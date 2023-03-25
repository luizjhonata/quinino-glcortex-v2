# API REST(CRUD) For a Q.UININO TELEFONIA
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/luizjhonata/quinino-glcortex/blob/main/LICENCE)

## About the project

The main goal of this project is calculate cost of calls using a plan of Q.UININO TELEFONIA and without a plan. 
To do that, the system has 3 entities, call, plan and tariffs. The entity call is the only that not persist data in the database, because the goal is give to their clientes only a easy way to make the calc, however Q.UININO TELEFONIA is abble to insert, update and delete plans and tariffs.

## CALL attributes:

- Origin; (DDD of Origin Call)
- Destiny; (DDD of Destiny Call)
- Time; (Time of call duration)
- Plan; (Which plan do you have)
- Cost with plan; (Variable to calc cost with plan)
- Cost without plan (Variable to calc cost without plan)

## PLAN attributes;

- Id; (Identification in database)
- Name; (Name of plan)
- Free Minutes; (Amount of free minutes by plan)
- Additional Tariff; (Price of additional minutes)

## TARIFF attributes;

- Id;
- Origin; (DDD of Origin Call)
- Destiny; (DDD of Destiny Call)
- pricePerMinute; (Cost of call)

## Methods availables with the API

- GET calculateCallCost; (Make the cost calc of calls with and without a plan)
- POST - insertPlan; (Insert new plans)
- POST - insertTariff; (Insert new tariffs)
- PUT - updataPlan; (Update any data about a plan)
- PUT - updateTariff; (Update any data about a tariff)
- DETELE - deletePlanById; (Delete a plan by his ID)
- DELETE - deleteTariffById; (Delete a tariff by his ID)

## SWAGGER DOCUMENTATION

Swagger is available in this backend, to make easy understand and test all methods.

## ENVIROMENTS

The API has 3 enviroments, test with H2 database in memory, dev to local tests with PostgreSQL and prod to used in production;

## TESTS

The API has tests for all of the 3 services, testing all of the methods available;

## In this project i use:

- Java 17;
- Spring Boot 3;
- Spring Boot Starter Validation;
- Spring Data Jpa;
- H2;
- POSTGRESQL;
- Relational Object Mapping;
- SWAGGER;
- JUNIT5;
- MOCKITO;

## Layers Patterns

The API has a DTO layer to avoid that our insed estructure be expose to user interface;
![Web](https://github.com/luizjhonata/assetsreadme/blob/main/foodDeliveryBackEnd/layerPatterns.png)

## How to run the project

Prerequisites: Java 17

```bash
# clone repository
git clone https://github.com/luizjhonata/quinino-glcortex.git

# enter in the quinino-glcortex project folder
cd quinino-glcortex

# run the project
./mvnw spring-boot:run
```

# Autor

Jhonata de Souza Luiz

https://www.linkedin.com/in/jhonataluiz/
