package by.bsuir.entity;

public class Product{

    public static enum Types{
        Kettle,
        Oven,
        Phone,
        Product
    }

    private int price;
    private String name;

    public Product(int price, String name){
        this.price = price;
        this.name = name;
    }

    public Types GetType(){
        return Types.Product;
    }

    public String GetName(){
        return this.name;
    }

    public int GetPrice(){
        return this.price;
    }

}
