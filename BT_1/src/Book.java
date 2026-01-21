import java.util.Scanner;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price; // Changed to double as per your new request

    // Constructors
    public Book() {}

    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Input/Output methods
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sách: ");
        this.id = sc.nextInt();
        sc.nextLine(); // Clear buffer
        System.out.print("Nhập tiêu đề: ");
        this.title = sc.nextLine();
        System.out.print("Nhập tác giả: ");
        this.author = sc.nextLine();
        System.out.print("Nhập đơn giá: ");
        this.price = sc.nextDouble();
    }

    public void output() {
        System.out.printf("ID: %-5d | Tên: %-20s | TG: %-15s | Giá: %.2f%n",
                id, title, author, price);
    }
}