package demo.sharespace.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

	public static String getUserId(HttpServletRequest request){
		return (String)request.getSession().getAttribute("userid");
	}
	
}
