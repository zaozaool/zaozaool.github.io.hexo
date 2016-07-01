title: Mysql递归查询
date: 2016-07-01 11:29:13
categories:  [后端]
tags: [mysql]
---
```mysql
--创建表
 
DROP TABLE IF EXISTS `t_areainfo`;
CREATE TABLE `t_areainfo` (
 `id` int(11) NOT '0' AUTO_INCREMENT,
 `level` int(11) DEFAULT '0',
 `name` varchar(255) DEFAULT '0',
 `parentId` int(11) DEFAULT '0',
 `status` int(11) DEFAULT '0',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
```
<!-- more -->

```mysql
--初始数据
 
INSERT INTO `t_areainfo` VALUES ('1', '0', '中国', '0', '0');
INSERT INTO `t_areainfo` VALUES ('2', '0', '华北区', '1', '0');
INSERT INTO `t_areainfo` VALUES ('3', '0', '华南区', '1', '0');
INSERT INTO `t_areainfo` VALUES ('4', '0', '北京', '2', '0');
INSERT INTO `t_areainfo` VALUES ('5', '0', '海淀区', '4', '0');
INSERT INTO `t_areainfo` VALUES ('6', '0', '丰台区', '4', '0');
INSERT INTO `t_areainfo` VALUES ('7', '0', '朝阳区', '4', '0');
INSERT INTO `t_areainfo` VALUES ('8', '0', '北京XX区1', '4', '0');
INSERT INTO `t_areainfo` VALUES ('9', '0', '北京XX区2', '4', '0');
INSERT INTO `t_areainfo` VALUES ('10', '0', '北京XX区3', '4', '0');
INSERT INTO `t_areainfo` VALUES ('11', '0', '北京XX区4', '4', '0');
INSERT INTO `t_areainfo` VALUES ('12', '0', '北京XX区5', '4', '0');
INSERT INTO `t_areainfo` VALUES ('13', '0', '北京XX区6', '4', '0');
INSERT INTO `t_areainfo` VALUES ('14', '0', '北京XX区7', '4', '0');
INSERT INTO `t_areainfo` VALUES ('15', '0', '北京XX区8', '4', '0');
INSERT INTO `t_areainfo` VALUES ('16', '0', '北京XX区9', '4', '0');
INSERT INTO `t_areainfo` VALUES ('17', '0', '北京XX区10', '4', '0');
INSERT INTO `t_areainfo` VALUES ('18', '0', '北京XX区11', '4', '0');
INSERT INTO `t_areainfo` VALUES ('19', '0', '北京XX区12', '4', '0');
INSERT INTO `t_areainfo` VALUES ('20', '0', '北京XX区13', '4', '0');
INSERT INTO `t_areainfo` VALUES ('21', '0', '北京XX区14', '4', '0');
INSERT INTO `t_areainfo` VALUES ('22', '0', '北京XX区15', '4', '0');
INSERT INTO `t_areainfo` VALUES ('23', '0', '北京XX区16', '4', '0');
INSERT INTO `t_areainfo` VALUES ('24', '0', '北京XX区17', '4', '0');
INSERT INTO `t_areainfo` VALUES ('25', '0', '北京XX区18', '4', '0');
INSERT INTO `t_areainfo` VALUES ('26', '0', '北京XX区19', '4', '0');
INSERT INTO `t_areainfo` VALUES ('27', '0', '北京XX区1', '4', '0');
INSERT INTO `t_areainfo` VALUES ('28', '0', '北京XX区2', '4', '0');
INSERT INTO `t_areainfo` VALUES ('29', '0', '北京XX区3', '4', '0');
INSERT INTO `t_areainfo` VALUES ('30', '0', '北京XX区4', '4', '0');
INSERT INTO `t_areainfo` VALUES ('31', '0', '北京XX区5', '4', '0');
INSERT INTO `t_areainfo` VALUES ('32', '0', '北京XX区6', '4', '0');
INSERT INTO `t_areainfo` VALUES ('33', '0', '北京XX区7', '4', '0');
INSERT INTO `t_areainfo` VALUES ('34', '0', '北京XX区8', '4', '0');
INSERT INTO `t_areainfo` VALUES ('35', '0', '北京XX区9', '4', '0');
INSERT INTO `t_areainfo` VALUES ('36', '0', '北京XX区10', '4', '0');
INSERT INTO `t_areainfo` VALUES ('37', '0', '北京XX区11', '4', '0');
INSERT INTO `t_areainfo` VALUES ('38', '0', '北京XX区12', '4', '0');
INSERT INTO `t_areainfo` VALUES ('39', '0', '北京XX区13', '4', '0');
INSERT INTO `t_areainfo` VALUES ('40', '0', '北京XX区14', '4', '0');
INSERT INTO `t_areainfo` VALUES ('41', '0', '北京XX区15', '4', '0');
INSERT INTO `t_areainfo` VALUES ('42', '0', '北京XX区16', '4', '0');
INSERT INTO `t_areainfo` VALUES ('43', '0', '北京XX区17', '4', '0');
INSERT INTO `t_areainfo` VALUES ('44', '0', '北京XX区18', '4', '0');
INSERT INTO `t_areainfo` VALUES ('45', '0', '北京XX区19', '4', '0');
INSERT INTO `t_areainfo` VALUES ('46', '0', 'xx省1', '1', '0');
INSERT INTO `t_areainfo` VALUES ('47', '0', 'xx省2', '1', '0');
INSERT INTO `t_areainfo` VALUES ('48', '0', 'xx省3', '1', '0');
INSERT INTO `t_areainfo` VALUES ('49', '0', 'xx省4', '1', '0');
INSERT INTO `t_areainfo` VALUES ('50', '0', 'xx省5', '1', '0');
INSERT INTO `t_areainfo` VALUES ('51', '0', 'xx省6', '1', '0');
INSERT INTO `t_areainfo` VALUES ('52', '0', 'xx省7', '1', '0');
INSERT INTO `t_areainfo` VALUES ('53', '0', 'xx省8', '1', '0');
INSERT INTO `t_areainfo` VALUES ('54', '0', 'xx省9', '1', '0');
INSERT INTO `t_areainfo` VALUES ('55', '0', 'xx省10', '1', '0');
INSERT INTO `t_areainfo` VALUES ('56', '0', 'xx省11', '1', '0');
INSERT INTO `t_areainfo` VALUES ('57', '0', 'xx省12', '1', '0');
INSERT INTO `t_areainfo` VALUES ('58', '0', 'xx省13', '1', '0');
INSERT INTO `t_areainfo` VALUES ('59', '0', 'xx省14', '1', '0');
INSERT INTO `t_areainfo` VALUES ('60', '0', 'xx省15', '1', '0');
INSERT INTO `t_areainfo` VALUES ('61', '0', 'xx省16', '1', '0');
INSERT INTO `t_areainfo` VALUES ('62', '0', 'xx省17', '1', '0');
INSERT INTO `t_areainfo` VALUES ('63', '0', 'xx省18', '1', '0');
INSERT INTO `t_areainfo` VALUES ('64', '0', 'xx省19', '1', '0');
```

```mysql
--查询传入areaId及其以下所有子节点
DROP FUNCTION IF EXISTS queryChildrenAreaInfo;
CREATE FUNCTION `queryChildrenAreaInfo` (areaId INT)
RETURNS VARCHAR(4000)
BEGIN
DECLARE sTemp VARCHAR(4000);
DECLARE sTempChd VARCHAR(4000);
 
SET sTemp = '$';
SET sTempChd = cast(areaId as char);
 
WHILE sTempChd is not NULL DO
SET sTemp = CONCAT(sTemp,',',sTempChd);
SELECT group_concat(id) INTO sTempChd FROM t_areainfo where FIND_IN_SET(parentId,sTempChd)>0;
END WHILE;
return sTemp;
END;
 
--调用方式
select queryChildrenAreaInfo(1);
select * from t_areainfo where FIND_IN_SET(id, queryChildrenAreaInfo(1));
```


转自[mysql递归查询，不用存储过程](http://zhidao.baidu.com/link?url=k1GDh1EGafIeAGtL1AVQgcBhQ57MIhBnup0Ma2w7Cl5fwyBVkcD4s-jv1JgoMMGhOcd6dzSoAMaGeHAmH7y-Danzp-JvIdAkaxaNYlN_4xO)