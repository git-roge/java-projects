import com.roge.lms.Book;
import com.roge.lms.Library;
import com.roge.lms.Transaction;
import com.roge.lms.User;

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

        while (choice != 7){
            System.out.println("Actions: \n" +
                    "1. Add Book\n2. Add User\n3. Show book list\n4. Show Users\n5. Borrow book\n6. Select User\n7. Exit"
            );
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1){
                System.out.print("Book name: ");
                String newBookName = scanner.nextLine();
                System.out.print("Book author: ");
                String newBookAuthor = scanner.nextLine();
                System.out.print("Book year: ");
                int newBookYear = scanner.nextInt();
                scanner.nextLine();

                library.addBook(newBookName, newBookAuthor, newBookYear);
            }

            if(choice == 2){
                System.out.print("User name: ");
                String newUserName = scanner.nextLine();

                library.addUser(newUserName);
            }

            if(choice == 3){
                for (Map.Entry<Integer, Book> entry : library.getBookList().entrySet()){
                    System.out.printf("bookId: %d, bookName: '%s', bookAuthor: '%s', bookYear: %d, status: '%s'\n",
                            entry.getKey(), entry.getValue().getTitle(), entry.getValue().getAuthor(), entry.getValue().getYear(), entry.getValue().getStatus());
                }
            }

            if(choice == 4){
                for (Map.Entry<Integer, User> entry : library.getUserList().entrySet()){
                    System.out.printf("userId: %d, userName: '%s'\n",
                            entry.getKey(), entry.getValue().getUserName()
                            );
                }
            }

            if(choice == 5){
                System.out.print("Book Id: ");
                int bookId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("User Id: ");
                int userId = scanner.nextInt();
                scanner.nextLine();

                library.borrowBook(bookId, userId);
            }

            if(choice == 6){
                System.out.print("Enter User id: ");
                int userId = scanner.nextInt();
                scanner.nextLine();

                for(Transaction transaction : library.getTransactionList()){
                    if(transaction.getUserId() == 1){
                        System.out.println(library.getBookList().get(transaction.getBookId()).getTitle());
                    }
                }
            }
        }

        System.out.println("Library exit");
    }
}