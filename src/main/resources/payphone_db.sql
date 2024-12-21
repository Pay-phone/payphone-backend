# payphone_db

CREATE DATABASE payphone_db DEFAULT CHARACTER SET utf8mb4;

USE payphone_db;

# User 기능  

CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- 암호화된 비밀번호
    role VARCHAR(20) NOT NULL DEFAULT 'user',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

# Accounts

CREATE TABLE accounts (
    account_id BIGINT AUTO_INCREMENT PRIMARY KEY,      
    account_number VARCHAR(20) NOT NULL UNIQUE, 
    user_id BIGINT NOT NULL,                  
    balance BIGINT DEFAULT 0,                   
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, 
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);