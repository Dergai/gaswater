CREATE TABLE `person`
(
    `id`             int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name`           varchar (30)
);

CREATE TABLE `measurement`
(
    `id`             int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `person_id`      varchar (30) NOT NULL,
    `meter`          numeric (10,3),
    `type`           varchar (30)
);

ALTER TABLE `measurement`
    ADD FOREIGN KEY (`person_id`)
        REFERENCES `person`(`id`);
