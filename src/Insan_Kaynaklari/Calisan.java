package Insan_Kaynaklari;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.postgresql.util.PSQLException;

public class Calisan {
	private int id;
	private String isim;
	private String position;
	private ArrayList<Proje> projeler;
	private int muhasebeProg;
	
	public Calisan(int id, String isim, String position, int muhasebeProg) {
		super();
		this.id = id;
		this.isim = isim;
		this.position = position;
		this.muhasebeProg = muhasebeProg;
		projeler = new ArrayList<Proje>();
	}
	
	public int Calisan_Ekle(Connection conn, String isim, String position, int muhasebe) {
		int durum;

		try {
			String query;
			query ="INSERT INTO calisan VALUES (nextval('calisan_id'),?,?,?)";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, isim);
			statement.setString(2, position);
			statement.setInt(3, muhasebe);
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
	
	public ArrayList<Calisan> Calisan_Oku(ArrayList<Calisan> l) {
		Connect con = new Connect();
		Connection c;
		c=con.connection("YSOFT_Yazilim_Evi", "postgres", "1234");
		
		String query = "SELECT id, isim, pozisyon, muhasebe";
		int durum = 0;
		Calisan cl = new Calisan();
		try {
			Statement s= c.createStatement();
			ResultSet r= s.executeQuery(query);
			while(r.next()) {
				cl.id=r.getInt(1);
				cl.isim=r.getString(2);
				cl.position=r.getString(3);
				cl.muhasebeProg=r.getInt(4);
				l.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}
		
	public void removeProject(Proje proje) {
		projeler.remove(proje);
	}
	
	public void addProject(Proje proje) {
		projeler.add(proje);
	}
	
	public Calisan() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public ArrayList<Proje> getProjeler() {
		return projeler;
	}

	public void setProjeler(ArrayList<Proje> projeler) {
		this.projeler = projeler;
	}

	public int getMuhasebeProg() {
		return muhasebeProg;
	}

	public void setMuhasebeProg(int muhasebeProg) {
		this.muhasebeProg = muhasebeProg;
	}


	
}
