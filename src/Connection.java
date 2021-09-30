import java.sql.*;


public class Connection {
    public static java.sql.Connection getConn() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/contactbook", "yourusername", "password");
            return (con);
        } finally {
            System.out.println("Connected Successfully!");
        }
    }
    
    public static void main(String[] args) throws Exception {
        java.sql.Connection con = getConn();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id,alias,phone FROM contacts");

        while (rs.next()) {
            System.out.println("ID    : " + rs.getInt(1));
            System.out.println("Alias : " + rs.getString(2));
            System.out.println("Phone : " + rs.getString(3) + "\n");
        }
    }
}
