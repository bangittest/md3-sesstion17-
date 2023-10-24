package bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class QuanLySanPham {
    private List<Product> danhSachSanPham;
    private static final String TEP_DU_LIEU = "sanpham.dat";

    public QuanLySanPham() {
        danhSachSanPham = new ArrayList<>();
    }

    public void themSanPham(Product sanPham) {
        danhSachSanPham.add(sanPham);
    }

    public List<Product> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(List<Product> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    public void hienThiDanhSachSanPham() {
        for (Product sanPham : danhSachSanPham) {
            System.out.println(sanPham);
        }
    }

    public Product timSanPhamTheoMa(String maSanPham) {
        for (Product sanPham : danhSachSanPham) {
            if (sanPham.getMaSanPham().equals(maSanPham)) {
                return sanPham;
            }
        }
        return null;
    }

    public void luuVaoTep() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TEP_DU_LIEU))) {
            oos.writeObject(danhSachSanPham);
            System.out.println("Danh sách sản phẩm đã được lưu vào " + TEP_DU_LIEU);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void taiTuTep() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TEP_DU_LIEU))) {
            danhSachSanPham = (List<Product>) ois.readObject();
            System.out.println("Danh sách sản phẩm đã được nạp từ " + TEP_DU_LIEU);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QuanLySanPham quanLy = new QuanLySanPham();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Quản Lý Sản Phẩm:");
            System.out.println("1. Thêm Sản Phẩm");
            System.out.println("2. Hiển Thị Tất Cả Sản Phẩm");
            System.out.println("3. Tìm Sản Phẩm Theo Mã");
            System.out.println("4. Lưu Sản Phẩm Vào Tệp");
            System.out.println("5. Tải Sản Phẩm Từ Tệp");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập mã sản phẩm: ");
                    String maSanPham = scanner.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String tenSanPham = scanner.nextLine();
                    System.out.print("Nhập ngày sản xuất: ");
                    String ngaySanXuat = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double gia = scanner.nextDouble();
                    scanner.nextLine(); // Đọc ký tự xuống dòng
                    System.out.print("Nhập mô tả sản phẩm: ");
                    String moTa = scanner.nextLine();

                    Product sanPham = new Product(maSanPham, tenSanPham, ngaySanXuat, gia, moTa);
                    quanLy.themSanPham(sanPham);
                    break;

                case 2:
                    System.out.println("Tất Cả Sản Phẩm:");
                    quanLy.taiTuTep();
                    quanLy.hienThiDanhSachSanPham();
                    break;

                case 3:
                    System.out.print("Nhập mã sản phẩm để tìm: ");
                    String timMaSanPham = scanner.nextLine();
                    Product sanPhamTimThay = quanLy.timSanPhamTheoMa(timMaSanPham);
                    if (sanPhamTimThay != null) {
                        System.out.println("Sản phẩm được tìm thấy:\n" + sanPhamTimThay);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;

                case 4:
                    quanLy.luuVaoTep();
                    break;

                case 5:
                    quanLy.taiTuTep();
                    break;

                case 6:
                    System.out.println("Đang thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn một tùy chọn hợp lệ.");
            }
        }
    }
}
