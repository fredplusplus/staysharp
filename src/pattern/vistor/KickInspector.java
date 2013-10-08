package pattern.vistor;

public class KickInspector implements Inspector {

	@Override
	public void inspect(Engine engine) {
		System.out.println("Kicking at engine " + engine);
	}

	@Override
	public void inspect(Wheel wheel) {
		System.out.println("Kicking at wheel " + wheel);

	}

}
