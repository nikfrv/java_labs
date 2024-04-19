import java.io.*;
import java.util.zip.*;

public class App {
    public static void main(String[] args) {
        // Указать путь каталога
        String directoryPath = "C:\\lab2";
        // Указать имя нового файла
        String outputFileName = "output.txt";
        // Указать имя zip-архива
        String zipFileName = "output.zip";

        try {
            // Создание нового файла
            File outputFile = new File(outputFileName);
            outputFile.createNewFile();

            // Поиск текстовых файлов и запись их содержимого в новый файл
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        // Чтение содержимого текстового файла
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        FileWriter writer = new FileWriter(outputFile, true);
                        while ((line = reader.readLine()) != null) {
                            // Запись содержимого в новый файл
                            writer.write(line);
                            writer.write(System.lineSeparator());
                        }
                        reader.close();
                        writer.close();
                    }
                }
            }

            // Упаковка файла в zip-архив
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry entry = new ZipEntry(outputFileName);
            zos.putNextEntry(entry);
            FileInputStream fis = new FileInputStream(outputFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
            fis.close();
            zos.close();
            fos.close();

            System.out.println("Successfully completed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
