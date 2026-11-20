package lab5;

public class BorrowingService implements BorrowingServiceAPI {
    private static BorrowingService instance;
    private int borrowingLimit;

    private BorrowingService() {
        borrowingLimit = 3;
    }

    public static synchronized BorrowingService getInstance() {
        if (instance == null) {
            instance = new BorrowingService();
        }
        return instance;
    }

   

    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {
        if (member == null || book == null) {
            return new BorrowingBookResult(false, "Member or book cannot be null.");
        }
        if (member.getBorrowedBooks().contains(book)) {
            return new BorrowingBookResult(false, "The book is already borrowed by " + member.getName() + ".");
        }
        if (!book.getIsAvailable()) {
            return new BorrowingBookResult(false, "The book is currently borrowed by another member and is unavailable.");
        }
        if (member.getBorrowedBooks().size() >= borrowingLimit) {
            return new BorrowingBookResult(false, member.getName() + " has exceeded the borrowing limit of " + borrowingLimit + " books.");
        }

        member.getBorrowedBooks().add(book);
        book.setIsAvailable(false);
        return new BorrowingBookResult(true, "Successfully borrowed: " + book.getTitle());
    }

    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {
        if (member == null || book == null) {
            return new BorrowingBookResult(false, "Member or book cannot be null.");
        }
        if (book.getIsAvailable()) {
            return new BorrowingBookResult(false, "The book has already been returned.");
        }
        if (!member.getBorrowedBooks().contains(book)) {
            return new BorrowingBookResult(false, member.getName() + " has not borrowed this book.");
        }

        member.getBorrowedBooks().remove(book);
        book.setIsAvailable(true);
        return new BorrowingBookResult(true, "Successfully returned: " + book.getTitle());
    }
}