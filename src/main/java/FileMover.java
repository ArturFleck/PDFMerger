import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.apache.commons.io.FileUtils.deleteDirectory;

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

    public static void move(File pathFrom, String name) {
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
            if (val.contains(".mpr")) {
                System.out.println(val);
                String directory = pathFrom + "/" + val;
                String destination = pathFrom + "/Програма BHX/" + name + "/" + val;

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
    }

    public static void dwgMover(File pathFrom) {
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
            if (val.contains(".dwg")) {
                int index = val.indexOf(".");
                String folderName = val.substring(0, index);

                System.out.println(val);
                String directory = pathFrom + "/" + val;
                String destination = pathFrom + "/" + folderName + "/AutoCad/" + val;

                System.out.println("from <- " + directory);
                System.out.println("to -> " + destination);

                Path source = Paths.get(directory);
                Path target = Paths.get(destination);

                try {
                    File g = new File(pathFrom + "/" + folderName);
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

    public static void programsMover(File pathFrom, File pathToMove) throws IOException {
        File[] listOfFolders = pathFrom.listFiles();

        assert listOfFolders != null;
        for (File file : listOfFolders) {
            if (file.isDirectory()) {
                String dirName = pathFrom + "/" + file.getName();
                String dirToDelete = pathToMove + "/" +  file.getName() +"/Програма BHX/" + file.getName()+"/";
                File dir2 = new File(dirName);
                File dirToGo2 = new File (dirToDelete);
                //dirToGo2.delete();
                FileUtils.deleteDirectory(dirToGo2);
                Files.move(dir2.toPath(), dirToGo2.toPath());

                System.out.println(file.getName() + "  moved");
            }
        }
    }


}


