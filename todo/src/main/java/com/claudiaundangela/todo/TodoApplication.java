package com.claudiaundangela.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import java.util.List;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TodoRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			String title = "First try";

			Todo todo = new Todo(title, "This is a test in the database.");

			repository.findTodoByTitle(title)
					.ifPresentOrElse(s -> {
						System.out.println(todo + " already exists.");
							}, () -> {
						System.out.println("Inserting todo item" + todo);
						repository.insert(todo);}
					);

			// usingMongoTemplateAndQuery(TodoRepository repository, MongoTemplate mongoTemplate, Todo todo, String title);
		};
	}

	private void usingMongoTemplateAndQuery (TodoRepository repository, MongoTemplate mongoTemplate, Todo todo, String title) {
		Query query = new Query();
		query.addCriteria(Criteria.where("title").is(title));

		List<Todo> todos = mongoTemplate.find(query, Todo.class);

		if (todos.size() > 1) {
			throw new IllegalStateException("Found many todos items with the same title: " + title);
		}

		if (todos.isEmpty()) {
			System.out.println("Inserting todo item" + todo);
			repository.insert(todo);
		} else {

		}
	}

}
