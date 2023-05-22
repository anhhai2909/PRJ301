create table GV(
MaGV nvarchar(10) primary key,
TenGV nvarchar(100),
TK nvarchar(100),
MK nvarchar(100),
ChucVu int,
)

create table lop(
Malop nvarchar(10) primary key,
Tenlop nvarchar(10),
SoHS int,
MaGV nvarchar(10) foreign key references GV(MaGV)
)

create table hocsinh(
MaHS nvarchar(10) primary key,
Ten nvarchar(100),
GioiTinh int,
NgaySinh date,
QueQuan text,
SoCCCD nvarchar(12),
SDT nvarchar(10),
Email nvarchar(100),
TenPH nvarchar(100),
SDTPH nvarchar(10),
Malop nvarchar(10) foreign key references lop(Malop),
MaGV nvarchar(10) foreign key references GV(MaGV)
)

Create table Mon(
Mamon nvarchar(10) primary key,
TenMon nvarchar(100),
MaGV nvarchar(10) foreign key references GV(MaGV)
)

create table Diem(
DiemM1 float,
DiemM2 float,
pt1 float,
pt2 float,
GiuaKi float,
CuoiKi float,
TB float,
XepLoai nvarchar(10),
Mamon nvarchar(10) foreign key references Mon(Mamon),
MaHS nvarchar(10) foreign key references hocsinh(MaHS),
MaGV nvarchar(10) foreign key references GV(MaGV),
primary key(Mamon,MaHS)
)

create table DiemDanh(
Ngay date,
TietHoc int,
TinhTrang int,
Mamon nvarchar(10) foreign key references Mon(Mamon),
MaHS nvarchar(10) foreign key references hocsinh(MaHS),
MaGV nvarchar(10) foreign key references GV(MaGV),
primary key(Mamon,MaHS,Ngay,TietHoc)
)

create table Hoc(
Nam nvarchar(10),
NgayBD date,
NgayKT date,
MaHS nvarchar(10) foreign key references hocsinh(MaHS),
Malop nvarchar(10) foreign key references lop(Malop),
primary key(Nam,MaHS,Malop)
)

create table tkb(
Thu nvarchar(10),
Tiet int,
Mon nvarchar(10),
Malop nvarchar(10) foreign key references lop(Malop),
MaGV nvarchar(10) foreign key references GV(MaGV),
primary key(Malop,Tiet,Thu),
)

create table quanlylop(
Nam date,
Malop nvarchar(10) foreign key references lop(Malop),
MaGV nvarchar(10) foreign key references GV(MaGV),
Primary key(Nam,Malop,MaGV)
)