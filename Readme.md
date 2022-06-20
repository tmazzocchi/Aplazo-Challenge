#Calculating the Interest
To calculate the interests of a credit i asume that have to sum the result of aplying the porcentage of the rate to the amount.

    TOTAL_WITH_INTEREST = AMOUNT  + (AMOUNT * RATE / 100)

#LocalDate in Response
I decide to set a LocalDate instead a Date type in the Response because with LocalDate i have a best result due not having the time.

#H2 DataBase
The configurations for the DB connection are in the application.properties
    
    URL = http://localhost:8080/h2-console

#Postman Collection
There is a test endpoint in `simple interest microservice.postman_collection.json`