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
        int answersheetCount = 12;
        int answerCount1 = 0;
        int answerCount2 = 0;
        int answerCount3 = 0;
        int answerCount4 = 0;
        int answerCount5 = 0;


        ArrayList<PImage>img = PDFHelper.getPImagesFromPdf("assets/omrtest.pdf");
        ArrayList<PImage>twomage=PDFHelper.getPImagesFromPdf("assets/omrtest.pdf");




        DImage a = new DImage(img.get(3));
        DImage aSheet= new DImage(img.get(1));
        short [][] answerSheet= aSheet.getBWPixelGrid();
        short[][] blackgrid = a.getBWPixelGrid();

       // System.out.println(blackgrid[1][1]);

        System.out.println("size of blackgrd: " + blackgrid.length + " "  + blackgrid[0].length);
        System.out.println("size of answersheet: " + answerSheet.length +  " " + answerSheet[0].length);
       for (int i=0; i <blackgrid.length;i++) {
            for (int j=0; j<blackgrid[0].length; j++){
                System.out.println("i: " + i + " j: " + j);

                if (blackgrid[i][j] == answerSheet[i][j]){
                    if (blackgrid[i][j]==255){
                        answerCount1++;
                        i+=50;
                    }
                }
            }
        }
        System.out.println(blackgrid.length+", "+blackgrid[0].length);
        System.out.println(answerSheet.length+", "+answerSheet[0].length);
//        System.out.println("REAL ANSWER COUNT OUT OF 12: " + answersheetCount+"/12");
//        System.out.println("SCANTRON 1 COUNT : " + answerCount1);
//        System.out.println("SCANTRON 2 COUNT : " + answerCount2);
//        System.out.println("SCANTRON 3 COUNT : " + answerCount3);
//        System.out.println("SCANTRON 4 COUNT : " + answerCount4);
//        System.out.println("SCANTRON 5 COUNT : " + answerCount5);




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
