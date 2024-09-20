
# Subscription Service API

## Overview

The Subscription Service API provides endpoints for managing user subscriptions. It allows users to purchase subscriptions and retrieve their latest subscription details.

## Technologies Used

- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework for building RESTful APIs.
- **Maven**: Dependency management and build automation tool.
- **MySQL**: Relational database for storing subscription data.

## API Endpoints

### 1. Buy Subscription

- **Endpoint**: `POST /api/subscriptions/buy`
- **Description**: Allows users to purchase a subscription.
- **Request Parameters**:
  - `userId` (Long): The ID of the user purchasing the subscription.
  - `type` (Subscription.SubscriptionType): The type of subscription to purchase.
- **Response**: Returns the purchased `Subscription` object.

#### Example Request

```http
POST http://localhost:8080/api/subscriptions/buy?userId=123&type=MONTHLY
```

#### Example Response

```json
{
    "id": 1,
    "userId": 123,
    "type": "MONTHLY",
    "startDate": "2024-09-20",
    "endDate": "2025-09-20"
}
```

### 2. Get Latest Subscription

- **Endpoint**: `GET /api/subscriptions/latest`
- **Description**: Retrieves the latest subscription for a specified user.
- **Request Parameters**:
  - `userId` (Long): The ID of the user whose latest subscription is to be fetched.
- **Response**: Returns the latest `Subscription` object.

#### Example Request

```http
GET http://localhost:8080/api/subscriptions/latest?userId=123
```

#### Example Response

```json
{
    "id": 1,
    "userId": 123,
    "type": "MONTHLY",
    "startDate": "2024-09-20",
    "endDate": "2025-09-20"
}
