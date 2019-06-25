
public class Orang {
	int id;
	String nama;
	String alamat;
	String gender;
	String agama;
	String golDarah;

	public Orang() {

	}

	public Orang(int id, String name, String alamat, String gender, String agama, String gd) {
		this.id = id;
		this.nama = name;
		this.alamat = alamat;
		this.gender = gender;
		this.agama = agama;
		this.golDarah = gd;
	}

	public void cetak() {
		System.out.println("ID " + id);
		System.out.println("Name " + nama);
		System.out.println("alamat " + alamat);
		System.out.println("Gender " + gender);
		System.out.println("Agama " + agama);
		System.out.println("GOl Darah " + golDarah);
	}
}
