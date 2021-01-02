# 用户信息表
CREATE TABLE `user`
(
    `id`       bigint      NOT NULL auto_increment,
    `name`     VARCHAR(64) NULL,
    `birthday` DATETIME    NULL,
    `sex`      INT         NULL,
    PRIMARY KEY (`id`)
);