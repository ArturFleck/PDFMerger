import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Merger {
    public static void main(String[] args) throws IOException {

        FileManager.excelMover();
        FileManager.projectMover();

        directories();

/*        PDFMergerUtility ut = new PDFMergerUtility();
        ut.addSource("C:\\Elecran\\3D-Constructor 7\\KM5\\TMP\\МВ С96 601Л\\МВ С96 601Л_KM_1_1.pdf");
        ut.addSource("C:\\Elecran\\3D-Constructor 7\\KM5\\TMP\\МВ С96 601Л\\МВ С96 601Л_KM_1_2.pdf");
        ut.addSource("C:\\Elecran\\3D-Constructor 7\\KM5\\TMP\\МВ С96 601Л\\МВ С96 601Л_KM_1_3.pdf");
        ut.setDestinationFileName("C:\\Elecran\\3D-Constructor 7\\KM5\\TMP\\МВ С96 601Л\\МВ С96 601Л.pdf");
        ut.mergeDocuments();*/
    }

    public static void directories() throws IOException {
        List<String> folderList = new ArrayList<>();
        List<String> fileList = new ArrayList<>();
        String path = "C:\\Elecran\\3D-Constructor 7\\KM5\\TMP";

        File folder = new File(path);
        String[] listOfFolders = folder.list();

        assert listOfFolders != null;
        for (String dir : listOfFolders) {
            folderList.add(dir);
            String files = path + "\\" + dir;
            filesForMerging(files);

            //System.out.println(files);

            deleteDirectory(new File(files));

        }

        //System.out.println(folderList);
    }


    static public boolean deleteDirectory(File path) {
        if( path.exists() ) {
            File[] files = path.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                }
                else {
                    files[i].delete();
                }
            }
        }
        return( path.delete() );
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

        ut.setDestinationFileName(path + ".pdf");
        ut.mergeDocuments();




/*        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileList.add(file.getName());
            }
        }*/


/*
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
        }*/

    }


}
