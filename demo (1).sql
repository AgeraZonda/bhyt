-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th2 24, 2019 lúc 03:22 AM
-- Phiên bản máy phục vụ: 5.7.23
-- Phiên bản PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `demo`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(40) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_password` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cmnd` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `admin` int(2) NOT NULL,
  `dob` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `dantoc` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hotennguoidamho` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gioitinh` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `quequan` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bhxh_id` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hogiadinh_id` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `cmnd`, `admin`, `dob`, `dantoc`, `hotennguoidamho`, `gioitinh`, `quequan`, `bhxh_id`, `hogiadinh_id`) VALUES
(1, 'duc anh', '81dc9bdb52d04dc20036dbd8313ed055', 'ducanh7897@gmail.com', 1, '', '', '', '', '', '', '0'),
(2, 'baphuong', '81dc9bdb52d04dc20036dbd8313ed055', 'baphuong@gmail.com', 2, '', '', '', '', '', '', '0'),
(3, 'Cong Son', '81dc9bdb52d04dc20036dbd8313ed055', 'congson@gmail.com', 2, '', '', '', '', '', '', '0'),
(29, 'philinhlinh', '81dc9bdb52d04dc20036dbd8313ed055', 'philinh@gmail.com', 2, '', '', '', '', '', '', '0'),
(30, 'duonglinhtrang', '81dc9bdb52d04dc20036dbd8313ed055', 'tranglinh@gmail.com', 2, '', '', '', '', '', '', '0'),
(31, 'hongnhung', '81dc9bdb52d04dc20036dbd8313ed055', 'hongnhung@gmail.com', 2, '', '', '', '', '', '', '0'),
(32, 'handaik97', '0be27b6bc72d6924bfa29a44e38c1035', 'handaik97@gmail.com', 2, '', '', '', '', '', '', '0'),
(33, 'toilahan97', '552114b824ac808236e41ee6a078267a', 'toilahan97@gmail.com', 2, '', '', '', '', '', '', '0'),
(34, 'hailinh', 'e2fc714c4727ee9395f324cd2e7f331f', 'hailinh@gmail.com', 2, '', '', '', '', '', '', '0'),
(35, 'phamhieu', '09d674562084500494ec3d746204a875', 'phamhieu@gmail.com', 2, '', '', '', '', '', '', '0'),
(36, 'quocduy', '81dc9bdb52d04dc20036dbd8313ed055', 'quocduy@gmail.com', 2, '', '', '', '', '', '', '0'),
(37, 'agerazonda', 'e10adc3949ba59abbe56e057f20f883e', 'duybmwpro@gmail.com', 2, '', '', '', '', '', '', '0'),
(38, 'nguyenquocduy', 'e10adc3949ba59abbe56e057f20f883e', 'nguyenquocduy1001@gmail.com', 1, '', '', '', '', '', '', '0'),
(39, 'fjdae', '81dc9bdb52d04dc20036dbd8313ed055', 'fdasfjlaksdf@gmail.com', 2, '', '', '', '', '', '', '0'),
(40, 'Nguyen Van A', '81dc9bdb52d04dc20036dbd8313ed055', '187713039', 2, '', '', '', '', '', '', '0'),
(41, 'Nguyen Van B', 'e10adc3949ba59abbe56e057f20f883e', '187713037', 2, '', '', '', '', '', '', '0'),
(42, 'Nguyen Thi A', '81dc9bdb52d04dc20036dbd8313ed055', '187713040', 2, '', '', '', '', '', '', '0'),
(43, 'Nguyen Quoc Duy', '81dc9bdb52d04dc20036dbd8313ed055', '187713038', 2, '10/01/1998', 'Kinh', 'Dinh thi nhuan', 'Nam', 'Nghe An', '123124', '4234234');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
