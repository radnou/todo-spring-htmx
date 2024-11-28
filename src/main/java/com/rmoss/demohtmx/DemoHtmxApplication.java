package com.rmoss.demohtmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
class TodoController{

    private final Set<Todo> todos = new ConcurrentSkipListSet<Todo>(Comparator.comparingInt(Todo::id));

    TodoController(){
        for (var t : "read a book, finish project spring, do chores, go to the gym".split(",")){
            todos.add(Todos.todo(t));
        }
    }

    @GetMapping()
    String todos (Model model){
        model.addAttribute("todos",this.todos);
        return "todos";
    }

    @DeleteMapping(produces= MediaType.TEXT_HTML_VALUE, path="/{todoId}")
    @ResponseBody()
    String delete (@PathVariable Integer todoId){

        this.todos
                .stream()
                .filter(t->t.id().equals(todoId))
                .forEach(this.todos::remove);

        return "";
    }




}


record Todo(Integer id, String title) {
}

class Todos {
    private static final AtomicInteger id = new AtomicInteger(0);

    static Todo todo(String title) {
        return new Todo(id.incrementAndGet(), title);
    }
}
