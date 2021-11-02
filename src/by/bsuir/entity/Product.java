package by.bsuir.entity;

public class Product
{
    private int price;
    private String name;
    private String color;

    public Product(int price, String name, String color)
    {
        this.price = price;
        this.name = name;
        this.color = color;
    }

    public String GetName()
    {
        return this.name;
    }

    public int GetPrice()
    {
        return this.price;
    }
}
