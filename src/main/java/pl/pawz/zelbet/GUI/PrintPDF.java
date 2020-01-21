package pl.pawz.zelbet.GUI;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.HorizontalAlignment;
import be.quodlibet.boxable.Row;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.IOException;


class PrintPDF {

    static void print(String name, double fYk, double rHData, double daysData, double mEdData, double mEkData, double mEkLtData,
                      double vEdData, double vEdRedData, double nEdData, char cementChar, double concreteFCk, double aS1Data, double aS2Data, double aS1RealData, double aS2RealData, double nS1Data, double nS2Data, double mRdData,
                      double wCalcData, double wRealData, double fMCalcData, double fMRealData, double fCsCalcData, double fSumCalcData, double fSumRealData, double alphaData,
                      double fi1Data, double fi2Data, double nSw1, double nSw2, double fiw1Data, double fiw2Data, double s1, double s2,
                      double vRdData, double nSw1Real, double nSw2Real, double fiw1DataReal, double fiw2DataReal, double s1Real,
                      double s2Real, double vRdRealData, double fiCrawlingData, double bData, double hData, double cNomData, double a1Data, double a2Data,
                      double bEffData,double hFData, double bEffTData, double hFTData, double lEff, double alphaMData) throws IOException {

        String namePdf = name;

        double concrete = concreteFCk;
        char cement = cementChar;
        double fyk = fYk;
        double rH = rHData;
        double days = daysData;
        double mEd = roundThreeDigit(mEdData * Math.pow(10, 3));
        double mEk = roundThreeDigit(mEkData * Math.pow(10, 3));
        double mEkLt = roundThreeDigit(mEkLtData * Math.pow(10, 3));
        double vEd = roundThreeDigit(vEdData * Math.pow(10, 3));
        double vRd = roundThreeDigit(vRdData * Math.pow(10, 3));
        double vRdReal = roundThreeDigit(vRdRealData * Math.pow(10, 3));
        double vEdRed = roundThreeDigit(vEdRedData * Math.pow(10, 3));
        double nEd = roundThreeDigit(nEdData * Math.pow(10, 3));
        double aS1 = aS1Data;
        double aS2 = aS2Data;
        double aS1Real = aS1RealData;
        double aS2Real = aS2RealData;
        double nS1 = nS1Data;
        double nS2 = nS2Data;
        double mRd = roundThreeDigit(mRdData * Math.pow(10, 3));
        double wCalc = wCalcData;
        double wReal = wRealData;
        double fMCalc = fMCalcData;
        double fMReal = fMRealData;
        double fCsCalc = fCsCalcData;
        double fCsReal = fCsCalcData;
        double fSumCalc = fSumCalcData;
        double fSumReal = fSumRealData;
        double alpha = alphaData;
        double fiCrawling = roundThreeDigit(fiCrawlingData);
        double hf = roundThreeDigit(hFData);
        double hft = roundThreeDigit(hFTData);
        double beff = roundThreeDigit(bEffData);
        double befft = roundThreeDigit(bEffTData);
        double b = roundThreeDigit(bData);
        double h = roundThreeDigit(hData);
        double alphaM = roundThreeDigit(alphaMData);
        double a1 = roundThreeDigit(a1Data);
        double a2 = roundThreeDigit(a2Data);

        String valueRods1 = nS1 + " fi " + fi1Data * Math.pow(10, 3);
        String valueRods2 = nS2 + " fi " + fi2Data * Math.pow(10, 3);

        String rods = "Prety odgiete alpha = " + alpha;

        String valueRodsShearing1 = nSw1 + " fi " + fiw1Data * Math.pow(10, 3);
        String valueRodsShearing2 = nSw2 + " fi " + fiw2Data * Math.pow(10, 3);

        String valueRodsShearing1Real = nSw1Real + " fi " + fiw1DataReal * Math.pow(10, 3);
        String valueRodsShearing2Real = nSw2Real + " fi " + fiw2DataReal * Math.pow(10, 3);


        //Creating PDF document object
        PDDocument document = new PDDocument();
        PDPage blankPage = new PDPage();
        document.addPage(blankPage);

        //1st heading - name

        PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 10);
        contentStream.setLeading(12.0f);
        contentStream.moveTextPositionByAmount(50, 740);

        contentStream.showText("Nazwa zadania: " + namePdf);


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
        textCell(headerRow.createCell(100, "D A N E"));


        table.addHeaderRow(headerRow);

        //data section


        contentStream.newLine();
        contentStream.newLine();
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("PARAMETRY MATERIALOWE:      PARAMETRY GEOMETRYCZNE:");
        contentStream.newLine();
        contentStream.showText("      Beton: f_ck " + concrete + "(cement: " + cement + ")        h = " + h+"m");
        contentStream.newLine();
        contentStream.showText("      Stal: f_yk = " + fyk + "MPa                 b = " + b+"m");
        contentStream.newLine();
        contentStream.showText("                                                           b_eff = "+beff+"m, h_f = "+hf+"m");
        contentStream.newLine();
        contentStream.showText("PARAMETRY DODATKOWE:                b_eff,T = "+befft+"m, h_fT = "+hft+"m");
        contentStream.newLine();
        contentStream.showText("      RH: " + rH + "%                                        a_1 = " + a1 + "m, a_2 = " + a2 + "m, c_nom = " + cNomData+"m");
        contentStream.newLine();
        contentStream.showText("      Wiek t_0: " + days + "dni                              l_eff = "+lEff+"m, alpha_m = "+alphaM);
        contentStream.newLine();
        contentStream.showText("      Fi(inf,t_0) = " + fiCrawling);


        //Table results

        float yPositionForces = 600;

        BaseTable tableForces = new BaseTable(yPositionForces, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRowForces = tableForces.createRow(12f);
        textCell(headerRowForces.createCell(100, "SILY WEWNETRZNE"));

        tableForces.addHeaderRow(headerRowForces);


        contentStream.newLine();
        contentStream.newLine();
        contentStream.newLine();

        contentStream.newLine();
        contentStream.showText("M_Ed: " + mEd + " kNm");
        contentStream.newLine();
        contentStream.showText("      M_Ek: " + mEk + " kNm");
        contentStream.newLine();
        contentStream.showText("      M_Ek: " + mEkLt + " kNm");
        contentStream.newLine();
        contentStream.showText("N_Ed: " + nEd + " kN");
        contentStream.newLine();
        contentStream.showText("V_Ed: " + vEd + " kN / V_Ed,red = " + vEdRed + " kN");


        float yPositionRes = 500;

        BaseTable tableRes = new BaseTable(yPositionRes, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRowRes = tableRes.createRow(12f);
        textCell(headerRowRes.createCell(100, "W Y N I K I"));

        tableRes.addHeaderRow(headerRowRes);

        float yPositionResults = 475;

        BaseTable tableResults = new BaseTable(yPositionResults, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRowResults = tableResults.createRow(15f);
        textCell(headerRowResults.createCell(100, "Stan graniczny nosnosci SGN"));
        tableResults.addHeaderRow(headerRowResults);


        Row<PDPage> row = tableResults.createRow(12);
        Row<PDPage> row1 = tableResults.createRow(12);

        row.createCell(25, "Rozciagane A_s1");
        greenCell(row.createCell(15, String.valueOf(aS1)));
        greenCell(row.createCell(15, String.valueOf(mEd)));
        blueCellGrey(row.createCell(15, String.valueOf(valueRods1)));
        greenCell(row.createCell(15, String.valueOf(aS1Real)));
        greenCell(row.createCell(15, String.valueOf(mRd)));

        row1.createCell(25, "Sciskane A_s2");
        greenCell(row1.createCell(15, String.valueOf(aS2)));
        greenCell(row1.createCell(15, String.valueOf(mEd)));
        blueCellGrey(row1.createCell(15, String.valueOf(valueRods2)));
        greenCell(row1.createCell(15, String.valueOf(aS2Real)));
        greenCell(row1.createCell(15, String.valueOf(mRd)));


        // Table for Shearing


        float yPositionResultsV = 390;

        BaseTable tableResultsV = new BaseTable(yPositionResultsV, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);

        Row<PDPage> headerRowResultsV = tableResultsV.createRow(15f);
        textCell(headerRowResultsV.createCell(100, "Stan graniczny nosnosci - scinanie"));
        tableResultsV.addHeaderRow(headerRowResultsV);


        Row<PDPage> rowV = tableResultsV.createRow(12);
        Row<PDPage> rowV1 = tableResultsV.createRow(12);

        rowV.createCell(30, "Strzemiona");
        blueCell(rowV.createCell(10, String.valueOf(valueRodsShearing1)));
        greenCell(rowV.createCell(10, String.valueOf(s1)));
        greenCell(rowV.createCell(15, String.valueOf(vRd)));
        greenCellGrey(rowV.createCell(10, String.valueOf(valueRodsShearing1Real)));
        blueCellGrey(rowV.createCell(10, String.valueOf(s1Real)));
        greenCell(rowV.createCell(15, String.valueOf(vRdReal)));

        rowV1.createCell(30, rods);
        blueCell(rowV1.createCell(10, String.valueOf(valueRodsShearing2)));
        blueCell(rowV1.createCell(10, String.valueOf(s2)));
        greenCell(rowV1.createCell(15, String.valueOf(vRd)));
        blueCellGrey(rowV1.createCell(10, String.valueOf(valueRodsShearing2Real)));
        blueCellGrey(rowV1.createCell(10, String.valueOf(s2Real)));
        greenCell(rowV1.createCell(15, String.valueOf(vEdRedData)));


        //Table for SLS


        float yPositionResultsSLS = 310;

        BaseTable tableResultsSLS = new BaseTable(yPositionResultsSLS, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, drawContent);


        Row<PDPage> headerRowResultsSLS = tableResultsSLS.createRow(15f);
        textCell(headerRowResultsSLS.createCell(100, "Stan graniczny uzytkowalnosci SGU - zginanie"));

        tableResultsSLS.addHeaderRow(headerRowResultsSLS);

        Row<PDPage> rowSLSSubtitle = tableResultsSLS.createRow(12);
        Row<PDPage> rowSLS = tableResultsSLS.createRow(12);
        Row<PDPage> rowSLS1 = tableResultsSLS.createRow(12);
        Row<PDPage> rowSLS2 = tableResultsSLS.createRow(12);
        Row<PDPage> rowSLS3 = tableResultsSLS.createRow(12);


        textCell(rowSLSSubtitle.createCell(50, "Parametr SGU"));
        textCell(rowSLSSubtitle.createCell(25, "Zbrojenie obliczeniowe"));
        textCell(rowSLSSubtitle.createCell(25, "Zbrojenie zastosowane"));

        //Content rows

        rowSLS.createCell(30, "Zarysowanie");
        textCell(rowSLS.createCell(10, "w"));
        textCell(rowSLS.createCell(10, "[mm]"));
        greenCell(rowSLS.createCell(25, String.valueOf(wCalc)));
        greenCellGrey(rowSLS.createCell(25, String.valueOf(wReal)));

        rowSLS1.createCell(30, "Ugiecie od obciazenia");
        textCell(rowSLS1.createCell(10, "f_M"));
        textCell(rowSLS1.createCell(10, "[cm]"));
        greenCell(rowSLS1.createCell(25, String.valueOf(fMCalc)));
        greenCell(rowSLS1.createCell(25, String.valueOf(fMReal)));

        rowSLS2.createCell(30, "Ugiecie od skurczu");
        textCell(rowSLS2.createCell(10, "f_cs"));
        textCell(rowSLS2.createCell(10, "[cm]"));
        greenCell(rowSLS2.createCell(25, String.valueOf(fCsCalc)));
        greenCell(rowSLS2.createCell(25, String.valueOf(fCsReal)));

        rowSLS3.createCell(30, "Ugiecie calkowite");
        textCell(rowSLS3.createCell(10, "f_M + f_cs"));
        textCell(rowSLS3.createCell(10, "[cm]"));
        greenCell(rowSLS3.createCell(25, String.valueOf(fSumCalc)));
        greenCellGrey(rowSLS3.createCell(25, String.valueOf(fSumReal)));


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

    private static void textCell(Cell cell) {
        cell.setAlign(HorizontalAlignment.CENTER);
    }

    private static void greenCell(Cell cell) {
        float[] hsb = new float[3];
        Color.RGBtoHSB(0, 176, 80, hsb);

        cell.setTextColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
        cell.setAlign(HorizontalAlignment.CENTER);
    }

    private static void greenCellGrey(Cell cell) {
        greenCell(cell);

        float[] hsb = new float[3];
        Color.RGBtoHSB(231, 230, 230, hsb);

        cell.setFillColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    }

    private static void blueCell(Cell cell) {
        float[] hsb = new float[3];
        Color.RGBtoHSB(0, 176, 240, hsb);

        cell.setTextColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
        cell.setAlign(HorizontalAlignment.CENTER);
    }

    private static void blueCellGrey(Cell cell) {
        blueCell(cell);

        float[] hsb = new float[3];
        Color.RGBtoHSB(231, 230, 230, hsb);

        cell.setFillColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    }

    private static double roundThreeDigit(double toRound) {
        return Math.round(toRound * 1000.00) / 1000D;
    }
}