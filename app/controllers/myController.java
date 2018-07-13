package controllers;

import models.Book;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import models.Person;
import models.Products;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

/**
 * Created by COM-1 on 1/7/2561.
 */
public class myController extends Controller{
    public static Person staff;
    public static Products computer;
    public static Book book;
    public static Form<Book> bookForm = Form.form(Book.class);

    public static String proName;

    public static Result showProfile() {
        /*String name, department;
        name = "Dr. Phichayaphak";
        department="Computer Information System";

        staff= new Person();
        staff.setId("st001");
        staff.setName("Smith");
        staff.setSurname("Smile");
        staff.setAddress("Khonkean");
        staff.setAge(35);
        staff.setSalary(28000.00);
        return ok(showData.render(staff)); */
        computer = new Products("p001", "computer PC", "Acer", 25500.00, 5);
        return ok(showData.render(computer));

    }

    public static Result book_form() {
        return ok(book_form.render());
    }

    public static Result book_post(){
        DynamicForm myForm = Form.form().bindFromRequest();
        String title, author, booktype, language, award, detail ;
        double price;

        title = myForm.get("title");
        author = myForm.get("author");
        booktype=myForm.get("booktype");
        language=myForm.get("language");
        //award=myForm.get("award");ZS

        if(myForm.get("award") != null )
            award="เคยได้รับรางวัล";
        else
            award= "ไม่เคยได้รับรางวัล";

        detail=myForm.get("detail");
        price = Double.parseDouble(myForm.get("price"));
        book = new Book(title, author, booktype, language, award, detail, price);
        /*book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        book.setBooktype(booktype);
        book.setLanguage(language);
        book.setAward(award);
        book.setDetail(detail); */

        return ok(book_show.render(book));
    }

    public static Result book_form_helper(){
        bookForm =Form.form(Book.class);
        return ok(book_form_helper.render(bookForm));
    }

    public static Result book_post_helper(){
        Form<Book> newForm = bookForm.bindFromRequest();
        if(newForm.hasErrors()){
            return  ok(book_form_helper.render(newForm));
        }
        else{
            book = newForm.get();
            return ok(book_show_helper.render(book));
        }

    }

}
