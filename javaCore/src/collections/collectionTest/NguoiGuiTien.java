/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections.collectionTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Tuan
 */
public class NguoiGuiTien implements Comparable<NguoiGuiTien>{
    public String Ma;
    private String Hoten;
    private String Diachi;
    private String Sodienthoai;
    private Date Ngaysinh;
    
    public void setMa(String Ma){
        this.Ma = Ma;
    }
    public void setHoten(String Hoten){
        this.Hoten = Hoten;
    }
    public void setDiachi(String Diachi){
        this.Diachi = Diachi;
    }
     public void setSothienthoai(String Diachi){
        this.Diachi = Diachi;
    }
    public void setNgaysinh(Date Ngaysinh){
        this.Ngaysinh = Ngaysinh;
    }
    public String getMa(){
        return Ma;
    }
    @Override
    public int compareTo(NguoiGuiTien another) {
        int compareValue = this.getMa().compareTo(another.Ma);
        if (compareValue == 0) {
            return this.getMa().compareTo(another.Ma);
        }
        return compareValue;
    } 
}
