import com.roge.lms.Book;
import com.roge.lms.Library;
import com.roge.lms.User;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("DMMMSU");

        library.addBook("Naruto", "Yukihiro", 1997);
        library.addBook("One Piece", "Kirishima", 1997);
        library.addBook("Black Clover", "Yushimitsu", 1997);
        library.addBook("Dragon Ball", "Kishima", 1997);

        User users = new User();
        users.createUser("Roge");
        users.createUser("Ivy");

        for(Map.Entry<Integer, String> entry : users.getUsersList().entrySet()){
            System.out.println("userId: " + entry.getKey() + ", userName: " + entry.getValue());
        }

        for(Book book : library.getBookList().values()){
            System.out.println(book.getTitle());
        }

        library.removeBook(1);
        library.removeBook(3);

        for(Book book : library.getBookList().values()){
            System.out.println(book.toString());
        }
    }
}