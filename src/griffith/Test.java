// Kisandu Dinusara Karunaratne
// 3142847

package griffith;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// creates a new library instance
		Library library = new Library("Griffith College Library", "Dublin 8");
		
		// adds 3 printed books to the library catalogue (book title, author, page length, cover) 
		library.addBook(new PrintedBook("Ikigai", "Hector Garcia and Francesc Miralles", 194, "Hardback"));
		library.addBook(new PrintedBook("Babel", "R.F. Kuang", 544, "Hardback"));
		library.addBook(new PrintedBook("You Like It Darker", "Stephen King", 512, "Paperback"));
		
		// adds 3 ebooks to the library catalogue (book title, author, format, format, page length, size)
		library.addBook(new EBook("Harry Potter and the Sorcerer’s Stone", "J.K. Rowling", "ePub", 309, 2.1));
		library.addBook(new EBook("The Hunger Games", "Suzanne Collins", "PDF", 374, 2.4));
		library.addBook(new EBook("The Fault in Our Stars", "John Green", "PDF", 313, 1.9));
		
		// adds 3 audiobooks to the library catalogue (book title, book author, narrator, audio length, size)
		library.addBook(new Audiobook("The Great Gatsby", "F. Scott Fitzgerald", "Jake Gyllenhaal", "4 hrs and 52 mins", 135));
		library.addBook(new Audiobook("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Jim Dale", "9 hrs and 3 mins", 255));
		library.addBook(new Audiobook("The Hobbit", "J.R.R. Tolkien", "Andy Serkis", "10 hrs and 25 mins", 290));
		
		System.out.println("Welcome to the " + library.getName());	
		
		boolean running = true;
		
		// the main menu loop
		while(running) {
			
			// calls on the displayMenu() method, which shows the available options in the menu
			displayMenu();
			int menuChoice = 0;
			
			// try-catch loop is used to check for invalid inputs
			try {
				menuChoice = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("Invalid input. Please enter a number.");
				System.out.println();
				continue;
			}
			
			// this handles the user's choices using a switch
			switch (menuChoice) {
				case 1:
					showAvailableBooks(library);
					break;
				case 2: 
					showPrintedBooks(library);
					break;
				case 3:
					showEBooks(library);
					break;
				case 4: 
					showAudiobooks(library);
					break;
				case 5: 
					borrowBook(library, scan);
					break;
				case 6:
					borrowBookByType(library, scan);
					break;
				case 7:
					returnBook(library, scan);
					break;
				case 8: 
					running = false;
					System.out.println("\nThank you for using the " + library.getName());
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					System.out.println();
			}
		}
		
		// closes the scanner
		scan.close();
	}
	
	
	// displays the main menu to the user
	public static void displayMenu() {
		System.out.println("\nLibrary Menu");
		System.out.println();
		System.out.println("1. See all Available Books");
		System.out.println("2. See all Printed Books only");
		System.out.println("3. See all Ebooks only");
		System.out.println("4. See all Audio Books only");
		System.out.println("5. Borrow a book");
		System.out.println("6. Borrow a book by type");
		System.out.println("7. Return a book");
		System.out.println("8. Exit");
		System.out.println();
		System.out.print("Enter an option (1-8): ");
	}
	
	
	
	// shows what books are available in the library system
	private static void showAvailableBooks(Library library) {
		
		// 
		ArrayList<Book> availableBooks = library.getAvailableBooks();
		
		if(availableBooks.isEmpty()) {
			System.out.println("\nNo books are available at the moment.");
			System.out.println();
			
		} else {
			System.out.println("\nAvailable Books: ");
			System.out.println();
			
			// this loops through all the available books and prints them out
			for (int i = 0; i < availableBooks.size(); i++) {
				System.out.println((i + 1) + ". " + availableBooks.get(i));
			}
		}
	}
	
	// shows all the printed books
	private static void showPrintedBooks(Library library) {
		ArrayList<PrintedBook> printedBooks = library.getPrintedBooks();
		
		if (printedBooks.isEmpty()) {
			System.out.println("\nNo printed books are available at the momemt");
			System.out.println();
			
		} else {
			System.out.println("\nAvailable Printed Books: ");
			System.out.println();
			
			for (int i = 0; i < printedBooks.size(); i++) {
				System.out.println((i + 1) + ". " + printedBooks.get(i));
			}
		}	
		
		System.out.println();
	}
	
	// shows all the ebooks
	private static void showEBooks(Library library) {
		ArrayList<EBook> ebooks = library.getEBooks();
		
		if(ebooks.isEmpty()) {
			System.out.println("\nNo E-Books are available at the moment");
			System.out.println();
			
		} else {
			System.out.println("\nAvailable E-Books: ");
			System.out.println();
			
			for (int i = 0; i < ebooks.size(); i++) {
				System.out.println((i + 1) + ". " + ebooks.get(i));
			}
		}
		
		System.out.println();
	}
	
	// shows all the audiobooks
	private static void showAudiobooks(Library library) {
		ArrayList<Audiobook> audiobooks = library.getAudioBooks();
		
		if(audiobooks.isEmpty()) {
			System.out.println("\nNo Audiobooks are available at the moment");
			System.out.println();
			
		} else {
			System.out.println("\nAvailable Audio Books: ");
			
			for (int i = 0; i < audiobooks.size(); i++) {
				System.out.println((i + 1) + ". " + audiobooks.get(i));
			}
		}
		
		System.out.println();
	}
	
	// this allows the user to borrow a book by entering its title and author
	private static void borrowBook(Library library, Scanner scan) {
		System.out.print("\nEnter book title: ");
		String title = scan.nextLine();
		
		System.out.print("Enter book author: ");
		String author = scan.nextLine();
		
		// if the title or the author's name is empty, it will output the following
		if (title.isEmpty() || author.isEmpty()) {
			System.out.println("\nError: Both title and author are required to borrow a book.");
			return;
		}
		
		// this calls the library borrow method
		library.borrow(title, author);
	}
	
	
	// this allows the user to borrow a book based on the type of book first (printed, ebook or audiobook)
	private static void borrowBookByType(Library library, Scanner scan) {
		System.out.println("\nSelect book type: ");
		System.out.println("1. Printed Book");
		System.out.println("2. E-Book");
		System.out.println("3. Audio Book");
		
		System.out.print("\nEnter your choice: ");
		
		int typeChoice = 0;
		
		try {
			typeChoice = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			scan.nextLine();
			System.out.println("Invalid input.");
			return;
		}
		
		String type = "";
		
		// determines the book type based on the user's input
		switch (typeChoice) {
			case 1:
				type = "PrintedBook";
				break;
			case 2:
				type = "EBook";
				break;
			case 3:
				type = "Audiobook";
				break;
			default:
				System.out.println("Invalid type selection.");
				return;
		}
		
		// this allows the user to enter the book details
		System.out.print("\nEnter book title: ");
		String title = scan.nextLine().trim();
		
		System.out.print("Enter book author: ");
		String author = scan.nextLine().trim();
		
		// if the title or the author's name is empty, it will output the following
		if (title.isEmpty() || author.isEmpty()) {
			System.out.println("\nError: Both title and author are required to borrow a book.");
			return;
		}
		
		// this calls the borrow method from the library class 
		library.borrow(title, author, type);
	}
	
	
	// this allows a user to return a book that's borrowed
	private static void returnBook(Library library, Scanner scan) {
		System.out.print("\nEnter book title: ");
		String title = scan.nextLine().trim();
		
		System.out.print("Enter book author: ");
		String author = scan.nextLine().trim();
		
		// this validates the user's input
		if (title.isEmpty() || author.isEmpty()) {
			System.out.println("\nError: Both title and author are required to return a book.");
			return;
		}
		
		Book bookToReturn = null;
		
		// this searches the library catalogue for the borrowed book
		for (Book book : library.getCatalogue()) {
			if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author) && book.getBorrowed()) {
				bookToReturn = book;
				break;
			}
		}
		
		// this returns the book if it's found
		if (bookToReturn != null) {
			library.returnBook(bookToReturn);
			System.out.println("\nBook has been returned successfully: " + title + " by " + author);
		} else {
			System.out.println("\nError: Book not found or not currently borrowed: " + title + " by " + author);
		}
	}
}
