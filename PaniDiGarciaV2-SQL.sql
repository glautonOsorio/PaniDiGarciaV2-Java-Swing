CREATE SCHEMA pani_di_garcia_v2;

USE pani_di_garcia_v2;

CREATE TABLE address(
id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
zipcode VARCHAR(9),
city VARCHAR(255),
state VARCHAR(255),
street VARCHAR(255)
);

CREATE TABLE user(
id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
fullName VARCHAR(64),
gender ENUM("Male","Female","Other"),
email VARCHAR(255),
birthDay DATE,
cpf VARCHAR(14),
password VARCHAR(100),
address_id INT,
FOREIGN KEY(address_id) REFERENCES address(id)
);

CREATE TABLE product (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    price DECIMAL(10, 2),
    categories Enum("Breads","Cakes","Sweets","Savorys","Pies"),
	user_id INT,
    FOREIGN KEY(user_id) REFERENCES users(id)
);


DROP TABLE products;
DROP TABLE users;
DROP TABLE addresses;

INSERT INTO addresses (zipcode, city, state, street)
VALUES
    ('12345', 'Example City', 'Example State', '123 Example Street'),
    ('54321', 'Another City', 'Another State', '456 Another Street');


INSERT INTO users (fullName, gender, email, birthDay, cpf, password, address_id)
VALUES
    ('John Doe', 'Male', 'john.doe@example.com', '1990-05-15', '12345678901', 'password123', 1),
    ('Jane Smith', 'Female', 'jane.smith@example.com', '1992-08-25', '98765432109', 'password456', 2);

INSERT INTO products (id, name, description, price, categories, user_id)
VALUES
    (1, 'French Bread', 'Traditional French bread loaf', 3.99, 'Breads', 1),
    (2, 'Chocolate Cake', 'Delicious chocolate cake', 24.99, 'Cakes', 2);
