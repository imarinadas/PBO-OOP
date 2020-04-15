-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Apr 2020 pada 02.48
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kuisperpus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE `anggota` (
  `nis` varchar(9) NOT NULL,
  `nmsiswa` varchar(20) NOT NULL,
  `ttl` date NOT NULL,
  `jk` varchar(10) NOT NULL,
  `agama` varchar(10) NOT NULL,
  `tdaftar` date NOT NULL,
  `berlaku` date NOT NULL,
  `kelas` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`nis`, `nmsiswa`, `ttl`, `jk`, `agama`, `tdaftar`, `berlaku`, `kelas`) VALUES
('121', 'Aga', '2000-12-20', 'Laki-Laki', 'Katolik', '2020-12-20', '2021-12-20', 'E'),
('122', 'Ayu', '2000-02-02', 'Perempuan', 'Islam', '2020-01-01', '2022-02-02', 'C');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `kdbuku` varchar(10) NOT NULL,
  `nmbuku` varchar(20) NOT NULL,
  `nmpengarang` varchar(20) NOT NULL,
  `nmpenerbit` varchar(20) NOT NULL,
  `thnterbit` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`kdbuku`, `nmbuku`, `nmpengarang`, `nmpenerbit`, `thnterbit`) VALUES
('A0001', 'Buku Cerita', 'Song Geu-rim', 'Gambar Media', '2001'),
('A0002', 'Dongeng Katak', 'penulissatu', 'penerbitsatu', '2007'),
('A0003', 'buku tulis', 'penulisdua', 'penerbit terang', '2020');

-- --------------------------------------------------------

--
-- Struktur dari tabel `karyawan`
--

CREATE TABLE `karyawan` (
  `nik` varchar(20) NOT NULL,
  `nmkaryawan` varchar(20) NOT NULL,
  `jk` varchar(10) NOT NULL,
  `golongan` varchar(10) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `tunjangan` varchar(10) NOT NULL,
  `jmlgaji` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `karyawan`
--

INSERT INTO `karyawan` (`nik`, `nmkaryawan`, `jk`, `golongan`, `jabatan`, `tunjangan`, `jmlgaji`) VALUES
('122', 'ara', 'Perempuan', '5', 'honorer', '200000', '650000'),
('123', 'ada', 'Laki-Laki', '2', 'supervisor', '500000', '900000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE `peminjaman` (
  `nopinjam` varchar(10) NOT NULL,
  `nis` varchar(9) NOT NULL,
  `kdbuku` varchar(10) NOT NULL,
  `tglpinjam` date NOT NULL,
  `tglkembali` date NOT NULL,
  `lmpinjam` int(5) NOT NULL,
  `denda` int(10) NOT NULL,
  `nik` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`nopinjam`, `nis`, `kdbuku`, `tglpinjam`, `tglkembali`, `lmpinjam`, `denda`, `nik`) VALUES
('1', '122', 'A0001', '2020-02-20', '2020-03-20', 0, 0, '122');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`nis`);

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`kdbuku`);

--
-- Indeks untuk tabel `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`nik`);

--
-- Indeks untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`nopinjam`),
  ADD KEY `cons_siswa` (`nis`),
  ADD KEY `cons_buku` (`kdbuku`),
  ADD KEY `cons_karyawan` (`nik`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `cons_buku` FOREIGN KEY (`kdbuku`) REFERENCES `buku` (`kdbuku`),
  ADD CONSTRAINT `cons_karyawan` FOREIGN KEY (`nik`) REFERENCES `karyawan` (`nik`),
  ADD CONSTRAINT `cons_siswa` FOREIGN KEY (`nis`) REFERENCES `anggota` (`nis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
