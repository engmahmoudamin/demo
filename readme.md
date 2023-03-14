# Getting Started

### Steps to run
&nbsp;&nbsp;1- Change datasource configuration in the application.yml to match your db
 ex:
    <pre>
      datasource:
        url: jdbc:oracle:thin:@localhost:1521:xe
        username: demo
        password: demo
        driver-class-name: oracle.jdbc.OracleDriver
    </pre>

&nbsp;&nbsp;2- Run the `resources/scripts/1-table-creation.sql` on your db to insert`USERS` table.

&nbsp;&nbsp;3- Run `mvn clean install` in the cmd to clean and build the project.

&nbsp;&nbsp;4- Run `java -jar target\demo-1.0.jar` in the cmd to run the project.

### Guides

&nbsp;&nbsp;You need a postman to test the following endpoints:

&nbsp;&nbsp;1- `GET - http://localhost:8088/saqaya/demo/v1/api/test` This to test that the project is working and doesn't need authentication

&nbsp;&nbsp;2- `POST - http://localhost:8088/saqaya/demo/v1/api/users` This to add a new user and doesn't need authentication and here a sample of the request
<pre>
{
  "firstName": "Michael",
  "lastName": "Knight",
  "email": "info@saqaya.com",
  "marketingConsent": false
}
</pre>

&nbsp;the response will as the following
<pre>
{
    "id": "d7740b8108397e93c5898a8c9b86faeeb55048a5",
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJpbmZvQHNhcWF5YS5jb20iLCJyb2xlcyI6W10sImlhdCI6MTY3ODc3MjY5NSwiZXhwIjoxNjc4Nzc2Mjk1fQ.cS2vdzBxoBoxRvrKuI_EyYHkLVNXbBxHsEqAx8mvCS8"
}
</pre>

&nbsp;&nbsp;3- `GET - http://localhost:8088/saqaya/demo/v1/api/users/{id}` This to retrieve the user added by the Post request, 
you will use the id and the bearer access token from the previous request.


