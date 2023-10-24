package BT1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        FileOutputStream fileOutputStream=new FileOutputStream("product.dat");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        List<Product>productList=new ArrayList<>();
       Product product=new Product("MA123","banh keo","ha n",3000,"hdhdhdh");
        objectOutputStream.writeObject(product);
        objectOutputStream.close();


        FileInputStream fileInputStream=new FileInputStream("product.dat");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        Product product1= (Product) objectInputStream.readObject();
        System.out.println(product1);
        objectOutputStream.close();


    }
}
