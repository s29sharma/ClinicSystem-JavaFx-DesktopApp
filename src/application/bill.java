package application;

public class bill {
	private final int tax_percent = 15;

	public int hst(int total) {
		int hs = total * tax_percent / 100;
		return hs;
	}

	public int gettaxpercent() {
		return this.tax_percent;
	}

	@Override
	public String toString() {
		return "The Applicable Tax is: " + tax_percent + "%";
	}
}
