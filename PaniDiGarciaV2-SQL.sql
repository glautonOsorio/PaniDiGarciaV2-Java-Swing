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
    id INT PRIMARY KEY UNIQUE AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    price DECIMAL(10, 2),
    categories Enum("Breads","Cakes","Sweets","Savorys","Pies"),
	user_id INT,
    FOREIGN KEY(user_id) REFERENCES user(id)
);


DROP TABLE products;
DROP TABLE users;
DROP TABLE addresses;

INSERT INTO address (zipcode, city, state, street)
VALUES
    ('12345-125', 'Example City', 'Example State', '123 Example Street'),
    ('54321-854', 'Another City', 'Another State', '456 Another Street');


INSERT INTO user (fullName, gender, email, birthDay, cpf, password, address_id)
VALUES
    ('John Doe', 'Male', 'john.doe@example.com', '1990-05-15', '123.456.789-01', 'password123', 1),
    ('Jane Smith', 'Female', 'jane.smith@example.com', '1992-08-25', '987.654.321-09', 'password456', 2),    
    ('Emily Johnson', 'Female', 'emily.johnson@example.com', '1995-02-10', '456.789.123-02', 'password789', 1),
    ('Michael Brown', 'Male', 'michael.brown@example.com', '1988-11-20', '654.321.987-05', 'passwordabc', 2),
    ('Sophia Davis', 'Female', 'sophia.davis@example.com', '1998-07-03', '789.456.321-08', 'passwordxyz', 1);
    

INSERT INTO product (name, description, price, categories, user_id)
VALUES
    ('French Bread', 'Traditional French bread loaf', 3.99, 'Breads', 1),
    ( 'Chocolate Cake', 'Delicious chocolate cake', 24.99, 'Cakes', 2),
    ( 'Baguette', 'Classic French baguette', 2.49, 'Breads', 1),
    ( 'Red Velvet Cake', 'Red velvet cake with cream cheese frosting', 29.99, 'Cakes', 2),
    ( 'Chocolate Chip Cookies', 'Freshly baked chocolate chip cookies', 9.99, 'Sweets', 3),
    ( 'Spinach Quiche', 'Savory quiche with spinach and cheese', 14.99, 'Savorys', 4),
    ( 'Apple Pie', 'Homemade apple pie with a flaky crust', 19.99, 'Pies', 5),
    ( 'Whole Wheat Bread', 'Nutritious whole wheat bread', 4.49, 'Breads', 1),
    ( 'Cheesecake', 'Creamy cheesecake with strawberry topping', 39.99, 'Cakes', 2),
    ( 'Brownies', 'Rich chocolate brownies with walnuts', 12.99, 'Sweets', 3),
    ( 'Chicken Pot Pie', 'Hearty chicken pot pie with vegetables', 17.99, 'Savorys', 4),
    ( 'Blueberry Pie', 'Sweet and tangy blueberry pie', 21.99, 'Pies', 5),
    ( 'Sourdough Bread', 'Artisan sourdough bread with a crispy crust', 5.99, 'Breads', 2),
    ( 'Carrot Cake', 'Moist carrot cake with cream cheese frosting', 34.99, 'Cakes', 4),
    ( 'Macarons', 'Colorful French macarons in assorted flavors', 19.99, 'Sweets', 1),
    ( 'Quiche Lorraine', 'Classic quiche with bacon and Swiss cheese', 16.99, 'Savorys', 3),
    ('Cherry Pie', 'Fresh cherry pie with a buttery lattice crust', 23.99, 'Pies', 2),
    ( 'Ciabatta Bread', 'Italian ciabatta bread with olive oil and herbs', 6.49, 'Breads', 4),
    ( 'Tiramisu', 'Traditional Italian dessert with coffee and mascarpone', 29.99, 'Cakes', 5),
    ( 'Garlic Breadsticks', 'Crispy garlic breadsticks with Parmesan cheese', 8.99, 'Breads', 3),
    ( 'Mousse Cake', 'Silky chocolate mousse cake with a chocolate ganache', 49.99, 'Cakes', 4),
    ('Peanut Butter Cookies', 'Classic peanut butter cookies with a soft center', 7.99, 'Sweets', 5),
    ( 'Beef Empanadas', 'Savory beef empanadas with onions and peppers', 13.99, 'Savorys', 1),
    ('Key Lime Pie', 'Refreshing key lime pie with a graham cracker crust', 27.99, 'Pies', 1),
    ('Focaccia Bread', 'Italian focaccia bread with rosemary and sea salt', 9.99, 'Breads', 1);



