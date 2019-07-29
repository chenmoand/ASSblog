CREATE TABLE IF NOT EXISTS `Blog_User`(
    `id` VARCHAR(10) NOT NULL COMMENT '账号',
    `name` VARCHAR(50) NOT NULL COMMENT  '用户名',
    `password` VARCHAR(100) NOT NULL COMMENT '密码',
    `email` VARCHAR(100) NOT NULL COMMENT '邮箱',
    `group` VARCHAR(100) NOT NULL COMMENT '用户组',
    `permissions` varchar(100) DEFAULT 'guest' COMMENT '权限',
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';