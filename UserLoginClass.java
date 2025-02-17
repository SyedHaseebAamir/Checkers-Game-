import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UserLoginClass {

    public boolean LoginUser(String uname, String upass) {
        String loginString = "SELECT * FROM login WHERE UserName=? AND UserPass=?";
        boolean isLoggedIn = false;

        ConnectionToDB connectionToDB = new ConnectionToDB();
        Connection con = connectionToDB.EstablishConnection();
        if (con != null) {
            try (PreparedStatement pstmt = con.prepareStatement(loginString)) {
                pstmt.setString(1, uname);
                pstmt.setString(2, upass);
                try (ResultSet res = pstmt.executeQuery()) {
                    isLoggedIn = res.next();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Login Error: " + ex.getMessage());
            } finally {
                try {
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error closing connection: " + ex.getMessage());
                }
            }
        }
        return isLoggedIn;
    }
    
    public boolean addUser(String username, String password) {
        ConnectionToDB connectionToDB = new ConnectionToDB();
        Connection con = connectionToDB.EstablishConnection();
        boolean isSuccess = false;

        if (con != null) {
            String insertUserSQL = "INSERT INTO login (UserName, UserPass) VALUES (?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(insertUserSQL)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
                isSuccess = true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            } finally {
                try {
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error closing connection: " + ex.getMessage());
                }
            }
        }
        return isSuccess;
    }

}
