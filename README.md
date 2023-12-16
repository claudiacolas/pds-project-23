# Parallel and Distributed Systems Project at Hochschule Esslingen

## Overview

This repository contains the source code for a parallel and distributed systems project developed at Hochschule Esslingen. The project incorporates a Spring Boot backend, MongoDB for the database, and a React frontend. Docker is used for containerization.

## Prerequisites

Before running the application, ensure that you have the following prerequisites installed:

- [Java Development Kit (JDK)](link-to-jdk)
- [Spring Boot framework](https://spring.io/projects/spring-boot)
- [A database](database-link) (e.g., MongoDB)
- [Docker](https://www.docker.com/) for containerization

## Project Structure

The project is organized as follows:

- `todo`: Root directory
  - `src`: Source code
    - `main`: Main application code
      - `frontend`: Frontend source code (if applicable)
      - `java`: Backend source code
      - `resources`: Backend configuration files
    - `test`: Test code
  - `target`: Build artifacts

## Backend API

### API Endpoints

#### Get All TODO Items

- **URL:** `/api/v1/todos`
- **HTTP Method:** GET
- **Description:** Retrieve a list of all TODO items.

#### Get TODO Item by ID

- **URL:** `/api/v1/todos/{id}`
- **HTTP Method:** GET
- **Description:** Retrieve a specific TODO item by its ID.

#### Create TODO Item

- **URL:** `/api/v1/todos/{title}`
- **HTTP Method:** POST
- **Description:** Create a new TODO item with the given title.

#### Update TODO Item

- **URL:** `/api/v1/todos/{id}/{title}`
- **HTTP Method:** PUT
- **Description:** Update an existing TODO item with the specified ID by setting its title to the new value.

#### Delete TODO Item

- **URL:** `/api/v1/todos/{id}`
- **HTTP Method:** DELETE
- **Description:** Delete a TODO item with the specified ID.

### Data Model

The application uses a data model for TODO items with the following attributes:

- `id` (String): The unique identifier of the TODO item.
- `title` (String): The title or description of the TODO item.
- `description` (String): Additional details about the TODO item.
- `completed` (Boolean): Indicates whether the TODO item is completed.
- `created` (LocalDateTime): The date and time when the TODO item was created.

## Running the Application

To run the application, follow these steps:

1. Clone this repository to your local machine.
2. Build and run the project using a Java IDE or the command line.

### Configuration

You can configure the application by modifying the application properties or configuration files as needed.

## Usage

Explain how users can interact with the application, including API endpoints and any frontend functionality.

