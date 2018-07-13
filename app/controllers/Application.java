package controllers;

import play.*;
import play.api.templates.Html;
import play.mvc.*;
import views.html.*;
import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static Result main(Html content){
        return ok(main.render(content));
    }

    public static Result index() {
        return main(home.render());
    }

    public static Result datatable(){
        return main(datatable.render());
    }

    public static Result train(){
        return main(train.render());
    }

    public static Result info(){
        return main(info.render("Dynamic Web Programming 2018"));
    }


}
