package dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
import model.SendEmail;
import model.Shelf;
import model.Student;
import model.Table;
import model.TableOrder;
import model.TableStatus;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import util.Utility;

public class DaoImpl implements DaoInterface {

    // TODO: Write Query with PL-SQL 
    // TODO: Design Patterns
    // TODO : look at theese lines 1610-1725 and write query method with pl-sql 
    // TODO : you was working at 2000 lines 
    
    @Override
    public List<Author> getAuthorList() throws Exception {
        List<Author> authorList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{?  = call AUTHOR_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Author author = new Author();
                    author.setRowNum(rs.getLong("r"));
                    author.setId(rs.getLong("ID"));
                    author.setName(rs.getString("NAME"));
                    author.setSurname(rs.getString("SURNAME"));
                    author.setBirthDate(rs.getDate("BIRTH_DATE"));
                    author.setDeathDate(rs.getDate("DEATH_DATE"));
                    author.setAdvanceInfo(rs.getString("ADVANCE_INFO"));

                    authorList.add(author);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return authorList;
    }

    @Override
    public List<Student> getStudentList() throws Exception {
        List<Student> studentList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call GET_STUDENT_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Student student = new Student();
                    student.setRowNum(rs.getLong("r"));
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setGroup(rs.getString("STUDENT_GROUP"));
                    student.setPhone(rs.getString("PHONE"));
                    student.setEmail(rs.getString("EMAIL"));

                    studentList.add(student);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return studentList;
    }

    @Override
    public byte[] getAuthorPhotoById(Long authorId) throws Exception {
        Author author = new Author();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call GET_AUTHOR_PHOTO(?)}";
        byte[] img = null;
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, authorId);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    img = rs.getBytes("IMG");
                    author.setId(rs.getLong("ID"));
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }
        return img;
    }

    @Override
    public byte[] getStudentPhotoById(Long studentId) throws Exception {
        Student student = new Student();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call GET_STUDENT_PHOTO(?)}";
        byte[] img = null;
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, studentId);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    img = rs.getBytes("IMG");
                    student.setId(rs.getLong("ID"));
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }
        return img;
    }

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call GET_EMPLOYEE_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setRowNum(rs.getLong("r"));
                    employee.setId(rs.getLong("ID"));
                    employee.setName(rs.getString("NAME"));
                    employee.setSurname(rs.getString("SURNAME"));
                    employee.setPhone(rs.getString("PHONE"));
                    employee.setAddress(rs.getString("ADRESS"));
                    employee.setWorkDay(rs.getString("WORK_DAY"));
                    employee.setSalary(rs.getFloat("SALARY"));
                    employee.setEmail(rs.getString("EMAIL"));

                    employeeList.add(employee);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return employeeList;
    }

    @Override
    public byte[] getEmployeePhotoById(Long employeeId) throws Exception {
        Employee employee = new Employee();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call GET_EMPLOYEE_PHOTO(?)}";
        byte[] img = null;
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, employeeId);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    img = rs.getBytes("IMG");
                    employee.setId(rs.getLong("ID"));
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }
        return img;
    }

    @Override
    public List<Book> getBookList() throws Exception {
        List<Book> bookList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call BOOK_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    BookStatus bookStatus = new BookStatus();
                    bookStatus.setId(rs.getLong("book_status_id"));
                    bookStatus.setStatusName(rs.getString("STATUS_NAME"));

                    Shelf shelf = new Shelf();
                    shelf.setId(rs.getLong("shelf_id"));
                    shelf.setShelfName(rs.getString("NAME"));

                    BookTip bookTip = new BookTip();
                    bookTip.setId(rs.getLong("book_tip_id"));
                    bookTip.setTipName(rs.getString("TIP"));

                    Book book = new Book();
                    book.setRowNum(rs.getLong("r"));
                    book.setId(rs.getLong("ID"));
                    book.setCopies(rs.getInt("COPIES"));
                    book.setTitle(rs.getString("TITLE"));
                    book.setPrice(rs.getFloat("PRICE"));
                    book.setPageNum(rs.getLong("PAGE_NUM"));

                    book.setShelf(shelf);
                    book.setBookStatus(bookStatus);
                    book.setBookTip(bookTip);

                    bookList.add(book);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return bookList;
    }

    @Override
    public byte[] getBookPhotoById(Long bookId) throws Exception {
        Book book = new Book();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call BOOK_PHOTO(?)}";
        byte[] img = null;
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, bookId);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    img = rs.getBytes("BOOK_IMG");
                    book.setId(rs.getLong("ID"));
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }
        return img;
    }

    @Override
    public List<Menu> getMenuList() throws Exception {
        List<Menu> menuList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call MENU_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("ID"));
                    menu.setRowNum(rs.getLong("r"));
                    menu.setMenuName(rs.getString("MENU_NAME"));
                    menu.setPrice(rs.getFloat("PRICE"));

                    menuList.add(menu);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return menuList;
    }

    @Override
    public List<Product> getProductList() throws Exception {
        List<Product> productList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call PRODUCT_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Product product = new Product();
                    product.setRowNum(rs.getLong("r"));
                    product.setId(rs.getLong("ID"));
                    product.setProductName(rs.getString("PRODUCT_NAME"));
                    product.setNum(rs.getInt("NUM"));
                    product.setPrice(rs.getFloat("PRICE"));
                    product.setAmount(rs.getFloat("AMOUNT"));

                    productList.add(product);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return productList;
    }

    @Override
    public List<SendEmail> getSendEmailList() throws Exception {
        List<SendEmail> sendEmailList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call SEND_EMAIL_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getLong("student_id"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setEmail(rs.getString("EMAIL"));

                    Employee employee = new Employee();
                    employee.setId(rs.getLong("employee_id"));
                    employee.setName(rs.getString("employee_name"));
                    employee.setSurname(rs.getString("employee_surname"));

                    SendEmail sendEmail = new SendEmail();
                    sendEmail.setRowNum(rs.getLong("r"));
                    sendEmail.setId(rs.getLong("ID"));
                    sendEmail.setMessage(rs.getString("MESSAGE"));

                    sendEmail.setStudent(student);
                    sendEmail.setEmployee(employee);

                    sendEmailList.add(sendEmail);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return sendEmailList;
    }

    @Override
    public List<OnlyOrder> getOnlyOrderList() throws Exception {
        List<OnlyOrder> orderList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{ ? = call ONLY_ORDER_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    OnlyOrder order = new OnlyOrder();
                    order.setRowNum(rs.getLong("r"));
                    order.setId(rs.getLong("ID"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("PRICE"));
                    order.setResName(rs.getString("RES_NAME"));

                    order.setMenu(menu);

                    orderList.add(order);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return orderList;
    }

    @Override
    public List<Note> getNoteList() throws Exception {
        List<Note> noteList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{?  = call NOTE_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Note note = new Note();
                    note.setRowNum(rs.getLong("r"));
                    note.setId(rs.getLong("ID"));
                    note.setBeginDate(rs.getDate("BEGIN_DATE"));
                    note.setEndDate(rs.getDate("END_DATE"));
                    note.setNoteText(rs.getString("NOTE"));

                    noteList.add(note);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return noteList;
    }

    @Override
    public List<TableOrder> getTableOrderList() throws Exception {
        List<TableOrder> tableOrderList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call TABLE_ORDER_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    OnlyOrder order = new OnlyOrder();
                    order.setId(rs.getLong("order_id"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("PRICE"));

                    order.setMenu(menu);

                    Table table = new Table();
                    table.setId(rs.getLong("table_id"));
                    table.setName(rs.getString("LIB_TABLE"));

                    TableOrder tableOrder = new TableOrder();
                    tableOrder.setRowNum(rs.getLong("r"));
                    tableOrder.setId(rs.getLong("ID"));
                    tableOrder.setResName(rs.getString("RES_NAME"));
                    tableOrder.setTable(table);
                    tableOrder.setOrder(order);

                    tableOrderList.add(tableOrder);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return tableOrderList;
    }

    @Override
    public List<Paid> getPaidList() throws Exception {
        List<Paid> paidList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call PAID_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    OnlyOrder order = new OnlyOrder();
                    order.setId(rs.getLong("order_id"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("order_price"));

                    order.setMenu(menu);

                    Table table = new Table();
                    table.setId(rs.getLong("table_id"));
                    table.setName(rs.getString("LIB_TABLE"));

                    TableOrder tableOrder = new TableOrder();
                    tableOrder.setId(rs.getLong("table_order_id"));
                    tableOrder.setResName(rs.getString("RES_NAME"));
                    tableOrder.setTable(table);
                    tableOrder.setOrder(order);

                    Paid paid = new Paid();
                    paid.setRowNum(rs.getLong("r"));
                    paid.setId(rs.getLong("ID"));
                    paid.setPaidDate(rs.getDate("PAID_DATE"));
                    paid.setPrice(rs.getFloat("PRICE"));
                    paid.setTableOrder(tableOrder);

                    paidList.add(paid);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return paidList;
    }

    @Override
    public List<Table> getTableList() throws Exception {
        List<Table> tableList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call TABLE_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Table table = new Table();
                    table.setRowNum(rs.getLong("r"));
                    table.setId(rs.getLong("ID"));
                    table.setName(rs.getString("LIB_TABLE"));

                    TableStatus status = new TableStatus();
                    status.setId(rs.getLong("table_status_id"));
                    status.setTableStatus(rs.getString("STATUS_NAME"));

                    table.setTableStatus(status);

                    tableList.add(table);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return tableList;
    }

    @Override
    public boolean add(OnlyOrder order) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call ADD_ONLY_ORDER(?,?,?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setInt(1, order.getNum());
                cs.setString(2, order.gettOrder());
                cs.setLong(3, order.getMenu().getId());
                cs.setFloat(4, order.getPrice());
                cs.setString(5, order.getResName());
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public Menu getMenuById(Long menuId) throws Exception {
        Menu menu = new Menu();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{ ? = call  MENU_BY_ID(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, menuId);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                if (rs.next()) {
                    menu.setId(rs.getLong("ID"));
                    menu.setRowNum(rs.getLong("r"));
                    menu.setMenuName(rs.getString("MENU_NAME"));
                    menu.setPrice(rs.getFloat("PRICE"));
                } else {
                    menu = null;
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return menu;
    }

    @Override
    public List<BookTip> getBookTipList() throws Exception {
        List<BookTip> bookTipList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call BOOK_TIP_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    BookTip bookTip = new BookTip();
                    bookTip.setRowNum(rs.getLong("r"));
                    bookTip.setId(rs.getLong("ID"));
                    bookTip.setTipName(rs.getString("TIP"));

                    bookTipList.add(bookTip);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return bookTipList;
    }

    @Override
    public List<Shelf> getShelfList() throws Exception {
        List<Shelf> shelfList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call BOOK_SHELF_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    Shelf shelf = new Shelf();
                    shelf.setRowNum(rs.getLong("r"));
                    shelf.setId(rs.getLong("ID"));
                    shelf.setShelfName(rs.getString("NAME"));

                    shelfList.add(shelf);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return shelfList;
    }

    @Override
    public boolean add(Student student, String imgPath) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " INSERT INTO STUDENT(ID,NAME,SURNAME,STUDENT_GROUP,PHONE,EMAIL,IMG) "
                + "  VALUES(STUDENT_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setString(3, student.getGroup());
                ps.setString(4, student.getPhone());
                ps.setString(5, student.getEmail());
                if (imgPath != null) {
                    InputStream in = new FileInputStream(imgPath);
                    ps.setBinaryStream(6, in);
                } else {
                    imgPath = "C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\nophoto.png";
                    InputStream in = new FileInputStream(imgPath);
                    ps.setBinaryStream(6, in);
                }
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean add(Author author, String imgPath) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        String sql = "INSERT INTO AUTHOR(ID,NAME,SURNAME,BIRTH_DATE,DEATH_DATE,IMG) \n"
                + " VALUES(AUTHOR_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareStatement(sql);
                cs.setString(1, author.getName());
                cs.setString(2, author.getSurname());
                cs.setDate(3, new java.sql.Date(author.getBirthDate().getTime()));
                cs.setDate(4, new java.sql.Date(author.getDeathDate().getTime()));
                if (imgPath != null) {
                    InputStream in = new FileInputStream(imgPath);
                    cs.setBinaryStream(5, in);
                } else {
                    imgPath = "C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\nophoto.png";
                    InputStream in = new FileInputStream(imgPath);
                    cs.setBinaryStream(5, in);
                }
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean add(Employee employee, String imgPath) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO  EMPLOYEE(ID,NAME,SURNAME,PHONE,ADRESS,WORK_DAY,SALARY,EMAIL,IMG) "
                + " VALUES(EMPLOYEE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, employee.getName());
                ps.setString(2, employee.getSurname());
                ps.setString(3, employee.getPhone());
                ps.setString(4, employee.getAddress());
                ps.setString(5, employee.getWorkDay());
                ps.setFloat(6, employee.getSalary());
                ps.setString(7, employee.getEmail());
                if (imgPath != null) {
                    InputStream in = new FileInputStream(imgPath);
                    ps.setBinaryStream(8, in);
                } else {
                    imgPath = "C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\nophoto.png";
                    InputStream in = new FileInputStream(imgPath);
                    ps.setBinaryStream(8, in);
                }
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean add(Book book, String imgPath) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO BOOK(ID,TITLE,PAGE_NUM,COPIES,BOOK_IMG,PRICE,BOOK_STATUS_ID,BOOK_TIP_ID,SHELF_ID) "
                + " VALUES(BOOK_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, book.getTitle());
                ps.setLong(2, book.getPageNum());
                ps.setInt(3, book.getCopies());
                if (imgPath != null) {
                    InputStream in = new FileInputStream(imgPath);
                    ps.setBinaryStream(4, in);
                } else {
                    imgPath = "C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\nophoto.png";
                    InputStream in = new FileInputStream(imgPath);
                    ps.setBinaryStream(4, in);
                }
                ps.setFloat(5, book.getPrice());
                ps.setLong(6, 3);
                ps.setLong(7, book.getBookTip().getId());
                ps.setLong(8, book.getShelf().getId());
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean add(Product product) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call PRODUCT_ADD(?,?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setString(1, product.getProductName());
                cs.setInt(2, product.getNum());
                cs.setFloat(3, product.getAmount());
                cs.setFloat(4, product.getPrice());
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean add(Menu menu) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call MENU_ADD(?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setString(1, menu.getMenuName());
                cs.setFloat(2, menu.getPrice());
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public Author getAuthorById(Long authorId) throws Exception {
        Author author = new Author();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call AUTHOR_BY_ID(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, authorId);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {

                    author.setRowNum(rs.getLong("r"));
                    author.setId(rs.getLong("ID"));
                    author.setName(rs.getString("NAME"));
                    author.setSurname(rs.getString("SURNAME"));
                    author.setBirthDate(rs.getDate("BIRTH_DATE"));
                    author.setDeathDate(rs.getDate("DEATH_DATE"));
                    author.setAdvanceInfo(rs.getString("ADVANCE_INFO"));

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return author;
    }

    @Override
    public Student getStudentById(Long studentId) throws Exception {
        Student student = new Student();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call STUDENT_BY_ID(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, studentId);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    student.setRowNum(rs.getLong("r"));
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setGroup(rs.getString("STUDENT_GROUP"));
                    student.setPhone(rs.getString("PHONE"));
                    student.setEmail(rs.getString("EMAIL"));
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }
        return student;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws Exception {
        Employee employee = new Employee();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call EMPLOYEE_BY_ID(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, employeeId);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    employee.setRowNum(rs.getLong("r"));
                    employee.setId(rs.getLong("ID"));
                    employee.setName(rs.getString("NAME"));
                    employee.setSurname(rs.getString("SURNAME"));
                    employee.setPhone(rs.getString("PHONE"));
                    employee.setAddress(rs.getString("ADRESS"));
                    employee.setWorkDay(rs.getString("WORK_DAY"));
                    employee.setSalary(rs.getFloat("SALARY"));
                    employee.setEmail(rs.getString("EMAIL"));
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }
        return employee;
    }

    @Override
    public Book getBookById(Long bookId) throws Exception {
        Book book = new Book();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call BOOK_BY_ID(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, bookId);
                cs.execute();
                rs = cs.executeQuery();
                while (rs.next()) {
                    BookStatus bookStatus = new BookStatus();
                    bookStatus.setId(rs.getLong("book_status_id"));
                    bookStatus.setStatusName(rs.getString("STATUS_NAME"));

                    Shelf shelf = new Shelf();
                    shelf.setId(rs.getLong("shelf_id"));
                    shelf.setShelfName(rs.getString("NAME"));

                    BookTip bookTip = new BookTip();
                    bookTip.setId(rs.getLong("book_tip_id"));
                    bookTip.setTipName(rs.getString("TIP"));

                    book.setRowNum(rs.getLong("r"));
                    book.setId(rs.getLong("ID"));
                    book.setCopies(rs.getInt("COPIES"));
                    book.setTitle(rs.getString("TITLE"));
                    book.setPrice(rs.getFloat("PRICE"));
                    book.setPageNum(rs.getLong("PAGE_NUM"));

                    book.setShelf(shelf);
                    book.setBookStatus(bookStatus);
                    book.setBookTip(bookTip);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return book;
    }

    @Override
    public Product getProductById(Long productId) throws Exception {
        Product product = new Product();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call PRODUCT_BY_ID(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, productId);
                cs.execute();
                rs = cs.executeQuery();
                while (rs.next()) {

                    product.setRowNum(rs.getLong("r"));
                    product.setId(rs.getLong("ID"));
                    product.setProductName(rs.getString("PRODUCT_NAME"));
                    product.setNum(rs.getInt("NUM"));
                    product.setPrice(rs.getFloat("PRICE"));
                    product.setAmount(rs.getFloat("AMOUNT"));

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return product;
    }

    @Override
    public boolean updateMenu(Menu menu, Long menuId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call UPDATE_MENU(?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setString(1, menu.getMenuName());
                cs.setFloat(2, menu.getPrice());
                cs.setLong(3, menuId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean updateAuthor(Author author, Long authorId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call UPDATE_AUTHOR(?,?,?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setString(1, author.getName());
                cs.setString(2, author.getSurname());
                cs.setDate(3, new java.sql.Date(author.getBirthDate().getTime()));
                if (author.getDeathDate() != null) {
                    cs.setDate(4, new java.sql.Date(author.getDeathDate().getTime()));
                } else {
                    cs.setDate(4, null);
                }
                cs.setLong(5, authorId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean updateStudent(Student student, Long studentId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call UPDATE_STUDENT(?,?,?,?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setString(1, student.getName());
                cs.setString(2, student.getSurname());
                cs.setString(3, student.getGroup());
                cs.setString(4, student.getPhone());
                cs.setString(5, student.getEmail());
                cs.setLong(6, studentId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean updateEmployee(Employee employee, Long employeeId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call UPDATE_EMPLOYEE(?,?,?,?,?,?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setString(1, employee.getName());
                cs.setString(2, employee.getSurname());
                cs.setString(3, employee.getPhone());
                cs.setString(4, employee.getAddress());
                cs.setString(5, employee.getWorkDay());
                cs.setFloat(6, employee.getSalary());
                cs.setString(7, employee.getEmail());
                cs.setLong(8, employeeId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean updateBook(Book book, Long bookId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call UPDATE_BOOK(?,?,?,?,?,?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setString(1, book.getTitle());
                cs.setLong(2, book.getPageNum());
                cs.setInt(3, book.getCopies());
                cs.setFloat(4, book.getPrice());
                cs.setLong(5, book.getBookStatus().getId());
                cs.setLong(6, book.getBookTip().getId());
                cs.setLong(7, book.getShelf().getId());
                cs.setLong(8, bookId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean updateProduct(Product product, Long productId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call UPDATE_PRODUCT(?,?,?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setString(1, product.getProductName());
                cs.setInt(2, product.getNum());
                cs.setFloat(3, product.getPrice());
                cs.setFloat(4, product.getAmount());
                cs.setLong(5, productId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean deleteMenu(Long menuId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call DELETE_MENU(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setLong(1, menuId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean deleteAuthor(Long authorId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call DELETE_AUTHOR(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setLong(1, authorId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean deleteStudent(Long studentId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call DELETE_STUDENT(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setLong(1, studentId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean deleteEmployee(Long employeeId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "call DELETE_EMPLOYEE(?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setLong(1, employeeId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean deleteBook(Long bookId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call DELETE_BOOK(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setLong(1, bookId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean deleteProduct(Long productId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call DELETE_PRODUCT(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setLong(1, productId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean updateAuthorImg(Long authorId, String imgPath) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE AUTHOR SET IMG = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                InputStream is = new FileInputStream(imgPath);
                ps.setBinaryStream(1, is);
                ps.setLong(2, authorId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean updateStudentImg(Long studentId, String imgPath) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE STUDENT SET IMG = ?  WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                InputStream is = new FileInputStream(imgPath);
                ps.setBinaryStream(1, is);
                ps.setLong(2, studentId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean updateEmployeeImg(Long employeeId, String imgPath) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE EMPLOYEE SET IMG = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                InputStream is = new FileInputStream(imgPath);
                ps.setBinaryStream(1, is);
                ps.setLong(2, employeeId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean updateBookImg(Long bookId, String imgPath) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE BOOK SET BOOK_IMG = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                InputStream is = new FileInputStream(imgPath);
                ps.setBinaryStream(1, is);
                ps.setLong(2, bookId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public List<BookStatus> getBookStatus() throws Exception {
        List<BookStatus> bookStatusList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call BOOK_STATUS_LIST}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    BookStatus status = new BookStatus();
                    status.setRowNum(rs.getLong("r"));
                    status.setId(rs.getLong("ID"));
                    status.setStatusName(rs.getString("STATUS_NAME"));

                    bookStatusList.add(status);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return bookStatusList;
    }

    @Override
    public List<OrderBook> getOrderBookList(Long statusId) throws Exception {
        List<OrderBook> orderBookList = new ArrayList<>();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call ORDER_BOOK_LIST(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, statusId);
                cs.execute();
                rs = (ResultSet) cs.getObject(1);
                while (rs.next()) {
                    OrderBook orderBook = new OrderBook();
                    orderBook.setRowNum(rs.getLong("r"));
                    orderBook.setId(rs.getLong("ID"));
                    orderBook.setBorrowTime(rs.getDate("BORROW_TIME"));
                    orderBook.setPrice(rs.getFloat("BORROW_PRICE"));

                    Book book = new Book();
                    book.setId(rs.getLong("book_id"));
                    book.setCopies(rs.getInt("COPIES"));
                    book.setTitle(rs.getString("TITLE"));
                    book.setPrice(rs.getFloat("book_price"));
                    book.setPageNum(rs.getLong("PAGE_NUM"));

                    Student student = new Student();
                    student.setId(rs.getLong("student_id"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setGroup(rs.getString("STUDENT_GROUP"));
                    student.setPhone(rs.getString("PHONE"));
                    student.setEmail(rs.getString("EMAIL"));

                    BookStatus status = new BookStatus();
                    status.setId(rs.getLong("book_status_id"));
                    status.setStatusName(rs.getString("STATUS_NAME"));

                    orderBook.setBook(book);
                    orderBook.setStudent(student);
                    orderBook.setBookStatus(status);

                    orderBookList.add(orderBook);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return orderBookList;
    }

    @Override
    public OrderBook getOrderBookById(Long orderBookId, Long bookStatusId) throws Exception {
        OrderBook orderBook = new OrderBook();
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{? = call ORDER_BOOK_BY_ID(?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setLong(2, bookStatusId);
                cs.setLong(3, orderBookId);
                rs = (ResultSet) cs.getObject(1);
                if (rs.next()) {
                    orderBook.setRowNum(rs.getLong("r"));
                    orderBook.setId(rs.getLong("ID"));
                    orderBook.setBorrowTime(rs.getDate("BORROW_TIME"));
                    orderBook.setPrice(rs.getFloat("BORROW_PRICE"));

                    Book book = new Book();
                    book.setId(rs.getLong("book_id"));
                    book.setCopies(rs.getInt("COPIES"));
                    book.setTitle(rs.getString("TITLE"));
                    book.setPrice(rs.getFloat("book_price"));
                    book.setPageNum(rs.getLong("PAGE_NUM"));

                    Student student = new Student();
                    student.setId(rs.getLong("student_id"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setGroup(rs.getString("STUDENT_GROUP"));
                    student.setPhone(rs.getString("PHONE"));
                    student.setEmail(rs.getString("EMAIL"));

                    BookStatus status = new BookStatus();
                    status.setId(rs.getLong("book_status_id"));
                    status.setStatusName(rs.getString("STATUS_NAME"));

                    orderBook.setBook(book);
                    orderBook.setStudent(student);
                    orderBook.setBookStatus(status);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, cs, rs);
        }

        return orderBook;
    }

    @Override
    public boolean updateSoldBook(OrderBook orderBook, Long orderBookId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call UPDATE_SOLD_BOOK(?,?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setLong(1, orderBook.getStudent().getId());
                cs.setLong(2, orderBook.getBook().getId());
                cs.setFloat(3, orderBook.getPrice());
                cs.setLong(4, orderBookId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean deleteOrderBook(Long orderBookId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call DELETE_ORDER_BOOK(?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setLong(1, orderBookId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean updateBorrowBook(OrderBook orderBook, Long orderBookId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call UPDATE_BORROW_BOOK(?,?,?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setLong(1, orderBook.getStudent().getId());
                cs.setLong(2, orderBook.getBook().getId());
                cs.setFloat(3, orderBook.getPrice());
                cs.setDate(4, new java.sql.Date(orderBook.getBorrowTime().getTime()));
                cs.setLong(5, orderBookId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean updateReadNowBook(OrderBook orderBook, Long orderBookId) throws Exception {
        boolean result = false;
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String sql = "{call UPDATE_READNOW_BOOK(?,?,?)}";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                cs = c.prepareCall(sql);
                cs.setLong(1, orderBook.getStudent().getId());
                cs.setLong(2, orderBook.getBook().getId());
                cs.setLong(3, orderBookId);
                cs.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, cs, rs);
        }
        return result;
    }

    @Override
    public boolean addSoldBook(OrderBook orderBook) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO ORDER_BOOK(ID,STUDENT_ID,BOOK_ID,BOOK_STATUS_ID,PRICE) "
                + " VALUES(ORDER_BOOK_SEQ.NEXTVAL,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, orderBook.getStudent().getId());
                ps.setLong(2, orderBook.getBook().getId());
                ps.setLong(3, orderBook.getBookStatus().getId());
                ps.setFloat(4, orderBook.getPrice());
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean updateBookNum(int copies, Long bookId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE BOOK SET COPIES = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, copies);
                ps.setLong(2, bookId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean addBorrowBook(OrderBook orderBook) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO ORDER_BOOK(ID,STUDENT_ID,BOOK_ID,BOOK_STATUS_ID,PRICE,BORROW_TIME) "
                + " VALUES(ORDER_BOOK_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, orderBook.getStudent().getId());
                ps.setLong(2, orderBook.getBook().getId());
                ps.setLong(3, orderBook.getBookStatus().getId());
                ps.setFloat(4, orderBook.getPrice());
                ps.setDate(5, new java.sql.Date(orderBook.getBorrowTime().getTime()));
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean addReadNowBook(OrderBook orderBook) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO ORDER_BOOK(ID,STUDENT_ID,BOOK_ID,BOOK_STATUS_ID) "
                + " VALUES(ORDER_BOOK_SEQ.NEXTVAL,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, orderBook.getStudent().getId());
                ps.setLong(2, orderBook.getBook().getId());
                ps.setLong(3, orderBook.getBookStatus().getId());
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean add(TableOrder tableOrder) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO TABLE_ORDER(ID,TABLE_ID,ONLY_ORDER_ID,RES_NAME) "
                + " VALUES(TABLE_ORDER_SEQ.NEXTVAL,?,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, tableOrder.getTable().getId());
                ps.setLong(2, tableOrder.getOrder().getId());
                ps.setString(3, tableOrder.getResName());
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean deleteOnlyOrder(Long onlyOrderId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE ONLY_ORDER SET ACTIVE = 0 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, onlyOrderId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean changeTableStatus(Long tableId, Long tableStatusId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE LIB_TABLE SET TABLE_STATUS_ID = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, tableStatusId);
                ps.setLong(2, tableId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public OnlyOrder getOnlyOrderById(Long onlyOrderId) throws Exception {
        OnlyOrder order = new OnlyOrder();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ONLY_ORDER.ID ,ONLY_ORDER.NUM,ONLY_ORDER.T_ORDER, "
                + " ONLY_ORDER.PRICE,MENU.ID menu_id ,MENU.MENU_NAME, ONLY_ORDER.RES_NAME FROM ONLY_ORDER "
                + " INNER JOIN MENU ON MENU.ID = ONLY_ORDER.MENU_ID WHERE (ONLY_ORDER.ACTIVE = 1 AND ONLY_ORDER.ID = ?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, onlyOrderId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    order.setRowNum(rs.getLong("r"));
                    order.setId(rs.getLong("ID"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("PRICE"));
                    order.setResName(rs.getString("RES_NAME"));

                    order.setMenu(menu);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return order;
    }

    @Override
    public TableOrder getTableOrderById(Long tableOrderId) throws Exception {
        TableOrder tableOrder = new TableOrder();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,TABLE_ORDER.ID,TABLE_ORDER.RES_NAME,LIB_TABLE.ID table_id,LIB_TABLE.LIB_TABLE, "
                + " ONLY_ORDER.ID order_id, "
                + " ONLY_ORDER.NUM,ONLY_ORDER.PRICE,ONLY_ORDER.T_ORDER, "
                + " MENU.ID menu_id,MENU.MENU_NAME "
                + " FROM TABLE_ORDER "
                + " INNER JOIN LIB_TABLE ON LIB_TABLE.ID  = TABLE_ORDER.TABLE_ID "
                + " INNER JOIN ONLY_ORDER ON ONLY_ORDER.ID  = TABLE_ORDER.ONLY_ORDER_ID "
                + " INNER JOIN MENU ON ONLY_ORDER.MENU_ID = MENU.ID WHERE (TABLE_ORDER.ACTIVE = 1 AND TABLE_ORDER.ID = ?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, tableOrderId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    OnlyOrder order = new OnlyOrder();
                    order.setId(rs.getLong("order_id"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("PRICE"));

                    order.setMenu(menu);

                    Table table = new Table();
                    table.setId(rs.getLong("table_id"));
                    table.setName(rs.getString("LIB_TABLE"));

                    tableOrder.setRowNum(rs.getLong("r"));
                    tableOrder.setId(rs.getLong("ID"));
                    tableOrder.setResName(rs.getString("RES_NAME"));
                    tableOrder.setTable(table);
                    tableOrder.setOrder(order);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return tableOrder;
    }

    @Override
    public List<TableOrder> getTableOrderByTableId(Long tableId) throws Exception {
        List<TableOrder> tableOrderList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,TABLE_ORDER.ID,TABLE_ORDER.RES_NAME,LIB_TABLE.ID table_id,LIB_TABLE.LIB_TABLE, "
                + " ONLY_ORDER.ID order_id, "
                + " ONLY_ORDER.NUM,ONLY_ORDER.PRICE,ONLY_ORDER.T_ORDER, "
                + " MENU.ID menu_id,MENU.MENU_NAME "
                + " FROM TABLE_ORDER "
                + " INNER JOIN LIB_TABLE ON LIB_TABLE.ID  = TABLE_ORDER.TABLE_ID "
                + " INNER JOIN ONLY_ORDER ON ONLY_ORDER.ID  = TABLE_ORDER.ONLY_ORDER_ID "
                + " INNER JOIN MENU ON ONLY_ORDER.MENU_ID = MENU.ID WHERE (TABLE_ORDER.ACTIVE = 1 AND LIB_TABLE.ID = ?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, tableId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    OnlyOrder order = new OnlyOrder();
                    order.setId(rs.getLong("order_id"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("PRICE"));

                    order.setMenu(menu);

                    Table table = new Table();
                    table.setId(rs.getLong("table_id"));
                    table.setName(rs.getString("LIB_TABLE"));

                    TableOrder tableOrder = new TableOrder();
                    tableOrder.setRowNum(rs.getLong("r"));
                    tableOrder.setId(rs.getLong("ID"));
                    tableOrder.setResName(rs.getString("RES_NAME"));
                    tableOrder.setTable(table);
                    tableOrder.setOrder(order);

                    tableOrderList.add(tableOrder);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return tableOrderList;
    }

    @Override
    public boolean updateOnlyOrder(OnlyOrder onlyOrder, Long onlyOrderId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE ONLY_ORDER SET NUM = ? , T_ORDER = ? , MENU_ID = ? , PRICE = ? , RES_NAME = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setInt(1, onlyOrder.getNum());
                ps.setString(2, onlyOrder.gettOrder());
                ps.setLong(3, onlyOrder.getMenu().getId());
                ps.setFloat(4, onlyOrder.getPrice());
                ps.setString(5, onlyOrder.getResName());
                ps.setLong(6, onlyOrderId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public boolean updateTableOrder(TableOrder tableOrder, Long tableOrderId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " UPDATE TABLE_ORDER SET TABLE_ID = ? , ONLY_ORDER_ID = ? , RES_NAME = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, tableOrder.getTable().getId());
                ps.setLong(2, tableOrder.getOrder().getId());
                ps.setString(3, tableOrder.getResName());
                ps.setLong(4, tableOrderId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, rs);
        }
        return result;
    }

    @Override
    public List<Table> getTableListByStatusId(Long statusId) throws Exception {
        List<Table> tableList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,LIB_TABLE.ID,LIB_TABLE,TABLE_STATUS.ID table_status_id, "
                + " TABLE_STATUS.STATUS_NAME FROM LIB_TABLE  "
                + " INNER JOIN TABLE_STATUS ON TABLE_STATUS.ID = LIB_TABLE.TABLE_STATUS_ID "
                + " WHERE (LIB_TABLE.ACTIVE = 1 AND TABLE_STATUS.ID = ?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, statusId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Table table = new Table();
                    table.setRowNum(rs.getLong("r"));
                    table.setId(rs.getLong("ID"));
                    table.setName(rs.getString("LIB_TABLE"));

                    TableStatus status = new TableStatus();
                    status.setId(rs.getLong("table_status_id"));
                    status.setTableStatus(rs.getString("STATUS_NAME"));

                    table.setTableStatus(status);

                    tableList.add(table);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return tableList;
    }

    @Override
    public TableOrder getTableOrderListByTableId(Long tableId) throws Exception {
        TableOrder tableOrder = new TableOrder();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,TABLE_ORDER.ID,TABLE_ORDER.RES_NAME,LIB_TABLE.ID table_id,LIB_TABLE.LIB_TABLE, "
                + " ONLY_ORDER.ID order_id, "
                + " ONLY_ORDER.NUM,ONLY_ORDER.PRICE,ONLY_ORDER.T_ORDER, "
                + " MENU.ID menu_id,MENU.MENU_NAME "
                + " FROM TABLE_ORDER "
                + " INNER JOIN LIB_TABLE ON LIB_TABLE.ID  = TABLE_ORDER.TABLE_ID "
                + " INNER JOIN ONLY_ORDER ON ONLY_ORDER.ID  = TABLE_ORDER.ONLY_ORDER_ID "
                + " INNER JOIN MENU ON ONLY_ORDER.MENU_ID = MENU.ID WHERE (TABLE_ORDER.ACTIVE = 1 AND LIB_TABLE.ID = ?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, tableId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    OnlyOrder order = new OnlyOrder();
                    order.setId(rs.getLong("order_id"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("PRICE"));

                    order.setMenu(menu);

                    Table table = new Table();
                    table.setId(rs.getLong("table_id"));
                    table.setName(rs.getString("LIB_TABLE"));

                    tableOrder.setRowNum(rs.getLong("r"));
                    tableOrder.setId(rs.getLong("ID"));
                    tableOrder.setResName(rs.getString("RES_NAME"));
                    tableOrder.setTable(table);
                    tableOrder.setOrder(order);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return tableOrder;
    }

    @Override
    public List<Student> searchStudent(String keyword) throws Exception {
        List<Student> studentList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM     r,\n"
                + "       ID,\n"
                + "       NAME,\n"
                + "       SURNAME,\n"
                + "       STUDENT_GROUP,\n"
                + "       PHONE,\n"
                + "       EMAIL\n"
                + "  FROM STUDENT\n"
                + " WHERE (ACTIVE = 1) AND (LOWER (NAME) LIKE LOWER (?)\n"
                + "       OR LOWER (SURNAME) LIKE LOWER (?)\n"
                + "       OR LOWER (STUDENT_GROUP) LIKE LOWER (?)\n"
                + "       OR LOWER (PHONE) LIKE LOWER (?)\n"
                + "       OR LOWER (EMAIL) LIKE LOWER (?))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setRowNum(rs.getLong("r"));
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setGroup(rs.getString("STUDENT_GROUP"));
                    student.setPhone(rs.getString("PHONE"));
                    student.setEmail(rs.getString("EMAIL"));

                    studentList.add(student);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return studentList;
    }

    @Override
    public List<Author> searchAuthor(String keyword) throws Exception {
        List<Author> authorList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM     r,\n"
                + "       ID,\n"
                + "       NAME,\n"
                + "       SURNAME,\n"
                + "       BIRTH_DATE,\n"
                + "       DEATH_DATE,\n"
                + "       ADVANCE_INFO\n"
                + "  FROM AUTHOR\n"
                + " WHERE    (ACTIVE = 1) AND (LOWER (NAME) LIKE LOWER (?)\n"
                + "       OR LOWER (SURNAME) LIKE LOWER (?)\n"
                + "       OR LOWER (BIRTH_DATE) LIKE LOWER (?)\n"
                + "       OR LOWER (DEATH_DATE) LIKE LOWER (?))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Author author = new Author();
                    author.setRowNum(rs.getLong("r"));
                    author.setId(rs.getLong("ID"));
                    author.setName(rs.getString("NAME"));
                    author.setSurname(rs.getString("SURNAME"));
                    author.setBirthDate(rs.getDate("BIRTH_DATE"));
                    author.setDeathDate(rs.getDate("DEATH_DATE"));
                    author.setAdvanceInfo(rs.getString("ADVANCE_INFO"));

                    authorList.add(author);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return authorList;
    }

    @Override
    public List<Book> searchBook(String keyword) throws Exception {
        List<Book> bookList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM             r,\n"
                + "       BOOK.ID,\n"
                + "       BOOK.TITLE,\n"
                + "       BOOK.COPIES,\n"
                + "       BOOK.PRICE,\n"
                + "       BOOK_STATUS.ID     book_status_id,\n"
                + "       BOOK_TIP.ID        book_tip_id,\n"
                + "       BOOK_STATUS.STATUS_NAME,\n"
                + "       BOOK_TIP.TIP,\n"
                + "       SHELF.ID           shelf_id,\n"
                + "       SHELF.NAME,\n"
                + "       BOOK.PAGE_NUM\n"
                + "  FROM BOOK\n"
                + "       INNER JOIN BOOK_STATUS ON BOOK_STATUS.ID = BOOK.BOOK_STATUS_ID\n"
                + "       INNER JOIN BOOK_TIP ON BOOK_TIP.ID = BOOK.BOOK_TIP_ID\n"
                + "       INNER JOIN SHELF ON SHELF.ID = BOOK.SHELF_ID\n"
                + " WHERE    BOOK.ACTIVE = 1 AND LOWER (BOOK.TITLE) LIKE LOWER (?)\n"
                + "       OR LOWER (BOOK.COPIES) LIKE LOWER (?)\n"
                + "       OR LOWER (BOOK.PRICE) LIKE LOWER (?)\n"
                + "       OR LOWER (BOOK.PAGE_NUM) LIKE LOWER (?)\n"
                + "       OR LOWER (BOOK_STATUS.STATUS_NAME) LIKE LOWER (?)\n"
                + "       OR LOWER (BOOK_TIP.TIP) LIKE LOWER(?)\n"
                + "       OR LOWER (SHELF.NAME) LIKE LOWER(?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                ps.setString(6, "%" + keyword + "%");
                ps.setString(7, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    BookStatus bookStatus = new BookStatus();
                    bookStatus.setId(rs.getLong("book_status_id"));
                    bookStatus.setStatusName(rs.getString("STATUS_NAME"));

                    Shelf shelf = new Shelf();
                    shelf.setId(rs.getLong("shelf_id"));
                    shelf.setShelfName(rs.getString("NAME"));

                    BookTip bookTip = new BookTip();
                    bookTip.setId(rs.getLong("book_tip_id"));
                    bookTip.setTipName(rs.getString("TIP"));

                    Book book = new Book();
                    book.setRowNum(rs.getLong("r"));
                    book.setId(rs.getLong("ID"));
                    book.setCopies(rs.getInt("COPIES"));
                    book.setTitle(rs.getString("TITLE"));
                    book.setPrice(rs.getFloat("PRICE"));
                    book.setPageNum(rs.getLong("PAGE_NUM"));

                    book.setShelf(shelf);
                    book.setBookStatus(bookStatus);
                    book.setBookTip(bookTip);

                    bookList.add(book);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return bookList;
    }

    @Override
    public List<Menu> searchMenu(String keyword) throws Exception {
        List<Menu> menuList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,MENU_NAME,PRICE FROM MENU WHERE (ACTIVE = 1 )AND (LOWER(MENU_NAME) LIKE LOWER(?) OR LOWER(PRICE) LIKE LOWER(?))";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("ID"));
                    menu.setRowNum(rs.getLong("r"));
                    menu.setMenuName(rs.getString("MENU_NAME"));
                    menu.setPrice(rs.getFloat("PRICE"));

                    menuList.add(menu);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return menuList;
    }

    @Override
    public List<TableOrder> searchTableOrder(String keyword) throws Exception {
        List<TableOrder> tableOrderList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM            r,\n"
                + "       TABLE_ORDER.ID,\n"
                + "       TABLE_ORDER.RES_NAME,\n"
                + "       LIB_TABLE.ID      table_id,\n"
                + "       LIB_TABLE.LIB_TABLE,\n"
                + "       ONLY_ORDER.ID     order_id,\n"
                + "       ONLY_ORDER.NUM,\n"
                + "       ONLY_ORDER.PRICE,\n"
                + "       ONLY_ORDER.T_ORDER,\n"
                + "       MENU.ID           menu_id,\n"
                + "       MENU.MENU_NAME\n"
                + "  FROM TABLE_ORDER\n"
                + "       INNER JOIN LIB_TABLE ON LIB_TABLE.ID = TABLE_ORDER.TABLE_ID\n"
                + "       INNER JOIN ONLY_ORDER ON ONLY_ORDER.ID = TABLE_ORDER.ONLY_ORDER_ID\n"
                + "       INNER JOIN MENU ON ONLY_ORDER.MENU_ID = MENU.ID\n"
                + " WHERE        TABLE_ORDER.ACTIVE = 1\n"
                + "          AND LOWER (TABLE_ORDER.RES_NAME) LIKE LOWER (?)\n"
                + "       OR LOWER (LIB_TABLE.LIB_TABLE) LIKE LOWER (?)\n"
                + "       OR LOWER (ONLY_ORDER.NUM) LIKE LOWER (?)\n"
                + "       OR LOWER (ONLY_ORDER.PRICE) LIKE LOWER (?)\n"
                + "       OR LOWER (ONLY_ORDER.T_ORDER) LIKE LOWER (?)\n"
                + "       OR LOWER (MENU.MENU_NAME) LIKE LOWER (?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                ps.setString(6, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    OnlyOrder order = new OnlyOrder();
                    order.setId(rs.getLong("order_id"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("PRICE"));

                    order.setMenu(menu);

                    Table table = new Table();
                    table.setId(rs.getLong("table_id"));
                    table.setName(rs.getString("LIB_TABLE"));

                    TableOrder tableOrder = new TableOrder();
                    tableOrder.setRowNum(rs.getLong("r"));
                    tableOrder.setId(rs.getLong("ID"));
                    tableOrder.setResName(rs.getString("RES_NAME"));
                    tableOrder.setTable(table);
                    tableOrder.setOrder(order);

                    tableOrderList.add(tableOrder);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return tableOrderList;
    }

    @Override
    public List<Product> searchProduct(String keyword) throws Exception {
        List<Product> productList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM     r,\n"
                + "       ID,\n"
                + "       PRODUCT_NAME,\n"
                + "       NUM,\n"
                + "       PRICE,\n"
                + "       AMOUNT\n"
                + "  FROM PRODUCT\n"
                + " WHERE    ACTIVE = 1 AND LOWER (PRODUCT_NAME) LIKE LOWER (?)\n"
                + "       OR LOWER (NUM) LIKE LOWER (?)\n"
                + "       OR LOWER (PRICE) LIKE LOWER (?)\n"
                + "       OR LOWER (AMOUNT) LIKE LOWER (?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setRowNum(rs.getLong("r"));
                    product.setId(rs.getLong("ID"));
                    product.setProductName(rs.getString("PRODUCT_NAME"));
                    product.setNum(rs.getInt("NUM"));
                    product.setPrice(rs.getFloat("PRICE"));
                    product.setAmount(rs.getFloat("AMOUNT"));

                    productList.add(product);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return productList;
    }

    @Override
    public List<Employee> searchEmployee(String keyword) throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM     r,\n"
                + "       ID,\n"
                + "       NAME,\n"
                + "       SURNAME,\n"
                + "       PHONE,\n"
                + "       ADRESS,\n"
                + "       WORK_DAY,\n"
                + "       SALARY,\n"
                + "       EMAIL\n"
                + "  FROM EMPLOYEE\n"
                + " WHERE    ACTIVE = 1 AND LOWER (NAME) LIKE LOWER (?)\n"
                + "       OR LOWER (SURNAME) LIKE LOWER (?)\n"
                + "       OR LOWER (PHONE) LIKE LOWER (?)\n"
                + "       OR LOWER (ADRESS) LIKE LOWER (?)\n"
                + "       OR LOWER (WORK_DAY) LIKE LOWER (?)\n"
                + "       OR LOWER (SALARY) LIKE LOWER (?)\n"
                + "       OR LOWER (EMAIL) LIKE LOWER (?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                ps.setString(6, "%" + keyword + "%");
                ps.setString(7, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setRowNum(rs.getLong("r"));
                    employee.setId(rs.getLong("ID"));
                    employee.setName(rs.getString("NAME"));
                    employee.setSurname(rs.getString("SURNAME"));
                    employee.setPhone(rs.getString("PHONE"));
                    employee.setAddress(rs.getString("ADRESS"));
                    employee.setWorkDay(rs.getString("WORK_DAY"));
                    employee.setSalary(rs.getFloat("SALARY"));
                    employee.setEmail(rs.getString("EMAIL"));

                    employeeList.add(employee);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return employeeList;
    }

    @Override
    public List<SendEmail> searchEmail(String keyword) throws Exception {
        List<SendEmail> sendEmailList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM               r,\n"
                + "       SEND_EMAIL.ID,\n"
                + "       SEND_EMAIL.MESSAGE,\n"
                + "       STUDENT.ID           student_id,\n"
                + "       STUDENT.NAME,\n"
                + "       STUDENT.SURNAME,\n"
                + "       STUDENT.EMAIL,\n"
                + "       EMPLOYEE.ID          employee_id,\n"
                + "       EMPLOYEE.NAME        employee_name,\n"
                + "       EMPLOYEE.SURNAME     employee_surname\n"
                + "  FROM SEND_EMAIL\n"
                + "       INNER JOIN STUDENT ON STUDENT.ID = SEND_EMAIL.STUDENT_ID\n"
                + "       INNER JOIN EMPLOYEE ON EMPLOYEE.ID = SEND_EMAIL.EMPLOYEE_ID\n"
                + " WHERE    SEND_EMAIL.ACTIVE = 1 AND LOWER (SEND_EMAIL.MESSAGE) LIKE LOWER (?)\n"
                + "       OR LOWER (STUDENT.NAME) LIKE LOWER (?)\n"
                + "       OR LOWER (STUDENT.SURNAME) LIKE LOWER (?)\n"
                + "       OR LOWER (STUDENT.EMAIL) LIKE LOWER (?)\n"
                + "       OR LOWER (EMPLOYEE.NAME) LIKE LOWER (?)\n"
                + "       OR LOWER (EMPLOYEE.SURNAME) LIKE LOWER (?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                ps.setString(6, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getLong("student_id"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setEmail(rs.getString("EMAIL"));

                    Employee employee = new Employee();
                    employee.setId(rs.getLong("employee_id"));
                    employee.setName(rs.getString("employee_name"));
                    employee.setSurname(rs.getString("employee_surname"));

                    SendEmail sendEmail = new SendEmail();
                    sendEmail.setRowNum(rs.getLong("r"));
                    sendEmail.setId(rs.getLong("ID"));
                    sendEmail.setMessage(rs.getString("MESSAGE"));

                    sendEmail.setStudent(student);
                    sendEmail.setEmployee(employee);

                    sendEmailList.add(sendEmail);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return sendEmailList;
    }

    @Override
    public List<OrderBook> searchOrderBook(String keyword, Long statusId) throws Exception {
        List<OrderBook> orderBookList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM               r,\n"
                + "       ORDER_BOOK.ID,\n"
                + "       ORDER_BOOK.BORROW_TIME,\n"
                + "       ORDER_BOOK.PRICE     BORROW_PRICE,\n"
                + "       BOOK.ID              book_id,\n"
                + "       BOOK.TITLE,\n"
                + "       BOOK.COPIES,\n"
                + "       BOOK.PAGE_NUM,\n"
                + "       BOOK_STATUS.ID       book_status_id,\n"
                + "       BOOK_STATUS.STATUS_NAME,\n"
                + "       STUDENT.ID           student_id,\n"
                + "       STUDENT.NAME,\n"
                + "       STUDENT.SURNAME,\n"
                + "       STUDENT.EMAIL,\n"
                + "       STUDENT.PHONE,\n"
                + "       STUDENT.STUDENT_GROUP,\n"
                + "       BOOK.PRICE           book_price\n"
                + "  FROM ORDER_BOOK\n"
                + "       INNER JOIN STUDENT ON STUDENT.ID = ORDER_BOOK.STUDENT_ID\n"
                + "       INNER JOIN BOOK ON BOOK.ID = ORDER_BOOK.BOOK_ID\n"
                + "       INNER JOIN BOOK_STATUS ON BOOK_STATUS.ID = ORDER_BOOK.BOOK_STATUS_ID\n"
                + " WHERE        (ORDER_BOOK.ACTIVE = 1 AND BOOK_STATUS.ID = ?)\n"
                + "          AND ( LOWER (ORDER_BOOK.BORROW_TIME) LIKE LOWER (?)\n"
                + "       OR LOWER (BOOK.TITLE) LIKE LOWER (?)\n"
                + "       OR LOWER (BOOK.COPIES) LIKE LOWER (?)\n"
                + "       OR LOWER (BOOK.PAGE_NUM) LIKE LOWER (?)\n"
                + "       OR LOWER (STUDENT.NAME) LIKE LOWER (?)\n"
                + "       OR LOWER (STUDENT.SURNAME) LIKE LOWER (?)\n"
                + "       OR LOWER (STUDENT.EMAIL) LIKE LOWER (?)\n"
                + "       OR LOWER (STUDENT.PHONE) LIKE LOWER (?)\n"
                + "       OR LOWER (STUDENT.STUDENT_GROUP) LIKE LOWER (?)\n"
                + "       OR LOWER (BOOK.PRICE) LIKE LOWER (?) )";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, statusId);
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setString(4, "%" + keyword + "%");
                ps.setString(5, "%" + keyword + "%");
                ps.setString(6, "%" + keyword + "%");
                ps.setString(7, "%" + keyword + "%");
                ps.setString(8, "%" + keyword + "%");
                ps.setString(9, "%" + keyword + "%");
                ps.setString(10, "%" + keyword + "%");
                ps.setString(11, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    OrderBook orderBook = new OrderBook();
                    orderBook.setRowNum(rs.getLong("r"));
                    orderBook.setId(rs.getLong("ID"));
                    orderBook.setBorrowTime(rs.getDate("BORROW_TIME"));
                    orderBook.setPrice(rs.getFloat("BORROW_PRICE"));

                    Book book = new Book();
                    book.setId(rs.getLong("book_id"));
                    book.setCopies(rs.getInt("COPIES"));
                    book.setTitle(rs.getString("TITLE"));
                    book.setPrice(rs.getFloat("book_price"));
                    book.setPageNum(rs.getLong("PAGE_NUM"));

                    Student student = new Student();
                    student.setId(rs.getLong("student_id"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setGroup(rs.getString("STUDENT_GROUP"));
                    student.setPhone(rs.getString("PHONE"));
                    student.setEmail(rs.getString("EMAIL"));

                    BookStatus status = new BookStatus();
                    status.setId(rs.getLong("book_status_id"));
                    status.setStatusName(rs.getString("STATUS_NAME"));

                    orderBook.setBook(book);
                    orderBook.setStudent(student);
                    orderBook.setBookStatus(status);

                    orderBookList.add(orderBook);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return orderBookList;
    }

    @Override
    public List<Book> advancedSearchBook(AdvancedSearch advancedSearch) throws Exception {
        List<Book> bookList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM             r, "
                + "       BOOK.ID, "
                + "       BOOK.TITLE, "
                + "       BOOK.COPIES, "
                + "       BOOK.PRICE, "
                + "       BOOK_STATUS.ID     book_status_id, "
                + "       BOOK_TIP.ID        book_tip_id, "
                + "       BOOK_STATUS.STATUS_NAME, "
                + "       BOOK_TIP.TIP, "
                + "       SHELF.ID           shelf_id, "
                + "       SHELF.NAME, "
                + "       BOOK.PAGE_NUM "
                + "  FROM BOOK "
                + "       INNER JOIN BOOK_STATUS ON BOOK_STATUS.ID = BOOK.BOOK_STATUS_ID "
                + "       INNER JOIN BOOK_TIP ON BOOK_TIP.ID = BOOK.BOOK_TIP_ID "
                + "       INNER JOIN SHELF ON SHELF.ID = BOOK.SHELF_ID "
                + " WHERE BOOK.ACTIVE = 1 ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (advancedSearch.getBookTipId() != null) {
                    sql += " AND BOOK_TIP.ID = " + advancedSearch.getBookTipId();
                }
                if (advancedSearch.getMinCopies() != null && !advancedSearch.getMinCopies().isEmpty()) {
                    sql += " AND BOOK.COPIES > " + advancedSearch.getMinCopies();
                }
                if (advancedSearch.getMaxCopies() != null && !advancedSearch.getMaxCopies().isEmpty()) {
                    sql += " AND BOOK.COPIES < " + advancedSearch.getMaxCopies();
                }
                if (advancedSearch.getMinPageNum() != null && !advancedSearch.getMinPageNum().isEmpty()) {
                    sql += " AND BOOK.PAGE_NUM > " + advancedSearch.getMinPageNum();
                }
                if (advancedSearch.getMaxPageNum() != null && !advancedSearch.getMaxPageNum().isEmpty()) {
                    sql += " AND BOOK.PAGE_NUM < " + advancedSearch.getMaxPageNum();
                }
                if (advancedSearch.getMinPrice() != 0) {
                    sql += " AND BOOK.PRICE > " + advancedSearch.getMinPrice();
                }
                if (advancedSearch.getMaxPrice() != 0) {
                    sql += " AND BOOK.PRICE < " + advancedSearch.getMaxPrice();
                }
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    BookStatus bookStatus = new BookStatus();
                    bookStatus.setId(rs.getLong("book_status_id"));
                    bookStatus.setStatusName(rs.getString("STATUS_NAME"));

                    Shelf shelf = new Shelf();
                    shelf.setId(rs.getLong("shelf_id"));
                    shelf.setShelfName(rs.getString("NAME"));

                    BookTip bookTip = new BookTip();
                    bookTip.setId(rs.getLong("book_tip_id"));
                    bookTip.setTipName(rs.getString("TIP"));

                    Book book = new Book();
                    book.setRowNum(rs.getLong("r"));
                    book.setId(rs.getLong("ID"));
                    book.setCopies(rs.getInt("COPIES"));
                    book.setTitle(rs.getString("TITLE"));
                    book.setPrice(rs.getFloat("PRICE"));
                    book.setPageNum(rs.getLong("PAGE_NUM"));

                    book.setShelf(shelf);
                    book.setBookStatus(bookStatus);
                    book.setBookTip(bookTip);

                    bookList.add(book);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return bookList;
    }

    @Override
    public List<Product> advancedSearchProduct(AdvancedSearch advancedSearch) throws Exception {
        List<Product> productList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,ID,PRODUCT_NAME,NUM,PRICE,AMOUNT FROM PRODUCT WHERE ACTIVE = 1 ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (advancedSearch.getMinNum() != null && !advancedSearch.getMinNum().isEmpty()) {
                    sql += " AND NUM > " + advancedSearch.getMinNum();
                }
                if (advancedSearch.getMaxNum() != null && !advancedSearch.getMaxNum().isEmpty()) {
                    sql += " AND NUM < " + advancedSearch.getMaxNum();
                }
                if (advancedSearch.getMinPrice() != null) {
                    sql += " AND PRICE > " + advancedSearch.getMinPrice();
                }
                if (advancedSearch.getMaxPrice() != null) {
                    sql += " AND PRICE < " + advancedSearch.getMaxPrice();
                }
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Product product = new Product();
                    product.setRowNum(rs.getLong("r"));
                    product.setId(rs.getLong("ID"));
                    product.setProductName(rs.getString("PRODUCT_NAME"));
                    product.setNum(rs.getInt("NUM"));
                    product.setPrice(rs.getFloat("PRICE"));
                    product.setAmount(rs.getFloat("AMOUNT"));

                    productList.add(product);
                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return productList;
    }

    @Override
    public boolean add(Paid paid) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO PAID(ID,TABLE_ORDER_ID,PRICE) "
                + " VALUES(PAID_SEQ.NEXTVAL,?,?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, paid.getTableOrder().getId());
                ps.setFloat(2, paid.getPrice());
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean deleteTableOrderByTableId(Long tableId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE TABLE_ORDER SET ACTIVE = 0 WHERE TABLE_ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, tableId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public List<Paid> searchPaid(String keyword) throws Exception {
        List<Paid> paidList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM               r,\n"
                + "       PAID.ID,\n"
                + "       PAID.PRICE,\n"
                + "       PAID.PAID_DATE,\n"
                + "       TABLE_ORDER.ID       table_order_id,\n"
                + "       TABLE_ORDER.RES_NAME,\n"
                + "       LIB_TABLE.ID         table_id,\n"
                + "       LIB_TABLE.LIB_TABLE,\n"
                + "       ONLY_ORDER.ID        order_id,\n"
                + "       ONLY_ORDER.NUM,\n"
                + "       ONLY_ORDER.PRICE     order_price,\n"
                + "       ONLY_ORDER.T_ORDER,\n"
                + "       MENU.ID              menu_id,\n"
                + "       MENU.MENU_NAME\n"
                + "  FROM PAID\n"
                + "       INNER JOIN TABLE_ORDER ON TABLE_ORDER.ID = PAID.TABLE_ORDER_ID\n"
                + "       INNER JOIN LIB_TABLE ON LIB_TABLE.ID = TABLE_ORDER.TABLE_ID\n"
                + "       INNER JOIN ONLY_ORDER ON ONLY_ORDER.ID = TABLE_ORDER.ONLY_ORDER_ID\n"
                + "       INNER JOIN MENU ON ONLY_ORDER.MENU_ID = MENU.ID\n"
                + " WHERE    PAID.ACTIVE = 1 AND LOWER (PAID.PRICE) LIKE LOWER (?)\n"
                + "       OR LOWER (LIB_TABLE.LIB_TABLE) LIKE LOWER (?)";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    OnlyOrder order = new OnlyOrder();
                    order.setId(rs.getLong("order_id"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("order_price"));

                    order.setMenu(menu);

                    Table table = new Table();
                    table.setId(rs.getLong("table_id"));
                    table.setName(rs.getString("LIB_TABLE"));

                    TableOrder tableOrder = new TableOrder();
                    tableOrder.setId(rs.getLong("table_order_id"));
                    tableOrder.setResName(rs.getString("RES_NAME"));
                    tableOrder.setTable(table);
                    tableOrder.setOrder(order);

                    Paid paid = new Paid();
                    paid.setRowNum(rs.getLong("r"));
                    paid.setId(rs.getLong("ID"));
                    paid.setPaidDate(rs.getDate("PAID_DATE"));
                    paid.setPrice(rs.getFloat("PRICE"));
                    paid.setTableOrder(tableOrder);

                    paidList.add(paid);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return paidList;
    }

    @Override
    public List<Paid> advancedSearchPaid(AdvancedSearch advancedSearch) throws Exception {
        List<Paid> paidList = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,PAID.ID, PAID.PRICE,PAID.PAID_DATE,TABLE_ORDER.ID table_order_id, "
                + " TABLE_ORDER.RES_NAME,LIB_TABLE.ID table_id, "
                + " LIB_TABLE.LIB_TABLE,ONLY_ORDER.ID order_id, "
                + " ONLY_ORDER.NUM,ONLY_ORDER.PRICE order_price, "
                + " ONLY_ORDER.T_ORDER, "
                + " MENU.ID menu_id, "
                + " MENU.MENU_NAME  "
                + " FROM PAID "
                + " INNER JOIN TABLE_ORDER ON TABLE_ORDER.ID = PAID.TABLE_ORDER_ID "
                + " INNER JOIN LIB_TABLE ON LIB_TABLE.ID  = TABLE_ORDER.TABLE_ID "
                + " INNER JOIN ONLY_ORDER ON ONLY_ORDER.ID  = TABLE_ORDER.ONLY_ORDER_ID "
                + " INNER JOIN MENU ON ONLY_ORDER.MENU_ID = MENU.ID WHERE PAID.ACTIVE = 1 ";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                if (advancedSearch.getBeginDate() != null) {
                    sql += " AND PAID.PAID_DATE >= TO_DATE('" + new java.sql.Date(advancedSearch.getBeginDate().getTime()) + "' , 'YYYY-MM-DD')";
                }
                if (advancedSearch.getEndDate() != null) {
                    sql += " AND PAID.PAID_DATE <= TO_DATE('" + new java.sql.Date(advancedSearch.getEndDate().getTime()) + "' , 'YYYY-MM-DD')";
                }
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    OnlyOrder order = new OnlyOrder();
                    order.setId(rs.getLong("order_id"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("order_price"));

                    order.setMenu(menu);

                    Table table = new Table();
                    table.setId(rs.getLong("table_id"));
                    table.setName(rs.getString("LIB_TABLE"));

                    TableOrder tableOrder = new TableOrder();
                    tableOrder.setId(rs.getLong("table_order_id"));
                    tableOrder.setResName(rs.getString("RES_NAME"));
                    tableOrder.setTable(table);
                    tableOrder.setOrder(order);

                    Paid paid = new Paid();
                    paid.setRowNum(rs.getLong("r"));
                    paid.setId(rs.getLong("ID"));
                    paid.setPaidDate(rs.getDate("PAID_DATE"));
                    paid.setPrice(rs.getFloat("PRICE"));
                    paid.setTableOrder(tableOrder);

                    paidList.add(paid);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return paidList;
    }

    @Override
    public boolean deletePaid(Long paidId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PAID SET ACTIVE = 0 WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, paidId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public Paid getPaidById(Long paidId) throws Exception {
        Paid paid = new Paid();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ROWNUM r,PAID.ID, PAID.PRICE,PAID.PAID_DATE,TABLE_ORDER.ID table_order_id, "
                + " TABLE_ORDER.RES_NAME,LIB_TABLE.ID table_id, "
                + " LIB_TABLE.LIB_TABLE,ONLY_ORDER.ID order_id, "
                + " ONLY_ORDER.NUM,ONLY_ORDER.PRICE order_price, "
                + " ONLY_ORDER.T_ORDER, "
                + " MENU.ID menu_id, "
                + " MENU.MENU_NAME  "
                + " FROM PAID "
                + " INNER JOIN TABLE_ORDER ON TABLE_ORDER.ID = PAID.TABLE_ORDER_ID "
                + " INNER JOIN LIB_TABLE ON LIB_TABLE.ID  = TABLE_ORDER.TABLE_ID "
                + " INNER JOIN ONLY_ORDER ON ONLY_ORDER.ID  = TABLE_ORDER.ONLY_ORDER_ID "
                + " INNER JOIN MENU ON ONLY_ORDER.MENU_ID = MENU.ID WHERE PAID.ACTIVE = 1 AND PAID.ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, paidId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getLong("menu_id"));
                    menu.setMenuName(rs.getString("MENU_NAME"));

                    OnlyOrder order = new OnlyOrder();
                    order.setId(rs.getLong("order_id"));
                    order.setNum(rs.getInt("NUM"));
                    order.settOrder(rs.getString("T_ORDER"));
                    order.setPrice(rs.getFloat("order_price"));

                    order.setMenu(menu);

                    Table table = new Table();
                    table.setId(rs.getLong("table_id"));
                    table.setName(rs.getString("LIB_TABLE"));

                    TableOrder tableOrder = new TableOrder();
                    tableOrder.setId(rs.getLong("table_order_id"));
                    tableOrder.setResName(rs.getString("RES_NAME"));
                    tableOrder.setTable(table);
                    tableOrder.setOrder(order);

                    paid.setRowNum(rs.getLong("r"));
                    paid.setId(rs.getLong("ID"));
                    paid.setPaidDate(rs.getDate("PAID_DATE"));
                    paid.setPrice(rs.getFloat("PRICE"));
                    paid.setTableOrder(tableOrder);

                }
            } else {
                System.out.println("Connection is failuare!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utility.close(c, ps, rs);
        }

        return paid;

    }

    @Override
    public boolean updatePaid(Paid paid, Long paidId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE PAID SET PRICE = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setFloat(1, paid.getPrice());
                ps.setLong(2, paidId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public boolean changeTableInPaidTable(Long tableId, Long tableOrderId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE TABLE_ORDER SET TABLE_ID = ? WHERE ID = ?";
        try {
            c = DbHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, tableId);
                ps.setLong(2, tableOrderId);
                ps.execute();
                result = true;
                c.commit();
            } else {
                System.out.println("Connection is failuare!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            util.Utility.close(c, ps, null);
        }
        return result;
    }

}
