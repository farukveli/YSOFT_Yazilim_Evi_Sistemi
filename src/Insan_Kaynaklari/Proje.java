package Insan_Kaynaklari;

import java.util.ArrayList;

public class Proje {
	private int projeId;
	private String isim;
	private int requiredEmployeeCount;
	private ArrayList<Calisan> employees;
	
	public Proje(int projeId, String isim, int requiredEmployeeCount) {
		super();
		this.projeId = projeId;
		this.isim = isim;
		this.requiredEmployeeCount = requiredEmployeeCount;
		employees = new ArrayList<Calisan>();
	}
	
	public Proje() {
		super();
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

	public int getRequiredEmployeeCount() {
		return requiredEmployeeCount;
	}

	public void setRequiredEmployeeCount(int requiredEmployeeCount) {
		this.requiredEmployeeCount = requiredEmployeeCount;
	}

	public ArrayList<Calisan> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Calisan> employees) {
		this.employees = employees;
	}
	
	
}
