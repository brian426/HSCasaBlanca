/*
Navicat MySQL Data Transfer

Source Server         : Conect
Source Server Version : 50144
Source Host           : localhost:3306
Source Database       : bdcasablanca

Target Server Type    : MYSQL
Target Server Version : 50144
File Encoding         : 65001

Date: 2015-02-06 20:04:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_cbcliente
-- ----------------------------
DROP TABLE IF EXISTS `t_cbcliente`;
CREATE TABLE `t_cbcliente` (
  `CB_idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `CB_CliNombres` varchar(45) NOT NULL,
  `CB_CliApellidos` varchar(45) NOT NULL,
  `CB_CliNumIdentif` varchar(15) NOT NULL,
  `CB_idIdentificacion` int(11) NOT NULL,
  `CB_CantVisitas` int(11) NOT NULL,
  `CB_OtrosDatos` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CB_idCliente`),
  KEY `fk_T_CBCliente_T_Identificacion1` (`CB_idIdentificacion`),
  CONSTRAINT `fk_T_CBCliente_T_Identificacion1` FOREIGN KEY (`CB_idIdentificacion`) REFERENCES `t_cbidentificacion` (`CB_idIdentificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbcliente
-- ----------------------------

-- ----------------------------
-- Table structure for t_cbestacionamiento
-- ----------------------------
DROP TABLE IF EXISTS `t_cbestacionamiento`;
CREATE TABLE `t_cbestacionamiento` (
  `CB_idEstacionamiento` int(11) NOT NULL AUTO_INCREMENT,
  `CB_NumeroPlaza` int(11) NOT NULL,
  `CB_EstadoPlaza` int(11) NOT NULL,
  `CB_idRegistroHab` int(11) DEFAULT NULL,
  PRIMARY KEY (`CB_idEstacionamiento`),
  KEY `fk_T_CBEstacionamiento_T_CBEstadoEstaciona_idx` (`CB_EstadoPlaza`),
  CONSTRAINT `fk_T_CBEstacionamiento_T_CBEstadoEstaciona` FOREIGN KEY (`CB_EstadoPlaza`) REFERENCES `t_cbestadoestaciona` (`CB_idEstadoEstaciona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbestacionamiento
-- ----------------------------

-- ----------------------------
-- Table structure for t_cbestadoestaciona
-- ----------------------------
DROP TABLE IF EXISTS `t_cbestadoestaciona`;
CREATE TABLE `t_cbestadoestaciona` (
  `CB_idEstadoEstaciona` int(11) NOT NULL AUTO_INCREMENT,
  `CB_descEstado` varchar(45) NOT NULL,
  PRIMARY KEY (`CB_idEstadoEstaciona`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbestadoestaciona
-- ----------------------------
INSERT INTO `t_cbestadoestaciona` VALUES ('1', 'Disponible');
INSERT INTO `t_cbestadoestaciona` VALUES ('2', 'Ocupada');
INSERT INTO `t_cbestadoestaciona` VALUES ('3', 'Reservada');
INSERT INTO `t_cbestadoestaciona` VALUES ('4', 'Mantenimiento');

-- ----------------------------
-- Table structure for t_cbestadohabitacion
-- ----------------------------
DROP TABLE IF EXISTS `t_cbestadohabitacion`;
CREATE TABLE `t_cbestadohabitacion` (
  `CB_idEstadoHab` int(11) NOT NULL AUTO_INCREMENT,
  `CB_DescEstadoHab` varchar(45) NOT NULL,
  PRIMARY KEY (`CB_idEstadoHab`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbestadohabitacion
-- ----------------------------
INSERT INTO `t_cbestadohabitacion` VALUES ('1', 'Disponible');
INSERT INTO `t_cbestadohabitacion` VALUES ('2', 'Ocupada');
INSERT INTO `t_cbestadohabitacion` VALUES ('3', 'Reservada');
INSERT INTO `t_cbestadohabitacion` VALUES ('4', 'Limpieza');
INSERT INTO `t_cbestadohabitacion` VALUES ('5', 'Mantenimiento');

-- ----------------------------
-- Table structure for t_cbestadoregistro
-- ----------------------------
DROP TABLE IF EXISTS `t_cbestadoregistro`;
CREATE TABLE `t_cbestadoregistro` (
  `CB_idEstadoRegistro` int(11) NOT NULL AUTO_INCREMENT,
  `CB_descEstadoReg` varchar(45) NOT NULL,
  PRIMARY KEY (`CB_idEstadoRegistro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbestadoregistro
-- ----------------------------
INSERT INTO `t_cbestadoregistro` VALUES ('1', 'Reservada');
INSERT INTO `t_cbestadoregistro` VALUES ('2', 'Registrada');
INSERT INTO `t_cbestadoregistro` VALUES ('3', 'Cancelada');

-- ----------------------------
-- Table structure for t_cbestadouser
-- ----------------------------
DROP TABLE IF EXISTS `t_cbestadouser`;
CREATE TABLE `t_cbestadouser` (
  `CB_idEstadoUser` int(11) NOT NULL AUTO_INCREMENT,
  `CB_DescEstado` varchar(45) NOT NULL,
  PRIMARY KEY (`CB_idEstadoUser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbestadouser
-- ----------------------------
INSERT INTO `t_cbestadouser` VALUES ('1', 'activo');
INSERT INTO `t_cbestadouser` VALUES ('2', 'no activo');

-- ----------------------------
-- Table structure for t_cbhabitacion
-- ----------------------------
DROP TABLE IF EXISTS `t_cbhabitacion`;
CREATE TABLE `t_cbhabitacion` (
  `CB_idHabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `CB_HabNumeroNivel` int(11) NOT NULL,
  `CB_HabNumero` int(11) NOT NULL,
  `CB_HabEstado` int(11) NOT NULL,
  `CB_HabHorarioOcupado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CB_idHabitacion`),
  KEY `fk_T_CBHabitacion_T_CBEstadoHabitacion1_idx` (`CB_HabEstado`),
  CONSTRAINT `fk_T_CBHabitacion_T_CBEstadoHabitacion1` FOREIGN KEY (`CB_HabEstado`) REFERENCES `t_cbestadohabitacion` (`CB_idEstadoHab`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbhabitacion
-- ----------------------------

-- ----------------------------
-- Table structure for t_cbidentificacion
-- ----------------------------
DROP TABLE IF EXISTS `t_cbidentificacion`;
CREATE TABLE `t_cbidentificacion` (
  `CB_idIdentificacion` int(11) NOT NULL AUTO_INCREMENT,
  `CB_IdentifDescripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`CB_idIdentificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbidentificacion
-- ----------------------------
INSERT INTO `t_cbidentificacion` VALUES ('1', 'DNI');

-- ----------------------------
-- Table structure for t_cbobservacion
-- ----------------------------
DROP TABLE IF EXISTS `t_cbobservacion`;
CREATE TABLE `t_cbobservacion` (
  `CB_idObservacion` int(11) NOT NULL AUTO_INCREMENT,
  `CB_DetalleObservacion` varchar(200) NOT NULL,
  `CB_FechaRegistro` datetime NOT NULL,
  `CB_TipoObservacion` int(11) NOT NULL,
  `CB_idUser` int(11) NOT NULL,
  PRIMARY KEY (`CB_idObservacion`),
  KEY `fk_T_CBObservacion_T_CBTipoObserv1_idx` (`CB_TipoObservacion`),
  KEY `fk_T_CBObservacion_T_CBUsuario1_idx` (`CB_idUser`),
  CONSTRAINT `fk_T_CBObservacion_T_CBTipoObserv1` FOREIGN KEY (`CB_TipoObservacion`) REFERENCES `t_cbtipoobserv` (`CB_idTipoObserv`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_CBObservacion_T_CBUsuario1` FOREIGN KEY (`CB_idUser`) REFERENCES `t_cbusuario` (`CB_idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbobservacion
-- ----------------------------

-- ----------------------------
-- Table structure for t_cbregistrohab
-- ----------------------------
DROP TABLE IF EXISTS `t_cbregistrohab`;
CREATE TABLE `t_cbregistrohab` (
  `CB_idRegistroHab` int(11) NOT NULL AUTO_INCREMENT,
  `CB_Auto` int(11) NOT NULL,
  `CB_PlacaAuto` varchar(8) DEFAULT NULL,
  `CB_TotaldePersonas` int(11) NOT NULL,
  `CB_FechaRegistroHab` datetime NOT NULL,
  `CB_EstadoRegistro` int(11) NOT NULL,
  `CB_idCliente` int(11) NOT NULL,
  `CB_idUser` int(11) NOT NULL,
  `CB_idHabitacion` int(11) NOT NULL,
  `CB_idEstacionamiento` int(11) DEFAULT NULL,
  `CB_idTiempoHospedaje` int(11) NOT NULL,
  `CB_HoraEntrada` varchar(45) NOT NULL,
  `CB_HoraSalida` varchar(45) NOT NULL,
  `CB_codRegistroHab` varchar(45) NOT NULL,
  `CB_CostoRegistroHab` double NOT NULL,
  PRIMARY KEY (`CB_idRegistroHab`),
  KEY `fk_T_CBRegistroHab_T_CBEstadoRegistro1_idx` (`CB_EstadoRegistro`),
  KEY `fk_T_CBRegistroHab_T_CBCliente1_idx` (`CB_idCliente`),
  KEY `fk_T_CBRegistroHab_T_CBUsuario1_idx` (`CB_idUser`),
  KEY `fk_T_CBRegistroHab_T_CBHabitacion1_idx` (`CB_idHabitacion`),
  KEY `fk_T_CBRegistroHab_T_CBEstacionamiento1_idx` (`CB_idEstacionamiento`),
  KEY `fk_T_CBRegistroHab_T_CBTiempoHospedaje1` (`CB_idTiempoHospedaje`),
  CONSTRAINT `fk_T_CBRegistroHab_T_CBEstadoRegistro1` FOREIGN KEY (`CB_EstadoRegistro`) REFERENCES `t_cbestadoregistro` (`CB_idEstadoRegistro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_CBRegistroHab_T_CBCliente1` FOREIGN KEY (`CB_idCliente`) REFERENCES `t_cbcliente` (`CB_idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_CBRegistroHab_T_CBUsuario1` FOREIGN KEY (`CB_idUser`) REFERENCES `t_cbusuario` (`CB_idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_CBRegistroHab_T_CBHabitacion1` FOREIGN KEY (`CB_idHabitacion`) REFERENCES `t_cbhabitacion` (`CB_idHabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_CBRegistroHab_T_CBEstacionamiento1` FOREIGN KEY (`CB_idEstacionamiento`) REFERENCES `t_cbestacionamiento` (`CB_idEstacionamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_T_CBRegistroHab_T_CBTiempoHospedaje1` FOREIGN KEY (`CB_idTiempoHospedaje`) REFERENCES `t_cbtiempohospedaje` (`CB_idTiempoHospedaje`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbregistrohab
-- ----------------------------

-- ----------------------------
-- Table structure for t_cbtiempohospedaje
-- ----------------------------
DROP TABLE IF EXISTS `t_cbtiempohospedaje`;
CREATE TABLE `t_cbtiempohospedaje` (
  `CB_idTiempoHospedaje` int(11) NOT NULL AUTO_INCREMENT,
  `CB_TiempoHDescripcion` varchar(45) NOT NULL,
  `CB_TiempoHPrecio` double NOT NULL,
  PRIMARY KEY (`CB_idTiempoHospedaje`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbtiempohospedaje
-- ----------------------------
INSERT INTO `t_cbtiempohospedaje` VALUES ('1', 'Max 6 horas S/.20', '20');

-- ----------------------------
-- Table structure for t_cbtipoobserv
-- ----------------------------
DROP TABLE IF EXISTS `t_cbtipoobserv`;
CREATE TABLE `t_cbtipoobserv` (
  `CB_idTipoObserv` int(11) NOT NULL AUTO_INCREMENT,
  `CB_descTipoObserv` varchar(45) NOT NULL,
  PRIMARY KEY (`CB_idTipoObserv`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbtipoobserv
-- ----------------------------
INSERT INTO `t_cbtipoobserv` VALUES ('1', 'Observacion');
INSERT INTO `t_cbtipoobserv` VALUES ('2', 'Incidencia');

-- ----------------------------
-- Table structure for t_cbusuario
-- ----------------------------
DROP TABLE IF EXISTS `t_cbusuario`;
CREATE TABLE `t_cbusuario` (
  `CB_idUser` int(11) NOT NULL AUTO_INCREMENT,
  `CB_UserNick` varchar(45) NOT NULL,
  `CB_UserPass` varchar(45) NOT NULL,
  `CB_UserNombre` varchar(45) NOT NULL,
  `CB_UserApellidos` varchar(45) NOT NULL,
  `CB_UserEdad` date NOT NULL,
  `CB_UserDNI` varchar(45) NOT NULL,
  `CB_UserCelular` varchar(45) DEFAULT NULL,
  `CB_UserTelefono` varchar(45) DEFAULT NULL,
  `CB_UserCorreo` varchar(45) DEFAULT NULL,
  `CB_idEstado` int(11) NOT NULL,
  PRIMARY KEY (`CB_idUser`),
  KEY `fk_T_CBUsuario_T_CBEstadoUser1_idx` (`CB_idEstado`),
  CONSTRAINT `fk_T_CBUsuario_T_CBEstadoUser1` FOREIGN KEY (`CB_idEstado`) REFERENCES `t_cbestadouser` (`CB_idEstadoUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cbusuario
-- ----------------------------
INSERT INTO `t_cbusuario` VALUES ('1', 'frans', '1234', 'frans', 'paico reyes', '1991-07-07', '48956185', null, '7894562', 'frans@hotmail.com', '1');
