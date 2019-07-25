CREATE TABLE IF NOT EXISTS `articeList` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `articleName` VARCHAR(100) NOT NULL COMMENT '文章名字',
    `describe` VARCHAR(300) NOT NULL COMMENT '简单描述',
    `author` VARCHAR(50) NOT NULL COMMENT '作者名称',
    `lable` VARCHAR(150) DEFAULT NULL COMMENT '标签',
    `classification` VARCHAR(100) NOT NULL  COMMENT  '分类',
    `content` TEXT NOT NULL COMMENT '文章内容',
    `date` DATETIME NOT NULL COMMENT '日期',
    `url` VARCHAR(100) NOT NULL COMMENT  '地址',
    PRIMARY KEY (id), UNIQUE (url)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '文章表';