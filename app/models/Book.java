package models;

import java.util.HashSet;
import java.util.Set;
import io.ebean.*;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Constraint;

@Entity

public class Book  extends Model {
    @Id
    @Constraints.Required
    public Integer id;

    @Constraints.Required
    @Constraints.MinLength(5)
    @Constraints.MaxLength(255)
    public String title;

    @Constraints.Required
    public Integer price;

    @Constraints.Required
    public String author;

    public static Finder<Integer, Book> find = new Finder<>(Book.class);


}

