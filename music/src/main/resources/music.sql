/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : music

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2019-11-16 14:34:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  `contents` varchar(200) NOT NULL,
  `commentDate` datetime DEFAULT NULL,
  PRIMARY KEY (`commentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `mylove`
-- ----------------------------
DROP TABLE IF EXISTS `mylove`;
CREATE TABLE `mylove` (
  `loveID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `songID` int(11) NOT NULL,
  PRIMARY KEY (`loveID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mylove
-- ----------------------------

-- ----------------------------
-- Table structure for `song`
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `songID` int(11) NOT NULL AUTO_INCREMENT,
  `songName` varchar(50) NOT NULL,
  `singer` varchar(30) NOT NULL,
  `fileUrl` varchar(120) NOT NULL,
  `hits` int(11) NOT NULL DEFAULT '0' COMMENT '试听次数',
  `download` int(11) NOT NULL DEFAULT '0' COMMENT '下载次数',
  `songType` int(11) NOT NULL DEFAULT '5' COMMENT '1-流行音乐；2-说唱；3-舞曲；4-民谣；5-其他的',
  PRIMARY KEY (`songID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of song
-- ----------------------------

-- ----------------------------
-- Table structure for `songlist`
-- ----------------------------
DROP TABLE IF EXISTS `songlist`;
CREATE TABLE `songlist` (
  `songListID` int(11) NOT NULL AUTO_INCREMENT,
  `songListName` varchar(20) NOT NULL,
  `createUserID` int(11) NOT NULL,
  `createDate` datetime NOT NULL,
  `introduction` varchar(200) DEFAULT NULL,
  `imageUrl` varchar(120) NOT NULL,
  PRIMARY KEY (`songListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of songlist
-- ----------------------------

-- ----------------------------
-- Table structure for `songlistcollection`
-- ----------------------------
DROP TABLE IF EXISTS `songlistcollection`;
CREATE TABLE `songlistcollection` (
  `songListID` int(11) NOT NULL,
  `collectionUserID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of songlistcollection
-- ----------------------------

-- ----------------------------
-- Table structure for `songlistdetailed`
-- ----------------------------
DROP TABLE IF EXISTS `songlistdetailed`;
CREATE TABLE `songlistdetailed` (
  `songListID` int(11) NOT NULL,
  `songID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of songlistdetailed
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `static` int(11) NOT NULL COMMENT '用户状态：0-不可用；1-可用',
  `password` varchar(50) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `imageUrl` varchar(120) DEFAULT NULL,
  `role` int(11) NOT NULL DEFAULT '0' COMMENT '0-用户；1-管理员',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
