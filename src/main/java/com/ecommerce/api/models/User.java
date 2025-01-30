package com.ecommerce.api.models;

public class User {
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String token;
    private String phone;
    private String userStatus;
    private boolean isActive;
    private String createdAt;
    private String updatedAt;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getUserStatus() { return userStatus; }
    public void setUserStatus(String userStatus) { this.userStatus = userStatus; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    // Builder pattern for User creation
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private User user = new User();

        public UserBuilder id(int id) {
            user.setId(id);
            return this;
        }

        public UserBuilder username(String username) {
            user.setUsername(username);
            return this;
        }

        public UserBuilder firstname(String firstname) {
            user.setFirstname(firstname);
            return this;
        }

        public UserBuilder lastname(String lastname) {
            user.setLastname(lastname);
            return this;
        }

        public UserBuilder email(String email) {
            user.setEmail(email);
            return this;
        }

        public UserBuilder password(String password) {
            user.setPassword(password);
            return this;
        }

        public UserBuilder token(String token) {
            user.setToken(token);
            return this;
        }

        public UserBuilder phone(String phone) {
            user.setPhone(phone);
            return this;
        }

        public UserBuilder userStatus(String userStatus) {
            user.setUserStatus(userStatus);
            return this;
        }

        public UserBuilder isActive(boolean isActive) {
            user.setActive(isActive);
            return this;
        }

        public UserBuilder createdAt(String createdAt) {
            user.setCreatedAt(createdAt);
            return this;
        }

        public UserBuilder updatedAt(String updatedAt) {
            user.setUpdatedAt(updatedAt);
            return this;
        }

        public User build() {
            return user;
        }
    }
}
