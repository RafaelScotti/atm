package atm;

public class Hardware {
	private HardwareType ht;
	
	public Hardware(HardwareType ht) {
		this.ht = ht;
	}
	
	HardwareType getInstace() {
		return HardwareType.getInstance();
	}
}
