package com.claudiaundangela.todo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        todo.setCompleted(false); // Default value for completed
        todo.setCreated(LocalDateTime.now()); // Set creation time
        todoRepository.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }


    // Update a todo by ID
    @PutMapping("/{id}")
    ResponseEntity<Todo> updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {
        Todo existingItem = todoRepository.findById(id).orElse(null);
        if (existingItem != null) {
            existingItem.setTitle(updatedTodo.getTitle());
            existingItem.setDescription(updatedTodo.getDescription());
            existingItem.setCompleted(updatedTodo.getCompleted());
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
