package com.example.demo3;

import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //=======specifing elements =======================

        Data.initTable();
        Pane logo = new Pane();
        //============ border logo ===========================
        Ellipse first = new Ellipse();
        first.setRadiusX(195);
        first.setRadiusY(40);
        first.setFill(Color.rgb(1,241,97));
        first.centerXProperty().bind(logo.widthProperty().divide(2));
        first.centerYProperty().bind(logo.heightProperty().divide(2));
        Ellipse second = new Ellipse();
        second.setRadiusX(160);
        second.setRadiusY(35);
        second.setFill(Color.rgb(255,255,255));
        second.centerXProperty().bind(logo.widthProperty().divide(2));
        second.centerYProperty().bind(logo.heightProperty().divide(2));
        //=============restaurant logo======================
        Label name = new Label("Restaurant");
        name.setTextFill(Color.rgb(197,40,40));
        name.layoutXProperty().bind(logo.widthProperty().divide(2).subtract(28));
        name.layoutYProperty().bind(logo.heightProperty().divide(2).subtract(40));
        name.setScaleY(5);
        name.setScaleX(4);
        logo.getChildren().addAll(first,second,name);
        //======================================================
        HBox buttons = new HBox();
        buttons.setSpacing(10);
        Button start = new Button("start");
        start.setScaleX(2);
        start.setScaleY(2);
        start.setOnAction( (ActionEvent e)-> {MainUI.table_SceneExchange(stage);});
        //==================scene pane====================
        FlowPane start_pane = new FlowPane();
        buttons.getChildren().add(start);
        start_pane.setVgap(75);
        start_pane.setHgap(10);

        start_pane.setOrientation(Orientation.VERTICAL);
        start_pane.getChildren().addAll(logo,buttons);
        buttons.setAlignment(Pos.CENTER);

        //==========main_scene with background=============
        Pane main_pane=new Pane();
        Image main_image = new Image("main.jpg");
        ImageView main_background=new ImageView(main_image);
        main_background.fitWidthProperty().bind(main_pane.widthProperty());
        main_background.fitHeightProperty().bind(main_pane.heightProperty());
        main_pane.getChildren().addAll(main_background,start_pane);

        start_pane.setLayoutX(400);
        start_pane.setLayoutY(400);
        Scene main =new Scene(main_pane,1500,800);

        stage.setScene(main);
        stage.show();

    }

    

    //=============end of test===============
    public static void main(String[] args) {

        launch();
    }
}
