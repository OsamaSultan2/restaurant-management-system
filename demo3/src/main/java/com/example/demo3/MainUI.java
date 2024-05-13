package com.example.demo3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public  class MainUI {
    private static Stage mainsStage ;
    private static Scene tableScene;
    private static Scene previous;
    public static void table_SceneExchange(Stage x){
        mainsStage= x;
        previous=  x.getScene();
        //============== TABLES SCENE ===============================================
        StackPane logo = new StackPane();
        //============ border logo ===========================
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

        Label name = new Label("Restaurant");
        name.setTextFill(Color.rgb(197,40,40));
        name.setScaleY(4);
        name.setScaleX(3);

        //=======================logo assembling====================================

        logo.getChildren().addAll(first,second,name);
        logo.setPadding(new Insets(50,20,20,0));
        logo.setAlignment(Pos.TOP_CENTER);

        //=====================background image=======================================

        StackPane main_pane=new StackPane();
        Image background_image=null;

        background_image=new Image("restaurant.jpg");

        ImageView background=new ImageView(background_image);
        background.fitWidthProperty().bind(main_pane.widthProperty());
        background.fitHeightProperty().bind(main_pane.heightProperty());

        main_pane.getChildren().addAll(background,logo);
        //===================== TABLESPANE================================================
        Image table_image=null;
        table_image = new Image("dining-table-png-41441.png");

        ImageView tables[]= new ImageView[4];



        HBox tables_pane1 = new HBox();
        HBox tables_pane2 = new HBox();
        VBox tables_pane = new VBox();

        tables_pane1.setSpacing(400);
        tables_pane2.setSpacing(900);
        tables_pane.setSpacing(0);

        for (int i=0;i<4;i++) {
            int finalI = i;

            tables[i] =new ImageView(table_image);
            tables[i].setFitWidth(150);
            tables[i].setFitHeight(150);

            tables[i].setOnMouseClicked(e ->
                    {
                        if(Data.getTable(finalI).getNoChairs()==0)
                            MainUI.tableFirstTime(finalI);
                        else
                            TableUI.exchange(mainsStage,finalI+1);

                    }
            );




            tables[i].setOnMouseMoved(e ->{
                tables[finalI].setCursor(Cursor.HAND);
                Effect effect=new Glow();
                tables[finalI].setEffect(effect);
            });

            tables[i].setOnMouseExited(e->{
                tables[finalI].setEffect(null);
            });
        }
        tables_pane1.getChildren().addAll(tables[1],tables[2]);
        tables_pane2.getChildren().addAll(tables[0],tables[3]);

        tables_pane1.setAlignment(Pos.CENTER);
        tables_pane2.setAlignment(Pos.CENTER);

        tables_pane.getChildren().addAll(tables_pane1,tables_pane2);
        tables_pane.setAlignment(Pos.BOTTOM_CENTER);
        tables_pane.setPadding(new Insets(0,0,100,0));


        //==================assembling the scene======================================

        main_pane.getChildren().add(tables_pane);
        tableScene= new Scene(main_pane,1500,800);

        mainsStage.setScene(tableScene);
        mainsStage.show();
//        mainsStage.setFullScreen(true);
//        mainsStage.setFullScreenExitHint("");
//        mainsStage.setAlwaysOnTop(true);


    }
    private static void tableFirstTime( int i){
        Stage messageStage =new Stage();
        VBox mainPane =new VBox();
        //boolean flag=false;
        mainPane.setSpacing(20);
        Label message= new Label("Please enter number of persons:");

        Button done =new Button("Set");
        done.setScaleX(1.5);
        done.setScaleY(1.5);

        TextField number= new TextField();
        number.setMinSize(20,20);
        mainPane.getChildren().addAll(message,number,done);
        mainPane.setAlignment(Pos.CENTER);
        Scene maessageScene= new Scene(mainPane,200,150);
        messageStage.setScene(maessageScene);
        messageStage.show();

        //stage for error 1st type less than expected
        VBox errorpanev1=new VBox();
        Scene error1=new Scene(errorpanev1);
        Stage st1=new Stage();
        st1.setScene(error1);
        Label labelerror=new Label("you are only limited from 1 to 4 persons");
        Button err=new Button("back to reserving");
        err.setOnAction(y->{st1.close();messageStage.show();number.clear();});
        errorpanev1.getChildren().addAll(labelerror,err);
        errorpanev1.setAlignment(Pos.CENTER);
        errorpanev1.setSpacing(15);
        st1.setWidth(300);
        st1.setHeight(150);
        labelerror.setFont(Font.font(15));
        err.setFont(Font.font(15));
        //stage for error second type input mismatch
        VBox errorpanev2=new VBox();
        Scene error2=new Scene(errorpanev2);
        Stage st2=new Stage();
        Label labelerror1=new Label("your input in invalid");
        Button err1=new Button("back to reserving");
        err1.setFont(Font.font(15));
        err1.setOnAction(w->{st2.close();messageStage.show();number.clear();});
        errorpanev2.getChildren().addAll(labelerror1,err1);
        errorpanev2.setAlignment(Pos.CENTER);
        errorpanev2.setSpacing(10);
        labelerror1.setFont(Font.font(15));
        st2.setScene(error2);
        st2.setWidth(225);
        st2.setHeight(125);
        //set on action for the main button
        done.setOnAction(d->
        {
            try{
                int noChairs = Integer.parseInt(number.getText());
                if(noChairs<=0 || noChairs>=5 ){
                    messageStage.close();
                    st1.show();

                }
                else {
                    Data.getTable(i).setNoChairs(noChairs);
                    messageStage.close();
                    TableUI.exchange(mainsStage,i+1);
                }}
            catch (Exception NumberFormatException){
                messageStage.close();
                st2.show();
            }
        });


    }
}