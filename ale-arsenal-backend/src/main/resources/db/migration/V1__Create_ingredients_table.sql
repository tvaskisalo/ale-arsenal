CREATE TABLE ingredients
(
    id              SERIAL PRIMARY KEY,
    sequel_id       INT     NOT NULL,
    name            VARCHAR NOT NULL,
    amount          FLOAT   NOT NULL,
    ingredient_type VARCHAR NOT NULL
);