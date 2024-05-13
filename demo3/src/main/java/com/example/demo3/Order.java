package com.example.demo3;

import java.util.*;
 class Order /*implements Clearable*/{
   private double bill;

   private ArrayList<Food> list = new ArrayList<Food>(){
       {/////////for testing setting/////////////////
//           add(new Side("Mashed potato",7.2,"pizza.png"));
//           add(new Side("Mashed potato",7.2));
       }///////////////////////////
   };
   public void removeFromList(int index){
       list.remove((index));
   }
     ////
   public void addToList(Food food)
    {
        list.add(food);
    }

   public  ArrayList<Food> getList()
   {
       return list;
   }
   public  Food getlistElem(int index)
   {
       return list.get(index);
   }


   public double payBill(int mainplate_index, int side_index, int soda_index)
   {
       bill = list.get(mainplate_index).getPrice()
               + list.get(side_index).getPrice()
               + list.get(soda_index).getPrice();
       return bill;
   }

     public void clear(){
         this.bill=0;
        list.clear();
     }

 }
