package com.example.demo3;

public class Data {
    private static Table[] table={new Table(),new Table(),new Table(),new Table()};
    private static Food[] menu ={
            new Side("Pasta salad",5.9),
            new Side("Mashed potato",7.2),
            new Side("Coleslaw",10.0),
            new Side("French fries",10.5),
            new Side("Onion rings",10.5),
            new MainPlate("kofta",15.9),
            new MainPlate("Kebab",24.2),
            new Soda("Apple juice",1.5),
            new Soda("Orange juice",2.0),
            new MainPlate("Koshary",20.7),
            new Soda("Tea",1.0),
            new Soda("Big Cola",5.3),
            new Soda("Mango juice",2.4),
            new MainPlate("Pizza",50.5,"pizza.png"),
            new MainPlate("Tarb",43.7)
    };
    public static Table getTable(int i){
        return table[i];
    }
    public static Food getMenuItem(int i) {
    return menu[i];
    }
    public static void initTable(){
        for (int i=0;i<4;i++){
            table[i]=new Table();
        }
    }
    public static void sortMenu(){
       java.util.Arrays.sort(menu);
    }
    public static Food[] getMenu(){
        return menu;
    }
}
