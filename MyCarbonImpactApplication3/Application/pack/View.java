package pack;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * The View class is the View of the Carbon Impact Application program
 * and acts as the GUI(Graphical User Interface) of the program that interacts with the user
 * and passes user input to the methods of the Controller Class for operation.
 * @author Justas Cepaitis * @version 1.0 
 * @since 18/03/2020
 */
public class View extends Application implements EventHandler<ActionEvent> {
	
	/** The App controller is an Object of the Controller Class utilized by the view to communicate with the Controller. */
	Controller appController = new Controller();
	
	/**
	 * Start method initializes all the necessary javafx components and builds a GUI out of them
	 * for the user using the program to interact with and have a more pleasing visual experience.
	 * It also defines the operations that should occur for every button click of the GUI to communicate
	 * to the Controller class.
	 *
	 * @param primaryStage is a Stage variable constructed for the rest of the javafx elements to be build on top of it.
	 */
	@Override
	public void start(Stage primaryStage) {
		Image image = new Image("file:Resources\\Earth.png", 120, 120, true, true);
		ImageView iv = new ImageView(image);
		
		// Creating labels
    	Label week = new Label("Week_____________");
    	Label date = new Label("Date______________");
    	Label activity = new Label("Activity___________");
     	Label points = new Label("points -10 -- +10");
     	Label introLine1 = new Label("Welcome to Carbon Footprint Tracker");
     	Label introLine2 = new Label("Monitor your Carbon Footprint to promote healthy living and a newfound respect "
     			+ "for your environment and our Planet");
     	introLine1.setFont(new Font("Calibri", 35));
     	introLine2.setFont(new Font("Calibri", 17));
     	
     	// Creating text boxes
    	TextField weekField = new TextField();
    	DatePicker dateField = new DatePicker();
    	TextField activityField = new TextField();
    	TextField pointsField = new TextField();
    	
    	// Creating Buttons
    	Button addButton = new Button("ADD");
    	Button removeButton = new Button("Remove");
    	Button listButton = new Button("List");
    	Button summaryButton = new Button("Summary");
    	Button loadButton = new Button("load");
    	Button saveButton = new Button("save");
    	Button exitButton = new Button("exit");
    	Button orderByDate = new Button("Order by Date");
    	Button orderByActivity = new Button("Order By Activity");
    	Button deathByObject = new Button("Create infinite amount of objects");
    	
    	// Creating a text area
    	TextArea textAreaManager = new TextArea("Activities to be Displayed");
    	TextArea textAreaResults = new TextArea();
    	
    	ChoiceBox<Activity> choiceBox = new ChoiceBox<Activity>();
    	
    	// Creating a region to create spacing to separate exit button from load and save buttons in application
    	Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
    	Region region2 = new Region();
        HBox.setHgrow(region2, Priority.ALWAYS);
		
		// Creating Horizontal box layouts for the Vertical box layout and adding scene elements to them
		HBox line1 = new HBox(week, weekField, region1, choiceBox);
		HBox line2 = new HBox(date, dateField);
		HBox line3 = new HBox(activity, activityField);
		HBox line4 = new HBox(points, pointsField);
		HBox line5 = new HBox(addButton, removeButton, listButton, summaryButton, deathByObject);
		HBox line6 = new HBox(loadButton, saveButton, region2, exitButton);
		HBox line7 = new HBox(orderByDate, orderByActivity);
		line7.setAlignment(Pos.CENTER);
		
		// Setting spacing of Horizontal boxes to improve appearance
		line1.setSpacing(4);
		line2.setSpacing(4);
		line3.setSpacing(5);
		line4.setSpacing(7);
		line5.setSpacing(10);
		line6.setSpacing(10);
		line7.setSpacing(10);
		
        // Creating a Vertical box layout
		VBox tab1Layout = new VBox();
		tab1Layout.setAlignment(Pos.CENTER);
		VBox tab2Layout = new VBox();
		tab2Layout.setPadding(new Insets(10,10,10,10));
		VBox tab3Layout = new VBox();
		tab3Layout.setPadding(new Insets(10,10,10,10));
		tab3Layout.setSpacing(5);
		tab3Layout.setAlignment(Pos.CENTER);
		
		tab1Layout.getChildren().addAll(iv, introLine1, introLine2);
		tab2Layout.getChildren().addAll(line1, line2, line3, line4, line5, textAreaManager, line6);
		tab3Layout.getChildren().addAll(line7, textAreaResults);
		
        TabPane tabPane = new TabPane();
        Tab introTab = new Tab("Intro");
        Tab activityManagerTab = new Tab("Activity Manager");
        Tab resultsTab = new Tab("Results");
        
        introTab.setContent(tab1Layout);
        activityManagerTab.setContent(tab2Layout);
        resultsTab.setContent(tab3Layout);
        
        introTab.setClosable(false);
        activityManagerTab.setClosable(false);
        resultsTab.setClosable(false);
        
        tabPane.getTabs().add(introTab);
        tabPane.getTabs().add(activityManagerTab);
        tabPane.getTabs().add(resultsTab);
        tabPane.setPadding(new Insets(5,5,5,5));

        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox, Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");
		primaryStage.setTitle("My Carbon Awareness Effort");
		primaryStage.setWidth(900);
		primaryStage.setHeight(370);

        primaryStage.show();
        
		// Button event Handlers
    	addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent addButtonEvent) {
				appController.addActivity(Integer.parseInt(weekField.getText()), dateField.getValue(), activityField.getText(), Integer.parseInt(pointsField.getText()));
				choiceBox.getItems().add(appController.getActivity(Integer.parseInt(weekField.getText()), dateField.getValue(), activityField.getText(), Integer.parseInt(pointsField.getText())));
			}
    	});
    	removeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent removeButtonEvent) {
				choiceBox.getItems().remove(choiceBox.getValue());
				appController.removeActivity(Integer.parseInt(weekField.getText()), dateField.getValue(), activityField.getText(), Integer.parseInt(pointsField.getText()));
			}
    	});
    	listButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent listButtonEvent) {
				String text = appController.getActivitiesText();
				textAreaManager.setText(text);
			}
    	});
       	summaryButton.setOnAction(new EventHandler<ActionEvent>() {
    			@Override
    			public void handle(ActionEvent summaryButtonEvent) {
    				int total = appController.getTotal(Integer.parseInt(weekField.getText()));
    				String text = "\n\nTotal points accumulated for Week " + (weekField.getText()) + ": " + total;
    				textAreaManager.setText(appController.getActivitiesText() + text);
    			}
        	});
       	loadButton.setOnAction(new EventHandler<ActionEvent>() {
    			@Override
    			public void handle(ActionEvent summaryButtonEvent) {
    				appController.loadFromFile();
    				int numberOfActivities = appController.getNumberOfActivities();
    				choiceBox.getItems().clear();
    				for (int i=0; i<numberOfActivities; i++) {
    					choiceBox.getItems().add(appController.getActivityByIndex(i));
    				}
    				choiceBox.getSelectionModel().selectFirst();
    			}
        	});
       	saveButton.setOnAction(new EventHandler<ActionEvent>() {
    			@Override
    			public void handle(ActionEvent saveButtonEvent) {
    				appController.saveToFile();
    			}
        	});
    	exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent exitButtonEvent) {
				Platform.exit();
				System.exit(0);
			}
    	});
        choiceBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Activity activity = choiceBox.getValue();
				if (activity != null) {
					weekField.setText(Integer.toString(activity.getWeek()));
			    	dateField.setValue(activity.getDate());
			    	activityField.setText(activity.getName());
			    	pointsField.setText(Integer.toString(activity.getPoints()));
				}
			}
        });
    	orderByDate.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent orderByDateButtonEvent) {
				int total = appController.getTotalOfAllWeeks();
				String text = appController.getActivitiesByDate() + "\n\nTotal points accumulated: " + total;
				textAreaResults.setText(text);
			}
    	});
    	orderByActivity.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent orderByActivityButtonEvent) {
				int total = appController.getTotalOfAllWeeks();
				String text = appController.getActivitiesByActivity() + "\n\nTotal points accumulated: " + total;
				textAreaResults.setText(text);
			}
    	});
    	deathByObject.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent deathByObjectButtonEvent) {
				while (true) {
					appController.addActivity(Integer.parseInt(weekField.getText()), dateField.getValue(), activityField.getText(), Integer.parseInt(pointsField.getText()));
				}
			}
    	});
	}
	
	@Override
	public void handle(ActionEvent arg0) {
	}
}