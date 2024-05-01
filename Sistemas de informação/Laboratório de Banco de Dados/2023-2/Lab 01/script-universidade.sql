-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: universidade
-- ------------------------------------------------------
-- Server version	8.0.15

DROP DATABASE IF EXISTS universidade;
CREATE DATABASE universidade;
USE universidade;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `depto`
--

DROP TABLE IF EXISTS `depto`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `depto` (
  `codDepto` char(5) NOT NULL,
  `nomeDepto` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codDepto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `depto`
--

LOCK TABLES `depto` WRITE;
/*!40000 ALTER TABLE `depto` DISABLE KEYS */;
INSERT INTO `depto` VALUES ('FIS01','Física'),('INF01','Informática'),('MAT01','Matemática'),('MED01','Medicina');
/*!40000 ALTER TABLE `depto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `disciplina` (
  `codDepto` char(5) NOT NULL,
  `numDisc` char(5) NOT NULL,
  `nomeDisc` varchar(50) DEFAULT NULL,
  `creditosDisc` int(11) DEFAULT NULL,
  PRIMARY KEY (`codDepto`,`numDisc`),
  CONSTRAINT `disciplina_ibfk_1` FOREIGN KEY (`codDepto`) REFERENCES `depto` (`codDepto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
/*!40000 ALTER TABLE `disciplina` DISABLE KEYS */;
INSERT INTO `disciplina` VALUES ('INF01','101','Programação FORTRAN',4),('INF01','102','Algoritmos e programação',6),('INF01','103','Estruturas de dados',4),('INF01','104','Programação lógica',4),('INF01','105','Teoria da commputação',4),('INF01','106','Banco de dados',4),('INF01','107','Linguagens formais',2),('INF01','108','Compiladores',4),('INF01','109','Classificação e pesquisa',6),('MAT01','101','Cálculo Diferencial',4),('MAT01','102','Álgebra linear',4),('MAT01','103','Geometria analítica',4);
/*!40000 ALTER TABLE `disciplina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `horario` (
  `anoSem` int(11) NOT NULL,
  `codDepto` char(5) NOT NULL,
  `numDisc` char(5) NOT NULL,
  `siglaTur` char(5) NOT NULL,
  `diaSem` int(11) NOT NULL,
  `horaInicio` char(5) NOT NULL,
  `numHoras` int(11) DEFAULT NULL,
  `CODPRED` int(11) DEFAULT NULL,
  `numSala` int(11) DEFAULT NULL,
  PRIMARY KEY (`anoSem`,`codDepto`,`numDisc`,`siglaTur`,`diaSem`,`horaInicio`),
  KEY `CODPRED` (`CODPRED`,`numSala`),
  CONSTRAINT `horario_ibfk_1` FOREIGN KEY (`anoSem`, `codDepto`, `numDisc`, `siglaTur`) REFERENCES `turma` (`anoSem`, `codDepto`, `numDisc`, `siglaTur`),
  CONSTRAINT `horario_ibfk_2` FOREIGN KEY (`CODPRED`, `numSala`) REFERENCES `sala` (`codPred`, `numSala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (932,'INF01','101','A',2,'8',2,43421,102),(932,'INF01','101','A',4,'8',2,43421,102),(932,'INF01','101','B',2,'18',2,43421,102),(932,'INF01','101','B',4,'18',2,43421,102),(932,'INF01','102','A',2,'8',2,43421,103),(932,'INF01','102','A',4,'8',2,43421,103),(932,'INF01','102','A',6,'8',2,43421,103),(932,'MAT01','101','A',2,'8',2,43423,101),(932,'MAT01','101','A',4,'8',2,43423,101),(932,'MAT01','101','B',2,'10',2,43423,101),(932,'MAT01','101','B',4,'10',2,43423,101),(932,'MAT01','101','C',2,'8',2,43423,102),(932,'MAT01','101','C',4,'8',2,43423,102);
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predio`
--

DROP TABLE IF EXISTS `predio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `predio` (
  `codPred` int(11) NOT NULL,
  `nomePred` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codPred`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predio`
--

LOCK TABLES `predio` WRITE;
/*!40000 ALTER TABLE `predio` DISABLE KEYS */;
INSERT INTO `predio` VALUES (43421,'Informática - laboratórios'),(43422,'Informática - administração'),(43423,'Informática - aulas');
/*!40000 ALTER TABLE `predio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prereq`
--

DROP TABLE IF EXISTS `prereq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `prereq` (
  `codDepto` char(5) NOT NULL,
  `numDisc` char(5) NOT NULL,
  `codDeptoPreReq` char(5) NOT NULL,
  `numDiscPreReq` char(5) NOT NULL,
  PRIMARY KEY (`codDepto`,`numDisc`,`codDeptoPreReq`,`numDiscPreReq`),
  KEY `codDeptoPreReq` (`codDeptoPreReq`,`numDiscPreReq`),
  CONSTRAINT `prereq_ibfk_1` FOREIGN KEY (`codDepto`, `numDisc`) REFERENCES `disciplina` (`codDepto`, `numDisc`),
  CONSTRAINT `prereq_ibfk_2` FOREIGN KEY (`codDeptoPreReq`, `numDiscPreReq`) REFERENCES `disciplina` (`codDepto`, `numDisc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prereq`
--

LOCK TABLES `prereq` WRITE;
/*!40000 ALTER TABLE `prereq` DISABLE KEYS */;
INSERT INTO `prereq` VALUES ('INF01','103','INF01','102'),('INF01','104','INF01','102'),('INF01','105','INF01','104'),('INF01','106','INF01','104'),('INF01','107','INF01','104'),('INF01','108','INF01','105'),('INF01','108','INF01','106'),('INF01','109','INF01','107'),('INF01','109','INF01','108'),('MAT01','103','MAT01','101');
/*!40000 ALTER TABLE `prereq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `professor` (
  `codProf` char(5) NOT NULL,
  `nomeProf` varchar(50) DEFAULT NULL,
  `codTit` int(11) DEFAULT NULL,
  `codDepto` char(5) DEFAULT NULL,
  PRIMARY KEY (`codProf`),
  KEY `codTit` (`codTit`),
  KEY `codDepto` (`codDepto`),
  CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`codTit`) REFERENCES `titulacao` (`codTit`),
  CONSTRAINT `professor_ibfk_2` FOREIGN KEY (`codDepto`) REFERENCES `depto` (`codDepto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES ('1','Heuser',4,'INF01'),('2','Antunes',4,'INF01'),('3','Macedo',4,'INF01'),('4','Machado',NULL,'INF01'),('5','Tavares',3,'INF01'),('6','Pereira',3,'INF01'),('7','Álvares',4,'MAT01'),('8','Silva',4,'MAT01'),('9','Souza',NULL,'MAT01');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profturma`
--

DROP TABLE IF EXISTS `profturma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `profturma` (
  `anoSem` int(11) NOT NULL,
  `codDepto` char(5) NOT NULL,
  `numDisc` char(5) NOT NULL,
  `siglaTur` char(5) NOT NULL,
  `codProf` char(5) NOT NULL,
  PRIMARY KEY (`anoSem`,`codDepto`,`numDisc`,`siglaTur`,`codProf`),
  KEY `codDepto` (`codDepto`),
  CONSTRAINT `profturma_ibfk_1` FOREIGN KEY (`anoSem`, `codDepto`, `numDisc`, `siglaTur`) REFERENCES `turma` (`anoSem`, `codDepto`, `numDisc`, `siglaTur`),
  CONSTRAINT `profturma_ibfk_2` FOREIGN KEY (`codDepto`) REFERENCES `professor` (`codDepto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profturma`
--

LOCK TABLES `profturma` WRITE;
/*!40000 ALTER TABLE `profturma` DISABLE KEYS */;
INSERT INTO `profturma` VALUES (932,'INF01','101','A','4'),(932,'INF01','101','A','5'),(932,'INF01','101','B','1'),(932,'INF01','102','A','2'),(932,'INF01','102','B','3'),(932,'INF01','102','C','5'),(932,'INF01','102','C','6'),(932,'INF01','103','U','7'),(932,'INF01','104','U','4'),(932,'INF01','105','U','2'),(932,'INF01','106','A','3'),(932,'INF01','106','B','6'),(932,'INF01','107','U','5'),(932,'INF01','108','U','4'),(932,'INF01','109','U','5'),(941,'INF01','101','U','2'),(941,'INF01','102','A','6'),(941,'INF01','102','B','1'),(941,'INF01','102','C','2'),(941,'INF01','103','U','3'),(941,'INF01','104','U','2'),(941,'INF01','105','U','1'),(941,'INF01','106','U','6'),(941,'INF01','107','A','3'),(941,'INF01','107','B','4'),(941,'INF01','109','U','3'),(932,'MAT01','101','A','2'),(932,'MAT01','101','B','7'),(932,'MAT01','101','C','8'),(941,'MAT01','102','A','3'),(941,'MAT01','102','B','6'),(941,'MAT01','102','C','5');
/*!40000 ALTER TABLE `profturma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `sala` (
  `codPred` int(11) NOT NULL,
  `numSala` int(11) NOT NULL,
  `descricaosala` varchar(100) DEFAULT NULL,
  `capacidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`codPred`,`numSala`),
  CONSTRAINT `sala_ibfk_1` FOREIGN KEY (`codPred`) REFERENCES `predio` (`codPred`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (43421,101,'Laboratório Windows',30),(43421,102,'Laboratório Redes',30),(43421,103,'Laboratório Linux',30),(43421,104,'Laboratório Windows',30),(43421,105,'Laboratório Linux',30),(43421,106,'Laboratório Hardware',30),(43421,107,'Laboratório Automação',30),(43422,101,'Secretaria geral',NULL),(43422,102,'Secretaria graduação',NULL),(43422,103,'Secretaria pós-graduação',NULL),(43423,101,'Sala de aula comum',30),(43423,102,'Sala de aula comum',30),(43423,103,'Sala de aula comum',30),(43423,104,'Sala de aula multimídia',30),(43423,105,'Auditório',80),(43423,106,'Sala de aula laboratório',30),(43423,107,'Sala de aula laboratório',30);
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titulacao`
--

DROP TABLE IF EXISTS `titulacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `titulacao` (
  `codTit` int(11) NOT NULL,
  `nomeTit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codTit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulacao`
--

LOCK TABLES `titulacao` WRITE;
/*!40000 ALTER TABLE `titulacao` DISABLE KEYS */;
INSERT INTO `titulacao` VALUES (1,'Graduado'),(2,'Especialista'),(3,'Mestre'),(4,'Doutor');
/*!40000 ALTER TABLE `titulacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8 ;
CREATE TABLE `turma` (
  `anoSem` int(11) NOT NULL,
  `codDepto` char(5) NOT NULL,
  `numDisc` char(5) NOT NULL,
  `siglaTur` char(5) NOT NULL,
  `capacidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`anoSem`,`codDepto`,`numDisc`,`siglaTur`),
  KEY `codDepto` (`codDepto`,`numDisc`),
  CONSTRAINT `turma_ibfk_1` FOREIGN KEY (`codDepto`, `numDisc`) REFERENCES `disciplina` (`codDepto`, `numDisc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (932,'INF01','101','A',40),(932,'INF01','101','B',40),(932,'INF01','102','A',20),(932,'INF01','102','B',20),(932,'INF01','102','C',20),(932,'INF01','103','U',60),(932,'INF01','104','U',40),(932,'INF01','105','U',40),(932,'INF01','106','A',30),(932,'INF01','106','B',30),(932,'INF01','107','U',70),(932,'INF01','108','U',40),(932,'INF01','109','U',40),(932,'MAT01','101','A',40),(932,'MAT01','101','B',40),(932,'MAT01','101','C',40),(941,'INF01','101','U',20),(941,'INF01','102','A',20),(941,'INF01','102','B',20),(941,'INF01','102','C',20),(941,'INF01','103','U',60),(941,'INF01','104','U',40),(941,'INF01','105','U',40),(941,'INF01','106','U',70),(941,'INF01','107','A',30),(941,'INF01','107','B',40),(941,'INF01','109','U',40),(941,'MAT01','102','A',40),(941,'MAT01','102','B',40),(941,'MAT01','102','C',40);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-26 19:47:17