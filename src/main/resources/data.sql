-- Se sustituyen los valores enteros para los identificadores de producto y marcas por UUIDs

INSERT INTO PRODUCT_PRICE (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURRENCY)
VALUES ('d600e0f2-ad74-413d-8a43-a4532a30b3f7', '45a9192c-c2b6-4429-b72e-786e45604469', TIMESTAMP '2020-06-14 00:00:00',
TIMESTAMP '2020-12-31 23:59:59', 1, '2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5', 0, 35.50, 1);

INSERT INTO PRODUCT_PRICE (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURRENCY)
VALUES ('04d58efd-6052-43ff-b75b-bae0f18e5249', '45a9192c-c2b6-4429-b72e-786e45604469', TIMESTAMP '2020-06-14 15:00:00',
TIMESTAMP '2020-06-14 18:30:00', 2, '2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5', 1, 25.45, 1);

INSERT INTO PRODUCT_PRICE (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURRENCY)
VALUES ('5175828a-3f33-46ab-85c1-70daed92803f', '45a9192c-c2b6-4429-b72e-786e45604469', TIMESTAMP '2020-06-15 00:00:00',
TIMESTAMP '2020-06-15 11:00:00', 3, '2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5', 1, 30.50, 1);

INSERT INTO PRODUCT_PRICE (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURRENCY)
VALUES ('78b1a3ba-caef-4798-be50-3dfa62e5a288', '45a9192c-c2b6-4429-b72e-786e45604469',TIMESTAMP '2020-06-15 16:00:00',
TIMESTAMP '2020-12-31 23:59:59', 4, '2f67a7df-47d6-4e39-8f69-bc2ef1b47ee5', 1, 38.95, 1);