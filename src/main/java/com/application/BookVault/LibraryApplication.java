package com.application.BookVault;

import com.application.BookVault.service.BookService;
import com.application.BookVault.entity.Author;
import com.application.BookVault.entity.Book;
import com.application.BookVault.entity.Category;
import com.application.BookVault.entity.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner initailCreate(BookService bookService){
		return args -> {
			Book book1 = new Book("978-0743269513", "To Kill a Mockingbird", "A classic of modern American literature");
			Author author1 = new Author("Harper Lee", "Pulitzer Prize-winning American novelist");
			Category category1 = new Category("Classic Literature");
			Publisher publisher1 = new Publisher("Harper Perennial");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("978-0547928227", "The Hobbit", "A fantasy novel and children's book by J.R.R. Tolkien");
			Author author2 = new Author("J.R.R. Tolkien", "English writer, poet, philologist, and academic");
			Category category2 = new Category("Fantasy");
			Publisher publisher2 = new Publisher("Houghton Mifflin Harcourt");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			Book book3 = new Book("978-8494", "Think and grow rivh", "self help book");
			Author author3 = new Author("Neploeon hill", "king");
			Category category3 = new Category("self help");
			Publisher publisher3 = new Publisher("Penguin Books");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);

			Book book4 = new Book("978-0143105947", "Pride and Prejudice", "Jane Austen's witty comedy of manners");
			Author author4 = new Author("Jane Austen", "English novelist known for her romance novels");
			Category category4 = new Category("Romance");
			Publisher publisher4 = new Publisher("Penguin Classics");
			book4.addAuthor(author4);
			book4.addCategory(category4);
			book4.addPublisher(publisher4);
			bookService.createBook(book4);

			Book book5 = new Book("978-0553380163", "A Brief History of Time", "From the Big Bang to Black Holes");
			Author author5 = new Author("Stephen Hawking", "Theoretical physicist and cosmologist");
			Category category5 = new Category("Science");
			Publisher publisher5 = new Publisher("Bantam");
			book5.addAuthor(author5);
			book5.addCategory(category5);
			book5.addPublisher(publisher5);
			bookService.createBook(book5);

			Book book6 = new Book("978-0375712111", "Mastering the Art of French Cooking", "Detailed instructions and recipes");
			Author author6 = new Author("Julia Child", "American chef, author, and television personality");
			Category category6 = new Category("Cookbooks");
			Publisher publisher6 = new Publisher("Knopf");
			book6.addAuthor(author6);
			book6.addCategory(category6);
			book6.addPublisher(publisher6);
			bookService.createBook(book6);
		};
	}
}
