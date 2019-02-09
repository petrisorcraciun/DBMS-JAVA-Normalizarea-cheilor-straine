package Conectare;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectareBD {
    public static String locatie_fisier;   
    public static Connection ConectareBazaDate() {
        Connection conexiune = null;
        try 
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String dbURL = "jdbc:ucanaccess://" + locatie_fisier; 
            conexiune = DriverManager.getConnection(dbURL); 
            
        } 
        catch (SQLException e) 
        {
            conexiune=null;
            if(e.getErrorCode() == 0)
            {
                JOptionPane.showMessageDialog(null, "Nu s-a realizat conexiunea la BD.", 
                                                    "Eroare conectare.", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConectareBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexiune;
    }
}
