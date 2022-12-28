import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Merger {
    public static void main(String[] args) throws IOException {

        FileManager.excelMover();
        FileManager.projectMover();

        directories();
    }

    public static void directories() throws IOException {
        List<String> folderList = new ArrayList<>();
        String path = "C:\\Elecran\\3D-Constructor 7\\KM5\\TMP";

        File folder = new File(path);
        String[] listOfFolders = folder.list();

        assert listOfFolders != null;
        for (String dir : listOfFolders) {
            folderList.add(dir);
            String files = path + "\\" + dir;
            filesForMerging(files);

            String dest = "D:\\_profile\\Desktop\\Типові меблі ЕЛКОН ДІЗАЙН\\ТИПОВІ КУХНІ\\верх\\МВ 96\\" + dir + "\\" + dir + ".pdf";
            String dest2 = "D:\\_profile\\Desktop\\Типові меблі ЕЛКОН ДІЗАЙН\\ТИПОВІ КУХНІ\\верх\\МВ 96\\" + dir + "\\" + "Креслення PDF\\" + dir + ".pdf";
            String name = files + ".pdf";
            Files.copy(Path.of(name), Path.of(dest), StandardCopyOption.REPLACE_EXISTING);
            Files.move(Path.of(name), Path.of(dest2), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(files);
            deleteDirectory(new File(files));
        }
        //System.out.println(folderList);
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

    public static void filesForMerging(String path) throws IOException {
        List<String> fileList = new ArrayList<>();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        PDFMergerUtility ut = new PDFMergerUtility();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileList.add(file.getName());
                ut.addSource(path + "\\" + file.getName());
            }
        }

        String name = path + ".pdf";
        ut.setDestinationFileName(name);
        ut.mergeDocuments();
    }
}
