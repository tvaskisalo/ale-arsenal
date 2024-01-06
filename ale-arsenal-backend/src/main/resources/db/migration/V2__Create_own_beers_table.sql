CREATE TABLE own_beers
(
    id          SERIAL PRIMARY KEY,
    sequel_id   INT     NOT NULL,
    name        VARCHAR NOT NULL,
    bottle_size FLOAT,
    keg_size    FLOAT,
    is_keg      BOOLEAN NOT NULL DEFAULT FALSE,
    amount      FLOAT   NOT NULL,
    abv         FLOAT,
    style       VARCHAR NOT NULL,
    brew_date   VARCHAR NOT NULL
)