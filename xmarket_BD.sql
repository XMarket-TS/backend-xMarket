-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-04-04 02:51:27.581

-- tables
-- Table: admin
CREATE TABLE admin
(
    admin_id         int          NOT NULL AUTO_INCREMENT,
    person_person_id int          NOT NULL,
    username         varchar(50)  NOT NULL,
    password         varchar(50)  NOT NULL,
    status           int          NOT NULL,
    tx_host          varchar(100) NOT NULL,
    tx_user_id       int          NOT NULL,
    tx_date          timestamp    NOT NULL,
    CONSTRAINT admin_pk PRIMARY KEY (admin_id)
);

-- Table: bank_account
CREATE TABLE bank_account
(
    bank_account_id                int          NOT NULL AUTO_INCREMENT,
    branch_office_id_branch_office int          NOT NULL,
    admin_admin_id                 int          NOT NULL,
    account_number                 int          NOT NULL,
    bank                           varchar(50)  NOT NULL,
    account_type                   varchar(50)  NOT NULL,
    status                         int          NOT NULL,
    tx_host                        varchar(100) NOT NULL,
    tx_user_id                     int          NOT NULL,
    tx_date                        timestamp    NOT NULL,
    CONSTRAINT bank_account_pk PRIMARY KEY (bank_account_id)
);

-- Table: branch_office
CREATE TABLE branch_office
(
    id_branch_office   int          NOT NULL AUTO_INCREMENT,
    manager_manager_id int          NOT NULL,
    name               varchar(50)  NOT NULL,
    phone              int          NOT NULL,
    zone               varchar(50)  NOT NULL,
    address            varchar(100) NOT NULL,
    image              varchar(300) NULL,
    status             int          NOT NULL,
    tx_host            varchar(100) NOT NULL,
    tx_user_id         int          NOT NULL,
    tx_date            timestamp    NOT NULL,
    CONSTRAINT branch_office_pk PRIMARY KEY (id_branch_office)
);

-- Table: card
CREATE TABLE card
(
    card_id          int          NOT NULL AUTO_INCREMENT,
    user_id          int          NOT NULL,
    card_name        varchar(100) NOT NULL,
    card_number      int          NOT NULL,
    expiration_year  int          NOT NULL,
    expiration_month int          NOT NULL,
    CVC              int          NOT NULL,
    creation_date    date         NOT NULL,
    status           int          NOT NULL COMMENT '0: DELETED
1: ACTIVE',
    tx_host          varchar(100) NOT NULL,
    tx_user_id       int          NOT NULL,
    tx_date          timestamp    NOT NULL,
    CONSTRAINT card_pk PRIMARY KEY (card_id)
);

-- Table: h_admin
CREATE TABLE h_admin
(
    h_admin_id       int          NOT NULL AUTO_INCREMENT,
    person_person_id int          NOT NULL,
    market_market_id int          NOT NULL,
    username         varchar(50)  NOT NULL,
    password         varchar(50)  NOT NULL,
    status           int          NOT NULL,
    tx_host          varchar(100) NOT NULL,
    tx_user_id       int          NOT NULL,
    tx_date          timestamp    NOT NULL,
    CONSTRAINT h_admin_pk PRIMARY KEY (h_admin_id)
);

-- Table: h_bank_account
CREATE TABLE h_bank_account
(
    h_bank_account_id              int          NOT NULL AUTO_INCREMENT,
    account_number                 int          NOT NULL,
    bank                           varchar(50)  NOT NULL,
    account_type                   varchar(50)  NOT NULL,
    status                         int          NOT NULL,
    tx_host                        varchar(100) NOT NULL,
    tx_user_id                     int          NOT NULL,
    tx_date                        timestamp    NOT NULL,
    branch_office_id_branch_office int          NOT NULL,
    admin_admin_id                 int          NOT NULL,
    CONSTRAINT h_bank_account_pk PRIMARY KEY (h_bank_account_id)
);

-- Table: h_branch_office
CREATE TABLE h_branch_office
(
    h_id_branch_office int          NOT NULL AUTO_INCREMENT,
    manager_manager_id int          NOT NULL,
    name               varchar(50)  NOT NULL,
    phone              int          NOT NULL,
    zone               varchar(50)  NOT NULL,
    address            varchar(100) NOT NULL,
    image              varchar(300) NULL,
    status             int          NOT NULL,
    tx_host            varchar(100) NOT NULL,
    tx_user_id         int          NOT NULL,
    tx_date            timestamp    NOT NULL,
    CONSTRAINT h_branch_office_pk PRIMARY KEY (h_id_branch_office)
);

-- Table: h_card
CREATE TABLE h_card
(
    h_card_id        int          NOT NULL AUTO_INCREMENT,
    user_id          int          NOT NULL,
    card_name        varchar(20)  NOT NULL,
    card_number      int          NOT NULL,
    expiration_year  int          NOT NULL,
    expiration_month int          NOT NULL,
    CVC              int          NOT NULL,
    creation_date    date         NOT NULL,
    status           int          NOT NULL COMMENT '0: DELETED
1: ACTIVE',
    tx_host          varchar(100) NOT NULL,
    tx_user_id       int          NOT NULL,
    tx_date          timestamp    NOT NULL,
    CONSTRAINT h_card_pk PRIMARY KEY (h_card_id)
);

-- Table: h_manager
CREATE TABLE h_manager
(
    h_manager_id     int          NOT NULL AUTO_INCREMENT,
    person_person_id int          NOT NULL,
    username         varchar(50)  NOT NULL,
    password         varchar(50)  NOT NULL,
    status           int          NOT NULL,
    tx_host          varchar(100) NOT NULL,
    tx_user_id       int          NOT NULL,
    tx_date          timestamp    NOT NULL,
    CONSTRAINT h_manager_pk PRIMARY KEY (h_manager_id)
);

-- Table: h_person
CREATE TABLE h_person
(
    h_person_id int          NOT NULL AUTO_INCREMENT,
    name        varchar(50)  NOT NULL,
    surname     varchar(50)  NOT NULL,
    email       varchar(60)  NOT NULL,
    description text         NULL,
    gender      varchar(20)  NOT NULL,
    photo       varchar(300) NULL,
    cellphone   varchar(20)  NULL,
    status      int          NOT NULL COMMENT '0: INACTIVE
1: ACTIVE',
    tx_host     varchar(100) NOT NULL,
    tx_user_id  int          NOT NULL,
    tx_date     timestamp    NOT NULL,
    CONSTRAINT h_person_pk PRIMARY KEY (h_person_id)
);

-- Table: h_product
CREATE TABLE h_product
(
    h_product_id        int            NOT NULL AUTO_INCREMENT,
    product_category_id int            NOT NULL,
    offers_id_offers    int            NOT NULL,
    qr_qr_id            int            NOT NULL,
    name                varchar(255)   NOT NULL,
    price               decimal(12, 2) NOT NULL,
    description         varchar(1000)  NOT NULL,
    unit                int            NOT NULL,
    status              int            NOT NULL,
    tx_host             varchar(100)   NOT NULL,
    tx_user_id          int            NOT NULL,
    tx_date             timestamp      NOT NULL,
    CONSTRAINT h_product_pk PRIMARY KEY (h_product_id)
);

-- Table: h_product_category
CREATE TABLE h_product_category
(
    h_id       int          NOT NULL AUTO_INCREMENT,
    name       varchar(255) NOT NULL,
    image      varchar(300) NULL,
    status     int          NOT NULL,
    tx_host    varchar(100) NOT NULL,
    tx_user_id int          NOT NULL,
    tx_date    timestamp    NOT NULL,
    CONSTRAINT h_product_category_pk PRIMARY KEY (h_id)
);

-- Table: h_purchase
CREATE TABLE h_purchase
(
    h_bill_id       int          NOT NULL AUTO_INCREMENT,
    card_id         int          NOT NULL,
    user_user_id    int          NOT NULL,
    buy_date        date         NOT NULL,
    billing_address varchar(50)  NOT NULL,
    city            varchar(20)  NOT NULL,
    status          int          NOT NULL COMMENT '0: DELETED
1: ACTIVE',
    tx_host         varchar(100) NOT NULL,
    tx_user_id      int          NOT NULL,
    tx_date         timestamp    NOT NULL,
    CONSTRAINT h_purchase_pk PRIMARY KEY (h_bill_id)
);

-- Table: h_user
CREATE TABLE h_user
(
    h_user_id      int          NOT NULL AUTO_INCREMENT,
    person_user_id int          NOT NULL,
    username       varchar(50)  NOT NULL,
    password       varchar(50)  NOT NULL,
    status         int          NOT NULL,
    tx_host        varchar(100) NOT NULL,
    tx_user_id     int          NOT NULL,
    tx_date        timestamp    NOT NULL,
    CONSTRAINT h_user_pk PRIMARY KEY (h_user_id)
);

-- Table: items
CREATE TABLE items
(
    items_id         int NOT NULL AUTO_INCREMENT,
    product_id       int NOT NULL,
    amount           int NOT NULL,
    purchase_bill_id int NOT NULL,
    CONSTRAINT items_pk PRIMARY KEY (items_id)
);

-- Table: manager
CREATE TABLE manager
(
    manager_id       int          NOT NULL AUTO_INCREMENT,
    person_person_id int          NOT NULL,
    username         varchar(50)  NOT NULL,
    password         varchar(50)  NOT NULL,
    status           int          NOT NULL,
    tx_host          varchar(100) NOT NULL,
    tx_user_id       int          NOT NULL,
    tx_date          timestamp    NOT NULL,
    CONSTRAINT manager_pk PRIMARY KEY (manager_id)
);

-- Table: media_product
CREATE TABLE media_product
(
    media_id           int          NOT NULL AUTO_INCREMENT,
    product_product_id int          NOT NULL,
    photo              varchar(300) NOT NULL,
    status             int          NOT NULL,
    tx_host            varchar(100) NOT NULL,
    tx_user_id         int          NOT NULL,
    tx_date            timestamp    NOT NULL,
    CONSTRAINT media_product_pk PRIMARY KEY (media_id)
);

-- Table: offers_register
CREATE TABLE offers_register
(
    id_offers          int          NOT NULL AUTO_INCREMENT,
    product_product_id int          NOT NULL,
    start_date         date         NOT NULL,
    end_date           date         NOT NULL,
    percentage         int          NOT NULL,
    status             int          NOT NULL,
    tx_host            varchar(100) NOT NULL,
    tx_user_id         int          NOT NULL,
    tx_date            timestamp    NOT NULL,
    CONSTRAINT offers_register_pk PRIMARY KEY (id_offers)
);

-- Table: person
CREATE TABLE person
(
    person_id   int          NOT NULL AUTO_INCREMENT,
    name        varchar(50)  NOT NULL,
    surname     varchar(50)  NOT NULL,
    email       varchar(60)  NOT NULL,
    description text         NULL,
    gender      varchar(20)  NOT NULL,
    photo       varchar(300) NULL,
    cellphone   varchar(20)  NULL,
    status      int          NOT NULL COMMENT '0: INACTIVE
1: ACTIVE',
    tx_host     varchar(100) NOT NULL,
    tx_user_id  int          NOT NULL,
    tx_date     timestamp    NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (person_id)
);

-- Table: product
CREATE TABLE product
(
    product_id          int            NOT NULL AUTO_INCREMENT,
    product_category_id int            NOT NULL,
    name                varchar(255)   NOT NULL,
    price               decimal(12, 2) NOT NULL,
    description         varchar(1000)  NOT NULL,
    weight              decimal(12, 2) NULL,
    status              int            NOT NULL,
    tx_host             varchar(100)   NOT NULL,
    tx_user_id          int            NOT NULL,
    tx_date             timestamp      NOT NULL,
    qr_hash             varchar(64)    NULL,
    CONSTRAINT product_pk PRIMARY KEY (product_id)
);

-- Table: product_branch_office
CREATE TABLE product_branch_office
(
    id_product_branch_office       int NOT NULL AUTO_INCREMENT,
    product_product_id             int NOT NULL,
    branch_office_id_branch_office int NOT NULL,
    CONSTRAINT product_branch_office_pk PRIMARY KEY (id_product_branch_office)
);

-- Table: product_category
CREATE TABLE product_category
(
    id         int          NOT NULL AUTO_INCREMENT,
    name       varchar(255) NOT NULL,
    image      varchar(300) NULL,
    status     int          NOT NULL,
    tx_host    varchar(100) NOT NULL,
    tx_user_id int          NOT NULL,
    tx_date    timestamp    NOT NULL,
    CONSTRAINT product_category_pk PRIMARY KEY (id)
);

-- Table: product_provider
CREATE TABLE product_provider
(
    product_provider_id  int NOT NULL AUTO_INCREMENT,
    product_product_id   int NOT NULL,
    provider_provider_id int NOT NULL,
    CONSTRAINT product_provider_pk PRIMARY KEY (product_provider_id)
);

-- Table: provider
CREATE TABLE provider
(
    provider_id int          NOT NULL AUTO_INCREMENT,
    name        varchar(50)  NOT NULL,
    phone_info  int          NOT NULL,
    status      int          NOT NULL,
    tx_host     varchar(100) NOT NULL,
    tx_user_id  int          NOT NULL,
    tx_date     timestamp    NOT NULL,
    CONSTRAINT provider_pk PRIMARY KEY (provider_id)
);

-- Table: purchase
CREATE TABLE purchase
(
    bill_id         int          NOT NULL AUTO_INCREMENT,
    card_id         int          NOT NULL,
    user_user_id    int          NOT NULL,
    buy_date        date         NOT NULL,
    billing_address varchar(50)  NOT NULL,
    city            varchar(20)  NOT NULL,
    status          int          NOT NULL COMMENT '0: DELETED
1: ACTIVE',
    tx_host         varchar(100) NOT NULL,
    tx_user_id      int          NOT NULL,
    tx_date         timestamp    NOT NULL,
    CONSTRAINT purchase_pk PRIMARY KEY (bill_id)
);

-- Table: stock
CREATE TABLE stock
(
    stock_id           int       NOT NULL AUTO_INCREMENT,
    product_product_id int       NOT NULL,
    in_stock           int       NOT NULL,
    last_update        timestamp NOT NULL,
    CONSTRAINT stock_pk PRIMARY KEY (stock_id)
);

-- Table: transaction
CREATE TABLE transaction
(
    tx_id      int          NOT NULL AUTO_INCREMENT,
    tx_host    varchar(100) NOT NULL,
    tx_user_ud int          NOT NULL,
    tx_date    timestamp    NOT NULL,
    CONSTRAINT transaction_pk PRIMARY KEY (tx_id)
);

-- Table: user
CREATE TABLE user
(
    user_id        int          NOT NULL AUTO_INCREMENT,
    person_user_id int          NOT NULL,
    username       varchar(50)  NOT NULL,
    password       varchar(50)  NOT NULL,
    status         int          NOT NULL,
    tx_host        varchar(100) NOT NULL,
    tx_user_id     int          NOT NULL,
    tx_date        timestamp    NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
);

-- foreign keys
-- Reference: admin_person (table: admin)
ALTER TABLE admin
    ADD CONSTRAINT admin_person FOREIGN KEY admin_person (person_person_id)
        REFERENCES person (person_id);

-- Reference: administrador_person (table: manager)
ALTER TABLE manager
    ADD CONSTRAINT administrador_person FOREIGN KEY administrador_person (person_person_id)
        REFERENCES person (person_id);

-- Reference: bank_account_admin (table: bank_account)
ALTER TABLE bank_account
    ADD CONSTRAINT bank_account_admin FOREIGN KEY bank_account_admin (admin_admin_id)
        REFERENCES admin (admin_id);

-- Reference: bank_account_branch_office (table: bank_account)
ALTER TABLE bank_account
    ADD CONSTRAINT bank_account_branch_office FOREIGN KEY bank_account_branch_office (branch_office_id_branch_office)
        REFERENCES branch_office (id_branch_office);

-- Reference: bill_card (table: purchase)
ALTER TABLE purchase
    ADD CONSTRAINT bill_card FOREIGN KEY bill_card (card_id)
        REFERENCES card (card_id);

-- Reference: branch_office_manager (table: branch_office)
ALTER TABLE branch_office
    ADD CONSTRAINT branch_office_manager FOREIGN KEY branch_office_manager (manager_manager_id)
        REFERENCES manager (manager_id);

-- Reference: media_product_product (table: media_product)
ALTER TABLE media_product
    ADD CONSTRAINT media_product_product FOREIGN KEY media_product_product (product_product_id)
        REFERENCES product (product_id);

-- Reference: offers_product (table: offers_register)
ALTER TABLE offers_register
    ADD CONSTRAINT offers_product FOREIGN KEY offers_product (product_product_id)
        REFERENCES product (product_id);

-- Reference: product_branch_office_branch_office (table: product_branch_office)
ALTER TABLE product_branch_office
    ADD CONSTRAINT product_branch_office_branch_office FOREIGN KEY product_branch_office_branch_office (branch_office_id_branch_office)
        REFERENCES branch_office (id_branch_office);

-- Reference: product_branch_office_product (table: product_branch_office)
ALTER TABLE product_branch_office
    ADD CONSTRAINT product_branch_office_product FOREIGN KEY product_branch_office_product (product_product_id)
        REFERENCES product (product_id);

-- Reference: product_category_product (table: product)
ALTER TABLE product
    ADD CONSTRAINT product_category_product FOREIGN KEY product_category_product (product_category_id)
        REFERENCES product_category (id);

-- Reference: product_order_item (table: items)
ALTER TABLE items
    ADD CONSTRAINT product_order_item FOREIGN KEY product_order_item (product_id)
        REFERENCES product (product_id);

-- Reference: product_provider_product (table: product_provider)
ALTER TABLE product_provider
    ADD CONSTRAINT product_provider_product FOREIGN KEY product_provider_product (product_product_id)
        REFERENCES product (product_id);

-- Reference: product_provider_provider (table: product_provider)
ALTER TABLE product_provider
    ADD CONSTRAINT product_provider_provider FOREIGN KEY product_provider_provider (provider_provider_id)
        REFERENCES provider (provider_id);

-- Reference: purchase_items_purchase (table: items)
ALTER TABLE items
    ADD CONSTRAINT purchase_items_purchase FOREIGN KEY purchase_items_purchase (purchase_bill_id)
        REFERENCES purchase (bill_id);

-- Reference: purchase_user (table: purchase)
ALTER TABLE purchase
    ADD CONSTRAINT purchase_user FOREIGN KEY purchase_user (user_user_id)
        REFERENCES user (user_id);

-- Reference: stock_product (table: stock)
ALTER TABLE stock
    ADD CONSTRAINT stock_product FOREIGN KEY stock_product (product_product_id)
        REFERENCES product (product_id);

-- Reference: user_person (table: user)
ALTER TABLE user
    ADD CONSTRAINT user_person FOREIGN KEY user_person (person_user_id)
        REFERENCES person (person_id);

-- End of file.

