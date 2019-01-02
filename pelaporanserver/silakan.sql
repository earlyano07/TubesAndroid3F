-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 02 Jan 2019 pada 18.35
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `silakan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kecelakaan`
--

CREATE TABLE `kecelakaan` (
  `id_kecelakaan` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `deskripsi` text NOT NULL,
  `waktu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lokasi` text NOT NULL,
  `gambar` text,
  `keterangan` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kecelakaan`
--

INSERT INTO `kecelakaan` (`id_kecelakaan`, `username`, `deskripsi`, `waktu`, `lokasi`, `gambar`, `keterangan`) VALUES
(1, 'oliv', 'banjir', '2017-11-27 09:56:14', 'malang', 'sasasasa', 'dilaporkan'),
(2, 'oliv', 'kecelakaan truck', '2017-12-02 11:54:28', 'pasuruan', 'asasaa', 'dilaporkan'),
(3, 'nidia', 'pohon tumbang', '2017-12-25 14:43:11', 'Singosari', 'asasasas', 'dilaporkan'),
(5, 'nidia', 'Mobil Srempet', '2018-01-04 01:17:49', 'Malang', NULL, 'lalalalala'),
(10, 'oliv', 'lalal', '2018-01-11 01:03:05', 'jzjzi', NULL, 'hsjsj'),
(11, 'ear', 'tabrak lari mobil', '2018-12-16 15:53:33', 'blitar', NULL, 'korban meninggal'),
(15, 'angga', '', '2018-10-10 10:15:19', 'hghghg', '2018121808121956', 'kkkkk'),
(16, 'angga', '', '2018-10-10 10:15:19', 'hghghg', '2018121808122150', 'kkkkk'),
(17, 'angga', '', '2018-10-10 10:15:19', 'hghghg', '2018121808122259', 'kkkkk'),
(18, 'angga', '', '2018-10-10 10:15:19', 'hghghg', '2018121808122324.png', 'kkkkk'),
(19, 'angga', '', '2018-10-10 10:15:19', 'hghghg', '201812180812243737.png', 'kkkkk'),
(20, 'angga', 'hghjyghygjhgjmgmjgmjhjuk', '2018-10-10 10:15:19', 'hghghg', '2018121808122727.png', 'kkkkk');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `telp` bigint(100) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `alamat`, `telp`, `email`) VALUES
(1, 'oliv', 'olivia21', 'Lawang, Malang', 2147483647, 'fiorenolivia@gmail.com'),
(14, 'nidia', 'nidnid', 'banyuwangi', 85636363636, 'nid@gmail.com'),
(15, 'lukita', 'nana', 'malang', 856343634636, 'lukita@gmail.com'),
(16, 'wildhan', 'qwer', 'malang', 8558965825, 'wlwlwl'),
(17, 'ear', 'ear', 'bacem', 12336, 'year@gmail.com'),
(19, 'angga', '1313', 'lamongan', 85858585, 'aa@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kecelakaan`
--
ALTER TABLE `kecelakaan`
  ADD PRIMARY KEY (`id_kecelakaan`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kecelakaan`
--
ALTER TABLE `kecelakaan`
  MODIFY `id_kecelakaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `kecelakaan`
--
ALTER TABLE `kecelakaan`
  ADD CONSTRAINT `kecelakaan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
