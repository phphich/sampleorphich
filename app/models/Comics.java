package models;

import java.util.Random;

/**
 * Created by COM-1 on 28/7/2561.
 */
public class Comics extends Book {
    private String id;
    private double discountRate;
    private String picture;

    public Comics() {
        setId();
    }

    public Comics(String title, String author, String booktype, String language, String award, String detail, double price, double discountRate, String picture) {
        super(title, author, booktype, language, award, detail, price);
        setId();
        this.discountRate = discountRate;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    private void setId() {
        Random random = new Random();
        id = Integer.toString(random.nextInt(100000) + 1);
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public  double getNetPrice() {
        return getPrice() -(getPrice() * discountRate/100);
    }
}

