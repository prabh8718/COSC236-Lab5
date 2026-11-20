package lab5;


public class LibraryApp {

	 
	private static LibrarianController librarian =  new LibrarianController();
	
	
	private static void addMember(String name) {
		librarian.addMember(name);
	}	
	private static void addBook(String title) {
		librarian.addBook(title);
	}
	private static void borrowBook(String title, String name) {
		librarian.borrowBookByMember(title, name);
	}
	private static void returnBook(String title, String name) {
		librarian.returnBookByMember(title, name);
	}
		
	public static void main(String[] args) {
						 	
		System.out.println(" *** Library management system demo *** ");
		
	   
		addBook("Dune");
		
	
		addMember("Alice"); 			
		borrowBook("Dune", "Alice");  	
		returnBook("Dune", "Alice"); 		
		 
	    
		System.out.println("\n *** Adding books to the library:");
		librarian.addBook("Dune");
		librarian.addBook("1984");
		librarian.addBook("Moby Dick");
		
		
		System.out.println("\n *** Adding members to the library:");
		librarian.addMember("Alice");
		librarian.addMember("Bob");
		
		librarian.borrowBookByMember("Dune", "Alice");
		librarian.borrowBookByMember("1984", "Alice");
		librarian.borrowBookByMember("Moby Dick", "Bob");
		librarian.borrowBookByMember("Dune", "Bob"); 
		
		System.out.println("\n *** Books borrowed by Alice:");
		librarian.showMemberBooks("Alice");
		
		librarian.showMemberBooks("Bob");
		
		System.out.println("\n *** Book returned by Alice: Dune");
		librarian.returnBookByMember("Dune", "Alice");
		librarian.borrowBookByMember("Dune", "Bob"); 
		System.out.println("\n *** Books borrowed by Bob:");
		librarian.showMemberBooks("Bob");
	}
	
}
