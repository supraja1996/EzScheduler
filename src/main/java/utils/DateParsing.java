package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateParsing {
	
	
	public  String dateparsing(String date) throws Exception {
		
		String formatdate = null;
		String Formatdate = null;
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("E, MMM dd");
		SimpleDateFormat formatter3 = new SimpleDateFormat("MMMM yyyy");
		SimpleDateFormat formatter4 = new SimpleDateFormat("dd");
		SimpleDateFormat formatter5 = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat formatter6=new SimpleDateFormat("E\n"+"dd-MMM");

		
		try {
			Date FormattedDate = formatter1.parse(date);
			formatdate = formatter4.format(FormattedDate);
		
			}catch (ParseException e) {
				try {
					Date FormattedDate = formatter2.parse(date);
					formatdate = formatter4.format(FormattedDate);

				}catch (ParseException e1) {
					try {
					Date FormattedDate = formatter3.parse(date);
					formatdate = formatter1.format(FormattedDate);
					}catch (ParseException e2) {
						try {
							Date FormattedDate = formatter5.parse(date);
							formatdate = formatter4.format(FormattedDate);
						}catch (ParseException e3) {
							try {
								Date FormattedDate = formatter6.parse(date);
								formatdate = formatter4.format(FormattedDate);
								// = String.format("%02d", formatdate1);
							}catch (ParseException e4) {
								
							}
						}
					}
					
				}
		
		}
		return formatdate;
	}

	public String monthparsing(String date) throws Exception{
		String month1 = null;
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("E, MMM dd");
		SimpleDateFormat formatter3 = new SimpleDateFormat("MMMM yyyy");
		SimpleDateFormat formatter4 = new SimpleDateFormat("MM");
		SimpleDateFormat formatter5 = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat formatter6=new SimpleDateFormat("E\n"+"dd-MMM");

		try {
			Date FormattedDate = formatter1.parse(date);
		    month1 = formatter4.format(FormattedDate);
		}catch (ParseException e) {
			try {
				Date FormattedDate = formatter2.parse(date);
				month1 = formatter4.format(FormattedDate);
			}
			catch (ParseException e1) {
				try {
				Date FormattedDate = formatter3.parse(date);
				month1 = formatter4.format(FormattedDate);
				}catch (ParseException e2) {
					try {
						Date FormattedDate = formatter5.parse(date);
						month1 = formatter4.format(FormattedDate);
					}catch (ParseException e3) {
						try {
							Date FormattedDate = formatter6.parse(date);
							month1 = formatter4.format(FormattedDate);
						}catch (ParseException e4) {
							
						}
					}
				}
				
			}
			
		}
		return month1;
		
		
	}
	public String yearparsing(String date) throws Exception{
		String year1 = null;
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("E, MMM dd");
		SimpleDateFormat formatter3 = new SimpleDateFormat("MMMM yyyy");
		SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy");
		SimpleDateFormat formatter5 = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat formatter6=new SimpleDateFormat("E\n"+"dd-MMM");

		try {
			Date FormattedDate = formatter1.parse(date);
			year1 = formatter4.format(FormattedDate);
		}catch (ParseException e) {
			try {
				Date FormattedDate = formatter3.parse(date);
				year1 = formatter4.format(FormattedDate);
			}
			catch (ParseException e1) {
				try {
					Date FormattedDate = formatter5.parse(date);
					year1 = formatter4.format(FormattedDate);
				}catch (ParseException e3) {
					
				}
			}
			 
		}
		return year1;
		
		
	}
	
	public String dateconversion(String date) throws Exception{
		
		String Date = null;
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter2=new SimpleDateFormat("E\n"+"dd-MMM");
		try {
			Date FormattedDate = formatter1.parse(date);
			Date = formatter2.format(FormattedDate);
		}catch (ParseException e1) {
			try {
				Date FormattedDate = formatter2.parse(date);
				Date = formatter1.format(FormattedDate);
			}catch (ParseException e2) {
				
			}
		}

		return Date;
		
		
	}
	public String weekparsing(String date) throws Exception{
		String week = null;
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("E, MMM dd");
//		SimpleDateFormat formatter3 = new SimpleDateFormat("MMMM yyyy");
//		SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy");
		SimpleDateFormat formatter3 = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat formatter4=new SimpleDateFormat("E\n"+"dd-MMM");
		SimpleDateFormat formatter5 = new SimpleDateFormat("E");
		try {
			Date FormattedDate = formatter1.parse(date);
			week = formatter4.format(FormattedDate);
		}catch(ParseException e1) {
			try { 
				Date FormattedDate = formatter2.parse(date);
				week = formatter4.format(FormattedDate);
			}catch(ParseException e2) {
				try {
				Date FormattedDate = formatter3.parse(date);
				week = formatter4.format(FormattedDate);
				}catch(ParseException e3) {
					try {
					Date FormattedDate = formatter3.parse(date);
					week = formatter4.format(FormattedDate);
					}catch(ParseException e4) {
						
					}
				}
			}
		}
		return week;
	}
}
