package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.Printer.MarginType;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	// ultimate stage
	Button b00 = new Button("ENTER");
	Label welcome00 = new Label("WELCOME TO MEDANTA \n              The Medicity");
	Stage ultimatestage = new Stage();

	// login stage
	Button btn03 = new Button("Sign in");
	TextField text04 = new TextField();
	PasswordField text05 = new PasswordField();
	Stage login = new Stage();

	// primary stage

	Button btn1 = new Button("Add new Patient");
	Button btn2 = new Button("Returning Patient");
	Button btn3 = new Button("Generate Bill");
	Button btn4 = new Button("Exit");
	Stage primarystage = new Stage();
	Label note = new Label("MEDANTA HOSPITAL");

	// second stage for new patient
	Button b1 = new Button("Add patient");
	Button b3 = new Button("Clear");
	Label lbltitle = new Label("Medanta Hospital Registration form");
	Label lblregtitle = new Label("Registration details:");
	Label lblappttile = new Label("Appointment Details:");
	// Label label1 = new Label("Enter Insurance ID:");
	Label label2 = new Label("First Name");
	Label label3 = new Label("Last Name");
	Label label4 = new Label("Address");
	Label label5 = new Label("State");
	Label label6 = new Label("City");
	Label label7 = new Label("Postal Code");
	Label label8 = new Label("Birth Date");
	Label label9 = new Label("Home Phone");
	Label label10 = new Label("Procedure");
	Label label11 = new Label("Choose Appointment");
	Label label12 = new Label("Choose Appointment Time");
	Label lbldoctor = new Label("Choose Doctor");
	DatePicker checkInDatePicker = new DatePicker();
	DatePicker dp1 = new DatePicker(); // date picker object
	ListView<String> lv = new ListView<>();
	ListView<String> lvdoctor = new ListView<>();
	TextField text1 = new TextField();
	TextField text2 = new TextField();
	TextField text3 = new TextField();
	TextField text4 = new TextField();
	TextField text5 = new TextField();
	TextField text6 = new TextField();
	TextField text7 = new TextField();
	Button bprint = new Button("Print");
	Button btnshowdoc = new Button("Show Appointment Schedule");

	Stage secondstage = new Stage();

	// stage 3 for old patient
	Label lbel = new Label("Enter Patient ID");
	Label lbel2 = new Label("Enter Patient's Date of Birth");
	Label lbldoctor2 = new Label("Choose a Doctor");
	Label lbel3 = new Label("Enter Appointment Date");
	Label lbel4 = new Label("Enter Appointment Time");
	TextField text31 = new TextField(); // stage3
	TextField text33 = new TextField(); // stage 3
	DatePicker dp2 = new DatePicker(); // date picker object
	DatePicker dp3 = new DatePicker(); // date picker object //stage 3
	ListView<String> lv2 = new ListView<>();
	ListView<String> lvdoctor2 = new ListView<>();
	TextField text9 = new TextField();
	TextField text10 = new TextField();
	Button btn31 = new Button("Search for Patient's Record");
	Button btn32 = new Button("Clear");
	Button btn33 = new Button("Book Appointment");
	Stage thirdstage = new Stage();

	// fourth stage

	Label lblappid = new Label("Appointment Id: ");
	Label lblpatid = new Label("Patient ID: ");
	Label lblfirstname = new Label("Firstname: ");
	Label lbllastname = new Label("Lastname: ");
	Label lblpro = new Label("Tests : ");
	Label lblappdate = new Label("Date of Appointment: ");
	// Label lbl47 = new Label("INSURANCE ID: ");
	// Label lbl48 = new Label("AMOUNT INSURED: ");
	// Label lbl49 = new Label("UNINSURED AMOUNT: ");
	Label lblapptime = new Label("Time of Appoitment");
	Label lblbillnum = new Label("Bill Number: ");
	Label lblmethod = new Label("Method of Payment: ");
	Label lblreceipt = new Label("Receipt Number: ");
	Label lblbill = new Label("Bill Total: ");
	Label lblhst = new Label("Hst: ");
	Label lbltotal = new Label("Total: ");
	Label signature = new Label(
			"Signature of the patient :      .........................................................");
	TextField txtappid = new TextField();
	TextField txtpatid = new TextField();
	Label lblifirstname = new Label();
	Label lblilastname = new Label();
	// Label lblipro1 = new Label();
	// Label lblipro2 = new Label();
	// Label lblipro3 = new Label();
	// Label lblipro4 = new Label();
	Label lbliappdate = new Label();
	Label lvbill = new Label();
	// Label lbl419 = new Label();
	// Label lbl420 = new Label();
	// Label lbl421 = new Label();
	Label lbliapptime = new Label();
	Label lblibillnum = new Label();
	Label lblimethod = new Label();
	Label lblireceipt = new Label();
	Label lblibill = new Label();
	Label lblihst = new Label();
	Label lblitotal = new Label();
	Button bt411 = new Button("Print");
	Button bt412 = new Button("Send as E-Mail");
	Button bt413 = new Button("Close");
	Button bt414 = new Button("Display");
	Stage fourthstage = new Stage();

	// fifth stage
	Stage fifthstage = new Stage();
	Label lbl51 = new Label();
	Label lbl52 = new Label();
	Label lbl53 = new Label();
	Label lbl54 = new Label();
	Label lbl55 = new Label();
	Label lbl56 = new Label();
	Label lbl57 = new Label();
	Label lbl58 = new Label();
	// Label lbl59 = new Label();
	Label lbl60 = new Label();
	Label lbl61 = new Label("Patient's Firstname: ");
	Label lbl62 = new Label("Patient's Lastname: ");
	Label lbl63 = new Label("Patient's Address: ");
	Label lbl64 = new Label("City: ");
	Label lbl65 = new Label("State: ");
	Label lbl66 = new Label("Zip Code: ");
	Label lbl67 = new Label("Phone Number: ");
	Label lbl68 = new Label("Patient's Birthdate: ");
	// Label lbl69 = new Label("Insurance ID: ");
	Label lbl70 = new Label("Patient ID: ");

	// sixth stage
	Stage sixthstage = new Stage();
	TableView<appointment> doctorapp = new TableView<appointment>();

	// seventh stage

	Stage seventhstage = new Stage();
	TableView<patient> patientrec = new TableView<patient>();

	@Override

	public void start(Stage ultimatestage) {

		// ultimate stage

		GridPane gp00 = new GridPane();
		HBox hb1 = new HBox();
		hb1.getChildren().add(b00);
		hb1.setAlignment(Pos.BOTTOM_CENTER);
		// gp00.add(null, 0, 2);
		// gp00.add(null, 0, 3);
		gp00.add(welcome00, 0, 0);
		gp00.setPadding(new Insets(20));
		gp00.setVgap(200);
		gp00.add(hb1, 0, 1);
		gp00.setAlignment(Pos.TOP_CENTER);
		Scene scene00 = new Scene(gp00, 1920, 1080);
		scene00.getStylesheets().add(this.getClass().getResource("application.css").toExternalForm());
		ultimatestage.setScene(scene00);
		ultimatestage.setTitle("welcome");
		ultimatestage.show();
		b00.setMinHeight(150);
		b00.setMinWidth(250);

		welcome00.setId("wel");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			PreparedStatement stm1 = con3
					.prepareStatement("select username,password from login where username=? and password=?");
			ArrayList<enterlogin> loginarray = new ArrayList<>();

			enterlogin user1 = new enterlogin("sachin", "sachin");
			enterlogin user2 = new enterlogin("harsh", "harsh");
			enterlogin user3 = new enterlogin("abin", "abin");

			loginarray.add(user1);
			loginarray.add(user2);
			loginarray.add(user3);
			for (enterlogin e : loginarray) {

				stm1.setString(1, e.getLogin());
				stm1.setString(2, e.getPassword());
			}
			ResultSet rs1 = stm1.executeQuery();

			// System.out.println(rs1);
			if (rs1.next()) {

				b00.setOnAction(e -> {
					login.initModality(Modality.APPLICATION_MODAL);
					login.show();
				});
			} else {
				PreparedStatement p1 = con3.prepareStatement("insert into login(username,password)values(?,?)");

				for (enterlogin e : loginarray) {

					p1.setString(1, e.getLogin());
					p1.setString(2, e.getPassword());
					p1.executeQuery();
				}

			}

		}

		catch (SQLException ex) {
			ex.getMessage();

		} catch (ClassNotFoundException ex) {
			ex.getMessage();

		}

		// login stage
		HBox hb02 = new HBox();
		GridPane gn02 = new GridPane();
		Label welcome = new Label("Welcome");
		Label lbl04 = new Label("Enter Username");
		Label lbl05 = new Label("Enter Password");
		gn02.add(lbl04, 0, 1);
		gn02.add(lbl05, 0, 2);
		gn02.add(text04, 1, 1); // Username
		gn02.add(text05, 1, 2); // password
		gn02.add(welcome, 0, 0); // title
		hb02.getChildren().addAll(btn03);
		gn02.add(hb02, 1, 3);
		welcome.setId("welcome-label"); // setting id for css
		hb02.setSpacing(10);
		hb02.setPadding(new Insets(10));
		gn02.setAlignment(Pos.CENTER);
		gn02.setHgap(10);
		gn02.setVgap(10);
		Scene scene = new Scene(gn02, 1920, 1080);
		login.setScene(scene);
		scene.getStylesheets().add(this.getClass().getResource("login.css").toExternalForm());
		btn03.setOnAction(e -> signin());

		// primary stage for Receptionist to select an operation

		HBox hb2 = new HBox();
		GridPane gp1 = new GridPane();
		hb2.getChildren().addAll(btn1, btn2, btn3, btn4);
		hb2.setSpacing(20);
		hb2.setPadding(new Insets(10));
		gp1.setAlignment(Pos.TOP_CENTER);
		hb2.setAlignment(Pos.BOTTOM_CENTER);
		gp1.add(note, 0, 1);
		gp1.add(hb2, 0, 2);
		gp1.setHgap(20);
		gp1.setVgap(150);
		btn1.setId("button");
		btn1.setMinHeight(150);
		btn1.setMinWidth(250);
		btn2.setMinHeight(150);
		btn2.setMinWidth(250);
		btn3.setMinHeight(150);
		btn3.setMinWidth(250);
		btn4.setMinHeight(150);
		btn4.setMinWidth(250);
		note.setId("welcome-note");

		Scene scene2 = new Scene(gp1, 1920, 1080);
		scene2.getStylesheets().add(this.getClass().getResource("selection.css").toExternalForm());
		primarystage.setScene(scene2);

		btn1.setOnAction(e -> {
			secondstage.initModality(Modality.APPLICATION_MODAL);
			secondstage.show();

		});
		btn2.setOnAction(e -> {
			thirdstage.initModality(Modality.APPLICATION_MODAL);
			thirdstage.show();

		});

		btn3.setOnAction(e -> {
			fourthstage.initModality(Modality.APPLICATION_MODAL);
			fourthstage.show();
		});

		btn4.setOnAction(e -> {
			System.exit(0);
		});

		// second stage for new patient
		BorderPane root = new BorderPane();
		root.setPrefWidth(500);
		root.setPrefHeight(300);
		HBox ab = new HBox();

		ab.getChildren().addAll(b1, b3);
		GridPane gp = new GridPane();
		// gp.add(label1, 0, 8);
		// gp.add(lbltitle, 0, 0);
		lblregtitle.setId("welcome-label");
		lblappttile.setId("welcome-label");
		gp.add(label2, 0, 2);
		gp.add(label3, 2, 2);
		gp.add(label4, 0, 3);
		gp.add(label5, 0, 4);
		gp.add(label6, 2, 3);
		gp.add(label7, 2, 4);
		gp.add(label8, 0, 5);
		gp.add(label9, 2, 5);
		gp.add(label10, 0, 11);
		gp.add(label12, 2, 12);
		gp.add(lbldoctor, 2, 11);
		gp.add(lblregtitle, 0, 1);
		gp.add(lblappttile, 0, 10);
		// gp.add(title, 0, 0);
		Tooltip tl = new Tooltip();
		tl.setText("\n Please enter time in hh/mm AM/PM 12-Hour format\n eg. 02:30 PM");
		text10.setTooltip(tl);
		lbltitle.setId("welcome-label");
		// gp.add(text1, 1, 8); // ins_id
		gp.add(text2, 1, 2);// FIRSTNAME
		gp.add(text3, 3, 2);// LASTNAME
		gp.add(text4, 1, 3);// ADDRESS
		gp.add(text5, 1, 4); // STATE
		gp.add(text6, 3, 3);// CITY
		gp.add(text7, 3, 4);// POSTALCODE
		gp.add(checkInDatePicker, 1, 5); // BIRTHDATE
		gp.add(text9, 3, 5); // HOMEPHONE
		gp.add(text10, 3, 12);// APPOINTMENT TIME
		// procedure pp = new procedure("Teeth Whitening", 1550);
		// procedure pp2 = new procedure("Bridges and Implants", 1560);
		// procedure pp3 = new procedure("Braces", 1570);
		// procedure pp4 = new procedure("Gum Surgery", 1580);
		// List<String> aa = new ArrayList<>();
		// aa.add(pp.getProcedureDetails());
		// aa.add(pp2.getProcedureDetails());
		// aa.add(pp3.getProcedureDetails());
		// aa.add(pp4.getProcedureDetails());

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");

			PreparedStatement stm00 = con3.prepareStatement("select pro_description from procedure");

			ResultSet rs00 = stm00.executeQuery();
			while (rs00.next()) {
				String current = rs00.getString("pro_description");
				ObservableList<String> list = FXCollections.observableArrayList(current);
				lv.getItems().addAll(list);

			}

		} catch (SQLException ex) {

		} catch (ClassNotFoundException ex) {

		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			PreparedStatement stm001 = con3.prepareStatement("select doc_firstname from doctor");

			ResultSet rs001 = stm001.executeQuery();
			while (rs001.next()) {
				String current2 = rs001.getString("doc_firstname");
				ObservableList<String> list2 = FXCollections.observableArrayList(current2);
				lvdoctor.getItems().addAll(list2);
			}

		} catch (SQLException ex) {

		} catch (ClassNotFoundException ex) {

		}

		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		// lvdoctor.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		root.setCenter(new ScrollPane(lv));
		root.setCenter(new ScrollPane(lvdoctor));
		lv.setPrefWidth(100);
		lv.setPrefHeight(70);
		lvdoctor.setPrefWidth(100);
		lvdoctor.setPrefHeight(70);
		gp.add(lvdoctor, 3, 11);
		gp.add(lv, 1, 11);
		HBox.setMargin(b1, new Insets(40));
		HBox.setMargin(b3, new Insets(40));
		ab.setAlignment(Pos.CENTER);
		root.setBottom(ab);
		bprint.setMinHeight(50);
		bprint.setMinWidth(150);
		b1.setMinHeight(50);
		b1.setMinWidth(150);
		b3.setMinHeight(50);
		b3.setMinWidth(150);
		/*
		 * ToolBar toolBar = new ToolBar(new Separator(), new Button("New"), new
		 * Button("Open"), new Button("Save"), new Button("Clean"), new
		 * Separator(), new Button("Compile"), new Button("Run"), new
		 * Button("Debug"), new Button("Profile"), new Separator());
		 */
		MenuBar mb = new MenuBar();
		Menu File = new Menu("File");
		Menu Edit = new Menu("Edit");
		Menu View = new Menu("View");
		Menu Clear = new Menu("Clear");
		Menu Exit = new Menu("Exit");
		mb.getMenus().addAll(File, Edit, View, Clear, Exit);

		MenuItem New = new MenuItem("New");
		MenuItem open = new MenuItem("Open Existing Patient File");
		MenuItem billgen = new MenuItem("Generate Bill");
		MenuItem close = new MenuItem("Close");
		MenuItem save = new MenuItem("Save");
		MenuItem saveas = new MenuItem("Save as");
		MenuItem print = new MenuItem("Print");
		MenuItem properties = new MenuItem("Properties");

		MenuItem redo = new MenuItem("Redo");
		MenuItem undo = new MenuItem("Undo Typing");
		MenuItem cut = new MenuItem("Cut");
		MenuItem copy = new MenuItem("Copy");
		MenuItem paste = new MenuItem("Paste");
		MenuItem selectall = new MenuItem("Select All");

		MenuItem minimize = new MenuItem("Minimize");
		MenuItem zoom = new MenuItem("Zoom");
		MenuItem toggle = new MenuItem("Toggle FulL Screen");

		MenuItem clear = new MenuItem("Clear all");
		MenuItem exit = new MenuItem("Close");

		File.getItems().addAll(New, open, billgen, close, save, saveas, print, properties);
		Edit.getItems().addAll(redo, undo, cut, copy, paste, selectall);
		View.getItems().addAll(minimize, zoom, toggle);
		Clear.getItems().add(clear);
		Exit.getItems().add(exit);

		New.setOnAction(e -> {
			secondstage.initModality(Modality.APPLICATION_MODAL);
			secondstage.show();
		});
		open.setOnAction(e -> {
			thirdstage.initModality(Modality.APPLICATION_MODAL);
			thirdstage.show();
		});
		billgen.setOnAction(e -> {
			fourthstage.initModality(Modality.APPLICATION_MODAL);
			fourthstage.show();
		});
		close.setOnAction(e -> {
			secondstage.close();
		});
		save.setOnAction(e -> {

		});
		saveas.setOnAction(e -> {

		});

		print.setOnAction(e -> {
			doprint(gp);
		});
		properties.setOnAction(e -> {

		});
		redo.setOnAction(e -> {

		});
		undo.setOnAction(e -> {

		});
		cut.setOnAction(e -> {

		});
		copy.setOnAction(e -> {

		});
		paste.setOnAction(e -> {

		});
		selectall.setOnAction(e -> {

		});
		minimize.setOnAction(e -> {

		});
		zoom.setOnAction(e -> {

		});
		toggle.setOnAction(e -> {

		});
		exit.setOnAction(e -> {
			System.exit(0);
		});
		clear.setOnAction(e -> {
			text1.setText(" ");
			text2.setText(" ");
			text3.setText(" ");
			text4.setText(" ");
			text5.setText(" ");
			text6.setText(" ");
			text7.setText(" ");
			text9.setText(" ");
			text10.setText(" ");
			text2.requestFocus();
		});
		File.getStyleClass().add("file");
		gp.getStyleClass().add("mygp");
		ab.getStyleClass().add("mymb");
		root.setTop(mb);
		root.setCenter(gp);
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(15);
		gp.setHgap(30);
		ab.setSpacing(20);
		ab.setPadding(new Insets(10));
		mb.getStyleClass().add("toolbar");

		gp.add(label11, 0, 12);
		gp.add(dp1, 1, 12);
		Scene scene3 = new Scene(root, 1920, 1080);
		scene3.getStylesheets().add(this.getClass().getResource("new.css").toExternalForm());
		secondstage.setScene(scene3);

		b1.setOnAction(e -> {
			try {
				addpatient();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		});

		b3.setOnAction(e -> {
			clear();
		});
		bprint.setOnAction(e -> {
			doprint(gp);
		});

		// third stage for old patient
		BorderPane bpold = new BorderPane();
		HBox hb3 = new HBox();
		Button btn34 = new Button("Close");
		Label welcom2 = new Label("Medanta Hospital Appointment Booking");
		welcom2.setId("welcome-label");
		Label lbldetails = new Label("Patient Details:");
		Label lblproc = new Label("Appointment Details:");
		HBox hb4 = new HBox();
		hb4.getChildren().add(welcom2);
		Label lbel5 = new Label("Select a procedure");
		HBox hb22 = new HBox();
		// hb3.getChildren().addAll(btn31, btn32);
		hb22.getChildren().addAll(btn33, btn34, btnshowdoc);
		hb22.setAlignment(Pos.CENTER);
		GridPane gp3 = new GridPane();
		gp3.add(lbldetails, 0, 0);
		gp3.add(lbel, 0, 1);
		gp3.add(lbel2, 2, 1);
		gp3.add(btn31, 1, 2);
		gp3.add(btn32, 2, 2);
		// gp3.add(hb22, 1, 7);
		gp3.add(lbldoctor2, 2, 4);
		lbldetails.setId("crimson");
		lblproc.setId("crimson");
		gp3.add(lblproc, 0, 3);
		gp3.add(lbel3, 0, 5);
		gp3.add(lbel4, 2, 5);
		gp3.add(lbel5, 0, 4);
		gp3.add(dp2, 1, 5);
		gp3.add(text33, 3, 5);
		gp3.add(text31, 1, 1);
		gp3.add(dp3, 3, 1);
		hb3.setSpacing(10);
		hb3.setAlignment(Pos.CENTER_LEFT);
		gp3.setAlignment(Pos.CENTER);
		hb3.setPadding(new Insets(10));
		gp3.setHgap(10);
		gp3.setVgap(10);
		text33.setTooltip(tl);
		btn33.setMinHeight(70);
		btn33.setMinWidth(150);
		btn31.setMinHeight(70);
		btn31.setMinWidth(190);
		btn32.setMinHeight(70);
		btn32.setMinWidth(250);
		btn34.setMinHeight(70);
		btn34.setMinWidth(150);
		btnshowdoc.setMinHeight(70);
		btnshowdoc.setMinWidth(150);
		hb22.setSpacing(20);
		hb22.setPadding(new Insets(10));

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con200 = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok",
					"n01193216", "oracle");

			PreparedStatement stm001 = con200.prepareStatement("select pro_description from procedure");

			ResultSet rs002 = stm001.executeQuery();
			while (rs002.next()) {
				String current2 = rs002.getString("pro_description");
				ObservableList<String> list2 = FXCollections.observableArrayList(current2);
				lv2.getItems().addAll(list2);

			}

		} catch (SQLException ex) {

		} catch (ClassNotFoundException ex) {

		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con3 = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			PreparedStatement stm001 = con3.prepareStatement("select doc_firstname from doctor");

			ResultSet rs001 = stm001.executeQuery();
			while (rs001.next()) {
				String current2 = rs001.getString("doc_firstname");
				ObservableList<String> list2 = FXCollections.observableArrayList(current2);
				lvdoctor2.getItems().addAll(list2);
			}

		} catch (SQLException ex) {

		} catch (ClassNotFoundException ex) {

		}

		lvdoctor2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		lvdoctor2.setPrefHeight(70);
		lvdoctor2.setPrefWidth(100);
		lv2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lv2.setPrefWidth(100);
		lv2.setPrefHeight(70);
		gp3.add(lv2, 1, 4);
		gp3.add(lvdoctor2, 3, 4);
		gp3.setHgap(25);
		gp3.setVgap(25);
		// hb3.setAlignment(Pos.CENTER);
		hb4.setAlignment(Pos.CENTER);
		HBox.setMargin(btn33, new Insets(60));
		HBox.setMargin(btn34, new Insets(60));
		HBox.setMargin(btnshowdoc, new Insets(60));
		bpold.setTop(hb4);
		bpold.setCenter(gp3);
		bpold.setBottom(hb22);

		Scene scene4 = new Scene(bpold, 1920, 1080);
		scene4.getStylesheets().add(this.getClass().getResource("old.css").toExternalForm());
		thirdstage.setScene(scene4);

		// stage 4 to create a bill
		BorderPane oldbill = new BorderPane();
		Button btnconfirm = new Button("Confirm Payment");

		GridPane gp40 = new GridPane();
		Label tophead = new Label("MEDANTA HOSPITAL");
		tophead.setId("tophead");
		HBox hb41 = new HBox();
		HBox hb42 = new HBox();
		hb42.getChildren().add(tophead);
		// gp40.add(tophead, 1, 0);
		gp40.add(lblappid, 0, 1);
		gp40.add(lblpatid, 2, 1);
		gp40.add(lblfirstname, 0, 2);
		gp40.add(lbllastname, 2, 2);
		gp40.add(lblappdate, 0, 6);
		gp40.add(lblapptime, 2, 6);
		// gp40.add(lbl47, 0, 7);
		// gp40.add(lbl48, 0, 8);
		// gp40.add(lbl49, 0, 9);
		gp40.add(lblpro, 0, 3);
		gp40.add(lblbillnum, 0, 7);
		gp40.add(lblmethod, 2, 7);
		gp40.add(lblreceipt, 0, 8);
		gp40.add(lblbill, 2, 9);
		gp40.add(lblhst, 2, 10);
		gp40.add(lbltotal, 2, 11);
		gp40.add(txtappid, 1, 1);
		gp40.add(txtpatid, 3, 1);
		gp40.add(lblifirstname, 1, 2);
		gp40.add(lblilastname, 3, 2);
		gp40.add(lbliappdate, 1, 6);
		gp40.add(lbliapptime, 3, 6);
		tophead.setAlignment(Pos.CENTER);
		hb42.setAlignment(Pos.CENTER);
		hb41.setAlignment(Pos.CENTER);
		gp40.setAlignment(Pos.CENTER);
		HBox.setMargin(bt414, new Insets(20));
		HBox.setMargin(bt411, new Insets(20));
		HBox.setMargin(bt413, new Insets(20));
		bt414.setMinHeight(50);
		bt414.setMinWidth(150);
		bt411.setMinHeight(50);
		bt411.setMinWidth(150);
		bt413.setMinHeight(50);
		bt413.setMinWidth(150);
		btnconfirm.setMinHeight(50);
		btnconfirm.setMinWidth(150);
		// gp40.add(lbl419, 1, 7);
		// gp40.add(lbl420, 1, 8);
		// gp40.add(lbl421, 1, 9);
		/*
		 * gp40.add(lblipro1, 3, 2); gp40.add(lblipro2, 3, 3);
		 * gp40.add(lblipro3, 3, 4); gp40.add(lblipro4, 3, 5);
		 */
		gp40.add(lblibillnum, 1, 7);
		gp40.add(lblimethod, 3, 7);
		gp40.add(lblireceipt, 1, 8);
		gp40.add(lblibill, 3, 9);
		gp40.add(lblihst, 3, 10);
		gp40.add(lblitotal, 3, 11);
		gp40.add(signature, 3, 12);
		txtappid.setMaxWidth(150);
		txtpatid.setMaxWidth(150);
		gp40.add(lvbill, 1, 3);
		hb41.getChildren().addAll(bt414, bt411, bt413, btnconfirm);
		// gp40.add(hb41, 1, 22);

		oldbill.setTop(hb42);
		oldbill.setCenter(gp40);
		oldbill.setBottom(hb41);
		gp40.setVgap(25);
		gp40.setHgap(25);
		gp40.setAlignment(Pos.BASELINE_LEFT);
		gp40.setPadding(new Insets(40));
		hb41.setSpacing(10);
		hb41.setPadding(new Insets(10));
		Scene scene6 = new Scene(oldbill, 1920, 1080);
		scene6.getStylesheets().add(this.getClass().getResource("bill.css").toExternalForm());
		fourthstage.setScene(scene6);

		bt414.setOnAction(e -> {
			try {
				generatebill();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			fourthstage.show();

		});

		bt411.setOnAction(e -> {
			doprint(oldbill);

		});

		bt412.setOnAction(e -> {
			// send as email function
		});

		bt413.setOnAction(e -> {
			fourthstage.close();
			System.exit(0);
		});

		btnconfirm.setOnAction(e -> {
			updatebillstatus();
		});

		// stage 5 to display the information about an old patient to the
		// receptionist
		Label welcom = new Label("Medanta Hospital");
		welcom.setId("welcome-label");
		BorderPane olddis = new BorderPane();
		Button btnclose = new Button("Close");
		btnclose.setMinHeight(70);
		btnclose.setMinWidth(150);
		HBox hbclose = new HBox();
		HBox hbtop = new HBox();
		welcom.setAlignment(Pos.CENTER);
		hbtop.getChildren().add(welcom);
		hbclose.setAlignment(Pos.CENTER);
		hbclose.getChildren().add(btnclose);
		GridPane pane00 = new GridPane();
		lbl61.setId("crimson");
		lbl62.setId("crimson");
		lbl63.setId("crimson");
		lbl64.setId("crimson");
		lbl65.setId("crimson");
		lbl66.setId("crimson");
		lbl67.setId("crimson");
		lbl68.setId("crimson");
		lbl70.setId("crimson");

		pane00.add(lbl51, 1, 0);
		pane00.add(lbl52, 3, 0);
		pane00.add(lbl53, 1, 1);
		pane00.add(lbl54, 3, 1);
		pane00.add(lbl55, 1, 2);
		pane00.add(lbl56, 3, 2);
		pane00.add(lbl57, 1, 3);
		pane00.add(lbl58, 3, 3);
		// pane00.add(lbl59, 1, 8);
		pane00.add(lbl60, 1, 4);
		pane00.add(lbl61, 0, 0);// 0-0
		pane00.add(lbl62, 2, 0);// 2-0
		pane00.add(lbl63, 0, 1);// 0-1
		pane00.add(lbl64, 2, 1);// 2-1
		pane00.add(lbl65, 0, 2);
		pane00.add(lbl66, 2, 2);
		pane00.add(lbl67, 0, 3);
		pane00.add(lbl68, 2, 3);
		pane00.setHgap(35);
		pane00.setVgap(35);
		pane00.setAlignment(Pos.CENTER);
		pane00.setPadding(new Insets(40));
		// pane00.add(lbl69, 0, 8);
		pane00.add(lbl70, 0, 4);
		HBox.setMargin(btnclose, new Insets(25));
		hbtop.setAlignment(Pos.CENTER);
		// olddis.setTop(hbtop);
		olddis.setTop(pane00);
		olddis.setCenter(patientrec);
		olddis.setBottom(hbclose);
		Scene scene5 = new Scene(olddis, 1920, 1080);
		scene5.getStylesheets().add(this.getClass().getResource("display.css").toExternalForm());
		fifthstage.setScene(scene5);
		btn31.setOnAction(e -> {
			displayinfo();
			showPatientRecord();
		});

		btn32.setOnAction(e -> {
			text33.setText("");
			text31.setText(" ");

		});

		btn33.setOnAction(e -> {
			try {
				Displaypatient();
			} catch (ParseException e2) {
				e2.printStackTrace();
			}

		});

		btnclose.setOnAction(e -> {
			fifthstage.close();
		});

		btn34.setOnAction(e -> {
			thirdstage.close();
		});

		// stagesix to present tabled data for a doctor

		// sixthstage.show();

		Scene sixthscene = new Scene(doctorapp, 600, 500);
		sixthscene.getStylesheets().add(this.getClass().getResource("seven.css").toExternalForm());
		sixthstage.setScene(sixthscene);

		btnshowdoc.setOnAction(e -> {
			docapp();
			sixthstage.show();
		});
		// seventh stage
		// Scene seventhscene = new Scene(patientrec, 600, 500);
		// seventhstage.setScene(seventhscene);

		patientrec.setMaxWidth(800);
		patientrec.setMaxHeight(400);
	}

	public void updatebillstatus() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con2 = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			PreparedStatement stm2 = con2.prepareStatement("update bill set bill_status='PAID' where app_id=?");
			int app_id = Integer.parseInt(txtappid.getText());
			stm2.setInt(1, app_id);
			stm2.executeUpdate();
			int i = stm2.executeUpdate();
			if (i > 0) {
				Alert al = new Alert(AlertType.CONFIRMATION);
				al.setHeaderText("Successfull Payment");
				al.setContentText("Payment has been updated successfully");
				al.showAndWait();
			} else {
				Alert al = new Alert(AlertType.WARNING);
				al.setHeaderText("Unsuccessful Payment");
				al.setContentText("Payment hasn't been updated successfully");
				al.showAndWait();
			}

		} catch (ClassNotFoundException ex) {
			ex.getMessage();
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
	}

	public void docapp() {

		TableColumn<appointment, String> App_date = new TableColumn<appointment, String>("Appointment Date");
		App_date.setCellValueFactory(new PropertyValueFactory<appointment, String>("app_date"));
		App_date.setMinWidth(200);
		TableColumn<appointment, String> App_time = new TableColumn<appointment, String>("Appointment Time");
		App_time.setCellValueFactory(new PropertyValueFactory<appointment, String>("app_time"));
		App_time.setMinWidth(200);
		TableColumn<appointment, String> Doc_name = new TableColumn<appointment, String>("Doctor Name");
		Doc_name.setCellValueFactory(new PropertyValueFactory<appointment, String>("doc_name"));
		Doc_name.setMinWidth(200);

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con2 = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			PreparedStatement stm2 = con2.prepareStatement(
					"select to_char(app_date,'dd-mm-yyyy'),app_time,d.doc_firstname from appointment a  "
							+ "join doctor d on a.doc_idnumber=d.doc_idnumber "
							+ "where doc_firstname=UPPER(?) and a.app_date=?");
			java.util.Date dp11 = java.util.Date.from(dp2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.sql.Date sqlDate11 = new java.sql.Date(dp11.getTime());
			stm2.setDate(2, sqlDate11);
			stm2.setString(1, lvdoctor2.getSelectionModel().getSelectedItem());
			final ObservableList<appointment> data = FXCollections.observableArrayList();
			ResultSet rs00 = stm2.executeQuery();
			while (rs00.next()) {
				data.add(new appointment(rs00.getString(1), rs00.getString(2), rs00.getString(3)));
			}
			doctorapp.setItems(data);
			doctorapp.getColumns().addAll(App_date, App_time, Doc_name);
		}

		catch (ClassNotFoundException ex) {
			ex.getMessage();
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
	}

	public void clear() {
		text1.setText(" ");
		text2.setText(" ");
		text3.setText(" ");
		text4.setText(" ");
		text5.setText(" ");
		text6.setText(" ");
		text7.setText(" ");
		text9.setText(" ");
		text10.setText(" ");
	}

	public void signin() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con2 = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			PreparedStatement stm2 = con2.prepareStatement("select * from login where username=? and password=?");
			String user1 = text04.getText();
			String pass2 = text05.getText();
			stm2.setString(1, user1);
			stm2.setString(2, pass2);
			ResultSet rs2 = stm2.executeQuery();
			if (rs2.next()) {
				primarystage.initModality(Modality.APPLICATION_MODAL);

				primarystage.show();

			} else {
				Alert al = new Alert(AlertType.CONFIRMATION);
				al.setContentText("Invalid Password. Please Re-Enter");
				al.setHeaderText("Invalid Password");
				al.showAndWait();
				text04.clear();
				text05.clear();
				text04.requestFocus();
			}

		} catch (ClassNotFoundException ex) {
			System.out.println("class not found " + ex.getMessage());
		}

		catch (SQLException ex) {
			System.out.println("record not found " + ex.getMessage());
		}

	}

	public void addpatient() throws ParseException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			String generatedcolumns[] = { "PAT_IDNUMBER" };
			PreparedStatement stm1 = con.prepareStatement(
					"insert into PATIENT(PAT_FIRSTNAME,PAT_LASTNAME,PAT_ADDRESS,PAT_STATE,PAT_CITY,PAT_ZIPCODE,PAT_BIRTHDATE,PAT_HOMEPHONE)"
							+ " values(?,?,?,?,?,?,?,?)",
					generatedcolumns);
			String firstname = text2.getText();// FIRSTNAME
			String lastname = text3.getText();// LASTNAME
			String address = text4.getText();// ADDRESS
			String city = text5.getText();// CITY
			String state = text6.getText();// STATE
			String postalcode = text7.getText();// POSTALCODDE
			int phonenumber = Integer.parseInt(text9.getText());// PHONENUMBER
			/*
			 * if (rs.next()) { abc = rs.getInt(1); }
			 */
			java.util.Date date = java.util.Date
					.from(checkInDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());

			// int ins_id = Integer.parseInt(text1.getText());

			stm1.setString(1, firstname);
			stm1.setString(2, lastname);
			stm1.setString(3, address);

			stm1.setString(4, city);
			stm1.setString(5, state);
			stm1.setString(6, postalcode);
			stm1.setInt(8, phonenumber);
			stm1.setDate(7, sqlDate);
			// stm1.setInt(9, ins_id);
			stm1.executeQuery();
			ResultSet rs001 = stm1.getGeneratedKeys();
			if (rs001.next()) {
				System.out.println("Key returned from getGeneratedKeys():" + rs001.getInt(1));
				String generatedcolumns2[] = { "APP_ID" };
				PreparedStatement stm35 = con.prepareStatement(
						"INSERT INTO APPOINTMENT(APP_DATE,APP_TIME,PAT_IDNUMBER,doc_idnumber)VALUES(?,?,?,?)",
						generatedcolumns2);
				java.util.Date dp11 = java.util.Date
						.from(dp1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
				java.sql.Date sqlDate11 = new java.sql.Date(dp11.getTime());
				stm35.setDate(1, sqlDate11);
				stm35.setString(2, text10.getText());
				stm35.setInt(3, rs001.getInt(1));

				PreparedStatement stmdoc = con
						.prepareStatement("select doc_idnumber from doctor where doc_firstname=?");

				stmdoc.setString(1, lvdoctor.getSelectionModel().getSelectedItem());
				ResultSet getdoc = stmdoc.executeQuery();
				if (getdoc.next()) {
					stm35.setInt(4, getdoc.getInt(1));

					stm35.executeQuery();

					PreparedStatement stm34 = con
							.prepareStatement("SELECT PRO_CODE FROM PROCEDURE WHERE PRO_DESCRIPTION=?");
					ObservableList<String> a = lv.getSelectionModel().getSelectedItems();
					for (String s : a) {
						stm34.setString(1, s);
						ResultSet rs000 = stm34.executeQuery();
						while (rs000.next()) {
							PreparedStatement stm33 = con.prepareStatement(
									"insert into appointment_detail (app_date,app_time,pro_code,doc_idnumber) values(?,?,?,?)");
							stm33.setDate(1, sqlDate11);
							stm33.setString(2, text10.getText());
							stm33.setString(3, rs000.getString(1));
							stm33.setInt(4, getdoc.getInt(1));
							stm33.executeQuery();
						}
					}

					ResultSet rs0002 = stm35.getGeneratedKeys();
					while (rs0002.next()) {
						System.out.println("Key returned from getGeneratedKeys():" + rs0002.getInt(1));

						PreparedStatement stm37 = con.prepareStatement(
								"select sum(p.pro_price) " + "from appointment a join appointment_detail ad on "
										+ "a.app_date=ad.app_date and a.app_time=ad.app_time " + "join procedure p on "
										+ "ad.PRO_CODE=p.pro_code " + "where a.app_id=? ");
						stm37.setInt(1, rs0002.getInt(1));
						stm37.executeQuery();

						ResultSet rs0003 = stm37.executeQuery();
						while (rs0003.next()) {
							System.out.println("Key returned from getGeneratedKeys():" + rs0002.getInt(1));
							String generatedcolumns3[] = { "BILL_NUMBER" };
							PreparedStatement stm36 = con.prepareStatement(
									"insert into bill(app_id,bill_total,bill_status) values(?,?,?)", generatedcolumns3);
							stm36.setInt(1, rs0002.getInt(1));
							stm36.setInt(2, rs0003.getInt(1));
							stm36.setString(3, "UNPAID");
							stm36.executeQuery();
							ResultSet rs0004 = stm36.getGeneratedKeys();
							while (rs0004.next()) {
								System.out.println("Key returned from getGeneratedKeys():" + rs0004.getInt(1));
								PreparedStatement stm38 = con.prepareStatement(
										"insert into payment(pay_amount,pay_method,bill_number) values(?,?,?)");
								stm38.setInt(1, rs0003.getInt(1));
								stm38.setString(2, "UNKNOWN");
								stm38.setInt(3, rs0004.getInt(1));
								stm38.executeQuery();
							}
						}
					}
				} else {
					Alert al = new Alert(AlertType.WARNING);
					al.setTitle("Appointment could not be set. Please try selecting another appointment date or time");
					al.setHeaderText("appointment could not be set");
					al.showAndWait();

				}
			}

			Alert al = new Alert(AlertType.CONFIRMATION);
			al.setTitle("appointment added successfully");
			al.setHeaderText("appointment added successfully");
			al.showAndWait();

		}

		catch (ClassNotFoundException ex) {
			System.out.println("class not found" + ex.getMessage());
			ex.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("record not found " + ex.getMessage());
			ex.printStackTrace();

			/*
			 * catch (ParseException e) { System.out.println(e.getMessage());
			 * e.printStackTrace(); }
			 */
		}

	}

	public void displayinfo() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			PreparedStatement stm22 = con.prepareStatement(
					"select pat_firstname,pat_lastname,pat_address,pat_city,pat_state,pat_zipcode,pat_homephone,to_CHAR(pat_birthdate,'DD/MM/YYYY') "
							+ "from patient where pat_idnumber=? and pat_birthdate=?");
			int abc = Integer.parseInt(text31.getText());
			stm22.setInt(1, abc);
			java.util.Date dp11 = java.util.Date.from(dp3.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.sql.Date sqlDate11 = new java.sql.Date(dp11.getTime());
			stm22.setDate(2, sqlDate11);
			ResultSet rs = stm22.executeQuery();
			if (rs.next()) {
				lbl51.setText(rs.getString(1));
				lbl52.setText(rs.getString(2));
				lbl53.setText(rs.getString(3));
				lbl54.setText(rs.getString(4));
				lbl55.setText(rs.getString(5));
				lbl56.setText(rs.getString(6));
				lbl57.setText(rs.getString(7));
				lbl58.setText(rs.getString(8));
				// lbl59.setText(rs.getString(9));
				lbl60.setText(text31.getText());
				stm22.executeQuery();
				fifthstage.initModality(Modality.APPLICATION_MODAL);
				fifthstage.show();

			}

			else {
				Alert al = new Alert(AlertType.ERROR);
				al.setContentText("PATIENT COULDN'T BE FOUND");
				al.show();

			}

		} catch (ClassNotFoundException ex) {
			System.out.println("class not found" + ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("record not found" + ex.getMessage());
		}

	}

	public void Displaypatient() throws ParseException {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			PreparedStatement stm2 = con.prepareStatement(
					"select pat_firstname,pat_lastname,pat_address,pat_city,pat_state,pat_zipcode,pat_homephone,pat_birthdate "
							+ "from patient where pat_idnumber=? and pat_birthdate=?");
			int abc = Integer.parseInt(text31.getText());
			stm2.setInt(1, abc);
			java.util.Date dp11 = java.util.Date.from(dp3.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.sql.Date sqlDate11 = new java.sql.Date(dp11.getTime());
			stm2.setDate(2, sqlDate11);
			ResultSet rs = stm2.executeQuery();
			if (rs.next()) {

				java.util.Date dp12 = java.util.Date
						.from(dp2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
				java.sql.Date sqlDate13 = new java.sql.Date(dp12.getTime());
				String generatecolumns3[] = { "APP_ID" };
				PreparedStatement stm33 = con.prepareStatement(
						"insert into appointment (app_date,app_time,pat_idnumber,doc_idnumber) values(?,?,?,?)",
						generatecolumns3);
				stm33.setDate(1, sqlDate13);
				stm33.setString(2, text33.getText());
				int ab = Integer.parseInt(text31.getText());
				stm33.setInt(3, ab);

				PreparedStatement stmdoc2 = con
						.prepareStatement("select doc_idnumber from doctor where doc_firstname=?");

				stmdoc2.setString(1, lvdoctor2.getSelectionModel().getSelectedItem());
				stmdoc2.executeQuery();
				ResultSet getdoc = stmdoc2.executeQuery();

				if (getdoc.next()) {
					stm33.setInt(4, getdoc.getInt(1));
					stm33.executeQuery();

					PreparedStatement stm35 = con
							.prepareStatement("SELECT PRO_CODE FROM PROCEDURE WHERE PRO_DESCRIPTION=?");
					ObservableList<String> a = lv2.getSelectionModel().getSelectedItems();
					for (String s : a) {
						stm35.setString(1, s);
						ResultSet rs000 = stm35.executeQuery();
						while (rs000.next()) {
							PreparedStatement stm34 = con.prepareStatement(
									"INSERT INTO APPOINTMENT_DETAIL(APP_DATE,APP_TIME,PRO_CODE,doc_idnumber) VALUES(?,?,?,?)");
							stm34.setDate(1, sqlDate13);
							stm34.setString(2, text33.getText());
							stm34.setString(3, rs000.getString(1));
							stm34.setInt(4, getdoc.getInt(1));
							stm34.executeQuery();
						}
					}
					ResultSet rsgenerated = stm33.getGeneratedKeys();
					if (rsgenerated.next()) {

						PreparedStatement stm37 = con.prepareStatement(
								"select sum(p.pro_price) " + "from appointment a join appointment_detail ad on "
										+ "a.app_date=ad.app_date and a.app_time=ad.app_time " + "join procedure p on "
										+ "ad.PRO_CODE=p.pro_code " + "where a.app_id=? ");
						stm37.setInt(1, rsgenerated.getInt(1));
						stm37.executeQuery();

						ResultSet rs0003 = stm37.executeQuery();
						while (rs0003.next()) {
							System.out.println("Key returned from getGeneratedKeys():" + rsgenerated.getInt(1));
							String generatedcolumns3[] = { "BILL_NUMBER" };
							PreparedStatement stm36 = con.prepareStatement(
									"insert into bill(app_id,bill_total,bill_status) values(?,?,?)", generatedcolumns3);
							stm36.setInt(1, rsgenerated.getInt(1));
							stm36.setInt(2, rs0003.getInt(1));
							stm36.setString(3, "UNPAID");
							stm36.executeQuery();
							ResultSet rs0004 = stm36.getGeneratedKeys();
							while (rs0004.next()) {
								System.out.println("Key returned from getGeneratedKeys():" + rs0004.getInt(1));
								PreparedStatement stm38 = con.prepareStatement(
										"insert into payment(pay_amount,pay_method,bill_number) values(?,?,?)");
								stm38.setInt(1, rs0003.getInt(1));
								stm38.setString(2, "UNKNOWN");
								stm38.setInt(3, rs0004.getInt(1));
								stm38.executeQuery();
							}

						}

					}

					Alert al = new Alert(AlertType.CONFIRMATION);
					al.setTitle("Appointment set");
					al.setHeaderText("Appointment set");
					al.showAndWait();
				} else {
					Alert al = new Alert(AlertType.CONFIRMATION);
					al.setTitle("Appointment could not be set");
					al.setHeaderText("Appointment could not be set");
					al.showAndWait();
				}
			}

		}

		catch (ClassNotFoundException ex) {
			System.out.println("class not found" + ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("record not found" + ex.getMessage());
			ex.printStackTrace();
			ex.getCause();
		}

	}

	public void generatebill() throws ParseException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			PreparedStatement stmbill = con.prepareStatement(
					"select p.pat_firstname,p.pat_lastname,to_CHAR(a.app_date,'DD/MM/YYYY'),a.app_time "
							+ "from patient p join appointment a on "
							+ "p.pat_idnumber=a.pat_idnumber where p.pat_idnumber=? and a.app_id=?");
			int pat_id = Integer.parseInt(txtpatid.getText());
			int app_id = Integer.parseInt(txtappid.getText());
			stmbill.setInt(1, pat_id);
			stmbill.setInt(2, app_id);
			stmbill.executeQuery();
			ResultSet bill_1 = stmbill.executeQuery();

			if (bill_1.next()) {
				lblifirstname.setText(bill_1.getString(1));
				lblilastname.setText(bill_1.getString(2));
				lbliappdate.setText(bill_1.getString(3));
				lbliapptime.setText(bill_1.getString(4));

				bill billclass = new bill();
				PreparedStatement stmbill2 = con
						.prepareStatement("select b.bill_number,p.pay_method,p.pay_receiptnumber,b.bill_total"
								+ " from bill b join appointment a on " + "b.app_id=a.app_id join payment p on "
								+ "p.bill_number=b.bill_number " + "where a.pat_idnumber=? and a.app_id=?");
				int pat_id2 = Integer.parseInt(txtpatid.getText());
				int app_id2 = Integer.parseInt(txtappid.getText());
				stmbill2.setInt(1, pat_id2);
				stmbill2.setInt(2, app_id2);
				stmbill2.executeQuery();
				ResultSet bill_2 = stmbill2.executeQuery();
				if (bill_2.next()) {
					lblibillnum.setText(bill_2.getString(1));
					lblimethod.setText(bill_2.getString(2));
					lblireceipt.setText(bill_2.getString(3));
					lblibill.setText(bill_2.getString(4));
					int a = Integer.parseInt(bill_2.getString(4));
					int taxcal = billclass.hst(a);
					lblihst.setText(taxcal + "");
					int b = a + taxcal;
					lblitotal.setText("" + b);

					PreparedStatement stmbill3 = con.prepareStatement(
							"select p.pro_description " + "from procedure p join appointment_detail ad on  "
									+ "p.pro_code=ad.pro_code join appointment a on "
									+ "ad.app_date=a.app_date and ad.app_time=a.app_time join patient p on "
									+ " a.pat_idnumber=p.pat_idnumber " + "where a.pat_idnumber = ? and a.app_id = ? "
									+ " group by p.pro_description");
					int pat_id3 = Integer.parseInt(txtpatid.getText());
					int app_id3 = Integer.parseInt(txtappid.getText());
					stmbill3.setInt(1, pat_id3);
					stmbill3.setInt(2, app_id3);
					List<String> mylist = new ArrayList<String>();
					ResultSet bill_3 = stmbill3.executeQuery();
					while (bill_3.next()) {
						mylist.add(bill_3.getString(1));
					}
					String abc = mylist.toString();

					lvbill.setWrapText(true);
					lvbill.setText(abc);

				}
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("class not found" + ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("record not found " + ex.getMessage());
			ex.printStackTrace();
			ex.getCause();
		}
	}

	public void doprint(Node stage) throws NullPointerException {
		try {
			Printer printer = Printer.getDefaultPrinter();
			System.out.println(printer);
			PageLayout layout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT,
					MarginType.HARDWARE_MINIMUM);
			PrinterJob job = PrinterJob.createPrinterJob(printer);
			job.getJobSettings().setPageLayout(layout);
			job.getJobSettings().setJobName("Sample Printing Job");
			job.showPrintDialog(secondstage);
			job.showPrintDialog(fourthstage);
			job.printPage(stage);
			job.endJob();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void showPatientRecord() {
		TableColumn<patient, String> display = new TableColumn<patient, String>("Patient history");

		TableColumn<patient, String> App_date2 = new TableColumn<patient, String>("Appointment Date");
		App_date2.setCellValueFactory(new PropertyValueFactory<patient, String>("app_date"));
		App_date2.setMinWidth(266);
		TableColumn<patient, String> App_time2 = new TableColumn<patient, String>("Appointment Time");
		App_time2.setCellValueFactory(new PropertyValueFactory<patient, String>("app_time"));
		App_time2.setMinWidth(266);
		TableColumn<patient, String> Pro_description = new TableColumn<patient, String>("Procedure");
		Pro_description.setCellValueFactory(new PropertyValueFactory<patient, String>("pro_description"));
		Pro_description.setMinWidth(266);

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con2 = DriverManager.getConnection("jdbc:oracle:thin:@dilbert.humber.ca:1521:grok", "n01193216",
					"oracle");
			PreparedStatement stm2 = con2
					.prepareStatement("select to_char(a.app_date,'dd-mm-yyyy'),a.app_time,p.pro_description from "
							+ "patient p join appointment a on  " + "p.pat_idnumber=a.pat_idnumber  "
							+ "join APPOINTMENT_DETAIL ad on  "
							+ "ad.app_date=a.app_date and ad.app_time=a.app_time join "
							+ "procedure p on ad.pro_code=p.pro_code  "
							+ "where p.pat_idnumber=? and p.pat_birthdate=?");

			java.util.Date dp11 = java.util.Date.from(dp3.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
			java.sql.Date sqlDate11 = new java.sql.Date(dp11.getTime());
			stm2.setDate(2, sqlDate11);
			int abc = Integer.parseInt(text31.getText());
			stm2.setInt(1, abc);
			final ObservableList<patient> data2 = FXCollections.observableArrayList();
			ResultSet rs00 = stm2.executeQuery();
			while (rs00.next()) {
				data2.add(new patient(rs00.getString(1), rs00.getString(2), rs00.getString(3).toString()));
				System.out.println(rs00.getString(3));
			}

			patientrec.setItems(data2);
			display.getColumns().addAll(App_date2, App_time2, Pro_description);
			patientrec.getColumns().addAll(display);
		} catch (ClassNotFoundException ex) {
			ex.getMessage();
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {

		launch(args);
	}

}
