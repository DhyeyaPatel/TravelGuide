package pojo;

public class Activity {
    private String name;
    private String description;
    private double price;
    private int capacity;

    public Activity() {
        super();
    }

    public Activity(String name, String description, double price, int capacity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
