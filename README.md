# Golf Club API

This project is a RESTful API for managing golf club members and tournaments, built with Spring Boot, Gradle, and MySQL. The application is containerized using Docker for ease of deployment.

---

## Features

- Manage golf club members (CRUD operations).
- Manage tournaments (CRUD operations).
- MySQL as the database.
- Containerized application with Docker.
- Gradle as the build tool.

---

## Prerequisites

Ensure the following are installed on your system:

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [JDK 22](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html)

---

## Getting Started

### **1. Clone the Repository**

git clone https://github.com/dev-pavel/golf-club-api.git \
cd golf-club-api


### **2. Build and Start the Application**

#### **Using Docker Compose**
1. Build and start the containers: \
   docker-compose up --build
2. Access the application at: \`http://localhost:8080\`

---

## API Endpoints

### **Member Endpoints**
| Method | Endpoint              | Description               |
|--------|-----------------------|---------------------------|
| GET    | \`/api/members\`      | Get all members           |
| GET    | \`/api/members/{id}\` | Get a member by ID        |
| POST   | \`/api/members\`      | Create a new member       |
| PUT    | \`/api/members/{id}\` | Update an existing member |
| DELETE | \`/api/members/{id}\` | Delete a member           |

### **Tournament Endpoints**
| Method | Endpoint                                  | Description                             |
|--------|-------------------------------------------|-----------------------------------------|
| GET    | \`/api/tournaments\`                      | Get all tournaments                     |
| GET    | \`/api/tournaments/{id}\`                 | Get a tournament by ID                  |
| POST   | \`/api/tournaments\`                      | Create a new tournament                 |
| PUT    | \`/api/tournaments/{id}\`                 | Update an existing tournament           |
| DELETE | \`/api/tournaments/{id}\`                 | Delete a tournament                     |
| POST   | \`/{tournamentId}/add-member/{memberId}\` | Add member to tournament                |
| GET    | \`/{tournamentId}/members\`               | Get all members for specific tournament |
|        |                                           |                                         |

---

## Environment Variables

| Variable                          | Description                                   |
|-----------------------------------|-----------------------------------------------|
| \`SPRING_DATASOURCE_URL\`         | Database connection URL                       |
| \`SPRING_DATASOURCE_USERNAME\`    | Database username                             |
| \`SPRING_DATASOURCE_PASSWORD\`    | Database password                             |
| \`SPRING_JPA_HIBERNATE_DDL_AUTO\` | Hibernate DDL-auto setting (e.g., \`update\`) |

---

## Database Configuration

The database is set up using MySQL. The following credentials are pre-configured in the \`docker-compose.yml\` file:

- **Database Name**: \`golfclubdb\`
- **User**: \`golfuser\`
- **Password**: \`golfpassword\`
- **Root Password**: \`rootpassword\`
