import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;

public class Merger {
    public static void main(String[] args) throws IOException {
        PDFMergerUtility PDFmerger = new PDFMergerUtility();

        PDFMergerUtility ut = new PDFMergerUtility();
        ut.addSource("C:\\Elecran\\3D-Constructor 7\\KM5\\TMP\\МВ С96 601Л\\МВ С96 601Л_KM_1_1.pdf");
        ut.addSource("C:\\Elecran\\3D-Constructor 7\\KM5\\TMP\\МВ С96 601Л\\МВ С96 601Л_KM_1_2.pdf");
        ut.addSource("C:\\Elecran\\3D-Constructor 7\\KM5\\TMP\\МВ С96 601Л\\МВ С96 601Л_KM_1_3.pdf");
        ut.setDestinationFileName("C:\\Elecran\\3D-Constructor 7\\KM5\\TMP\\МВ С96 601Л\\МВ С96 601Л.pdf");
        ut.mergeDocuments();
    }
}
