-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 14, 2020 lúc 08:24 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `tracnghiemabo`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bodethi`
--

CREATE TABLE `bodethi` (
  `MaCauHoi` int(11) NOT NULL,
  `MaDeThi` int(11) NOT NULL,
  `NgayTao` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `bodethi`
--

INSERT INTO `bodethi` (`MaCauHoi`, `MaDeThi`, `NgayTao`) VALUES
(81, 1, '0000-00-00 00:00:00'),
(82, 1, '0000-00-00 00:00:00'),
(83, 1, '0000-00-00 00:00:00'),
(84, 1, '0000-00-00 00:00:00'),
(85, 1, '0000-00-00 00:00:00'),
(86, 1, '0000-00-00 00:00:00'),
(87, 1, '0000-00-00 00:00:00'),
(88, 1, '0000-00-00 00:00:00'),
(89, 1, '0000-00-00 00:00:00'),
(90, 1, '0000-00-00 00:00:00'),
(91, 1, '0000-00-00 00:00:00'),
(92, 1, '0000-00-00 00:00:00'),
(93, 1, '0000-00-00 00:00:00'),
(94, 1, '0000-00-00 00:00:00'),
(95, 1, '0000-00-00 00:00:00'),
(96, 1, '0000-00-00 00:00:00'),
(97, 1, '0000-00-00 00:00:00'),
(98, 1, '0000-00-00 00:00:00'),
(99, 1, '0000-00-00 00:00:00'),
(100, 1, '0000-00-00 00:00:00'),
(101, 2, '0000-00-00 00:00:00'),
(102, 2, '0000-00-00 00:00:00'),
(103, 2, '0000-00-00 00:00:00'),
(104, 2, '0000-00-00 00:00:00'),
(105, 2, '0000-00-00 00:00:00'),
(106, 2, '0000-00-00 00:00:00'),
(107, 2, '0000-00-00 00:00:00'),
(108, 2, '0000-00-00 00:00:00'),
(109, 2, '0000-00-00 00:00:00'),
(110, 2, '0000-00-00 00:00:00'),
(111, 2, '0000-00-00 00:00:00'),
(112, 2, '0000-00-00 00:00:00'),
(113, 2, '0000-00-00 00:00:00'),
(114, 2, '0000-00-00 00:00:00'),
(115, 2, '0000-00-00 00:00:00'),
(116, 2, '0000-00-00 00:00:00'),
(117, 2, '0000-00-00 00:00:00'),
(118, 2, '0000-00-00 00:00:00'),
(119, 2, '0000-00-00 00:00:00'),
(120, 2, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cauhoi`
--

CREATE TABLE `cauhoi` (
  `MaCauHoi` int(11) NOT NULL,
  `CauHoi` varchar(512) COLLATE utf8_vietnamese_ci NOT NULL,
  `HinhAnh` mediumtext COLLATE utf8_vietnamese_ci NOT NULL,
  `NgayTao` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `NgaySuaCuoi` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `cauhoi`
--

INSERT INTO `cauhoi` (`MaCauHoi`, `CauHoi`, `HinhAnh`, `NgayTao`, `NgaySuaCuoi`) VALUES
(81, 'Điều kiện cân nặng và độ tuổi để tham gia hiến máu là?', '', '0000-00-00 00:00:00', NULL),
(82, 'Nhiệm vụ của bạch cầu là gì?', '', '0000-00-00 00:00:00', NULL),
(83, 'Chức năng của tiểu cầu là gì?', '', '0000-00-00 00:00:00', NULL),
(84, 'Chức năng của hồng cầu là gì?', '', '0000-00-00 00:00:00', NULL),
(85, 'Tổng lượng máu trong cơ thể người trưởng thành bằng?', '', '0000-00-00 00:00:00', NULL),
(86, 'Nhóm máu B ở Việt Nam chiếm khoảng bao nhiêu phần trăm?', '', '0000-00-00 00:00:00', NULL),
(87, 'Đời sống tối đa của hồng cầu là?', '', '0000-00-00 00:00:00', NULL),
(88, 'Nhóm máu A ở Việt Nam chiếm khoảng bao nhiêu phần trăm?', '', '0000-00-00 00:00:00', NULL),
(89, 'Nhóm máu O ở Việt Nam chiếm khoảng bao nhiêu phần trăm?', '', '0000-00-00 00:00:00', NULL),
(90, 'Nhóm máu AB ở Việt Nam chiếm khoảng bao nhiêu phần trăm?', '', '0000-00-00 00:00:00', NULL),
(91, 'Hệ nhóm máu quan trọng nhất là?', '', '0000-00-00 00:00:00', NULL),
(92, 'Sau khi ăn từ 1-2 giờ huyết tương có màu gì?', '', '0000-00-00 00:00:00', NULL),
(93, 'Điểm cần lưu ý khi dán ugo cho người hiến máu?', '', '0000-00-00 00:00:00', NULL),
(94, 'Khoảng  thời gian tối thiếu giữa hai lần hiến máu toàn phần là?', '', '0000-00-00 00:00:00', NULL),
(95, 'Giai đoạn cửa sổ của bệnh viêm gan C là?', '', '0000-00-00 00:00:00', NULL),
(96, 'An toàn truyền máu cần đảm bảo mấy yếu tố?', '', '0000-00-00 00:00:00', NULL),
(97, 'Những lưu ý sau khi hiến máu là gì?', '', '0000-00-00 00:00:00', NULL),
(98, 'Khi xuất hiện chảy máu tại chỗ TNV nên?', '', '0000-00-00 00:00:00', NULL),
(99, 'Đâu không là một bước trong quy trình hiến máu?', '', '0000-00-00 00:00:00', NULL),
(100, 'Tỷ lệ người có nhóm máu Rh- ở Việt Nam là?', '', '0000-00-00 00:00:00', NULL),
(101, 'Phong trào hiến máu tình nguyện ở nước ta được phát động vào năm nào và địa điểm là ở đâu?', '', '0000-00-00 00:00:00', NULL),
(102, 'Người có nhóm máu Rh âm (Rh-) có được nhận máu từ người có nhóm máu Rh dương (Rh+) nhiều lần không? Tại sao?', '', '0000-00-00 00:00:00', NULL),
(103, 'Bạn hãy cho biết khoảng thời gian giữ 2 lần hiến tiểu cầu máu?', '', '0000-00-00 00:00:00', NULL),
(104, 'Quy trình tham gia hiến máu tình nguyện?', '', '0000-00-00 00:00:00', NULL),
(105, 'Máu gồm mấy thành phần? Đó là những thành phần nào?', '', '0000-00-00 00:00:00', NULL),
(106, 'Nhóm máu O có kháng thể trong huyết thanh là?', '', '0000-00-00 00:00:00', NULL),
(107, 'Các tế bào máu gồm?', '', '0000-00-00 00:00:00', NULL),
(108, 'Nhóm máu B có kháng thể trong huyết thanh là ?', '', '0000-00-00 00:00:00', NULL),
(109, 'Nhóm máu A có kháng thể trong huyết thanh là ?', '', '0000-00-00 00:00:00', NULL),
(110, 'Đâu không phải là một hệ máu?', '', '0000-00-00 00:00:00', NULL),
(111, 'Đâu không phải là một tế bào máu?', '', '0000-00-00 00:00:00', NULL),
(112, 'Hồng cầu được sinh ra từ đâu?', '', '0000-00-00 00:00:00', NULL),
(113, 'Nhóm máu Ab có kháng thể huyết thanh là?', '', '0000-00-00 00:00:00', NULL),
(114, 'Nhóm máu AB nhận được máu từ những nhóm máu nào? ', '', '0000-00-00 00:00:00', NULL),
(115, 'Nhóm máu B nhận được máu từ những nhóm máu nào? ', '', '0000-00-00 00:00:00', NULL),
(116, 'Nhóm máu A nhận được máu từ những nhóm máu nào? ', '', '0000-00-00 00:00:00', NULL),
(117, 'Nhóm máu O nhận được máu từ những nhóm máu nào? ', '', '0000-00-00 00:00:00', NULL),
(118, 'Máu sau khi được nhận từ người hiến máu sẽ được làm những xét nghiệm gì?', '', '0000-00-00 00:00:00', NULL),
(119, 'Có mấy nguồn cho máu?', '', '0000-00-00 00:00:00', NULL),
(120, 'Nguồn cho máu an toàn nhất là từ đâu?', '', '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dapan`
--

CREATE TABLE `dapan` (
  `MaDapAn` int(11) NOT NULL,
  `DapAn` varchar(512) COLLATE utf8_vietnamese_ci NOT NULL,
  `IsTrue` bit(1) NOT NULL,
  `MaCauHoi` int(11) NOT NULL,
  `NgayTao` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `NgaySuaCuoi` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `dapan`
--

INSERT INTO `dapan` (`MaDapAn`, `DapAn`, `IsTrue`, `MaCauHoi`, `NgayTao`, `NgaySuaCuoi`) VALUES
(1, 'Nam (42kg trở lên và 20 - 60 tuổi), Nữ (45kg trở lên và 20-60 tuổi)', b'0', 81, '0000-00-00 00:00:00', NULL),
(2, 'Nam. Nữ (từ 42kg trở lên và 18 - 60 tuổi)', b'0', 81, '0000-00-00 00:00:00', NULL),
(3, 'Nam (từ 45kg trở lên), Nữ (từ 42kg trở lên) và cả Nam Nữ đều từ 18 - 60 tuổi)', b'1', 81, '0000-00-00 00:00:00', NULL),
(4, 'Nam (từ 45kg trở lên và 18 - 60 tuổi), Nữ (từ 42kg trở lên và 18 - 55 tuổi)', b'0', 81, '0000-00-00 00:00:00', NULL),
(5, 'Vận chuyển Oxi', b'0', 82, '0000-00-00 00:00:00', NULL),
(6, 'Bảo vệ cơ thể', b'1', 82, '0000-00-00 00:00:00', NULL),
(7, 'Tham gia quá trình đông máu', b'0', 82, '0000-00-00 00:00:00', NULL),
(8, 'Vận chuyển chất dinh dưỡng', b'0', 82, '0000-00-00 00:00:00', NULL),
(9, 'Vận chuyển Oxi', b'0', 83, '0000-00-00 00:00:00', NULL),
(10, 'Bảo vệ cơ thể', b'0', 83, '0000-00-00 00:00:00', NULL),
(11, 'Tham gia quá trình đông máu', b'1', 83, '0000-00-00 00:00:00', NULL),
(12, 'Vận chuyển chất dinh dưỡng', b'0', 83, '0000-00-00 00:00:00', NULL),
(13, 'Vận chuyển Oxi', b'1', 84, '0000-00-00 00:00:00', NULL),
(14, 'Bảo vệ cơ thể', b'0', 84, '0000-00-00 00:00:00', NULL),
(15, 'Tham gia quá trình đông máu', b'0', 84, '0000-00-00 00:00:00', NULL),
(16, 'Vận chuyển chất dinh dưỡng', b'0', 84, '0000-00-00 00:00:00', NULL),
(17, '1/3 trọng lượng cơ thể', b'1', 85, '0000-00-00 00:00:00', NULL),
(18, '1/4 trọng lượng cơ thể', b'0', 85, '0000-00-00 00:00:00', NULL),
(19, 'C.2/5 trọng lượng cơ thể', b'0', 85, '0000-00-00 00:00:00', NULL),
(20, '3/5 trọng lượng cơ thể', b'0', 85, '0000-00-00 00:00:00', NULL),
(21, 'Khoảng 45%', b'0', 86, '0000-00-00 00:00:00', NULL),
(22, 'Khoảng 40%', b'0', 86, '0000-00-00 00:00:00', NULL),
(23, 'Khoảng 35%', b'0', 86, '0000-00-00 00:00:00', NULL),
(24, 'Khoảng 30%', b'1', 86, '0000-00-00 00:00:00', NULL),
(25, '90 ngày', b'0', 87, '0000-00-00 00:00:00', NULL),
(26, '100 ngày ', b'0', 87, '0000-00-00 00:00:00', NULL),
(27, '115 ngày', b'0', 87, '0000-00-00 00:00:00', NULL),
(28, '120 ngày', b'1', 87, '0000-00-00 00:00:00', NULL),
(29, 'Khoảng 45%', b'0', 88, '0000-00-00 00:00:00', NULL),
(30, 'Khoảng 20%', b'1', 88, '0000-00-00 00:00:00', NULL),
(31, 'Khoảng 35%', b'0', 88, '0000-00-00 00:00:00', NULL),
(32, 'Khoảng 40%', b'0', 88, '0000-00-00 00:00:00', NULL),
(33, 'Khoảng 45%', b'0', 89, '0000-00-00 00:00:00', NULL),
(34, 'Khoảng 25%', b'0', 89, '0000-00-00 00:00:00', NULL),
(35, 'Khoảng 40%', b'1', 89, '0000-00-00 00:00:00', NULL),
(36, 'Khoảng 35%', b'0', 89, '0000-00-00 00:00:00', NULL),
(37, 'Khoảng 25%', b'0', 90, '0000-00-00 00:00:00', NULL),
(38, 'Khoảng 5%', b'1', 90, '0000-00-00 00:00:00', NULL),
(39, 'Khoảng 15%', b'0', 90, '0000-00-00 00:00:00', NULL),
(40, 'Khoảng 35%', b'0', 90, '0000-00-00 00:00:00', NULL),
(41, 'Hệ nhóm máu ABO và hệ nhóm máu Rh', b'1', 91, '0000-00-00 00:00:00', NULL),
(42, 'Hệ nhóm máu ABO và hệ nhóm máu Rh+', b'0', 91, '0000-00-00 00:00:00', NULL),
(43, 'Hệ nhóm máu ABO và hệ nhóm máu Rh-', b'0', 91, '0000-00-00 00:00:00', NULL),
(44, 'Hệ nhóm máu ABO và hệ nhóm máu Kell, Rh', b'0', 91, '0000-00-00 00:00:00', NULL),
(45, 'Màu vàng chanh', b'1', 92, '0000-00-00 00:00:00', NULL),
(46, 'Màu đục', b'0', 92, '0000-00-00 00:00:00', NULL),
(47, 'Màu vàng', b'0', 92, '0000-00-00 00:00:00', NULL),
(48, 'Màu cam', b'0', 92, '0000-00-00 00:00:00', NULL),
(49, ' Dán không quá chật và dán ngang, không tiếp xúc với phần bông', b'1', 93, '0000-00-00 00:00:00', NULL),
(50, 'Dán không quá chật và dán dọc, không tiếp xúc với phần bông', b'0', 93, '0000-00-00 00:00:00', NULL),
(51, 'Cả a và B đều đúng', b'0', 93, '0000-00-00 00:00:00', NULL),
(52, 'Cả A và B đều sai', b'0', 93, '0000-00-00 00:00:00', NULL),
(53, '14 đến 30 ngày', b'0', 94, '0000-00-00 00:00:00', NULL),
(54, '2 tuần', b'0', 94, '0000-00-00 00:00:00', NULL),
(55, '84 ngày', b'1', 94, '0000-00-00 00:00:00', NULL),
(56, '6 tháng', b'0', 94, '0000-00-00 00:00:00', NULL),
(57, '10 tuần', b'0', 95, '0000-00-00 00:00:00', NULL),
(58, '12 tuần', b'1', 95, '0000-00-00 00:00:00', NULL),
(59, '15 tuần', b'0', 95, '0000-00-00 00:00:00', NULL),
(60, '16 tuần', b'0', 95, '0000-00-00 00:00:00', NULL),
(61, '2 yếu tố: An toàn cho người hiến máu; An toàn cho người nhận máu', b'0', 96, '0000-00-00 00:00:00', NULL),
(62, '2 yếu tố: An toàn cho người hiến máu; An toàn cho nhân viên làm công tác truyền máu', b'0', 96, '0000-00-00 00:00:00', NULL),
(63, '3 yếu tố: An toàn cho người hiến máu, an toàn cho người nhận máu và an toàn cho nhân viên làm công tác truyền máu.', b'1', 96, '0000-00-00 00:00:00', NULL),
(64, '1 yếu tố: An toàn cho người nhận máu', b'0', 96, '0000-00-00 00:00:00', NULL),
(65, 'Không cần kiêng gì cả cứ như khi chưa hiến máu.', b'0', 97, '0000-00-00 00:00:00', NULL),
(66, 'Hạn chế rượu bia, không vận động mạnh từ 1- 2 ngày sau hiến máu.', b'0', 97, '0000-00-00 00:00:00', NULL),
(67, 'Ăn uống đầy đủ, ngủ đủ giấc không thức khuya có thể dung  thêm các sản phẩm tốt cho máu.', b'0', 97, '0000-00-00 00:00:00', NULL),
(68, 'Cả B và C đều đúng', b'1', 97, '0000-00-00 00:00:00', NULL),
(69, 'Gập tay người hiến máu lại, thay bông băng', b'0', 98, '0000-00-00 00:00:00', NULL),
(70, 'Gập tay người hiến máu lại cho không chảy máu nữa và không cần thay bông băng', b'0', 98, '0000-00-00 00:00:00', NULL),
(71, 'Giơ cao tay người hiến máu, thay bông băng', b'1', 98, '0000-00-00 00:00:00', NULL),
(72, 'Gọi bác sĩ ', b'0', 98, '0000-00-00 00:00:00', NULL),
(73, 'Khám lâm sàng', b'0', 99, '0000-00-00 00:00:00', NULL),
(74, 'Trà đường', b'1', 99, '0000-00-00 00:00:00', NULL),
(75, 'Xét nghiệm máu', b'0', 99, '0000-00-00 00:00:00', NULL),
(76, 'Đăng ký', b'0', 99, '0000-00-00 00:00:00', NULL),
(77, '0,5%', b'0', 100, '0000-00-00 00:00:00', NULL),
(78, '0,6%', b'0', 100, '0000-00-00 00:00:00', NULL),
(79, '0,7%', b'1', 100, '0000-00-00 00:00:00', NULL),
(80, '0,8%', b'0', 100, '0000-00-00 00:00:00', NULL),
(81, 'Năm 1994, mở đầu là ngày hiến máu tình nguyện của sinh viên ĐH Y Hà nội ngày 24/01/1994.', b'1', 101, '0000-00-00 00:00:00', NULL),
(82, 'Năm 1995, mở đầu là ngày hiến máu tình nguyện của sinh viên ĐH Y Hà nội ngày 24/01/1995', b'0', 101, '0000-00-00 00:00:00', NULL),
(83, 'Năm 1994, mở đầu là ngày hiến máu tình nguyện của sinh viên ĐH Y Hà nội ngày 24/02/1994', b'0', 101, '0000-00-00 00:00:00', NULL),
(84, 'Năm 1995, mở đầu là ngày hiến máu tình nguyện của sinh viên ĐH Y Hà nội ngày 24/02/1995', b'0', 101, '0000-00-00 00:00:00', NULL),
(85, 'Có. Vì nhóm máu Rh- hiếm nên có sự đặc biệt hơn.', b'0', 102, '0000-00-00 00:00:00', NULL),
(86, 'Không. Vì nhóm máu Rh- hiếm nên hạn chế hiến máu.', b'1', 102, '0000-00-00 00:00:00', NULL),
(87, 'Không. Chỉ nhận được lần đầu tiên vì lúc đó chưa có kháng thể chống lại Rh dương.', b'0', 102, '0000-00-00 00:00:00', NULL),
(88, 'Nhóm máu Rh- không thể truyền được cho nhóm máu Rh+', b'0', 102, '0000-00-00 00:00:00', NULL),
(89, '2 tuần', b'1', 103, '0000-00-00 00:00:00', NULL),
(90, '3 tuần', b'0', 103, '0000-00-00 00:00:00', NULL),
(91, '4 tuần', b'0', 103, '0000-00-00 00:00:00', NULL),
(92, '1 tuần', b'0', 103, '0000-00-00 00:00:00', NULL),
(93, 'Đăng kí -> xét nghiệm máu -> khám lâm sàng -> hiến máu -> nghỉ ngơi, ăn nhẹ và nhận quà', b'0', 104, '0000-00-00 00:00:00', NULL),
(94, 'Khám lâm sàng -> Đăng kí -> Hiến máu -> Xét nghiệm máu -> Nghỉ ngơi, ăn nhẹ và nhận quà.', b'0', 104, '0000-00-00 00:00:00', NULL),
(95, 'Khám lâm sàng -> Đăng kí -> Xét nghiệm máu -> Hiến máu –> Nghỉ ngơi, ăn nhẹ và nhận quà', b'0', 104, '0000-00-00 00:00:00', NULL),
(96, 'Đăng kí -> Khám lâm sàng -> Xét nghiệm máu -> Hiến máu -> Nghỉ ngơi, ăn nhẹ và nhận quà.', b'1', 104, '0000-00-00 00:00:00', NULL),
(97, '3 thành phần: Hồng cầu, tiểu cầu, bạch cầu', b'0', 105, '0000-00-00 00:00:00', NULL),
(98, '4 thành phần: Hồng cầu, tiểu cầu, bạch cầu, huyết tương', b'0', 105, '0000-00-00 00:00:00', NULL),
(99, '2 thành phần : các tế bào ( phần hữu hình) gồm hồng cầu, tiểu cầu, bạch cầu; huyết tương( phần vô hình).', b'1', 105, '0000-00-00 00:00:00', NULL),
(100, '3 thành phần: Hồng cầu, tiểu cầu, huyết tương.', b'0', 105, '0000-00-00 00:00:00', NULL),
(101, 'Chống A và chống B', b'1', 106, '0000-00-00 00:00:00', NULL),
(102, 'Chống AB và chống B', b'0', 106, '0000-00-00 00:00:00', NULL),
(103, 'Chống O ', b'0', 106, '0000-00-00 00:00:00', NULL),
(104, 'Chống AB và chống A', b'0', 106, '0000-00-00 00:00:00', NULL),
(105, 'Hồng cầu và tiểu cầu', b'0', 107, '0000-00-00 00:00:00', NULL),
(106, 'Hồng cầu và huyết tương', b'0', 107, '0000-00-00 00:00:00', NULL),
(107, 'Hồng cầu, tiểu cầu và bạch cầu', b'1', 107, '0000-00-00 00:00:00', NULL),
(108, 'Bạch cầu và huyết tương', b'0', 107, '0000-00-00 00:00:00', NULL),
(109, 'Chống A và chống B', b'0', 108, '0000-00-00 00:00:00', NULL),
(110, 'Chống AB và chống B', b'0', 108, '0000-00-00 00:00:00', NULL),
(111, 'Chống A', b'1', 108, '0000-00-00 00:00:00', NULL),
(112, 'Chống O và chống B', b'0', 108, '0000-00-00 00:00:00', NULL),
(113, 'Chống A và chống B', b'0', 109, '0000-00-00 00:00:00', NULL),
(114, 'Chống B', b'1', 109, '0000-00-00 00:00:00', NULL),
(115, 'Chống A', b'0', 109, '0000-00-00 00:00:00', NULL),
(116, 'Chống O và chống B', b'0', 109, '0000-00-00 00:00:00', NULL),
(117, 'Huyết tương', b'1', 110, '0000-00-00 00:00:00', NULL),
(118, 'Hồng cầu ', b'0', 110, '0000-00-00 00:00:00', NULL),
(119, 'Tiểu cầu', b'0', 110, '0000-00-00 00:00:00', NULL),
(120, 'Bạch cầu', b'0', 110, '0000-00-00 00:00:00', NULL),
(121, 'ABO', b'0', 111, '0000-00-00 00:00:00', NULL),
(122, 'Kell', b'0', 111, '0000-00-00 00:00:00', NULL),
(123, 'M', b'0', 111, '0000-00-00 00:00:00', NULL),
(124, 'H', b'1', 111, '0000-00-00 00:00:00', NULL),
(125, 'Tủy xương', b'1', 112, '0000-00-00 00:00:00', NULL),
(126, 'Từ quá trình trao đổi chất hấp thụ', b'0', 112, '0000-00-00 00:00:00', NULL),
(127, 'Từ quá trình vận chuyển Oxi', b'0', 112, '0000-00-00 00:00:00', NULL),
(128, 'Từ tủy xương, và thêm từ quá trình vận chuyển Oxi', b'0', 112, '0000-00-00 00:00:00', NULL),
(129, 'Chống A và chống B', b'0', 113, '0000-00-00 00:00:00', NULL),
(130, 'Chống AB và chống B', b'0', 113, '0000-00-00 00:00:00', NULL),
(131, 'Không có kháng thể.', b'1', 113, '0000-00-00 00:00:00', NULL),
(132, 'Chống O và chống B', b'0', 113, '0000-00-00 00:00:00', NULL),
(133, 'Nhóm AB', b'0', 114, '0000-00-00 00:00:00', NULL),
(134, 'Nhóm O', b'0', 114, '0000-00-00 00:00:00', NULL),
(135, 'Nhóm A, B, O, AB', b'1', 114, '0000-00-00 00:00:00', NULL),
(136, 'Nhóm A, B', b'0', 114, '0000-00-00 00:00:00', NULL),
(137, 'Nhóm AB', b'0', 115, '0000-00-00 00:00:00', NULL),
(138, 'Nhóm B, O', b'1', 115, '0000-00-00 00:00:00', NULL),
(139, 'Nhóm A, B, O, AB', b'0', 115, '0000-00-00 00:00:00', NULL),
(140, 'Nhóm A, B', b'0', 115, '0000-00-00 00:00:00', NULL),
(141, 'Nhóm A, O', b'1', 116, '0000-00-00 00:00:00', NULL),
(142, 'Nhóm B, O', b'0', 116, '0000-00-00 00:00:00', NULL),
(143, 'Nhóm A, B, O, AB', b'0', 116, '0000-00-00 00:00:00', NULL),
(144, 'Nhóm A, B', b'0', 116, '0000-00-00 00:00:00', NULL),
(145, 'Nhóm A, O', b'0', 117, '0000-00-00 00:00:00', NULL),
(146, 'Nhóm B, O', b'0', 117, '0000-00-00 00:00:00', NULL),
(147, 'Nhóm A, B, O, AB', b'0', 117, '0000-00-00 00:00:00', NULL),
(148, 'Nhóm O', b'1', 117, '0000-00-00 00:00:00', NULL),
(149, 'Kiểm tra nhóm máu(hệ ABO, hệ Rh), HIV, virus viêm gan B, virus viêm gan C, giang mai, sốt rét.', b'1', 118, '0000-00-00 00:00:00', NULL),
(150, 'Kiểm tra nhóm máu(hệ ABO, hệ Rh), virus viêm gan B, virus viêm gan C, giang mai, sốt rét.', b'0', 118, '0000-00-00 00:00:00', NULL),
(151, 'Kiểm tra nhóm máu(hệ ABO, hệ Rh), HIV, giang mai, sốt rét.', b'0', 118, '0000-00-00 00:00:00', NULL),
(152, 'Kiểm tra nhóm máu(hệ ABO, hệ Rh), HIV, virus viêm gan B, virus viêm gan C.', b'0', 118, '0000-00-00 00:00:00', NULL),
(153, '4', b'1', 119, '0000-00-00 00:00:00', NULL),
(154, '3', b'0', 119, '0000-00-00 00:00:00', NULL),
(155, '2', b'0', 119, '0000-00-00 00:00:00', NULL),
(156, '5', b'0', 119, '0000-00-00 00:00:00', NULL),
(157, 'Người cho máu chuyên nghiệp.', b'0', 120, '0000-00-00 00:00:00', NULL),
(158, 'Người hiến máu tự thân', b'0', 120, '0000-00-00 00:00:00', NULL),
(159, 'Người hiến máu tình nguyện.', b'1', 120, '0000-00-00 00:00:00', NULL),
(160, 'Người nhà cho máu', b'0', 120, '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dethi`
--

CREATE TABLE `dethi` (
  `MaDeThi` int(11) NOT NULL,
  `TenDeThi` varchar(256) COLLATE utf8_vietnamese_ci NOT NULL,
  `NgayTao` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `NgaySuaCuoi` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `dethi`
--

INSERT INTO `dethi` (`MaDeThi`, `TenDeThi`, `NgayTao`, `NgaySuaCuoi`) VALUES
(1, 'Đề số 001', '0000-00-00 00:00:00', NULL),
(2, 'Đề số 002', '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ketqua`
--

CREATE TABLE `ketqua` (
  `MaKetQua` int(11) NOT NULL,
  `HoTen` varchar(256) COLLATE utf8_vietnamese_ci NOT NULL,
  `Diem` int(11) NOT NULL,
  `MaDeThi` int(11) NOT NULL,
  `NgayTao` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `NgaySuaCuoi` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `ketqua`
--

INSERT INTO `ketqua` (`MaKetQua`, `HoTen`, `Diem`, `MaDeThi`, `NgayTao`, `NgaySuaCuoi`) VALUES
(2, 'ngọc', 0, 1, '0000-00-00 00:00:00', NULL),
(3, 'Ngọc', 150, 1, '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaTaiKhoan` int(11) NOT NULL,
  `TenTaiKhoan` varchar(256) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MatKhau` varchar(256) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NgayTao` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp(),
  `NgaySuaCuoi` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`MaTaiKhoan`, `TenTaiKhoan`, `MatKhau`, `NgayTao`, `NgaySuaCuoi`) VALUES
(1, 'admin', '013745cb28a00b0d8f27f66dad76a7e560584f0a2cbb8f21c6daa9982e2684bfcc9a25e5f7c708e42dcc6970f803b9da434d7755aaac180cbf6c530ce8445f41', '0000-00-00 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc đóng vai cho view `vbaithi`
-- (See below for the actual view)
--
CREATE TABLE `vbaithi` (
`MaDeThi` int(11)
,`MaCauHoi` int(11)
,`CauHoi` varchar(512)
,`HinhAnh` mediumtext
);

-- --------------------------------------------------------

--
-- Cấu trúc cho view `vbaithi`
--
DROP TABLE IF EXISTS `vbaithi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vbaithi`  AS  select `bodethi`.`MaDeThi` AS `MaDeThi`,`cauhoi`.`MaCauHoi` AS `MaCauHoi`,`cauhoi`.`CauHoi` AS `CauHoi`,`cauhoi`.`HinhAnh` AS `HinhAnh` from (`bodethi` join `cauhoi` on(`bodethi`.`MaCauHoi` = `cauhoi`.`MaCauHoi`)) ;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bodethi`
--
ALTER TABLE `bodethi`
  ADD PRIMARY KEY (`MaDeThi`,`MaCauHoi`) USING BTREE,
  ADD KEY `fk_BoDeThi_CauHoi_1` (`MaCauHoi`) USING BTREE;

--
-- Chỉ mục cho bảng `cauhoi`
--
ALTER TABLE `cauhoi`
  ADD PRIMARY KEY (`MaCauHoi`) USING BTREE;

--
-- Chỉ mục cho bảng `dapan`
--
ALTER TABLE `dapan`
  ADD PRIMARY KEY (`MaDapAn`) USING BTREE,
  ADD KEY `fk_dapan_cauhoi_1` (`MaCauHoi`) USING BTREE;

--
-- Chỉ mục cho bảng `dethi`
--
ALTER TABLE `dethi`
  ADD PRIMARY KEY (`MaDeThi`) USING BTREE;

--
-- Chỉ mục cho bảng `ketqua`
--
ALTER TABLE `ketqua`
  ADD PRIMARY KEY (`MaKetQua`) USING BTREE,
  ADD KEY `fk_ketqua_dethi_1` (`MaDeThi`) USING BTREE;

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaTaiKhoan`) USING BTREE;

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cauhoi`
--
ALTER TABLE `cauhoi`
  MODIFY `MaCauHoi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;

--
-- AUTO_INCREMENT cho bảng `dapan`
--
ALTER TABLE `dapan`
  MODIFY `MaDapAn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=161;

--
-- AUTO_INCREMENT cho bảng `dethi`
--
ALTER TABLE `dethi`
  MODIFY `MaDeThi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `ketqua`
--
ALTER TABLE `ketqua`
  MODIFY `MaKetQua` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `MaTaiKhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `bodethi`
--
ALTER TABLE `bodethi`
  ADD CONSTRAINT `fk_BoDeThi_CauHoi_1` FOREIGN KEY (`MaCauHoi`) REFERENCES `cauhoi` (`MaCauHoi`),
  ADD CONSTRAINT `fk_BoDeThi_DeThi_1` FOREIGN KEY (`MaDeThi`) REFERENCES `dethi` (`MaDeThi`);

--
-- Các ràng buộc cho bảng `dapan`
--
ALTER TABLE `dapan`
  ADD CONSTRAINT `fk_dapan_cauhoi_1` FOREIGN KEY (`MaCauHoi`) REFERENCES `cauhoi` (`MaCauHoi`);

--
-- Các ràng buộc cho bảng `ketqua`
--
ALTER TABLE `ketqua`
  ADD CONSTRAINT `fk_ketqua_dethi_1` FOREIGN KEY (`MaDeThi`) REFERENCES `dethi` (`MaDeThi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
