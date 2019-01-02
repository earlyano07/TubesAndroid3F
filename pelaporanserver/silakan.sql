-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2018 at 12:57 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `silakan`
--
CREATE DATABASE IF NOT EXISTS `silakan` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `silakan`;

-- --------------------------------------------------------

--
-- Table structure for table `kecelakaan`
--

CREATE TABLE IF NOT EXISTS `kecelakaan` (
  `id_kecelakaan` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `deskripsi` text NOT NULL,
  `waktu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lokasi` text NOT NULL,
  `gambar` text,
  `keterangan` text,
  PRIMARY KEY (`id_kecelakaan`),
  KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `kecelakaan`
--

INSERT INTO `kecelakaan` (`id_kecelakaan`, `username`, `deskripsi`, `waktu`, `lokasi`, `gambar`, `keterangan`) VALUES
(1, 'oliv', 'banjir', '2017-11-27 09:56:14', 'malang', 'sasasasa', 'dilaporkan'),
(2, 'oliv', 'kecelakaan truck', '2017-12-02 11:54:28', 'pasuruan', 'asasaa', 'dilaporkan'),
(3, 'nidia', 'pohon tumbang', '2017-12-25 14:43:11', 'Singosari', 'asasasas', 'dilaporkan'),
(5, 'nidia', 'Mobil Srempet', '2018-01-04 01:17:49', 'Malang', NULL, 'lalalalala'),
(10, 'oliv', 'lalal', '2018-01-11 01:03:05', 'jzjzi', NULL, 'hsjsj');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `telp` bigint(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `alamat`, `telp`, `email`) VALUES
(1, 'oliv', 'olivia21', 'Lawang, Malang', 2147483647, 'fiorenolivia@gmail.com'),
(14, 'nidia', 'nidnid', 'banyuwangi', 85636363636, 'nid@gmail.com'),
(15, 'lukita', 'nana', 'malang', 856343634636, 'lukita@gmail.com'),
(16, 'wildhan', 'qwer', 'malang', 8558965825, 'wlwlwl');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kecelakaan`
--
ALTER TABLE `kecelakaan`
  ADD CONSTRAINT `kecelakaan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
