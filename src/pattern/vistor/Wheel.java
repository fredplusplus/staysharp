package pattern.vistor;

public class Wheel implements AirplanePart {

	@Override
	public void acceptInspection(Inspector inspector) {
		inspector.inspect(this);
	}

	@Override
	public String toString() {
		return "Michilin Stuff";
	}
}
