package Insan_Kaynaklari;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.postgresql.util.PSQLException;

public class Proje {
	private int projeId;
	private String isim;
	private int maxRequiredEmployeeCount;
	private int minRequiredEmployeeCount;
	private int proje_durum;
	private ArrayList<Calisan> employees;
	
	public Proje(int projeId, String isim) {
		super();
		this.projeId = projeId;
		this.isim = isim;
		employees = new ArrayList<Calisan>();
	}
	
	public Proje() {
		super();
	}
	
	public int	Proje_Ekle(Connection conn, String isim, int enAz, int enCok) {
		int durum;

		try {
			String query;
			query ="INSERT INTO proje VALUES (nextval('proje_id'),?,?,?)";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, isim);
			statement.setInt(2, enAz);
			statement.setInt(3, enCok);
			statement.execute();
			durum=0;
			
		}catch(PSQLException e) {
			durum=-1;
		}
		catch (SQLException e) {
			durum=-2;
		}
		catch (java.lang.NullPointerException e) {
			durum=-3;
		}
		
		return durum;
	}
	
	public ArrayList<Proje> Proje_Oku(ArrayList<Proje> p) {
		Connect con = new Connect();
		Connection c;
		c=con.connection("YSOFT_Yazilim_Evi", "postgres", "1234");
		
		String query = "SELECT id, isim, enazcalisan, encokcalisan, durum";
		int durum = 0;
		Proje pr = new Proje();
		try {
			Statement s= c.createStatement();
			ResultSet r= s.executeQuery(query);
			while(r.next()) {
				pr.projeId=r.getInt(1);
				pr.isim=r.getString(2);
				pr.minRequiredEmployeeCount=r.getInt(3);
				pr.maxRequiredEmployeeCount=r.getInt(4);
				pr.proje_durum=r.getInt(5);
				p.add(pr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	public void addEmployee(Calisan calisan) {
		employees.add(calisan);
	}

	public void removeEmployee(Calisan calisan) {
		employees.remove(calisan);
	}
	
	public int getProjeId() {
		return projeId;
	}

	public void setProjeId(int projeId) {
		this.projeId = projeId;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public ArrayList<Calisan> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Calisan> employees) {
		this.employees = employees;
	}

	public int getMaxRequiredEmployeeCount() {
		return maxRequiredEmployeeCount;
	}

	public void setMaxRequiredEmployeeCount(int maxRequiredEmployeeCount) {
		this.maxRequiredEmployeeCount = maxRequiredEmployeeCount;
	}

	public int getMinRequiredEmployeeCount() {
		return minRequiredEmployeeCount;
	}

	public void setMinRequiredEmployeeCount(int minRequiredEmployeeCount) {
		this.minRequiredEmployeeCount = minRequiredEmployeeCount;
	}

	public int getProje_durum() {
		return proje_durum;
	}

	public void setProje_durum(int proje_durum) {
		this.proje_durum = proje_durum;
	}
	
}
