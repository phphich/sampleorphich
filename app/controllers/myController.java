package controllers;

import models.Book;
import models.Comics;
import play.Play;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import models.Person;
import models.Products;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by COM-1 on 1/7/2561.
 */
public class myController extends Controller{
    public static Person staff;
    public static Products computer;
    public static Book book;
    public static Form<Book> bookForm = Form.form(Book.class);
    public static String proName;
    public static  List<Book> books = new ArrayList<Book>();

    public static Form<Comics> comicsForm=Form.form(Comics.class);
    public static List<Comics> comicsList = new ArrayList<Comics>();
    public static Comics comics;
    public static String comPicPath = "public" +Play.application().configuration().getString("com_pic_path");

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
        return Application.main(showData.render(staff)); */
        computer = new Products("p001", "computer PC", "Acer", 25500.00, 5);
        return Application.main(showData.render(computer));

    }

    public static Result book_form() {
        return Application.main(book_form.render());
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

        return Application.main(book_show.render(book));
    }

    public static Result book_form_helper(){
        bookForm =Form.form(Book.class);
        return Application.main(book_form_helper.render(bookForm));
    }

    public static Result book_post_helper(){
        Form<Book> newForm = bookForm.bindFromRequest();
        if(newForm.hasErrors()){
            return  Application.main(book_form_helper.render(newForm));
        }
        else{
            book = newForm.get();
            return Application.main(book_show_helper.render(book));
        }
    }

    public  static Result book_form_helper_list(){
        bookForm =Form.form(Book.class);
        return Application.main(book_form_helper_list.render(bookForm));
    }

    public static Result book_post_helper_list(){
        Form<Book> newForm = bookForm.bindFromRequest();
        if(newForm.hasErrors()){
            return  Application.main(book_form_helper_list.render(newForm));
        }



        else{
        /*    books.add(new Book("Computer Programming1", "DR.John", "สารคดี", "ไทย", "เคยได้รับรางวัล","N/A", 1000.00) );

            book = new Book();
            book.setTitle("Com2");
            book.setAuthor("DR. A");
            book.setBooktype("สารคดี");
            book.setLanguage("ไทย");
            book.setAward("เคยรับรางวัล");
            book.setDetail(".....");
            book.setPrice(1200.00);
            books.add(book);  */

            book = newForm.get();
            books.add(book);
            return Application.main(book_show_helper_list.render(books));
        }
    }

    public static Result comics_form_helper_list(){
        comicsForm = Form.form(Comics.class);
        //return Application.main(info.render(comPicPath));
        return Application.main(comics_form_helper_list.render(comicsForm));
    }

    public static Result comics_post_helper_list(){
        Form<Comics> myForm = comicsForm.bindFromRequest();
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("picture");
        String fileName, contentType;
        if(myForm.hasErrors()){
            flash("errMsg", "ท่านป้อนข้อมูลไม่ถูกต้อง/ไม่สมบูรณ์");
            return Application.main(comics_form_helper_list.render(myForm));
        }
        else {
            if (picture != null) {
                contentType = picture.getContentType();
                File file = picture.getFile();
                fileName = picture.getFilename();
                if (!contentType.startsWith("image")) {
                    flash("errContentType", "ท่านเลือกประเภทไฟล์ที่ไม่ใช่รูปภาพ");
                    return Application.main(comics_form_helper_list.render(myForm));
                }
                comics = myForm.get();
                fileName = comics.getId()  + fileName.substring(fileName.lastIndexOf("."));
                file.renameTo( new File("public/images/comics", fileName));
                comics.setPicture(fileName);
                comicsList.add(comics);
            }
            return Application.main(comics_show_helper_list.render(comicsList));
        }
    }

    public static Result showComicsList() {
        return Application.main(comics_show_helper_list.render(comicsList));
    }



}
