import java.io.File;
import java.io.IOException;

public class LeadClass {
    public static void main(String[] args) throws IOException {
        File pathFromExport = new File("C:/Test5/3D-CON~1/KM5/Export/");
        File pathFromTMP = new File("C:/Elecran/3D-Constructor 7/KM5/TMP/");
        File pathFromPrograms = new File("D:/_profile/Desktop/Программы BHX/");
        String pathTo = "D:/_profile/Desktop/Типові меблі ЕЛКОН ДІЗАЙН/ТИПОВІ КУХНІ/основа низ/ПЕНАЛ/";
        //String pathTo = "D:/_profile/Desktop/Типові меблі ЕЛКОН ДІЗАЙН/ТИПОВІ КУХНІ/Кухня низ/МН ЯЩИК/";
        File pathToMove = new File(pathTo);


        /*FileMover.dwgMover(pathToMove);
        DirectoriesCreator.mkDir(pathToMove);
        FileManager.excelMover(pathFromExport, pathTo);
        FileManager.projectMover(pathFromTMP,pathTo);
        PDFMerger.mergePDF(pathFromTMP, pathTo);*/

        //FileMover.mprMover(pathToMove);

        FileMover.programsMover(pathFromPrograms,pathToMove);

    }
}
