import com.roge.lms.Book;
import com.roge.lms.Library;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("DMMMSU");

        library.addBook("Naruto", "Yukihiro", 1997);
        library.addBook("One Piece", "Kirishima", 1997);

        for(Map.Entry<Integer, Book> entry : library.getBookList().entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", " + entry.getValue());
        }
    }
}