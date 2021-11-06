package by.bsuir.entity;

public class Phone extends Product{
    private int diagonal;
    private String color;
    public Phone(int price, String name, String color, int diagonal){
        super(price, name);
        this.color = color;
        this.diagonal = diagonal;
    }

    @Override
    public Types GetType(){
        return Types.Phone;
    }

    public String GetColor(){
        return this.color;
    }
}
