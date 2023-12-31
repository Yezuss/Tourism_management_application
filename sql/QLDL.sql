USE [master]
GO
/****** Object:  Database [QLDL]    Script Date: 11-May-22 9:49:42 PM ******/
CREATE DATABASE [QLDL]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLDL', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QLDL.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QLDL_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QLDL_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QLDL] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLDL].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLDL] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLDL] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLDL] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLDL] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLDL] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLDL] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QLDL] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLDL] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLDL] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLDL] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLDL] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLDL] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLDL] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLDL] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLDL] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QLDL] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLDL] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLDL] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLDL] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLDL] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLDL] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLDL] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLDL] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLDL] SET  MULTI_USER 
GO
ALTER DATABASE [QLDL] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLDL] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLDL] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLDL] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QLDL] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QLDL] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QLDL] SET QUERY_STORE = OFF
GO
USE [QLDL]

GO
/****** Object:  Table [dbo].[HuongDanVien]    Script Date: 11-May-22 9:49:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HuongDanVien](
	[MaHDV] [varchar](20) NOT NULL,
	[Hoten] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NULL,
	[DiaChi] [nvarchar](100) NULL,
	[SDT] [varchar](20) NULL,
 CONSTRAINT [PK_HuongDanVien] PRIMARY KEY CLUSTERED 
(
	[MaHDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11-May-22 9:49:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [varchar](20) NOT NULL,
	[tenKH] [nvarchar](50) NULL,
	[sdt] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[tuoi] [nvarchar](50) NULL,
	[gioiTinh] [bit] NULL,
	[diaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiTour]    Script Date: 11-May-22 9:49:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiTour](
	[maLoaiTour] [varchar](20) NOT NULL,
	[tenLoaiTour] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiTour] PRIMARY KEY CLUSTERED 
(
	[maLoaiTour] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11-May-22 9:49:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [varchar](20) NOT NULL,
	[tenNV] [nvarchar](50) NULL,
	[sdt] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[tuoi] [nvarchar](50) NULL,
	[gioiTinh] [bit] NULL,
	[diaChi] [nvarchar](50) NULL,
	[matkhau] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tour]    Script Date: 11-May-22 9:49:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tour](
	[maTour] [varchar](20) NOT NULL,
	[tenTour] [nvarchar](50) NULL,
	[soluongkhach] [int] NULL,
	[donvitochuc] [nvarchar](50) NULL,
	[trangthai] [nvarchar](50) NULL,
	[lichTrinh] [nvarchar](100) NULL,
	[giaTour] [float] NULL,
	[phuongtien] [nvarchar](50) NULL,
	[maLoaiTour] [varchar](20) NOT NULL,
	[maHDV] [varchar](20) NOT NULL,
	[NgayKH] [date] NULL,
	[NgayKT] [date] NULL,
 CONSTRAINT [PK_Tour] PRIMARY KEY CLUSTERED 
(
	[maTour] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VeTour]    Script Date: 11-May-22 9:49:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VeTour](
	[maVe] [varchar](20) NOT NULL,
	[ngayDatVe] [date] NULL,
	[maNV] [varchar](20) NOT NULL,
	[maKH] [varchar](20) NOT NULL,
	[maTour] [varchar](20) NOT NULL,
 CONSTRAINT [PK_VeTour] PRIMARY KEY CLUSTERED 
(
	[maVe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[HuongDanVien] ([MaHDV], [Hoten], [NgaySinh], [GioiTinh], [DiaChi], [SDT]) VALUES (N'HDV001', N'Huỳnh Phương Nam', CAST(N'1990-01-01' AS Date), N'true', N'Quận 1, Hồ Chí Minh', N'0342980001')
INSERT [dbo].[HuongDanVien] ([MaHDV], [Hoten], [NgaySinh], [GioiTinh], [DiaChi], [SDT]) VALUES (N'HDV002', N'Lê Vân Nam', CAST(N'1990-02-02' AS Date), N'false', N'Quận Tân Bình, Hồ Chí Minh', N'0342980002')
INSERT [dbo].[HuongDanVien] ([MaHDV], [Hoten], [NgaySinh], [GioiTinh], [DiaChi], [SDT]) VALUES (N'HDV003', N'Trần Thế Hùng', CAST(N'1989-01-01' AS Date), N'true', N'Quận Phú Nhuận, Hồ Chí Minh', N'0342980003')
INSERT [dbo].[HuongDanVien] ([MaHDV], [Hoten], [NgaySinh], [GioiTinh], [DiaChi], [SDT]) VALUES (N'HDV004', N'Lê Thi Thu Hà', CAST(N'1989-02-02' AS Date), N'false', N'Quận 9, Hồ Chí Minh', N'0342980004')
INSERT [dbo].[HuongDanVien] ([MaHDV], [Hoten], [NgaySinh], [GioiTinh], [DiaChi], [SDT]) VALUES (N'HDV005', N'Võ Thanh Trúc', CAST(N'1988-01-01' AS Date), N'true', N'Quận 2, Hồ Chí Minh', N'0342980005')
INSERT [dbo].[HuongDanVien] ([MaHDV], [Hoten], [NgaySinh], [GioiTinh], [DiaChi], [SDT]) VALUES (N'HDV006', N'Nguyễn Văn Duy', CAST(N'1988-02-02' AS Date), N'true', N'Quận Gò Vấp, Hồ Chí Minh', N'0342980006')
INSERT [dbo].[HuongDanVien] ([MaHDV], [Hoten], [NgaySinh], [GioiTinh], [DiaChi], [SDT]) VALUES (N'HDV007', N'Nguyễn Trí', CAST(N'1987-01-01' AS Date), N'true', N'Quận 12, Hồ Chí Minh', N'0342980007')
INSERT [dbo].[HuongDanVien] ([MaHDV], [Hoten], [NgaySinh], [GioiTinh], [DiaChi], [SDT]) VALUES (N'HDV008', N'Lê Văn Toàn', CAST(N'1987-02-02' AS Date), N'false', N'Thủ Ðức, Hồ Chí Minh', N'0342980008')
INSERT [dbo].[HuongDanVien] ([MaHDV], [Hoten], [NgaySinh], [GioiTinh], [DiaChi], [SDT]) VALUES (N'HDV009', N'Trần Quốc Đạt', CAST(N'1986-01-01' AS Date), N'true', N'Quận Gò Vấp, Hồ Chí Minh', N'0342980009')
INSERT [dbo].[HuongDanVien] ([MaHDV], [Hoten], [NgaySinh], [GioiTinh], [DiaChi], [SDT]) VALUES (N'HDV010', N'Cao Tự Lâm', CAST(N'1986-02-02' AS Date), N'false', N'Quận Gò Vấp, Hồ Chí Minh', N'0342980010')
GO
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'CD1007', N'Võ Chí Dũng', N'908248324', N'chidungvo113@gmail.com', N'22', 1, N'229/64/30 Tây Thạnh')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'HQ1237', N'Hoàng Quân', N'382099948', N'hoangquantran@gmail.com', N'30', 1, N'1120 Phường 13 Gò Vấp')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'LA1006', N'Lê Lan Anh', N'908775323', N'lelan007@gmail.com', N'18', 0, N'83/43/39 Phạm Văn Bạch')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'NH1012', N'Nguyễn Huy', N'1212470501', N'huynguyen113@gmail.com', N'20', 1, N'Tổ 15, kp3b, phường Thạnh Lộc')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'NV1234', N'tangThanhDuc', N'1asdas', N'qq', N'0983518610', 1, N'1')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'TA1002', N'Phạm Tuấn Anh', N'918500135', N'tuananh111@gmail.com', N'33', 1, N'KDC 39/40 Hồ Đắc Di')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'TB1002', N'Mai Thế Bình', N'984240179', N'binhthe007@gmail.com', N'56', 1, N'22/38 Tống Văn Hên')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'TG2277', N'Trường Giang', N'354988651', N'truonggiangpham@gmail.com', N'40', 1, N'2A/64/8N Nguyễn Văn Trỗi Phú Nhuận')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'TH1001', N'Hồ Thị Hà', N'982290226', N'hothiha123@gmail.com', N'19', 0, N'166/3 Huỳnh Văn Nghệ')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'TH1013', N'Nguyễn Thị Hòa', N'1212304844', N'thihoa101@gmail.com', N'24', 0, N'61/70 đường 59, p14')
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [sdt], [email], [tuoi], [gioiTinh], [diaChi]) VALUES (N'TH1015', N'Trần Thanh Hải', N'1212270580', N'tranthanhhai@gmail.com', N'21', 1, N'Đường 164, Ấp 5, Xã Binh Mỹ')
GO
INSERT [dbo].[LoaiTour] ([maLoaiTour], [tenLoaiTour]) VALUES (N'BASIC', N'Thường')
INSERT [dbo].[LoaiTour] ([maLoaiTour], [tenLoaiTour]) VALUES (N'VIP', N'cao cấp')
GO
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdt], [email], [tuoi], [gioiTinh], [diaChi], [matkhau]) VALUES (N'TD2119', N'Tăng Thanh Đức', N'983518610', N'tangthanhduc113@gmail.com', N'21', 1, N'90 Lê Chân, Tiền Giang', N'admin')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdt], [email], [tuoi], [gioiTinh], [diaChi], [matkhau]) VALUES (N'TK7899', N'Nguyễn Tuấn Kiệt', N'1203438673', N'tuankiet11@gmail.com', N'22', 1, N'Hẻm 266 Lê Trọng Tấn', N'admin')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdt], [email], [tuoi], [gioiTinh], [diaChi], [matkhau]) VALUES (N'TL3010', N'Nguyễn Thành Lâm ', N'919038525', N'thuthilam@gmail.com', N'22', 1, N'5/16 Đồ Sơn', N'admin')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdt], [email], [tuoi], [gioiTinh], [diaChi], [matkhau]) VALUES (N'TN1122', N'Dương Thế Ngọc ', N'982290226', N'thengoc999@gmail.com', N'20', 0, N'108/E5 Cộng Hoà', N'admin')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdt], [email], [tuoi], [gioiTinh], [diaChi], [matkhau]) VALUES (N'TP2134', N'Huỳnh Triệu Phú ', N'1212408421', N'phuhuynh123@gmail.com', N'20', 1, N'Đường số 13, phường Bình Hưng Hoà', N'admin')
GO
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'CM06', N'Cà Mau
', 1, N'SGTour
', N'Còn Trống
', N'Ăn cua Cà Mau 
', 2299000, N'Xe khách
', N'BASIC', N'HDV005', CAST(N'2022-04-30' AS Date), CAST(N'2022-05-03' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'D0013', N'Đà Nẵng
', 1, N'MeKong
', N'Còn Trống
', N'Núi Bà - Chùa Linh Ứng - Cầu Rồng
', 3400000, N'Máy bay - xe khách
', N'BASIC', N'HDV003', CAST(N'2022-05-01' AS Date), CAST(N'2022-05-03' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'DLVT012', N'Đà Lạt - Vũng Tàu
', 1, N'SGTravel
', N'Còn Trống
', N'Ngày 1: Đà Lạt - Ngày 2 : Vũng Tàu
', 3500000, N'Xe khách
', N'BASIC', N'HDV004', CAST(N'2022-05-01' AS Date), CAST(N'2022-05-03' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'HCM011
', N'Hồ Chí Minh
', 4, N'SGTravel
', N'Còn Trống
', N'Nhà thờ Đức Bà - Phố Đi Bộ - Dinh Độc Lập', 2990000, N'Xe khách
', N'BASIC', N'HDV002', CAST(N'2022-04-28' AS Date), CAST(N'2022-05-03' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'HL001
', N'Hạ Long
', 0, N'MeKong
', N'Còn Trống
', N'Lên Du Thuyền ngắm Vịnh Hạ Long
', 4500000, N'Máy bay - xe khách
', N'BASIC', N'HDV001', CAST(N'2022-04-28' AS Date), CAST(N'2022-05-03' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'HN002
', N'Hà Nội
', 2, N'SGTravel
', N'Còn Trống
', N'Dạo Phố Cổ - Ăn kem Tràng Tiền
', 5000000, N'Máy bay - xe khách
', N'VIP', N'HDV010', CAST(N'2022-05-01' AS Date), CAST(N'2022-05-03' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'LC004
', N'Lào Cai
', 3, N'MeKong
', N'Còn Trống
', N'Leo đỉnh Phan-Xi-Păng
', 5999999, N'Máy bay - xe khách
', N'VIP', N'HDV009', CAST(N'2022-04-28' AS Date), CAST(N'2022-05-05' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'MT1
', N'Miền Trung
', 2, N'MeKong
', N'Còn Trống
', N'Phú Yên - Quy Nhơn - Quãng Ngãi
', 6000000, N'Xe khách
', N'VIP', N'HDV008', CAST(N'2022-04-30' AS Date), CAST(N'2022-05-03' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'MT3
', N'Miền Tây
', 0, N'SGTour
', N'Còn Trống
', N'Tiền Giang- Sóc Trăng - Cần Thơ
', 4000000, N'Xe khách
', N'BASIC', N'HDV007', CAST(N'2022-04-28' AS Date), CAST(N'2022-05-03' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'NT006
', N'Nha Trang
', 2, N'SGTour
', N'Còn Trống
', N'Vinpeal Nha Trang
', 5300000, N'Xe khách
', N'VIP', N'HDV006', CAST(N'2022-05-01' AS Date), CAST(N'2022-05-03' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'PQ005
', N'Phú Quốc
', 2, N'SGTravel
', N'Còn Trống
', N'Lặn ngắm san hô
', 3200000, N'Máy bay - xe khách
', N'BASIC', N'HDV005', CAST(N'2022-04-30' AS Date), CAST(N'2022-05-04' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'QNPY003
', N'Quy Nhơn - Phú Yên
', 2, N'SGTravel
', N'Còn Trống
', N'Đặc sản Quy Nhơn
', 2500000, N'Xe khách
', N'BASIC', N'HDV004', CAST(N'2022-04-30' AS Date), CAST(N'2022-05-04' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'SP008
', N'Sapa
', 2, N'SGTravel
', N'Còn Trống
', N'Quảng Trường Sapa
', 7900000, N'Máy bay - xe khách
', N'VIP', N'HDV003', CAST(N'2022-04-28' AS Date), CAST(N'2022-05-04' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'TB009
', N'Tây Bắc
', 2, N'MeKong
', N'Còn Trống
', N'Cao Bằng - Bắc Cạn - Tuyên Quang
', 6500000, N'Máy bay - xe khách
', N'VIP', N'HDV002', CAST(N'2022-04-30' AS Date), CAST(N'2022-05-03' AS Date))
INSERT [dbo].[Tour] ([maTour], [tenTour], [soluongkhach], [donvitochuc], [trangthai], [lichTrinh], [giaTour], [phuongtien], [maLoaiTour], [maHDV], [NgayKH], [NgayKT]) VALUES (N'TN2
', N'Tây Nguyên
', 2, N'SGTour
', N'Còn Trống
', N'Buôn Mê Thuột - Đăklak
', 3000000, N'Xe khách
', N'BASIC', N'HDV001', CAST(N'2022-04-28' AS Date), CAST(N'2022-05-03' AS Date))
GO
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE001KH001', CAST(N'2022-04-13' AS Date), N'TD2119', N'CD1007', N'CM06')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE001KH002', CAST(N'2022-04-13' AS Date), N'TD2119', N'CD1007', N'DLVT012')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE001KH003', CAST(N'2022-04-13' AS Date), N'TD2119', N'HQ1237', N'D0013')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE001KH004', CAST(N'2022-04-13' AS Date), N'TD2119', N'LA1006', N'LC004
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE001KH005', CAST(N'2022-04-13' AS Date), N'TD2119', N'NH1012', N'HL001
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE001KH006', CAST(N'2022-04-13' AS Date), N'TK7899', N'TA1002', N'HL001
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE001KH007', CAST(N'2022-04-13' AS Date), N'TK7899', N'TB1002', N'HN002
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE001KH008', CAST(N'2022-04-13' AS Date), N'TK7899', N'TG2277', N'HN002
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE002KH009', CAST(N'2022-04-13' AS Date), N'TK7899', N'TH1001', N'QNPY003
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE002KH010', CAST(N'2022-04-13' AS Date), N'TK7899', N'TH1013', N'QNPY003
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE002KH011', CAST(N'2022-04-13' AS Date), N'TL3010', N'TH1015', N'MT1
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE002KH012', CAST(N'2022-04-13' AS Date), N'TL3010', N'CD1007', N'MT1
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH013', CAST(N'2022-04-13' AS Date), N'TL3010', N'TA1002', N'TN2
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH014', CAST(N'2022-04-13' AS Date), N'TL3010', N'TB1002', N'TN2
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH015', CAST(N'2022-04-13' AS Date), N'TL3010', N'TB1002', N'MT3
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH016', CAST(N'2022-04-13' AS Date), N'TN1122', N'TB1002', N'MT3
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH017', CAST(N'2022-04-13' AS Date), N'TN1122', N'TG2277', N'LC004
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH018', CAST(N'2022-04-13' AS Date), N'TN1122', N'TG2277', N'LC004
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH019', CAST(N'2022-04-13' AS Date), N'TN1122', N'TG2277', N'PQ005
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH020', CAST(N'2022-04-13' AS Date), N'TN1122', N'TG2277', N'PQ005
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH021', CAST(N'2022-04-13' AS Date), N'TP2134', N'TH1001', N'NT006
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH022', CAST(N'2022-04-13' AS Date), N'TP2134', N'TH1001', N'NT006
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH023', CAST(N'2022-04-13' AS Date), N'TP2134', N'TH1013', N'SP008
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE004KH024', CAST(N'2022-04-13' AS Date), N'TP2134', N'TH1013', N'SP008
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE005KH025', CAST(N'2022-04-13' AS Date), N'TP2134', N'TH1015', N'TB009
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE005KH026', CAST(N'2022-04-13' AS Date), N'TN1122', N'TH1015', N'TB009
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE005KH029', CAST(N'2022-04-13' AS Date), N'TL3010', N'TG2277', N'HCM011
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE005KH030', CAST(N'2022-04-13' AS Date), N'TD2119', N'TH1001', N'HCM011
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE005KH031', CAST(N'2022-04-13' AS Date), N'TD2119', N'CD1007', N'HCM011
')
INSERT [dbo].[VeTour] ([maVe], [ngayDatVe], [maNV], [maKH], [maTour]) VALUES (N'VE005KH032', CAST(N'2022-04-13' AS Date), N'TK7899', N'LA1006', N'HCM011
')
GO
ALTER TABLE [dbo].[Tour]  WITH CHECK ADD  CONSTRAINT [FK_Tour_HuongDanVien] FOREIGN KEY([maHDV])
REFERENCES [dbo].[HuongDanVien] ([MaHDV])
GO
ALTER TABLE [dbo].[Tour] CHECK CONSTRAINT [FK_Tour_HuongDanVien]
GO
ALTER TABLE [dbo].[Tour]  WITH CHECK ADD  CONSTRAINT [FK_Tour_LoaiTour] FOREIGN KEY([maLoaiTour])
REFERENCES [dbo].[LoaiTour] ([maLoaiTour])
GO
ALTER TABLE [dbo].[Tour] CHECK CONSTRAINT [FK_Tour_LoaiTour]
GO
ALTER TABLE [dbo].[VeTour]  WITH CHECK ADD  CONSTRAINT [FK_VeTour_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[VeTour] CHECK CONSTRAINT [FK_VeTour_KhachHang]
GO
ALTER TABLE [dbo].[VeTour]  WITH CHECK ADD  CONSTRAINT [FK_VeTour_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[VeTour] CHECK CONSTRAINT [FK_VeTour_NhanVien]
GO
ALTER TABLE [dbo].[VeTour]  WITH CHECK ADD  CONSTRAINT [FK_VeTour_Tour] FOREIGN KEY([maTour])
REFERENCES [dbo].[Tour] ([maTour])
GO
ALTER TABLE [dbo].[VeTour] CHECK CONSTRAINT [FK_VeTour_Tour]
GO
USE [master]
GO
ALTER DATABASE [QLDL] SET  READ_WRITE 
GO
