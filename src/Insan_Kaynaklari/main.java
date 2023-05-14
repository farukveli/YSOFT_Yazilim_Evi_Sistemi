package Insan_Kaynaklari;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {

	public static void main(String[] args) {
		Connect con = new Connect();
		Connection c;
		
        try {
            c=con.connection("YSOFT_Yazilim_Evi", "postgres", "1234");
            
        }
        catch (Exception e) {
            System.out.println("Baðlantý Hatasý!!!");
            e.printStackTrace();
        }

    	Login login = new Login(con.getConnection());
        login.setVisible(true);
	}
	
	
}
