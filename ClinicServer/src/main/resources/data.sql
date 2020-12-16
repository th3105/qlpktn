delete from clinic.nurse;
delete from clinic.doctor;
delete from clinic.patient;

insert into clinic.doctor (id, bacnghe, chuyenmon, cmt, diachi, ngaysinh, ten, thamnien, trinhdo)
		values(1, '2', 'da khoa', 0124, 'Hanoi', '31-05-1999', 'Ngo Duc Thang', '2 nam', 'dai hoc');
insert into clinic.doctor (id, bacnghe, chuyenmon, cmt, diachi, ngaysinh, ten, thamnien, trinhdo)
		values(3, '2', 'da khoa', 0125, 'Hanoi', '30-03-1999', 'Nguyen Mai Lan', '2 nam', 'dai hoc');
insert into clinic.doctor (id, bacnghe, chuyenmon, cmt, diachi, ngaysinh, ten, thamnien, trinhdo)
		values(4, '2', 'da khoa', 0126, 'Hanoi', '21-11-1999', 'Hoang Hiep', '2 nam', 'dai hoc');
insert into clinic.doctor (id, bacnghe, chuyenmon, cmt, diachi, ngaysinh, ten, thamnien, trinhdo)
		values(5, '2', 'da khoa', 0127, 'Hanoi', '11-01-1999', 'Tran Duc', '2 nam', 'dai hoc');
insert into clinic.nurse (id, ten, cmt, ngaysinh, diachi, sdt, trinhdo, thamnien)
		values(1, 'Nguyen Thi Van Anh', 0128, '03-11-1998', 'Haiduong', '0987654321', 'Dai hoc', '2 nam');
insert into clinic.nurse (id, ten, cmt, ngaysinh, diachi, sdt, trinhdo, thamnien)
		values(2, 'Nguyen Thi Anh Duong', 0129, '03-11-1998', 'Haiphong', '0987654321', 'Dai hoc', '2 nam');
insert into clinic.nurse (id, ten, cmt, ngaysinh, diachi, sdt, trinhdo, thamnien)
		values(3, 'Nguyen Thi Kim Dao', 0130, '03-11-1998', 'Hanoi', '0987654321', 'Dai hoc', '2 nam');
insert into clinic.nurse (id, ten, cmt, ngaysinh, diachi, sdt, trinhdo, thamnien)
		values(4, 'Nguyen Thi Linh', 0131, '03-1-1998', 'Nghe An', '0987654321', 'Dai hoc', '2 nam');
        
insert into clinic.nurse (id, ten, cmt, ngaysinh, diachi, sdt)
		values(1, 'Nguyen Thi Linh', 0132, '03-1-1998', 'Nghe An', '0987654321');
        insert into clinic.nurse (id, ten, cmt, ngaysinh, diachi, sdt)
		values(2, 'Nguyen Thi Lan', 0133, '03-1-1998', 'Nghe An', '0987654321');
        insert into clinic.nurse (id, ten, cmt, ngaysinh, diachi, sdt)
		values(3, 'Nguyen Thi Mai', 0134, '03-1-1998', 'Nghe An', '0987654321');
        insert into clinic.nurse (id, ten, cmt, ngaysinh, diachi, sdt)
		values(4, 'Nguyen Thi Lien', 0135, '03-1-1998', 'Nghe An', '0987654321');
        insert into clinic.nurse (id, ten, cmt, ngaysinh, diachi, sdt)
		values(5, 'Nguyen Thi Loan', 0136, '03-1-1998', 'Nghe An', '0987654321');
        
insert into clinic.patient (id, cmt, diachi, ngaysinh, sdt, ten) 
		values(1, 001, 'CaMau', '01-01-99', '0123456789', 'Nguyen Thi Kim Dao');
insert into clinic.patient (id, cmt, diachi, ngaysinh, sdt, ten) 
		values(2, 002, 'VungTau', '01-01-70', '02369874', 'Le Thi Tien');
