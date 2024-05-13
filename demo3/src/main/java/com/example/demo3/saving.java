package com.example.demo3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class saving {
    private static int allPaymentsCounter=0;
    private static String pathname = String.format("Restaurant_Payment_%o",allPaymentsCounter);
    private java.util.Calendar date ;
    public static void createFile(){
        try {
            allPaymentsCounter++;
            File myObj = new File(pathname);

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public static void fileWrite(ArrayList<Food> orderedList,double totalPrice){
        try {
            FileWriter myWriter = new FileWriter(pathname);
            myWriter.write("Ordered time: "+ java.time.LocalDateTime.now());
            for(Food f : orderedList){
                myWriter.write("\nmeal : " + f.getName() + "\nprice : "+f.getPrice());
            }
            myWriter.write("\n************total price**************"+"\n"+totalPrice);
            myWriter.close();
        }
        catch(IOException _){

        }
    }
}
