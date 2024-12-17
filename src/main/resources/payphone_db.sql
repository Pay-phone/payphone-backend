# payphone_db

DROP DATABASE IF EXISTS payphone_db;
CREATE DATABASE payphone_db DEFAULT CHARACTER SET utf8mb4;

USE payphone_db;

# User 기능  

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- 암호화된 비밀번호
    role VARCHAR(20) NOT NULL DEFAULT 'user',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);