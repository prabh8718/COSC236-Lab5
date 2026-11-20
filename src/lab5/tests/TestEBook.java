package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.EBook;
import lab5.Library;
import lab5.Member;
import lab5.BorrowingService;

class TestEBook {

    private Library library;
    
    @BeforeEach
    void setUp() throws Exception {
        this.library = new Library();
    }

    @Test
    void testEBookPolymorphism() {
        EBook eBook = new EBook("Digital Fortress");
        Member member = new Member("Alan Turing",BorrowingService.getInstance());

        library.addBook(eBook);
        assertEquals(1, library.booksCount(), "Library should contain the EBook");

        member.borrowBook(eBook);
        assertEquals(1, member.borrowedBooksCount(), "Member should successfully borrow the EBook");
        assertFalse(eBook.getIsAvailable(), "EBook should now be marked as unavailable");

        member.returnBook(eBook);
        assertTrue(eBook.getIsAvailable(), "EBook should be available again after return");
    }
}