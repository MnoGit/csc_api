-- Table: Categories
CREATE TABLE Categories (
                            category_id INT PRIMARY KEY,
                            name VARCHAR(255)
);
-- Table: Super_Categories
CREATE TABLE super_categories (
                                  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                                  name VARCHAR(255),
                                  create_date timestamp default current_timestamp,
                                  updated_date timestamp,
                                  delete_date timestamp
);
-- Table: Categories
CREATE TABLE categories (
                                  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                                  name VARCHAR(255),
                                  create_date timestamp default current_timestamp,
                                  updated_date timestamp,
                                  delete_date timestamp,
                                  FOREIGN KEY (id) REFERENCES super_categories(id)
);


-- Table: Authors
CREATE TABLE Authors (
                         author_id SERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         email VARCHAR(255)
);
-- Table: Articles
CREATE TABLE Articles (
                          article_id INT PRIMARY KEY,
                          title VARCHAR(255),
                          content TEXT,
                          category_id INT,
                          author_id INT,
                          publication_date DATE,
                          FOREIGN KEY (category_id) REFERENCES Categories(category_id),
                          FOREIGN KEY (author_id) REFERENCES Authors(author_id)
);

-- Table: Comments
CREATE TABLE Comments (
                          comment_id INT PRIMARY KEY,
                          article_id INT,
                          name VARCHAR(255),
                          email VARCHAR(255),
                          content TEXT,
                          comment_date TIMESTAMP,
                          FOREIGN KEY (article_id) REFERENCES Articles(article_id)
);

-- Table: users
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       user_id UUID DEFAULT gen_random_uuid(),
                       name VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       role VARCHAR(255) NOT NULL CHECK (role IN ('ROLE_USER', 'ROLE_ADMIN')),
                       create_date timestamp default current_timestamp

);
-- insert user default
INSERT INTO users (name, password, email, role)
VALUES ('admin', '$2a$12$z4zBiKdEKXIg2P8pzUN4MelT1EphgMSQNE4n.4G0sP2SxqRw4I/jq', 'admin@gmail.com.com', 'ROLE_ADMIN');

