--https://cafedev.vn/tu-hoc-sql-bai-tap-thuc-hanh-create-insert-update-xoa-du-lieu-trong-sql/

--1
-- 1.2 
alter table SANPHAM add GHICHU varchar(20)
-- 1.3
alter table KHACHHANG add LOAIKH tinyint
-- 1.4
update KHACHHANG
set hoten = 'Nguyen Van B'
where makh = 'KH01'
-- 1.5
set dateformat dmy
update KHACHHANG
set hoten = 'Nguyen Van Hoan', ngdk = '14/01/2007' 
where makh = 'KH09'
-- 1.6
alter table SANPHAM alter column GHICHU varchar(100)
-- 1.7
-- delete HOADON from HOADON inner join HOADON


delete from CTHD
where exists(
	select *
	from HOADON a, CTHD b
	where a.SOHD = b.SOHD
	and
)

