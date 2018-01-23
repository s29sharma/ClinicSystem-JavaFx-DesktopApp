package application;

public class procedure {
	private String procedureDetails;
	private int cost;

	public procedure(String proceduredetails, int cost) {
		this.procedureDetails = proceduredetails;
		this.cost = cost;

	}

	public String getProcedureDetails() {
		return procedureDetails;
	}

	public void setProcedureDetails(String procedureDetails) {
		this.procedureDetails = procedureDetails;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}