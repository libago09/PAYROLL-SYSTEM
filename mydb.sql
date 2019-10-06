-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `idattendance` int(11) NOT NULL AUTO_INCREMENT,
  `time_in` varchar(15) DEFAULT NULL,
  `time_out` varchar(15) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `Employee_idEmployee` int(11) NOT NULL,
  PRIMARY KEY (`idattendance`),
  KEY `fk_attendance_Employee1_idx` (`Employee_idEmployee`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (7,'20:34','20:34','2019-09-01',2),(12,'06:00','12:00','2019-10-02',2),(13,'06:00','12:00','2019-10-03',2),(14,'06:00','12:00','2019-10-04',2),(15,'06:00','12:00','2019-10-05',2),(16,'06:00','12:00','2019-10-06',2),(17,'06:00','12:00','2019-10-06',10),(18,'01:00','04:00','2019-10-06',10),(19,'06:00','12:00','2019-10-07',10),(20,'01:00','04:00','2019-10-07',10),(21,'06:00','12:00','2019-10-08',10),(22,'01:00','04:00','2019-10-08',10),(23,'06:00','12:00','2019-10-09',10),(31,'22:2','22:3','2019-09-03',2);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benefits`
--

DROP TABLE IF EXISTS `benefits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benefits` (
  `idbenefits` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(15) DEFAULT NULL,
  `amount` varchar(15) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `Employee_idEmployee` int(11) NOT NULL,
  `deductions_iddeductions` int(11) NOT NULL,
  PRIMARY KEY (`idbenefits`),
  KEY `fk_benefits_deductions1_idx` (`deductions_iddeductions`),
  KEY `fk_benefits_Employee1_idx` (`Employee_idEmployee`) /*!80000 INVISIBLE */
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benefits`
--

LOCK TABLES `benefits` WRITE;
/*!40000 ALTER TABLE `benefits` DISABLE KEYS */;
INSERT INTO `benefits` VALUES (1,'ge','200','2019-10-02',2,4),(9,'SSS','300','2019-10-02',10,5),(11,'Philhealth','600','2019-10-03',2,7),(12,'Di kosaba','233','2019-10-03',2,8),(13,'GG','123','2019-10-03',2,9);
/*!40000 ALTER TABLE `benefits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deductions`
--

DROP TABLE IF EXISTS `deductions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deductions` (
  `iddeductions` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`iddeductions`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deductions`
--

LOCK TABLES `deductions` WRITE;
/*!40000 ALTER TABLE `deductions` DISABLE KEYS */;
INSERT INTO `deductions` VALUES (1,20000),(2,100),(3,80),(4,100),(5,120),(6,200),(7,300),(8,100),(9,50);
/*!40000 ALTER TABLE `deductions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `idDepartment` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idDepartment`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'ambot'),(2,'di ko'),(3,'kapoy'),(4,'ge'),(5,'g');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependent`
--

DROP TABLE IF EXISTS `dependent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dependent` (
  `iddependent` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(15) DEFAULT NULL,
  `midinit` varchar(2) DEFAULT NULL,
  `lastname` varchar(15) DEFAULT NULL,
  `birthdate` varchar(15) DEFAULT NULL,
  `dependentcol` date DEFAULT NULL,
  `Employee_idEmployee` int(11) NOT NULL,
  PRIMARY KEY (`iddependent`),
  KEY `fk_dependent_Employee1_idx` (`Employee_idEmployee`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_dependent_Employee1` FOREIGN KEY (`Employee_idEmployee`) REFERENCES `employee` (`idEmployee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependent`
--

LOCK TABLES `dependent` WRITE;
/*!40000 ALTER TABLE `dependent` DISABLE KEYS */;
/*!40000 ALTER TABLE `dependent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `idEmployee` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(15) DEFAULT NULL,
  `region` varchar(15) DEFAULT NULL,
  `city` varchar(15) DEFAULT NULL,
  `firstname` varchar(15) DEFAULT NULL,
  `midinit` varchar(15) DEFAULT NULL,
  `lastname` varchar(15) DEFAULT NULL,
  `sex` varchar(15) DEFAULT NULL,
  `birthdate` varchar(15) DEFAULT NULL,
  `employeepassword` varchar(15) DEFAULT NULL,
  `leavecount` int(11) DEFAULT NULL,
  `jobtitle` varchar(15) DEFAULT NULL,
  `department_idDepartment` int(11) DEFAULT NULL,
  `salary_idsalary1` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEmployee`),
  KEY `fk_Employee_department1_idx` (`department_idDepartment`),
  KEY `fk_Employee_salary1_idx` (`salary_idsalary1`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'321','234','324','123','qwe','32','m','34','ge',12,'123123',1,2),(4,'sesasme','ambot','4','Rome','B','Boy','f','ulol','2121',12,'1222',1,1),(5,'asd','asd','asd','qwe','asd','qwea','k','asd','qqq',23,'2',2,1),(6,'23','23','23','23','23','23','1','23','23',23,'2',1,1),(8,'qweqwe','qweqwe','qweqw','12312','2','234','m','qweqwe','qwe',12,'ambot',2,2),(9,'2323','qwe','123','123','qwe','123','m','qwe','222',2,'2323',2,2),(10,'4-21','10','CDO','Tomas Jubile','T','LIBAGO','M','feb42000','12',12,'HEADKO',5,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaves`
--

DROP TABLE IF EXISTS `leaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leaves` (
  `idleaves` int(11) NOT NULL AUTO_INCREMENT,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `numofdays` varchar(5) DEFAULT NULL,
  `Employee_idEmployee` int(11) NOT NULL,
  PRIMARY KEY (`idleaves`),
  KEY `fk_leaves_Employee1_idx` (`Employee_idEmployee`),
  CONSTRAINT `fk_leaves_Employee1` FOREIGN KEY (`Employee_idEmployee`) REFERENCES `employee` (`idEmployee`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaves`
--

LOCK TABLES `leaves` WRITE;
/*!40000 ALTER TABLE `leaves` DISABLE KEYS */;
INSERT INTO `leaves` VALUES (1,'2019-01-01','2019-02-02','30',5);
/*!40000 ALTER TABLE `leaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `idsalary` int(11) NOT NULL AUTO_INCREMENT,
  `amount` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsalary`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (1,'11111'),(2,'22222'),(3,'3333444'),(4,'343434'),(5,'3434');
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-06 20:09:39
