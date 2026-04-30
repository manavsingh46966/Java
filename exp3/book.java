public class Book {

    private String title;
    private String author;
    private String genre;
    private double price;

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.genre = "Unknown";
        this.price = 0.0;
    }

    public Book(String title, String author, String genre, double price) throws InvalidPriceException {
        if (price < 0) {
            throw new InvalidPriceException("Price cannot be negative.");
        }

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.printf("%-15s %-15s %-12s %.2f\n", title, author, genre, price);
    }
}
