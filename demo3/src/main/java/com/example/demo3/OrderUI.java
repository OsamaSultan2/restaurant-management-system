package com.example.demo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public  class OrderUI {
    private static Stage mainStage;
    private static Scene previous;
    public static void exchange(Stage stage, int index) {
        mainStage=stage;
        previous=stage.getScene();
        //System.out.println(Data.getTable(1).getOrder().list);
        addMealsGui(stage, index);

        // meal1Root.setPrefSize(400,500);
        // HBox.setMargin(menuRoot,new Insets(10));
        //VBox.setMargin(orderRoot,new Insets(10));
        //meal1Root.setSpacing(10);
    }

    /////////////////////// meal adding to ordered GUI/////////////////
    public static void addMealsGui(Stage stage, int index) {


        HBox menuRoot = new HBox(10);
        VBox orderRoot = new VBox(15);
        VBox.setMargin(menuRoot, new Insets(10, 0, 0, 0));




        ArrayList<Food> orderedList = Data.getTable(index).getOrder().getList();


        ImageView[] imageViews = new ImageView[orderedList.size()];
        Text[] priceText = new Text[orderedList.size()];
        double totalPrice = 0;


        for (int i = 0; i < orderedList.size(); i++) {


            VBox meal1Root = new VBox(10);
            meal1Root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(15), new Insets(-10))));


            try {

                imageViews[i] = new ImageView(orderedList.get(i).getFoodImg());
                imageViews[i].setFitWidth(100);
                imageViews[i].setFitHeight(100);
                meal1Root.getChildren().addAll(imageViews[i]);

            } catch (Exception e) {

                System.out.println("noImgpath");

            }


            priceText[i] = new Text("Item price is : " + Double.toString(orderedList.get(i).getPrice()) + "\nItem name : " + orderedList.get(i).getName());
            priceText[i].setFont(Font.font("Roboto", 14));
            totalPrice += orderedList.get(i).getPrice();


            meal1Root.getChildren().addAll(priceText[i]);
            menuRoot.getChildren().addAll(meal1Root);
        }


        Text totalPriceText = new Text("\nTotal check = " + (totalPrice + (totalPrice * 14 / 100)));
        totalPriceText.setFont(Font.font("Roboto", 40));


        Text taxesText = new Text("Total items price = " + totalPrice + "\n14% taxes = " + (totalPrice * 14 / 100));
        taxesText.setFont(Font.font("Roboto", 15));
        taxesText.setFill(Color.GRAY);


        menuRoot.setSpacing(25);


        VBox.setMargin(totalPriceText, new Insets(0, 0, 0, 0));
        ///

        ///
        menuRoot.setAlignment(Pos.TOP_CENTER);
        orderRoot.setAlignment(Pos.TOP_CENTER);

        ImageView headerImg = new ImageView("216a8c258305188af56217c3b58b99c5 (1).jpg");
        headerImg.setFitWidth(1600);


        Button backBtn = new Button("Back");
        backBtn.setPrefWidth(75);
        /////////////////BACK IMPELEMENTATION //////////////////////////

        ///////////////
        Button saveBtn = new Button("Save");
        saveBtn.setPrefWidth(75);
        ///////////////////Save///////////////
        backBtn.setOnAction(e-> OrderUI.backScene());
        final double TotalPrice = totalPrice;
        saveBtn.setOnAction(actionEvent -> {

            saving.createFile();
            saving.fileWrite(orderedList, TotalPrice);


//            for (int i = 0; i < orderedList.size(); )
//                Data.getTable(index).getOrder().removeFromList(i);
//
//
            Data.getTable(index).clear();
            addMealsGui(stage, index);

        });
        orderRoot.getChildren().addAll(headerImg, menuRoot, taxesText, totalPriceText, backBtn, saveBtn);
///////////////////

        Scene scene = new Scene(orderRoot, 1500, 800);
        stage.setTitle("Order");
        stage.setScene(scene);
        stage.show();

    }
    private static void backScene(){
        mainStage.setScene(previous);
        mainStage.show();
//        mainsStage.setFullScreen(true);
//        mainsStage.setFullScreenExitHint("");
    }
}
//////////////////////
