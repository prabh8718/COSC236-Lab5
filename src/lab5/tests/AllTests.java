package lab5.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({TestAddRemoveBooks.class, 
				TestAddRemoveMembers.class,
				TestFindClassString.class,
				TestBorrowBooks.class,
				TestEBook.class,
				TestAudioBook.class,
				TestNotAvailableBook.class,
				TestBorrowingService.class,
				TestSingleton.class,
				TestMembersBorrowingService.class,
				TestRemoveMemberWithBooks.class,
				TestBookFactory.class,
				TestController.class})
public class AllTests {
    
}

