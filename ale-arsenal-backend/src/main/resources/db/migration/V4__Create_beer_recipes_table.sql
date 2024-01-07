CREATE TYPE INGREDIENT_AMOUNT AS
(
    ingredient_id INT,
    amount        FLOAT
);

CREATE TABLE beerRecipes
(
    id                        SERIAL PRIMARY KEY,
    sequel_id                 INT NOT NULL,
    resulting_beer_id         INT,
    batch_size                FLOAT,
    pre_boil_gravity          FLOAT,
    post_boil_gravity         FLOAT,
    malts                     INGREDIENT_AMOUNT[],
    hops                      INGREDIENT_AMOUNT[],
    water                     FLOAT,
    yeast                     INGREDIENT_AMOUNT[],
    other_ingredients         INGREDIENT_AMOUNT[],
    description               VARCHAR,
    fermentation_temp         FLOAT,
    fermentation_time_in_days INTEGER
)