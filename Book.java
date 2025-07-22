public class Book {
    // Protected variables (so child classes can access them)
    protected String title;
    protected String author;
    protected int pages;
    protected boolean isAvailable;

    // Constructor
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true; // Set isAvailable to true by default
    }

    // Basic methods
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("\"" + title + "\" has been borrowed.");
        } else {
            System.out.println("\"" + title + "\" is not available.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("\"" + title + "\" has been returned");
        } else {
            System.out.println("\"" + title + "\" was already available.");
        }
    }

    public void displayInfo() {
        System.out.println("\n--- Book Information ---");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters (optional, but good practice for completeness if state can be changed externally)
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public static void main(String[] args) {
        Book book = new Book("Clean Code", "Robert C. Martin", 464);

        book.displayInfo();      // Show info
        book.borrowBook();       // Borrow the book
        book.borrowBook();       // Try borrowing again
        book.returnBook();       // Return the book
        book.returnBook();       // Try returning again
    }

}

