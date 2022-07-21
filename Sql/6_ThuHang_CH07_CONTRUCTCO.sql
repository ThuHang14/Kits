
/*
1. Viết mã SQL cần thiết để liệt kê số nhân viên, họ, tên và chữ viết tắt đệm của tất cả nhân viên có họ bắt đầu bằng Smith. Sắp xếp kết quả theo số nhân viên.Giả sử phân biệt chữ hoa chữ thường.
*/
select EMP_NUM , EMP_LNAME,EMP_NITIAL
from EMPLOYEE 
where EMP_FNAME like 'Smith%'
order by EMP_NUM

/*2. Sử dụng bảng EMPLOYEE, JOB và PROJECT trong cơ sở dữ liệu Ch07_ConstructCo, viết mã SQL sẽ nối các bảng EMPLOYEE và PROJECT bằng cách sử dụng EMP_NUM làm thuộc tính chung. Hiển thị các thuộc tính được hiển thị trong kết quả được trình bày trong Hình P7.2, được sắp xếp theo giá trị dự án*/
select p.PROJ_NAME,p.PROJ_VALUE,p.PROJ_BALANCE,e.EMP_LNAME,e.EMP_FNAME,j.JOB_CODE,j.JOB_DESCRIPTION,j.JOB_CHG_HOUR
from job j 
inner join EMPLOYEE e on  j.JOB_CODE = e.JOB_CODE
inner join PROJECT p on p.EMP_NUM = e.EMP_NUM
ORDER BY p.PROJ_NUM

/*3.Viết mã SQL sẽ tạo ra cùng một thông tin được hiển thị trong câu  2, nhưng được sắp xếp theo họ của nhân viên (last name).*/
select p.PROJ_NAME,p.PROJ_VALUE,p.PROJ_BALANCE,e.EMP_LNAME,e.EMP_FNAME,j.JOB_CODE,j.JOB_DESCRIPTION,j.JOB_CHG_HOUR
from job j 
inner join EMPLOYEE e on  j.JOB_CODE = e.JOB_CODE
inner join PROJECT p on p.EMP_NUM = e.EMP_NUM
ORDER BY e.EMP_LNAME

/*4. Viết mã SQL sẽ chỉ liệt kê các số dự án riêng biệt (distinct) trong bảng ASSIGNMENT, được sắp xếp theo số dự án.*/
select DISTINCT  a.PROJ_NUM
from ASSIGNMENT a 

/*5. Viết mã SQL để xác thực các giá trị ASSIGN_CHARGE trong bảng ASSIGNMENT. Truy vấn của bạn sẽ truy xuất số phân công, mã số nhân viên, số dự án, phí phân công đã lưu trữ (ASSIGN_CHARGE) và phí phân công đã tính (được tính bằng cách nhân ASSIGN_CHG_HR với ASSIGN_HOURS). Sắp xếp kết quả theo số chỉ định.*/
select e.EMP_NUM ,p.PROJ_NUM , a.ASSIGNMENT_CHARGE,(a.ASSIGNMENT_CHG_HR* a.ASSIGNMENT_HOURS)as ASSIGN_CHARGE_TEST
from ASSIGNMENT a
inner join EMPLOYEE e on e.EMP_NUM = a.EMP_NUM 
inner join PROJECT p on p.PROJ_NUM = a.PROJ_NUM
ORDER BY a.ASSIGNMENT_NUM

/*6. Sử dụng dữ liệu trong bảng ASSIGNMENT, hãy viết mã SQL sẽ mang lại tổng số giờ làm việc cho mỗi nhân viên và tổng số tiền tính từ những giờ làm việc đó, được sắp xếp theo số nhân viên*/
select e.EMP_NUM,e.EMP_LNAME , sum(a.ASSIGNMENT_HOURS)as SumofAssign_Hours, sum(a.ASSIGNMENT_CHARGE) as SumofAssign_charge
from ASSIGNMENT a
inner join EMPLOYEE e on e.EMP_NUM = a.EMP_NUM 
GROUP BY e.EMP_NUM,e.EMP_LNAME
ORDER BY e.EMP_NUM

/*7. Viết truy vấn để đưa ra tổng số giờ và chi phí cho từng dự án được thể hiện trong bảng ASSIGNMENT, được sắp xếp theo số dự án. */
select p.EMP_NUM , sum(a.ASSIGNMENT_HOURS)as SumofAssign_Hours, sum(a.ASSIGNMENT_CHARGE) as SumofAssign_charge
from ASSIGNMENT a
inner join PROJECT p on p.PROJ_NUM = a.PROJ_NUM 
GROUP BY p.EMP_NUM
ORDER BY p.EMP_NUM

/*8. Viết SQL để tạo ra tổng số giờ làm việc và tổng số phí mà tất cả nhân viên thực hiện*/
select sum(a.ASSIGNMENT_HOURS)as SumofAssign_Hours, sum(a.ASSIGNMENT_CHARGE) as SumofAssign_charge
from ASSIGNMENT a
