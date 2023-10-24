package bai2;

import java.io.*;

public class FileCopyProgram {
    public static void main(String[] args) {

        String sourceFilePath = "source.txt";
        String targetFilePath = "target.txt";

        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);

        // Kiểm tra xem tệp nguồn tồn tại
        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại.");
            return;
        }

        // Kiểm tra xem tệp đích đã tồn tại chưa
        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại.");
            return;
        }

        try (InputStream inputStream = new FileInputStream(sourceFile);
             OutputStream outputStream = new FileOutputStream(targetFile)) {
            byte[] buffer = new byte[1024];
            int length;
            int byteCount = 0;

            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
                byteCount += length;
            }

            System.out.println("Sao chép tệp thành công. Số byte sao chép: " + byteCount);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi trong quá trình sao chép tệp.");
        }
    }
}
