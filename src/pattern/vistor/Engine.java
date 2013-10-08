package pattern.vistor;

public class Engine implements AirplanePart {

	@Override
	public void acceptInspection(Inspector inspector) {
		inspector.inspect(this);
	}

	@Override
	public String toString() {
		return "Lycomin OJ-320";
	}
}
