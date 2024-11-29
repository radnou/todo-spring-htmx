package com.rmoss.demohtmx;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class DemoHtmxApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHtmxApplication.class, args);
    }

}

@Controller
@RequestMapping("/todos")
class TodoController {

    private final Set<Todo> todos = new ConcurrentSkipListSet<Todo>(Comparator.comparingInt(Todo::id));

    TodoController() {

        todos.add(Todos.todo("read a book", false, "Personal"));
        todos.add(Todos.todo("finish project spring", false, "Work"));
        todos.add(Todos.todo("do chores", true, "Home"));
        todos.add(Todos.todo("go to the gym", false, "Health"));

    }

    @GetMapping()
    String todos(Model model) {
        model.addAttribute("todos", this.todos);
        return "todos";
    }

    @DeleteMapping(produces = MediaType.TEXT_HTML_VALUE, path = "/{todoId}")
    @ResponseBody()
    String delete(@PathVariable Integer todoId,Model model) {

        this.todos
                .stream()
                .filter(t -> t.id().equals(todoId))
                .forEach(this.todos::remove);
        model.addAttribute("todos", this.todos);

        return "";
    }

    @PostMapping
    HtmxResponse create (@RequestParam("new-todo") String todo, Model model){
        todos.add(Todos.todo(todo));
        model.addAttribute("todos", this.todos);
        return HtmxResponse.builder()
                .view("todos :: todos")
                .view("todos :: todos-form")
                .build();
    }

    //patch method to update the status of a specify todo set in path
    @PatchMapping(path = "/{todoId}")
    @ResponseBody
    String update(@PathVariable Integer todoId, @RequestParam(value = "todo-status", defaultValue = "false") Boolean completed, Model model) {
        this.todos.stream()
                .filter(t -> t.id().equals(todoId))
                .findFirst()
                .ifPresent(todo -> {
                    this.todos.remove(todo);
                    this.todos.add(new Todo(todo.id(), todo.title(), completed, todo.category()));
                });
        model.addAttribute("todos", this.todos);
        return "";
    }
}

record Todo(Integer id, String title, Boolean completed, String category) {
}

class Todos {
    private static final AtomicInteger id = new AtomicInteger(0);

    static Todo todo(String title) {
        return new Todo(id.incrementAndGet(), title, false, "");
    }

    static Todo todo(String title, Boolean status, String category) {
        return new Todo(id.incrementAndGet(), title, status, category);
    }
}
