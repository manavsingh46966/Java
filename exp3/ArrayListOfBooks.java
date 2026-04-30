import java.util.ArrayList;

public class ArrayListOfBooks {

    public static void main(String[] args) {

        ArrayList<Book> bookList = new ArrayList<>();

        try {
            bookList.add(new Book("Java Basics", "John Smith", "Education", 450));
            System.out.println("Book added successfully.");

            bookList.add(new Book("The Alchemist", "Paulo Coelho", "Fiction", 350));
            System.out.println("Book added successfully.");

            bookList.add(new Book("Harry Potter", "J.K Rowling", "Fiction", 500));
            System.out.println("Book added successfully.");

            bookList.add(new Book("Invalid Book", "Unknown", "Fiction", -200));

        } catch (InvalidPriceException e) {
            System.out.println("InvalidPriceException: " + e.getMessage());
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("%-15s %-15s %-12s %s\n", "Title", "Author", "Genre", "Price");
        System.out.println("--------------------------------------------------");

        double total = 0;

        for (Book b : bookList) {
            b.display();
            total += b.getPrice();
        }

        System.out.println("--------------------------------------------------");

        double average = total / bookList.size();
        System.out.printf("\nAverage Price of Books: %.2f\n", average);

        System.out.println("\nBooks in Fiction Genre:");
        bookList.forEach(b -> {
            if (b.getGenre().equalsIgnoreCase("Fiction")) {
                System.out.println(b.getTitle() + " - " + b.getPrice());
            }
        });
    }
}
