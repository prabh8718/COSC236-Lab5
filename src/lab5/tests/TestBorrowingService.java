package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Book;
import lab5.BorrowingBookResult;
import lab5.BorrowingService;
import lab5.Member;
import lab5.PaperBook;


class TestBorrowingService {
    private BorrowingService service;
    private Member alice;
    private Member bob;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;

    @BeforeEach
    void setUp() {
        service = BorrowingService.getInstance();
        alice = new Member("Alice",BorrowingService.getInstance());
        bob = new Member("Bob",BorrowingService.getInstance());
        book1 = new PaperBook("Dune");
        book2 = new PaperBook("1984");
        book3 = new PaperBook("The Hobbit");
        book4 = new PaperBook("Foundation");
    }

    @Test
    void testBorrowAndReturnSuccess() {
        BorrowingBookResult borrowRes = service.borrowBook(alice, book1);
        assertTrue(borrowRes.isSuccess());
        assertFalse(book1.getIsAvailable());

        BorrowingBookResult returnRes = service.returnBook(alice, book1);
        assertTrue(returnRes.isSuccess());
        assertTrue(book1.getIsAvailable());
    }

    @Test
    void testBorrowAlreadyBorrowedBySameMember() {
        service.borrowBook(alice, book1);
        BorrowingBookResult res = service.borrowBook(alice, book1);
        assertFalse(res.isSuccess());
    }

    @Test
    void testBorrowUnavailableBook() {
        service.borrowBook(alice, book1);
        BorrowingBookResult res = service.borrowBook(bob, book1);
        assertFalse(res.isSuccess());
    }

    @Test
    void testBorrowExceedsLimit() {
        assertTrue(service.borrowBook(alice, book1).isSuccess());
        assertTrue(service.borrowBook(alice, book2).isSuccess());
        assertTrue(service.borrowBook(alice, book3).isSuccess());

        BorrowingBookResult fourthRes = service.borrowBook(alice, book4);
        assertFalse(fourthRes.isSuccess());
    }

    @Test
    void testReturnAlreadyReturnedBook() {
        BorrowingBookResult res = service.returnBook(alice, book1);
        assertFalse(res.isSuccess());
    }

    @Test
    void testReturnBookNotBorrowedByMember() {
        service.borrowBook(alice, book1);
        BorrowingBookResult res = service.returnBook(bob, book1);
        assertFalse(res.isSuccess());
    }
}