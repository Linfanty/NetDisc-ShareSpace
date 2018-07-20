package demo.sharespace.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/space/*")
public class LoginFilter implements Filter { // 登录过滤器

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    	// 初始化
    	// 当容器第一次加载该过滤器时，init() 方法将被调用。该类在这个方法中包含了一个指向 Filter Config 对象的引用。
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	/*
	 * 过滤
	过滤器的大多数时间都消耗在这里。doFilter方法被容器调用，
	同时传入分别指向这个请求/响应链中的 Servlet Request、Servlet Response 和 Filter Chain 对象的引用。
	然后过滤器就有机会处理请求，
	将处理任务传递给链中的下一个资源(通过调用 Filter Chain 对象引用上的 doFilter方法)，
	之后在处理控制权返回该过滤器时处理响应。
	  */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request; // 客户端的请求
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;  // 客户端的相应
		HttpSession session = httpServletRequest.getSession(); // 返回当前reqeust中的HttpSession  存储登录信息
		
		// session.setAttribute( ,"login_flag") : 将login_flag保存在session中
		String loginFlag = (String)session.getAttribute("login_flag");  // 得到session中存储的 login_flag 用户对象信息
		String username = (String)session.getAttribute("username"); // 得到session中存储的 username 用户对象信息
		
		if("-1".equals(loginFlag) || username == null){ // 登录日志不匹配 ||用户名为空 则跳转得到登录界面
			httpServletResponse.sendRedirect("/ShareSpace/login.jsp");
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response); // 将请求转发给过滤器链上下一个对象
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
