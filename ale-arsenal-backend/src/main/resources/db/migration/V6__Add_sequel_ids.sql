ALTER TABLE ingredients
ADD sequel_id INT NOT NULL;

ALTER TABLE own_beers
ADD sequel_id INT NOT NULL;

ALTER TABLE other_beers
ADD sequel_id INT NOT NULL;

ALTER TABLE beer_recipes
ADD sequel_id INT NOT NULL;