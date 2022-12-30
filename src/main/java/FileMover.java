import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileMover {

    public static void mprMover(File pathFrom) {
        File[] listOfFolders = pathFrom.listFiles();

        assert listOfFolders != null;
        for (File file : listOfFolders) {
            if (file.isDirectory()) {
                File f = new File(pathFrom + "/" + file.getName());
                move(f, file.getName());
            }
        }
    }

    public static void move(File pathFrom, String name){
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
            //String folderName = val.substring(0, index);

            System.out.println(val);
            String directory = pathFrom + "/" + val;
            String destination = pathFrom +"/Програма BHX/" + name + "/" + val;

            System.out.println("from <- " + directory);
            System.out.println("to -> " + destination);

            Path source = Paths.get(directory);
            Path target = Paths.get(destination);
            try {
                File g = new File(pathFrom + "/" + "Програма BHX");
                if (!(g).exists()) {
                    g.mkdir();
                }

                File a = new File(g + "/" + name);
                if (!(a).exists()) {
                    a.mkdir();
                }

                Files.move(source, target, REPLACE_EXISTING);
                System.out.println(".mpr moved Successfully!!!\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void objectMover(File pathFrom) {
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
            String destination = pathFrom +"/"+ folderName + "/AutoCad/" + val;

            System.out.println("from <- " + directory);
            System.out.println("to -> " + destination);

            Path source = Paths.get(directory);
            Path target = Paths.get(destination);
            try {
                File g = new File(pathFrom+"/" + folderName);
                if (!(g).exists()) {
                    g.mkdir();
                }

                File a = new File(g + "/AutoCad/");
                if (!(a).exists()) {
                    a.mkdir();
                }

                Files.move(source, target, REPLACE_EXISTING);
                System.out.println("cad moved Successfully!!!\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


