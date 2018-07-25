package demo.sharespace.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

	public static String getUserId(HttpServletRequest request){
		return (String)request.getSession().getAttribute("userid");
	}
	public static String getFileName(HttpServletRequest request){
		return (String)request.getSession().getAttribute("filename");
	}

	public static String getUserName(HttpServletRequest request){
		return (String)request.getSession().getAttribute("username");
	}
	
	public static String getGroupName(HttpServletRequest request){
		return (String)request.getSession().getAttribute("groupname");
	}
	
	public static String getGroupId(HttpServletRequest request){
		return (String)request.getSession().getAttribute("groupid");
	}
}
