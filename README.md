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
    git clone https://github.com/your-username/BookStoreApp.git
    ```

2. Navigate to the project directory:
    ```sh
    cd NoteApp
    ```

3. Build the project using Maven:
    ```sh
    mvn clean install
    ```

## API Endpoints
1. POST http://locahost:8080/notes: Create a new note.

2. GET http://locahost:8080/notes: Retrieve all notes.

3. GET http://locahost:8080/notes/:id: Retrieve a specific note by ID. 

4. PUT http://locahost:8080/notes/:id: Update a specific note. 

5. DELETE http://locahost:8080/notes/:id: Delete a specific note.

### Swagger
URL: http://localhost:8080/swagger-ui/index.html