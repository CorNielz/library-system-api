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
      <a href="#api-endpoints">API Endpoints</a>
      <ul>
        <li><a href="#books">Books</a></li>
        <li><a href="#reservations">Reservations</a></li>
        <li><a href="#reviews">Reviews</a></li>
        <li><a href="#health-check">Health Check</a></li>     
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

Each of these features is exposed via REST endpoints and possible due to a relational database model.



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
