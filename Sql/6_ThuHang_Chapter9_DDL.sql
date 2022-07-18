use master;
go
if exists
(select * from sysdatabases where name='DOIBONG') 
	Drop database DOIBONG;
go
Create database DOIBONG; 
go
use DOIBONG;
go

Create table DOIBONG(
MaDoi int primary key,
TenDoiBong nvarchar(50));

Create table VITRI(
	MaViTri int primary key, 
	TenViTri nvarchar(50)
	);

Create table CAUTHU(
	MaCauThu int primary key, 
	HoTen nvarchar(50), 
	SoAo nvarchar(50), 
MaDoi int references DOIBONG(MaDoi),
MaViTri int references VITRI(MaViTri));

Create table DOIDAU(
MaDoiDau int primary key, 
TenDoiDau nvarchar(50), 
DiaChi nvarchar(50), 
SoDienThoai nvarchar(12));

Create table TRANDAU(
MaTranDau int primary key, 
Ngay date, 
Thoigian time, 
DiaDiem nvarchar(50), 
MaDoiDau int references DOIDAU(MaDoiDau));

Create table THAMGIA(
MaCauThu int references CAUTHU(MaCauThu), 
MaTranDau int references TRANDAU(MaTranDau), 
SoBan int
constraint PK_THAMGIA primary key(MaCauThu, MaTranDau)) ;

--chèn thông tin vào bảng
insert into VITRI(MaViTri, TenViTri)values(1,'Tien dao')
insert into VITRI(MaViTri, TenViTri)values(2,'Tien Ve')
insert into VITRI(MaViTri, TenViTri)values(3,'Hau Ve')

insert into DOIBONG(MaDoi, TenDoiBong)values(1,'Ha Noi')
insert into DOIBONG(MaDoi, TenDoiBong)values(2,'Hai Phong')
insert into DOIBONG(MaDoi, TenDoiBong)values(3,'Sai Gon')

insert into CAUTHU(MaCauThu, HoTen, SoAo, MaDoi, MaViTri)
			values(1,'Messi', '7', 3, 1);
insert into CAUTHU(MaCauThu, HoTen, SoAo, MaDoi, MaViTri)
			values(2,'Van Thanh', '9', 2, 2);
insert into CAUTHU(MaCauThu, HoTen, SoAo, MaDoi, MaViTri)
			values(3,'Van Toan', '6', 1, 3);

insert into DOIDAU(MaDoiDau,TenDoiDau,DiaChi,SoDienThoai) values (1,'doi dau A','223 Hoang  Hoa Tham',841234567892)
insert into DOIDAU(MaDoiDau,TenDoiDau,DiaChi,SoDienThoai) values (2,'doi dau B','2 Hoang  Cau',841064952301)
insert into DOIDAU(MaDoiDau,TenDoiDau,DiaChi,SoDienThoai) values (3,'doi dau C','14 My Dinh',843302167410)
insert into DOIDAU(MaDoiDau,TenDoiDau,DiaChi,SoDienThoai) values (4,'doi dau C','14 My Dinh',843302167410)

insert into TRANDAU(MaTranDau,Ngay,Thoigian,DiaDiem,MaDoiDau) values (1,'2022/1/8','12:34:54.1237','Ha Noi',3)
insert into TRANDAU(MaTranDau,Ngay,Thoigian,DiaDiem,MaDoiDau) values (2,'2021/12/18','12:34:54.1237','Hai Duong',2)
insert into TRANDAU(MaTranDau,Ngay,Thoigian,DiaDiem,MaDoiDau) values (3,'2022/10/28','12:34:54.1237','Hai Phong',3)
insert into TRANDAU(MaTranDau,Ngay,Thoigian,DiaDiem,MaDoiDau) values (4,'2021/12/28','11:34:54.1237','Ha Nam',2)
insert into TRANDAU(MaTranDau,Ngay,Thoigian,DiaDiem,MaDoiDau) values (5,'2022/10/28','10:34:54.1237','Hai Phong',2)

insert into THAMGIA(MaCauThu,MaTranDau,SoBan) values (1,2,5)
insert into THAMGIA(MaCauThu,MaTranDau,SoBan) values (1,2,15)
insert into THAMGIA(MaCauThu,MaTranDau,SoBan) values (3,3,25)
insert into THAMGIA(MaCauThu,MaTranDau,SoBan) values (2,2,2)
insert into THAMGIA(MaCauThu,MaTranDau,SoBan) values (1,1,4)

--truy vấn 
select * from CAUTHU 

select * from TRANDAU

select * from THAMGIA

select * from TRANDAU

delete from CAUTHU where MaCauThu=1; 
delete from DOIDAU where MaDoiDau=4;

update CAUTHU SET MaDoi=2  WHERE  MaCauThu=3;
update THAMGIA SET SoBan = 3 WHERE MaCauThu=1 

select c.MaCauThu,c.HoTen , t.SoBan , td.Ngay , d.TenDoiDau
from CAUTHU c 
INNER JOIN THAMGIA t on t.MaCauThu = c.MaCauThu 
INNER JOIN TRANDAU td on td.MaTranDau = t.MaTranDau
INNER JOIN DOIDAU d on d.MaDoiDau = td.MaDoiDau
WHERE c.MaCauThu = 3

select c.MaCauThu,c.HoTen,v.MaViTri
from CAUTHU c 
INNER JOIN VITRI v on v.MaViTri=c.MaViTri
where c.HoTen like 'V%'

select COUNT(td.Ngay)
from CAUTHU c 
INNER JOIN THAMGIA t on t.MaCauThu = c.MaCauThu 
INNER JOIN TRANDAU td on td.MaTranDau = t.MaTranDau
where c.HoTen like 'M%'

select  sum(tg.SoBan)
from TRANDAU t 
INNER JOIN THAMGIA tg ON t.MaDoiDau = tg.MaTranDau 
where t.Ngay = '2022/10/28'




