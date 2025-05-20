package edu.miracosta.cs112.lab07;//package name here depending on your IDE

import javafx.application.Application;  //abstract class used for JavaFX GUI's
import javafx.stage.Stage;              //class for GUI window
import javafx.scene.Scene;              //class for specific view in GUI window
import javafx.scene.layout.VBox;        //class for layout pane, organized top-to-bottom
import javafx.scene.control.Label;      //class for label component
import javafx.scene.control.Button;     //class for button component
import javafx.event.EventHandler;       //interface for handling events
import javafx.event.ActionEvent;        //class for type of event for action (like button or key pressed)

public class HelloApplication extends Application implements EventHandler { //inheriting core functionality + this class will handle events
    /*** GUI COMPONENTS ***/
    // TODO: follow step 25 in README.md to create reference variables
    private Label topLabel;
    private Label bottomLabel;
    private Button button1;
    private Button button2;
    private TextField textField;
    private int button2ClickCount = 0;

    /*** DRIVER main ***/
    public static void main(String[] args) {
        launch(args); //method from Application class, must be called to setup javafx application
    }

    // TODO: follow steps 2-9 in README.md to create a start method
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello GUI: Your Name");

        // Layouts
        StackPane layout = new StackPane();
        AnchorPane anchorPane = new AnchorPane();
        layout.getChildren().add(anchorPane);

        // Labels
        topLabel = new Label("Hello GUI World");
        bottomLabel = new Label("Click counts appear here.");

        // Buttons
        button1 = new Button("Set Text");
        button2 = new Button("Click Counter");

        button1.setOnAction(this);
        button2.setOnAction(this);

        // TextField
        textField = new TextField();
        AnchorPane.setTopAnchor(textField, 150.0);
        AnchorPane.setLeftAnchor(textField, 100.0);
        AnchorPane.setRightAnchor(textField, 100.0);
        anchorPane.getChildren().add(textField);

        // Position Top Label
        AnchorPane.setTopAnchor(topLabel, 10.0);
        AnchorPane.setLeftAnchor(topLabel, 10.0);
        anchorPane.getChildren().add(topLabel);

        // Position Bottom Label
        AnchorPane.setBottomAnchor(bottomLabel, 10.0);
        AnchorPane.setLeftAnchor(bottomLabel, 10.0);
        anchorPane.getChildren().add(bottomLabel);

        // Position Buttons
        AnchorPane.setBottomAnchor(button1, 10.0);
        AnchorPane.setRightAnchor(button1, 10.0);
        anchorPane.getChildren().add(button1);

        AnchorPane.setBottomAnchor(button2, 10.0);
        AnchorPane.setLeftAnchor(button2, 10.0);
        anchorPane.getChildren().add(button2);

        // Scene setup
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // TODO: follow steps 10-21 in README.md to add objects to your layout (inside start)

    // TODO: follow steps 22-34 in README.md to create an event handler
     @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button1) {
            String input = textField.getText();
            topLabel.setText(input.isEmpty() ? "You didn’t enter anything!" : input);
        } else if (event.getSource() == button2) {
            button2ClickCount++;
            bottomLabel.setText("Button clicked " + button2ClickCount + " times");
        }
    }
}
