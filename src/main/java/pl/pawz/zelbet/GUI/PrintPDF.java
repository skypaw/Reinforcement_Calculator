package pl.pawz.zelbet.GUI;

import java.io.IOException;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.HorizontalAlignment;
import be.quodlibet.boxable.Row;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PrintPDF {

    public static void main(String args[]) throws IOException {

        String namePdf = "zadanie testowe";
        String concrete = "C25/30";
        String cement = "N";
        String fyk = "500";
        String rH = "50";
        String days = "28";
        String mEd = "28";
        String mEk = "28";
        String mEkLt = "28";
        String vEd = "28";
        String vEdRed = "28";
        String nEd = "28";


        //Creating PDF document object
        PDDocument document = new PDDocument();
        PDPage blankPage = new PDPage();
        document.addPage(blankPage);

        //1st heading - name

        PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 11);
        contentStream.setLeading(12.0f);
        contentStream.moveTextPositionByAmount(50, 740);

        contentStream.drawString("Nazwa zadania: " + namePdf);


        // Title Table
        float margin = 50;
        float yStartNewPage = blankPage.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = blankPage.getMediaBox().getWidth() - (2 * margin);

        boolean drawContent = true;
        float yStart = yStartNewPage;
        float bottomMargin = 70;
        float yPosition = 725;

        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRow = table.createRow(12f);
        Cell<PDPage> cell = headerRow.createCell(100, "D A N E");

        table.addHeaderRow(headerRow);

        //data section


        contentStream.newLine();
        contentStream.newLine();
        contentStream.newLine();
        contentStream.newLine();
        contentStream.drawString("PARAMETRY MATERIALOWE:");
        contentStream.newLine();
        contentStream.drawString("      Beton: " + concrete + "(cement: " + cement + ")");
        contentStream.newLine();
        contentStream.drawString("      Stal: f_yk = " + fyk + "MPa");
        contentStream.newLine();
        contentStream.newLine();
        contentStream.drawString("PARAMETRY DODATKOWE:");
        contentStream.newLine();
        contentStream.drawString("      RH: " + rH + "%");
        contentStream.newLine();
        contentStream.drawString("      Wiek t_0: " + days + "dni");
        contentStream.newLine();
        contentStream.drawString("      Fi(inf,t_0) = ");


        //Table results

        float yPositionForces = 600;

        BaseTable tableForces = new BaseTable(yPositionForces, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRowForces = tableForces.createRow(12f);
        Cell<PDPage> cellForces = headerRowForces.createCell(100, "SILY WEWNETRZNE");

        tableForces.addHeaderRow(headerRowForces);


        contentStream.newLine();
        contentStream.newLine();
        contentStream.newLine();

        contentStream.newLine();
        contentStream.drawString("M_Ed: " + mEd + " kNm");
        contentStream.newLine();
        contentStream.drawString("      M_Ek: " + mEk + " kNm");
        contentStream.newLine();
        contentStream.drawString("      M_Ek: " + mEkLt + " kNm");
        contentStream.newLine();
        contentStream.drawString("N_Ed: " + nEd + " kN");
        contentStream.newLine();
        contentStream.drawString("V_Ed: " + vEd + " kN / V_Ed,red = " + vEdRed + " kN");


        float yPositionResults = 500;

        BaseTable tableRes = new BaseTable(yPositionResults, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRowRes = tableRes.createRow(12f);
        Cell<PDPage> cellRes = headerRowRes.createCell(100, "W Y N I K I");

        tableRes.addHeaderRow(headerRowRes);


        table.draw();
        contentStream.close();
        tableForces.draw();
        tableForces.draw();
        tableRes.draw();


        document.save("G:/dev/inzynierka/results/my_doc.pdf");
        System.out.println("PDF created");
        document.close();

    }
}