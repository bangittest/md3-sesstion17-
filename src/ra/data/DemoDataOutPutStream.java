package ra.data;

import ra.data.modal.Student;

import java.io.*;

public class DemoDataOutPutStream {
    public static void main(String[] args) throws IOException {
        File studentFile=new File("student.dat");
        studentFile.createNewFile();
        Student student=new Student(1,"Hieu",27,true);
        boolean status=true;
        double PI=3.14;
        String language="java";
        FileOutputStream fos=new FileOutputStream(studentFile);

        DataOutputStream dos=new DataOutputStream(fos);
        dos.writeUTF(language);
        dos.writeDouble(PI);
        dos.writeBoolean(status);
        dos.close();
    }
}
