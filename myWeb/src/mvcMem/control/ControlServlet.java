package mvcMem.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcMem.action.Action;


public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
	   
	   String cmd = request.getParameter("cmd");
	   if(cmd != null) {
		   ActionFactory factory = ActionFactory.getInstance();//싱글톤 객체
		   Action action = factory.getAction(cmd); //factory메서드 : cmd매개변수의 값에 따라서 클래스 생성
		   ActionForward af = action.execute(request, response); //다형성을 이용해서(실행을 시켜줌) Action클래스에 오버라이딩이 다 되어있기떄문에 => 팩토리에서 만들어 주기때문에
		   if(af.isRedirect()) {
			   System.out.println("isRedirect()=true redirect");
			   response.sendRedirect(af.getUrl());
		   } else {
			   System.out.println("isRedirect()=false forward");
			   RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());
			   rd.forward(request, response);
			   
		   }
	   } else {
		   PrintWriter out = response.getWriter();
		   response.setContentType("text/html;charset=utf-8");
		   out.println("<html>");
		   out.println("<head><title>Error</title></head>");
		   out.println("<body>");
		   out.println("<h4>올바른 요청이 아닙니다!</h4>");
		   out.println("<h4>http://localhost:8080/myWeb/mvcMem/member.mdo?cmd=요청키워드</h4>");
		   out.println("</body>");
		   out.println("</html>");
	   }
   }

}
