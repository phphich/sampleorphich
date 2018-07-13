package models;

/**
 * Created by COM-1 on 1/7/2561.
 */
public class Products {
    private String id, name, brand;
    private double price;
    private int amount;
    private double discount;

    public Products() {
    }

    public Products(String id, String name, String brand, double price, int amount) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.amount = amount;
        //สั่งคำนวณส่วนลด
        setDiscount();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        setDiscount();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        setDiscount();
    }

    public double getDiscount() {
        return discount;
    }

    private void setDiscount() {
        double total = price *amount;
        if (total<1000)
            discount=0;
        else if (total< 5000)
            discount=total *0.05;
        else
            discount=total *0.1;
    }

    public double getTotal() {
        return  price * amount;
    }
        


}
