package com.claudiaundangela.todo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Todo {

    @Id
    public String id;
    @Indexed(unique = true) //Cannot repeat the title
    public String title;
    public String description;
    public Boolean completed;
    public LocalDateTime created;

    public Todo() {

    }

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
        this.created = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
