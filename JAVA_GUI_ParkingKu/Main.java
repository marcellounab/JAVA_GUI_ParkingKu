package ParkingKUFinal;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ParkingKULogin pl = new ParkingKULogin();
        pl.setVisible(true);
        pl.pack();
        pl.setSize(500,525);
        pl.setLocationRelativeTo(null);
        pl.setDefaultCloseOperation(ParkingKURegister.EXIT_ON_CLOSE);
	}

}