package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.SQLExceptionList;

public final class ConnectionPool {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	//사용하지 않은 커넥션 즉 , 초기 커넥션을 저장하는 변수
	private ArrayList<Connection> free;
	private ArrayList<Connection> used; //사용중인 커넥션 저장하는 변수
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String user = "dlsdyd1245"; private String password = "tmxk5313";
	private int initialCons = 10;	//최초 초기 커넥션 수
	private int maxCons = 20; //최대 커넥션 수
	private int numCons = 0; //총 Connection 수
	private static ConnectionPool cp;
	public static ConnectionPool getInstance() {
		try {
			if(cp == null) {
				synchronized (ConnectionPool.class) {
					cp = new ConnectionPool();
				}
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return cp;
	}
	private ConnectionPool() throws SQLException {
		//초기 커넥션 개수를 가각의 ArrayList에 저장할 수 있도록 초기 커넥션 수만큼 ArrayList 생성
		free = new ArrayList<Connection>(initialCons);
		used = new ArrayList<Connection>(initialCons);
		//initialCons 수만큼 Connection 생성(free)
		while(numCons < initialCons) {
			addConnection();
		}
	}
	//free에 커넥션 객체를 저장함
	private void addConnection() throws SQLException {
		free.add(getNewConnection());
	}
	//새로운 커넥션 객체를 생성함
	private Connection getNewConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Abouc to connect to " + con);
		++numCons; //커넥션 생성될 때 마다 숫자 증가
		return con;
	}
	// free에 있는 커넥션을 used로 옮기는 작업 ==> free -----> used
	public synchronized Connection getConnection() throws SQLException {
		//free에 connection이 없으면 maxCons만큼 Connection을 더 생성
		if(free.isEmpty()) {
			while(numCons < maxCons) {
				addConnection();
			}
		}
		
		Connection _con;
		_con = free.get(free.size() - 1); //바구니안에 있는 마지막 객체를 제거하고 빌려준다
		free.remove(_con);
		used.add(_con);
		return _con;
	}
	// used에 있는 커넥션을 free로 반납함
	public synchronized void releaseConnection(Connection _con) throws SQLException {
		boolean flag = false;
		if(used.contains(_con)) {
			used.remove(_con);
			numCons--;
			flag = true;
		}else {
			throw new SQLException("ConnectionPool에 있지 않네요");
		}
		try {
			if(flag) {
				free.add(_con); numCons++;
			}else {
				_con.close();
			}
		}catch(SQLException e) {
			try {
				_con.close();
			}catch(SQLExceptionList e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void CloseAll() { //모든 Connection 자원을 반납함
		//usd에 있는 커넥션을 모두 삭제
		for(int i=0; i<used.size(); i++) {
			Connection _con = (Connection)used.get(i);
			used.remove(i--);
			try {
				_con.close();
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		//free에 있는 커넥션을 모두 삭제해버림
		for(int i=0; i<free.size(); i++) {
			Connection _con = (Connection)free.get(i);
			free.remove(i--);
			try {
				_con.close();
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
	public int getmaxCons() {
		return maxCons;
		
	}
	public int getNumCons() {
		return numCons;
	}
}
