## Backend for a note web/desktop app
Still in active development.

**Frontend:**
https://github.com/furkankizilbuga/better-notes

**Tech Stack:**
- Java 21
- Spring Boot 3.5
- Spring Data JPA
- Spring Security
- PostgreSQL
- H2 (development/test)
- Lombok
- spring-dotenv (for environment variables)

## Setup & Running

1. Clone the project:
```bash
git clone https://github.com/furkankizilbuga/better-notes-server.git
cd better-notes-server
```

2. Create a .env file in the root directory and add the following values:
```env
## PostgreSQL Database
DB_USERNAME=<your_postgres_username>
DB_PASSWORD=<your_postgres_password>
DB_HOST=<your_db_host>
DB_PORT=<your_db_port>
DB_NAME=<your_db_name>

## Frontend URL
CLIENT_URL=<your_frontend_url>
```

3. Install dependencies and run the backend:
```bash
mvn clean install
mvn spring-boot:run
```
