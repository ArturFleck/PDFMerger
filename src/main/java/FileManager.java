import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
public class FileManager {
    public static void excelMover(File pathFrom, String pathTo){
        List<String> fileList = new ArrayList<>();
        File[] listOfFiles = pathFrom.listFiles();

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

            String directory = pathFrom + "/" + val + ".xls";   //name of file with path

            String pathToMove= pathTo;
            if (folderName.equals("Відомість деталей")) {
                pathToMove = pathTo + fileName + "/Відомість деталей/" + val + ".xls";
            }
            if (folderName.equals("Матеріали") || folderName.equals("Фурнітура")) {
                pathToMove = pathTo + fileName + "/Матеріали і фурнітура для 1 С/" + val + ".xls";
            }

            System.out.println("from << " + directory);
            System.out.println("to >> " + pathToMove);

            Path source = Paths.get(directory);
            Path target = Paths.get(pathToMove);
            try {

                Files.move(source, target, REPLACE_EXISTING);
                System.out.println("Excel Success!!!\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void projectMover(File pathFrom, String pathTo){
        List<String> fileList = new ArrayList<>();

        File[] listOfFiles = pathFrom.listFiles();

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
            String directory = pathFrom + "/" + val;
            String destination = pathTo + folderName + "/Файл розкрою матеріалу GibLab/" + val;

            System.out.println("from <- "+directory);
            System.out.println("to -> "+destination);

            Path source = Paths.get(directory);
            Path target = Paths.get(destination);
            try {

                Files.move(source, target, REPLACE_EXISTING);
                System.out.println("project moved Successfully!!!\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}