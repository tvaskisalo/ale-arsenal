CREATE TABLE other_beers
(
    id          SERIAL PRIMARY KEY,
    sequel_id   INT     NOT NULL,
    name        VARCHAR NOT NULL,
    brewery     VARCHAR NOT NULL,
    amount      INT     NOT NULL,
    bottle_size FLOAT   NOT NULL,
    style       VARCHAR NOT NULL,
    abv         FLOAT   NOT NULL
)