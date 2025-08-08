# StackSplit - Delivery Service 🚚

This is the **Delivery microservice** of the shopping cart web application.

It handles order **delivery assignment**, **tracking**, and **status updates**. Built with **Spring Boot** and **PostgreSQL**, this service operates independently and communicates with the `orders-service` to manage delivery lifecycle events.

> 🧩 Part of the modern 3-tier microservices architecture:
> - `auth-service` – user authentication and authorization  
> - `orders-service` – handles shopping cart and orders  
> - `delivery-service` – manages deliveries *(this repo)*  
> - `frontend` – React JS client

---

## 🔧 Prerequisites

Make sure these are installed before running this service:

- [Java JDK 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/)
- [Git](https://git-scm.com/)

---

## ⚙️ Tech Stack

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven

---

## 📁 Folder Structure (Example)

```
delivery-service/
├── controller/ # REST endpoints (delivery APIs)
├── service/ # Business logic
├── repository/ # JPA Repositories
├── model/ # Entities: Delivery, Address
├── dto/ # Request/Response DTOs
├── config/ # App config, CORS
├── util/ # Utility functions or constants
├── DeliveryApplication.java
└── application.properties
```

---

## 🗃️ Database Configuration

Create a PostgreSQL database (e.g., `delivery_db`) and update `application.properties` accordingly:

```properties
server.port=8083

spring.datasource.url=jdbc:postgresql://localhost:5432/delivery_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
```

---

## 🚀 How to Run

```git clone https://github.com/himanshujha411/Microservices-Delivery-Mgmt.git
cd Microservices-Delivery-Mgmt

./mvnw spring-boot:run
```
