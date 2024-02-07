import FileIO.PDFHelper;
import core.DImage;
import processing.core.PImage;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

// Author: David Dobervich (this is my edit)
// ANOTHER EDIT.
public class OpticalMarkReaderMain {
    public static void main(String[] args) {
        String pathToPdf = fileChooser();
        System.out.println("Loading pdf at " + pathToPdf);

        ArrayList<PImage>img = PDFHelper.getPImagesFromPdf("assets/omrtest.pdf");




        DImage a = new DImage(img.get(3));
        DImage aSheet= new DImage(img.get(1));
        short [][] answerSheet=aSheet.getBWPixelGrid();
        short[][] blackgrid = a.getBWPixelGrid();

        System.out.println(blackgrid[1][1]);

        for (int i=0; i <blackgrid.length;i++) {
            for (int j=0; j<blackgrid[0].length; j++){
                if (blackgrid[i][j] == answerSheet[i][j]){
                }
            }
        }




        /*
        Your code here to...
        (1).  Load the pdf
        (2).  Loop over its pages
        (3).  Create a DImage from each page and process its pixels
        (4).  Output 2 csv files
         */

    }

    private static String fileChooser() {
        String userDirLocation = System.getProperty("user.dir");
        File userDir = new File(userDirLocation);
        /* hello */

        JFileChooser fc = new JFileChooser(userDir);
        int returnVal = fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        return file.getAbsolutePath();
    }
}
