CREATE TABLE food
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    name         VARCHAR(20)           NOT NULL,
    category     VARCHAR(20)           NOT NULL,
    manufacturer VARCHAR(20)           NOT NULL,
    image_url    VARCHAR(255)          NULL,
    nutrition_id BIGINT,
    CONSTRAINT pk_food PRIMARY KEY (id)
);