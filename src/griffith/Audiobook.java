// Kisandu Dinusara Karunaratne
// 3142847

package griffith;

public class Audiobook extends Book {
	
	// attributes for the audio book class
	private String narrator;
	private String audioLength;
	private double size;
	
	// constructor for the audio book class
	public Audiobook(String title, String author, String narrator, String audioLength, double size) {
		super(title, author); // this calls the superclass (book)'s constructor to set the title and the author
		this.narrator = narrator;
		this.audioLength = audioLength;
		this.size = size;
	}
	
	// getter for the narrator, which returns the narrator of the book
	public String getNarrator() {
		return narrator;
	}
	
	// setter for the narrator, which sets the narrator of the book
	public void setNarrator(String narrator) {
		this.narrator = narrator;
	}
	
	// getter for the audio length, which returns the book's audio length
	public String getAudiolength() {
		return audioLength;
	}
	
	// setter for the audio length, which sets the book's audio length
	public void setAudiolength(String audioLength) {
		this.audioLength = audioLength;
	}
	
	// getter for the size, which returns the size of the audio book
	public double getSize() {
		return size;
	}
	
	// setter for the size, which sets the size of the audio book
	public void setSize(double size) {
		this.size = size;
	}
	
	// this provides detailed information about the audio book, which also includes the toString() information from the superclass
	@Override
	public String toString() {
		return super.toString() + ", " + "Narrator: " + narrator + ", Audio Length: " + audioLength + ", Size: " + size + "MB";
	}

}
