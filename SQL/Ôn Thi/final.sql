create function test(@phg char(3) = '030')
returns decimal(20,3)
as
begin
	declare @avgSa decimal(20,3);

	select @avgSa = avg(LUONG) from NHANVIEN where PHG = @phg;

	return @avgSa;
end;


-- Viết proc thực hiện hiển thị thông tin nhân viên có lương lớn nhất với từng phòng ban
drop proc getSalary
create proc getSalary 
as
BEGIN
	set nocount on;
	select *
	from NHANVIEN a, PHONGBAN b
	where a.PHG=b.MAPHG and a.LUONG = (SELECT max(LUONG) from NHANVIEN where PHG=b.MAPHG)
END;

exec getSalary