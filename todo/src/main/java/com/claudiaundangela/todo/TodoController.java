package com.claudiaundangela.todo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@AllArgsConstructor
public class TodoController {
    @Autowired
    private final TodoRepository todoRepository;

    // Get all todos
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todoList = todoRepository.findAll();
        if (!todoList.isEmpty()) {
            return ResponseEntity.ok(todoList);
        }
        return ResponseEntity.notFound().build();
    }

    // Get a todo by ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable String id){
        Todo todoItem = todoRepository.findById(id).orElse(null);
        if (todoItem != null) {
            return ResponseEntity.ok(todoItem);
        }
        return ResponseEntity.notFound().build();
    }

    // Create a new todo
    @PostMapping
    public ResponseEntity<Todo> CreateTodo(@PathVariable String title){
        var item = new Todo();
        item.title = title;
        todoRepository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    // Update a todo by ID
    @PutMapping("/{id}")
    ResponseEntity<Todo> UpdateTodo(@PathVariable String id, @PathVariable String title){
        Todo existingItem = todoRepository.findById(id).orElse(null);
        if (existingItem != null) {
            existingItem.title = title;
            todoRepository.save(existingItem);
            return ResponseEntity.status(HttpStatus.OK).body(existingItem);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a todo by ID
    @DeleteMapping("/{id}")
    ResponseEntity<Todo> DeleteTodo(@PathVariable String id){
        Todo item = todoRepository.findById(id).orElse(null);
        if (item != null) {
            todoRepository.delete(item);
            return ResponseEntity.status(HttpStatus.OK).body(item);
        }
        return ResponseEntity.notFound().build();
    }

}
