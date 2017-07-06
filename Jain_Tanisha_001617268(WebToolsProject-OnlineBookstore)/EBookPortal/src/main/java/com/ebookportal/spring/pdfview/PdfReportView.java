package com.ebookportal.spring.pdfview;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.ebookportal.spring.dao.OrderDetailsDAO;
import com.ebookportal.spring.pojo.OrderDetails;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReportView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Font font_helvetica_14_bold_blue = new Font(Font.HELVETICA, 14, Font.BOLD, Color.BLUE); 
		Font font_courier_16_italic_red = new Font(Font.COURIER, 16, Font.ITALIC, Color.RED);
		Font font_courier_16_bold_black = new Font(Font.COURIER, 16, Font.BOLD, Color.BLACK);
		
		HttpSession session = request.getSession();
		long userId = (Long) session.getAttribute("userId");
		String username = (String)session.getAttribute("username");
		
		OrderDetailsDAO orDet = new OrderDetailsDAO();
		List odList = orDet.listDetails(userId);
		
		Paragraph p1 = new Paragraph("Online Bookstore - Your Order History", font_courier_16_bold_black);
		pdfdoc.add(p1);
		
		Paragraph p2 = new Paragraph("Customer Id: "+String.valueOf(userId), font_courier_16_italic_red);
		pdfdoc.add(p2);
		
		Paragraph p3 = new Paragraph("Customer Name: "+username, font_courier_16_italic_red);
		pdfdoc.add(p3);
		
		Iterator orderIterator = odList.iterator();
		while (orderIterator.hasNext())
         {
             OrderDetails order = (OrderDetails) orderIterator.next();
        
        Paragraph prg1 = new Paragraph("Date of purchase: "+order.getDate(), font_helvetica_14_bold_blue);
		
		PdfPTable tablehead = new PdfPTable(4); // 6 columns.

        PdfPCell cell1 = new PdfPCell(new Paragraph("Order Id"));
        PdfPCell cell3 = new PdfPCell(new Paragraph("Book Title"));
        PdfPCell cell4 = new PdfPCell(new Paragraph("Author"));
        PdfPCell cell5 = new PdfPCell(new Paragraph("Price"));

        tablehead.addCell(cell1);
        tablehead.addCell(cell3);
        tablehead.addCell(cell4);
        tablehead.addCell(cell5);
        
        PdfPTable tablebody = new PdfPTable(4); // 6 columns.

        PdfPCell cell6 = new PdfPCell(new Paragraph(String.valueOf(order.getOrderId())));
        PdfPCell cell8 = new PdfPCell(new Paragraph(order.getBookName()));
        PdfPCell cell9 = new PdfPCell(new Paragraph(order.getBookAuthor()));
        PdfPCell cell10 = new PdfPCell(new Paragraph(String.valueOf(order.getPrice())));

        tablebody.addCell(cell6);
        tablebody.addCell(cell8);
        tablebody.addCell(cell9);
        tablebody.addCell(cell10);
        
        tablehead.setSpacingBefore(10f);
        tablebody.setSpacingAfter(20f);
        
        pdfdoc.add(prg1);
		pdfdoc.add(tablehead);
		pdfdoc.add(tablebody);
		
		}
	}
}
