import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

//https://stackoverflow.com/questions/3585329/how-to-merge-two-pdf-files-into-one-in-java
public class FileManager {
    public static void main(String[] args) throws IOException {
        excelMover();
        projectMover();
    }
    public static void excelMover(){
        List<String> fileList = new ArrayList<>();

        File folder = new File("C:\\Test5\\3D-CON~1\\KM5\\Export");
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileList.add(file.getName().replace(".xls", ""));
            }
        }

        System.out.println(fileList);

        for (int i = 0; i < fileList.size(); i++) {
            String val = fileList.get(i);
            int index = val.indexOf("[");
            String folderName = val.substring(0, index - 1);
            String fileName = val.substring(index + 1);
            fileName = fileName.substring(0, fileName.length() - 1);
            //System.out.println(folderName);
            //System.out.println(fileName);

            String directory = "C:\\Test5\\3D-CON~1\\KM5\\Export\\" + val + ".xls";
            String destination = "D:\\_profile\\Desktop\\Типові меблі ЕЛКОН ДІЗАЙН\\ТИПОВІ КУХНІ\\верх\\МВ 96\\";

            if (folderName.equals("Відомість деталей")) {
                destination = destination + fileName + "\\Відомість деталей\\" + val + ".xls";
            }
            if (folderName.equals("Матеріали") || folderName.equals("Фурнітура")) {
                destination = destination + fileName + "\\Матеріали і фурнітура для 1 С\\" + val + ".xls";
            }

            System.out.println(directory);
            System.out.println(destination);

            Path source = Paths.get(directory);
            Path target = Paths.get(destination);
            try {

                Files.move(source, target, REPLACE_EXISTING);
                System.out.println("Success!!!\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void projectMover(){
        List<String> fileList = new ArrayList<>();

        File folder = new File("C:\\Elecran\\3D-Constructor 7\\KM5\\TMP");
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileList.add(file.getName());
            }
        }

        System.out.println(fileList);

        for (int i = 0; i < fileList.size(); i++) {
            String val = fileList.get(i);
            int index = val.indexOf(".");
            String folderName = val.substring(0, index);
            System.out.println(val);
            String directory = "C:\\Elecran\\3D-Constructor 7\\KM5\\TMP\\" + val;
            String destination = "D:\\_profile\\Desktop\\Типові меблі ЕЛКОН ДІЗАЙН\\ТИПОВІ КУХНІ\\верх\\МВ 96\\" + folderName + "\\Файл розкрою матеріалу GibLab\\" + val;

            System.out.println(directory);
            System.out.println(destination);

            Path source = Paths.get(directory);
            Path target = Paths.get(destination);
            try {

                Files.move(source, target, REPLACE_EXISTING);
                System.out.println("Success!!!\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}