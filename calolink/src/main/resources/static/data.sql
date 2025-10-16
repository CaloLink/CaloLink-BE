-- 애플리케이션 실행 시 기존 데이터를 모두 삭제하여 항상 동일한 상태에서 시작하도록 보장
DELETE FROM food;
DELETE FROM nutrition;

-- === 1. 영양정보(NUTRITION) 데이터 먼저 삽입 ===
INSERT INTO nutrition (id, kcal, protein, fat, carb, sugar, cholesterol, saturated_fat, trans_fat, sodium)
VALUES (1, 500, 10.5, 15.2, 68.3, 5.1, 0.0, 7.1, 0.0, 1790), -- 신라면 영양정보
       (2, 530, 12.0, 16.0, 75.0, 7.0, 0.0, 8.0, 0.0, 1280), -- 불닭볶음면 영양정보
       (3, 610, 11.0, 20.0, 95.0, 6.0, 0.0, 9.0, 0.0, 1100), -- 짜파게티 영양정보
       (4, 485, 9.5, 14.0, 65.0, 4.0, 0.0, 6.0, 0.0, 1850), -- 진라면 영양정보
       (5, 465, 6.0, 22.0, 61.0, 4.0, 0.0, 10.0, 0.0, 700),  -- 새우깡 영양정보
       (6, 361, 4.0, 24.0, 32.0, 1.0, 0.0, 11.0, 0.0, 320),  -- 포카칩 영양정보
       (7, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 15),     -- 코카콜라 제로 영양정보
       (8, 0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 5);      -- 칠성사이다 제로 영양정보




-- === 2. 음식(FOOD) 데이터 삽입하면서 nutrition_id로 연결 ===
-- 면류 (NOODLES)
INSERT INTO food (id, name, category, manufacturer, image_url, nutrition_id)
VALUES (1, '신라면', 'NOODLES', '농심', 'https://image.nongshim.com/nongshim/main/img/ko/brand/shin_history_2021.jpg', 1),
       (2, '불닭볶음면', 'NOODLES', '삼양', 'https://www.samyangfoods.com/upload/product/20221104/20221104101905001_p.png', 2),
       (3, '짜파게티', 'NOODLES', '농심', 'https://image.nongshim.com/non-front/main/img/ko/brand/jjapagetti_history_2021_01.jpg', 3),
       (4, '진라면 매운맛', 'NOODLES', '오뚜기', 'https://www.ottogi.co.kr/upload/product/20220303102213.png', 4);


-- 간식 (SNACK)
INSERT INTO food (id, name, category, manufacturer, image_url, nutrition_id)
VALUES (5, '새우깡', 'SNACK', '농심', 'https://image.nongshim.com/non-front/main/img/ko/brand/saewookkang_history_2021_01.jpg', 5),
       (6, '포카칩 오리지널', 'SNACK', '오리온', 'https://www.orionworld.com/Data/product/20230206/pocachip_o_20230206.png', 6);


-- 음료 (DRINKS)
INSERT INTO food (id, name, category, manufacturer, image_url, nutrition_id)
VALUES (7, '코카콜라 제로', 'DRINKS', '코카콜라', 'https://www.coca-cola.com/content/dam/onexp/kr/ko/coca-cola-kr/coke-zero-product-img/coke-zero-355ml.png', 7),
       (8, '칠성사이다 제로', 'DRINKS', '롯데칠성', 'https://mall.lottechilsung.co.kr/upload/product/20230303/20230303051412_0.png', 8);
