package MusicAlbums;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class Database {
    private Statement statement;
    private static Database db_instance = null;
    private Connection conn = null;
    private Database(){
//        @Override
//        public Connection getConnection() {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                conn = DriverManager.getConnection("jdbc:mysql://localhost:1521:xe", "dba", "sql");
//            }
//            catch (ClassNotFoundException ex) {
//                Logger.getLogger(MysqlResourceConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SQLException ex) {
//                Logger.getLogger(MysqlResourceConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return con;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dba", "sql");
            statement = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static java.sql.Statement get_statement(){
        if(db_instance==null){ db_instance = new Database();
        }return db_instance.statement;
    }
    public static void exit(){
        if(db_instance!=null){
            try { db_instance.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
