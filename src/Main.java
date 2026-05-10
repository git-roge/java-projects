import com.roge.lms.*;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("DMMMSU");
        Scanner scanner = new Scanner(System.in);
        //Add books
        library.addBook("Naruto", "Yukihiro", 1997);
        library.addBook("One Piece", "Kirishima", 1997);
        library.addBook("Black Clover", "Yushimitsu", 1997);
        library.addBook("Dragon Ball", "Kishima", 1997);

        //Add users
        library.addUser("Roge");
        library.addUser("Ivy");

        int choice = 0;
        while (choice != 9) {
            try {
                System.out.println("Actions: \n" +
                        "1. Add Book\n2. Add User\n3. Show book list\n4. Show Users\n5. Borrow book\n6. Select User\n7. Return book\n8. Show transactions\n9. Exit"
                );
                choice = scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e) {
                System.out.println("Invalid action");
                scanner.nextLine();
                continue;
            }
            //Add book
            if (choice == 1) {
                System.out.print("Book name: ");
                String newBookName = scanner.nextLine();
                System.out.print("Book author: ");
                String newBookAuthor = scanner.nextLine();
                System.out.print("Book year: ");
                int newBookYear = scanner.nextInt();
                scanner.nextLine();

                library.addBook(newBookName, newBookAuthor, newBookYear);
            }
            //Add user
            if (choice == 2) {
                System.out.print("User name: ");
                String newUserName = scanner.nextLine();

                library.addUser(newUserName);
            }
            //Show book list
            if (choice == 3) {
                for (Map.Entry<Integer, Book> entry : library.getBookList().entrySet()) {
                    System.out.printf("bookId: %d, bookName: '%s', bookAuthor: '%s', bookYear: %d, status: '%s'\n",
                            entry.getKey(), entry.getValue().getTitle(), entry.getValue().getAuthor(), entry.getValue().getYear(), entry.getValue().getStatus());
                }
            }
            //Show users
            if (choice == 4) {
                for (Map.Entry<Integer, User> entry : library.getUserList().entrySet()) {
                    System.out.printf("userId: %d, userName: '%s'\n",
                            entry.getKey(), entry.getValue().getUserName()
                    );
                }
            }

            //borrow book
            if (choice == 5) {
                int borrowBookId, borrowUserId;
                for (Book book : library.getAvailableBooks()){
                    System.out.println(book.getBookId() + ". " + book.getTitle());
                }

                while (true) {
                    System.out.print("Enter userId: ");
                    borrowUserId = scanner.nextInt();
                    scanner.nextLine();

                    if (!library.validateUser(borrowUserId)) {
                        System.out.println("User doesn't exist");
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("Enter bookId: ");
                    borrowBookId = scanner.nextInt();
                    scanner.nextLine();

                    if (!library.validateBook(borrowBookId)) {
                        System.out.println("Book doesn't exist.");
                    } else {
                        break;
                    }
                }

                library.borrowBook(borrowBookId, borrowUserId);
            }

            if (choice == 6) {
                int userId;

                while (true) {
                    System.out.print("Enter user Id: ");
                    userId = scanner.nextInt();
                    scanner.nextLine();

                    if (!library.validateUser(userId)) {
                        System.out.println("User doesn't exist");
                    } else {
                        break;
                    }
                }

                User user = library.getUserList().get(userId);

                if (user == null) {
                    System.out.println("User doesn't exist.");
                    continue;
                }

                System.out.println(user.toString());
                for (Book book : user.getBorrowedBooks()) {
                    System.out.println(book.getBookId() + ". " + book.getTitle());
                }
            }
            if (choice == 7) {
                int returnBookId;
                int returnUserId;

                while (true) {
                    System.out.print("Enter userId: ");
                    returnUserId = scanner.nextInt();
                    scanner.nextLine();

                    if (!library.validateUser(returnUserId)) {
                        System.out.println("User doesn't exist");
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("Enter bookId: ");
                    returnBookId = scanner.nextInt();
                    scanner.nextLine();

                    if (!library.validateBook(returnBookId)) {
                        System.out.println("Book doesn't exist.");
                    } else {
                        break;
                    }
                }

                library.returnBook(returnBookId, returnUserId);
            }
            if (choice == 8) {
                for (Transaction transaction : library.getTransactionList()) {
                    System.out.println(transaction.toString());
                }
            }else {
                System.out.println("Invalid input");
            }
        }

            System.out.println("Library exit");
        }
}