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
		   ActionFactory factory = ActionFactory.getInstance();//�̱��� ��ü
		   Action action = factory.getAction(cmd); //factory�޼��� : cmd�Ű������� ���� ���� Ŭ���� ����
		   ActionForward af = action.execute(request, response); //�������� �̿��ؼ�(������ ������) ActionŬ������ �������̵��� �� �Ǿ��ֱ⋚���� => ���丮���� ����� �ֱ⶧����
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
		   out.println("<h4>�ùٸ� ��û�� �ƴմϴ�!</h4>");
		   out.println("<h4>http://localhost:8080/myWeb/mvcMem/member.mdo?cmd=��ûŰ����</h4>");
		   out.println("</body>");
		   out.println("</html>");
	   }
   }

}
