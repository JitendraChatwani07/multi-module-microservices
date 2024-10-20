# Multi-Module Microservice Project

## Overview

This project is a multi-module microservice architecture that includes User, Order, and Product services. Each service is developed using Spring Boot and communicates via REST APIs. The project is structured to support independent deployment and scaling of services.

## Services

1. **User Service**
   - **Port:** 8081
   - **Description:** Manages user information such as registration, retrieval, and updates.
   - **API Documentation:** [User Service API](./docs/user-api.md)

2. **Order Service**
   - **Port:** 8082
   - **Description:** Handles order processing, including order creation, retrieval, updating, and deletion.
   - **API Documentation:** [Order Service API](./docs/order-api.md)

3. **Product Service**
   - **Port:** 8083
   - **Description:** Manages product information, including product creation, retrieval, updating, and deletion.
   - **API Documentation:** [Product Service API](./docs/product-api.md)

## Repository Structure
root
├── docker-compose.yml 
├── user-service/ 
├── order-service/ 
├── product-service/



## Technologies Useda

- **Java 19**: Programming language.
- **Spring Boot**: Framework for building microservices.
- **MySQL**: Database for data persistence.
- **Docker**: Containerization for deployment.
- **Swagger**: API documentation.

## Setup and Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/JitendraChatwani07/multi-module-microservices.git
   cd multi-module-microservices
   docker compose up --build
   run all microservices as spring boot applications
   
