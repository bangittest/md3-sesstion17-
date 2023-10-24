package ra.data.empl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        List<Employee>employees=new ArrayList<>();
        List<Skill>skills=new ArrayList<>();
        FileOutputStream fileOutputStream=new FileOutputStream("employee.dat");
        ObjectOutputStream outputStream=new ObjectOutputStream(fileOutputStream);
        skills.add(new Skill("java",5));
        Employee employee=new Employee(1,"John",true,skills);
        outputStream.writeObject(employee);

        outputStream.close();
        System.out.println("ghi thanh cong");


        FileInputStream fileInputStream=new FileInputStream("employee.dat");
        ObjectInputStream inputStream=new ObjectInputStream(fileInputStream);
        Employee employee1=(Employee) inputStream.readObject();
        System.out.println(employee1);
        inputStream.close();
        System.out.println("Ket thuc doc file");

    }
}
