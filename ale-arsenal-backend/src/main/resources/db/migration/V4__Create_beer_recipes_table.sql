CREATE TYPE INGREDIENT_AMOUNT AS (
  ingredient_id INT,
  count FLOAT
);

CREATE TABLE beer_recipes (
  id SERIAL PRIMARY KEY,
  resulting_beer_id INT,
  batch_size FLOAT,
  pre_boil_gravity FLOAT,
  post_boil_gravity FLOAT,
  malts INGREDIENT_AMOUNT[],
  hops INGREDIENT_AMOUNT[],
  water FLOAT,
  yeast INGREDIENT_AMOUNT,
  other_ingredients INGREDIENT_AMOUNT[],
  description VARCHAR,
  fermentation_temp FLOAT,
  fermentation_time_in_days INTEGER
)