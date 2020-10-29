DROP TABLE IF EXISTS product;
CREATE TABLE product ( id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(25) NOT NULL, quantity number(200)NOT NULL, price decimal(30,2) NOT NULL, discount decimal(30,2) NOT NULL);  
INSERT INTO product (name, quantity,price,discount) VALUES
('Apple', 100,8000,5.2),
  ('Samsung', 250, 5000,10.5),
  ('OnePlus', 425,7000,11);