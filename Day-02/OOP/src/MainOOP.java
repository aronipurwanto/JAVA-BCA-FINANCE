
public class MainOOP {
	public static void main(String[] args) {
		String nilai ="ABC";
		
		Orang org1 = new Orang();
		org1.id=1;
		org1.nama="ROni";
		org1.gender = "Pria";
		org1.golDarah="B";
		org1.cetak();
		
		Orang org2 = new Orang();
		org2.id=2;
		org2.nama="Guntur";
		org2.gender = "Pria";
		org2.golDarah="O";
		
		org2.cetak();
		
		Orang org3 = new Orang(3, "Livia", "Tanggera", "Wanita", "Budha", "O");
		org3.cetak();
	}
}
