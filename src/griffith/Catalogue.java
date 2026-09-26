// Kisandu Dinusara Karunaratne
// 3142847

package griffith;

import java.util.ArrayList;

// the interface ensures that all the implementations from the catalogue are following a consistent structure
public interface Catalogue {

	public void addBook(Book book);

	public ArrayList<Book> getAvailableBooks();

	public ArrayList<PrintedBook> getPrintedBooks();
	
	public ArrayList<EBook> getEBooks();
	
	public ArrayList<Audiobook> getAudioBooks();
	
	public Book borrow(String title, String author);
	
	public Book borrow(String title, String author, String type);
	
	public void returnBook(Book book);
}
