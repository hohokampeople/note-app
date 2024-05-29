# Note APP

## Overview
Note APP is RESTful API that allows users to create, retrieve, update, and delete notes.
## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Swagger](#swagger)


## Prerequisites
Before you begin, ensure you have met the following requirements:
- Java 11 or higher
- Maven 3.6.0 or higher
- An IDE (IntelliJ IDEA, Eclipse, etc.) 

## Installation
To install the project, follow these steps:

1. Clone the repository:
    ```sh
    git clone https://github.com/hohokampeople/note-app.git
    ```

2. Navigate to the project directory:
    ```sh
    cd NoteApp
    ```

3. Build the project using Maven:
    ```sh
    mvn clean install
    ```

## Run
To run the project, follow these steps:

1. Once the build is successful, you can run the Spring Boot application using the following Maven command:
    ```sh
    mvn spring-boot:run
    ```

2. Once the application is running, you can access it through a web browser or make requests to its endpoints using tools like cURL or Postman. By default, the application will run on localhost at port 8080.
    ```sh
    localhost at port 8080
    ```

## API Endpoints
1. POST http://locahost:8080/notes: Create a new note.

2. GET http://locahost:8080/notes: Retrieve all notes.

3. GET http://locahost:8080/notes/:id: Retrieve a specific note by ID. 

4. PUT http://locahost:8080/notes/:id: Update a specific note. 

5. DELETE http://locahost:8080/notes/:id: Delete a specific note.

### Swagger
URL: http://localhost:8080/swagger-ui/index.html