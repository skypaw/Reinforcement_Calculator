package pl.pawz.zelbet.GUI;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;

class PrintPDF {

    static void print(String name, double fYk) throws IOException {

        String namePdf = name;
        String concrete = "C25/30";
        String cement = "N";
        Double fyk = fYk;
        String rH = "50";
        String days = "28";
        String mEd = "28";
        String mEk = "28";
        String mEkLt = "28";
        String vEd = "28";
        String vEdRed = "28";
        String nEd = "28";
        double aS1 = 0;
        double aS2 = 0;
        double aS1Real = 0;
        double aS2Real = 0;
        double nS1 = 0;
        double nS2 = 0;
        double mRd = 0;



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


        float yPositionRes = 510;

        BaseTable tableRes = new BaseTable(yPositionRes, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRowRes = tableRes.createRow(12f);
        Cell<PDPage> cellRes = headerRowRes.createCell(100, "W Y N I K I");

        tableRes.addHeaderRow(headerRowRes);

        float yPositionResults = 475;

        BaseTable tableResults = new BaseTable(yPositionResults, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRowResults = tableResults.createRow(15f);
        Cell<PDPage> cellResults = headerRowResults.createCell(100, "Stan graniczny nosnosci SGN");
        tableResults.addHeaderRow(headerRowResults);


        Row<PDPage> row = tableResults.createRow(12);
        Row<PDPage> row1 = tableResults.createRow(12);

        cellResults = row.createCell(25, "Rozciagane");
        cellResults = row.createCell(15, String.valueOf(aS1));
        cellResults = row.createCell(15, String.valueOf(mEd));
        cellResults = row.createCell(15, String.valueOf(nS1));
        cellResults = row.createCell(15, String.valueOf(aS1Real));
        cellResults = row.createCell(15, String.valueOf(mRd));

        cellResults = row1.createCell(25, "Sciskane");
        cellResults = row1.createCell(15, String.valueOf(aS2));
        cellResults = row1.createCell(15, String.valueOf(mEd));
        cellResults = row1.createCell(15, String.valueOf(nS2));
        cellResults = row1.createCell(15, String.valueOf(aS2Real));
        cellResults = row1.createCell(15, String.valueOf(mRd));


        float yPositionResultsV = 390;

        BaseTable tableResultsV = new BaseTable(yPositionResultsV, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRowResultsV = tableResultsV.createRow(15f);
        Cell<PDPage> cellResultsV = headerRowResultsV.createCell(100, "Stan graniczny nosnosci - scinanie");
        tableResultsV.addHeaderRow(headerRowResultsV);


        Row<PDPage> rowV = tableResultsV.createRow(12);
        Row<PDPage> rowV1 = tableResultsV.createRow(12);

        cellResults = rowV.createCell(25, "Strzemiona");
        cellResults = rowV.createCell(15, String.valueOf(aS1));
        cellResults = rowV.createCell(15, String.valueOf(mEd));
        cellResults = rowV.createCell(15, String.valueOf(nS1));
        cellResults = rowV.createCell(15, String.valueOf(aS1Real));
        cellResults = rowV.createCell(15, String.valueOf(mRd));

        cellResults = rowV1.createCell(25, "Prety odgiete");
        cellResults = rowV1.createCell(15, "Some value");
        cellResults = rowV1.createCell(15, "Some value");
        cellResults = rowV1.createCell(15, "Some value");
        cellResults = rowV1.createCell(15, "Some value");
        cellResults = rowV1.createCell(15, "Some value");


        float yPositionResultsSLS = 310;

        BaseTable tableResultsSLS = new BaseTable(yPositionResultsSLS, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRowResultsSLS = tableResultsSLS.createRow(15f);
        Cell<PDPage> cellResultsSLS = headerRowResultsSLS.createCell(100, "Stan graniczny uzytkowalnosci SGU - zginanie");
        tableResultsSLS.addHeaderRow(headerRowResultsSLS);


        Row<PDPage> rowSLS = tableResultsSLS.createRow(12);
        Row<PDPage> rowSLS1 = tableResultsSLS.createRow(12);
        Row<PDPage> rowSLS2 = tableResultsSLS.createRow(12);
        Row<PDPage> rowSLS3 = tableResultsSLS.createRow(12);

        cellResults = rowSLS.createCell(30, "Zarysowanie");
        cellResults = rowSLS.createCell(10, "w");
        cellResults = rowSLS.createCell(10, "[mm]");
        cellResults = rowSLS.createCell(25, String.valueOf(nS1));
        cellResults = rowSLS.createCell(25, String.valueOf(aS1Real));


        cellResults = rowSLS1.createCell(30, "Ugiecie od obciazenia");
        cellResults = rowSLS1.createCell(10, "f_M");
        cellResults = rowSLS1.createCell(10, "[cm]");
        cellResults = rowSLS1.createCell(25, "Some value");
        cellResults = rowSLS1.createCell(25, "Some value");

        cellResults = rowSLS2.createCell(30, "Ugiecie od skurczu");
        cellResults = rowSLS2.createCell(10, "f_cs");
        cellResults = rowSLS2.createCell(10, "[cm]");
        cellResults = rowSLS2.createCell(25, "Some value");
        cellResults = rowSLS2.createCell(25, "Some value");

        cellResults = rowSLS3.createCell(30, "Ugiecie calkowite");
        cellResults = rowSLS3.createCell(10, "f_M + f_cs");
        cellResults = rowSLS3.createCell(10, "[cm]");
        cellResults = rowSLS3.createCell(25, "Some value");
        cellResults = rowSLS3.createCell(25, "Some value");


        table.draw();
        contentStream.close();
        tableForces.draw();
        tableForces.draw();
        tableRes.draw();
        tableResults.draw();
        tableResultsV.draw();
        tableResultsSLS.draw();

        document.save(name + ".pdf");
        System.out.println("PDF created");
        document.close();

    }
}