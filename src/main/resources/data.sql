DROP TABLE IF EXISTS flights;

CREATE TABLE flights (
                              flight_id INT AUTO_INCREMENT  PRIMARY KEY,
                              carrier_code_IATA VARCHAR(250) NOT NULL,
                              flight_number INT NOT NULL,
                              flight_date DATE,
                              origin VARCHAR(250),
                              destination VARCHAR(250)
);


DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
                              role_id INT AUTO_INCREMENT  PRIMARY KEY,
                              name VARCHAR(250)
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
                              user_id INT AUTO_INCREMENT  PRIMARY KEY,
                              username VARCHAR(250) NOT NULL,
                              password VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS user_role;

CREATE TABLE user_role(
                                     user_id varchar2(15) NOT NULL,
                                     role_id varchar2(14) NOT NULL,
                                     FOREIGN KEY (user_id) REFERENCES users(user_id),
                                     FOREIGN KEY (role_id) REFERENCES roles(role_id),
                                     UNIQUE (user_id, role_id)
);

INSERT INTO roles (role_id, name) VALUES
('1', 'ROLE_USER'),
('2', 'ROLE_ADMINISTRATOR');

    INSERT INTO users (user_id, username, password) VALUES
(111, 'user', '$2a$10$Fu4EKLHhK5RF4tQxmMmxc.k1Xu.Z6a.ABrgeAobcdzvGqV2KQCgmG'),
(222, 'admin', '$2a$10$Fu4EKLHhK5RF4tQxmMmxc.k1Xu.Z6a.ABrgeAobcdzvGqV2KQCgmG');

INSERT INTO flights (carrier_code_IATA, flight_number, flight_date, origin, destination) VALUES
('1AA',1, '1900-01-01', '1AA', '1AA'),
('1AA',1, '1900-01-01', '1AA', '1AA'),
('1AA',1, '1900-01-01', '1AA', '1AA');

INSERT INTO user_role (user_id, role_id) VALUES
(111, 1),
(222, 2);