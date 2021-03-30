-- SET @last_person = LAST_INSERT_ID();

-- NEW Persons
INSERT INTO person
    (`person_id`, `name`, `surname`, `email`, `description`, `cellphone`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (1, 'Ren ', 'Hoek', 'ren.dog@whatever.com', 'Soy el mejor Chihuahua', '66600666', '1', '127.0.0.1', '0', '2021-03-23 18');
INSERT INTO person
    (`person_id`, `name`, `surname`, `email`, `description`, `cellphone`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (2, 'Stimpson ', 'J. Cat', 'stimpy.cat@whatever.com', 'Soy un gato bobalicón', '66601666', '1', '127.0.0.1', '0', '2021-03-23 18');
INSERT INTO person
    (`person_id`, `name`, `surname`, `email`, `description`, `cellphone`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (3, 'Super ', 'Tostada', 'pan.tostado@whatever.com', 'Soy suuuuper tostada!', '66602666', '1', '127.0.0.1', '0', '2021-03-23 18');
INSERT INTO person
    (`person_id`, name, surname, email, description, cellphone, status, tx_host, tx_user_id, tx_date) VALUES
    (4, 'Nikita', 'Peatt', 'npeatt0@blogs.com', 'Cysto & recto w grf/pros', 5991210319, 1, '8.44.233.223', 10, '2020-05-12 01:27:25');
INSERT INTO person
    (`person_id`, name, surname, email, description, cellphone, status, tx_host, tx_user_id, tx_date) VALUES
    (5, 'Dalia', 'Colbrun', 'dcolbrun1@businessweek.com', 'Grft repair hrt sept NOS', 9746370500, 1, '43.84.97.97', 2, '2021-01-13 07:06:20');
INSERT INTO person
    (`person_id`, name, surname, email, description, cellphone, status, tx_host, tx_user_id, tx_date) VALUES
    (6, 'Stevy', 'Lound', 'slound2@plala.or.jp', 'Particulate radiosurgery', 4608881916, 1, '185.108.116.97', 27, '2020-05-31 09:20:19');
INSERT INTO person
    (`person_id`, name, surname, email, description, cellphone, status, tx_host, tx_user_id, tx_date) VALUES
    (7, 'Cassie', 'Yirrell', 'cyirrell3@deliciousdays.com', 'Other lacrimal gland ops', 2058512030, 1, '206.125.242.62', 43, '2021-03-03 12:35:28');
INSERT INTO person
    (`person_id`, name, surname, email, description, cellphone, status, tx_host, tx_user_id, tx_date) VALUES
    (8, 'Jennica', 'Willshee', 'jwillshee4@acquirethisname.com', 'Oth op on >l extraoc mus', 2531904915, 1, '202.128.241.79', 24, '2021-03-25 13:45:31');

INSERT INTO person
    (`person_id`, name, surname, email, description, cellphone, status, tx_host, tx_user_id, tx_date) VALUES
    (9, 'Velvet', 'Agent', 'vagent7@livejournal.com', 'Atlas-axis fusion', 5688353350, 1, '212.147.230.95', 95, '2021-02-15 07:56:35');
INSERT INTO person
    (`person_id`, name, surname, email, description, cellphone, status, tx_host, tx_user_id, tx_date) VALUES
    (10, 'Vivian', 'Cicerone', 'vcicerone8@ameblo.jp', 'Bilat rad neck dissect', 3363941597, 1, '238.48.163.8', 36, '2020-06-21 14:44:37');
INSERT INTO person
    (`person_id`, name, surname, email, description, cellphone, status, tx_host, tx_user_id, tx_date) VALUES
    (11, 'Gloriana', 'Grewar', 'ggrewar5@weather.com', 'Tracheal reconstruction', 6439961257, 0, '116.159.156.251', 72, '2020-12-12 01:01:15');
INSERT INTO person
    (`person_id`, name, surname, email, description, cellphone, status, tx_host, tx_user_id, tx_date) VALUES
    (12, 'Jarrod', 'Crooke', 'jcrooke6@noaa.gov', 'Remov imp dev-metac/carp', 4665346344, 0, '239.123.139.83', 46, '2020-11-21 08:34:12');

--
-- NEW Users
INSERT INTO `user` -- PASSWORD renhoek
    (`user_id`, `person_user_id`, `username`, `password`, `status`, `user_photo`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (1, '1', 'RenHoek', 'c14afa31f907bab70e86a17ea514a145', '1', 'https://images4.alphacoders.com/204/204188.jpg', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `user` -- PASSWORD stimpycat
    (`user_id`, `person_user_id`, `username`, `password`, `status`, `user_photo`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (2, '2', 'StimpyCat', 'cca4b797eae06dc4f71ba5e7138d2c04', '1', 'https://i.pinimg.com/originals/ec/15/32/ec1532c5a2b4666e05663cf394238e5a.jpg', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `user` -- PASSWORD tostada
    (`user_id`, `person_user_id`, `username`, `password`, `status`, `user_photo`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (3, '3', 'SuperTostada', 'a5781406ac28540320c4848432425976', '1', 'http://pm1.narvii.com/6047/22e0656970ed40f8fa6a2736db3113f6f0b469f0_00.jpg', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `user` -- PASSWORD default
    (`user_id`, `person_user_id`, `username`, `password`, `status`, `user_photo`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (4, '4', 'Nikita', 'c21f969b5f03d33d43e04f8f136e7682', '1', 'https://res.cloudinary.com/fulano/image/upload/v1617116017/profileimage_kptkl6.jpg', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `user` -- PASSWORD default
    (`user_id`, `person_user_id`, `username`, `password`, `status`, `user_photo`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (5, '5', 'Dalia', 'c21f969b5f03d33d43e04f8f136e7682', '1', 'https://res.cloudinary.com/fulano/image/upload/v1617116017/profileimage_kptkl6.jpg', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `user` -- PASSWORD default
    (`user_id`, `person_user_id`, `username`, `password`, `status`, `user_photo`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (6, '6', 'Stevy', 'c21f969b5f03d33d43e04f8f136e7682', '1', 'https://res.cloudinary.com/fulano/image/upload/v1617116017/profileimage_kptkl6.jpg', '127.0.0.1', '0', '2021-03-23 18:00:00');

-- NEW Admin
INSERT INTO `admin` -- PASSWORD stimpycat
    (`admin_id`, `person_person_id`, `username`, `photo`, `password`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (1, '2', 'StimpyCat', 'https://i.pinimg.com/originals/ec/15/32/ec1532c5a2b4666e05663cf394238e5a.jpg', 'cca4b797eae06dc4f71ba5e7138d2c04', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');

-- NEW Manager
INSERT INTO `manager` -- PASSWORD renhoek
    (`manager_id`, `person_person_id`, `username`, `photo`, `password`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (1, '1', 'RenHoek', 'https://images4.alphacoders.com/204/204188.jpg','c14afa31f907bab70e86a17ea514a145', '1',  '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `manager` -- PASSWORD tostada
    (`manager_id`, `person_person_id`, `username`, `photo`, `password`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (2, '3', 'SuperTostada', 'http://pm1.narvii.com/6047/22e0656970ed40f8fa6a2736db3113f6f0b469f0_00.jpg', 'a5781406ac28540320c4848432425976', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `manager` -- PASSWORD default
    (`manager_id`, `person_person_id`, `username`, `photo`, `password`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (3, '7', 'Cassie', 'https://res.cloudinary.com/fulano/image/upload/v1617116017/profileimage_kptkl6.jpg', 'c21f969b5f03d33d43e04f8f136e7682', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `manager` -- PASSWORD default
    (`manager_id`, `person_person_id`, `username`, `photo`, `password`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (4, '8', 'Jennica', 'https://res.cloudinary.com/fulano/image/upload/v1617116017/profileimage_kptkl6.jpg', 'c21f969b5f03d33d43e04f8f136e7682', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');

-- NEW BranchOffice
INSERT INTO `branch_office`
    (`id_branch_office`, `manager_manager_id`, `name`, `phone`, `zone`, `address`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (1, '1', 'Ketal Calacoto', '66603666', 'Zona Sur', 'Av. Ballivián esq, calle 15, Calacoto', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');

INSERT INTO `branch_office`
    (`id_branch_office`, `manager_manager_id`, `name`, `phone`, `zone`, `address`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (2, '1', 'Ketal Arce', '66604666', 'Zona Central', 'Av. Arce esq. Calle Macario Pinilla, San Jorge', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');

INSERT INTO `branch_office`
    (`id_branch_office`, `manager_manager_id`, `name`, `phone`, `zone`, `address`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (3, '2', 'Ketal Achumani', '66605666', 'Zona Sur', 'Av. Alexander Nº 108, entre calle 13 y 14, Achumani', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');

INSERT INTO `branch_office`
    (`id_branch_office`, `manager_manager_id`, `name`, `phone`, `zone`, `address`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (4, '2', 'Express de Ketal', '66606666', 'El Alto', 'Estación Mirador Teleférico, Ciudad Satélite', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');

-- NEW Categories
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Abarrotes', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Aseo y Limpieza', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Bebidas, Licores y Tabacos', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Snack, Golosinas y Galletas', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Productos Frescos', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Refrigerado y Congelado', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Panaderia y Pastelería', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Cuidado Personal', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Bebés y Nin@s', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Hogar y Electro', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Lácteos', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');
INSERT INTO `product_category` (`name`, `status`, `tx_host`, `tx_user_id`, `tx_date`)
                        VALUES ('Mascotas', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');


-- NEW Products
INSERT INTO `product`
    (`product_id`, `product_category_id`, `name`, `price`, `description`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (1, '3', 'Coca-Cola 2L', '12.30', 'Es una coca de 2L en un envase de plastico no retornable', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

INSERT INTO `product`
    (`product_id`, `product_category_id`, `name`, `price`, `description`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (2, '3', 'Baileys', '149.90', 'Baileys 750Ml', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

INSERT INTO `product`
    (`product_id`, `product_category_id`, `name`, `price`, `description`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (3, '4', 'Doritos', '19.90', 'Doritos Queso 200Gr', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

INSERT INTO `product`
    (`product_id`, `product_category_id`, `name`, `price`, `description`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (4, '4', 'Chizitos La Estrella', '12.70', 'Chizitos La Estrella Familiar 240Gr', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

INSERT INTO `product`
    (`product_id`, `product_category_id`, `name`, `price`, `description`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (5, '10', 'Alicate de punta', '47.90', 'Alicate De Punta 8" M Acero Tolsen 260G', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

INSERT INTO `product`
    (`product_id`, `product_category_id`, `name`, `price`, `description`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    (6, '10', 'Afeitadora PR1235', '409.00', 'Afeitadora Electrica Reming Pivot&Flex Pr1235', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');


-- NEW Media Product   ==>   Photos Product
INSERT INTO `media_product`
    (`product_product_id`, `photo`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('1', 'https://st1.sedovin.com/3371/coca-cola-2-litros.jpg', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

INSERT INTO `media_product`
    (`product_product_id`, `photo`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('2', 'https://www.ketal.com.bo/image/cache/catalog/product/5055050-550x550.jpg', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

INSERT INTO `media_product`
    (`product_product_id`, `photo`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('3', 'https://www.ketal.com.bo/image/cache/catalog/product/80134792-1000x1000.jpg', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

INSERT INTO `media_product`
    (`product_product_id`, `photo`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('4', 'https://www.ketal.com.bo/image/cache/catalog/product/80141414-550x550.jpg', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

INSERT INTO `media_product`
    (`product_product_id`, `photo`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('5', 'https://www.ketal.com.bo/image/cache/catalog/product/80203310-1000x1000.jpg', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

INSERT INTO `media_product`
    (`product_product_id`, `photo`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('6', 'https://www.ketal.com.bo/image/cache/catalog/product/80152267-1000x1000.jpg', '1', '127.0.0.1', '0', '2021-03-20 18:07:21');

-- NEW stocks
INSERT INTO `stock`
    (`product_product_id`, `in_stock`, `last_update`) VALUES
    ('1', '12', '2021-03-20 18:07:21');

INSERT INTO `stock`
    (`product_product_id`, `in_stock`, `last_update`) VALUES
    ('2', '23', '2021-03-20 18:07:21');

INSERT INTO `stock`
    (`product_product_id`, `in_stock`, `last_update`) VALUES
    ('3', '34', '2021-03-20 18:07:21');

INSERT INTO `stock`
    (`product_product_id`, `in_stock`, `last_update`) VALUES
    ('4', '45', '2021-03-20 18:07:21');

INSERT INTO `stock`
    (`product_product_id`, `in_stock`, `last_update`) VALUES
    ('5', '56', '2021-03-20 18:07:21');

INSERT INTO `stock`
    (`product_product_id`, `in_stock`, `last_update`) VALUES
    ('6', '50', '2021-03-20 18:07:21');

-- Linking products - branches
INSERT INTO `product_branch_office` (`product_product_id`, `branch_office_id_branch_office`) VALUES ('1', '1');
INSERT INTO `product_branch_office` (`product_product_id`, `branch_office_id_branch_office`) VALUES ('3', '1');
INSERT INTO `product_branch_office` (`product_product_id`, `branch_office_id_branch_office`) VALUES ('5', '1');

INSERT INTO `product_branch_office` (`product_product_id`, `branch_office_id_branch_office`) VALUES ('2', '2');
INSERT INTO `product_branch_office` (`product_product_id`, `branch_office_id_branch_office`) VALUES ('4', '2');
INSERT INTO `product_branch_office` (`product_product_id`, `branch_office_id_branch_office`) VALUES ('6', '2');









