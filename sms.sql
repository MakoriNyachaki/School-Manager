-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2020 at 07:04 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sms`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `libraryNumber` varchar(25) NOT NULL,
  `ISBN` bigint(11) DEFAULT NULL,
  `Title` varchar(150) NOT NULL,
  `Author` varchar(75) NOT NULL,
  `Genre` varchar(65) NOT NULL,
  `Pages` int(11) NOT NULL,
  `Subject` varchar(50) NOT NULL,
  `Volume` varchar(12) DEFAULT NULL,
  `Edition` varchar(30) DEFAULT NULL,
  `Year` year(4) DEFAULT NULL,
  `Publisher` varchar(100) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `regDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`libraryNumber`, `ISBN`, `Title`, `Author`, `Genre`, `Pages`, `Subject`, `Volume`, `Edition`, `Year`, `Publisher`, `Price`, `regDate`) VALUES
('HL/02/2020', 9780310214595, 'Think Big', 'Benjamin Carson', 'Motivation', 261, 'Others', '', '', 1987, 'Zondervan  Grand Rapids, michigsn 49530', 749, '2020-11-12 20:29:18');

-- --------------------------------------------------------

--
-- Table structure for table `borrow_book`
--

CREATE TABLE `borrow_book` (
  `borrowID` int(11) NOT NULL,
  `admNo` int(11) NOT NULL,
  `Name` varchar(75) NOT NULL,
  `Form` int(3) NOT NULL,
  `Stream` varchar(15) NOT NULL,
  `borrowedDate` datetime NOT NULL,
  `libraryNumber` varchar(25) NOT NULL,
  `ISBN` bigint(11) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `Year` datetime NOT NULL,
  `Publisher` varchar(100) NOT NULL,
  `Availability` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `examregister`
--

CREATE TABLE `examregister` (
  `admNo` int(11) NOT NULL,
  `Name` varchar(75) NOT NULL,
  `Form` int(3) NOT NULL,
  `Stream` varchar(15) NOT NULL,
  `numberofUnits` int(3) NOT NULL,
  `Eng` int(3) DEFAULT NULL,
  `Swa` int(3) DEFAULT NULL,
  `Mat` int(3) DEFAULT NULL,
  `Bio` int(3) DEFAULT NULL,
  `Che` int(3) DEFAULT NULL,
  `Phy` int(3) DEFAULT NULL,
  `His` int(3) DEFAULT NULL,
  `Cre` int(3) DEFAULT NULL,
  `Geo` int(3) DEFAULT NULL,
  `GroupIV` int(3) DEFAULT NULL,
  `GroupV` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `fees`
--

CREATE TABLE `fees` (
  `feesID` int(11) NOT NULL,
  `admNo` int(11) NOT NULL,
  `Name` varchar(75) NOT NULL,
  `form` int(3) NOT NULL,
  `stream` varchar(20) NOT NULL,
  `amountPaid` int(11) NOT NULL,
  `modeofPayment` varchar(20) NOT NULL,
  `transactionNumber` varchar(30) NOT NULL,
  `paidDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fees`
--

INSERT INTO `fees` (`feesID`, `admNo`, `Name`, `form`, `stream`, `amountPaid`, `modeofPayment`, `transactionNumber`, `paidDate`) VALUES
(1, 1, 'A Makori', 1, 'Blue', 60000, 'Bank Deposit', '123456789', '2020-11-12 19:09:11');

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE `parent` (
  `idNo` int(11) NOT NULL,
  `parentName` varchar(100) NOT NULL,
  `parentGender` varchar(6) NOT NULL,
  `parentPhone` int(11) NOT NULL,
  `parentEmail` varchar(65) NOT NULL,
  `parentAddress` int(11) NOT NULL,
  `postalCode` int(11) NOT NULL,
  `Town` varchar(50) NOT NULL,
  `parentDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `parent`
--

INSERT INTO `parent` (`idNo`, `parentName`, `parentGender`, `parentPhone`, `parentEmail`, `parentAddress`, `postalCode`, `Town`, `parentDate`) VALUES
(5723004, 'Kennedy Nyachaki', 'Male', 7164560416, 'nyachakim@gmail.com', 5540, 40200, 'Kiii', '2010-02-10 18:58:07');

-- --------------------------------------------------------

--
-- Table structure for table `return_book`
--

CREATE TABLE `return_book` (
  `returnID` int(11) NOT NULL,
  `admNo` int(11) NOT NULL,
  `Name` varchar(75) NOT NULL,
  `Form` int(3) NOT NULL,
  `Stream` varchar(15) NOT NULL,
  `borrowedDate` datetime NOT NULL,
  `returnDate` datetime NOT NULL,
  `libraryNumber` varchar(25) NOT NULL,
  `ISBN` bigint(11) DEFAULT NULL,
  `Title` varchar(100) NOT NULL,
  `Year` datetime DEFAULT NULL,
  `Publisher` varchar(100) NOT NULL,
  `Availability` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `return_book`
--

INSERT INTO `return_book` (`returnID`, `admNo`, `Name`, `Form`, `Stream`, `borrowedDate`, `returnDate`, `libraryNumber`, `ISBN`, `Title`, `Year`, `Publisher`, `Availability`) VALUES
(4, 1, 'A Makori', 1, 'Blue', '2020-11-12 20:30:11', '2020-11-20 20:30:46', 'hl/02/2020', 9780310214595, 'Think Big', '1987-01-01 00:00:00', 'Zondervan  Grand Rapids, michigsn 49530', 'Clean'),
(5, 1, 'A Makori', 1, 'Blue', '2020-11-13 20:35:01', '2020-11-20 20:35:33', 'hl/02/2020', 9780310214595, 'Think Big', '1987-01-01 00:00:00', 'Zondervan  Grand Rapids, michigsn 49530', 'Clean');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffNo` int(11) NOT NULL,
  `Name` varchar(75) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `DOB` datetime NOT NULL,
  `Category` varchar(50) DEFAULT NULL,
  `jGroup` varchar(15) DEFAULT NULL,
  `Department` varchar(75) DEFAULT NULL,
  `Major` varchar(75) DEFAULT NULL,
  `Role` varchar(100) DEFAULT NULL,
  `Phone` int(11) NOT NULL,
  `Email` varchar(65) DEFAULT NULL,
  `Address` int(11) DEFAULT NULL,
  `pCode` int(11) DEFAULT NULL,
  `Town` varchar(50) NOT NULL,
  `DOR` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffNo`, `Name`, `Gender`, `DOB`, `Category`, `jGroup`, `Department`, `Major`, `Role`, `Phone`, `Email`, `Address`, `pCode`, `Town`, `DOR`) VALUES
(326697, 'Admin', 'Male', '1900-11-05 19:34:44', 'Non-Teaching', 'O', 'Resource and Electricity', 'Computer Science', 'Other Staff', 716250416, 'admin@makotechpro.co.ke', 5465, 40200, 'Kiii', '2020-11-11 19:34:54');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `admNo` int(11) NOT NULL,
  `indexNo` bigint(11) NOT NULL,
  `idNo` int(11) NOT NULL,
  `sName` varchar(25) NOT NULL,
  `otherName` varchar(50) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `DOB` datetime NOT NULL,
  `Photo` mediumblob NOT NULL,
  `Form` int(3) NOT NULL,
  `Stream` varchar(8) NOT NULL,
  `Kcpe` int(11) NOT NULL,
  `targetKcse` varchar(8) NOT NULL,
  `Career` varchar(1000) NOT NULL,
  `DOA` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`admNo`, `indexNo`, `idNo`, `sName`, `otherName`, `Gender`, `DOB`, `Photo`, `Form`, `Stream`, `Kcpe`, `targetKcse`, `Career`, `DOA`) VALUES

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `staffNo` int(11) NOT NULL,
  `userName` varchar(15) NOT NULL,
  `Email` varchar(65) NOT NULL,
  `Phone` int(11) NOT NULL,
  `regDate` datetime NOT NULL,
  `sponsor` varchar(6) NOT NULL,
  `Password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`staffNo`, `userName`, `Email`, `Phone`, `regDate`, `sponsor`, `Password`) VALUES
(326697, 'admin', 'admin@makotechpro.co.ke', 716780416, '2020-11-11 00:00:00', '660PLA', '[[, a, d, m, i, n, @, ?, M, a, k, ]]');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`libraryNumber`),
  ADD KEY `isbn` (`ISBN`),
  ADD KEY `ISBN_2` (`ISBN`);

--
-- Indexes for table `borrow_book`
--
ALTER TABLE `borrow_book`
  ADD PRIMARY KEY (`borrowID`),
  ADD KEY `adm` (`admNo`),
  ADD KEY `lno` (`libraryNumber`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indexes for table `examregister`
--
ALTER TABLE `examregister`
  ADD PRIMARY KEY (`admNo`);

--
-- Indexes for table `fees`
--
ALTER TABLE `fees`
  ADD PRIMARY KEY (`feesID`),
  ADD UNIQUE KEY `transaction` (`transactionNumber`),
  ADD KEY `admNo` (`admNo`);

--
-- Indexes for table `parent`
--
ALTER TABLE `parent`
  ADD PRIMARY KEY (`idNo`),
  ADD UNIQUE KEY `phone` (`parentPhone`),
  ADD UNIQUE KEY `email` (`parentEmail`);

--
-- Indexes for table `return_book`
--
ALTER TABLE `return_book`
  ADD PRIMARY KEY (`returnID`),
  ADD KEY `admret` (`admNo`),
  ADD KEY `lnoret` (`libraryNumber`),
  ADD KEY `ISBN` (`ISBN`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffNo`),
  ADD UNIQUE KEY `sphonr` (`Phone`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`admNo`),
  ADD UNIQUE KEY `indexNo` (`indexNo`),
  ADD UNIQUE KEY `Photo` (`Photo`) USING HASH,
  ADD KEY `indexNo_2` (`indexNo`),
  ADD KEY `idNo` (`idNo`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`staffNo`),
  ADD UNIQUE KEY `uname` (`userName`),
  ADD UNIQUE KEY `umail` (`Email`),
  ADD UNIQUE KEY `uphone` (`Phone`),
  ADD UNIQUE KEY `scode` (`sponsor`),
  ADD UNIQUE KEY `pass` (`Password`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `borrow_book`
--
ALTER TABLE `borrow_book`
  MODIFY `borrowID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `fees`
--
ALTER TABLE `fees`
  MODIFY `feesID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `return_book`
--
ALTER TABLE `return_book`
  MODIFY `returnID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `borrow_book`
--
ALTER TABLE `borrow_book`
  ADD CONSTRAINT `borrow_book_ibfk_1` FOREIGN KEY (`libraryNumber`) REFERENCES `book` (`libraryNumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `borrow_book_ibfk_2` FOREIGN KEY (`admNo`) REFERENCES `student` (`admNo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `examregister`
--
ALTER TABLE `examregister`
  ADD CONSTRAINT `examregister_ibfk_1` FOREIGN KEY (`admNo`) REFERENCES `student` (`admNo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `fees`
--
ALTER TABLE `fees`
  ADD CONSTRAINT `fees_ibfk_1` FOREIGN KEY (`admNo`) REFERENCES `student` (`admNo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `return_book`
--
ALTER TABLE `return_book`
  ADD CONSTRAINT `return_book_ibfk_1` FOREIGN KEY (`admNo`) REFERENCES `student` (`admNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `return_book_ibfk_2` FOREIGN KEY (`libraryNumber`) REFERENCES `book` (`libraryNumber`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`idNo`) REFERENCES `parent` (`idNo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`staffNo`) REFERENCES `staff` (`staffNo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;