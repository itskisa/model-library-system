// Kisandu Dinusara Karunaratne
// 3142847

package griffith;

public class PrintedBook extends Book {

	// attributes for the printedbook class
	private int pageLength;
	private String cover;
	
	// constructor for the printed book class
	public PrintedBook(String title, String author, int pageLength, String cover) {
		super(title, author); // this calls the superclass (book)'s constructor to set the title and the author
		this.pageLength = pageLength;
		this.cover = cover;
	}
	
	// getter for the page length
	public int getPageLength() {
		return pageLength;
	}
	
	// setter for the page length
	public void setPageLength(int pageLength) {
		this.pageLength = pageLength;
	}
	
	// getter for the cover
	public String getCover() {
		return cover;
	}
	
	// setter for the cover
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	// this provides a detailed description of the printed books, including the toString() method from the superclass
	@Override
	public String toString() {
		return super.toString() + ", Page Length: " + pageLength + ", Cover: " + cover;
	}
}
