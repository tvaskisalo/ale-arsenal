CREATE TABLE ingredients (
  id SERIAL PRIMARY KEY,
  name VARCHAR NOT NULL,
  count FLOAT NOT NULL,
  ingredient_type VARCHAR NOT NULL
);