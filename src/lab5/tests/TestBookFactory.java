package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import lab5.AudioBook;
import lab5.AudioBookFactory;
import lab5.Book;
import lab5.BookFactory;
import lab5.EBook;
import lab5.EBookFactory;
import lab5.PaperBook;
import lab5.PaperBookFactory;

class TestBookFactory {

    @Test
    void testPaperBookFactory() {
        BookFactory factory = new PaperBookFactory();
        Book book = factory.createBook("Dune");
        assertNotNull(book);
        assertTrue(book instanceof PaperBook);
        assertEquals("Dune", book.getTitle());
    }

    @Test
    void testEBookFactory() {
        BookFactory factory = new EBookFactory();
        Book book = factory.createBook("1984");
        assertNotNull(book);
        assertTrue(book instanceof EBook);
        assertEquals("1984", book.getTitle());
    }

    @Test
    void testAudioBookFactory() {
        BookFactory factory = new AudioBookFactory();
        Book book = factory.createBook("The Hobbit");
        assertNotNull(book);
        assertTrue(book instanceof AudioBook);
        assertEquals("The Hobbit", book.getTitle());
    }

    @Test
    void testUnsupportedBookTypeEdgeCase() {
        BookFactory unsupportedFactory = new BookFactory() {
            @Override
            public Book createBook(String title) {
                throw new UnsupportedOperationException("Unsupported book type");
            }
        };
        assertThrows(UnsupportedOperationException.class, () -> {
            unsupportedFactory.createBook("Unknown Book");
        });
    }
}