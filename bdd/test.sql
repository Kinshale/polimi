CREATE TABLE employees (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  position VARCHAR(50),
  salary NUMERIC(10,2), 
  hire_date DATE DEFAULT CURRENT_DATE
);

INSERT INTO employees (name, position, salary)
VALUES 
    ('Alice Johnson', 'Manager', 75000.00),
    ('Bob Smith', 'Developer', 60000.00),
    ('Clara Barton', 'Designer', 55000.00);
