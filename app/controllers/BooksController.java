package controllers;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Set;


import javax.inject.Inject;



public class BooksController extends Controller{
    @Inject
    public FormFactory formFactory;

    //for all books

    public Result index(){
        Set<Book> books =  Book.allBooks();
            return ok(views.html.books.index.render(books));
    }

    // to create a book

    public Result create() {
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(views.html.books.create.render(bookForm));




    }

    // to save book

    public Result save() {
        return TODO;

    }

    //

    public  Result edit(Integer id){
        return  TODO;

    }


    public Result destroy( Integer id){
        return  TODO;
    }


    //for all books

    public Result show ( Integer id){
        return TODO;
    }

    public Result update(){
        return  TODO;
    }
}
