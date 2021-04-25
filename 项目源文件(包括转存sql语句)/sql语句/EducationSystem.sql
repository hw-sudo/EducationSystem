/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : EducationSystem

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 16/01/2021 22:42:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cou
-- ----------------------------
DROP TABLE IF EXISTS `cou`;
CREATE TABLE `cou`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `snum` int(11) NULL DEFAULT NULL,
  `jiaoshi` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cou
-- ----------------------------
INSERT INTO `cou` VALUES (1, '03001', 'Javaweb', 100, 7, 'Tom');
INSERT INTO `cou` VALUES (2, '03002', '软件工程', 100, 9, '王健林');
INSERT INTO `cou` VALUES (6, '03003', '计算机网络', 110, 4, '马云');
INSERT INTO `cou` VALUES (7, '03004', '高数', 100, 3, '马化腾');
INSERT INTO `cou` VALUES (8, '03005', '语文', 100, 0, '李彦宏');
INSERT INTO `cou` VALUES (9, '03006', 'C语言', 100, 0, '吴彦祖');

-- ----------------------------
-- Table structure for jiben
-- ----------------------------
DROP TABLE IF EXISTS `jiben`;
CREATE TABLE `jiben`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tpid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `spid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `banji` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ye` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jiben
-- ----------------------------
INSERT INTO `jiben` VALUES (7, '03003', '01001', '02001', '小杨', '男', '1班', '软件工程', '67');
INSERT INTO `jiben` VALUES (8, '03004', '01003', '02002', 'cat', '男', '2班', '电信工程', '46');
INSERT INTO `jiben` VALUES (12, '03002', '01001', '02003', '小张三', '男', '2班', '软件工程', '86');
INSERT INTO `jiben` VALUES (14, '03004', '01004', '02004', 'tom', '男', '1班', '汉语', '97');
INSERT INTO `jiben` VALUES (15, '03003', '01001', '02004', 'tom', '男', '1班', '汉语', '66');

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `spid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `banji` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ye` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES (1, '02001', '学生1', '男', '1班', '软件工程');
INSERT INTO `stu` VALUES (2, '02002', '学生2', '女', '1班', '计算机');
INSERT INTO `stu` VALUES (3, '02003', '学生3', '男', '2班', '英语');
INSERT INTO `stu` VALUES (4, '02004', 'tom', '男', '1班', '汉语');
INSERT INTO `stu` VALUES (5, '02005', '小七', '男', '2班', '网络工程');
INSERT INTO `stu` VALUES (6, '02005', '李四', '男', '2班', '软件工程');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tpid` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teaname` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `txueyuan` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zhicheng` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '01001', '小王', '男', '计算机学院', '教授');
INSERT INTO `teacher` VALUES (2, '01002', '小刘', '男', '信息学院', '副教授');
INSERT INTO `teacher` VALUES (3, '01003', '小强', '男', '计算机学院', '教授');
INSERT INTO `teacher` VALUES (4, '01004', '小李', '男', '计算机学院', '教授');
INSERT INTO `teacher` VALUES (5, '01005', '小红', '女', '师范学院', '助教');
INSERT INTO `teacher` VALUES (6, '01006', '张三', '男', '马克思学院', '教授');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 3);
INSERT INTO `user` VALUES (2, '01001', '123456', 1);
INSERT INTO `user` VALUES (3, '01002', '123456', 1);
INSERT INTO `user` VALUES (4, '01003', '123456', 1);
INSERT INTO `user` VALUES (5, '01004', '123456', 1);
INSERT INTO `user` VALUES (9, '02004', '123456', 2);
INSERT INTO `user` VALUES (10, '01005', '123456', 1);
INSERT INTO `user` VALUES (11, '02005', '123456', 2);
INSERT INTO `user` VALUES (12, '01006', '123456', 1);
INSERT INTO `user` VALUES (13, '02005', '123456', 2);
INSERT INTO `user` VALUES (14, '02001', '123456', 2);
INSERT INTO `user` VALUES (15, '02002', '123456', 2);
INSERT INTO `user` VALUES (16, '02003', '123456', 2);

SET FOREIGN_KEY_CHECKS = 1;
