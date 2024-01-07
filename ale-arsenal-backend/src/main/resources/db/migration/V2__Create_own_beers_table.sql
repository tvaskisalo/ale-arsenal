CREATE TABLE ownBeers
(
    id            SERIAL PRIMARY KEY,
    sequel_id     INT     NOT NULL,
    name          VARCHAR NOT NULL,
    bottle_size   FLOAT,
    keg_size      FLOAT,
    bottle_amount INT     NOT NULL,
    keg_amount    INT     NOT NULL,
    abv           FLOAT,
    style         VARCHAR NOT NULL,
    brew_date     VARCHAR NOT NULL,
    description   VARCHAR NOT NULL
)