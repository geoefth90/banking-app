# banking-app

The app consists of an in memory H2 database with 2 preloaded accounts with id (123456789 and 987654321).
- http://localhost:8080/h2-console
- jdbc:h2:mem:bankingApp
- username/password: sa/password

# docker execution
- mvn clean install
- docker build -t banking-app .
- docker run -p 8080:8080 banking-app

# POSTMAN sample request
http://localhost:8080/transfer
body :

{
"sourceAccount": 123456789,
"targetAccount": 987654321,
"amount": 10.1,
"currency": "EUR"
}
