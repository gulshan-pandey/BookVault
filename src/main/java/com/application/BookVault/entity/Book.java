package com.application.BookVault.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter                         // Lombok's Magic
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", length = 50, nullable = false, unique = true)
    private String ISBN;

    @Column(name = "name", length = 50, nullable = false)
    private  String  name;

    @Column(name = "description", length = 250, nullable = false)
    private  String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    //whatever changes will happen on book same will be reflected on authors related to book
    private Set<Author> authors = new HashSet<Author>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="books_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    //whatever changes will happen on book same will be reflected on categories related to book
    private Set<Category> categories = new HashSet<Category>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="books_publishers",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id"))
    private Set<Publisher> publishers = new HashSet<Publisher>();


    public Book( String isbn, String name, String description) {
        this.ISBN = isbn;
        this.name = name;
        this.description = description;

    }

    //as relation between book and publisher is bidirectional
    // so when removing a book then same book should be removed from books set as well as from publishers set
    // so when adding a book then same book should be added from books set as well as from publishers set
    public void removePublisher(Publisher publisher){
        this.publishers.remove(publisher);
        publisher.getBooks().remove((publisher));
    }

    public  void addPublisher(Publisher publisher){
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }

    public  void removeAuthor(Author author){
        this.authors.remove(author);
        author.getBooks().remove(author);
    }

    public  void  addAuthor(Author author){
        this.authors.add(author);                    // Adds the author to the set of authors associated with this book
        //Lombok has automatically generated the getBooks() for set of books
        author.getBooks().add(this);// Adds this book to the set of books associated with the author
                                    //This adds the current Book instance (this) to the set of books associated with the author.
    }

    public  void removeCategory(Category category){
        this.categories.remove(category);
        category.getBooks().remove(category);
    }

    public  void  addCategory(Category category){
        this.categories.add(category);
        category.getBooks().add(this);
    }


}


