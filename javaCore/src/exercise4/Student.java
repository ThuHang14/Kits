package exercise4;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;

    private String quequan;
    private int namsinh;
    private float  diemTB;

    public Student(String name, int age, String quequan, int namsinh, float diemTB) {
        this.name = name;
        this.age = age;
        this.quequan = quequan;
        this.namsinh = namsinh;
        this.diemTB = diemTB;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name+ " " +
        this.age + " " +
        this.quequan + " " +
        this.namsinh+ " " +
        this.diemTB ;
    }
}
