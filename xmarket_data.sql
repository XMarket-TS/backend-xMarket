-- NEW Persons
INSERT INTO person
    (`name`, `surname`, `email`, `description`, `cellphone`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('Ren ', 'Hoek', 'ren.dog@whatever.com', 'Soy el mejor Chihuahua', '66600666', '1', '127.0.0.1', '0', '2021-03-23 18');

INSERT INTO person
    (`name`, `surname`, `email`, `description`, `cellphone`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('Stimpson ', 'J. Cat', 'stimpy.cat@whatever.com', 'Soy un gato bobalicón', '66600666', '1', '127.0.0.1', '0', '2021-03-23 18');


-- NEW Users
INSERT INTO `user` -- PASSWORD renhoek
    (`person_user_id`, `username`, `password`, `status`, `user_photo`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('1', 'Ren Hoek', 'c14afa31f907bab70e86a17ea514a145', '1', 'https://images4.alphacoders.com/204/204188.jpg', '127.0.0.1', '0', '2021-03-23 18:00:00');

INSERT INTO `user` -- PASSWORD stimpycat
    (`person_user_id`, `username`, `password`, `status`, `user_photo`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('2', 'Stimpy Cat', 'cca4b797eae06dc4f71ba5e7138d2c04', '1', 'https://i.pinimg.com/originals/ec/15/32/ec1532c5a2b4666e05663cf394238e5a.jpg', '127.0.0.1', '0', '2021-03-23 18:00:00');

-- NEW Admin
INSERT INTO `admin` -- PASSWORD stimpycat
    (`person_person_id`, `username`, `photo`, `password`, `status`, `tx_host`, `tx_user_id`, `tx_date`) VALUES
    ('2', 'Stimpy Cat', 'https://i.pinimg.com/originals/ec/15/32/ec1532c5a2b4666e05663cf394238e5a.jpg', 'cca4b797eae06dc4f71ba5e7138d2c04', '1', '127.0.0.1', '0', '2021-03-23 18:00:00');

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
