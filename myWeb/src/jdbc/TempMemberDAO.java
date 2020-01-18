package jdbc;
import java.sql.*;
import java.util.*;
import jdbc.TempMemberVO;

public class TempMemberDAO {
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private final String USER = "dlsdyd1245";
	private final String PASS = "tmxk5313";
	public TempMemberDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e) {
			System.out.println("ERROR");
		}
	}
	
	public Vector<TempMemberVO> getMemberList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Vector<TempMemberVO> vecList = new Vector<TempMemberVO>();
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String strQuery = "select * from tempmember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(strQuery);
			while(rs.next()) {
				TempMemberVO vo = new TempMemberVO();
				vo.setId(rs.getString("id"));
			}
		}catch(Exception e) {
			
	
		
		}
	return vecList;
	}
	
	
}
