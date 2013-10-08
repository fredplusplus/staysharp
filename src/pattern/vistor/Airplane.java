package pattern.vistor;

import java.util.LinkedList;

public class Airplane implements AirplanePart {

	private LinkedList<AirplanePart> parts;

	public Airplane() {
		parts = new LinkedList<>();
		parts.add(new Engine());
		parts.add(new Wheel());
		parts.add(new Wheel());
		parts.add(new Wheel());
	}

	@Override
	public void acceptInspection(Inspector inspector) {
		for (AirplanePart part : parts) {
			part.acceptInspection(inspector);
		}
	}
}
