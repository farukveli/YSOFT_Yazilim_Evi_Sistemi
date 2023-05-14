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
		employees = new Calisan().Calisan_Oku(employees);
		projeler = new Proje().Proje_Oku(projeler);
		
	}

	public InsanKaynaklari() {
		super();
	}
	
	public void hireEmployee(Calisan employee) {
		employees.add(employee);
	}
	
	public int assignEmployeeToProject() {
		int i=0;
		int j=0;
		while( projeler.get(i) != null
				&& projeler.get(i).getMinRequiredEmployeeCount()<= projeler.get(i).getEmployees().size()) {
			i++;
		}
		
		if(projeler.get(i) != null) {
			while( employees.get(j) != null && employees.get(i).getProjeler().size()!= 0) {
				j++;
			}
			if(employees.get(j) != null) {
				projeler.get(i).addEmployee(employees.get(j));
				employees.get(j).addProject(projeler.get(i));
			}
		}else {
			i=0;
			while( projeler.get(i) != null
					&& projeler.get(i).getMaxRequiredEmployeeCount()>= projeler.get(i).getEmployees().size()) {
				i++;
			}
			if(projeler.get(i) != null) {
				j=0;
				while( employees.get(j) != null && employees.get(i).getProjeler().size()!= 0) {
					j++;
				}
				if(employees.get(j) != null) {
					projeler.get(i).addEmployee(employees.get(j));
					employees.get(j).addProject(projeler.get(i));
				}
			}
		}
		return 0;
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
