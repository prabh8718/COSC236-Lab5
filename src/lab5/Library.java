package lab5;

import java.util.ArrayList;
import java.util.Iterator;


public class Library {
	 
	private ArrayList<Book> catalog = new ArrayList<>(); 
	private ArrayList<Member> members = new ArrayList<>(); 
	
	public Member findMemberByName(String name) {
		 for (Member member : members) {
	           if (member.getName().equals(name)) {
	               return member; 
	           }
	       }
	       return null;
	}
	public Book findBookByTitle (String title) {
		 for (Book book : catalog) {
	           if (book.getTitle().equals(title)) {
	               return book; 
	           }
	       }
	       return null; 
	}
	public void addMember(Member member) {
		members.add(member);
	}
	public void addBook(Book book) {
		catalog.add(book);
	}
	public void removeMember(String name) {
		Member member = findMemberByName(name);
		removeMember(member);
	}
	public void removeMember(Member member) {
		if(member != null) {
			member.returnAllBooks(); 
			members.remove(member);
		}
	}
	public void removeBook(String title) {
		Book book = findBookByTitle(title);
		removeBook(book);
	}
	public void removeBook(Book book) {
		if (book != null)
			catalog.remove(book); 
	}
	public void showMembers() {
		Iterator<Member> memberIterator = members.iterator();
	    while(memberIterator.hasNext()) {
		   	 Member member = memberIterator.next();
		   	 System.out.println(member);
	    }
	}
	public void showBooks() {
		Iterator<Book> bookIterator = catalog.iterator();
	    while(bookIterator.hasNext()) {
		   	 Book book = bookIterator.next();
		   	 System.out.println(book); 
	    }
	}
	public int booksCount() {
		return catalog.size();
	}
	public int membersCount() {
		return members.size();
	}
}
