import java.io.File;
import java.io.IOException;

public class LeadClass {
    public static void main(String[] args) throws IOException {
        File pathFromExport = new File("C:/Test5/3D-CON~1/KM5/Export/");
        File pathFromTMP = new File("C:/Elecran/3D-Constructor 7/KM5/TMP/");
        String pathTo = "D:/_profile/Desktop/Типові меблі ЕЛКОН ДІЗАЙН/ТИПОВІ КУХНІ/основа верх/МВ 72/";
        File pathToMove = new File(pathTo);

        DirectoriesCreator.mkDir(pathToMove);

        //FileManager.excelMover(pathFromExport, pathTo);
        //FileManager.projectMover(pathFromTMP,pathTo);
        //PDFMerger.mergePDF(pathFromTMP, pathTo);
        //FileMover.dwgMover(pathToMove);
        //FileMover.mprMover(pathToMove);
    }
}
