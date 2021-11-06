package by.bsuir.entity;

public class Oven extends Product{
    private int height;
    private int width;
    private int length;

    public Oven(int price, String name, int height, int width) {
        super(price, name);
        this.height = height;
        this.width = width;
    }

    @Override
    public Types GetType(){
        return Types.Oven;
    }

    int getWidth(){
        return width;
    }

    int GetHeight(){
        return height;
    }
}
