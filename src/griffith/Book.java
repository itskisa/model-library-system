// Kisandu Dinusara Karunaratne
// 3142847

package griffith;

public abstract class Book {
	
	// attributes for the book class
	private String title;
	private String author;
	private boolean borrowed;
	
	// constructor for the book class
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.borrowed = false; // this sets the default value (new books will be added as "available")
	}
	
	// this marks the book as borrowed
	public void borrow() {
		this.borrowed = true;
	}
	
	// this marks the book as returned
	public void returnBook() {
		this.borrowed = false;
	}
	
	// getter for the title, which returns the title of the book to the user
	public String getTitle() {
		return title;
	}
	
	// getter for the author, which returns the author of the book to the user
	public String getAuthor() {
		return author;
	}
	
	// getter for the borrowing system. this returns true if the book is borrowed, and false if it isn't
	public boolean getBorrowed() {
		return borrowed;
	}
	
	// this displays the information about the books stored to the user
	@Override
	public String toString() {
		return "Title: " + title + ", Author/s: " + author + ", Borrowed: " + borrowed;
	}
	

}
