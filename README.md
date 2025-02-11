# PassKeeper

PassKeeper is a console-based password management application. It allows users to add, search, and display passwords, and stores them in a PostgreSQL database.

## Features
- Add a new password (with optional auto-generation).
- Search for a password by account name.
- Display all saved passwords.
- Save passwords to a PostgreSQL database.

## Technologies
- **Programming Language**: Java
- **Database**: PostgreSQL
- **Libraries**: JDBC (for database connectivity)

## Requirements
- Java Development Kit (JDK) 8 or higher.
- PostgreSQL installed.
- A database with the `passwords` table (see **Database Setup**).

## Database Setup
1. Create a database in PostgreSQL:
   ```sql
   CREATE DATABASE passkeeper;
