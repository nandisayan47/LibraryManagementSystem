INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('CREATOR');
INSERT INTO roles (name) VALUES ('EDITOR');
INSERT INTO roles (name) VALUES ('ADMIN');

INSERT INTO users (fname, lname, city, username, password, enabled) VALUES ('Nilesh', 'Roy', 'Rajkot','nilesh', '$2a$10$OlpVGGz1EXm.LQ/OcvmBQOFdAe3FQNYhOOXrKD6y9fhxOr2aBKwHu', '1');
INSERT INTO users (fname, lname, city, username, password, enabled) VALUES ('Mahesh', 'Das', 'Mumbai', 'mahesh', '$2a$10$lv8PTtiNw7injglznpYeIehWW6knfFe/RnUW16TmGKtfSWRm/V2z2', '1');
INSERT INTO users (fname, lname, city, username, password, enabled) VALUES ('Suresh', 'Prabhu', 'Chennai', 'suresh', '$2a$10$flDL1ovH.7JEy1lSpBuuHuqagrXA8K3j3ELXQFV/KXhQK.WSnP8a.', '1');
INSERT INTO users (fname, lname, city, username, password, enabled) VALUES ('Ramesh', 'Lal', 'Ahmedabad', 'ramesh', '$2a$10$9k8/ODt16QFCmcmXLO2.oeVR8gHUtqpw9JeoEwEx/BKKAX9BZbbHK', '1');
INSERT INTO users (fname, lname, city, username, password, enabled) VALUES ('Sayan', 'Nandi', 'Kolkata', 'admin', '$2a$10$bN7OWEvi6rTqJEYbZfDOg.FHmG.xPTDxJR1k9LzsR4O6Nt8zuIKwq', '1');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1); 
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2); 
INSERT INTO users_roles (user_id, role_id) VALUES (3, 3); 
INSERT INTO users_roles (user_id, role_id) VALUES (4, 2); 
INSERT INTO users_roles (user_id, role_id) VALUES (4, 3); 
INSERT INTO users_roles (user_id, role_id) VALUES (5, 4);