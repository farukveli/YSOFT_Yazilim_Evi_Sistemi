package Insan_Kaynaklari;

public class MuhasebeProgrami {
	private int programID;
	private String name;
	public MuhasebeProgrami(int programID, String name) {
		super();
		this.programID = programID;
		this.name = name;
	}
	
	public MuhasebeProgrami() {
		super();
	}
	
	public float maasHesapla(Calisan employee) {
		return 1;
	}
	
	
	public int getProgramID() {
		return programID;
	}
	
	public void setProgramID(int programID) {
		this.programID = programID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
