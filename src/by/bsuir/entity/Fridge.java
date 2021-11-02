package by.bsuir.entity;

public class Fridge extends Product{
    private int height;
    private int width;
    private int length;

    public Fridge(int price, String name, String color, int height, int width) {
        super(price, name, color);
        this.height = height;
        this.width = width;
    }

    int getWidth(){
        return width;
    }

    int GetHeight(){
        return height;
    }
}
