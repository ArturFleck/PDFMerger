import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileMover {
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
            //String pathTo = val;
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


