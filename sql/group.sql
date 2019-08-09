CREATE TABLE IF NOT EXISTS `Blog_Group`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `group_name` VARCHAR(100) NOT NULL COMMENT '组的名字',
#     `group_grade` CHAR(1) NOT NULL  COMMENT '组的权限等级',
    `group_describe` VARCHAR(255) NOT NULL COMMENT '组的描述',
    PRIMARY KEY (id), UNIQUE (group_name)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '组表';



CREATE TABLE IF NOT EXISTS `Group_Permissions`(
      `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
      `group_id` bigint(20) DEFAULT NULL COMMENT '组id',
      `per_id` bigint(20) DEFAULT NULL COMMENT '权限id',
      PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '组拥有的权限';