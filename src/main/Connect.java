package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @desc A singleton database access class for MySQL
 * @author Ramindu
 */
public final class Connect {
	    
    public static Connect db;
    private Statement statement;
    public Connection conn;
    private Connect() {
    	boolean status = false;
    	
		
		PreparedStatement pst = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "episunsa_gradesTracker";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
			}
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized Connect getDbCon() {
        if ( db == null ) {
            db = new Connect();
        }
        return db;
 
    }
    public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int resultado = 0;
        int result = statement.executeUpdate(insertQuery,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()){
            resultado=rs.getInt(1);
        }
        return resultado;
 
    }
 
}