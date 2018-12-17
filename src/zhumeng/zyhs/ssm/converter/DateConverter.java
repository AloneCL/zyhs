package zhumeng.zyhs.ssm.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter implements Converter<String, Date> {

	
	public String convert(Date str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(str);

		//return format.parse(str);

	}
	/*public static void main(String[] args) throws ParseException {
		String dt="Mon Feb 12 18:29:43 CST 2018";

		SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);

		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println(sdf2.parse(sdf2.format(sdf1.parse(dt))));  
	}
*/

	@Override
	public Date convert(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
