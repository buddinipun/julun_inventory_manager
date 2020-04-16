package com.aptota.app.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.aptota.app.model.order.ViewQuotation;
import com.aptota.app.model.requests.QuotationReportReqest;
import com.aptota.app.model.response.GetQuotationItem;

public class ExcelOrderDetailsReport extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		 response.setHeader("Content-disposition", "attachment; filename=\"order_invoice.xls\"");
		
		 @SuppressWarnings("unchecked")
		 QuotationReportReqest quotationReport = (QuotationReportReqest) model.get("quotationReport");
		 ViewQuotation quotation =  quotationReport.getViewQuotation();
		 
		 System.out.println("quotation is : " + quotation.getMarketingexeName() + "" + quotation.getCustomerName());

		 System.out.println("quotation is : " + quotationReport);
		 List<GetQuotationItem> quotationItem = quotationReport.getOrderItemList();
		  
		 
		  Sheet sheet = workbook.createSheet("Quotation");
		  
		  Row mainheadderRow = sheet.createRow(1);
		  // Creating Header  
		  Map<String, CellStyle> styles = createStyles(workbook);
		  Row titleRow = sheet.createRow(0);
	      titleRow.setHeightInPoints(35);
	      Cell titleCell = titleRow.createCell(0);
	      titleCell.setCellValue("CEYLON JULUN GROUP (PVT) LIMITED");
	      titleCell.setCellStyle(styles.get("title"));
	      sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$G$1"));
         
	      
	      Row addressRow = sheet.createRow(1);
	      Cell addressCell = addressRow.createCell(0);
	      addressRow.setHeightInPoints(15);
	      addressCell.setCellValue("No.612, Liyanagemulla, Seeduwa.");
	      sheet.addMergedRegion(CellRangeAddress.valueOf("$A$2:$G$2"));
	      addressCell.setCellStyle(styles.get("address"));
	      
	      
	      Row contactRow = sheet.createRow(2);
	      Cell contactCell = contactRow.createCell(0);
	      contactRow.setHeightInPoints(15);
	      contactCell.setCellValue("Tel : 011-4332248/011-4332239/076-3609205/076-3609204");
	      sheet.addMergedRegion(CellRangeAddress.valueOf("$A$3:$G$3"));
	      contactCell.setCellStyle(styles.get("contact"));
	      
	      Row noticeRow = sheet.createRow(3);
	      Cell noticeCell = noticeRow.createCell(0);
	      noticeRow.setHeightInPoints(15);
	      noticeCell.setCellValue("QUOTATION");
	      sheet.addMergedRegion(CellRangeAddress.valueOf("$A$4:$G$4"));
	      noticeCell.setCellStyle(styles.get("notice"));
	      
	      Row customerCellRow = sheet.createRow(4);
	      Cell customerCellName = customerCellRow.createCell(0);
	      customerCellRow.setHeightInPoints(15);
	      customerCellName.setCellValue("Name of the Customer :" + " " + quotation.getCustomerName());
	      sheet.addMergedRegion(CellRangeAddress.valueOf("$A$5:$C$5"));
	      
	      Cell customerCellNameVal = customerCellRow.createCell(1);
	      customerCellNameVal.setCellValue(quotation.getCustomerName());
	      
	      //noticeCell.setCellStyle(styles.get("notice"));
	      
	      
	      Cell customerCellValue2 = customerCellRow.createCell(3);
	      customerCellValue2.setCellValue("Date : " + quotation.getCreateDate());
	      sheet.addMergedRegion(CellRangeAddress.valueOf("$D$5:$E$5"));
	      
	      Row salesRow = sheet.createRow(5);
	      Cell salesCellName = salesRow.createCell(0);
	      salesRow.setHeightInPoints(15);
	      salesCellName.setCellValue("Sales Person :");
	      sheet.addMergedRegion(CellRangeAddress.valueOf("$A$6:$C$6"));
	      //noticeCell.setCellStyle(styles.get("notice"));
	      
	      
	      Cell salesCellValue2 = salesRow.createCell(3);
	      salesCellValue2.setCellValue(quotation.getMarketingexeName());
	      sheet.addMergedRegion(CellRangeAddress.valueOf("$D$6:$E$6"));
	     
	      
	      
	      // header row
	      
		   
		  Row header = sheet.createRow(7);
		  
		  HSSFCellStyle style = (HSSFCellStyle) workbook.createCellStyle();
          style.setBorderBottom(BorderStyle.MEDIUM);
          style.setBorderLeft(BorderStyle.MEDIUM);
          style.setBorderRight(BorderStyle.MEDIUM);
          style.setBorderTop(BorderStyle.MEDIUM);
          style.setAlignment(CellStyle.ALIGN_CENTER);
          style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
          
          
          HSSFCellStyle styleThin = (HSSFCellStyle) workbook.createCellStyle();
          styleThin.setBorderBottom(BorderStyle.THIN);
          styleThin.setBorderLeft(BorderStyle.THIN);
          styleThin.setBorderRight(BorderStyle.THIN);
          styleThin.setBorderTop(BorderStyle.THIN);
          styleThin.setAlignment(CellStyle.ALIGN_CENTER);
          styleThin.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

          
		  header.setHeightInPoints(40);
		  Cell cell1 = header.createCell(0);
		  cell1.setCellValue("S/N");
		  
		  Cell cell2 = header.createCell(1);
		  cell2.setCellValue("Item Code");
		  sheet.autoSizeColumn(1);
		  
		  sheet.setColumnWidth(2, 10000);
		  Cell cell3 = header.createCell(2);
		  cell3.setCellValue("PRODUCT DESCRIPTIONS");
		  
		  
		  sheet.setColumnWidth(3, 4000);
		  Cell cell4 = header.createCell(3);
		  cell4.setCellValue("COLOUR");
		  
		  
		  sheet.setColumnWidth(4, 2000);
		  Cell cell5 = header.createCell(4);
		  cell5.setCellValue("QTY");
		  
		  sheet.setColumnWidth(5, 4000);
		  Cell cell6 = header.createCell(5);
		  cell6.setCellValue("Base Price");
		  
		  sheet.setColumnWidth(6, 4000);
		  Cell cell7 = header.createCell(6);
		  cell7.setCellValue("UNIT PRICE");
		  
		  Cell cell8 = header.createCell(7);
		  cell8.setCellValue("VALUE");
		  sheet.autoSizeColumn(7);
		  
		  
		  cell1.setCellStyle(style);
		  cell2.setCellStyle(style);
		  cell3.setCellStyle(style);
		  cell4.setCellStyle(style);
		  cell5.setCellStyle(style);
		  cell6.setCellStyle(style);
		  cell7.setCellStyle(style);
		  cell8.setCellStyle(style);
		 
		  
		  
		  int inititembodyRow = 8;
		  System.out.println("quotation item id : " + quotationItem);
		  for (int i = 0; i < quotationItem.size() ; i++) {
			  
			  
			  
			  inititembodyRow = inititembodyRow + i;
			  Row row = sheet.createRow(inititembodyRow);
			  row.setHeightInPoints(25);
			  Cell bodyCell;
			  	
			  		bodyCell = row.createCell(0);
			  		bodyCell.setCellValue(i);
			  		bodyCell.setCellStyle(styleThin);
			  		
			  		
			  		bodyCell = row.createCell(1);
			  		bodyCell.setCellValue(quotationItem.get(i).getItemCode());
			  		bodyCell.setCellStyle(styleThin);
			  		
			  		bodyCell = row.createCell(2);
			  		bodyCell.setCellValue(quotationItem.get(i).getItemDesciption());
			  		bodyCell.setCellStyle(styleThin);
			  		
			  		bodyCell = row.createCell(3);
			  		bodyCell.setCellValue(getItemColour(quotationItem.get(i).getItemCode()));
			  		bodyCell.setCellStyle(styleThin);
			  		
			  		
			  		bodyCell = row.createCell(4);
			  		bodyCell.setCellValue(quotationItem.get(i).getQuantity());
			  		bodyCell.setCellStyle(styleThin);
			  		
			  		bodyCell = row.createCell(5);
			  		bodyCell.setCellValue(quotationItem.get(i).getBasePrice());
			  		bodyCell.setCellStyle(styleThin);
			  		
			  		bodyCell = row.createCell(6);
			  		bodyCell.setCellValue("");
			  		bodyCell.setCellStyle(styleThin);
			  		
			  		bodyCell = row.createCell(7);
			  		bodyCell.setCellValue(quotationItem.get(i).getAmount());
			  		bodyCell.setCellStyle(styleThin);
				
					System.out.println(quotationItem.get(i).getItemCode()+  "is " + quotationItem.get(i).getQuantity() + "about " + quotationItem.get(i).getAmount());
				    //Row ih = sheet.createRow(7 + ++ih);
				 //   sheet.createRow(7 + ++i).createCell(0).setCellValue(quotationItem.get(i).getItemCode());
				    
		    
		}
		  HSSFCellStyle styletotal = (HSSFCellStyle) workbook.createCellStyle();
		  styletotal.setBorderBottom(BorderStyle.MEDIUM);
		  styletotal.setBorderLeft(BorderStyle.THIN);
		  styletotal.setBorderRight(BorderStyle.MEDIUM);
		  styletotal.setBorderTop(BorderStyle.THIN);
		  styletotal.setAlignment(CellStyle.ALIGN_CENTER);
		  styletotal.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		  Font font = workbook.createFont();
		  font.setBold(true);
		  styletotal.setFont(font);
		  
		  Row row = sheet.createRow(inititembodyRow+ 1); 
		  row.setHeightInPoints(25);
		  Cell totalCell1 = row.createCell(0);
		  totalCell1.setCellValue("Total");
		  totalCell1.setCellStyle(styletotal);
		  sheet.addMergedRegion(new CellRangeAddress(inititembodyRow+1,inititembodyRow+1,0,5));
		  
		  
		  Cell totalCell2 = row.createCell(1);
		  totalCell2.setCellStyle(styletotal);
		  Cell totalCell3 = row.createCell(2);
		  totalCell3.setCellStyle(styletotal);
		  Cell totalCell4 = row.createCell(3);
		  totalCell4.setCellStyle(styletotal);
		  Cell totalCell5 = row.createCell(4);
		  totalCell5.setCellStyle(styletotal);
		  Cell totalCell6 = row.createCell(5);
		  totalCell6.setCellStyle(styletotal);
		  Cell totalCell7 = row.createCell(6);
		  totalCell7.setCellStyle(styletotal);
		  
		  
		  Cell totalCell8 = row.createCell(7);
		  totalCell8.setCellValue(quotation.getTotalValue());
		  totalCell8.setCellStyle(styletotal);
		  
		  
		  
		  
		
		
	}
	
	
	
	/**
     * Create a library of cell styles
     */
    private static Map<String, CellStyle> createStyles(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<>();
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short)18);
        titleFont.setBold(true);
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(titleFont);
        styles.put("title", style);
        
        Font addressFont = wb.createFont();
        addressFont.setFontHeightInPoints((short)10);
        addressFont.setBold(true);
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(addressFont);
        styles.put("address", style);
        

        Font contactFont = wb.createFont();
        contactFont.setFontHeightInPoints((short)10);
        //contactFont.setBold(true);
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(contactFont);
        styles.put("contact", style);   
        
        
        Font noticeFont = wb.createFont();
        noticeFont.setFontHeightInPoints((short)11);
        noticeFont.setBold(true);
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFont(noticeFont);
        styles.put("notice", style); 
        
        Font monthFont = wb.createFont();
        monthFont.setFontHeightInPoints((short)11);
        monthFont.setColor(IndexedColors.WHITE.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(monthFont);
        style.setWrapText(true);
        styles.put("header", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setWrapText(true);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        styles.put("cell", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("formula", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("formula_2", style);

        return styles;
    }
    
    public String getItemColour(String itemCode) {
    	String colorName = null;
    	char colorCode = itemCode.charAt(3);
        
    	if (colorCode == ' ') {
    		colorName = "";
    	} else if (colorCode == 'G') {
    		colorName = "Brick Red";
    	} else if (colorCode == 'A') {
    		colorName = "Rose Red";
    	}else if (colorCode == 'H') {
    		colorName = "Chocolate Brown";
    	}else if (colorCode == 'C') {
    		colorName = "Dark Green";
    	}else if (colorCode == 'E') {
    		colorName = "Dark Gray";
    	}else if (colorCode == 'B') {
    		colorName = "Dark Blue";
    	}else {
    		colorName = "";
    	}
    	return colorName;
    }

}
