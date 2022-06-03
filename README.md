# Backend Engineer Assignment
In this assignment, you are expected to make changes to an existing API backend code. Please read the constraints and tasks carefully, make your changes, and follow submission guideline at the bottom of the page.

## Scenario:
BayzDelivery is a delivery startup which allows its users to register as delivery men or customers.

Customer gives an order from the online shop and delivery man picks the order and drives it to the customer.

At the end of delivery, delivery man sends a request to the server with his/her id, customer id, order id, the distance in km and the start and end time of delivery.

## Application Constraints:
- Users are using BayzDelivery mobile app, assume that the API is only consumed by mobile app
- Data should only be accepted from the registered customers and delivery men.
- User can not be both customer and delivery man at the same time. Only one must be chosen at registration
- The delivery man earns commission for each order. `TotalCommission = OrderPrice * 0.05 + Distance * 0.5`
- The delivery man is not allowed to deliver multiple orders at the same time

## Tasks:
1. Codebase contains functional or logical bugs. Find these issues, fix them and write unit tests.
2. Mobile team asked you for a new API endpoint to display top 3 delivery men whose delivery has the maximum order price in a given time interval and they want to show average commission they earned.
3. Customer support team wants to be notified when a delivery is not done in 45 minutes. Create the scheduled task to check and notify CS team asynchronously
4. Increase unit test coverage to be 60%. Please do not try to increase more.

## Evaluation Criterias:
- Code quality and Applying Best Practices
- Feature implementation
- Bug fixes
- Unit Tests
- Git commit structure

## Development Environment:
- GIT for version control
- Gradle
- Java 8
- MySQL 5.6+ (If required, change the DB connection url, user and password information by updating application.properties)
- Liquibase

# Submission

Please open a Pull/Merge request to this repository with everything you have prepared.

- Make sure that project is building correctly.
- Make sure that all tests are passing.
- Prepare necessary instructions to run your application in `DOC.md` file.
- You have 7 days to complete this task.
