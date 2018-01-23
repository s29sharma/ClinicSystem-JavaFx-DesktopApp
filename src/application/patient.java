package application;

import javafx.beans.property.SimpleStringProperty;

public class patient {
	private final SimpleStringProperty app_date;
	private final SimpleStringProperty app_time;
	private final SimpleStringProperty pro_description;

	patient(String appdate, String apptime, String prodescription) {
		this.app_date = new SimpleStringProperty(appdate);
		this.app_time = new SimpleStringProperty(apptime);
		this.pro_description = new SimpleStringProperty(prodescription);
	}

	public String getApp_date() {
		return app_date.get();
	}

	public void setapp_date(String appdate) {
		app_date.set(appdate);
	}

	public void setapp_time(String apptime) {
		app_time.set(apptime);
	}

	public void setPro_description(String prodescription) {
		pro_description.set(prodescription);
	}

	public String getApp_time() {
		return app_time.get();
	}

	public String getPro_description() {
		return pro_description.get();
	}

}
