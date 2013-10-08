package pattern.vistor;

public class Inspection {

	public void inspection() {
		Airplane plane = new Airplane();
		plane.acceptInspection(new ObserveInspector());
		plane.acceptInspection(new KickInspector());
		System.out.println("Inspection Complete!");
	}

	public static void main(String[] args) {
		Inspection in = new Inspection();
		in.inspection();
	}
}
