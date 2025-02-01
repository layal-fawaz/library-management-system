-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 01 فبراير 2025 الساعة 13:09
-- إصدار الخادم: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarymanagementsystem`
--

-- --------------------------------------------------------

--
-- بنية الجدول `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `title` text DEFAULT NULL,
  `author` text DEFAULT NULL,
  `isbn` text DEFAULT NULL,
  `publishDate` text DEFAULT NULL,
  `pageCount` text DEFAULT NULL,
  `copyCount` text DEFAULT NULL,
  `publisher` text DEFAULT NULL,
  `bookImagePath` text DEFAULT NULL,
  `catgeory` text DEFAULT NULL,
  `language` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `books`
--

INSERT INTO `books` (`id`, `title`, `author`, `isbn`, `publishDate`, `pageCount`, `copyCount`, `publisher`, `bookImagePath`, `catgeory`, `language`) VALUES
(1, 'java', 'walter savitch', '123Ib', '12/2/2008', '555', '1', 'ssMpub', '/images/book.jpg', 'Coding', 'Eng'),
(2, 'English', 'jhon smith', '78LSH', '3/3/1978', '160', '1', 'eng SSDar', '/images/boo.jpg', 'Languages', 'AR'),
(3, 'beauty&walf', 'nelson nash', '8h1twb', '4/5/2020', '307', '0', 'oberw!', '/images/bb.jpg', 'Novels', 'Eng'),
(27, 'python', 'layal48', '8393', '12/22/3', '2', '2', 'K$WBW', '/images/b.jpg', 'Languages', 'AR'),
(35, 'kotlin2', 'jeeej', '738338', '099', '900', '2', '777', '/images/book.jpg', 'coding4', 'AR'),
(38, 'java3', 'layal', 'djjd339', '8/2/2022', '400', '2', 'lay', '/images/boo.jpg', 'Coding', 'Eng');

-- --------------------------------------------------------

--
-- بنية الجدول `borrowbooksdetails`
--

CREATE TABLE `borrowbooksdetails` (
  `userid` int(11) DEFAULT NULL,
  `username` text DEFAULT NULL,
  `userimage` text DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  `booktitle` text DEFAULT NULL,
  `bookimage` text DEFAULT NULL,
  `status` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `borrowbooksdetails`
--

INSERT INTO `borrowbooksdetails` (`userid`, `username`, `userimage`, `bookid`, `booktitle`, `bookimage`, `status`) VALUES
(3, 'user', '/images/download.png', 2, 'English', '/images/boo.jpg', 'Rejected'),
(3, 'user', '/images/download.png', 3, 'beauty&walf', '/images/bb.jpg', 'Approved'),
(3, 'user', '/images/download.png', 1, 'java', '/images/book.jpg', 'Approved'),
(3, 'user', '/images/download.png', 2, 'English', '/images/boo.jpg', 'Rejected'),
(19, 'lay22', '/images/image.png', 3, 'beauty&walf', '/images/bb.jpg', 'Rejected'),
(19, 'lay22', '/images/image.png', 2, 'English', '/images/boo.jpg', 'Approved'),
(3, 'user', '/images/download.png', 1, 'java', '/images/book.jpg', 'Pending'),
(3, 'user', '/images/download.png', 38, 'java3', '/images/boo.jpg', 'Pending');

-- --------------------------------------------------------

--
-- بنية الجدول `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fullName` text DEFAULT NULL,
  `userName` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `email` text DEFAULT NULL,
  `phoneNumber` text DEFAULT NULL,
  `role` text DEFAULT NULL,
  `profileImagePath` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `users`
--

INSERT INTO `users` (`id`, `fullName`, `userName`, `password`, `email`, `phoneNumber`, `role`, `profileImagePath`) VALUES
(1, 'layal Alhussinei', 'admin', '1', 'layal@gmail.com', '0588899', 'Admin', '/images/images.png'),
(2, 'layal fawaz riyad ', 'lib', '123', '2', '2', 'Libriran', '/images/images (2).jpg'),
(3, 'layal F Alhussinei', 'user', '1', 'ss@gmail.com', '05988439', 'User', '/images/download.png'),
(19, 'layal', 'lay22', '22', 'kkj', '88e8e', 'User', '/images/image.png'),
(33, 'sara', 'ssa27', '2288', 's@gmail.com', '84888', 'User', '/images/491611774.jpg'),
(34, 'layalaal', 'jj', 'jj', 'j', 'j', 'User', '/images/b.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `userName` (`userName`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
