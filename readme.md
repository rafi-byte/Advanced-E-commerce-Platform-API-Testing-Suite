# Advanced E-commerce API Testing Framework

> A robust API testing framework built with RestAssured and TestNG for testing the Restful-booker API.

## Features

- 🔐 Token-based authentication testing
- 🔄 CRUD operations for bookings
- 📝 Detailed logging and reporting
- ⚡ Parallel test execution
- 🎯 Data-driven testing

## Tech Stack

- Java 11
- TestNG
- Rest Assured
- Maven
- Logback
- Jackson

## Project Structure

```
src/
├── main/
│   ├── java/com/ecommerce/api/
│   │   ├── config/
│   │   ├── constants/
│   │   ├── models/
│   │   └── utils/
│   └── resources/
└── test/
    ├── java/com/ecommerce/api/tests/
    │   ├── auth/
    │   ├── products/
    │   └── orders/
    └── resources/testdata/
```

## Getting Started

1. **Clone the repository**
```
git clone https://github.com/yourusername/Api_Testing_Project.git
cd Api_Testing_Project
```

2. **Install dependencies**
```
mvn clean install
```

3. **Update config.properties**
```
api.base.url=https://restful-booker.herokuapp.com
api.username=admin
api.password=password123
```

## Running Tests

```
# Run all tests
mvn clean test

# Run specific test class
mvn test -Dtest=AuthenticationTests
```

## Test Reports

- TestNG Reports: `target/surefire-reports`
- Logs: `logs/api-tests.log`

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


