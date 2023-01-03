import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class PDFMerger {
    public static void mergePDF(File pathFrom, String pathTo) throws IOException {
        String[] listOfFolders = pathFrom.list();

        assert listOfFolders != null;
        for (String dir : listOfFolders) {
            String files = pathFrom + "/" + dir;
            filesForMerging2(files);

            String dest = pathTo + dir + "/Ескізи для менеджера/" + dir + ".pdf";
            String dest2 = pathTo + dir + "/Креслення PDF/" + dir + ".pdf";
            String name = files + ".pdf";

            Files.move(Path.of(name), Path.of(dest), StandardCopyOption.REPLACE_EXISTING);
            filesForMerging(files);
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

    public static void filesForMerging2(String path) throws IOException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        PDFMergerUtility ut = new PDFMergerUtility();

        assert listOfFiles != null;
        for (int i = 1; i < listOfFiles.length; i++) {
            if ((listOfFiles[i]).isFile()) {
                ut.addSource(path + "/" + (listOfFiles[i]).getName());
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
