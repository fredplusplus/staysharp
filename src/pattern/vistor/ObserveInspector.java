package pattern.vistor;

public class ObserveInspector implements Inspector {

	@Override
	public void inspect(Engine engine) {
		System.out.println("Looking at engine " + engine);
	}

	@Override
	public void inspect(Wheel wheel) {
		System.out.println("Looking at wheel " + wheel);

	}

}
