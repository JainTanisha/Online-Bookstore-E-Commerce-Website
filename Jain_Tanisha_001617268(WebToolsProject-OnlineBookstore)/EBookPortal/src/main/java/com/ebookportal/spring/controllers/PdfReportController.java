package com.ebookportal.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.ebookportal.spring.pdfview.PdfReportView;


@Controller
public class PdfReportController {
	
	@RequestMapping(value = "/report.pdf", method = RequestMethod.GET)
	public ModelAndView createReport()
	{
		View view = new PdfReportView();
		
		return new ModelAndView(view);
	}
}
