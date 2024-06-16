CREATE DATABASE regenmelody;
USE regenmelody;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);
SELECT * FROM users;
CREATE TABLE mixes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    sounds JSON,
    FOREIGN KEY (user_id) REFERENCES users(id)
);