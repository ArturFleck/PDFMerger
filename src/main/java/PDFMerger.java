import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class PDFMerger {
    public static void directories(File pathFrom, String pathTo) throws IOException {
        String[] listOfFolders = pathFrom.list();

        assert listOfFolders != null;
        for (String dir : listOfFolders) {
            String files = pathFrom + "/" + dir;
            filesForMerging(files);

            String dest = pathTo + dir + "/" + dir + ".pdf";
            String dest2 = pathTo + dir + "/" + "Креслення PDF/" + dir + ".pdf";
            String name = files + ".pdf";

            Files.copy(Path.of(name), Path.of(dest), StandardCopyOption.REPLACE_EXISTING);
            Files.move(Path.of(name), Path.of(dest2), StandardCopyOption.REPLACE_EXISTING);

            System.out.println(files);
            deleteDirectory(new File(files));
        }
    }

    public static void filesForMerging(String path) throws IOException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        PDFMergerUtility ut = new PDFMergerUtility();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                ut.addSource(path + "/" + file.getName());
            }
        }

        ut.setDestinationFileName(path + ".pdf");
        ut.mergeDocuments();
        System.out.println("Created  " + path + ".pdf");
    }

    static public boolean deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return (path.delete());
    }
}
