# JerseyCrudApp

Postman Collection --> JerseyCRUD.postman_collection.json

## Endpoints :
    Base Url : - http://localhost:8080/jersey-crud-example

* GET   /api/users
* GET   /api/users/user/{id}
* POST  /api//users/
* DEL   /api/users/user/{id}
* PUT   /api/users/user/{id}


## Payload Example :
```
{
    "id": "12345",
    "name": "praveen",
    "joiningDate": "30/06/2021",
    "countryCode": "FR"
}
```

Server : Tomcat 8.5
