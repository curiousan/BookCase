package controllers;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Set;
import views.html.books.*;


import javax.inject.Inject;



public class BooksController extends Controller{
    @Inject
    public FormFactory formFactory;

    //for all books

    public Result index(){
        List<Book> books =  Book.find.all();
        return ok(views.html.books.index.render(books));
    }

    // to create a book

    public Result create() {
        Form<Book> bookForm = formFactory.form(Book.class);
        if(bookForm.hasErrors()){
            flash("danger","please check the input below");
            return badRequest(create.render(bookForm));
        }
        return ok(views.html.books.create.render(bookForm));




    }

    // to save book

    public Result save() {
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
        book.save();
        flash("success", "book saved successfully");
        return redirect(routes.BooksController.index());

    }

    //

    public  Result edit(Integer id){
        Book book = Book.find.byId(id);
        if (book == null ){
            return notFound("Book not found");
        }
        Form<Book> bookForm = formFactory.form(Book.class).fill(book);


        return  ok(views.html.books.edit.render(bookForm));




    }



    public Result destroy( Integer id){
        Book book = Book.find.byId(id);
        if(book ==  null){
            return notFound("books with given id is not found");
        }
        book.delete();
        return redirect(routes.BooksController.index());

    }


    //for all books

    public Result show ( Integer id){
        Book book = Book.find.byId(id);
        return  ok(views.html.books.show.render(book));
    }

    public Result update(){
        Book book = formFactory.form(Book.class).bindFromRequest().get();
        Book oldbook = Book.find.byId(book.id);
        if(oldbook != null){
            oldbook.author = book.author;
            oldbook.title = book.title;
            oldbook.price = book.price;
            oldbook.update();
        }




        return redirect(routes.BooksController.index());
    }
}
