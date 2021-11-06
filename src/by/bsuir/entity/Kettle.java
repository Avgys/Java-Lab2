package by.bsuir.entity;

public class Kettle extends Product{
    private int capacity;

    public Kettle(int price, String name, int capacity) {
        super(price, name);
        this.capacity = capacity;
    }

    @Override
    public Types GetType(){
        return Types.Kettle;
    }

    int GetCapacity(){
        return capacity;
    }
}