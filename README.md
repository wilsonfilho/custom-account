# Financial API

API created for Pismo Challeng Interview
- Java 21
- Swagger
- H2

# Running the API:

Clone the project::
```sh
$ git clone <project>
```

Run Maven clean and install in the project folder:
```sh
$ mvn clean install
```


After the building, run the command below::
```sh
$ docker compose up --build
```

### Useful Links

| Tool | Link |
| ------ | ------ |
| Swagger | http://localhost:8080/swagger-ui.html|
| H2 DataBase | http://localhost:8080/h2-console/ |

### DataBase Credentials

```sh
username: sa
password: password
```

### API Documentation

Available endpoints:
|HTTP |	Endpoint|
| ------ | ------ |
|POST	| http://127.0.0.1:8080/accounts/save|
|GET	|http://127.0.0.1:8080/accounts/{accountId}|
|POST|	http://127.0.0.1:8080/transactions/save|
