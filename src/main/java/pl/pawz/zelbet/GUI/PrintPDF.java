package pl.pawz.zelbet.GUI;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import javax.swing.text.StyleConstants;
import java.io.File;
import java.io.IOException;

public class PrintPDF {
    public static final String DEST
            = "/hello_table.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new PrintPDF().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        try (Document document = new Document(pdf)) {
            Table table = new Table(3);
            Cell cell = new Cell(1, 3)
                    .setTextAlignment(TextAlignment.CENTER)
                    .add(new Paragraph("Cell with colspan 3"));
            table.addCell(cell);
            cell = new Cell(2, 1)
                    .add(new Paragraph("Cell with rowspan 2"))
                    .setVerticalAlignment(VerticalAlignment.MIDDLE);
            table.addCell(cell);
            table.addCell("Cell 1.1");
            table.addCell(new Cell().add(new Paragraph("Cell 1.2")));
            table.addCell(new Cell()
                    .add(new Paragraph("Cell 2.1"))
                    .setMargin(5));
            table.addCell(new Cell()
                    .add(new Paragraph("Cell 1.2"))

                    .setPadding(5));

            document.add(table);
        }
    }
}