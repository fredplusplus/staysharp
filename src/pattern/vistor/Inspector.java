package pattern.vistor;

public interface Inspector {
	
	void inspect(Engine engine);

	void inspect(Wheel wheel);
}
