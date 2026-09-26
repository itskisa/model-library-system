// Kisandu Dinusara Karunaratne
// 3142847

package griffith;

import java.util.ArrayList;

public class Library implements Catalogue {
	
	// attributes for the library
	private String name;
	private String location;
	private ArrayList<Book> catalogue;
	
	// constructor for the library
	public Library(String name, String location) {
		this.name = name;
		this.location = location;
		this.catalogue = new ArrayList<>(); // this creates an empty catalogue to store the books
	}
	
	// getter for the library name
	public String getName() {
		return name;
	}
	
	// getter for the library location
	public String getLocation() {
		return location;
	}
	
	// getter for the library's catalogue
	public ArrayList<Book> getCatalogue(){
		return catalogue;
	}

	// this adds a new book to the library's catalogue
	@Override
	public void addBook(Book book) {
		catalogue.add(book);
	}

	// returns all the books that have not been borrowed yet. 
	@Override
	public ArrayList<Book> getAvailableBooks() {
		ArrayList<Book> availableBooks = new ArrayList<>();
		
		for(Book book : catalogue) {
			if (!book.getBorrowed()) {
				availableBooks.add(book);
			}
		}
		
		return availableBooks;
	}
	
	// this returns all the books that are printed in the catalogue
	@Override
	public ArrayList<PrintedBook> getPrintedBooks() {
		ArrayList<PrintedBook> printedBooks = new ArrayList<>();
		
		for(Book book : catalogue) {
			if (book instanceof PrintedBook) {
				printedBooks.add((PrintedBook) book);
			}
		}
		
		return printedBooks;
	}

	// this returns all the e-books in the catalogue
	@Override
	public ArrayList<EBook> getEBooks() {
		ArrayList<EBook> ebooks = new ArrayList<>();
		
		for (Book book : catalogue) {
			if (book instanceof EBook) {
				ebooks.add((EBook) book);
			}
		}
		
		return ebooks;
	}

	// this returns all the audio books in the catalogue
	@Override
	public ArrayList<Audiobook> getAudioBooks() {
		ArrayList<Audiobook> audiobooks = new ArrayList<>();
		
		for (Book book : catalogue) {
			if (book instanceof Audiobook) {
				audiobooks.add((Audiobook) book);
			}
		}
		
		return audiobooks;
	}

	// this allows the user to borrow a book by the title and the author. it checks if the book exists and if it's not already borrowed
	@Override
	public Book borrow(String title, String author) {
		
		// this is used to track whether the book exists but is currently borrowed
		Book foundBook = null;
		
		// this loops through all the books in the catalogue, and compares both the title and the author
		for (Book book : catalogue) {
			if(book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
				
				// if the book is not borrowed, it will be marked as borrowed
				if(!book.getBorrowed()) {
					book.borrow();
					System.out.println("\nBook borrowed successfully: " + book.getTitle() + " by " + book.getAuthor());
					return book;
				}
				
				// if the book exists but it's already borrowed, then store it in foundBook to reference later
				foundBook = book;
			}
		}
		
		// after checking all the books, this will determine the reason why the user could not borrow the book
		if (foundBook != null) {
			System.out.println("\nNo copies available for: " + title + " by " + author);
		} else {
			System.out.println("\nBook not found: " + title + " by " + author);
		}
		
		return null;
	}

	@Override
	public Book borrow(String title, String author, String type) {
		
		// this is used to track whether the book exists but is currently borrowed
		Book foundBook = null;
		
		for (Book book : catalogue) {
			
			// this checks if the book matches the requested type and the details 
			boolean isCorrectType = ((type.equalsIgnoreCase("PrintedBook") && book instanceof PrintedBook) || (type.equalsIgnoreCase("EBook") && book instanceof EBook) || (type.equalsIgnoreCase("Audiobook") && book instanceof Audiobook));
			
			// this checks if both the title and the author match as well
			if (isCorrectType && book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
				
				// if the book is not borrowed, this will mark it as borrowed and return it
				if(!book.getBorrowed()) {
					book.borrow();
					System.out.println("\nBook borrowed successfully: " + book.getTitle() + " (" + type + ")");
					return book;
				}
				
				// this indicates that the book exists but is currently unavailable
				foundBook = book;
			}
		}
			
		if (foundBook != null) {
			System.out.println("\nNo copies available for: " + title + " by " + author + " (" + type + ")");
		} else {
			System.out.println("\nBook not found: " + title + " by " + author + " (" + type + ")");
		}
		
		// returns null if the borrowing failed
		return null;
	}
	

	// this allows the user to return a borrowed book. this checks if the book belongs in the library before it's marked as returned
	@Override
	public void returnBook(Book book) {
		if (book != null && catalogue.contains(book)) {
			// marks the book as returned
			book.returnBook();
		} else {
			System.out.println("Book does not belong in this library");
		}
		
	}
	
	// this provides a summary of the library object
	@Override
	public String toString() {
		return "Library: " + name + ", Location: " + location + ", Total Size: " + catalogue.size();
	}

}
