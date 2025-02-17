import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionToDB {

    Connection con = null;

     public Connection EstablishConnection() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\lenovo\\Documents\\NetBeansProjects\\chessgui\\login.accdb");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Connection Error: " + ex.getMessage());
        }
        return con;
    }
  public boolean LoginUser(String uname, String upass) {
    String loginString = "SELECT * FROM login WHERE UserName=? AND UserPass=?";
    boolean b;

 

    Connection con = EstablishConnection();
    try {
       PreparedStatement pstmt = con.prepareStatement(loginString);
        ResultSet res = pstmt.executeQuery();
        pstmt.setString(1, uname);
        pstmt.setString(2, upass);
        res = pstmt.executeQuery();
        b = res.next();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
        b = false;
    }
    return b;
  }
   
}

    

  

