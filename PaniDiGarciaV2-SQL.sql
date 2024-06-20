CREATE SCHEMA pani_di_garcia_v2;

USE pani_di_garcia_v2;

CREATE TABLE addresses(
id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
zipcode VARCHAR(8),
city VARCHAR(255),
state VARCHAR(255),
street VARCHAR(255)
);

CREATE TABLE users(
id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
fullName VARCHAR(64),
gender ENUM("Male","Female","Other"),
email VARCHAR(255),
birthDate DATE,
cpf VARCHAR(11),
password VARCHAR(100),
address_id INT,
FOREIGN KEY(address_id) REFERENCES addresses(id)
);

CREATE TABLE categories(
id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
c_name VARCHAR(50)
);

CREATE TABLE products (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price DECIMAL(10, 2),
    image VARCHAR(255),
    category_id INT,
	user_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY(user_id) REFERENCES users(id)
);
