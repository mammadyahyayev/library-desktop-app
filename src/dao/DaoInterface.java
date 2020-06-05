package dao;

import java.util.List;
import model.AdvancedSearch;
import model.Author;
import model.Book;
import model.BookStatus;
import model.BookTip;
import model.Employee;
import model.Menu;
import model.Note;
import model.OnlyOrder;
import model.OrderBook;
import model.Paid;
import model.Product;
import model.ReceiveEmail;
import model.SendEmail;
import model.Shelf;
import model.Student;
import model.Table;
import model.TableOrder;

public interface DaoInterface {

    List<Author> getAuthorList() throws Exception;

    List<Student> getStudentList() throws Exception;

    List<Employee> getEmployeeList() throws Exception;

    List<Book> getBookList() throws Exception;

    List<Menu> getMenuList() throws Exception;

    List<Product> getProductList() throws Exception;

    List<SendEmail> getSendEmailList() throws Exception;

    List<OnlyOrder> getOnlyOrderList() throws Exception;

    List<Note> getNoteList() throws Exception;

    List<TableOrder> getTableOrderList() throws Exception;

    List<Paid> getPaidList() throws Exception;

    List<Table> getTableList() throws Exception;

    List<BookTip> getBookTipList() throws Exception;

    List<Shelf> getShelfList() throws Exception;

    List<BookStatus> getBookStatus() throws Exception;

    List<OrderBook> getOrderBookList(Long statusId) throws Exception;

    byte[] getAuthorPhotoById(Long authorId) throws Exception;

    byte[] getStudentPhotoById(Long studentId) throws Exception;

    byte[] getEmployeePhotoById(Long employeeId) throws Exception;

    byte[] getBookPhotoById(Long bookId) throws Exception;

    boolean add(OnlyOrder order) throws Exception;

    boolean add(Student student, String imgPath) throws Exception;

    boolean add(Author author, String imgPath) throws Exception;

    boolean add(Employee employee, String imgPath) throws Exception;

    boolean add(Book book, String imgPath) throws Exception;

    boolean add(Product product) throws Exception;

    boolean add(Menu menu) throws Exception;

    boolean addSoldBook(OrderBook orderBook) throws Exception;

    boolean addBorrowBook(OrderBook orderBook) throws Exception;

    boolean addReadNowBook(OrderBook orderBook) throws Exception;

    boolean add(TableOrder tableOrder) throws Exception;

    boolean add(Paid paid) throws Exception;

    Menu getMenuById(Long menuId) throws Exception;

    Author getAuthorById(Long authorId) throws Exception;

    Student getStudentById(Long studentId) throws Exception;

    Employee getEmployeeById(Long employeeId) throws Exception;

    Book getBookById(Long bookId) throws Exception;

    Product getProductById(Long productId) throws Exception;

    OrderBook getOrderBookById(Long orderBookId, Long bookStatusId) throws Exception;

    OnlyOrder getOnlyOrderById(Long onlyOrderId) throws Exception;

    TableOrder getTableOrderById(Long tableOrderId) throws Exception;

    Paid getPaidById(Long paidId) throws Exception;

    boolean updateMenu(Menu menu, Long menuId) throws Exception;

    boolean updateAuthor(Author author, Long authorId) throws Exception;

    boolean updateStudent(Student student, Long studentId) throws Exception;

    boolean updateEmployee(Employee employee, Long employeeId) throws Exception;

    boolean updateBook(Book book, Long bookId) throws Exception;

    boolean updateProduct(Product product, Long productId) throws Exception;

    boolean updateAuthorImg(Long authorId, String imgPath) throws Exception;

    boolean updateStudentImg(Long studentId, String imgPath) throws Exception;

    boolean updateEmployeeImg(Long employeeId, String imgPath) throws Exception;

    boolean updateBookImg(Long bookId, String imgPath) throws Exception;

    boolean updateSoldBook(OrderBook orderBook, Long orderBookId) throws Exception;

    boolean updateBorrowBook(OrderBook orderBook, Long orderBookId) throws Exception;

    boolean updateReadNowBook(OrderBook orderBook, Long orderBookId) throws Exception;

    boolean updateOnlyOrder(OnlyOrder onlyOrder, Long onlyOrderId) throws Exception;

    boolean updateTableOrder(TableOrder tableOrder, Long tableOrderId) throws Exception;

    boolean updatePaid(Paid paid, Long paidId) throws Exception;

    boolean deleteMenu(Long menuId) throws Exception;

    boolean deleteAuthor(Long authorId) throws Exception;

    boolean deleteStudent(Long studentId) throws Exception;

    boolean deleteEmployee(Long employeeId) throws Exception;

    boolean deleteBook(Long bookId) throws Exception;

    boolean deleteProduct(Long productId) throws Exception;

    boolean deleteOrderBook(Long orderBookId) throws Exception;

    boolean deleteOnlyOrder(Long onlyOrderId) throws Exception;

    boolean deletePaid(Long paidId) throws Exception;

    List<Student> searchStudent(String keyword) throws Exception;

    List<Author> searchAuthor(String keyword) throws Exception;

    List<Book> searchBook(String keyword) throws Exception;

    List<Menu> searchMenu(String keyword) throws Exception;

    List<TableOrder> searchTableOrder(String keyword) throws Exception;

    List<Product> searchProduct(String keyword) throws Exception;

    List<Employee> searchEmployee(String keyword) throws Exception;

    List<SendEmail> searchEmail(String keyword) throws Exception;

    List<OrderBook> searchOrderBook(String keyword, Long statusId) throws Exception;

    List<Paid> searchPaid(String keyword) throws Exception;

// Crud emeliyyatlarindan basqa metodlar
    boolean updateBookNum(int copies, Long bookId) throws Exception;

    boolean changeTableStatus(Long tableId, Long tableStatusId) throws Exception;

    List<TableOrder> getTableOrderByTableId(Long tableId) throws Exception;

    TableOrder getTableOrderListByTableId(Long tableId) throws Exception;

    List<Table> getTableListByStatusId(Long statusId) throws Exception;

    List<Book> advancedSearchBook(AdvancedSearch advancedSearch) throws Exception;

    List<Product> advancedSearchProduct(AdvancedSearch advancedSearch) throws Exception;

    boolean deleteTableOrderByTableId(Long tableId) throws Exception;

    List<Paid> advancedSearchPaid(AdvancedSearch advancedSearch) throws Exception;

    boolean changeTableInPaidTable(Long tableId, Long tableOrderId) throws Exception;

}
