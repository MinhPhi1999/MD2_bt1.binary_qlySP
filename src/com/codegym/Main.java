package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // ghi ds vào file nhị phân
    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // lấy ra dsach từ file product.txt
    public static List<Product> readDataFromFile(String path) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    // phương thức thêm sản phẩm
    public static void addProduct (String file,Product product){
        List<Product> products = readDataFromFile(file);
        products.add(product);
        writeToFile("product.txt",products);
    }
    // phương thức in ra
    public static void display(String file){
        List<Product> products = readDataFromFile(file);
        for (Product element: products) {
            System.out.println(element);
        }
    }
    // phương thức tìm kiếm
    public static Product search(int id, String file){
        List<Product> products = readDataFromFile(file);
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()){
                System.out.println(products.get(i));
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // write your code here
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"quần","vietNam",10,"quần bò"));
        products.add(new Product(2,"áo","thailand",15,"polo"));
        products.add(new Product(3,"mũ","USA",5,"lưỡi chai"));
        products.add(new Product(4,"tất","laos",2,"len"));
        products.add(new Product(5,"sịp","Eng",5,"lụa"));
        writeToFile("product.txt",products);
        display("product.txt");
        System.out.println("------------------------------------------");
        addProduct("product.txt",new Product(6,"váy","Nga",15,"dài"));
        display("product.txt");
        System.out.println("-------------------------");
        search(6,"product.txt");

    }
}
