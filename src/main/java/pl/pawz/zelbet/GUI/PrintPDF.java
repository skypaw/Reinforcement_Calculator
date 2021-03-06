package pl.pawz.zelbet.GUI;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.HorizontalAlignment;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.line.LineStyle;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.IOException;


class PrintPDF {

    static void print(String name, double fYk, double rHData, double daysData, double mEdData, double mEkData, double mEkLtData,
                      double vEdData, double vEdRedData, double nEdData, char cementChar, double concreteFCk, double aS1Data, double aS2Data, double aS1RealData, double aS2RealData, double nS1Data, double nS2Data, double mRdData,
                      double wCalcData, double wRealData, double fMCalcData, double fMRealData, double fCsCalcData, double fSumCalcData,double fCsRealData, double fSumRealData, double alphaData,
                      double fi1Data, double fi2Data, double nSw1, double nSw2, double fiw1Data, double fiw2Data, double s1Data, double s2Data,
                      double vRdData, double nSw1Real, double nSw2Real, double fiw1DataReal, double fiw2DataReal, double s1RealData,
                      double s2RealData, double vRdRealData, double fiCrawlingData, double bData, double hData, double cNomData, double a1Data, double a2Data,
                      double bEffData, double hFData, double bEffTData, double hFTData, double lEff, double alphaMData, double nRd, double cotTheta) throws IOException {

        double mEd = roundThreeDigit(mEdData * Math.pow(10, 3));
        double mEk = roundThreeDigit(mEkData * Math.pow(10, 3));
        double mEkLt = roundThreeDigit(mEkLtData * Math.pow(10, 3));
        double vEd = roundThreeDigit(vEdData * Math.pow(10, 3));
        double vRdReal = roundThreeDigit(vRdRealData * Math.pow(10, 3));
        double vEdRed = roundThreeDigit(vEdRedData * Math.pow(10, 3));
        double nEd = roundThreeDigit(nEdData * Math.pow(10, 3));
        double mRd = roundThreeDigit(mRdData * Math.pow(10, 3));
        double fCsCalc = roundThreeDigit(fCsCalcData);
        double fCsReal = roundThreeDigit(fCsRealData);
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
        double s1 = roundThreeDigit(s1Data);
        double s1Real = roundThreeDigit(s1RealData);

        double s2 = roundThreeDigit(s2Data);
        double s2Real = roundThreeDigit(s2RealData);


        System.out.println(s1);
        System.out.println(s1Data);

        String valueRods1 = (int) nS1Data + " fi " + (int) (fi1Data * Math.pow(10, 3));
        String valueRods2 = (int) nS2Data + " fi " + (int) (fi2Data * Math.pow(10, 3));

        String rods = "Prety odgiete alpha = " + alphaData;

        String valueRodsShearing1 = (int) nSw1 + " fi " + (int) (fiw1Data * Math.pow(10, 3));
        String valueRodsShearing2 = (int) nSw2 + " fi " + (int) (fiw2Data * Math.pow(10, 3));

        String valueRodsShearing1Real = (int) nSw1Real + " fi " + (int) (fiw1DataReal * Math.pow(10, 3));
        String valueRodsShearing2Real = (int) nSw2Real + " fi " + (int) (fiw2DataReal * Math.pow(10, 3));

        String cotThetaString = "cot_Theta = " + cotTheta;

        String mEdString = mEd + " / ";
        String mRdString = mRd + " / ";

        //Creating PDF document object
        PDDocument document = new PDDocument();
        PDPage blankPage = new PDPage();
        document.addPage(blankPage);

        //1st heading - name

        PDPageContentStream contentStream = new PDPageContentStream(document, blankPage);

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 10);
        contentStream.setLeading(12.0f);
        contentStream.newLineAtOffset(50, 740);

        contentStream.showText("Nazwa zadania: " + name);


        // Title Table
        float margin = 50;
        float yStartNewPage = blankPage.getMediaBox().getHeight() - (2 * margin);
        float tableWidth = blankPage.getMediaBox().getWidth() - (2 * margin);

        float bottomMargin = 70;
        float yPosition = 725;

        BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, true);

        Row<PDPage> headerRow = table.createRow(12f);
        textCell(headerRow.createCell(100, "D A N E"));


        table.addHeaderRow(headerRow);

        //data section


        contentStream.newLine();
        contentStream.newLine();
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("PARAMETRY MATERIALOWE:");
        contentStream.newLine();
        contentStream.showText("      Beton: f_ck " + concreteFCk + "(cement: " + cementChar + ")");
        contentStream.newLine();
        contentStream.showText("      Stal: f_yk = " + fYk + "MPa");
        contentStream.newLine();
        contentStream.newLine();
        contentStream.showText("PARAMETRY DODATKOWE:");
        contentStream.newLine();
        contentStream.showText("      RH: " + rHData + "%");
        contentStream.newLine();
        contentStream.showText("      Wiek t_0: " + daysData + "dni");
        contentStream.newLine();
        contentStream.showText("      Fi(inf,t_0) = " + fiCrawling);


        //Table results

        float yPositionForces = 600;

        BaseTable tableForces = new BaseTable(yPositionForces, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, true);

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
        contentStream.showText("      M_Ek,lt: " + mEkLt + " kNm");
        contentStream.newLine();
        contentStream.showText("N_Ed: " + nEd + " kN");
        contentStream.newLine();
        contentStream.showText("V_Ed: " + vEd + " kN / V_Ed,red = " + vEdRed + " kN");

        contentStream.newLineAtOffset(170, 180);
        contentStream.showText("PARAMETRY GEOMETRYCZNE:");
        contentStream.newLine();
        contentStream.showText("    h = " + h + "m");
        contentStream.newLine();
        contentStream.showText("    b = " + b + "m");
        contentStream.newLine();
        contentStream.showText("        b_eff = " + beff + "m, h_f = " + hf + "m");
        contentStream.newLine();
        contentStream.showText("        b_eff,T = " + befft + "m, h_fT = " + hft + "m");
        contentStream.newLine();
        contentStream.showText("    a_1 = " + a1 + "m, a_2 = " + a2 + "m, c_nom = " + cNomData + "m");
        contentStream.newLine();
        contentStream.showText("    l_eff = " + lEff + "m, alpha_m = " + alphaM);


        float yPositionRes = 500;

        BaseTable tableRes = new BaseTable(yPositionRes, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, true);

        Row<PDPage> headerRowRes = tableRes.createRow(12f);
        textCell(headerRowRes.createCell(100, "W Y N I K I"));

        tableRes.addHeaderRow(headerRowRes);

        float yPositionResults = 475;

        BaseTable tableResults = new BaseTable(yPositionResults, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, true);

        Row<PDPage> headerRowResults = tableResults.createRow(15f);
        textCell(headerRowResults.createCell(100, "Stan graniczny nosnosci SGN"));
        tableResults.addHeaderRow(headerRowResults);

        Row<PDPage> rowDesc1 = tableResults.createRow(10);
        Row<PDPage> rowDesc2 = tableResults.createRow(10);
        Row<PDPage> rowDesc3 = tableResults.createRow(10);
        Row<PDPage> row = tableResults.createRow(12);
        Row<PDPage> row1 = tableResults.createRow(12);

        rowDesc1.createCell(20, "").setBottomBorderStyle(LineStyle.produceDotted(Color.WHITE, 0));
        textCell(rowDesc1.createCell(35, "Zbrojenie obliczeniowe"));
        textCell(rowDesc1.createCell(45, "Zbrojenie zastosowane"));

        middleCell(rowDesc2.createCell(20, "Zbrojenie"));
        textCell(rowDesc2.createCell(15, "Powierzchnia"));
        textCell(rowDesc2.createCell(20, "Nosnosc M_Rd/N_Rd"));
        textCell(rowDesc2.createCell(10, "Liczba/srednica"));
        textCell(rowDesc2.createCell(15, "Powierzchnia"));
        textCell(rowDesc2.createCell(20, "Nosnosc M_Rd/N_Rd"));

        rowDesc3.createCell(20, "").setTopBorderStyle(LineStyle.produceDotted(Color.WHITE, 0));
        textCell(rowDesc3.createCell(15, "[cm^2]"));
        textCell(rowDesc3.createCell(20, "[kNm]/[kN]"));
        textCell(rowDesc3.createCell(10, "[szt.]/[mm]"));
        textCell(rowDesc3.createCell(15, "[cm^2]"));
        textCell(rowDesc3.createCell(20, "[kNm]/[kN]"));


        row.createCell(20, "Rozciagane A_s1");
        greenCell(row.createCell(15, String.valueOf(aS1Data)));
        greenCellWhiteBottom(row.createCell(20, mEdString));
        blueCellGrey(row.createCell(10, valueRods1));
        greenCell(row.createCell(15, String.valueOf(aS1RealData)));
        greenCellWhiteBottom(row.createCell(20, mRdString));

        row1.createCell(20, "Sciskane A_s2");
        greenCell(row1.createCell(15, String.valueOf(aS2Data)));
        greenCell(row1.createCell(20, String.valueOf(nEd)));
        blueCellGrey(row1.createCell(10, valueRods2));
        greenCell(row1.createCell(15, String.valueOf(aS2RealData)));
        greenCell(row1.createCell(20, String.valueOf(nRd)));


        // Table for Shearing


        float yPositionResultsV = 340;

        BaseTable tableResultsV = new BaseTable(yPositionResultsV, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, true);

        Row<PDPage> headerRowResultsV = tableResultsV.createRow(15f);
        textCell(headerRowResultsV.createCell(100, "Stan graniczny nosnosci - scinanie"));
        tableResultsV.addHeaderRow(headerRowResultsV);

        Row<PDPage> VDesc1 = tableResultsV.createRow(10);
        Row<PDPage> VDesc2 = tableResultsV.createRow(10);
        Row<PDPage> VDesc3 = tableResultsV.createRow(10);
        Row<PDPage> rowV = tableResultsV.createRow(12);
        Row<PDPage> rowV1 = tableResultsV.createRow(12);

        VDesc1.createCell(30, "").setBottomBorderStyle(LineStyle.produceDotted(Color.WHITE, 0));
        textCell(VDesc1.createCell(35, "Zbrojenie obliczeniowe"));
        textCell(VDesc1.createCell(35, "Zbrojenie zastosowane"));

        middleCell(VDesc2.createCell(30, "Zbrojenie"));
        textCell(VDesc2.createCell(10, "Srednica"));
        textCell(VDesc2.createCell(10, "Rozstaw"));
        textCell(VDesc2.createCell(15, "Nosnosc V_Rd"));
        textCell(VDesc2.createCell(10, "Srednica"));
        textCell(VDesc2.createCell(10, "Rozstaw"));
        textCell(VDesc2.createCell(15, "Nosnosc V_Rd"));

        cotTheta(VDesc3.createCell(30, cotThetaString));
        textCell(VDesc3.createCell(10, "[szt.]/[mm]"));
        textCell(VDesc3.createCell(10, "[m]"));
        textCell(VDesc3.createCell(15, "[kN]"));
        textCell(VDesc3.createCell(10, "[szt.]/[mm]"));
        textCell(VDesc3.createCell(10, "[m]"));
        textCell(VDesc3.createCell(15, "[kN]"));


        rowV.createCell(30, "Strzemiona");
        blueCell(rowV.createCell(10, valueRodsShearing1));
        greenCell(rowV.createCell(10, String.valueOf(s1)));
        greenCellWhiteBottom(rowV.createCell(15, String.valueOf(vEd)));
        greenCellGrey(rowV.createCell(10, valueRodsShearing1Real));
        blueCellGrey(rowV.createCell(10, String.valueOf(s1Real)));
        greenCellWhiteBottom(rowV.createCell(15, String.valueOf(vRdReal)));

        rowV1.createCell(30, rods);
        blueCell(rowV1.createCell(10, valueRodsShearing2));
        blueCell(rowV1.createCell(10, String.valueOf(s2)));
        greenCell(rowV1.createCell(15, ""));
        blueCellGrey(rowV1.createCell(10, valueRodsShearing2Real));
        blueCellGrey(rowV1.createCell(10, String.valueOf(s2Real)));
        greenCell(rowV1.createCell(15, ""));


        //Table for SLS


        float yPositionResultsSLS = 210;

        BaseTable tableResultsSLS = new BaseTable(yPositionResultsSLS, yStartNewPage, bottomMargin, tableWidth, margin, document, blankPage, true, true);


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
        greenCell(rowSLS.createCell(25, String.valueOf(wCalcData)));
        greenCellGrey(rowSLS.createCell(25, String.valueOf(wRealData)));

        rowSLS1.createCell(30, "Ugiecie od obciazenia");
        textCell(rowSLS1.createCell(10, "f_M"));
        textCell(rowSLS1.createCell(10, "[cm]"));
        greenCell(rowSLS1.createCell(25, String.valueOf(fMCalcData)));
        greenCell(rowSLS1.createCell(25, String.valueOf(fMRealData)));

        rowSLS2.createCell(30, "Ugiecie od skurczu");
        textCell(rowSLS2.createCell(10, "f_cs"));
        textCell(rowSLS2.createCell(10, "[cm]"));
        greenCell(rowSLS2.createCell(25, String.valueOf(fCsCalc)));
        greenCell(rowSLS2.createCell(25, String.valueOf(fCsReal)));

        rowSLS3.createCell(30, "Ugiecie calkowite");
        textCell(rowSLS3.createCell(10, "f_M + f_cs"));
        textCell(rowSLS3.createCell(10, "[cm]"));
        greenCell(rowSLS3.createCell(25, String.valueOf(fSumCalcData)));
        greenCellGrey(rowSLS3.createCell(25, String.valueOf(fSumRealData)));


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

    private static void middleCell(Cell cell) {
        cell.setBottomBorderStyle(LineStyle.produceDotted(Color.WHITE, 0));
        cell.setTopBorderStyle(LineStyle.produceDotted(Color.WHITE, 0));
        cell.setAlign(HorizontalAlignment.CENTER);
    }


    private static void cotTheta(Cell cell) {
        cell.setTopBorderStyle(LineStyle.produceDotted(Color.WHITE, 0));
        cell.setAlign(HorizontalAlignment.CENTER);
    }

    private static void greenCellWhiteBottom(Cell cell) {
        greenCell(cell);
        cell.setBottomBorderStyle(LineStyle.produceDotted(Color.WHITE, 0));
    }

}