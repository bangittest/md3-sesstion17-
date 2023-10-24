package bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product implements Serializable {
    private String maSanPham;
    private String tenSanPham;
    private String ngaySanXuat;
    private double gia;

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    private String moTa;

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public Product(String maSanPham, String tenSanPham, String ngaySanXuat, double gia, String moTa) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.ngaySanXuat = ngaySanXuat;
        this.gia = gia;
        this.moTa = moTa;
    }

    // Các phương thức Getter và Setter ở đây

    @Override
    public String toString() {
        return "Mã Sản Phẩm: " + maSanPham + "\n" +
                "Tên Sản Phẩm: " + tenSanPham + "\n" +
                "Ngày Sản Xuất: " + ngaySanXuat + "\n" +
                "Giá: " + gia + "\n" +
                "Mô Tả: " + moTa + "\n";
    }
}
