package utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConversion {
public static Date convertDate(String doj) {
/*SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
Date sqldate=null;
try {
	java.util.Date utildate=sdf.parse(doj);
	sqldate=new Date(utildate.getTime());
}
catch (ParseException e) {
	e.printStackTrace();
}*/
	DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate ld=LocalDate.parse(doj, formatter);
	Date sqldate=Date.valueOf(ld);
return sqldate;
}
}
