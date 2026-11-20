package lab5;

public class LibrarianController {
	
	Library library;
	
	public LibrarianController( ) {
		this.library = new Library(); 
	}
	public Library getLibrary() {
		return this.library;
	}
	public void showBooks() {
		library.showBooks();
	}
	public void showMembers() {
		library.showMembers();
	}
	public void addBook(String title) {
		library.addBook(new PaperBook(title));  
	}
	public void addMember(String name) {
		library.addMember(new Member(name)); 
	}
	public void removeBook(String title) {
		library.removeBook(title); 
	}
	public void removeMember(String name) {
		library.removeMember(name);
	}
	public void addAudioBook(String title) {
	    library.addBook(new AudioBook(title));
	}
	public void showMember(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			System.out.println(member);
		else 
			System.out.println("Member " + name + " not found.");
	}
	public void showBook(String title) {
		Book book = library.findBookByTitle(title);
		if (book != null)
			System.out.println(book);
		else 
			System.out.println("Book " + title + " not found.");
	}
	public void showMemberBooks(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			member.listBorrowedBooks();
		else 
			System.out.println("Member " + name + " not found.");
	}
	
	public void borrowBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); 
		Book book = library.findBookByTitle(title);  
		if (book != null && member != null)
			member.borrowBook(book); 
		else 	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
	
	public void returnBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); 
		Book book = library.findBookByTitle(title); 
		if (book != null && member != null)
			member.returnBook(book); 
		else  	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
}
