CREATE TABLE nutrition
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    food_id       BIGINT                NOT NULL,
    kcal          DOUBLE                NOT NULL,
    protein       DOUBLE                NOT NULL,
    fat           DOUBLE                NOT NULL,
    carb          DOUBLE                NOT NULL,
    sugar         DOUBLE                NOT NULL,
    cholesterol   DOUBLE                NOT NULL,
    saturated_fat DOUBLE                NOT NULL,
    trans_fat     DOUBLE                NOT NULL,
    CONSTRAINT pk_nutrition PRIMARY KEY (id)
);

ALTER TABLE nutrition
    ADD CONSTRAINT uc_nutrition_food UNIQUE (food_id);

ALTER TABLE nutrition
    ADD CONSTRAINT FK_NUTRITION_ON_FOOD FOREIGN KEY (food_id) REFERENCES food (id);