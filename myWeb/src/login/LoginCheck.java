package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ConnUtil;


@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	
    	//db���� ����� ���� ��ȸ �����
    	//db���� ��ȸ�� ������� ���̵� ����� ��ġ�ϴ� ���
    	//Ŭ���̾�Ʈ�� ������ httpsession��ü�� ���� ��Ų��
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	String sql = "select pass from login where id = ? ";
    	try {
    		conn = ConnUtil.getConnection();
    		pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, id);
   		    		
    		rs = pstmt.executeQuery();
    		    		
    		if(rs.next()) {
    			String dbPw = rs.getString("pass");
    			
    			
    			if(dbPw.equals(pwd)) {
    				//HttpSession ��ü ���
    				HttpSession session = request.getSession();
    				//Ŭ���̾�Ʈ�� ������ HttpSession��ü�� ����
    				session.setAttribute("user", id);
    			}
    			
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {if(rs != null)rs.close(); } catch(SQLException e) {}
    		try {if(pstmt != null)pstmt.close(); } catch(SQLException e) {}
    		try {if(conn != null) conn.close(); } catch(SQLException e) {}
    	}
    	response.sendRedirect("Login");
//    	String dbID = "admin";
//    	String dbPWD = "1234";
//    	if(dbID.equals(id) && dbPWD.equals(pwd)) {
//    		HttpSession session = request.getSession();
//    		
//    		session.setAttribute("user", id);
//    	}
//    	response.sendRedirect("Login");
    	
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
