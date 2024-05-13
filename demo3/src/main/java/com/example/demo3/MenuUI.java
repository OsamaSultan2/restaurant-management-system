package com.example.demo3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class MenuUI {
    private static Stage mainsStage ;
    private static Scene menuScene;
    private static Scene previous;
    public static void exchange(Stage x,int index){ //table instance is needed
        mainsStage = x;
        previous = x.getScene();
        //======================menu SCENE==========================

        BorderPane mainPane =new BorderPane();
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

        Label name = new Label("Menu");
        name.setTextFill(Color.rgb(197,40,40));
        name.setScaleY(4);
        name.setScaleX(3);

        //=======================logo assembling====================================

        logo.getChildren().addAll(first,second,name);
        logo.setPadding(new Insets(50,20,20,0));
        logo.setAlignment(Pos.TOP_CENTER);

        //=========================== MENU =============================================

        GridPane sodas =new GridPane();
        GridPane mainPlates=new GridPane();
        GridPane sides =new GridPane();
        FlowPane menu= new FlowPane();

        Label sideLabel= new Label("Sides");
        Label mainPlateslabel= new Label("MainPlates");
        Label sodaLabel= new Label("Sodas");

        sideLabel.setAlignment(Pos.CENTER);
        sideLabel.setFont(Font.font(20));


        mainPlateslabel.setAlignment(Pos.CENTER);
        mainPlateslabel.setFont(Font.font(20));

        sodaLabel.setAlignment(Pos.CENTER);
        sodaLabel.setFont(Font.font(20));

        sides.setHgap(30);
        mainPlates.setHgap(30);
        sodas.setHgap(30);

        sides.setVgap(30);
        mainPlates.setVgap(30);
        sodas.setVgap(30);

        sides.add(sideLabel,1,0);
        mainPlates.add(mainPlateslabel,1,0);
        sodas.add(sodaLabel,1,0);

        Data.sortMenu();

        int length = Data.getMenu().length;
        int mainPlateCounter=1;
        int sideCounter=1;
        int sodaCounter=1;

        Button[] button=new Button[length];

    for (int i=0; i<length;i++) {
        Food item =Data.getMenuItem(i);
    if(item instanceof MainPlate ){

        button[i]= new Button("add");
        Label  plateName=new Label(Data.getMenuItem(i).getName());
        Double price =Data.getMenuItem(i).getPrice();
        Label  platePrice=new Label(price.toString());
        plateName.setFont(Font.font(15));
        platePrice.setFont(Font.font(15));
        mainPlates.add(plateName,0,mainPlateCounter);
        mainPlates.add(platePrice,1,mainPlateCounter);
        mainPlates.add(button[i],2,mainPlateCounter);

        button[i].setOnAction(e->
        {
        Data.getTable(index).getOrder().addToList(item);
        MenuUI.dataSend();
        }
        );
        mainPlateCounter+=1;


    }
        else if(item instanceof Side ){

            button[i]= new Button("add");
            Label  sideName=new Label( Data.getMenuItem(i).getName());
            Double price =Data.getMenuItem(i).getPrice();
            Label  sidePrice=new Label(price.toString());
            sideName.setFont(Font.font(15));
             sidePrice.setFont(Font.font(15));

            sides.add(sideName,0,sideCounter);
            sides.add(sidePrice,1,sideCounter);
            sides.add(button[i],2,sideCounter);

            button[i].setOnAction(e->
                    {
                        Data.getTable(index).getOrder().addToList(item);
                        MenuUI.dataSend();
                    }
                    );

        sideCounter+=1;

        }

        if(item instanceof Soda ){

            button[i]= new Button("add");
            Label  sodaName=new Label( Data.getMenuItem(i).getName());
            Double price =Data.getMenuItem(i).getPrice();
            Label  sodaPrice=new Label(price.toString());
            sodaName.setFont(Font.font(15));
            sodaPrice.setFont(Font.font(15));

            sodas.add(sodaName,0,sodaCounter);
            sodas.add(sodaPrice,1,sodaCounter);
            sodas.add(button[i],2,sodaCounter);
            sodaCounter+=1;

            button[i].setOnAction(e->
                    {
                        Data.getTable(index).getOrder().addToList(item);
                        MenuUI.dataSend();
                    }
                    );
        }
    }

    menu.setHgap(150);
    menu.setVgap(70);
    menu.getChildren().addAll(mainPlates,sides,sodas);
    menu.setAlignment(Pos.CENTER);



       //=======================BACK BUTTON ========================================

        HBox backButton = new HBox();
        backButton.setPadding(new Insets(0,0,40,40));

        Button bt = new Button("BACK");
        bt.setScaleX(1.5);
        bt.setScaleY(1.5);
        bt.setOnAction(e ->MenuUI.backScene());

            backButton.getChildren().add(bt);
      backButton.setAlignment(Pos.BOTTOM_LEFT);
       //======================= SCENE assembling ==================================
        mainPane.setTop(logo);
        mainPane.setCenter(menu);
        mainPane.setBottom(backButton);
        menuScene= new Scene(mainPane,1500,800);

        mainsStage.setScene(menuScene);
        mainsStage.setTitle("Menu");
        mainsStage.show();
//        mainsStage.setFullScreen(true);
//        mainsStage.setFullScreenExitHint("");
    }
    private static void backScene(){
        mainsStage.setScene(previous);
        mainsStage.show();
//        mainsStage.setFullScreen(true);
//        mainsStage.setFullScreenExitHint("");
    }

    //============DATA method==================
    private static void dataSend(){
        Stage messageStage = new Stage();
        Scene messageScene;
        Label message = new Label("Item added successfully");
        message.setAlignment(Pos.CENTER);
        message.setFont(Font.font(15));
        messageScene= new Scene(message,200,200);
        messageStage.setTitle("Done");
        messageStage.setScene(messageScene);
        messageStage.show();
    }
}