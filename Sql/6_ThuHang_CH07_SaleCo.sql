-- SaleCo 13 14
/*9. Viết truy vấn để đếm số lượng hóa đơn*/
select count(v.INV_NUMBER)
from INVOICE v

/*10. Viết truy vấn để đếm số lượng khách hàng có số dư trên $500.*/
select count(c.CUS_CODE)
from CUSTOMER c
where c.CUS_BALANCE > 500

/*11. Tạo danh sách tất cả các giao dịch mua của khách hàng, sử dụng kết quả hiển thị trong Hình P7.11 làm gợi ý. Sắp xếp kết quả theo mã khách hàng, số hóa đơn và mô tả sản phẩm.*/
select c.CUS_CODE, i.INV_NUMBER,i.INV_DATE,p.P_DESCRIPT,l.LINE_UNIT,l.LINE_PRICE
from CUSTOMER c
inner join INVOICE i on i.CUS_CODE = c.CUS_CODE
inner join LINE l on l.INV_NUMBER = i.INV_NUMBER
inner join PRODUCT p on p.P_CODE = l.P_CODE
ORDER BY c.CUS_CODE , i.INV_NUMBER , p.P_DESCRIPT

/*12. Sử dụng kết quả hiển thị trong Hình P7.12 làm gợi ý, tạo danh sách các giao dịch mua của khách hàng, bao gồm thành tiền cho từng dòng hóa đơn. Thành tiền là một thuộc tính bắt nguồn được tính bằng cách nhân LINE_UNITS với LINE_PRICE. Sắp xếp đầu ra theo mã khách hàng, số hóa đơn và mô tả sản phẩm. Hãy sử dụng bí danh cột như trong hình.*/
select c.CUS_CODE, i.INV_NUMBER,p.P_DESCRIPT,l.LINE_UNIT,l.LINE_PRICE , (l.LINE_UNIT*l.LINE_PRICE)as Subtotal
from CUSTOMER c
inner join INVOICE i on i.CUS_CODE = c.CUS_CODE
inner join LINE l on l.INV_NUMBER = i.INV_NUMBER
inner join PRODUCT p on p.P_CODE = l.P_CODE
ORDER BY c.CUS_CODE , p.P_CODE , p.P_DESCRIPT

/*13. Viết truy vấn để hiển thị mã khách hàng, số dư và tổng số lần mua hàng cho từng khách hàng. Tổng số lần mua được tính bằng cách tổng thành tiền (như được tính trong Bài toán 12) cho mỗi khách hàng. Sắp xếp kết quả theo mã khách hàng và sử dụng bí danh như trong Hình P7.13.
*/
select c.CUS_CODE,c.CUS_BALANCE,sum(l.LINE_UNIT*l.LINE_PRICE )as TotalPurcharset
from CUSTOMER c
inner join INVOICE i on i.CUS_CODE = c.CUS_CODE
inner join LINE l on l.INV_NUMBER = i.INV_NUMBER
GROUP BY c.CUS_CODE , c.CUS_BALANCE
ORDER BY c.CUS_CODE

/*14. Sửa đổi truy vấn trong câu 13 để bao gồm số lần mua sản phẩm riêng lẻ của mỗi khách hàng. (Nói cách khác, nếu hóa đơn của khách hàng dựa trên ba sản phẩm, mỗi sản phẩm một LINE_NUMBER, thì bạn tính ba lần mua sản phẩm. Lưu ý rằng trong dữ liệu hóa đơn ban đầu, khách hàng 10011 đã tạo ba hóa đơn, có tổng cộng sáu dòng, mỗi dòng đại diện cho một mua sản phẩm.) Giá trị đầu ra giống với thể hiện trong Hình P7.14, được sắp xếp theo mã khách hàng*/
select c.CUS_CODE,c.CUS_BALANCE,sum(l.LINE_UNIT*l.LINE_PRICE )as TotalPurcharset,COUNT(i.INV_NUMBER) as NumBerOfPurchases
from CUSTOMER c
inner join INVOICE i on i.CUS_CODE = c.CUS_CODE
inner join LINE l on l.INV_NUMBER = i.INV_NUMBER
GROUP BY c.CUS_CODE , c.CUS_BALANCE
ORDER BY c.CUS_CODE

/*15. Sử dụng truy vấn để tính tổng tất cả các lần mua, số lần mua và số tiền mua trung bình của mỗi khách hàng. Giá trị đầu ra giống thể hiển thị trong Hình P7.15. Sắp xếp kết quả theo mã khách hàng*/
select c.CUS_CODE,c.CUS_BALANCE,sum(l.LINE_UNIT*l.LINE_PRICE )as TotalPurcharset,COUNT(i.INV_NUMBER) as NumBerOfPurchases , AVG(l.LINE_UNIT*l.LINE_PRICE) as AvertagePurchasesAmount
from CUSTOMER c
inner join INVOICE i on i.CUS_CODE = c.CUS_CODE
inner join LINE l on l.INV_NUMBER = i.INV_NUMBER
GROUP BY c.CUS_CODE , c.CUS_BALANCE
ORDER BY c.CUS_CODE

/*16. Viết câu truy vấn để tạo ra tổng số lần mua hàng trên mỗi hóa đơn, tạo ra kết quả giống hiển thị trong Hình P7.16, được sắp xếp theo số hóa đơn. Tổng hóa đơn là tổng số lần mua sản phẩm trong LINE tương ứng với INVOICE*/
select i.INV_NUMBER ,COUNT(l.P_CODE) as invoiceTotal
from INVOICE i
inner join LINE l on l.INV_NUMBER = i.INV_NUMBER
GROUP BY i.INV_NUMBER
ORDER BY i.INV_NUMBER

/*17. Viết câu truy vấn để hiển thị các hóa đơn và tổng số hóa đơn trong Hình P7.17. Sắp xếp kết quả theo mã khách hàng và số hóa đơn.*/
select i.CUS_CODE, i.INV_NUMBER ,COUNT(l.P_CODE) as invoiceTotal
from INVOICE i
inner join LINE l on l.INV_NUMBER = i.INV_NUMBER
GROUP BY i.CUS_CODE, i.INV_NUMBER
ORDER BY i.CUS_CODE, i.INV_NUMBER 

/*18. Viết một truy vấn để hiển thị số lượng hóa đơn và tổng số tiền mua hàng của khách hàng, sử dụng kết quả hiển thị trong Hình P7.18 làm gợi ý. Lưu ý kết quả được sắp xếp theo mã khách hàng. (So sánh bản tóm tắt này với kết quả được hiển thị trong Bài toán 17.)*/
select c.CUS_CODE,sum(l.LINE_UNIT*l.LINE_PRICE )as TotalPurcharset,COUNT(i.INV_NUMBER) as NumBerOfInvoices 
from CUSTOMER c
inner join INVOICE i on i.CUS_CODE = c.CUS_CODE
inner join LINE l on l.INV_NUMBER = i.INV_NUMBER
GROUP BY c.CUS_CODE
ORDER BY c.CUS_CODE

/*19. Viết truy vấn để tạo tổng số hóa đơn, tổng số hóa đơn cho tất cả các hóa đơn, số tiền mua hàng nhỏ nhất của khách hàng, số tiền mua hàng lớn nhất của khách hàng và giá trị trung bình của tất cả số tiền mua hàng của khách hàng. Đầu ra của bạn giống với Hình P7.19.*/
select COUNT(i.INV_NUMBER) as TotalInvoices , sum(l.LINE_UNIT*l.LINE_PRICE )as TotalSale,
min(l.LINE_UNIT*l.LINE_PRICE)as MiniumPurchases,MAX(l.LINE_UNIT*l.LINE_PRICE) as LargestPurchases ,
 AVG(l.LINE_UNIT*l.LINE_PRICE) as AvertagePurchasesAmount
from CUSTOMER c
inner join INVOICE i on i.CUS_CODE = c.CUS_CODE
inner join LINE l on l.INV_NUMBER = i.INV_NUMBER
GROUP BY c.CUS_CODE
ORDER BY c.CUS_CODE