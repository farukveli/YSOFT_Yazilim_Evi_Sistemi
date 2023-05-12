package Insan_Kaynaklari;

import java.util.ArrayList;

public class InsanKaynaklari {
	
	private ArrayList<Calisan> employees;
	private ArrayList<Proje> projeler;
	private MuhasebeProgrami accountProgram;
	private TasminatServisi severanceService;
	
	
	public InsanKaynaklari(MuhasebeProgrami accountProgram,TasminatServisi severanceService) {
		super();
		this.accountProgram = accountProgram;
		this.severanceService = severanceService;
		this.employees = new ArrayList<Calisan>();
		this.projeler = new ArrayList<Proje>();
	}

	public InsanKaynaklari() {
		super();
	}
	
	public void hireEmployee(Calisan employee) {
		employees.add(employee);
	}
	
	public void assignEmployeeToProject(Proje proje, Calisan calisan) {
		for(Proje p : projeler ) {
			if (p.getProjeId()==proje.getProjeId())
				proje.addEmployee(calisan);
			else
				System.out.println("Proje Bulunamadý");
		}
	}
	
	public void layoffEmployee(Calisan employee) {
		employees.remove(employee);
	}
	
	public float calculateSalary(Calisan employee) {
		return 1;
	}
	
	public float calculateSeverancePay(Calisan employee) {
		return 1;
	}
	
	public ArrayList<Calisan> getEmployees() {
		return employees;
	}
	
	public void setEmployees(ArrayList<Calisan> employees) {
		this.employees = employees;
	}
	public ArrayList<Proje> getProjeler() {
		return projeler;
	}
	public void setProjeler(ArrayList<Proje> projeler) {
		this.projeler = projeler;
	}
	public MuhasebeProgrami getAccountProgram() {
		return accountProgram;
	}
	public void setAccountProgram(MuhasebeProgrami accountProgram) {
		this.accountProgram = accountProgram;
	}
	public TasminatServisi getSeveranceService() {
		return severanceService;
	}
	public void setSeveranceService(TasminatServisi severanceService) {
		this.severanceService = severanceService;
	}
	
	
	
}
