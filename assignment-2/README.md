# Assignment 2: Product Management REST API

## Setup

1. Start MySQL and update `spring.datasource.password` in `src/main/resources/application.properties`.
2. Run `mvn spring-boot:run` from this folder.
3. Import `Product-Management-API.postman_collection.json` into Postman and run the requests in order.

The API runs at `http://localhost:8080`.

| Operation | HTTP | URL |
| --- | --- | --- |
| Add product | POST | `/products` |
| Get all products | GET | `/products` |
| Get one product | GET | `/products/{id}` |
| Update product | PUT | `/products/{id}` |
| Delete product | DELETE | `/products/{id}` |

Example request body:

```json
{
  "name": "Wireless Mouse",
  "price": 799.00,
  "quantity": 15
}
```
