import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);

        String msg = """
                \n--- CHƯƠNG TRÌNH QUẢN LÝ SÁCH ---
                1. Thêm 1 cuốn sách
                2. Xóa 1 cuốn sách
                3. Thay đổi sách
                4. Xuất thông tin tất cả sách
                5. Tìm sách có tiêu đề chứa "Lập trình"
                6. Lấy sách tối đa theo giá
                7. Tìm kiếm sách theo tên tác giả
                0. Thoát
                Chọn chức năng: """;

        int chon;
        do {
            System.out.print(msg);
            chon = x.nextInt();
            x.nextLine(); // Clear buffer

            switch (chon) {
                case 1 -> { // Add book
                    Book b = new Book();
                    b.input();
                    listBook.add(b);
                }
                case 2 -> { // Delete book
                    System.out.print("Nhập mã sách cần xóa: ");
                    int id = x.nextInt();
                    listBook.removeIf(b -> b.getId() == id);
                    System.out.println("Đã cập nhật danh sách.");
                }
                case 3 -> { // Change book
                    System.out.print("Nhập mã sách cần sửa: ");
                    int id = x.nextInt();
                    Optional<Book> find = listBook.stream().filter(b -> b.getId() == id).findFirst();
                    if (find.isPresent()) {
                        System.out.println("Nhập thông tin mới:");
                        find.get().input();
                    } else {
                        System.out.println("Không tìm thấy mã sách!");
                    }
                }
                case 4 -> { // Export all
                    System.out.println("\n--- DANH SÁCH SÁCH ---");
                    listBook.forEach(Book::output);
                }
                case 5 -> { // Find "Programming"
                    System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
                    listBook.stream()
                            .filter(b -> b.getTitle().toLowerCase().contains("Lập trình") ||
                                    b.getTitle().toLowerCase().contains("lập trình"))
                            .forEach(Book::output);
                }
                case 6 -> { // Max K books with price <= P
                    System.out.print("Nhập số lượng sách tối đa: ");
                    int k = x.nextInt();
                    System.out.print("Nhập mức giá tối đa: ");
                    double p = x.nextDouble();

                    listBook.stream()
                            .filter(b -> b.getPrice() <= p)
                            .limit(k)
                            .forEach(Book::output);
                }
                case 7 -> { // List by authors
                    System.out.print("Nhập tên tác giả: ");
                    String input = x.nextLine();
                    List<String> targetAuthors = Arrays.asList(input.split(",\\s*"));

                    listBook.stream()
                            .filter(b -> targetAuthors.stream()
                                    .anyMatch(a -> a.equalsIgnoreCase(b.getAuthor())))
                            .forEach(Book::output);
                }
                case 0 -> System.out.println("Thoát chương trình.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);
    }
}