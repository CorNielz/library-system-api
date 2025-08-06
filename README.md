<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#features">Features</a></li>
        <li><a href="#tech-stack">Tech Stack</a></li>
        <li><a href="#architecture-overview">Architecture Overview</a></li>
        <li><a href="#design-decisions">Design Decisions</a></li>
        <li><a href="#database-schema">Database Schema</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#running-the-application">Running the Application</a></li>
      </ul>
    </li>
    <li>
      <a href="#postman-collection">Postman Collection</a>
    </li>
    <li>
        <a href="#roadmap">Roadmap</a>
    </li>
  </ol>
</details>

<--- PROJECT ON HOLD | PERSONAL ISSUES --->

## About The Project

Born from a coding challenge, this project is a back-end RESTFUL API for a CRUD library system. 



## Features

Users should be allowed to, but not limited to:

### Books
* Search and list books by title and/or author;
* Register books;
* Update book information;
* Soft delete books;

### Reservations
* Check and list reservations;
* Reserve available copies by a price; 
* Update data of a reservation;
* Delete reservations;

### Reviews
* Check and list reviews for a book
* Submit reviews for a book;
* Edit review content;
* Delete a review;

### Users
* Register new users;
* Check and list users;
* Update information on a user;
* Soft delete users;

Each of these features is exposed via REST endpoints and enabled by a relational database model.



## Tech Stack
This project uses the following technologies:

* Maven (Builds and dependencies)
* Java 21 (Core language)
* Spring Boot 3 (API building)
* Spring Data JPA (Abstraction for database actions)
* PostgreSQL (Relational Database)
* IntelliJ (Java IDE)
* Postman (API testing and demo)
* DBDiagram.io (ER diagram)



## Architecture Overview
This project follows a Modular Monolith architecture, with focus and separation of business logic (Domain-Driven Design). The project is organized into four layers, API, Application, Domain, and Infrastructure (Layered Architecture).



## Design Decisions

### Modular Monolith
The Modular Monolith was chosen due to it encapsulation of related functionalities, helping organize the code and project structure, also, it's easy to refactor a monolith and later, if escalation is needed, to separate into microservices. Using microservices this early on the project would add additional complexity as well.

### Domain-Driven Design and Layered Architecture
DDD and Layered Architecture were chosen to better divide the project by both feature and layer concern, opening the project for expansion and keeping it tidy.

### DTOs
DTOs were added to the API endpoint requests in order to keep hidden unnecessary fields of domain and infrastructure logic from the final user/consumer.
Some tables received the DELETED status, so to soft delete values, allowing auditability and restoration in case of severe problems.

### Mapping
To reduce boilerplate, auto mapping was introduced via MapStruct.


### PostgreSQL Database
PostgreSQL was chosen due to being a relational database, with great AWS integration and ENUM capacities.  



## Database Schema
[Current ER Diagram](https://github.com/CorNielz/library-system-api/).



# Getting Started

## Prerequisites

* Java 21
* Maven
* PostgreSQL
* IDE
* Git



## Installation

### 1. Clone the Repo

Run in your IDE/Git Bash (Preferable IntelliJ)
`git clone https://github.com/CorNielz/library-system-api.git`

### 2. Configure the DB

Run in your terminal: 
`psql -U postgres -f Library System ER.sql`

### 3. Build with Maven

Run in your IDE/Terminal (Preferable IntelliJ)
`mvn clean install`



## Running the Application

### 1. Run Application

* Maven
Run in your IDE/Git Bash (Preferable IntelliJ)
`mvn spring-boot:run`

### 2. Usage

In this project, currently, no GUIs are available. Once the application is up and running, it will start a local server.

`http://localhost:8080`

All available endpoints can be accessed via the Postman Collection, which contains test/demo cases for you.

# Postman Collection
[LibraryCollection](https://www.postman.com/dashcornielz/workspace/library-system/collection/29982401-a6679a31-5665-47ac-be94-1ca670e3a767?action=share&source=copy-link&creator=29982401)

# Roadmap
Priorities and next courses of action in the development. Warning: This section is **subject to change**, some content here is optional, to make the application cleaner, while others are either essential or required by the challenge.
1. Endpoint errors and implementations [Critical Priority]
1. Exception Handling [Critical Priority];
2. Logging  [High Priority];
3. Health Check [High Priority];
4. Cross models and entity validations [Medium Priority]
5. Authentication and Authorization with JWT and roles [Low Priority/Extra];
6. Book tagging for better searching and organizing [Low Priority/Extra];
