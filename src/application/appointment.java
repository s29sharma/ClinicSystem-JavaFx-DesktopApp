package application;

//import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class appointment {
	private final SimpleStringProperty app_date;
	private final SimpleStringProperty app_time;
	private final SimpleStringProperty doc_name;

	appointment(String appdate, String apptime, String docname) {
		this.app_date = new SimpleStringProperty(appdate);
		this.app_time = new SimpleStringProperty(apptime);
		this.doc_name = new SimpleStringProperty(docname);
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

	public void setdoc_name(String docname) {
		doc_name.set(docname);
	}

	public String getApp_time() {
		return app_time.get();
	}

	public String getDoc_name() {
		return doc_name.get();
	}

}
