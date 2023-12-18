# Parallel and Distributed Systems Project at Hochschule Esslingen

## Overview

This repository contains the source code for a parallel and distributed systems project developed at Hochschule Esslingen. 
The project is a Todo Application which allows you to manage your daily tasks. 
It incorporates a Spring Boot backend, MongoDB for the database, a React frontend and Docker is used for containerization. It also incorporates OpenTelemetry and Jaeger for observability.

## Prerequisites

Before running the application, ensure that you have the following prerequisites installed:

- [Java Development Kit (JDK)](link-to-jdk)
- [Spring Boot framework](https://spring.io/projects/spring-boot)
- [Docker](https://www.docker.com/) for containerization

## Project Structure

The project is organized as follows:

- `pds-project-23`: Root directory
  - `todo`: Backend source code
      - `database`: Database dockerfile
      - `src`: Source code
        -`main`: Main application code
        -`test`: Test code
      - `target`: Build artifacts
  - `frontend`: Frontend source code

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

## Application Configuration
- Backend running on port: `8080`
- Frontend running on port: `3000`
- MongoDB database running on port: `8081`
- JaegerUI running on port: `16686`

## Usage

To run the application, follow these steps:

1. Clone this repository to your local machine.
2. Build and run the project using a Java IDE or the command line.
3. Navigate to the root directory of the cloned repository where the `docker-compose.yaml` file is located.
4. Open a terminal or command prompt.
5. Run the following command to start the services:
       `docker-compose up -d`
