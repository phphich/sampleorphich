package models;

/**
 * Created by COM-1 on 8/7/2561.
 */
public class Book {
    private String title, author, booktype, language, award, detail;
    private double price;

    public Book() {
    }

    public Book(String title, String author, String booktype, String language, String award, String detail, double price) {
        this.title = title;
        this.author = author;
        this.booktype = booktype;
        this.language = language;
        this.award = award;
        this.detail = detail;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
