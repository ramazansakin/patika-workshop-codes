-- Retrieve all columns from a table
SELECT * FROM employees;

-- Retrieve specific columns
SELECT employee_id, first_name, last_name FROM employees;

-- Filter data with WHERE clause
SELECT * FROM employees WHERE department_id = 10;

-- INSERT a new record
INSERT INTO employees (employee_id, first_name, last_name, department_id)
VALUES (101, 'John', 'Doe', 20);

-- UPDATE existing records
UPDATE employees SET salary = salary * 1.1 WHERE department_id = 20;

-- DELETE records
DELETE FROM employees WHERE employee_id = 101;

-- Create a new database
CREATE DATABASE company;

-- Use the database
USE company;

-- Create a table
CREATE TABLE employees (
               employee_id INT PRIMARY KEY,
               first_name VARCHAR(50),
               last_name VARCHAR(50),
               department_id INT,
               salary DECIMAL(10, 2)
);


https://www.programiz.com/sql/online-compiler/

