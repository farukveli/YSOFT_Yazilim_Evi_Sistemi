package Insan_Kaynaklari;

import java.util.ArrayList;

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
