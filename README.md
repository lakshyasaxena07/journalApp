# 📝 Journal App

A secure, RESTful journaling application built with Spring Boot and MongoDB. This application allows users to create, read, update, and delete personal journal entries with role-based authentication.

## 🚀 Features

- **Secure Authentication**: Role-based access control with Spring Security
- **Personal Journal Management**: Create, read, update, and delete journal entries
- **User Management**: User registration, profile updates, and account deletion
- **Admin Panel**: Administrative access to user management
- **MongoDB Integration**: Persistent data storage with MongoDB
- **RESTful API**: Clean REST endpoints for all operations
- **Transaction Support**: MongoDB transaction management for data consistency

## 🛠️ Technology Stack

- **Backend Framework**: Spring Boot 3.5.5
- **Security**: Spring Security with HTTP Basic Authentication
- **Database**: MongoDB with Spring Data MongoDB
- **Build Tool**: Maven
- **Java Version**: Java 21
- **Additional Libraries**:
  - Lombok for reducing boilerplate code
  - Spring Boot Starter Web for REST API
  - Spring Boot Starter Security for authentication

## 📋 Prerequisites

Before running this application, make sure you have:

- Java 21 or higher installed
- MongoDB instance running (local or cloud)
- Maven 3.6+ installed

## ⚙️ Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd journalApp
   ```

2. **Configure MongoDB**
   
   Update the `src/main/resources/application.yml` file with your MongoDB connection details:
   ```yaml
   spring:
     data:
       mongodb:
         uri: mongodb://localhost:27017  # Your MongoDB URI
         database: journaldb
   ```

3. **Build the application**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8081/journal`

## 📡 API Endpoints

### Public Endpoints (No Authentication Required)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/public` | Get all users (public view) |
| POST | `/public/create` | Create a new user account |

### User Endpoints (Authentication Required)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/journal` | Get all journal entries for authenticated user |
| POST | `/journal` | Create a new journal entry |
| GET | `/journal/id/{id}` | Get specific journal entry by ID |
| PUT | `/journal/id/{id}` | Update specific journal entry |
| DELETE | `/journal/id/{id}` | Delete specific journal entry |
| PUT | `/user` | Update user profile |
| DELETE | `/user` | Delete user account |

### Admin Endpoints (Admin Role Required)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/admin/all-users` | Get all users (admin view) |

## 🔐 Authentication

This application uses HTTP Basic Authentication. Include your credentials in the request headers:

```
Authorization: Basic <base64-encoded-username:password>
```

### User Roles
- **USER**: Default role for regular users
- **ADMIN**: Administrative role with additional privileges

## 📄 API Usage Examples

### Creating a User
```bash
curl -X POST http://localhost:8081/journal/public/create \
  -H "Content-Type: application/json" \
  -d '{
    "userName": "john_doe",
    "password": "securepassword123"
  }'
```

### Creating a Journal Entry
```bash
curl -X POST http://localhost:8081/journal/journal \
  -H "Content-Type: application/json" \
  -H "Authorization: Basic <credentials>" \
  -d '{
    "title": "My First Entry",
    "content": "This is my first journal entry!"
  }'
```

### Getting All Journal Entries
```bash
curl -X GET http://localhost:8081/journal/journal \
  -H "Authorization: Basic <credentials>"
```

## 🗄️ Database Schema

### User Collection
```json
{
  "_id": "ObjectId",
  "userName": "string (unique)",
  "password": "string (encrypted)",
  "journalEntries": ["JournalEntry references"],
  "roles": ["string array"]
}
```

### Journal Entry Collection
```json
{
  "_id": "ObjectId",
  "title": "string (required)",
  "content": "string",
  "date": "LocalDateTime"
}
```

## 🔧 Configuration

### Application Properties

The application can be configured through `application.yml`:

```yaml
spring:
  data:
    mongodb:
      uri: # Your MongoDB connection string
      database: journaldb
      auto-index-creation: true

server:
  port: 8081
  servlet:
    context-path: /journal

debug: true
```

### Security Configuration

- Public endpoints: `/public/**`
- Authenticated endpoints: `/journal/**`, `/user/**`
- Admin endpoints: `/admin/**` (requires ADMIN role)
- CSRF protection is disabled for API usage
- HTTP Basic Authentication is enabled

## 🧪 Testing

Run the tests using Maven:

```bash
mvn test
```

## 📁 Project Structure

```
src/
├── main/
│   ├── java/net/edigest/journalApp/
│   │   ├── config/           # Security and encoder configuration
│   │   ├── controller/       # REST controllers
│   │   ├── entity/          # MongoDB entities
│   │   ├── repository/      # Data access layer
│   │   ├── service/         # Business logic layer
│   │   └── JournalApplication.java
│   └── resources/
│       └── application.yml   # Application configuration
└── test/                    # Test files
```

## 🚦 Error Handling

The application includes proper HTTP status codes:

- `200 OK`: Successful GET/PUT operations
- `201 CREATED`: Successful POST operations
- `204 NO_CONTENT`: Successful DELETE operations
- `400 BAD_REQUEST`: Invalid request data
- `401 UNAUTHORIZED`: Authentication required
- `403 FORBIDDEN`: Insufficient permissions
- `404 NOT_FOUND`: Resource not found

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

**Lakshya Saxena**

## 🆘 Support

If you encounter any issues or have questions, please open an issue in the GitHub repository.

## 🔮 Future Enhancements

- [ ] JWT authentication implementation
- [ ] Email notifications
- [ ] Journal entry categories/tags
- [ ] File attachment support
- [ ] Advanced search functionality
- [ ] Data export features
- [ ] Mobile app integration
- [ ] Real-time collaboration features

---

⭐ **If you found this project helpful, please give it a star!** ⭐
