package library;

import dao.DaoImpl;
import enums.BookType;
import static enums.Enums.*;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import model.AdvancedSearch;
import model.Author;
import model.Book;
import model.BookTip;
import model.Employee;
import model.Item;
import model.Menu;
import model.Note;
import model.OrderBook;
import model.Paid;
import model.Product;
import model.SendEmail;
import model.Student;
import model.Table;
import model.TableOrder;

public class LibraryFrame extends ColumnSize {
    
    private DaoImpl dao;
    private JFrame frame;
    private String globCheckName = "0";
    private int id;
    private int isDeleteMsg;
    private ColumnSize columnSize;
    private HideId hide;
    
    public LibraryFrame() {
        hide = new HideId();
        columnSize = new ColumnSize();
        initComponents();
        
    }
    
    Timer updateTimer;
    int DELAY = 1;
    
    LibraryFrame(DaoImpl dao) {
        hide = new HideId();
        columnSize = new ColumnSize();
        try {
            initComponents();
            this.dao = dao;
            tablePageHover.setOpaque(false);
            studentPageHover.setOpaque(false);
            authorPageHover.setOpaque(false);
            orderPageHover.setOpaque(false);
            emailPageHover.setOpaque(false);
            calcPageHover.setOpaque(false);
            bookPageHover.setOpaque(false);
            menuPageHover.setOpaque(false);
            employeePageHover.setOpaque(false);
            
            frame = null;
            
            Calendar cal = Calendar.getInstance();
            cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            time.setText(sdf.format(cal.getTime()));
            SimpleDateFormat dateSdf = new SimpleDateFormat("dd.MM.yyyy");
            date.setText(dateSdf.format(cal.getTime()));
            
            updateTimer = new Timer(DELAY, new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    Date currentTime = new Date();
                    String formatTimeStr = "HH:mm:ss";
                    DateFormat formatTime = new SimpleDateFormat(formatTimeStr);
                    String formattedTimeStr = formatTime.format(currentTime);
                    
                    time.setText(formattedTimeStr);
                    
                }
            });
            
            updateTimer.start();
            
            Font f = new Font("Calibri", Font.ITALIC, 18);
            JTableHeader header = warningTable.getTableHeader();
            header.setFont(f);
            header.setForeground(Color.black);
            
            ((DefaultTableCellRenderer) header.getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.CENTER);

//        warningTable.getTableHeader().setOpaque(false);
//        warningTable.getTableHeader().setBackground(new Color(0).red);
            tablePageContentOnLay.setVisible(false);
            studentsPageContentOnLay.setVisible(false);
            bookPageContentOnLay.setVisible(false);
            authorPageContentOnLay.setVisible(false);
            menuPageContentOnLay.setVisible(false);
            orderPageContentOnLay.setVisible(false);
            calcPageContentOnLay.setVisible(false);
            emailPageContentOnLay.setVisible(false);
            employeePageContentOnLay.setVisible(false);
            orderBookPageContentOnLay.setVisible(false);
            bookAdvancedSearchPageContentOnLay.setVisible(false);

            ////
            soldBookPageContentOnLay.setVisible(false);
            borrowBookPageContentOnLay.setVisible(false);
            ////
            List<Author> authorList = dao.getAuthorList();
            ViewAuthorListInTable(authorList);
            
            List<Student> studentList = dao.getStudentList();
            ViewStudentListInTable(studentList);
            
            List<Employee> employeeList = dao.getEmployeeList();
            ViewEmployeeListInTable(employeeList);
            
            List<Book> bookList = dao.getBookList();
            ViewBookListInTable(bookList);
            
            List<Menu> menuList = dao.getMenuList();
            ViewMenuListInTable(menuList);
            
            List<Product> productList = dao.getProductList();
            ViewProductListInTable(productList);
            
            List<SendEmail> sendEmailList = dao.getSendEmailList();
            ViewSendEmailList(sendEmailList);
            
            for (Student student : studentList) {
                studentsNumText.setText(student.getRowNum().toString());
            }
            for (Book book : bookList) {
                bookNumText.setText(book.getRowNum().toString());
            }
            for (Employee employee : employeeList) {
                employeeNumText.setText(employee.getRowNum().toString());
            }
            
            Font f2 = new Font("Calibri", Font.ITALIC, 18);
            JTableHeader header2 = notesTable.getTableHeader();
            header2.setFont(f2);
            
            List<Note> noteList = dao.getNoteList();
            ViewNoteListInTable(noteList);
            
            List<TableOrder> tableOrderList = dao.getTableOrderList();
            ViewTableOrderListInTable(tableOrderList);
            
            List<Paid> paidList = dao.getPaidList();
            ViewPaidListInTable(paidList);
            
            String protocol = "imap";
            String host = "imap.gmail.com";
            String port = "993";
            
            String userName = "bshelf17@gmail.com";
            String password = "mamed2001";
            
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        mainPage = new javax.swing.JPanel();
        mainPageIcon = new javax.swing.JLabel();
        mainPageHover = new javax.swing.JLabel();
        mainPageText = new javax.swing.JLabel();
        tablePage = new javax.swing.JPanel();
        tablePageHover = new javax.swing.JLabel();
        tablePageIcon = new javax.swing.JLabel();
        tablePageText = new javax.swing.JLabel();
        studentPage = new javax.swing.JPanel();
        studentPageHover = new javax.swing.JLabel();
        studentPageIcon = new javax.swing.JLabel();
        studentPageText = new javax.swing.JLabel();
        bookPage = new javax.swing.JPanel();
        bookPageHover = new javax.swing.JLabel();
        bookPageIcon = new javax.swing.JLabel();
        bookPageText = new javax.swing.JLabel();
        authorPage = new javax.swing.JPanel();
        authorPageHover = new javax.swing.JLabel();
        authorPageIcon = new javax.swing.JLabel();
        authorPageText = new javax.swing.JLabel();
        menuPage = new javax.swing.JPanel();
        menuPageHover = new javax.swing.JLabel();
        menuPageIcon = new javax.swing.JLabel();
        menuPageText = new javax.swing.JLabel();
        orderPage = new javax.swing.JPanel();
        orderPageHover = new javax.swing.JLabel();
        orderPageIcon = new javax.swing.JLabel();
        orderPageText = new javax.swing.JLabel();
        calcPage = new javax.swing.JPanel();
        calcPageHover = new javax.swing.JLabel();
        calcPageIcon = new javax.swing.JLabel();
        calcPageText = new javax.swing.JLabel();
        emailPage = new javax.swing.JPanel();
        emailPageHover = new javax.swing.JLabel();
        emailPageIcon = new javax.swing.JLabel();
        emailPageText = new javax.swing.JLabel();
        logo = new javax.swing.JPanel();
        logoIcon = new javax.swing.JLabel();
        logoText = new javax.swing.JLabel();
        employeePage = new javax.swing.JPanel();
        employeePageHover = new javax.swing.JLabel();
        employeePageIcon = new javax.swing.JLabel();
        employeePageText = new javax.swing.JLabel();
        mainPageContent = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        userIcon = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        userSurname = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        mainPageLay = new javax.swing.JLayeredPane();
        mainPageContentOnLay = new javax.swing.JPanel();
        studentsNum = new javax.swing.JPanel();
        studentsNumText = new javax.swing.JLabel();
        studentsIcon = new javax.swing.JLabel();
        studentsText = new javax.swing.JLabel();
        studentsMoreInfo = new javax.swing.JPanel();
        studentsMoreInfoIcon = new javax.swing.JLabel();
        studentsMoreInfoText = new javax.swing.JLabel();
        bookNum = new javax.swing.JPanel();
        bookIcon = new javax.swing.JLabel();
        bookNumText = new javax.swing.JLabel();
        bookMoreInfo = new javax.swing.JPanel();
        bookMoreInfoText = new javax.swing.JLabel();
        bookMoreInfoIcon = new javax.swing.JLabel();
        bookText = new javax.swing.JLabel();
        employeeNum = new javax.swing.JPanel();
        employeeIcon = new javax.swing.JLabel();
        employeeNumText = new javax.swing.JLabel();
        employeeMoreInfo = new javax.swing.JPanel();
        employeeMoreInfoIcon = new javax.swing.JLabel();
        employeeMoreInfoText = new javax.swing.JLabel();
        employeeText = new javax.swing.JLabel();
        warningBoard = new javax.swing.JPanel();
        warningBoardHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        warningTable = new javax.swing.JTable();
        event = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        notesTable = new javax.swing.JTable();
        eventIcon = new javax.swing.JLabel();
        eventText = new javax.swing.JLabel();
        addEvent = new javax.swing.JButton();
        tablePageLay = new javax.swing.JLayeredPane();
        tablePageContentOnLay = new javax.swing.JPanel();
        masa1 = new javax.swing.JButton();
        masa2 = new javax.swing.JButton();
        masa3 = new javax.swing.JButton();
        masa4 = new javax.swing.JButton();
        masa5 = new javax.swing.JButton();
        masa6 = new javax.swing.JButton();
        masa7 = new javax.swing.JButton();
        masa8 = new javax.swing.JButton();
        masa9 = new javax.swing.JButton();
        masa10 = new javax.swing.JButton();
        masa11 = new javax.swing.JButton();
        masa12 = new javax.swing.JButton();
        masa13 = new javax.swing.JButton();
        masa14 = new javax.swing.JButton();
        masa15 = new javax.swing.JButton();
        masa16 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        masa17 = new javax.swing.JButton();
        masa18 = new javax.swing.JButton();
        masa19 = new javax.swing.JButton();
        masa20 = new javax.swing.JButton();
        shelf1 = new javax.swing.JButton();
        shelf2 = new javax.swing.JButton();
        shelf3 = new javax.swing.JButton();
        shelf5 = new javax.swing.JButton();
        shelf4 = new javax.swing.JButton();
        shelf6 = new javax.swing.JButton();
        masa22 = new javax.swing.JButton();
        masa21 = new javax.swing.JButton();
        masa23 = new javax.swing.JButton();
        masa24 = new javax.swing.JButton();
        masa25 = new javax.swing.JButton();
        masa26 = new javax.swing.JButton();
        masa27 = new javax.swing.JButton();
        masa28 = new javax.swing.JButton();
        masa29 = new javax.swing.JButton();
        masa30 = new javax.swing.JButton();
        masa31 = new javax.swing.JButton();
        masa32 = new javax.swing.JButton();
        masa33 = new javax.swing.JButton();
        masa34 = new javax.swing.JButton();
        masa35 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        masa36 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        masa37 = new javax.swing.JButton();
        masa38 = new javax.swing.JButton();
        masa39 = new javax.swing.JButton();
        masa40 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        shelf7 = new javax.swing.JButton();
        shelf9 = new javax.swing.JButton();
        shelf11 = new javax.swing.JButton();
        shelf12 = new javax.swing.JButton();
        shelf10 = new javax.swing.JButton();
        shelf8 = new javax.swing.JButton();
        emptyTableCheck = new javax.swing.JCheckBox();
        allTableCheck = new javax.swing.JCheckBox();
        emptyText = new javax.swing.JLabel();
        emptyTableNum = new javax.swing.JLabel();
        addOrderToTable = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator20 = new javax.swing.JSeparator();
        studentsPageLay = new javax.swing.JLayeredPane();
        studentsPageContentOnLay = new javax.swing.JPanel();
        studentsTablePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        studentsNumber = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        searchForStudents = new javax.swing.JTextField();
        searchBtn = new javax.swing.JPanel();
        searchText = new javax.swing.JLabel();
        addStudentIcon = new javax.swing.JLabel();
        refreshStudent = new javax.swing.JLabel();
        bookPageLay = new javax.swing.JLayeredPane();
        bookPageContentOnLay = new javax.swing.JPanel();
        bookTablePanel = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        searchForBook = new javax.swing.JTextField();
        searchBookBtn = new javax.swing.JPanel();
        searchText1 = new javax.swing.JLabel();
        advancedSearchBookBtn = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        addBook = new javax.swing.JLabel();
        orderBook = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        refreshBook = new javax.swing.JLabel();
        bookAdvancedSearchPageLay = new javax.swing.JLayeredPane();
        bookAdvancedSearchPageContentOnLay = new javax.swing.JPanel();
        bookAdvancedSearchTablePanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        tipCombo = new javax.swing.JComboBox<>();
        minCopies = new javax.swing.JTextField();
        maxCopies = new javax.swing.JTextField();
        minPrice = new javax.swing.JTextField();
        maxPrice = new javax.swing.JTextField();
        minPageNum = new javax.swing.JTextField();
        maxPageNum = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        advancedBookTable = new javax.swing.JTable();
        searchAdvancedBook = new javax.swing.JLabel();
        authorPageLay = new javax.swing.JLayeredPane();
        authorPageContentOnLay = new javax.swing.JPanel();
        authorTablePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        authorNumber = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        authorTable = new javax.swing.JTable();
        searchForAuthor = new javax.swing.JTextField();
        searchAuthorBtn = new javax.swing.JPanel();
        searchText2 = new javax.swing.JLabel();
        addAuthor = new javax.swing.JLabel();
        refreshAuthor = new javax.swing.JLabel();
        menuPageLay = new javax.swing.JLayeredPane();
        menuPageContentOnLay = new javax.swing.JPanel();
        menuTablePanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        menuNum = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        searchForMenu = new javax.swing.JTextField();
        searchMenuBtn = new javax.swing.JPanel();
        searchText3 = new javax.swing.JLabel();
        addMenu = new javax.swing.JLabel();
        refreshMenu = new javax.swing.JLabel();
        orderPageLay = new javax.swing.JLayeredPane();
        orderPageContentOnLay = new javax.swing.JPanel();
        orderTablePanel = new javax.swing.JPanel();
        jSeparator14 = new javax.swing.JSeparator();
        jScrollPane8 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        searchForOrder = new javax.swing.JTextField();
        searchOrderBtn = new javax.swing.JPanel();
        searchText4 = new javax.swing.JLabel();
        addOrder = new javax.swing.JLabel();
        paidBtn = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        refreshOrderPage = new javax.swing.JLabel();
        calcPageLay = new javax.swing.JLayeredPane();
        calcPageContentOnLay = new javax.swing.JPanel();
        calcPageTablesPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        paidTable = new javax.swing.JTable();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        beginDate = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        endDate = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        gainMoney = new javax.swing.JTextField();
        searchForPaid = new javax.swing.JTextField();
        searchPaidBtn = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JSeparator();
        jScrollPane10 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jSeparator17 = new javax.swing.JSeparator();
        searchForProduct = new javax.swing.JTextField();
        searchProductBtn = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        minNum = new javax.swing.JTextField();
        maxNum = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        beginMoney = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        endMoney = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        searchPaidAdv = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        searchProductAdv = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        addProduct = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        refreshCalc = new javax.swing.JLabel();
        emailPageLay = new javax.swing.JLayeredPane();
        emailPageContentOnLay = new javax.swing.JPanel();
        emailTablePanel = new javax.swing.JPanel();
        newMessage = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        searchForEmail = new javax.swing.JTextField();
        searchForEmailBtn = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JSeparator();
        jScrollPane11 = new javax.swing.JScrollPane();
        sendEmailTable = new javax.swing.JTable();
        refreshEmail = new javax.swing.JLabel();
        employeePageLay = new javax.swing.JLayeredPane();
        employeePageContentOnLay = new javax.swing.JPanel();
        employeeTablePanel = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        employeeNumber = new javax.swing.JLabel();
        searchForEmployee = new javax.swing.JTextField();
        searchEmployeeBtn = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        addEmployee = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jScrollPane12 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        refreshEmployee = new javax.swing.JLabel();
        orderBookPageLay = new javax.swing.JLayeredPane();
        orderBookPageContentOnLay = new javax.swing.JPanel();
        orderBookTablePanel = new javax.swing.JPanel();
        addOrderBook = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        searchBook = new javax.swing.JTextField();
        searchBookButton = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        soldBook = new javax.swing.JCheckBox();
        borrowBook = new javax.swing.JCheckBox();
        readNowBook = new javax.swing.JCheckBox();
        refreshOrderBook = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        tableContent = new javax.swing.JPanel();
        soldBookPageLay = new javax.swing.JLayeredPane();
        soldBookPageContentOnLay = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        soldBookTable = new javax.swing.JTable();
        borrowBookPageLay = new javax.swing.JLayeredPane();
        borrowBookPageContentOnLay = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        borrowBookTable = new javax.swing.JTable();
        readNowBookPageLay = new javax.swing.JLayeredPane();
        readNowBookPageContentOnLay = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        readNowBookTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1420, 843));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(0, 102, 255));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPage.setBackground(new java.awt.Color(0, 102, 255));
        mainPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mainPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mainPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mainPageMouseExited(evt);
            }
        });
        mainPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Home_35px.png")); // NOI18N
        mainPage.add(mainPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        mainPageHover.setBackground(new java.awt.Color(255, 255, 255));
        mainPageHover.setForeground(new java.awt.Color(255, 255, 255));
        mainPageHover.setOpaque(true);
        mainPage.add(mainPageHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        mainPageText.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        mainPageText.setForeground(new java.awt.Color(255, 255, 255));
        mainPageText.setText("ƏSAS SƏHİFƏ");
        mainPage.add(mainPageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 40));

        menu.add(mainPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, 60));

        tablePage.setBackground(new java.awt.Color(0, 102, 255));
        tablePage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablePageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tablePageMouseExited(evt);
            }
        });
        tablePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePageHover.setBackground(new java.awt.Color(255, 255, 255));
        tablePage.add(tablePageHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        tablePageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Table_35px.png")); // NOI18N
        tablePage.add(tablePageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        tablePageText.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        tablePageText.setForeground(new java.awt.Color(255, 255, 255));
        tablePageText.setText("YERLƏR");
        tablePage.add(tablePageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 9, 90, 40));

        menu.add(tablePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 280, 60));

        studentPage.setBackground(new java.awt.Color(0, 102, 255));
        studentPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentPageMouseExited(evt);
            }
        });
        studentPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentPageHover.setBackground(new java.awt.Color(255, 255, 255));
        studentPage.add(studentPageHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        studentPageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Student Male_35px.png")); // NOI18N
        studentPage.add(studentPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 15, -1, -1));

        studentPageText.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        studentPageText.setForeground(new java.awt.Color(255, 255, 255));
        studentPageText.setText("TƏLƏBƏLƏR");
        studentPage.add(studentPageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 9, -1, 40));

        menu.add(studentPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 60));

        bookPage.setBackground(new java.awt.Color(0, 102, 255));
        bookPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookPageMouseExited(evt);
            }
        });
        bookPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookPageHover.setBackground(new java.awt.Color(255, 255, 255));
        bookPage.add(bookPageHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        bookPageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Book_35px.png")); // NOI18N
        bookPage.add(bookPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        bookPageText.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        bookPageText.setForeground(new java.awt.Color(255, 255, 255));
        bookPageText.setText("KİTABLAR");
        bookPage.add(bookPageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 9, -1, 40));

        menu.add(bookPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 280, 60));

        authorPage.setBackground(new java.awt.Color(0, 102, 255));
        authorPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        authorPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authorPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                authorPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                authorPageMouseExited(evt);
            }
        });
        authorPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        authorPageHover.setBackground(new java.awt.Color(255, 255, 255));
        authorPage.add(authorPageHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        authorPageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\William Shakespeare_35px.png")); // NOI18N
        authorPage.add(authorPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 40));

        authorPageText.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        authorPageText.setForeground(new java.awt.Color(255, 255, 255));
        authorPageText.setText("MÜƏLLİFLƏR");
        authorPage.add(authorPageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 40));

        menu.add(authorPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 280, 60));

        menuPage.setBackground(new java.awt.Color(0, 102, 255));
        menuPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuPageMouseExited(evt);
            }
        });
        menuPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPageHover.setBackground(new java.awt.Color(255, 255, 255));
        menuPage.add(menuPageHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        menuPageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Restaurant_35px.png")); // NOI18N
        menuPage.add(menuPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, -1, 50));

        menuPageText.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        menuPageText.setForeground(new java.awt.Color(255, 255, 255));
        menuPageText.setText("MENYU");
        menuPage.add(menuPageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 9, -1, 40));

        menu.add(menuPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 280, 60));

        orderPage.setBackground(new java.awt.Color(0, 102, 255));
        orderPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        orderPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                orderPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                orderPageMouseExited(evt);
            }
        });
        orderPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderPageHover.setBackground(new java.awt.Color(255, 255, 255));
        orderPage.add(orderPageHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        orderPageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Purchase Order_35px.png")); // NOI18N
        orderPage.add(orderPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        orderPageText.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        orderPageText.setForeground(new java.awt.Color(255, 255, 255));
        orderPageText.setText("SİFARİŞ");
        orderPage.add(orderPageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 9, -1, 40));

        menu.add(orderPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 280, 60));

        calcPage.setBackground(new java.awt.Color(0, 102, 255));
        calcPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calcPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calcPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calcPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calcPageMouseExited(evt);
            }
        });
        calcPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calcPageHover.setBackground(new java.awt.Color(255, 255, 255));
        calcPage.add(calcPageHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        calcPageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Calculator_35px.png")); // NOI18N
        calcPage.add(calcPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        calcPageText.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        calcPageText.setForeground(new java.awt.Color(255, 255, 255));
        calcPageText.setText("HESABAT");
        calcPage.add(calcPageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 40));

        menu.add(calcPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 280, 60));

        emailPage.setBackground(new java.awt.Color(0, 102, 255));
        emailPage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        emailPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailPageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emailPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emailPageMouseExited(evt);
            }
        });
        emailPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailPageHover.setBackground(new java.awt.Color(255, 255, 255));
        emailPage.add(emailPageHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        emailPageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Send Email_35px.png")); // NOI18N
        emailPage.add(emailPageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 50, 50));

        emailPageText.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        emailPageText.setForeground(new java.awt.Color(255, 255, 255));
        emailPageText.setText("EMAİL GÖNDƏR");
        emailPage.add(emailPageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, 40));

        menu.add(emailPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 280, 60));

        logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Book Shelf_75px.png")); // NOI18N
        logo.add(logoIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        logoText.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        logoText.setText("BooKShelf");
        logo.add(logoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 180, 60));

        menu.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 90));

        employeePage.setBackground(new java.awt.Color(0, 102, 255));
        employeePage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeePageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employeePageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                employeePageMouseExited(evt);
            }
        });
        employeePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeePageHover.setBackground(new java.awt.Color(255, 255, 255));
        employeePage.add(employeePageHover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 60));

        employeePageIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Managemenddst_35px.png")); // NOI18N
        employeePage.add(employeePageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        employeePageText.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        employeePageText.setForeground(new java.awt.Color(255, 255, 255));
        employeePageText.setText("İŞÇİLƏR");
        employeePage.add(employeePageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, 50));

        menu.add(employeePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 280, 60));

        bg.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 850));

        mainPageContent.setBackground(new java.awt.Color(255, 255, 255));
        mainPageContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 102, 255));

        exit.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("X");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        time.setFont(new java.awt.Font("Cambria", 0, 36)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("10-Apr-2020 17:20");

        userIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Male User_50px.png")); // NOI18N

        userName.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setText("NAME");

        userSurname.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        userSurname.setForeground(new java.awt.Color(255, 255, 255));
        userSurname.setText("SURNAME");

        date.setFont(new java.awt.Font("Cambria", 0, 36)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("jLabel32");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(date)
                .addGap(18, 18, 18)
                .addComponent(time)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
                .addComponent(userIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userName)
                    .addComponent(userSurname))
                .addGap(64, 64, 64)
                .addComponent(exit)
                .addGap(20, 20, 20))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit)
                .addGap(23, 23, 23))
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(time)
                        .addComponent(date))
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, headerLayout.createSequentialGroup()
                            .addComponent(userName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userSurname))
                        .addComponent(userIcon, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPageContent.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 70));

        mainPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPageContentOnLay.setBackground(new java.awt.Color(255, 255, 255));
        mainPageContentOnLay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainPageContentOnLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentsNum.setBackground(new java.awt.Color(255, 202, 51));

        studentsNumText.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        studentsNumText.setForeground(new java.awt.Color(255, 255, 255));
        studentsNumText.setText("25");

        studentsIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Student Male_75px.png")); // NOI18N

        studentsText.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        studentsText.setForeground(new java.awt.Color(255, 255, 255));
        studentsText.setText("TƏLƏBƏLƏR");

        studentsMoreInfo.setBackground(new java.awt.Color(240, 179, 64));
        studentsMoreInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentsMoreInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsMoreInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentsMoreInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentsMoreInfoMouseExited(evt);
            }
        });

        studentsMoreInfoIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Next page_15px.png")); // NOI18N

        studentsMoreInfoText.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        studentsMoreInfoText.setForeground(new java.awt.Color(255, 255, 255));
        studentsMoreInfoText.setText("ƏTRAFLI");

        javax.swing.GroupLayout studentsMoreInfoLayout = new javax.swing.GroupLayout(studentsMoreInfo);
        studentsMoreInfo.setLayout(studentsMoreInfoLayout);
        studentsMoreInfoLayout.setHorizontalGroup(
            studentsMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsMoreInfoLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(studentsMoreInfoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentsMoreInfoIcon)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        studentsMoreInfoLayout.setVerticalGroup(
            studentsMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentsMoreInfoText, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(studentsMoreInfoIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout studentsNumLayout = new javax.swing.GroupLayout(studentsNum);
        studentsNum.setLayout(studentsNumLayout);
        studentsNumLayout.setHorizontalGroup(
            studentsNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentsMoreInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(studentsNumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentsNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentsNumText)
                    .addComponent(studentsText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(studentsIcon)
                .addContainerGap())
        );
        studentsNumLayout.setVerticalGroup(
            studentsNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsNumLayout.createSequentialGroup()
                .addGroup(studentsNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentsIcon)
                    .addGroup(studentsNumLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(studentsNumText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(studentsText)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentsMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPageContentOnLay.add(studentsNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 300, 150));

        bookNum.setBackground(new java.awt.Color(212, 51, 51));

        bookIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Open Book_75px.png")); // NOI18N

        bookNumText.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        bookNumText.setForeground(new java.awt.Color(255, 255, 255));
        bookNumText.setText("32");

        bookMoreInfo.setBackground(new java.awt.Color(255, 12, 12));
        bookMoreInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookMoreInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookMoreInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookMoreInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookMoreInfoMouseExited(evt);
            }
        });

        bookMoreInfoText.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        bookMoreInfoText.setForeground(new java.awt.Color(255, 255, 255));
        bookMoreInfoText.setText("ƏTRAFLI");

        bookMoreInfoIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Next page_15px.png")); // NOI18N

        javax.swing.GroupLayout bookMoreInfoLayout = new javax.swing.GroupLayout(bookMoreInfo);
        bookMoreInfo.setLayout(bookMoreInfoLayout);
        bookMoreInfoLayout.setHorizontalGroup(
            bookMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookMoreInfoLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(bookMoreInfoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookMoreInfoIcon)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        bookMoreInfoLayout.setVerticalGroup(
            bookMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookMoreInfoIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bookMoreInfoText, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        bookText.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        bookText.setForeground(new java.awt.Color(255, 255, 255));
        bookText.setText("KİTABLAR");

        javax.swing.GroupLayout bookNumLayout = new javax.swing.GroupLayout(bookNum);
        bookNum.setLayout(bookNumLayout);
        bookNumLayout.setHorizontalGroup(
            bookNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bookMoreInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bookNumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bookNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookNumLayout.createSequentialGroup()
                        .addComponent(bookNumText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bookIcon))
                    .addGroup(bookNumLayout.createSequentialGroup()
                        .addComponent(bookText)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bookNumLayout.setVerticalGroup(
            bookNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookNumLayout.createSequentialGroup()
                .addGroup(bookNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookIcon)
                    .addGroup(bookNumLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bookNumText)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bookText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        mainPageContentOnLay.add(bookNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 340, 150));

        employeeNum.setBackground(new java.awt.Color(0, 220, 2));

        employeeIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Employee_75px.png")); // NOI18N

        employeeNumText.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        employeeNumText.setForeground(new java.awt.Color(255, 255, 255));
        employeeNumText.setText("14");

        employeeMoreInfo.setBackground(new java.awt.Color(23, 169, 7));
        employeeMoreInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeMoreInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeMoreInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employeeMoreInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                employeeMoreInfoMouseExited(evt);
            }
        });

        employeeMoreInfoIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Next page_15px.png")); // NOI18N

        employeeMoreInfoText.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        employeeMoreInfoText.setForeground(new java.awt.Color(255, 255, 255));
        employeeMoreInfoText.setText("ƏTRAFLI");

        javax.swing.GroupLayout employeeMoreInfoLayout = new javax.swing.GroupLayout(employeeMoreInfo);
        employeeMoreInfo.setLayout(employeeMoreInfoLayout);
        employeeMoreInfoLayout.setHorizontalGroup(
            employeeMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeMoreInfoLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(employeeMoreInfoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeMoreInfoIcon)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        employeeMoreInfoLayout.setVerticalGroup(
            employeeMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeMoreInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(employeeMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(employeeMoreInfoIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeMoreInfoText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        employeeText.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        employeeText.setForeground(new java.awt.Color(255, 255, 255));
        employeeText.setText("İŞÇİLƏR");

        javax.swing.GroupLayout employeeNumLayout = new javax.swing.GroupLayout(employeeNum);
        employeeNum.setLayout(employeeNumLayout);
        employeeNumLayout.setHorizontalGroup(
            employeeNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(employeeMoreInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(employeeNumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeeNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeNumLayout.createSequentialGroup()
                        .addComponent(employeeText)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(employeeNumLayout.createSequentialGroup()
                        .addComponent(employeeNumText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(employeeIcon))))
        );
        employeeNumLayout.setVerticalGroup(
            employeeNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeNumLayout.createSequentialGroup()
                .addGroup(employeeNumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeIcon)
                    .addGroup(employeeNumLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(employeeNumText)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(employeeText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPageContentOnLay.add(employeeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 310, 150));

        warningBoard.setBackground(new java.awt.Color(255, 255, 255));
        warningBoard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        warningBoardHeader.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\High Priority_50px.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("XATIRLATMALAR");

        javax.swing.GroupLayout warningBoardHeaderLayout = new javax.swing.GroupLayout(warningBoardHeader);
        warningBoardHeader.setLayout(warningBoardHeaderLayout);
        warningBoardHeaderLayout.setHorizontalGroup(
            warningBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningBoardHeaderLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(761, Short.MAX_VALUE))
        );
        warningBoardHeaderLayout.setVerticalGroup(
            warningBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningBoardHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(warningBoardHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        warningTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        warningTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Warning Icon", "Warning Message"
            }
        ));
        warningTable.setCellSelectionEnabled(true);
        warningTable.setEnabled(false);
        warningTable.setFocusable(false);
        warningTable.setRowHeight(40);
        warningTable.setSelectionBackground(new java.awt.Color(0, 153, 51));
        jScrollPane1.setViewportView(warningTable);

        javax.swing.GroupLayout warningBoardLayout = new javax.swing.GroupLayout(warningBoard);
        warningBoard.setLayout(warningBoardLayout);
        warningBoardLayout.setHorizontalGroup(
            warningBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(warningBoardHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(warningBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        warningBoardLayout.setVerticalGroup(
            warningBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, warningBoardLayout.createSequentialGroup()
                .addComponent(warningBoardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPageContentOnLay.add(warningBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 1100, 280));

        event.setBackground(new java.awt.Color(37, 109, 240));

        notesTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        notesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Başlanğıc Tarix", "Son Tarix", "Qeydiyyat"
            }
        ));
        notesTable.setCellSelectionEnabled(true);
        notesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        notesTable.setRowHeight(45);
        jScrollPane3.setViewportView(notesTable);

        eventIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Calendar_30px.png")); // NOI18N

        eventText.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        eventText.setForeground(new java.awt.Color(255, 255, 255));
        eventText.setText("QEYDİYYATLAR");

        addEvent.setBackground(new java.awt.Color(255, 255, 255));
        addEvent.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        addEvent.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Add List_35px.png")); // NOI18N
        addEvent.setText("Əlavə Et");
        addEvent.setToolTipText("");
        addEvent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout eventLayout = new javax.swing.GroupLayout(event);
        event.setLayout(eventLayout);
        eventLayout.setHorizontalGroup(
            eventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
                    .addGroup(eventLayout.createSequentialGroup()
                        .addComponent(eventIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eventText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addEvent)))
                .addGap(18, 18, 18))
        );
        eventLayout.setVerticalGroup(
            eventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(eventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eventText, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addEvent)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPageContentOnLay.add(event, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 1070, 250));

        mainPageLay.setLayer(mainPageContentOnLay, javax.swing.JLayeredPane.PALETTE_LAYER);
        mainPageLay.add(mainPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(mainPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        tablePageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePageContentOnLay.setBackground(new java.awt.Color(255, 255, 255));
        tablePageContentOnLay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        masa1.setBackground(new java.awt.Color(153, 0, 255));
        masa1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa1.setText("1");
        masa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masa1ActionPerformed(evt);
            }
        });

        masa2.setBackground(new java.awt.Color(153, 0, 255));
        masa2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa2.setText("2");

        masa3.setBackground(new java.awt.Color(153, 0, 255));
        masa3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa3.setText("3");

        masa4.setBackground(new java.awt.Color(153, 0, 255));
        masa4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa4.setText("4");

        masa5.setBackground(new java.awt.Color(153, 0, 255));
        masa5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa5.setText("5");

        masa6.setBackground(new java.awt.Color(153, 0, 255));
        masa6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa6.setText("6");

        masa7.setBackground(new java.awt.Color(153, 0, 255));
        masa7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa7.setText("7");

        masa8.setBackground(new java.awt.Color(153, 0, 255));
        masa8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa8.setText("8");

        masa9.setBackground(new java.awt.Color(153, 0, 255));
        masa9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa9.setText("9");

        masa10.setBackground(new java.awt.Color(153, 0, 255));
        masa10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa10.setText("10");

        masa11.setBackground(new java.awt.Color(153, 0, 255));
        masa11.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa11.setText("11");

        masa12.setBackground(new java.awt.Color(153, 0, 255));
        masa12.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa12.setText("12");

        masa13.setBackground(new java.awt.Color(153, 0, 255));
        masa13.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa13.setText("13");

        masa14.setBackground(new java.awt.Color(153, 0, 255));
        masa14.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa14.setText("14");

        masa15.setBackground(new java.awt.Color(153, 0, 255));
        masa15.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa15.setText("15");

        masa16.setBackground(new java.awt.Color(153, 0, 255));
        masa16.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa16.setText("16");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        masa17.setBackground(new java.awt.Color(153, 0, 255));
        masa17.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa17.setText("17");

        masa18.setBackground(new java.awt.Color(153, 0, 255));
        masa18.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa18.setText("18");

        masa19.setBackground(new java.awt.Color(153, 0, 255));
        masa19.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa19.setText("19");

        masa20.setBackground(new java.awt.Color(153, 0, 255));
        masa20.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa20.setText("20");

        shelf1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf1.setText("RƏF 1");

        shelf2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf2.setText("RƏF 2");

        shelf3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf3.setText("RƏF 3");

        shelf5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf5.setText("RƏF 5");

        shelf4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf4.setText("RƏF 4");

        shelf6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf6.setText("RƏF 6");
        shelf6.setToolTipText("");

        masa22.setBackground(new java.awt.Color(153, 0, 255));
        masa22.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa22.setText("22");

        masa21.setBackground(new java.awt.Color(153, 0, 255));
        masa21.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa21.setText("21");

        masa23.setBackground(new java.awt.Color(153, 0, 255));
        masa23.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa23.setText("23");

        masa24.setBackground(new java.awt.Color(153, 0, 255));
        masa24.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa24.setText("24");

        masa25.setBackground(new java.awt.Color(153, 0, 255));
        masa25.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa25.setText("25");

        masa26.setBackground(new java.awt.Color(153, 0, 255));
        masa26.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa26.setText("26");

        masa27.setBackground(new java.awt.Color(153, 0, 255));
        masa27.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa27.setText("27");

        masa28.setBackground(new java.awt.Color(153, 0, 255));
        masa28.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa28.setText("28");

        masa29.setBackground(new java.awt.Color(153, 0, 255));
        masa29.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa29.setText("29");

        masa30.setBackground(new java.awt.Color(153, 0, 255));
        masa30.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa30.setText("30");

        masa31.setBackground(new java.awt.Color(153, 0, 255));
        masa31.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa31.setText("31");

        masa32.setBackground(new java.awt.Color(153, 0, 255));
        masa32.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa32.setText("32");

        masa33.setBackground(new java.awt.Color(153, 0, 255));
        masa33.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa33.setText("33");

        masa34.setBackground(new java.awt.Color(153, 0, 255));
        masa34.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa34.setText("34");

        masa35.setBackground(new java.awt.Color(153, 0, 255));
        masa35.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa35.setText("35");

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        masa36.setBackground(new java.awt.Color(153, 0, 255));
        masa36.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa36.setText("36");

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator7.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

        masa37.setBackground(new java.awt.Color(153, 0, 255));
        masa37.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa37.setText("37");

        masa38.setBackground(new java.awt.Color(153, 0, 255));
        masa38.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa38.setText("38");

        masa39.setBackground(new java.awt.Color(153, 0, 255));
        masa39.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa39.setText("39");

        masa40.setBackground(new java.awt.Color(153, 0, 255));
        masa40.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        masa40.setText("40");

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));

        shelf7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf7.setText("RƏF 7");

        shelf9.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf9.setText("RƏF 9");

        shelf11.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf11.setText("RƏF 11");
        shelf11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shelf11ActionPerformed(evt);
            }
        });

        shelf12.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf12.setText("RƏF 12");
        shelf12.setToolTipText("");

        shelf10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf10.setText("RƏF 10");

        shelf8.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        shelf8.setText("RƏF 8");

        buttonGroup1.add(emptyTableCheck);
        emptyTableCheck.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        emptyTableCheck.setText("BOŞ MASALAR");
        emptyTableCheck.setOpaque(false);
        emptyTableCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyTableCheckActionPerformed(evt);
            }
        });

        buttonGroup1.add(allTableCheck);
        allTableCheck.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        allTableCheck.setText("BÜTÜN MASALAR");
        allTableCheck.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        allTableCheck.setOpaque(false);
        allTableCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allTableCheckActionPerformed(evt);
            }
        });

        emptyText.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        emptyText.setText("BOŞ MASALARIN SAYI:");

        emptyTableNum.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        emptyTableNum.setText("25");
        emptyTableNum.setToolTipText("");

        addOrderToTable.setBackground(new java.awt.Color(102, 102, 255));
        addOrderToTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addOrderToTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addOrderToTableMouseClicked(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("SİFARİŞ ƏLAVƏ ET");

        javax.swing.GroupLayout addOrderToTableLayout = new javax.swing.GroupLayout(addOrderToTable);
        addOrderToTable.setLayout(addOrderToTableLayout);
        addOrderToTableLayout.setHorizontalGroup(
            addOrderToTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrderToTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        addOrderToTableLayout.setVerticalGroup(
            addOrderToTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jSeparator20.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator20.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout tablePageContentOnLayLayout = new javax.swing.GroupLayout(tablePageContentOnLay);
        tablePageContentOnLay.setLayout(tablePageContentOnLayLayout);
        tablePageContentOnLayLayout.setHorizontalGroup(
            tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(allTableCheck)
                        .addGap(26, 26, 26)
                        .addComponent(emptyTableCheck)
                        .addGap(140, 140, 140)
                        .addComponent(emptyText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emptyTableNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                        .addComponent(addOrderToTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator20)))
                .addContainerGap())
            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shelf1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shelf2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shelf3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shelf4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shelf5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shelf6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(shelf7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shelf8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(shelf9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shelf10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shelf12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(shelf11, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                            .addComponent(masa13, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(masa14, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(masa15, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(masa16, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePageContentOnLayLayout.createSequentialGroup()
                                            .addComponent(masa5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(masa6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(masa7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(masa8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePageContentOnLayLayout.createSequentialGroup()
                                            .addComponent(masa1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(masa2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(masa3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(masa4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePageContentOnLayLayout.createSequentialGroup()
                                            .addComponent(masa9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(masa10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(masa11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(masa12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator1)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                        .addComponent(masa17, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(masa18, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(masa19, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(masa20, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                            .addComponent(masa33, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(masa34, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(masa35, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(masa36, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePageContentOnLayLayout.createSequentialGroup()
                                            .addComponent(masa25, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(masa26, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(masa27, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(masa28, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePageContentOnLayLayout.createSequentialGroup()
                                            .addComponent(masa21, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(masa22, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(masa23, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(masa24, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePageContentOnLayLayout.createSequentialGroup()
                                            .addComponent(masa29, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(masa30, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(masa31, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(masa32, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator5)
                                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                        .addComponent(masa37, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(masa38, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(masa39, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(masa40, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tablePageContentOnLayLayout.setVerticalGroup(
            tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addOrderToTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(allTableCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emptyTableCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emptyText)
                        .addComponent(emptyTableNum)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(masa1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masa2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(masa4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masa3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(masa5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masa6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(masa8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masa7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(masa9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masa10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(masa12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masa11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(masa13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masa14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(masa16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masa15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(masa17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masa18, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(masa20, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masa19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(masa21, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masa22, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(masa24, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masa23, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(masa25, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masa26, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(masa28, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masa27, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(masa29, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masa30, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(masa32, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masa31, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(masa33, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masa34, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(masa36, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masa35, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(masa37, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(masa38, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tablePageContentOnLayLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(masa40, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(masa39, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shelf1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelf3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelf5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelf7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelf9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shelf11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shelf2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tablePageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(shelf4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(shelf6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(shelf10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(shelf12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(shelf8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        tablePageLay.add(tablePageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(tablePageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        studentsPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        studentsPageContentOnLay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        studentsTablePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel5.setText("TƏLƏBƏ SAYI:");

        studentsNumber.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        studentsNumber.setText("24");

        studentsTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        studentsTable.setRowHeight(33);
        studentsTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        studentsTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(studentsTable);

        searchForStudents.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchForStudents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchForStudentsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForStudentsKeyReleased(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(102, 102, 255));
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });

        searchText.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchText.setForeground(new java.awt.Color(255, 255, 255));
        searchText.setText("AXTAR");

        javax.swing.GroupLayout searchBtnLayout = new javax.swing.GroupLayout(searchBtn);
        searchBtn.setLayout(searchBtnLayout);
        searchBtnLayout.setHorizontalGroup(
            searchBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBtnLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(searchText)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        searchBtnLayout.setVerticalGroup(
            searchBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        addStudentIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Add User Male_35px.png")); // NOI18N
        addStudentIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStudentIconMouseClicked(evt);
            }
        });

        refreshStudent.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Synchronize_35px.png")); // NOI18N
        refreshStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshStudentMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout studentsTablePanelLayout = new javax.swing.GroupLayout(studentsTablePanel);
        studentsTablePanel.setLayout(studentsTablePanelLayout);
        studentsTablePanelLayout.setHorizontalGroup(
            studentsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10)
                    .addGroup(studentsTablePanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(studentsNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchForStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(addStudentIcon)
                        .addGap(18, 18, 18)
                        .addComponent(refreshStudent)
                        .addGap(7, 7, 7))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE))
                .addContainerGap())
        );
        studentsTablePanelLayout.setVerticalGroup(
            studentsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsTablePanelLayout.createSequentialGroup()
                .addGroup(studentsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentsTablePanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(studentsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentsTablePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(studentsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(studentsNumber)))
                            .addComponent(addStudentIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addGroup(studentsTablePanelLayout.createSequentialGroup()
                                .addGroup(studentsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(searchBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchForStudents, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(studentsTablePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshStudent)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout studentsPageContentOnLayLayout = new javax.swing.GroupLayout(studentsPageContentOnLay);
        studentsPageContentOnLay.setLayout(studentsPageContentOnLayLayout);
        studentsPageContentOnLayLayout.setHorizontalGroup(
            studentsPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsPageContentOnLayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentsTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        studentsPageContentOnLayLayout.setVerticalGroup(
            studentsPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsPageContentOnLayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentsTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        studentsPageLay.add(studentsPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(studentsPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        bookPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookPageContentOnLay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookPageContentOnLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookTablePanel.setBackground(new java.awt.Color(255, 255, 255));

        bookTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        bookTable.setRowHeight(33);
        bookTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        bookTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(bookTable);

        searchForBook.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchForBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForBookKeyReleased(evt);
            }
        });

        searchBookBtn.setBackground(new java.awt.Color(102, 102, 255));
        searchBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBookBtnMouseClicked(evt);
            }
        });

        searchText1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchText1.setForeground(new java.awt.Color(255, 255, 255));
        searchText1.setText("AXTAR");

        javax.swing.GroupLayout searchBookBtnLayout = new javax.swing.GroupLayout(searchBookBtn);
        searchBookBtn.setLayout(searchBookBtnLayout);
        searchBookBtnLayout.setHorizontalGroup(
            searchBookBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBookBtnLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(searchText1)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        searchBookBtnLayout.setVerticalGroup(
            searchBookBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        advancedSearchBookBtn.setBackground(new java.awt.Color(102, 102, 255));
        advancedSearchBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                advancedSearchBookBtnMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ƏTRAFLI AXTARIŞ");

        javax.swing.GroupLayout advancedSearchBookBtnLayout = new javax.swing.GroupLayout(advancedSearchBookBtn);
        advancedSearchBookBtn.setLayout(advancedSearchBookBtnLayout);
        advancedSearchBookBtnLayout.setHorizontalGroup(
            advancedSearchBookBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, advancedSearchBookBtnLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        advancedSearchBookBtnLayout.setVerticalGroup(
            advancedSearchBookBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        addBook.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Add Book_35px.png")); // NOI18N
        addBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBookMouseClicked(evt);
            }
        });

        orderBook.setBackground(new java.awt.Color(102, 102, 255));
        orderBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderBookMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("KİTAB SİFARİŞİ");

        javax.swing.GroupLayout orderBookLayout = new javax.swing.GroupLayout(orderBook);
        orderBook.setLayout(orderBookLayout);
        orderBookLayout.setHorizontalGroup(
            orderBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderBookLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        orderBookLayout.setVerticalGroup(
            orderBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        refreshBook.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Synchronize_35px.png")); // NOI18N
        refreshBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshBookMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bookTablePanelLayout = new javax.swing.GroupLayout(bookTablePanel);
        bookTablePanel.setLayout(bookTablePanelLayout);
        bookTablePanelLayout.setHorizontalGroup(
            bookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator11)
                    .addGroup(bookTablePanelLayout.createSequentialGroup()
                        .addGroup(bookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookTablePanelLayout.createSequentialGroup()
                                .addComponent(orderBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(advancedSearchBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 415, Short.MAX_VALUE)
                                .addComponent(searchForBook, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addBook)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refreshBook)))
                        .addContainerGap())))
        );
        bookTablePanelLayout.setVerticalGroup(
            bookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookTablePanelLayout.createSequentialGroup()
                        .addGroup(bookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(advancedSearchBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(bookTablePanelLayout.createSequentialGroup()
                        .addGroup(bookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(refreshBook)
                                .addComponent(addBook))
                            .addGroup(bookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(searchForBook, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                .addContainerGap())
        );

        bookPageContentOnLay.add(bookTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1120, 760));

        bookPageLay.add(bookPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        bookAdvancedSearchTablePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setText("JANR");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel11.setText("MİN SƏHİFƏ SAYI");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel12.setText("MAX SƏHİFƏ SAYI");

        jLabel29.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel29.setText("MİN KOPYA SAYI");

        jLabel35.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel35.setText("MAX KOPYA SAYI");

        jLabel36.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel36.setText("MİN QİYMƏT");

        jLabel37.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel37.setText("MAX QİYMƏT");

        tipCombo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        minCopies.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        maxCopies.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        minPrice.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        maxPrice.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        minPageNum.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        maxPageNum.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        advancedBookTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        advancedBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        advancedBookTable.setRowHeight(33);
        advancedBookTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        advancedBookTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane16.setViewportView(advancedBookTable);

        searchAdvancedBook.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Downloads\\button (10).png")); // NOI18N
        searchAdvancedBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchAdvancedBookMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bookAdvancedSearchTablePanelLayout = new javax.swing.GroupLayout(bookAdvancedSearchTablePanel);
        bookAdvancedSearchTablePanel.setLayout(bookAdvancedSearchTablePanelLayout);
        bookAdvancedSearchTablePanelLayout.setHorizontalGroup(
            bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookAdvancedSearchTablePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookAdvancedSearchTablePanelLayout.createSequentialGroup()
                        .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel29)
                            .addComponent(jLabel35))
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookAdvancedSearchTablePanelLayout.createSequentialGroup()
                        .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(78, 78, 78)))
                .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tipCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minCopies)
                    .addComponent(maxCopies)
                    .addComponent(minPageNum)
                    .addComponent(maxPageNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookAdvancedSearchTablePanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37))
                        .addGap(52, 52, 52)
                        .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(117, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookAdvancedSearchTablePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchAdvancedBook)
                        .addGap(40, 40, 40))))
            .addGroup(bookAdvancedSearchTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16)
                .addContainerGap())
        );
        bookAdvancedSearchTablePanelLayout.setVerticalGroup(
            bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookAdvancedSearchTablePanelLayout.createSequentialGroup()
                .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookAdvancedSearchTablePanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tipCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bookAdvancedSearchTablePanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))))
                .addGap(22, 22, 22)
                .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(minCopies, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(maxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(maxCopies, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bookAdvancedSearchTablePanelLayout.createSequentialGroup()
                        .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minPageNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(bookAdvancedSearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(maxPageNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(searchAdvancedBook))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bookAdvancedSearchPageContentOnLayLayout = new javax.swing.GroupLayout(bookAdvancedSearchPageContentOnLay);
        bookAdvancedSearchPageContentOnLay.setLayout(bookAdvancedSearchPageContentOnLayLayout);
        bookAdvancedSearchPageContentOnLayLayout.setHorizontalGroup(
            bookAdvancedSearchPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookAdvancedSearchPageContentOnLayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookAdvancedSearchTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bookAdvancedSearchPageContentOnLayLayout.setVerticalGroup(
            bookAdvancedSearchPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookAdvancedSearchPageContentOnLayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookAdvancedSearchTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bookAdvancedSearchPageLay.setLayer(bookAdvancedSearchPageContentOnLay, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bookAdvancedSearchPageLayLayout = new javax.swing.GroupLayout(bookAdvancedSearchPageLay);
        bookAdvancedSearchPageLay.setLayout(bookAdvancedSearchPageLayLayout);
        bookAdvancedSearchPageLayLayout.setHorizontalGroup(
            bookAdvancedSearchPageLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
            .addGroup(bookAdvancedSearchPageLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(bookAdvancedSearchPageContentOnLay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bookAdvancedSearchPageLayLayout.setVerticalGroup(
            bookAdvancedSearchPageLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
            .addGroup(bookAdvancedSearchPageLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bookAdvancedSearchPageLayLayout.createSequentialGroup()
                    .addComponent(bookAdvancedSearchPageContentOnLay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bookPageLay.add(bookAdvancedSearchPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(bookPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        authorPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        authorPageContentOnLay.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        authorPageContentOnLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        authorTablePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel10.setText("MÜƏLLİF SAYI:");

        authorNumber.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        authorNumber.setText("24");

        authorTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        authorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        authorTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        authorTable.setFocusable(false);
        authorTable.setRowHeight(33);
        authorTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        authorTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane6.setViewportView(authorTable);

        searchForAuthor.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchForAuthor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForAuthorKeyReleased(evt);
            }
        });

        searchAuthorBtn.setBackground(new java.awt.Color(102, 102, 255));
        searchAuthorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchAuthorBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchAuthorBtnMouseClicked(evt);
            }
        });

        searchText2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchText2.setForeground(new java.awt.Color(255, 255, 255));
        searchText2.setText("AXTAR");

        javax.swing.GroupLayout searchAuthorBtnLayout = new javax.swing.GroupLayout(searchAuthorBtn);
        searchAuthorBtn.setLayout(searchAuthorBtnLayout);
        searchAuthorBtnLayout.setHorizontalGroup(
            searchAuthorBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchAuthorBtnLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(searchText2)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        searchAuthorBtnLayout.setVerticalGroup(
            searchAuthorBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchText2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        addAuthor.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Add User Male_35px.png")); // NOI18N
        addAuthor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addAuthorMouseClicked(evt);
            }
        });

        refreshAuthor.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Synchronize_35px.png")); // NOI18N
        refreshAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshAuthorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout authorTablePanelLayout = new javax.swing.GroupLayout(authorTablePanel);
        authorTablePanel.setLayout(authorTablePanelLayout);
        authorTablePanelLayout.setHorizontalGroup(
            authorTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(authorTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(authorTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator12)
                    .addGroup(authorTablePanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchForAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchAuthorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(addAuthor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshAuthor)
                        .addGap(13, 13, 13))
                    .addGroup(authorTablePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)))
                .addContainerGap())
        );
        authorTablePanelLayout.setVerticalGroup(
            authorTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(authorTablePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(authorTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(authorTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(authorNumber)
                        .addComponent(searchForAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addAuthor)
                    .addComponent(refreshAuthor)
                    .addComponent(searchAuthorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
        );

        authorPageContentOnLay.add(authorTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1120, 750));

        authorPageLay.add(authorPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(authorPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        menuPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPageContentOnLay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPageContentOnLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuTablePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel14.setText("YEMƏK SAYI:");

        menuNum.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        menuNum.setText("24");

        menuTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        menuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        menuTable.setRowHeight(33);
        menuTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        menuTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane7.setViewportView(menuTable);

        searchForMenu.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchForMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForMenuKeyReleased(evt);
            }
        });

        searchMenuBtn.setBackground(new java.awt.Color(102, 102, 255));
        searchMenuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMenuBtnMouseClicked(evt);
            }
        });

        searchText3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchText3.setForeground(new java.awt.Color(255, 255, 255));
        searchText3.setText("AXTAR");

        javax.swing.GroupLayout searchMenuBtnLayout = new javax.swing.GroupLayout(searchMenuBtn);
        searchMenuBtn.setLayout(searchMenuBtnLayout);
        searchMenuBtnLayout.setHorizontalGroup(
            searchMenuBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchMenuBtnLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(searchText3)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        searchMenuBtnLayout.setVerticalGroup(
            searchMenuBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchText3, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        addMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Add_35pxhgk.png")); // NOI18N
        addMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMenuMouseClicked(evt);
            }
        });

        refreshMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Synchronize_35px.png")); // NOI18N
        refreshMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuTablePanelLayout = new javax.swing.GroupLayout(menuTablePanel);
        menuTablePanel.setLayout(menuTablePanelLayout);
        menuTablePanelLayout.setHorizontalGroup(
            menuTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator13)
                    .addGroup(menuTablePanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menuNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchForMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(addMenu)
                        .addGap(18, 18, 18)
                        .addComponent(refreshMenu)
                        .addGap(16, 16, 16))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuTablePanelLayout.setVerticalGroup(
            menuTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuTablePanelLayout.createSequentialGroup()
                .addGroup(menuTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuTablePanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(menuTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(menuNum))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuTablePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(menuTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addMenu)
                            .addGroup(menuTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(searchMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchForMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(refreshMenu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                .addContainerGap())
        );

        refreshMenu.getAccessibleContext().setAccessibleName("refreshMenu");

        menuPageContentOnLay.add(menuTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1120, 750));

        menuPageLay.add(menuPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(menuPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        orderPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderPageContentOnLay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        orderPageContentOnLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderTablePanel.setBackground(new java.awt.Color(255, 255, 255));

        orderTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        orderTable.setRowHeight(33);
        orderTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        orderTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane8.setViewportView(orderTable);

        searchForOrder.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchForOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForOrderKeyReleased(evt);
            }
        });

        searchOrderBtn.setBackground(new java.awt.Color(102, 102, 255));
        searchOrderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchOrderBtnMouseClicked(evt);
            }
        });

        searchText4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchText4.setForeground(new java.awt.Color(255, 255, 255));
        searchText4.setText("AXTAR");

        javax.swing.GroupLayout searchOrderBtnLayout = new javax.swing.GroupLayout(searchOrderBtn);
        searchOrderBtn.setLayout(searchOrderBtnLayout);
        searchOrderBtnLayout.setHorizontalGroup(
            searchOrderBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchOrderBtnLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(searchText4)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        searchOrderBtnLayout.setVerticalGroup(
            searchOrderBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchText4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        addOrder.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Add_35pxasdads.png")); // NOI18N

        paidBtn.setBackground(new java.awt.Color(102, 102, 255));
        paidBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paidBtnMouseClicked(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("ÖDƏ");

        javax.swing.GroupLayout paidBtnLayout = new javax.swing.GroupLayout(paidBtn);
        paidBtn.setLayout(paidBtnLayout);
        paidBtnLayout.setHorizontalGroup(
            paidBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paidBtnLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel34)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        paidBtnLayout.setVerticalGroup(
            paidBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        refreshOrderPage.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Synchronize_35px.png")); // NOI18N
        refreshOrderPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshOrderPageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout orderTablePanelLayout = new javax.swing.GroupLayout(orderTablePanel);
        orderTablePanel.setLayout(orderTablePanelLayout);
        orderTablePanelLayout.setHorizontalGroup(
            orderTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator14)
                    .addGroup(orderTablePanelLayout.createSequentialGroup()
                        .addComponent(paidBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchForOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(addOrder)
                        .addGap(18, 18, 18)
                        .addComponent(refreshOrderPage)
                        .addGap(9, 9, 9))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE))
                .addContainerGap())
        );
        orderTablePanelLayout.setVerticalGroup(
            orderTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderTablePanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(orderTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addOrder)
                    .addComponent(refreshOrderPage)
                    .addGroup(orderTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(searchForOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchOrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(orderTablePanelLayout.createSequentialGroup()
                        .addComponent(paidBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );

        orderPageContentOnLay.add(orderTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1120, 750));

        orderPageLay.add(orderPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(orderPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        calcPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calcPageContentOnLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calcPageTablesPanel.setBackground(new java.awt.Color(255, 255, 255));
        calcPageTablesPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        paidTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        paidTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        paidTable.setRowHeight(33);
        paidTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        paidTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane9.setViewportView(paidTable);

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator15.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel16.setText("ƏTRAFLI AXTARIŞ");

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel17.setText("BAŞLANĞIC TARİX");

        beginDate.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel18.setText("SON TARİX");

        endDate.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel19.setText("QAZANC");

        gainMoney.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        searchForPaid.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchForPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForPaidKeyReleased(evt);
            }
        });

        searchPaidBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchPaidBtn.setText("AXTAR");
        searchPaidBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        searchPaidBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchPaidBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPaidBtnActionPerformed(evt);
            }
        });

        jSeparator16.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator16.setForeground(new java.awt.Color(0, 0, 0));

        productTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        productTable.setRowHeight(33);
        productTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        productTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane10.setViewportView(productTable);

        jSeparator17.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator17.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);

        searchForProduct.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchForProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForProductKeyReleased(evt);
            }
        });

        searchProductBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchProductBtn.setText("AXTAR");
        searchProductBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        searchProductBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchProductBtnActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel21.setText("Min Say");

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel22.setText("Max Say");

        minNum.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        maxNum.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel24.setText("BAŞLANĞIC QİYMƏT");

        beginMoney.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel25.setText("SON QİYMƏT");

        endMoney.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel20.setText("ƏTRAFLI AXTARIŞ");

        searchPaidAdv.setBackground(new java.awt.Color(62, 104, 255));
        searchPaidAdv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchPaidAdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchPaidAdvMouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("AXTAR");

        javax.swing.GroupLayout searchPaidAdvLayout = new javax.swing.GroupLayout(searchPaidAdv);
        searchPaidAdv.setLayout(searchPaidAdvLayout);
        searchPaidAdvLayout.setHorizontalGroup(
            searchPaidAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPaidAdvLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(37, 37, 37))
        );
        searchPaidAdvLayout.setVerticalGroup(
            searchPaidAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        searchProductAdv.setBackground(new java.awt.Color(62, 104, 255));
        searchProductAdv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchProductAdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchProductAdvMouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("AXTAR");

        javax.swing.GroupLayout searchProductAdvLayout = new javax.swing.GroupLayout(searchProductAdv);
        searchProductAdv.setLayout(searchProductAdvLayout);
        searchProductAdvLayout.setHorizontalGroup(
            searchProductAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchProductAdvLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        searchProductAdvLayout.setVerticalGroup(
            searchProductAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        addProduct.setBackground(new java.awt.Color(62, 104, 255));
        addProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductMouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("ƏLAVƏ ET");

        javax.swing.GroupLayout addProductLayout = new javax.swing.GroupLayout(addProduct);
        addProduct.setLayout(addProductLayout);
        addProductLayout.setHorizontalGroup(
            addProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(19, 19, 19))
        );
        addProductLayout.setVerticalGroup(
            addProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        refreshCalc.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Synchronize_35px.png")); // NOI18N
        refreshCalc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshCalcMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout calcPageTablesPanelLayout = new javax.swing.GroupLayout(calcPageTablesPanel);
        calcPageTablesPanel.setLayout(calcPageTablesPanelLayout);
        calcPageTablesPanelLayout.setHorizontalGroup(
            calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(endMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                                                .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel21)
                                                    .addComponent(minNum, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel20))
                                                .addGap(71, 71, 71))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calcPageTablesPanelLayout.createSequentialGroup()
                                                .addComponent(searchForProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(maxNum, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22)
                                            .addComponent(searchProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel24)
                                    .addComponent(beginMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchProductAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calcPageTablesPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                                .addComponent(searchForPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchPaidBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(refreshCalc)
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calcPageTablesPanelLayout.createSequentialGroup()
                                .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(beginDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gainMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calcPageTablesPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(searchPaidAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );
        calcPageTablesPanelLayout.setVerticalGroup(
            calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchForPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchPaidBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refreshCalc))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(beginDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(29, 29, 29)
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gainMoney, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchPaidAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchForProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(beginMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchProductAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(calcPageTablesPanelLayout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(calcPageTablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        calcPageContentOnLay.add(calcPageTablesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1100, 760));

        calcPageLay.add(calcPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(calcPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        emailPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailPageContentOnLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailTablePanel.setBackground(new java.awt.Color(255, 255, 255));

        newMessage.setBackground(new java.awt.Color(62, 104, 255));
        newMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newMessageMouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("YENİ MESAJ");

        javax.swing.GroupLayout newMessageLayout = new javax.swing.GroupLayout(newMessage);
        newMessage.setLayout(newMessageLayout);
        newMessageLayout.setHorizontalGroup(
            newMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newMessageLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel27)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        newMessageLayout.setVerticalGroup(
            newMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newMessageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addContainerGap())
        );

        searchForEmail.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchForEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForEmailKeyReleased(evt);
            }
        });

        searchForEmailBtn.setBackground(new java.awt.Color(62, 104, 255));
        searchForEmailBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchForEmailBtn.setText("AXTAR");
        searchForEmailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchForEmailBtnActionPerformed(evt);
            }
        });

        sendEmailTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        sendEmailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        sendEmailTable.setRowHeight(33);
        sendEmailTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        sendEmailTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane11.setViewportView(sendEmailTable);

        refreshEmail.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Synchronize_35px.png")); // NOI18N
        refreshEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshEmailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout emailTablePanelLayout = new javax.swing.GroupLayout(emailTablePanel);
        emailTablePanel.setLayout(emailTablePanelLayout);
        emailTablePanelLayout.setHorizontalGroup(
            emailTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emailTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emailTablePanelLayout.createSequentialGroup()
                        .addComponent(newMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 516, Short.MAX_VALUE)
                        .addComponent(refreshEmail)
                        .addGap(18, 18, 18)
                        .addComponent(searchForEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchForEmailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(jSeparator18)
                    .addComponent(jScrollPane11))
                .addContainerGap())
        );
        emailTablePanelLayout.setVerticalGroup(
            emailTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emailTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emailTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(emailTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(refreshEmail)
                            .addComponent(searchForEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(newMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchForEmailBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
        );

        emailPageContentOnLay.add(emailTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1100, 760));

        emailPageLay.add(emailPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(emailPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        employeePageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeePageContentOnLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeTablePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel28.setText("İŞÇİLƏRİN SAYI:");

        employeeNumber.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        employeeNumber.setText("25");

        searchForEmployee.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchForEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchForEmployeeKeyReleased(evt);
            }
        });

        searchEmployeeBtn.setBackground(new java.awt.Color(102, 102, 255));
        searchEmployeeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchEmployeeBtnMouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("AXTAR");

        javax.swing.GroupLayout searchEmployeeBtnLayout = new javax.swing.GroupLayout(searchEmployeeBtn);
        searchEmployeeBtn.setLayout(searchEmployeeBtnLayout);
        searchEmployeeBtnLayout.setHorizontalGroup(
            searchEmployeeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchEmployeeBtnLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel30)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        searchEmployeeBtnLayout.setVerticalGroup(
            searchEmployeeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        addEmployee.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Add User Male_35px.png")); // NOI18N
        addEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addEmployeeMouseClicked(evt);
            }
        });

        jSeparator19.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator19.setForeground(new java.awt.Color(0, 0, 0));

        employeeTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        employeeTable.setRowHeight(33);
        employeeTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        employeeTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane12.setViewportView(employeeTable);

        refreshEmployee.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Synchronize_35px.png")); // NOI18N
        refreshEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshEmployeeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout employeeTablePanelLayout = new javax.swing.GroupLayout(employeeTablePanel);
        employeeTablePanel.setLayout(employeeTablePanelLayout);
        employeeTablePanelLayout.setHorizontalGroup(
            employeeTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employeeTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
                    .addComponent(jSeparator19)
                    .addGroup(employeeTablePanelLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(employeeNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchForEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addEmployee)
                        .addGap(18, 18, 18)
                        .addComponent(refreshEmployee)
                        .addGap(8, 8, 8)))
                .addGap(23, 23, 23))
        );
        employeeTablePanelLayout.setVerticalGroup(
            employeeTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeTablePanelLayout.createSequentialGroup()
                .addGroup(employeeTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employeeTablePanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(employeeTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(employeeNumber)
                            .addComponent(searchForEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employeeTablePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(employeeTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addEmployee)
                            .addComponent(refreshEmployee)
                            .addComponent(searchEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );

        employeePageContentOnLay.add(employeeTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1100, 740));

        employeePageLay.add(employeePageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(employeePageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        orderBookPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderBookTablePanel.setBackground(new java.awt.Color(255, 255, 255));

        addOrderBook.setBackground(new java.awt.Color(102, 102, 255));
        addOrderBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addOrderBookMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SİFARİŞ");

        javax.swing.GroupLayout addOrderBookLayout = new javax.swing.GroupLayout(addOrderBook);
        addOrderBook.setLayout(addOrderBookLayout);
        addOrderBookLayout.setHorizontalGroup(
            addOrderBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrderBookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addOrderBookLayout.setVerticalGroup(
            addOrderBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        searchBook.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBookKeyReleased(evt);
            }
        });

        searchBookButton.setBackground(new java.awt.Color(102, 102, 255));
        searchBookButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBookButtonMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("AXTAR");

        javax.swing.GroupLayout searchBookButtonLayout = new javax.swing.GroupLayout(searchBookButton);
        searchBookButton.setLayout(searchBookButtonLayout);
        searchBookButtonLayout.setHorizontalGroup(
            searchBookButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchBookButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchBookButtonLayout.setVerticalGroup(
            searchBookButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        buttonGroup2.add(soldBook);
        soldBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        soldBook.setText("SATILAN");
        soldBook.setOpaque(false);
        soldBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soldBookActionPerformed(evt);
            }
        });

        buttonGroup2.add(borrowBook);
        borrowBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        borrowBook.setText("BORC VERİLƏN");
        borrowBook.setOpaque(false);
        borrowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowBookActionPerformed(evt);
            }
        });

        buttonGroup2.add(readNowBook);
        readNowBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        readNowBook.setText("HAZIRDA OXUNAN");
        readNowBook.setOpaque(false);
        readNowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readNowBookActionPerformed(evt);
            }
        });

        refreshOrderBook.setIcon(new javax.swing.ImageIcon("C:\\Users\\Windows10\\Desktop\\JAVA\\DESKTOP\\DESKTOP_IMG\\Synchronize_35px.png")); // NOI18N
        refreshOrderBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshOrderBookMouseClicked(evt);
            }
        });

        tableContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        soldBookPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        soldBookPageContentOnLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        soldBookTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        soldBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        soldBookTable.setRowHeight(33);
        soldBookTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        soldBookTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane13.setViewportView(soldBookTable);

        soldBookPageContentOnLay.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        soldBookPageLay.add(soldBookPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        tableContent.add(soldBookPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        borrowBookPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        borrowBookTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        borrowBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        borrowBookTable.setRowHeight(33);
        borrowBookTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        borrowBookTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane14.setViewportView(borrowBookTable);

        javax.swing.GroupLayout borrowBookPageContentOnLayLayout = new javax.swing.GroupLayout(borrowBookPageContentOnLay);
        borrowBookPageContentOnLay.setLayout(borrowBookPageContentOnLayLayout);
        borrowBookPageContentOnLayLayout.setHorizontalGroup(
            borrowBookPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(borrowBookPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(borrowBookPageContentOnLayLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        borrowBookPageContentOnLayLayout.setVerticalGroup(
            borrowBookPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(borrowBookPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(borrowBookPageContentOnLayLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        borrowBookPageLay.add(borrowBookPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        tableContent.add(borrowBookPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        readNowBookPageLay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        readNowBookTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        readNowBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        readNowBookTable.setRowHeight(33);
        readNowBookTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        readNowBookTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane15.setViewportView(readNowBookTable);

        javax.swing.GroupLayout readNowBookPageContentOnLayLayout = new javax.swing.GroupLayout(readNowBookPageContentOnLay);
        readNowBookPageContentOnLay.setLayout(readNowBookPageContentOnLayLayout);
        readNowBookPageContentOnLayLayout.setHorizontalGroup(
            readNowBookPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(readNowBookPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE))
        );
        readNowBookPageContentOnLayLayout.setVerticalGroup(
            readNowBookPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(readNowBookPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
        );

        readNowBookPageLay.add(readNowBookPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        tableContent.add(readNowBookPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        javax.swing.GroupLayout orderBookTablePanelLayout = new javax.swing.GroupLayout(orderBookTablePanel);
        orderBookTablePanel.setLayout(orderBookTablePanelLayout);
        orderBookTablePanelLayout.setHorizontalGroup(
            orderBookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderBookTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderBookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderBookTablePanelLayout.createSequentialGroup()
                        .addComponent(addOrderBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(readNowBook)
                        .addGap(62, 62, 62)
                        .addComponent(borrowBook)
                        .addGap(56, 56, 56)
                        .addComponent(soldBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(refreshOrderBook)
                        .addGap(10, 10, 10))
                    .addComponent(jSeparator21)
                    .addComponent(tableContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        orderBookTablePanelLayout.setVerticalGroup(
            orderBookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderBookTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderBookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderBookTablePanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(searchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderBookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(refreshOrderBook)
                        .addComponent(searchBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderBookTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(readNowBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borrowBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(soldBook))
                    .addComponent(addOrderBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout orderBookPageContentOnLayLayout = new javax.swing.GroupLayout(orderBookPageContentOnLay);
        orderBookPageContentOnLay.setLayout(orderBookPageContentOnLayLayout);
        orderBookPageContentOnLayLayout.setHorizontalGroup(
            orderBookPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderBookPageContentOnLayLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(orderBookTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        orderBookPageContentOnLayLayout.setVerticalGroup(
            orderBookPageContentOnLayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderBookPageContentOnLayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderBookTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        orderBookPageLay.add(orderBookPageContentOnLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 780));

        mainPageContent.add(orderBookPageLay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 780));

        bg.add(mainPageContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1140, 850));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void mainPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPageMouseClicked
        bar(mainPageHover);
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        mainPageContentOnLay.setVisible(true);
        frame = null;
        

    }//GEN-LAST:event_mainPageMouseClicked

    private void tablePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePageMouseClicked
        bar(tablePageHover);
        mainPageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        tablePageContentOnLay.setVisible(true);
        frame = null;
        
        buttonGroup1.clearSelection();
        
        try {
            List<Table> tableList = dao.getTableListByStatusId((long) 2);
            for (Table table : tableList) {
                emptyTableNum.setText(table.getRowNum().toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tablePageMouseClicked

    private void studentPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentPageMouseClicked
        bar(studentPageHover);
        mainPageContentOnLay.setVisible(false);
        tablePageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        
        studentsPageContentOnLay.setVisible(true);
        
        studentsTable.getTableHeader().setOpaque(false);
        studentsTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = studentsTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        frame = null;
        
        studentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = studentsTable.rowAtPoint(e.getPoint());
                int col = studentsTable.columnAtPoint(e.getPoint());
                
                int rowIndex = studentsTable.getSelectedRow();
                Long selectedRow = (Long) studentsTable.getValueAt(rowIndex, 0);
                if (col == StudentEnum.VIEW.getValue()) {
                    if (frame == null) {
                        ViewStudent viewStudent = new ViewStudent(dao, selectedRow);
                        viewStudent.setVisible(true);
                        frame = viewStudent;
                        viewStudent.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == StudentEnum.SEND_MESSAGE.getValue()) {
                    if (frame == null) {
                        NewMessage message = new NewMessage(dao, selectedRow);
                        message.setVisible(true);
                        frame = message;
                        message.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == StudentEnum.EDIT.getValue()) {
                    if (frame == null) {
                        EditStudent editStudent = new EditStudent(dao, selectedRow);
                        editStudent.setVisible(true);
                        frame = editStudent;
                        editStudent.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == StudentEnum.DELETE.getValue()) {
                    JLabel label = new JLabel("Tələbəni silmək isdədiyinizə əminsiz?");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    int isDeleteMsg = JOptionPane.showConfirmDialog(null, label, "Tələbəni Sil", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    
                    if (isDeleteMsg == JOptionPane.YES_OPTION) {
                        try {
                            boolean isDelete = dao.deleteStudent(selectedRow);
                            if (isDelete) {
                                JOptionPane.showMessageDialog(null, "Tələbə Silindi...");
                            } else {
                                JOptionPane.showMessageDialog(null, "Silinmədi!!!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
        }
        );
        

    }//GEN-LAST:event_studentPageMouseClicked

    private void bookPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookPageMouseClicked
        bar(bookPageHover);
        mainPageContentOnLay.setVisible(false);
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        
        bookPageContentOnLay.setVisible(true);
        bookTable.getTableHeader().setOpaque(false);
        bookTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = bookTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        frame = null;
        
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = bookTable.rowAtPoint(e.getPoint());
                int col = bookTable.columnAtPoint(e.getPoint());
                
                int rowIndex = bookTable.getSelectedRow();
                Long selectedRow = (Long) bookTable.getValueAt(rowIndex, 0);
                if (col == BookEnum.VIEW.getValue()) {
                    if (frame == null) {
                        ViewBook viewBook = new ViewBook(dao, selectedRow);
                        viewBook.setVisible(true);
                        frame = viewBook;
                        viewBook.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == BookEnum.EDIT.getValue()) {
                    if (frame == null) {
                        EditBook editBook = new EditBook(dao, selectedRow);
                        editBook.setVisible(true);
                        frame = editBook;
                        
                        editBook.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == BookEnum.DELETE.getValue()) {
                    JLabel label = new JLabel("Kitabı silmək isdədiyinizə əminsiz?");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    int isDeleteMsg = JOptionPane.showConfirmDialog(null, label, "Kitabı Sil", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    
                    if (isDeleteMsg == JOptionPane.YES_OPTION) {
                        try {
                            boolean isDelete = dao.deleteBook(selectedRow);
                            if (isDelete) {
                                JOptionPane.showMessageDialog(null, "Kitab Silindi...");
                            } else {
                                JOptionPane.showMessageDialog(null, "Silinmədi!!!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (col == BookEnum.ORDER_BOOK.getValue()) {
                    try {
                        Book book = dao.getBookById(selectedRow);
                        if (book.getCopies() != 0) {
                            if (frame == null) {
                                AddOrderBookFrame addOrderBookFrame = new AddOrderBookFrame(dao, selectedRow);
                                addOrderBookFrame.setVisible(true);
                                frame = addOrderBookFrame;
                                
                                addOrderBookFrame.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowClosed(WindowEvent e) {
                                        try {
                                            frame = null;
                                            List<Book> bookList = dao.getBookList();
                                            ViewBookListInTable(bookList);
                                            refreshBookMouseClicked(evt);
                                        } catch (Exception ex) {
                                            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Hal hazırda əlimizdə bu kitabdan yoxdur");
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        }
        );
        

    }//GEN-LAST:event_bookPageMouseClicked

    private void authorPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorPageMouseClicked
        bar(authorPageHover);
        frame = null;
        mainPageContentOnLay.setVisible(false);
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(true);
        authorTable.getTableHeader().setOpaque(false);
        authorTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = authorTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        
        authorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = authorTable.rowAtPoint(e.getPoint());
                int col = authorTable.columnAtPoint(e.getPoint());
                
                int rowIndex = authorTable.getSelectedRow();
                Long selectedRow = (Long) authorTable.getValueAt(rowIndex, 0);
                if (col == EnumSixToEight.VIEW.getValue() && frame == null) {
                    
                    ViewAuthor viewAuthor = new ViewAuthor(dao, selectedRow);
                    viewAuthor.setVisible(true);
                    frame = viewAuthor;
                    viewAuthor.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            frame = null;
                        }
                    });
                    
                }
                if (col == EnumSixToEight.EDIT.getValue() && frame == null) {
                    EditAuthor editAuthor = new EditAuthor(dao, selectedRow);
                    editAuthor.setVisible(true);
                    frame = editAuthor;
                    
                    editAuthor.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            frame = null;
                        }
                    });
                    
                }
                if (col == EnumSixToEight.DELETE.getValue()) {
                    JLabel label = new JLabel("Müəllifi silmək isdədiyinizə əminsiz?");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    int isDeleteMsg = JOptionPane.showConfirmDialog(null, label, "Müəllifi Sil", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    
                    if (isDeleteMsg == JOptionPane.YES_OPTION) {
                        try {
                            boolean isDelete = dao.deleteAuthor(selectedRow);
                            if (isDelete) {
                                JOptionPane.showMessageDialog(null, "Müəllif Silindi...");
                            } else {
                                JOptionPane.showMessageDialog(null, "Silinmədi!!!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
        }
        );

    }//GEN-LAST:event_authorPageMouseClicked

    private void menuPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPageMouseClicked
        bar(menuPageHover);
        frame = null;
        mainPageContentOnLay.setVisible(false);
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(true);
        menuTable.getTableHeader().setOpaque(false);
        menuTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = menuTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        
        menuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = menuTable.rowAtPoint(e.getPoint());
                int col = menuTable.columnAtPoint(e.getPoint());
                
                int rowIndex = menuTable.getSelectedRow();
                Long selectedRow = (Long) menuTable.getValueAt(rowIndex, 0);
                if (col == MenuEnum.VIEW.getValue()) {
                    if (frame == null) {
                        ViewMenu viewMenu = new ViewMenu(dao, selectedRow);
                        viewMenu.setVisible(true);
                        frame = viewMenu;
                        viewMenu.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == MenuEnum.EDIT.getValue()) {
                    if (frame == null) {
                        EditMenu editMenu = new EditMenu(dao, selectedRow);
                        editMenu.setVisible(true);
                        frame = editMenu;
                        
                        editMenu.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == MenuEnum.DELETE.getValue()) {
                    JLabel label = new JLabel("Menyunu silmək isdədiyinizə əminsiz?");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    int isDeleteMsg = JOptionPane.showConfirmDialog(null, label, "Menyunu Sil", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    
                    if (isDeleteMsg == JOptionPane.YES_OPTION) {
                        try {
                            boolean isDelete = dao.deleteMenu(selectedRow);
                            if (isDelete) {
                                JOptionPane.showMessageDialog(null, "Menyu Silindi...");
                            } else {
                                JOptionPane.showMessageDialog(null, "Silinmədi!!!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
        }
        );

    }//GEN-LAST:event_menuPageMouseClicked

    private void orderPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderPageMouseClicked
        bar(orderPageHover);
        frame = null;
        mainPageContentOnLay.setVisible(false);
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(true);
        orderTable.getTableHeader().setOpaque(false);
        orderTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = orderTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = orderTable.rowAtPoint(e.getPoint());
                int col = orderTable.columnAtPoint(e.getPoint());
                
                int rowIndex = orderTable.getSelectedRow();
                Long selectedRow = (Long) orderTable.getValueAt(rowIndex, 0);
                if (col == EnumSixToEight.VIEW.getValue()) {
                    if (frame == null) {
                        ViewTableOrder viewTableOrder = new ViewTableOrder(dao, selectedRow);
                        viewTableOrder.setVisible(true);
                        frame = viewTableOrder;
                        viewTableOrder.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == EnumSixToEight.EDIT.getValue()) {
                    if (frame == null) {
                        EditTableOrder editTableOrder = new EditTableOrder(dao, selectedRow);
                        editTableOrder.setVisible(true);
                        frame = editTableOrder;
                        
                        editTableOrder.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == EnumSixToEight.DELETE.getValue()) {
                    JLabel label = new JLabel("Menyunu silmək isdədiyinizə əminsiz?");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    int isDeleteMsg = JOptionPane.showConfirmDialog(null, label, "Menyunu Sil", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    
                    if (isDeleteMsg == JOptionPane.YES_OPTION) {
                        try {
                            boolean isDelete = dao.deleteMenu(selectedRow);
                            if (isDelete) {
                                JOptionPane.showMessageDialog(null, "Menyu Silindi...");
                            } else {
                                JOptionPane.showMessageDialog(null, "Silinmədi!!!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
        }
        );
        

    }//GEN-LAST:event_orderPageMouseClicked

    private void calcPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calcPageMouseClicked
        bar(calcPageHover);
        frame = null;
        mainPageContentOnLay.setVisible(false);
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(true);
        
        paidTable.getTableHeader().setOpaque(false);
        paidTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = paidTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        
        productTable.getTableHeader().setOpaque(false);
        productTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f1 = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header1 = productTable.getTableHeader();
        header1.setFont(f1);
        header1.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header1.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = productTable.rowAtPoint(e.getPoint());
                int col = productTable.columnAtPoint(e.getPoint());
                
                int rowIndex = productTable.getSelectedRow();
                Long selectedRow = (Long) productTable.getValueAt(rowIndex, 0);
                if (col == EnumSixToEight.VIEW.getValue() && frame == null) {
                    ViewProduct viewProduct = new ViewProduct(dao, selectedRow);
                    viewProduct.setVisible(true);
                    frame = viewProduct;
                    viewProduct.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            frame = null;
                        }
                    });
                    
                }
                if (col == EnumSixToEight.EDIT.getValue() && frame == null) {
                    
                    EditProduct editProduct = new EditProduct(dao, selectedRow);
                    editProduct.setVisible(true);
                    frame = editProduct;
                    
                    editProduct.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            frame = null;
                        }
                    });
                    
                }
                if (col == EnumSixToEight.DELETE.getValue()) {
                    JLabel label = new JLabel("Produktu silmək isdədiyinizə əminsiz?");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    int isDeleteMsg = JOptionPane.showConfirmDialog(null, label, "Produktu Sil", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    
                    if (isDeleteMsg == JOptionPane.YES_OPTION) {
                        try {
                            boolean isDelete = dao.deleteProduct(selectedRow);
                            if (isDelete) {
                                JOptionPane.showMessageDialog(null, "Produkt Silindi...");
                            } else {
                                JOptionPane.showMessageDialog(null, "Silinmədi!!!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
        }
        );
        

    }//GEN-LAST:event_calcPageMouseClicked

    private void emailPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailPageMouseClicked
        bar(emailPageHover);
        frame = null;
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        mainPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(true);
        
        sendEmailTable.getTableHeader().setOpaque(false);
        sendEmailTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = sendEmailTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        

    }//GEN-LAST:event_emailPageMouseClicked

    private void mainPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPageMouseEntered
        mainPage.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_mainPageMouseEntered

    private void mainPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPageMouseExited
        mainPage.setBackground(Color.decode("#0066FF"));
    }//GEN-LAST:event_mainPageMouseExited

    private void tablePageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePageMouseEntered
        tablePage.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_tablePageMouseEntered

    private void tablePageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePageMouseExited
        tablePage.setBackground(Color.decode("#0066FF"));
    }//GEN-LAST:event_tablePageMouseExited

    private void studentPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentPageMouseEntered
        studentPage.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_studentPageMouseEntered

    private void studentPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentPageMouseExited
        studentPage.setBackground(Color.decode("#0066FF"));
    }//GEN-LAST:event_studentPageMouseExited

    private void bookPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookPageMouseEntered
        bookPage.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_bookPageMouseEntered

    private void bookPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookPageMouseExited
        bookPage.setBackground(Color.decode("#0066FF"));
    }//GEN-LAST:event_bookPageMouseExited

    private void authorPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorPageMouseEntered
        authorPage.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_authorPageMouseEntered

    private void authorPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorPageMouseExited
        authorPage.setBackground(Color.decode("#0066FF"));
    }//GEN-LAST:event_authorPageMouseExited

    private void menuPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPageMouseEntered
        menuPage.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_menuPageMouseEntered

    private void menuPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPageMouseExited
        menuPage.setBackground(Color.decode("#0066FF"));
    }//GEN-LAST:event_menuPageMouseExited

    private void orderPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderPageMouseEntered
        orderPage.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_orderPageMouseEntered

    private void orderPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderPageMouseExited
        orderPage.setBackground(Color.decode("#0066FF"));
    }//GEN-LAST:event_orderPageMouseExited

    private void calcPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calcPageMouseEntered
        calcPage.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_calcPageMouseEntered

    private void calcPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calcPageMouseExited
        calcPage.setBackground(Color.decode("#0066FF"));
    }//GEN-LAST:event_calcPageMouseExited

    private void emailPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailPageMouseEntered
        emailPage.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_emailPageMouseEntered

    private void emailPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailPageMouseExited
        emailPage.setBackground(Color.decode("#0066FF"));
    }//GEN-LAST:event_emailPageMouseExited

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void studentsMoreInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMoreInfoMouseEntered
        studentsMoreInfo.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_studentsMoreInfoMouseEntered

    private void studentsMoreInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMoreInfoMouseExited
        studentsMoreInfo.setBackground(Color.decode("#F0B340"));
    }//GEN-LAST:event_studentsMoreInfoMouseExited

    private void bookMoreInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookMoreInfoMouseEntered
        bookMoreInfo.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_bookMoreInfoMouseEntered

    private void bookMoreInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookMoreInfoMouseExited
        bookMoreInfo.setBackground(Color.decode("#FF0C0C"));
    }//GEN-LAST:event_bookMoreInfoMouseExited

    private void employeeMoreInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMoreInfoMouseEntered
        employeeMoreInfo.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_employeeMoreInfoMouseEntered

    private void employeeMoreInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMoreInfoMouseExited
        employeeMoreInfo.setBackground(Color.decode("#17A907"));
    }//GEN-LAST:event_employeeMoreInfoMouseExited

    private void shelf11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shelf11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shelf11ActionPerformed

    private void employeePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeePageMouseClicked
        bar(employeePageHover);
        frame = null;
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        mainPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(true);
        
        employeeTable.getTableHeader().setOpaque(false);
        employeeTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = employeeTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = employeeTable.rowAtPoint(e.getPoint());
                int col = employeeTable.columnAtPoint(e.getPoint());
                
                int rowIndex = employeeTable.getSelectedRow();
                Long selectedRow = (Long) employeeTable.getValueAt(rowIndex, 0);
                if (col == EmployeeEnum.VIEW.getValue() && frame == null) {
                    
                    ViewEmployee viewEmployee = new ViewEmployee(dao, selectedRow);
                    viewEmployee.setVisible(true);
                    frame = viewEmployee;
                    viewEmployee.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            frame = null;
                        }
                    });
                    
                }
                if (col == EmployeeEnum.EDIT.getValue() && frame == null) {
                    
                    EditEmployee editEmployee = new EditEmployee(dao, selectedRow);
                    editEmployee.setVisible(true);
                    frame = editEmployee;
                    
                    editEmployee.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            try {
                                frame = null;
                                List<Employee> employeeList = dao.getEmployeeList();
                                ViewEmployeeListInTable(employeeList);
                            } catch (Exception ex) {
                                Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    
                }
                if (col == EmployeeEnum.DELETE.getValue()) {
                    JLabel label = new JLabel("İşçini silmək isdədiyinizə əminsiz?");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    int isDeleteMsg = JOptionPane.showConfirmDialog(null, label, "İşçini Sil", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    
                    if (isDeleteMsg == JOptionPane.YES_OPTION) {
                        try {
                            boolean isDelete = dao.deleteAuthor(selectedRow);
                            if (isDelete) {
                                JOptionPane.showMessageDialog(null, "İşçi Silindi...");
                            } else {
                                JOptionPane.showMessageDialog(null, "Silinmədi!!!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
        }
        );

    }//GEN-LAST:event_employeePageMouseClicked

    private void employeePageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeePageMouseEntered
        employeePage.setBackground(Color.decode("#000"));
    }//GEN-LAST:event_employeePageMouseEntered

    private void employeePageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeePageMouseExited
        employeePage.setBackground(Color.decode("#0066FF"));
    }//GEN-LAST:event_employeePageMouseExited

    private void studentsMoreInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMoreInfoMouseClicked
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        mainPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        
        bar(studentPageHover);
        studentsPageContentOnLay.setVisible(true);
        studentsTable.getTableHeader().setOpaque(false);
        studentsTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = studentsTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }//GEN-LAST:event_studentsMoreInfoMouseClicked

    private void bookMoreInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookMoreInfoMouseClicked
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        employeePageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        mainPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        
        bar(bookPageHover);
        bookPageContentOnLay.setVisible(true);
        bookTable.getTableHeader().setOpaque(false);
        bookTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = bookTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }//GEN-LAST:event_bookMoreInfoMouseClicked

    private void employeeMoreInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMoreInfoMouseClicked
        tablePageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        authorPageContentOnLay.setVisible(false);
        menuPageContentOnLay.setVisible(false);
        orderPageContentOnLay.setVisible(false);
        bookAdvancedSearchPageContentOnLay.setVisible(false);
        calcPageContentOnLay.setVisible(false);
        mainPageContentOnLay.setVisible(false);
        orderBookPageContentOnLay.setVisible(false);
        emailPageContentOnLay.setVisible(false);
        studentsPageContentOnLay.setVisible(false);
        bookPageContentOnLay.setVisible(false);
        
        bar(employeePageHover);
        employeePageContentOnLay.setVisible(true);
        employeeTable.getTableHeader().setOpaque(false);
        employeeTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
        Font f = new Font("Calibri", Font.ITALIC, 18);
        JTableHeader header = employeeTable.getTableHeader();
        header.setFont(f);
        header.setForeground(Color.white);
        
        ((DefaultTableCellRenderer) header.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
    }//GEN-LAST:event_employeeMoreInfoMouseClicked

    private void addOrderToTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOrderToTableMouseClicked
        AddOrderToTableFrame frame = new AddOrderToTableFrame(dao);
        frame.setVisible(true);
    }//GEN-LAST:event_addOrderToTableMouseClicked

    private void addStudentIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStudentIconMouseClicked
        try {
            AddStudentFrame addStudentFrame = new AddStudentFrame(dao);
            addStudentFrame.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addStudentIconMouseClicked

    private void addEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEmployeeMouseClicked
        AddEmployeeFrame addEmployeeFrame = new AddEmployeeFrame(dao);
        addEmployeeFrame.setVisible(true);
    }//GEN-LAST:event_addEmployeeMouseClicked

    private void addAuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAuthorMouseClicked
        AddAuthor addAuthor = new AddAuthor(dao);
        addAuthor.setVisible(true);
    }//GEN-LAST:event_addAuthorMouseClicked

    private void addMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMenuMouseClicked
        AddMenu addMenu = new AddMenu(dao);
        addMenu.setVisible(true);
    }//GEN-LAST:event_addMenuMouseClicked

    private void addProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductMouseClicked
        AddProduct addProduct = new AddProduct(dao);
        addProduct.setVisible(true);
    }//GEN-LAST:event_addProductMouseClicked

    private void addBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBookMouseClicked
        AddBookFrame addBookFrame = new AddBookFrame(dao);
        addBookFrame.setVisible(true);
    }//GEN-LAST:event_addBookMouseClicked

    private void refreshStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshStudentMouseClicked
        try {
            frame = null;
            List<Student> studentList = dao.getStudentList();
            ViewStudentListInTable(studentList);
            
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_refreshStudentMouseClicked

    private void refreshBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBookMouseClicked
        try {
            frame = null;
            List<Book> bookList = dao.getBookList();
            ViewBookListInTable(bookList);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshBookMouseClicked

    private void refreshAuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshAuthorMouseClicked
        try {
            frame = null;
            List<Author> authorList = dao.getAuthorList();
            ViewAuthorListInTable(authorList);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshAuthorMouseClicked

    private void refreshEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshEmployeeMouseClicked
        try {
            frame = null;
            List<Employee> employeeList = dao.getEmployeeList();
            ViewEmployeeListInTable(employeeList);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshEmployeeMouseClicked

    private void refreshMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMenuMouseClicked
        try {
            frame = null;
            List<Menu> menuList = dao.getMenuList();
            ViewMenuListInTable(menuList);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshMenuMouseClicked

    private void refreshCalcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshCalcMouseClicked
        try {
            frame = null;
            List<Product> productList = dao.getProductList();
            ViewProductListInTable(productList);
            
            List<Paid> paidList = dao.getPaidList();
            ViewPaidListInTable(paidList);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshCalcMouseClicked

    private void newMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newMessageMouseClicked
        NewMessage message = new NewMessage(dao);
        message.setVisible(true);
    }//GEN-LAST:event_newMessageMouseClicked

    private void orderBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderBookMouseClicked
        try {
            bookPageContentOnLay.setVisible(false);
            bookAdvancedSearchPageContentOnLay.setVisible(false);
            orderBookPageContentOnLay.setVisible(true);
            
            soldBookTable.getTableHeader().setOpaque(false);
            soldBookTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
            Font f = new Font("Calibri", Font.ITALIC, 18);
            JTableHeader header = soldBookTable.getTableHeader();
            header.setFont(f);
            header.setForeground(Color.white);
            
            ((DefaultTableCellRenderer) header.getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.CENTER);
            
            borrowBookTable.getTableHeader().setOpaque(false);
            borrowBookTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
            Font f1 = new Font("Calibri", Font.ITALIC, 18);
            JTableHeader header1 = borrowBookTable.getTableHeader();
            header1.setFont(f1);
            header1.setForeground(Color.white);
            
            ((DefaultTableCellRenderer) header1.getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.CENTER);
            
            readNowBookTable.getTableHeader().setOpaque(false);
            readNowBookTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
            Font f2 = new Font("Calibri", Font.ITALIC, 18);
            JTableHeader header2 = readNowBookTable.getTableHeader();
            header2.setFont(f2);
            header2.setForeground(Color.white);
            
            ((DefaultTableCellRenderer) header2.getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.CENTER);
            
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_orderBookMouseClicked

    private void soldBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soldBookActionPerformed
        if (soldBook.isSelected()) {
            try {
                borrowBookPageContentOnLay.setVisible(false);
                bookAdvancedSearchPageContentOnLay.setVisible(false);
                readNowBookPageContentOnLay.setVisible(false);
                soldBookPageContentOnLay.setVisible(true);
                globCheckName = "sold";
                List<OrderBook> orderBookList = dao.getOrderBookList((long) 1);
                ViewSoldBookListInTable(orderBookList, globCheckName);
            } catch (Exception ex) {
                Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_soldBookActionPerformed

    private void borrowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowBookActionPerformed
        try {
            if (borrowBook.isSelected()) {
                readNowBookPageContentOnLay.setVisible(false);
                bookAdvancedSearchPageContentOnLay.setVisible(false);
                soldBookPageContentOnLay.setVisible(false);
                borrowBookPageContentOnLay.setVisible(true);
                
                globCheckName = "borrow";
                List<OrderBook> orderBookList = dao.getOrderBookList((long) 2);
                ViewBorrowBookListInTable(orderBookList, globCheckName);
            }
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_borrowBookActionPerformed

    private void readNowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readNowBookActionPerformed
        if (readNowBook.isSelected()) {
            try {
                soldBookPageContentOnLay.setVisible(false);
                bookAdvancedSearchPageContentOnLay.setVisible(false);
                borrowBookPageContentOnLay.setVisible(false);
                readNowBookPageContentOnLay.setVisible(true);
                globCheckName = "readNow";
                List<OrderBook> orderBookList = dao.getOrderBookList((long) 4);
                ViewReadNowBookListInTable(orderBookList, globCheckName);
            } catch (Exception ex) {
                Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_readNowBookActionPerformed

    private void refreshOrderBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshOrderBookMouseClicked
        try {
            if (soldBook.isSelected()) {
                borrowBookPageContentOnLay.setVisible(false);
                bookAdvancedSearchPageContentOnLay.setVisible(false);
                readNowBookPageContentOnLay.setVisible(false);
                soldBookPageContentOnLay.setVisible(true);
                globCheckName = BookType.SOLD.getValue();
                List<OrderBook> orderBookList = dao.getOrderBookList((long) 1);
                ViewSoldBookListInTable(orderBookList, globCheckName);
            }
            if (borrowBook.isSelected()) {
                readNowBookPageContentOnLay.setVisible(false);
                bookAdvancedSearchPageContentOnLay.setVisible(false);
                soldBookPageContentOnLay.setVisible(false);
                borrowBookPageContentOnLay.setVisible(true);
                
                globCheckName = BookType.BORROW.getValue();
                List<OrderBook> orderBookList = dao.getOrderBookList((long) 2);
                ViewBorrowBookListInTable(orderBookList, globCheckName);
            }
            if (readNowBook.isSelected()) {
                soldBookPageContentOnLay.setVisible(false);
                bookAdvancedSearchPageContentOnLay.setVisible(false);
                borrowBookPageContentOnLay.setVisible(false);
                readNowBookPageContentOnLay.setVisible(true);
                globCheckName = BookType.READNOW.getValue();
                List<OrderBook> orderBookList = dao.getOrderBookList((long) 4);
                ViewReadNowBookListInTable(orderBookList, globCheckName);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_refreshOrderBookMouseClicked

    private void masa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masa1ActionPerformed

    }//GEN-LAST:event_masa1ActionPerformed

    private void emptyTableCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyTableCheckActionPerformed
        try {
            if (emptyTableCheck.isSelected()) {
                List<Table> tableList = dao.getTableList();
                for (Table table : tableList) {
                    if (table.getTableStatus().getId() == 2 && table.getId() == 1) {
                        masa1.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 2) {
                        masa2.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 3) {
                        masa3.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 4) {
                        masa4.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 5) {
                        masa5.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 6) {
                        masa6.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 7) {
                        masa7.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 8) {
                        masa8.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 9) {
                        masa9.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 10) {
                        masa10.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 11) {
                        masa11.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 12) {
                        masa12.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 13) {
                        masa13.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 14) {
                        masa14.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 15) {
                        masa15.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 16) {
                        masa16.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 17) {
                        masa17.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 18) {
                        masa18.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 19) {
                        masa19.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 20) {
                        masa20.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 21) {
                        masa21.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 22) {
                        masa22.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 23) {
                        masa23.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 24) {
                        masa24.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 25) {
                        masa25.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 26) {
                        masa26.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 27) {
                        masa27.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 28) {
                        masa28.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 29) {
                        masa29.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 30) {
                        masa30.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 31) {
                        masa31.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 32) {
                        masa32.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 33) {
                        masa33.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 34) {
                        masa34.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 35) {
                        masa35.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 36) {
                        masa36.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 37) {
                        masa37.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 38) {
                        masa38.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 39) {
                        masa39.setEnabled(false);
                    }
                    if (table.getTableStatus().getId() == 2 && table.getId() == 40) {
                        masa40.setEnabled(false);
                    }
                }
            } else {
                masa1.setEnabled(true);
                masa2.setEnabled(true);
                masa3.setEnabled(true);
                masa4.setEnabled(true);
                masa5.setEnabled(true);
                masa6.setEnabled(true);
                masa7.setEnabled(true);
                masa8.setEnabled(true);
                masa9.setEnabled(true);
                masa10.setEnabled(true);
                masa11.setEnabled(true);
                masa12.setEnabled(true);
                masa13.setEnabled(true);
                masa14.setEnabled(true);
                masa15.setEnabled(true);
                masa16.setEnabled(true);
                masa17.setEnabled(true);
                masa18.setEnabled(true);
                masa19.setEnabled(true);
                masa20.setEnabled(true);
                masa21.setEnabled(true);
                masa22.setEnabled(true);
                masa23.setEnabled(true);
                masa24.setEnabled(true);
                masa25.setEnabled(true);
                masa26.setEnabled(true);
                masa27.setEnabled(true);
                masa28.setEnabled(true);
                masa29.setEnabled(true);
                masa30.setEnabled(true);
                masa31.setEnabled(true);
                masa32.setEnabled(true);
                masa33.setEnabled(true);
                masa34.setEnabled(true);
                masa35.setEnabled(true);
                masa36.setEnabled(true);
                masa37.setEnabled(true);
                masa38.setEnabled(true);
                masa39.setEnabled(true);
                masa40.setEnabled(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_emptyTableCheckActionPerformed

    private void allTableCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allTableCheckActionPerformed
        if (allTableCheck.isSelected()) {
            masa1.setEnabled(true);
            masa2.setEnabled(true);
            masa3.setEnabled(true);
            masa4.setEnabled(true);
            masa5.setEnabled(true);
            masa6.setEnabled(true);
            masa7.setEnabled(true);
            masa8.setEnabled(true);
            masa9.setEnabled(true);
            masa10.setEnabled(true);
            masa11.setEnabled(true);
            masa12.setEnabled(true);
            masa13.setEnabled(true);
            masa14.setEnabled(true);
            masa15.setEnabled(true);
            masa16.setEnabled(true);
            masa17.setEnabled(true);
            masa18.setEnabled(true);
            masa19.setEnabled(true);
            masa20.setEnabled(true);
            masa21.setEnabled(true);
            masa22.setEnabled(true);
            masa23.setEnabled(true);
            masa24.setEnabled(true);
            masa25.setEnabled(true);
            masa26.setEnabled(true);
            masa27.setEnabled(true);
            masa28.setEnabled(true);
            masa29.setEnabled(true);
            masa30.setEnabled(true);
            masa31.setEnabled(true);
            masa32.setEnabled(true);
            masa33.setEnabled(true);
            masa34.setEnabled(true);
            masa35.setEnabled(true);
            masa36.setEnabled(true);
            masa37.setEnabled(true);
            masa38.setEnabled(true);
            masa39.setEnabled(true);
            masa40.setEnabled(true);
        }
    }//GEN-LAST:event_allTableCheckActionPerformed

    private void addOrderBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOrderBookMouseClicked
        if (frame == null) {
            AddOrderBookFrame addOrderBookFrame = new AddOrderBookFrame(dao);
            addOrderBookFrame.setVisible(true);
            frame = addOrderBookFrame;
            addOrderBookFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    try {
                        frame = null;
                        List<TableOrder> tableOrderList = dao.getTableOrderList();
                        ViewTableOrderListInTable(tableOrderList);
                    } catch (Exception ex) {
                        Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        List<TableOrder> tableOrderList = dao.getTableOrderList();
                        ViewTableOrderListInTable(tableOrderList);
                    } catch (Exception ex) {
                        Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            });
            
        }

    }//GEN-LAST:event_addOrderBookMouseClicked

    private void refreshOrderPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshOrderPageMouseClicked
        try {
            List<TableOrder> tableOrderList = dao.getTableOrderList();
            ViewTableOrderListInTable(tableOrderList);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshOrderPageMouseClicked

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        try {
            String keyword = searchForStudents.getText();
            List<Student> searchStudent = dao.searchStudent(keyword);
            ViewStudentListInTable(searchStudent);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBtnMouseClicked

    private void searchForStudentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForStudentsKeyReleased
        searchBtnMouseClicked(null);
    }//GEN-LAST:event_searchForStudentsKeyReleased

    private void searchForStudentsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForStudentsKeyPressed

    }//GEN-LAST:event_searchForStudentsKeyPressed

    private void searchBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBookBtnMouseClicked
        try {
            List<Book> searchBook = dao.searchBook(searchForBook.getText());
            ViewBookListInTable(searchBook);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBookBtnMouseClicked

    private void searchForBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForBookKeyReleased
        searchBookBtnMouseClicked(null);
    }//GEN-LAST:event_searchForBookKeyReleased

    private void searchAuthorBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchAuthorBtnMouseClicked
        try {
            List<Author> searchAuthor = dao.searchAuthor(searchForAuthor.getText());
            ViewAuthorListInTable(searchAuthor);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchAuthorBtnMouseClicked

    private void searchForAuthorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForAuthorKeyReleased
        searchAuthorBtnMouseClicked(null);
    }//GEN-LAST:event_searchForAuthorKeyReleased

    private void searchMenuBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMenuBtnMouseClicked
        try {
            List<Menu> searchMenu = dao.searchMenu(searchForMenu.getText());
            ViewMenuListInTable(searchMenu);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchMenuBtnMouseClicked

    private void searchForMenuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForMenuKeyReleased
        searchMenuBtnMouseClicked(null);
    }//GEN-LAST:event_searchForMenuKeyReleased

    private void searchOrderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchOrderBtnMouseClicked
        try {
            List<TableOrder> searchTableOrder = dao.searchTableOrder(searchForOrder.getText());
            ViewTableOrderListInTable(searchTableOrder);
            
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchOrderBtnMouseClicked

    private void searchForOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForOrderKeyReleased
        searchOrderBtnMouseClicked(null);
    }//GEN-LAST:event_searchForOrderKeyReleased

    private void searchProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchProductBtnActionPerformed
        try {
            List<Product> searchProduct = dao.searchProduct(searchForProduct.getText());
            ViewProductListInTable(searchProduct);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchProductBtnActionPerformed

    private void searchForProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForProductKeyReleased
        searchProductBtnActionPerformed(null);
    }//GEN-LAST:event_searchForProductKeyReleased

    private void searchForEmailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchForEmailBtnActionPerformed
        try {
            List<SendEmail> searchEmail = dao.searchEmail(searchForEmail.getText());
            ViewSendEmailList(searchEmail);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchForEmailBtnActionPerformed

    private void searchForEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForEmailKeyReleased
        searchForEmailBtnActionPerformed(null);
    }//GEN-LAST:event_searchForEmailKeyReleased

    private void searchEmployeeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchEmployeeBtnMouseClicked
        try {
            List<Employee> searchEmployee = dao.searchEmployee(searchForEmployee.getText());
            ViewEmployeeListInTable(searchEmployee);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchEmployeeBtnMouseClicked

    private void searchForEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForEmployeeKeyReleased
        searchEmployeeBtnMouseClicked(null);
    }//GEN-LAST:event_searchForEmployeeKeyReleased

    private void searchBookButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBookButtonMouseClicked
        try {
            if (soldBook.isSelected()) {
                borrowBookPageContentOnLay.setVisible(false);
                readNowBookPageContentOnLay.setVisible(false);
                soldBookPageContentOnLay.setVisible(true);
                globCheckName = BookType.SOLD.getValue();
                List<OrderBook> orderBookList = dao.searchOrderBook(searchBook.getText(), (long) 1);
                ViewSoldBookListInTable(orderBookList, globCheckName);
            }
            if (borrowBook.isSelected()) {
                readNowBookPageContentOnLay.setVisible(false);
                soldBookPageContentOnLay.setVisible(false);
                borrowBookPageContentOnLay.setVisible(true);
                
                globCheckName = BookType.BORROW.getValue();
                List<OrderBook> orderBookList = dao.searchOrderBook(searchBook.getText(), (long) 2);
                ViewBorrowBookListInTable(orderBookList, globCheckName);
            }
            if (readNowBook.isSelected()) {
                soldBookPageContentOnLay.setVisible(false);
                borrowBookPageContentOnLay.setVisible(false);
                readNowBookPageContentOnLay.setVisible(true);
                globCheckName = BookType.READNOW.getValue();
                List<OrderBook> orderBookList = dao.searchOrderBook(searchBook.getText(), (long) 4);
                ViewReadNowBookListInTable(orderBookList, globCheckName);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchBookButtonMouseClicked

    private void searchBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBookKeyReleased
        searchBookButtonMouseClicked(null);
    }//GEN-LAST:event_searchBookKeyReleased

    private void advancedSearchBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_advancedSearchBookBtnMouseClicked
        try {
            tipCombo.removeAllItems();
            tablePageContentOnLay.setVisible(false);
            studentsPageContentOnLay.setVisible(false);
            authorPageContentOnLay.setVisible(false);
            menuPageContentOnLay.setVisible(false);
            bookAdvancedSearchPageContentOnLay.setVisible(false);
            orderPageContentOnLay.setVisible(false);
            employeePageContentOnLay.setVisible(false);
            calcPageContentOnLay.setVisible(false);
            mainPageContentOnLay.setVisible(false);
            emailPageContentOnLay.setVisible(false);
            orderBookPageContentOnLay.setVisible(false);
            studentsPageContentOnLay.setVisible(false);
            bookPageContentOnLay.setVisible(false);
            bookAdvancedSearchPageContentOnLay.setVisible(true);
            
            advancedBookTable.getTableHeader().setOpaque(false);
            advancedBookTable.getTableHeader().setBackground(Color.decode("#3E68FF"));
            Font f = new Font("Calibri", Font.ITALIC, 18);
            JTableHeader header = advancedBookTable.getTableHeader();
            header.setFont(f);
            header.setForeground(Color.white);
            
            ((DefaultTableCellRenderer) header.getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.CENTER);
            frame = null;
            
            ViewBookTipListInComboBox();
            
            advancedBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
                
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    int row = advancedBookTable.rowAtPoint(e.getPoint());
                    int col = advancedBookTable.columnAtPoint(e.getPoint());
                    
                    int rowIndex = advancedBookTable.getSelectedRow();
                    Long selectedRow = (Long) advancedBookTable.getValueAt(rowIndex, 0);
                    if (col == 9) {
                        if (frame == null) {
                            ViewBook viewBook = new ViewBook(dao, selectedRow);
                            viewBook.setVisible(true);
                            frame = viewBook;
                            viewBook.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    frame = null;
                                }
                            });
                        }
                        
                    }
                    if (col == 10) {
                        if (frame == null) {
                            EditBook editBook = new EditBook(dao, selectedRow);
                            editBook.setVisible(true);
                            frame = editBook;
                            
                            editBook.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    frame = null;
                                }
                            });
                        }
                        
                    }
                    if (col == 11) {
                        JLabel label = new JLabel("Kitabı silmək isdədiyinizə əminsiz?");
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        int isDeleteMsg = JOptionPane.showConfirmDialog(null, label, "Kitabı Sil", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                        
                        if (isDeleteMsg == JOptionPane.YES_OPTION) {
                            try {
                                boolean isDelete = dao.deleteBook(selectedRow);
                                if (isDelete) {
                                    JOptionPane.showMessageDialog(null, "Kitab Silindi...");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Silinmədi!!!");
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    if (col == 12) {
                        try {
                            Book book = dao.getBookById(selectedRow);
                            if (book.getCopies() != 0) {
                                if (frame == null) {
                                    AddOrderBookFrame addOrderBookFrame = new AddOrderBookFrame(dao, selectedRow);
                                    addOrderBookFrame.setVisible(true);
                                    frame = addOrderBookFrame;
                                    
                                    addOrderBookFrame.addWindowListener(new WindowAdapter() {
                                        @Override
                                        public void windowClosed(WindowEvent e) {
                                            try {
                                                frame = null;
                                                List<Book> bookList = dao.getBookList();
                                                ViewBookListInTable(bookList);
                                                refreshBookMouseClicked(evt);
                                            } catch (Exception ex) {
                                                Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    });
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Hal hazırda əlimizdə bu kitabdan yoxdur");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
            }
            );
            
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_advancedSearchBookBtnMouseClicked

    private void searchAdvancedBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchAdvancedBookMouseClicked
        try {
            
            AdvancedSearch advancedSearch = new AdvancedSearch();
            Item tipItem = (Item) tipCombo.getSelectedItem();
            advancedSearch.setBookTipId(tipItem.getId());
            
            advancedSearch.setMinCopies(minCopies.getText());
            advancedSearch.setMaxCopies(maxCopies.getText());
            advancedSearch.setMinPageNum(minPageNum.getText());
            advancedSearch.setMaxPageNum(maxPageNum.getText());
            advancedSearch.setMinPrice(Float.valueOf(minPrice.getText()));
            advancedSearch.setMaxPrice(Float.valueOf(maxPrice.getText()));
            
            List<Book> bookList = dao.advancedSearchBook(advancedSearch);;
            ViewAdvancedBookListInTable(bookList);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchAdvancedBookMouseClicked

    private void searchProductAdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchProductAdvMouseClicked
        try {
            AdvancedSearch advancedSearch = new AdvancedSearch();
            advancedSearch.setMinNum(minNum.getText());
            advancedSearch.setMaxNum(maxNum.getText());
            
            if (!beginMoney.getText().isEmpty()) {
                advancedSearch.setMinPrice(Float.parseFloat(beginMoney.getText()));
            }
            
            if (!endMoney.getText().isEmpty()) {
                advancedSearch.setMaxPrice(Float.parseFloat(endMoney.getText()));
            }
            
            List<Product> productList = dao.advancedSearchProduct(advancedSearch);
            ViewProductListInTable(productList);
            
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchProductAdvMouseClicked

    private void paidBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paidBtnMouseClicked
        
        int rowIndex = orderTable.getSelectedRow();
        Long selectedRow = (Long) orderTable.getValueAt(rowIndex, 0);
        if (frame == null) {
            PaidFrame paidFrame = new PaidFrame(dao, selectedRow);
            paidFrame.setVisible(true);
            frame = paidFrame;
            
            paidFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    try {
                        frame = null;
                        refreshOrderPageMouseClicked(evt);
                        List<TableOrder> tableOrderList = dao.getTableOrderList();
                        ViewTableOrderListInTable(tableOrderList);
                    } catch (Exception ex) {
                        Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
    }//GEN-LAST:event_paidBtnMouseClicked

    private void searchPaidBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPaidBtnActionPerformed
        try {
            List<Paid> paidList = dao.searchPaid(searchForPaid.getText());
            ViewPaidListInTable(paidList);
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchPaidBtnActionPerformed

    private void searchForPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchForPaidKeyReleased
        searchPaidBtnActionPerformed(null);
    }//GEN-LAST:event_searchForPaidKeyReleased

    private void searchPaidAdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchPaidAdvMouseClicked
        try {
            float price = 0;
            AdvancedSearch advancedSearch = new AdvancedSearch();
            advancedSearch.setBeginDate(beginDate.getDate());
            advancedSearch.setEndDate(endDate.getDate());
            
            List<Paid> paidList = dao.advancedSearchPaid(advancedSearch);
            ViewPaidListInTable(paidList);
            for (Paid paid : paidList) {
                price += paid.getPrice();
            }
            gainMoney.setText(String.valueOf(price));
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchPaidAdvMouseClicked

    private void refreshEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshEmailMouseClicked
        LibraryFrame libraryFrame = new LibraryFrame(dao);
    }//GEN-LAST:event_refreshEmailMouseClicked
    
    public void bar(JLabel label) {
        mainPageHover.setOpaque(false);
        studentPageHover.setOpaque(false);
        authorPageHover.setOpaque(false);
        orderPageHover.setOpaque(false);
        emailPageHover.setOpaque(false);
        calcPageHover.setOpaque(false);
        bookPageHover.setOpaque(false);
        menuPageHover.setOpaque(false);
        tablePageHover.setOpaque(false);
        employeePageHover.setOpaque(false);
        label.setOpaque(true);
        menu.repaint();
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addAuthor;
    private javax.swing.JLabel addBook;
    private javax.swing.JLabel addEmployee;
    private javax.swing.JButton addEvent;
    private javax.swing.JLabel addMenu;
    private javax.swing.JLabel addOrder;
    private javax.swing.JPanel addOrderBook;
    private javax.swing.JPanel addOrderToTable;
    private javax.swing.JPanel addProduct;
    private javax.swing.JLabel addStudentIcon;
    private javax.swing.JTable advancedBookTable;
    private javax.swing.JPanel advancedSearchBookBtn;
    private javax.swing.JCheckBox allTableCheck;
    private javax.swing.JLabel authorNumber;
    private javax.swing.JPanel authorPage;
    private javax.swing.JPanel authorPageContentOnLay;
    private javax.swing.JLabel authorPageHover;
    private javax.swing.JLabel authorPageIcon;
    private javax.swing.JLayeredPane authorPageLay;
    private javax.swing.JLabel authorPageText;
    private javax.swing.JTable authorTable;
    private javax.swing.JPanel authorTablePanel;
    private com.toedter.calendar.JDateChooser beginDate;
    private javax.swing.JTextField beginMoney;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel bookAdvancedSearchPageContentOnLay;
    private javax.swing.JLayeredPane bookAdvancedSearchPageLay;
    private javax.swing.JPanel bookAdvancedSearchTablePanel;
    private javax.swing.JLabel bookIcon;
    private javax.swing.JPanel bookMoreInfo;
    private javax.swing.JLabel bookMoreInfoIcon;
    private javax.swing.JLabel bookMoreInfoText;
    private javax.swing.JPanel bookNum;
    private javax.swing.JLabel bookNumText;
    private javax.swing.JPanel bookPage;
    private javax.swing.JPanel bookPageContentOnLay;
    private javax.swing.JLabel bookPageHover;
    private javax.swing.JLabel bookPageIcon;
    private javax.swing.JLayeredPane bookPageLay;
    private javax.swing.JLabel bookPageText;
    private javax.swing.JTable bookTable;
    private javax.swing.JPanel bookTablePanel;
    private javax.swing.JLabel bookText;
    private javax.swing.JCheckBox borrowBook;
    private javax.swing.JPanel borrowBookPageContentOnLay;
    private javax.swing.JLayeredPane borrowBookPageLay;
    private javax.swing.JTable borrowBookTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel calcPage;
    private javax.swing.JPanel calcPageContentOnLay;
    private javax.swing.JLabel calcPageHover;
    private javax.swing.JLabel calcPageIcon;
    private javax.swing.JLayeredPane calcPageLay;
    private javax.swing.JPanel calcPageTablesPanel;
    private javax.swing.JLabel calcPageText;
    private javax.swing.JLabel date;
    private javax.swing.JPanel emailPage;
    private javax.swing.JPanel emailPageContentOnLay;
    private javax.swing.JLabel emailPageHover;
    private javax.swing.JLabel emailPageIcon;
    private javax.swing.JLayeredPane emailPageLay;
    private javax.swing.JLabel emailPageText;
    private javax.swing.JPanel emailTablePanel;
    private javax.swing.JLabel employeeIcon;
    private javax.swing.JPanel employeeMoreInfo;
    private javax.swing.JLabel employeeMoreInfoIcon;
    private javax.swing.JLabel employeeMoreInfoText;
    private javax.swing.JPanel employeeNum;
    private javax.swing.JLabel employeeNumText;
    private javax.swing.JLabel employeeNumber;
    private javax.swing.JPanel employeePage;
    private javax.swing.JPanel employeePageContentOnLay;
    private javax.swing.JLabel employeePageHover;
    private javax.swing.JLabel employeePageIcon;
    private javax.swing.JLayeredPane employeePageLay;
    private javax.swing.JLabel employeePageText;
    private javax.swing.JTable employeeTable;
    private javax.swing.JPanel employeeTablePanel;
    private javax.swing.JLabel employeeText;
    private javax.swing.JCheckBox emptyTableCheck;
    private javax.swing.JLabel emptyTableNum;
    private javax.swing.JLabel emptyText;
    private com.toedter.calendar.JDateChooser endDate;
    private javax.swing.JTextField endMoney;
    private javax.swing.JPanel event;
    private javax.swing.JLabel eventIcon;
    private javax.swing.JLabel eventText;
    private javax.swing.JLabel exit;
    private javax.swing.JTextField gainMoney;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel logo;
    private javax.swing.JLabel logoIcon;
    private javax.swing.JLabel logoText;
    private javax.swing.JPanel mainPage;
    private javax.swing.JPanel mainPageContent;
    private javax.swing.JPanel mainPageContentOnLay;
    private javax.swing.JLabel mainPageHover;
    private javax.swing.JLabel mainPageIcon;
    private javax.swing.JLayeredPane mainPageLay;
    private javax.swing.JLabel mainPageText;
    private javax.swing.JButton masa1;
    private javax.swing.JButton masa10;
    private javax.swing.JButton masa11;
    private javax.swing.JButton masa12;
    private javax.swing.JButton masa13;
    private javax.swing.JButton masa14;
    private javax.swing.JButton masa15;
    private javax.swing.JButton masa16;
    private javax.swing.JButton masa17;
    private javax.swing.JButton masa18;
    private javax.swing.JButton masa19;
    private javax.swing.JButton masa2;
    private javax.swing.JButton masa20;
    private javax.swing.JButton masa21;
    private javax.swing.JButton masa22;
    private javax.swing.JButton masa23;
    private javax.swing.JButton masa24;
    private javax.swing.JButton masa25;
    private javax.swing.JButton masa26;
    private javax.swing.JButton masa27;
    private javax.swing.JButton masa28;
    private javax.swing.JButton masa29;
    private javax.swing.JButton masa3;
    private javax.swing.JButton masa30;
    private javax.swing.JButton masa31;
    private javax.swing.JButton masa32;
    private javax.swing.JButton masa33;
    private javax.swing.JButton masa34;
    private javax.swing.JButton masa35;
    private javax.swing.JButton masa36;
    private javax.swing.JButton masa37;
    private javax.swing.JButton masa38;
    private javax.swing.JButton masa39;
    private javax.swing.JButton masa4;
    private javax.swing.JButton masa40;
    private javax.swing.JButton masa5;
    private javax.swing.JButton masa6;
    private javax.swing.JButton masa7;
    private javax.swing.JButton masa8;
    private javax.swing.JButton masa9;
    private javax.swing.JTextField maxCopies;
    private javax.swing.JTextField maxNum;
    private javax.swing.JTextField maxPageNum;
    private javax.swing.JTextField maxPrice;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel menuNum;
    private javax.swing.JPanel menuPage;
    private javax.swing.JPanel menuPageContentOnLay;
    private javax.swing.JLabel menuPageHover;
    private javax.swing.JLabel menuPageIcon;
    private javax.swing.JLayeredPane menuPageLay;
    private javax.swing.JLabel menuPageText;
    private javax.swing.JTable menuTable;
    private javax.swing.JPanel menuTablePanel;
    private javax.swing.JTextField minCopies;
    private javax.swing.JTextField minNum;
    private javax.swing.JTextField minPageNum;
    private javax.swing.JTextField minPrice;
    private javax.swing.JPanel newMessage;
    private javax.swing.JTable notesTable;
    private javax.swing.JPanel orderBook;
    private javax.swing.JPanel orderBookPageContentOnLay;
    private javax.swing.JLayeredPane orderBookPageLay;
    private javax.swing.JPanel orderBookTablePanel;
    private javax.swing.JPanel orderPage;
    private javax.swing.JPanel orderPageContentOnLay;
    private javax.swing.JLabel orderPageHover;
    private javax.swing.JLabel orderPageIcon;
    private javax.swing.JLayeredPane orderPageLay;
    private javax.swing.JLabel orderPageText;
    private javax.swing.JTable orderTable;
    private javax.swing.JPanel orderTablePanel;
    private javax.swing.JPanel paidBtn;
    private javax.swing.JTable paidTable;
    private javax.swing.JTable productTable;
    private javax.swing.JCheckBox readNowBook;
    private javax.swing.JPanel readNowBookPageContentOnLay;
    private javax.swing.JLayeredPane readNowBookPageLay;
    private javax.swing.JTable readNowBookTable;
    private javax.swing.JLabel refreshAuthor;
    private javax.swing.JLabel refreshBook;
    private javax.swing.JLabel refreshCalc;
    private javax.swing.JLabel refreshEmail;
    private javax.swing.JLabel refreshEmployee;
    private javax.swing.JLabel refreshMenu;
    private javax.swing.JLabel refreshOrderBook;
    private javax.swing.JLabel refreshOrderPage;
    private javax.swing.JLabel refreshStudent;
    private javax.swing.JLabel searchAdvancedBook;
    private javax.swing.JPanel searchAuthorBtn;
    private javax.swing.JTextField searchBook;
    private javax.swing.JPanel searchBookBtn;
    private javax.swing.JPanel searchBookButton;
    private javax.swing.JPanel searchBtn;
    private javax.swing.JPanel searchEmployeeBtn;
    private javax.swing.JTextField searchForAuthor;
    private javax.swing.JTextField searchForBook;
    private javax.swing.JTextField searchForEmail;
    private javax.swing.JButton searchForEmailBtn;
    private javax.swing.JTextField searchForEmployee;
    private javax.swing.JTextField searchForMenu;
    private javax.swing.JTextField searchForOrder;
    private javax.swing.JTextField searchForPaid;
    private javax.swing.JTextField searchForProduct;
    private javax.swing.JTextField searchForStudents;
    private javax.swing.JPanel searchMenuBtn;
    private javax.swing.JPanel searchOrderBtn;
    private javax.swing.JPanel searchPaidAdv;
    private javax.swing.JButton searchPaidBtn;
    private javax.swing.JPanel searchProductAdv;
    private javax.swing.JButton searchProductBtn;
    private javax.swing.JLabel searchText;
    private javax.swing.JLabel searchText1;
    private javax.swing.JLabel searchText2;
    private javax.swing.JLabel searchText3;
    private javax.swing.JLabel searchText4;
    private javax.swing.JTable sendEmailTable;
    private javax.swing.JButton shelf1;
    private javax.swing.JButton shelf10;
    private javax.swing.JButton shelf11;
    private javax.swing.JButton shelf12;
    private javax.swing.JButton shelf2;
    private javax.swing.JButton shelf3;
    private javax.swing.JButton shelf4;
    private javax.swing.JButton shelf5;
    private javax.swing.JButton shelf6;
    private javax.swing.JButton shelf7;
    private javax.swing.JButton shelf8;
    private javax.swing.JButton shelf9;
    private javax.swing.JCheckBox soldBook;
    private javax.swing.JPanel soldBookPageContentOnLay;
    private javax.swing.JLayeredPane soldBookPageLay;
    private javax.swing.JTable soldBookTable;
    private javax.swing.JPanel studentPage;
    private javax.swing.JLabel studentPageHover;
    private javax.swing.JLabel studentPageIcon;
    private javax.swing.JLabel studentPageText;
    private javax.swing.JLabel studentsIcon;
    private javax.swing.JPanel studentsMoreInfo;
    private javax.swing.JLabel studentsMoreInfoIcon;
    private javax.swing.JLabel studentsMoreInfoText;
    private javax.swing.JPanel studentsNum;
    private javax.swing.JLabel studentsNumText;
    private javax.swing.JLabel studentsNumber;
    private javax.swing.JPanel studentsPageContentOnLay;
    private javax.swing.JLayeredPane studentsPageLay;
    private javax.swing.JTable studentsTable;
    private javax.swing.JPanel studentsTablePanel;
    private javax.swing.JLabel studentsText;
    private javax.swing.JPanel tableContent;
    private javax.swing.JPanel tablePage;
    private javax.swing.JPanel tablePageContentOnLay;
    private javax.swing.JLabel tablePageHover;
    private javax.swing.JLabel tablePageIcon;
    private javax.swing.JLayeredPane tablePageLay;
    private javax.swing.JLabel tablePageText;
    private javax.swing.JLabel time;
    private javax.swing.JComboBox<String> tipCombo;
    private javax.swing.JLabel userIcon;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userSurname;
    private javax.swing.JPanel warningBoard;
    private javax.swing.JPanel warningBoardHeader;
    private javax.swing.JTable warningTable;
    // End of variables declaration//GEN-END:variables

    private void ViewAuthorListInTable(List<Author> authorList) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Delete_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Ad");
        table.addColumn("Soyad");
        table.addColumn("Doğum Tarixi");
        table.addColumn("Ölüm Tarixi");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
        
        for (Author author : authorList) {
            authorNumber.setText(author.getRowNum().toString());
            Object data[] = new Object[]{
                author.getId(), author.getRowNum(), author.getName(), author.getSurname(), author.getBirthDate(),
                author.getDeathDate(), view, update, delete
            };
            table.addRow(data);
        }
        
        authorTable.setModel(table);
        authorTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        authorTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        authorTable.getColumn("Sil").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) authorTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        //Hide id for AuthorTable
        hide.hideId(authorTable);

        // Set column size for Author Table
        columnSize.authorTableColumnSize(authorTable);
        
        authorTable.getTableHeader().setReorderingAllowed(false);
        
    }
    
    private void ViewStudentListInTable(List<Student> studentList) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Delete_30px.png"));
        
        JLabel email = new JLabel();
        email.setIcon(new ImageIcon("Envelope_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                email.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                return (Component) value;
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Ad");
        table.addColumn("Soyad");
        table.addColumn("Telefon");
        table.addColumn("Qrup");
        table.addColumn("Gmail");
        table.addColumn("Ətraflı");
        table.addColumn("Mesaj Göndər");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
        
        for (Student student : studentList) {
            studentsNumber.setText(student.getRowNum().toString());
            Object data[] = new Object[]{
                student.getId(), student.getRowNum(), student.getName(), student.getSurname(), student.getPhone(),
                student.getGroup(), student.getEmail(), view, email, update, delete
            };
            table.addRow(data);
        }
        
        studentsTable.setModel(table);
        studentsTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        studentsTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        studentsTable.getColumn("Sil").setCellRenderer(new LabelRenderer());
        studentsTable.getColumn("Mesaj Göndər").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) studentsTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        hide.hideId(studentsTable);
        
        columnSize.studentsTableColumnSize(studentsTable);
        
        studentsTable.getTableHeader().setReorderingAllowed(false);
        
    }
    
    private void ViewEmployeeListInTable(List<Employee> employeeList) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete
                .setIcon(new ImageIcon("Delete_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                return (Component) value;
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Ad");
        table.addColumn("Soyad");
        table.addColumn("Telefon");
        table.addColumn("Adress");
        table.addColumn("İş Günləri");
        table.addColumn("Maaş");
        table.addColumn("Gmail");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
        
        for (Employee employee : employeeList) {
            employeeNumber.setText(employee.getRowNum().toString());
            Object data[] = new Object[]{
                employee.getId(), employee.getRowNum(), employee.getName(), employee.getSurname(), employee.getPhone(),
                employee.getAddress(), employee.getWorkDay(), employee.getSalary(), employee.getEmail(), view, update, delete
            };
            table.addRow(data);
        }
        
        employeeTable.setModel(table);
        employeeTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        employeeTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        employeeTable.getColumn("Sil").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) employeeTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        hide.hideId(employeeTable);
        
        columnSize.employeeTableColumnSize(employeeTable);
        
        employeeTable.getTableHeader().setReorderingAllowed(false);
    }
    
    private void ViewBookListInTable(List<Book> bookList) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Delete_30px.png"));
        
        JLabel orderBook = new JLabel();
        orderBook.setIcon(new ImageIcon("Add Shopping Cart_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                orderBook.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Kitab Adı");
        table.addColumn("Janr");
        table.addColumn("Səhifələrin Sayı");
        table.addColumn("Kopya Sayı");
        table.addColumn("Qiyməti");
        table.addColumn("Rəf");
        table.addColumn("Status");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
        table.addColumn("Sifariş et");
        
        for (Book book : bookList) {
            Object data[] = new Object[]{
                book.getId(), book.getRowNum(), book.getTitle(), book.getBookTip().getTipName(), book.getPageNum(),
                book.getCopies(), book.getPrice(), book.getShelf().getShelfName(),
                book.getBookStatus().getStatusName(), view, update, delete, orderBook
            };
            table.addRow(data);
        }
        
        bookTable.setModel(table);
        bookTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        bookTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        bookTable.getColumn("Sil").setCellRenderer(new LabelRenderer());
        bookTable.getColumn("Sifariş et").setCellRenderer(new LabelRenderer());
        
        hide.hideId(bookTable);
        
        columnSize.bookTableColumnSize(bookTable);
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) bookTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        bookTable.getTableHeader().setReorderingAllowed(false);
        
    }
    
    private void ViewMenuListInTable(List<Menu> menuList) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Delete_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Yemək Adı");
        table.addColumn("Qiyməti");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
        
        for (Menu menu : menuList) {
            menuNum.setText(menu.getRowNum().toString());
            Object data[] = new Object[]{
                menu.getId(), menu.getRowNum(), menu.getMenuName(), menu.getPrice(), view, update, delete
            };
            table.addRow(data);
        }
        
        menuTable.setModel(table);
        menuTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        menuTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        menuTable.getColumn("Sil").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) menuTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        hide.hideId(menuTable);
        
        menuTable.getTableHeader().setReorderingAllowed(false);
        
    }
    
    private void ViewProductListInTable(List<Product> productList) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Delete_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Produkt Adı");
        table.addColumn("Sayı");
        table.addColumn("Miqdarı");
        table.addColumn("Qiyməti");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
        
        for (Product product : productList) {
            Object data[] = new Object[]{
                product.getId(), product.getRowNum(), product.getProductName(), product.getNum(), product.getAmount(), product.getPrice(), view, update, delete
            };
            table.addRow(data);
        }
        
        productTable.setModel(table);
        productTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        productTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        productTable.getColumn("Sil").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) productTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        hide.hideId(productTable);
        
        productTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        
        productTable.getTableHeader().setReorderingAllowed(false);
        
    }
    
    private void ViewSendEmailList(List<SendEmail> sendEmailList) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Tələbə Adı");
        table.addColumn("Tələbə Soyadı");
        table.addColumn("Gmail");
        table.addColumn("Mesaj");
        table.addColumn("İşçi Adı");
        table.addColumn("İşçi Soyadı");
        table.addColumn("Ətraflı");
        
        for (SendEmail sendEmail : sendEmailList) {
            Object data[] = new Object[]{
                sendEmail.getId(), sendEmail.getRowNum(),
                sendEmail.getStudent().getName(), sendEmail.getStudent().getSurname(), sendEmail.getStudent().getEmail(),
                sendEmail.getMessage(),
                sendEmail.getEmployee().getName(), sendEmail.getEmployee().getSurname(), view,};
            table.addRow(data);
        }
        
        sendEmailTable.setModel(table);
        sendEmailTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) sendEmailTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        hide.hideId(sendEmailTable);
        
        columnSize.sendEmailTableColumnSize(sendEmailTable);
        
        sendEmailTable.getTableHeader().setReorderingAllowed(false);
        
    }
    
    private void ViewNoteListInTable(List<Note> noteList) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Delete_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Qeyd");
        table.addColumn("Başlanğıc Tarix");
        table.addColumn("Son Tarix");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
        
        for (Note note : noteList) {
            Object data[] = new Object[]{
                note.getId(), note.getRowNum(), note.getNoteText(), note.getBeginDate(), note.getEndDate(), view, update, delete
            };
            table.addRow(data);
        }
        
        notesTable.setModel(table);
        notesTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        notesTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        notesTable.getColumn("Sil").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) notesTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        hide.hideId(notesTable);
        
        notesTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        
        notesTable.getTableHeader().setReorderingAllowed(false);
        
    }
    
    private void ViewTableOrderListInTable(List<TableOrder> tableOrderList) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Delete_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Ad");
        table.addColumn("Masa");
        table.addColumn("Sifariş");
        table.addColumn("Hesab");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
        
        for (TableOrder tableOrder : tableOrderList) {
            
            Object data[] = new Object[]{
                tableOrder.getId(), tableOrder.getRowNum(), tableOrder.getResName(), tableOrder.getTable().getName(),
                tableOrder.getOrder().gettOrder(), tableOrder.getOrder().getPrice(),
                view, update, delete
            };
            table.addRow(data);
        }
        
        orderTable.setModel(table);
        orderTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        orderTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        orderTable.getColumn("Sil").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) orderTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        orderTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        
        hide.hideId(orderTable);
        
        orderTable.getTableHeader().setReorderingAllowed(false);
        
    }
    
    private void ViewPaidListInTable(List<Paid> paidList) {
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Delete_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Masa");
        table.addColumn("Hesab");
        table.addColumn("Ödəmə Tarixi");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
        
        for (Paid paid : paidList) {
            Object data[] = new Object[]{
                paid.getId(), paid.getRowNum(), paid.getTableOrder().getTable().getName(),
                paid.getPrice(), paid.getPaidDate(),
                update, delete
            };
            table.addRow(data);
        }
        
        paidTable.setModel(table);
        
        paidTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        paidTable.getColumn("Sil").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) paidTable.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        hide.hideId(paidTable);
        
        paidTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        
        paidTable.getTableHeader().setReorderingAllowed(false);
        
        paidTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = paidTable.rowAtPoint(e.getPoint());
                int col = paidTable.columnAtPoint(e.getPoint());
                
                int rowIndex = paidTable.getSelectedRow();
                Long selectedRow = (Long) paidTable.getValueAt(rowIndex, 0);
                
                if (col == 5) {
                    if (frame == null) {
                        EditPaid editPaid = new EditPaid(dao, selectedRow);
                        editPaid.setVisible(true);
                        frame = editPaid;
                        
                        editPaid.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == 6) {
                    JLabel label = new JLabel("Ödənişi  silmək isdədiyinizə əminsiz?");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    int isDeleteMsg = JOptionPane.showConfirmDialog(null, label, "Ödənişi Sil", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    
                    if (isDeleteMsg == JOptionPane.YES_OPTION) {
                        try {
                            boolean isDelete = dao.deletePaid(selectedRow);
                            if (isDelete) {
                                JOptionPane.showMessageDialog(null, "Ödəniş Silindi...");
                                
                            } else {
                                JOptionPane.showMessageDialog(null, "Silinmədi!!!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(LibraryFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
            }
            
        }
        );
        
    }
    
    private void ViewSoldBookListInTable(List<OrderBook> orderBookList, String globCheckName) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Give_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Ad");
        table.addColumn("Soyad");
        table.addColumn("Kitab");
        table.addColumn("Qiymət");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Qaytar");
        
        for (OrderBook soldBook : orderBookList) {
            Object data[] = new Object[]{
                soldBook.getId(), soldBook.getRowNum(), soldBook.getStudent().getName(), soldBook.getStudent().getSurname(),
                soldBook.getBook().getTitle(), soldBook.getBook().getPrice(),
                view, update, delete
            };
            table.addRow(data);
        }
        
        soldBookTable.setModel(table);
        soldBookTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        soldBookTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        soldBookTable.getColumn("Qaytar").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) soldBookTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        hide.hideId(soldBookTable);
        
        soldBookTable.getTableHeader().setReorderingAllowed(false);
        
        soldBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = soldBookTable.rowAtPoint(e.getPoint());
                int col = soldBookTable.columnAtPoint(e.getPoint());
                
                int rowIndex = soldBookTable.getSelectedRow();
                Long selectedRow = (Long) soldBookTable.getValueAt(rowIndex, 0);
                if (col == EnumSixToEight.VIEW.getValue() && frame == null) {
                    
                    ViewOrderBook viewOrderBook = new ViewOrderBook(dao, selectedRow, globCheckName);
                    viewOrderBook.setVisible(true);
                    frame = viewOrderBook;
                    viewOrderBook.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            frame = null;
                        }
                    });
                    
                }
                
                if (col == EnumSixToEight.EDIT.getValue() && frame == null) {
                    
                    EditOrderBook editOrderBook = new EditOrderBook(dao, selectedRow, globCheckName);
                    editOrderBook.setVisible(true);
                    frame = editOrderBook;
                    
                    editOrderBook.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            frame = null;
                        }
                    });
                    
                }
                if (col == EnumSixToEight.DELETE.getValue() && frame == null) {
                    GiveBackFrame backFrame = new GiveBackFrame(selectedRow, dao, globCheckName);
                    backFrame.setVisible(true);
                    frame = backFrame;
                    
                    backFrame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            try {
                                frame = null;
                                List<OrderBook> orderBookList = dao.getOrderBookList((long) 1);
                                ViewSoldBookListInTable(orderBookList, globCheckName);
                            } catch (Exception ex) {
                                Logger.getLogger(LibraryFrame.class
                                        .getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    
                }
                
            }
            
        }
        );
        
    }
    
    private void ViewBorrowBookListInTable(List<OrderBook> orderBookList, String globCheckName) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Give_30px.png"));
        
        JLabel email = new JLabel();
        email.setIcon(new ImageIcon("Envelope_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                email.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Ad");
        table.addColumn("Soyad");
        table.addColumn("Kitab");
        table.addColumn("Kirayə Vaxtı");
        table.addColumn("Qiymət");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Mesaj");
        table.addColumn("Qaytar");
        
        for (OrderBook borrowBook : orderBookList) {
            Object data[] = new Object[]{
                borrowBook.getId(), borrowBook.getRowNum(), borrowBook.getStudent().getName(), borrowBook.getStudent().getSurname(),
                borrowBook.getBook().getTitle(), borrowBook.getBorrowTime(), borrowBook.getBook().getPrice(),
                view, update, email, delete
            };
            table.addRow(data);
        }
        
        borrowBookTable.setModel(table);
        borrowBookTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        borrowBookTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        borrowBookTable.getColumn("Qaytar").setCellRenderer(new LabelRenderer());
        borrowBookTable.getColumn("Mesaj").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) borrowBookTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        hide.hideId(borrowBookTable);
        
        borrowBookTable.getTableHeader().setReorderingAllowed(false);
        
        borrowBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = borrowBookTable.rowAtPoint(e.getPoint());
                int col = borrowBookTable.columnAtPoint(e.getPoint());
                
                int rowIndex = borrowBookTable.getSelectedRow();
                Long selectedRow = (Long) borrowBookTable.getValueAt(rowIndex, 0);
                if (col == 7) {
                    if (frame == null) {
                        ViewOrderBook viewOrderBook = new ViewOrderBook(dao, selectedRow, globCheckName);
                        viewOrderBook.setVisible(true);
                        frame = viewOrderBook;
                        viewOrderBook.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                
                if (col == 8) {
                    if (frame == null) {
                        EditOrderBook editOrderBook = new EditOrderBook(dao, selectedRow, globCheckName);
                        editOrderBook.setVisible(true);
                        frame = editOrderBook;
                        
                        editOrderBook.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == 9) {
                    if (frame == null) {
                        NewMessage message = new NewMessage(dao, selectedRow, globCheckName);
                        message.setVisible(true);
                        frame = message;
                        message.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                }
                if (col == 10) {
                    if (frame == null) {
                        GiveBackFrame backFrame = new GiveBackFrame(selectedRow, dao, globCheckName);
                        backFrame.setVisible(true);
                        frame = backFrame;
                        
                        backFrame.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                try {
                                    frame = null;
                                    List<OrderBook> orderBookList = dao.getOrderBookList((long) 2);
                                    ViewBorrowBookListInTable(orderBookList, globCheckName);
                                } catch (Exception ex) {
                                    Logger.getLogger(LibraryFrame.class
                                            .getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                    }
                }
                
            }
        }
        );
        
    }
    
    private void ViewReadNowBookListInTable(List<OrderBook> orderBookList, String globCheckName) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Give_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Ad");
        table.addColumn("Soyad");
        table.addColumn("Kitab");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Qaytar");
        
        for (OrderBook readNowBook : orderBookList) {
            Object data[] = new Object[]{
                readNowBook.getId(), readNowBook.getRowNum(), readNowBook.getStudent().getName(), readNowBook.getStudent().getSurname(),
                readNowBook.getBook().getTitle(),
                view, update, delete
            };
            table.addRow(data);
        }
        
        readNowBookTable.setModel(table);
        readNowBookTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        readNowBookTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        readNowBookTable.getColumn("Qaytar").setCellRenderer(new LabelRenderer());
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) readNowBookTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        hide.hideId(readNowBookTable);
        
        readNowBookTable.getTableHeader().setReorderingAllowed(false);
        
        readNowBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = readNowBookTable.rowAtPoint(e.getPoint());
                int col = readNowBookTable.columnAtPoint(e.getPoint());
                
                int rowIndex = readNowBookTable.getSelectedRow();
                Long selectedRow = (Long) readNowBookTable.getValueAt(rowIndex, 0);
                if (col == 5) {
                    if (frame == null) {
                        ViewOrderBook viewOrderBook = new ViewOrderBook(dao, selectedRow, globCheckName);
                        viewOrderBook.setVisible(true);
                        frame = viewOrderBook;
                        viewOrderBook.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                
                if (col == 6) {
                    if (frame == null) {
                        EditOrderBook editOrderBook = new EditOrderBook(dao, selectedRow, globCheckName);
                        editOrderBook.setVisible(true);
                        frame = editOrderBook;
                        
                        editOrderBook.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                frame = null;
                            }
                        });
                    }
                    
                }
                if (col == 7) {
                    if (frame == null) {
                        GiveBackFrame backFrame = new GiveBackFrame(selectedRow, dao, globCheckName);
                        backFrame.setVisible(true);
                        frame = backFrame;
                        
                        backFrame.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                try {
                                    frame = null;
                                    List<OrderBook> orderBookList = dao.getOrderBookList((long) 4);
                                    ViewReadNowBookListInTable(orderBookList, globCheckName);
                                } catch (Exception ex) {
                                    Logger.getLogger(LibraryFrame.class
                                            .getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                    }
                }
                
            }
        }
        );
    }
    
    private void ViewAdvancedBookListInTable(List<Book> bookList) {
        JLabel view = new JLabel();
        view.setIcon(new ImageIcon("ViewB_30px.png"));
        
        JLabel update = new JLabel();
        update.setIcon(new ImageIcon("UpdateA File_30px.png"));
        
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("Delete_30px.png"));
        
        JLabel orderBook = new JLabel();
        orderBook.setIcon(new ImageIcon("Add Shopping Cart_30px.png"));
        
        class LabelRenderer implements TableCellRenderer {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                view.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                update.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                delete.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                orderBook.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                return (Component) value;
                
            }
            
        }
        
        DefaultTableModel table = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        
        table.addColumn("Id");
        table.addColumn("№");
        table.addColumn("Kitab Adı");
        table.addColumn("Janr");
        table.addColumn("Səhifələrin Sayı");
        table.addColumn("Kopya Sayı");
        table.addColumn("Qiyməti");
        table.addColumn("Rəf");
        table.addColumn("Status");
        table.addColumn("Ətraflı");
        table.addColumn("Düzəliş et");
        table.addColumn("Sil");
        table.addColumn("Sifariş et");
        
        for (Book book : bookList) {
            Object data[] = new Object[]{
                book.getId(), book.getRowNum(), book.getTitle(), book.getBookTip().getTipName(), book.getPageNum(),
                book.getCopies(), book.getPrice(), book.getShelf().getShelfName(),
                book.getBookStatus().getStatusName(), view, update, delete, orderBook
            };
            table.addRow(data);
        }
        
        advancedBookTable.setModel(table);
        advancedBookTable.getColumn("Ətraflı").setCellRenderer(new LabelRenderer());
        advancedBookTable.getColumn("Düzəliş et").setCellRenderer(new LabelRenderer());
        advancedBookTable.getColumn("Sil").setCellRenderer(new LabelRenderer());
        advancedBookTable.getColumn("Sifariş et").setCellRenderer(new LabelRenderer());
        
        hide.hideId(advancedBookTable);
        
        columnSize.advancedBookTableColumnSize(advancedBookTable);
        
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) advancedBookTable.getDefaultRenderer(Object.class
        );
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        advancedBookTable.getTableHeader().setReorderingAllowed(false);
    }
    
    private void ViewBookTipListInComboBox() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) tipCombo.getModel();
            List<BookTip> bookTipList = dao.getBookTipList();
            for (BookTip bookTip : bookTipList) {
                model.addElement(new Item(bookTip.getId(), bookTip.getTipName()));
            }
        } catch (Exception ex) {
            Logger.getLogger(LibraryFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
// 7168
