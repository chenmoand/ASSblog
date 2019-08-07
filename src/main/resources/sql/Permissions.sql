CREATE TABLE IF NOT EXISTS `Blog_Permissions`(
   `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `per_name` VARCHAR(100) NOT NULL COMMENT '权限的名字',
   `per_grade` CHAR(1) NOT NULL  COMMENT '权限等级',
#    `per_describe` VARCHAR(255) NOT NULL COMMENT '权限的描述',
   PRIMARY KEY (id), UNIQUE (per_name)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '权限表';