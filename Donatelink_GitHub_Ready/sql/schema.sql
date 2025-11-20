-- Donatelink MySQL schema
CREATE DATABASE IF NOT EXISTS donatelink_db;
USE donatelink_db;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(20) DEFAULT 'user',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS donations (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  amount DECIMAL(10,2) NOT NULL,
  note VARCHAR(255),
  donated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);

-- sample user
INSERT INTO users (name, email, password, role) VALUES
('Test User','test@example.com','testpass','user');

INSERT INTO donations (user_id, amount, note) VALUES
(1, 500.00, 'First donation');
