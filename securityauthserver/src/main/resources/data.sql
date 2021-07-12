
Drop TABLE  Users;
CREATE TABLE IF NOT EXISTS  Users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  role VARCHAR(250) DEFAULT NULL
);


INSERT INTO Users (username, password, role) VALUES
  ('bsingh91', 'password', 'ROLE_USER'),
  ('tom21', 'password', 'ROLE_USER'),
('enduser', 'password', 'ROLE_USER');