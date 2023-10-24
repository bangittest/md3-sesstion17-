package bai1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(products);
            System.out.println("Danh sách sản phẩm đã được lưu vào " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            products = (List<Product>) ois.readObject();
            System.out.println("Danh sách sản phẩm đã được nạp từ " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();


        manager.addProduct(new Product("P001", "Sản phẩm 1", "01/01/2022", 100.0, "Mô tả sản phẩm 1"));
        manager.addProduct(new Product("P002", "Sản phẩm 2", "02/01/2022", 150.0, "Mô tả sản phẩm 2"));

        // Lưu danh sách sản phẩm vào tệp
        manager.saveToFile("products.txt");

        // Nạp danh sách sản phẩm từ tệp
        manager.loadFromFile("products.txt");

        // Lấy danh sách sản phẩm
        List<Product> products = manager.getAllProducts();

        // In danh sách sản phẩm
        for (Product product : products) {
            System.out.println(product.getProductName() + " - " + product.getPrice());
        }
    }
}
