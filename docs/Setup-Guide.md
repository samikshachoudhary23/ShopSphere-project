# ShopSphere – Setup Guide

## Requirements
- JDK compatible with the project
- Apache Maven
- Apache Tomcat 11
- MySQL Server 8
- MySQL Connector/J

## Database Setup
1. Start the MySQL server.
2. Create the database named shopsphere if it does not exist.
3. Review docs/database.sql before importing it into a database.
4. Configure the database URL, username and password in com.shopsphere.dao.DBConnection.
5. Ensure the MySQL user has permission to access the database.

## Build
Open PowerShell in the project root and run:

mvn clean package

## Deploy
Copy target/webapp.war into the Tomcat webapps directory.
Start or restart Tomcat.

## Open Application
http://localhost:8080/webapp/

## Important Notes
- Do not share database passwords in reports or public repositories.
- Review database.sql before importing because it contains DROP TABLE statements.
- MOCK_ONLINE is a simulated payment option, not a real payment gateway.
- Verify the database connection settings on the target computer before running the application.
