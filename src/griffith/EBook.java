// Kisandu Dinusara Karunaratne
// 3142847

package griffith;

public class EBook extends Book {
	
	// attributes to the e-book
	private String format;
	private int pageLength;
	private double size; 
	
	// constructor for the e-book class
	public EBook(String title, String author, String format, int pageLength, double size) {
		super(title, author); // this calls the superclass (book)'s constructor, which sets the title and the author of the book
		this.format = format;
		this.pageLength = pageLength;
		this.size = size;
	}
	
	// getter for the format
	public String getFormat() {
		return format;
	}
	
	// setter for the format
	public void setFormat(String format) {
		this.format = format;
	}
	
	// getter for the page length of the e-book
	public int getPageLength() {
		return pageLength;
	}
	
	// setter for the page length
	public void setPageLength(int pageLength) {
		this.pageLength = pageLength;
	}

	// getter for the size
	public double getSize() {
		return size;
	}
	
	// setter for the size
	public void setSize(double size) {
		this.size = size;
	}
	
	// this provides detailed information about the e-book, which also includes the toString() information from the superclass
	@Override
	public String toString() {
		return super.toString() + ", " + "Format: " + format + ", Page Length: " + pageLength + ", Size: " + size + "MB";
	}
	
}
