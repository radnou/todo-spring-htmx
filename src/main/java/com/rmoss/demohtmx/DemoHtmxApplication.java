package com.rmoss.demohtmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    String delete(@PathVariable Integer todoId) {

        this.todos
                .stream()
                .filter(t -> t.id().equals(todoId))
                .forEach(this.todos::remove);

        return "";
    }

    @PostMapping()
    @ResponseStatus()
    String create (@RequestParam BodyP){

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
