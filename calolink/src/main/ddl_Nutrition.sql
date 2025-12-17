CREATE TABLE nutrition
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    kcal          INTEGER              NOT NULL,
    protein       DOUBLE                NOT NULL,
    fat           DOUBLE                NOT NULL,
    carb          DOUBLE                NOT NULL,
    sugar         DOUBLE                NOT NULL,
    cholesterol   DOUBLE                NOT NULL,
    saturated_fat DOUBLE                NOT NULL,
    trans_fat     DOUBLE                NOT NULL,
    sodium        INTEGER               NOT NULL
    CONSTRAINT pk_nutrition PRIMARY KEY (id)
);

ALTER TABLE food
    ADD CONSTRAINT FK_FOOD_ON_NUTRITION FOREIGN KEY (nutrition_id) REFERENCES nutrition (id);