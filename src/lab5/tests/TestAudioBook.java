package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lab5.AudioBook;
import lab5.Book;
import lab5.Library;
import lab5.Member;

class TestAudioBook {

    @Test
    void testAudioBookBorrowAndReturn() {
        Book audioBook = new AudioBook("The Hobbit");
        Member member = new Member("Alice");

        assertTrue(audioBook.getIsAvailable());
        member.borrowBook(audioBook);
        assertFalse(audioBook.getIsAvailable());
        assertEquals(1, member.borrowedBooksCount());

        member.returnBook(audioBook);
        assertTrue(audioBook.getIsAvailable());
        assertEquals(0, member.borrowedBooksCount());
    }

    @Test
    void testAddAndRemoveAudioBook() {
        Library library = new Library();
        Book audioBook = new AudioBook("Dune Audio");

        library.addBook(audioBook);
        assertEquals(1, library.booksCount());

        library.removeBook(audioBook);
        assertEquals(0, library.booksCount());
    }
}