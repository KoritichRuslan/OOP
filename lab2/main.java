import java.util.ArrayList;
import java.util.List;

//template for working with different objects
abstract class LibraryItem {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void checkOutItem() {
        isCheckedOut = true;
    }

    public void returnItem() {
        isCheckedOut = false;
    }

    public abstract void displayInfo();
}

//subclass that extends behavior of parent class
class Book extends LibraryItem {
    private String isbn; //International Standard Book Number

    public Book(String title, String author, String isbn) {
        super(title, author);
        this.isbn = isbn;
    }
    
    public String getIsbn() {
        return isbn;
    }

    @Override
    public void displayInfo() {
        System.out.println("- Book Title: " + getTitle() + " || Author: " + getAuthor() + " || ISBN: " + isbn);
    }
}

class Magazine extends LibraryItem {
    private String issueDate;

    public Magazine(String title, String author, String issueDate) {
        super(title, author);
        this.issueDate = issueDate;
    }
    
    public String getIssueDate() {
        return issueDate;
    }

    @Override
    public void displayInfo() {
        System.out.println("- Magazine Title: " + getTitle() + " || Author: " + getAuthor() + " || Issue date: " + issueDate);
    }
}

class Audiobook extends LibraryItem {
    private double duration;

    public Audiobook(String title, String author, double duration) {
        super(title, author);
        this.duration = duration;
    }
    
    public double getDuration() {
        return duration;
    }

    @Override
    public void displayInfo() {
        System.out.println("- Audiobook Title: " + getTitle() + " || Author: " + getAuthor() + " || Duration (in hours): " + duration);
    }
}

class Library {
    private List<LibraryItem> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
        item.displayInfo();
    }

    private LibraryItem findItem(String title, String author, String extraInfo) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title) && item.getAuthor().equalsIgnoreCase(author)) {
                if (item instanceof Book && ((Book) item).getIsbn().equals(extraInfo)) {
                    return item;
                } else if (item instanceof Magazine && ((Magazine) item).getIssueDate().equals(extraInfo)) {
                    return item;
                } else if (item instanceof Audiobook && String.valueOf(((Audiobook) item).getDuration()).equals(extraInfo)) {
                    return item;
                }
            }
        }
        return null;
    }

    public void checkOutItem(String title, String author, String extraInfo) {
        LibraryItem item = findItem(title, author, extraInfo);
        if (item != null && !item.isCheckedOut()) {
            item.checkOutItem();
            System.out.println("Checked out: " + title + " by " + author + " (" + getItemType(item) + ")");
        } else {
            System.out.println("Already checked out, or incorrect details: " + title + " by " + author);
        }
    }

    public void returnItem(String title, String author, String extraInfo) {
        LibraryItem item = findItem(title, author, extraInfo);
        if (item != null && item.isCheckedOut()) {
            item.returnItem();
            System.out.println("Returned: " + title + " by " + author + " (" + getItemType(item) + ")");
        } else {
            System.out.println("Not checked out, or incorrect details: " + title + " by " + author);
        }
    }

    public void searchItem(String title, String author, String extraInfo) {
        LibraryItem item = findItem(title, author, extraInfo);
        if (item != null) {
            System.out.println("Found: " + title + " by " + author + " (" + getItemType(item) + ")");
        } else {
            System.out.println("Material not found: " + title + " by " + author);
        }
    }

    public void displayAvailableItems() {
        boolean hasAvailableItems = false;
        System.out.println("Available material(s) in library:");
        for (LibraryItem item : items) {
            if (!item.isCheckedOut()) {
                item.displayInfo();
                hasAvailableItems = true;
            }
        }
        if (!hasAvailableItems) {
            System.out.println("No available material(s) in library.");
        }
    }

    private String getItemType(LibraryItem item) {
        if (item instanceof Book) {
            return "book";
        } else if (item instanceof Magazine) {
            return "magazine";
        } else if (item instanceof Audiobook) {
            return "audiobook";
        }
        return "unknown type";
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        System.out.println("Added new material(s).");
        library.addItem(new Book("Garden of bones", "Tess Gerritsen", "ІЛ-00037829"));
        library.addItem(new Magazine("MARIE CLAIRE", "Evelyn Pruvost", "October 1937"));
        library.addItem(new Audiobook("Becoming", "Michelle Obama", 11.0));

        System.out.println();
        library.searchItem("Garden of bones", "Tess Gerritsen", "ІЛ-00037829");
        library.searchItem("MARIE CLAIRE", "Evelyn Pruvost", "October 1937");
        library.searchItem("Becoming", "Michelle Obama", "11.0");

        System.out.println();
        library.checkOutItem("Garden of bones", "Tess Gerritsen", "ІЛ-00037829");
        library.checkOutItem("MARIE CLAIRE", "Evelyn Pruvost", "October 1937");

        System.out.println();
        library.returnItem("Garden of bones", "Tess Gerritsen", "ІЛ-00037829");
        
        System.out.println();
        library.displayAvailableItems();
    }
}
