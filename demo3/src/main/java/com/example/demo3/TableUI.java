package com.example.demo3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class TableUI {
    private static Stage mainsStage ;
    private static Scene tableScene;
    private static Scene previous;
    public static void exchange(Stage x, int i) {  // NEEDing an argument for table class and for table number
        mainsStage = x;
        previous = x.getScene();
    //======================table SCENE==========================
        StackPane mainPane =new StackPane();
        StackPane logo = new StackPane();
        //============ TABLE LOGO ===========================
        Ellipse first = new Ellipse();
        first.setRadiusX(155);
        first.setRadiusY(30);
        first.setFill(Color.rgb(1,241,97));
        first.centerXProperty().bind(logo.widthProperty().divide(2));
        first.centerYProperty().bind(logo.heightProperty().divide(2));
        Ellipse second = new Ellipse();
        second.setRadiusX(120);
        second.setRadiusY(25);
        second.setFill(Color.rgb(255,255,255));
        second.centerXProperty().bind(logo.widthProperty().divide(2));
        second.centerYProperty().bind(logo.heightProperty().divide(2));
        //========================restaurant logo==============================
        Label name = new Label("Table "+i);
        name.setTextFill(Color.rgb(197,40,40));
        name.setScaleY(4);
        name.setScaleX(3);
        //=======================logo assembling====================================
        logo.getChildren().addAll(first,second,name);
        logo.setPadding(new Insets(50,20,20,0));
        logo.setAlignment(Pos.TOP_CENTER);
        //==========================RETURN BUTTON=======================================
        VBox buttons = new VBox();
        buttons.setSpacing(30);
        Button bt = new Button("BACK");
        Button bt2 = new Button("ORDER");
        Button bt3 = new Button("MENU");
        
        bt.setScaleX(1.5);
        bt.setScaleY(1.5);
        
        bt2.setScaleX(1.5);
        bt2.setScaleY(1.5);
        
        bt3.setScaleX(1.5);
        bt3.setScaleY(1.5);
        
        bt.setOnAction(e ->TableUI.backScene());
        bt2.setOnAction(e ->OrderUI.exchange(mainsStage,i-1));
        bt3.setOnAction(e-> MenuUI.exchange(mainsStage,i-1));

        buttons.getChildren().addAll(bt3,bt2,bt);
        buttons.setAlignment(Pos.CENTER);
    //========================ASSEMBLING table SCENE ===============================


    mainPane.getChildren().addAll(logo,buttons);
    tableScene =new Scene(mainPane,1500,800);
    mainsStage.setScene(tableScene);
    mainsStage.setTitle("table "+ i);
    mainsStage.show();


    }
    public static void backScene(){
        mainsStage.setScene(previous);
        mainsStage.show();

    }
}
