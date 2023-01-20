import java.io.File;

public class DirectoriesCreator {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static void mkDir(File path) {

        File[] listOfFolders = path.listFiles();

        assert listOfFolders != null;
        for (File file : listOfFolders) {
            if (file.isDirectory()) {
                File folder = new File(path + "/" + file.getName());
                createDir(folder);
            }
        }
    }

    private static void createDir(File dir) {
        File cad = new File(dir + "/" + "AutoCad");
        File details = new File(dir + "/" + "Відомість деталей");
        //File sketches = new File(dir + "/" + "Ескізи для менеджера");
        File views = new File(dir + "/" + "Зображення виробу габаритні розміри");
        File pdfSketches = new File(dir + "/" + "Креслення PDF");
        File materials = new File(dir + "/" + "Матеріали і фурнітура для 1 С");
        File BHX = new File(dir + "/" + "Програма BHX");
        File GibLab = new File(dir + "/" + "Файл розкрою матеріалу GibLab");

        System.out.println(dir + " in process!!!");
        if (!(cad).exists()) {
            cad.mkdir();
            System.out.println(ANSI_RED + "CAD created");
        }

        if (!(details).exists()) {
            details.mkdir();
            System.out.println(ANSI_GREEN + "Details excel dir created");
        }

        /*if (!(sketches).exists()) {
            sketches.mkdir();
            System.out.println(ANSI_YELLOW + "Sketches created");
        }*/

        if (!(views).exists()) {
            views.mkdir();
            System.out.println(ANSI_BLUE + "Views created");
        }

        if (!(pdfSketches).exists()) {
            pdfSketches.mkdir();
            System.out.println(ANSI_PURPLE + "PDF dir created");
        }

        if (!(materials).exists()) {
            materials.mkdir();
            System.out.println(ANSI_CYAN + "materials dir created");
        }

        if (!(BHX).exists()) {
            BHX.mkdir();
            System.out.println(ANSI_WHITE + "BHX created");
        }

        if (!(GibLab).exists()) {
            GibLab.mkdir();
            System.out.println(ANSI_BLACK + "GibLab created");
        }

        System.out.println(ANSI_RESET + "done with that dir !!!\n");
    }
}
