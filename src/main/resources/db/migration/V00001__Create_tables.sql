CREATE TABLE persons (
                         name VARCHAR(255) NOT NULL,
                         surname VARCHAR(255) NOT NULL,
                         age INT NOT NULL,
                         phone_number VARCHAR(255),
                         city VARCHAR(255),
                         PRIMARY KEY (name, surname, age)
);