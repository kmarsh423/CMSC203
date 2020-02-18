package FXMainPane;

import java.awt.Event;

import DataManager.DataManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button b1 = new Button(); 
	Button b2 = new Button(); 
	Button b3 = new Button(); 
	Button b4 = new Button(); 
	Button b5 = new Button(); 
	Button bS = new Button();
	
	
	Label label1 = new Label();
	
	TextField textfield = new TextField();
	
	//  declare two HBoxes
	
	HBox hb1;
	HBox hb2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager data;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	public FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		b1.setText("Hello");
		b2.setText("Howdy");
		b3.setText("Chinese");
		bS.setText("Swedish");
		b4.setText("Clear");
		b5.setText("Exit");
		
		label1.setText("Feedback");
		
		ButtonHandler bH = new ButtonHandler();
		
		//  instantiate the HBoxes
		hb1 = new HBox();
		hb2 = new HBox();

		//student Task #4:
		//  instantiate the DataManager instance
		data = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(b1, new Insets(10));
		HBox.setMargin(b2, new Insets(10));
		HBox.setMargin(b3, new Insets(10));
		HBox.setMargin(bS, new Insets(10));
		HBox.setMargin(b4, new Insets(10));
		HBox.setMargin(b5, new Insets(10));
		
		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hb1.getChildren().addAll(label1, textfield);
		//  add the buttons to the other HBox
		hb2.getChildren().addAll(b1, b2, b3, bS, b4, b5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hb1, hb2);
		
		b1.setOnAction(bH);
		b2.setOnAction(bH);
		b3.setOnAction(bH);
		bS.setOnAction(bH);
		b4.setOnAction(bH);
		b5.setOnAction(bH);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{

		public void handle(ActionEvent event) {
			if(event.getTarget().equals(b1)) 
				textfield.setText(data.getHello());
			else if (event.getTarget().equals(b2))
				textfield.setText(data.getHowdy());
			else if (event.getTarget().equals(b3))
				textfield.setText(data.getChinese());
			else if (event.getTarget().equals(bS))
				textfield.setText(data.getSwedish());
			else if(event.getTarget().equals(b4))
				textfield.setText("");
			else if (event.getTarget().equals(b5))
				System.exit(0);
		}
	}
}