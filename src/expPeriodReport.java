import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Statement;

public class expPeriodReport 
{
	public  expPeriodReport(ResultSet rs) 
	{
		//-------------------------------------------variables to calculate debts,paid,still need to pay -----------------------
		double allValue=0;
		double allValueAfterTax=0;
		double tax=0;
		float taxValue=0;
		
		String vatQuery = "SELECT ערך FROM `dynamic` WHERE `שם משתנה` = 'מעמ'  ";
	try{
		Statement stt = (Statement) Driver.getDatabaseDriver().conn.createStatement();
		ResultSet vatValSet = stt.executeQuery(vatQuery);
		vatValSet.next();
		taxValue = Float.parseFloat(vatValSet.getString(1));
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
		
		String url = "C:\\temp\\";

		//----------------------------------------------------------------------------------------------------------------------
			try
			{
				

				// Listing 1. Instantiation of document object
				Document document = new Document(PageSize.A4, 0, 0, 50, 50);
				
				File file = new File(url);
				if (!file.exists())
					{
						file.mkdir(); 
						
					}
				PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(url + "expPeriodReport.pdf"));


				writer.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
				//opening the document to write into it
				document.open();
				
				//----------------------------------------------------client information---------------------------------------------
				PdfPTable infotable = new PdfPTable(1);
				infotable.setSpacingAfter(10);
				infotable.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

				PdfPCell infoCell1 = new PdfPCell();
				infoCell1.addElement(new Phrase("קונדיטוריית רחל",Fonts.Arial14Bold));
				infoCell1.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				infotable.addCell(infoCell1);

				PdfPCell infoCell3 = new PdfPCell();
				infoCell3.addElement(new Phrase("אבו סנאן",Fonts.Arial12));
				infoCell3.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				infotable.addCell(infoCell3);

				PdfPCell infoCell4 = new PdfPCell();
				infoCell4.addElement(new Phrase("נייד : 054-6885673 , פקס : 04-9963601",Fonts.Arial12));
				infoCell4.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				infotable.addCell(infoCell4);

				document.add(infotable);

				//----------------------------------------------------report subject ---------------------------------------------
				PdfPTable subjecttable = new PdfPTable(1);
				subjecttable.setWidthPercentage(25);
				subjecttable.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

				PdfPCell subjectCell = new PdfPCell();
				subjectCell.addElement(new Phrase("דוח הוצאות תקופתי",Fonts.Arial14BoldItalic));
				subjectCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				subjecttable.addCell(subjectCell);

				document.add(subjecttable);			
				//----------------------------------------------------projectProducts Bid  table-------------------------------------------

				PdfPTable table = new PdfPTable(4);
				table.setSpacingBefore(15);
				table.setSpacingAfter(15);
				table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

				//first cell
				PdfPCell cell = new PdfPCell();
				Paragraph p1 = new Paragraph("תאריך ושעה",Fonts.Arial);
				p1.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.setColspan(1);
				cell.addElement(p1);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//second cell
				Paragraph p2 = new Paragraph("תיאור הוצאה",Fonts.Arial);
				p2.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.addElement(p2);
				cell.setColspan(1);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//third cell
				Paragraph p3 = new Paragraph("סוג הוצאה",Fonts.Arial);
				p3.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.addElement(p3);
				cell.setColspan(1);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//5th cell
				Paragraph p5 = new Paragraph("סכום",Fonts.Arial);
				p5.setAlignment(PdfPCell.ALIGN_CENTER);
				cell.setColspan(1);
				cell.addElement(p5);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				cell=new PdfPCell();

				//getting the data from income period table in database


				while(rs.next())
				{
					//product date time 
					String cell1 = rs.getString(1);
					//first name 
					String cell2 = rs.getString(2);
					//last name
					String cell3 = rs.getString(3);
					//price
					String cell5 = rs.getString(4);

					// calculating the income value 
					allValueAfterTax+=Double.parseDouble(cell5);
					
					//first cell
					cell = new PdfPCell();
					p1 = new Paragraph(cell1,Fonts.Arial);
					p1.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p1);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					cell=new PdfPCell();

					//second cell
					p2 = new Paragraph(cell2,Fonts.Arial);
					p2.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p2);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					cell=new PdfPCell();

					//third cell
					p3 = new Paragraph(cell3,Fonts.Arial);
					p3.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p3);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					cell=new PdfPCell();

					//5th cell
					p5 = new Paragraph(cell5,Fonts.Arial);
					p5.setAlignment(PdfPCell.ALIGN_CENTER);
					cell.setColspan(1);
					cell.addElement(p5);
					table.addCell(cell);
					cell=new PdfPCell();
				}
				document.add(table);

				//----------------------------------------------Value table---------------------------------------------------------------
				allValue=allValueAfterTax/(1+taxValue);
				
				tax=allValue*taxValue;
				
				PdfPTable beforelastTable = new PdfPTable(2);
				beforelastTable.setSpacingBefore(5);
				beforelastTable.setSpacingAfter(5);
				beforelastTable.setWidthPercentage(40);
				beforelastTable.setRunDirection(PdfWriter.RUN_DIRECTION_RTL); 

				PdfPCell beforelastCell = new PdfPCell();
				beforelastCell.addElement(new Phrase("סך הכל לפני מעמ : ",Fonts.Arial14Bold));
				beforelastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				beforelastTable.addCell(beforelastCell);
				
				beforelastCell = new PdfPCell();
				beforelastCell.addElement(new Phrase(String.valueOf(Math.round(allValue*100.0)/100.0),Fonts.Arial14Bold));
				beforelastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				beforelastTable.addCell(beforelastCell);
			
				beforelastCell = new PdfPCell();
				beforelastCell.addElement(new Phrase("סך הכל  מעמ : ",Fonts.Arial14Bold));
				beforelastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				beforelastTable.addCell(beforelastCell);
				
				beforelastCell = new PdfPCell();
				beforelastCell.addElement(new Phrase(String.valueOf(Math.round(tax*100.0)/100.0),Fonts.Arial14Bold));
				beforelastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				beforelastTable.addCell(beforelastCell);
				
				beforelastCell = new PdfPCell();
				beforelastCell.addElement(new Phrase("סך הכל אחרי מעמ : ",Fonts.Arial14Bold));
				beforelastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				beforelastTable.addCell(beforelastCell);
				
				beforelastCell = new PdfPCell();
				beforelastCell.addElement(new Phrase(String.valueOf(allValueAfterTax),Fonts.Arial14Bold));
				beforelastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				beforelastTable.addCell(beforelastCell);
				document.add(beforelastTable);

				
				
				//----------------------------------------------last table , signature ---------------------------------------------------
				PdfPTable lastTable = new PdfPTable(1);
				lastTable.setSpacingBefore(10);
				lastTable.setSpacingAfter(20);
				lastTable.setRunDirection(PdfWriter.RUN_DIRECTION_LTR); 

				PdfPCell lastCell = new PdfPCell();
				lastCell.addElement(new Phrase("       בברכה\n קונדיטוריית רחל",Fonts.Arial14Bold));
				lastCell.setBorder(com.itextpdf.text.Rectangle.NO_BORDER);
				lastTable.addCell(lastCell);
				document.add(lastTable);

				//---------------------------------------------closing the document-------------------------------------------------
				document.close();
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
}
