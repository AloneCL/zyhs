package zhumeng.zyhs.wechat.link;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class GetAccessTokenServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		new Thread(new TokenThread()).start();		//启动定时获取access_token的线程
	    
	}
}
