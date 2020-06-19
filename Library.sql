/* Formatted on 06/May/20 1:54:18 PM (QP5 v5.354) */
--Author--
SELECT
    ROWNUM r,
    id,
    name,
    surname,
    birth_date,
    death_date,
    advance_info,
    img
FROM
    author
WHERE
    active = 1;

SELECT
    id,
    img
FROM
    author
WHERE
    id = 1;


--Student--

SELECT
    ROWNUM r,
    id,
    name,
    surname,
    student_group,
    phone,
    email
FROM
    student;

SELECT
    id,
    img
FROM
    student
WHERE
    id = 1;

--Employee--

SELECT
    ROWNUM r,
    id,
    name,
    surname,
    phone,
    adress,
    work_day,
    salary,
    email
FROM
    employee;

SELECT
    id,
    img
FROM
    employee
WHERE
    id = 1;

SELECT
    id,
    view_img,
    edit_img,
    delete_im
FROM
    action
WHERE
    id = 1;

SELECT
    ROWNUM r,
    book.id,
    book.title,
    book.copies,
    book.price,
    book_status.id   book_status_id,
    book_tip.id      book_tip_id,
    book_status.status_name,
    book_tip.tip,
    shelf.id         shelf_id,
    shelf.name,
    book.page_num
FROM
    book
    INNER JOIN book_status ON book_status.id = book.book_status_id
    INNER JOIN book_tip ON book_tip.id = book.book_tip_id
    INNER JOIN shelf ON shelf.id = book.shelf_id
WHERE
    book.active = 1;

SELECT
    *
FROM
    book;

SELECT
    id,
    book_img
FROM
    book
WHERE
    id = 1;

SELECT
    ROWNUM r,
    id,
    menu_name,
    price
FROM
    menu
WHERE
    active = 1;

SELECT
    ROWNUM r,
    id,
    product_name,
    num,
    price,
    amount
FROM
    product
WHERE
    active = 1;

SELECT
    ROWNUM r,
    send_email.id,
    message,
    student.id         student_id,
    student.name,
    student.surname,
    student.email,
    employee.id        employee_id,
    employee.name      employee_name,
    employee.surname   employee_surname
FROM
    send_email
    INNER JOIN student ON student.id = send_email.student_id
    INNER JOIN employee ON employee.id = send_email.employee_id
WHERE
    send_email.active = 1;

SELECT
    ROWNUM r,
    only_order.id,
    only_order.num,
    only_order.t_order,
    only_order.price,
    menu.id,
    menu.menu_name
FROM
    only_order
    INNER JOIN menu ON menu.id = only_order.menu_id
WHERE
    only_order.active = 1;

SELECT
    id,
    begin_date,
    end_date,
    note
FROM
    notes
WHERE
    active = 1;

SELECT
    ROWNUM r,
    table_order.id,
    table_order.res_name,
    lib_table.id    table_id,
    lib_table.lib_table,
    only_order.id   order_id,
    only_order.num,
    only_order.price,
    only_order.t_order,
    menu.id         menu_id,
    menu.menu_name
FROM
    table_order
    INNER JOIN lib_table ON lib_table.id = table_order.table_id
    INNER JOIN only_order ON only_order.id = table_order.only_order_id
    INNER JOIN menu ON only_order.menu_id = menu.id
WHERE
    table_order.active = 1;

SELECT
    ROWNUM r,
    paid.id,
    paid.price,
    paid.paid_date,
    table_order.id     table_order_id,
    table_order.res_name,
    lib_table.id       table_id,
    lib_table.lib_table,
    only_order.id      order_id,
    only_order.num,
    only_order.price   order_price,
    only_order.t_order,
    menu.id            menu_id,
    menu.menu_name
FROM
    paid
    INNER JOIN table_order ON table_order.id = paid.table_order_id
    INNER JOIN lib_table ON lib_table.id = table_order.table_id
    INNER JOIN only_order ON only_order.id = table_order.only_order_id
    INNER JOIN menu ON only_order.menu_id = menu.id
WHERE
    paid.active = 1;

SELECT
    *
FROM
    paid;

SELECT
    ROWNUM r,
    lib_table.id,
    lib_table,
    table_status.id table_status_id,
    table_status.status_name
FROM
    lib_table
    INNER JOIN table_status ON table_status.id = lib_table.table_status_id
WHERE
    lib_table.active = 1;

SELECT
    *
FROM
    table_order;

SELECT
    *
FROM
    only_order;

INSERT INTO only_order (
    id,
    num,
    t_order,
    menu_id,
    price,
    res_name
) VALUES (
    only_order_seq.NEXTVAL,
    ?,
    ?,
    ?,
    ?,
    ?
);

INSERT INTO student (
    id,
    name,
    surname,
    student_group,
    phone,
    email,
    img
) VALUES (
    student_seq.NEXTVAL,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?
);

INSERT INTO author (
    id,
    name,
    surname,
    birth_date,
    death_date,
    img
) VALUES (
    author_seq.NEXTVAL,
    ?,
    ?,
    ?,
    ?,
    ?
);

INSERT INTO employee (
    id,
    name,
    surname,
    phone,
    address,
    work_day,
    salary,
    email,
    img
) VALUES (
    employee_seq.NEXTVAL,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?
);

INSERT INTO product (
    id,
    product_name,
    num,
    amount,
    price
) VALUES (
    product_seq.NEXTVAL,
    ?,
    ?,
    ?,
    ?
);

INSERT INTO book (
    id,
    title,
    page_num,
    copies,
    book_img,
    price,
    book_status_id,
    book_tip_id,
    shelf_id
) VALUES (
    book_seq.NEXTVAL,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?,
    ?
);

INSERT INTO menu (
    id,
    menu_name,
    price
) VALUES (
    menu_seq.NEXTVAL,
    ?,
    ?
);

SELECT
    ROWNUM r,
    id,
    tip
FROM
    book_tip
WHERE
    active = 1;

SELECT
    ROWNUM r,
    id,
    name
FROM
    shelf
WHERE
    active = 1;

SELECT
    *
FROM
    menu;

UPDATE menu
SET
    menu_name = ?,
    price = ?
WHERE
    id = ?;

SELECT
    *
FROM
    author;

UPDATE author
SET
    name = ?,
    surname = ?,
    birth_date = ?,
    death_date = ?,
    img = ?
WHERE
    id = ?;

SELECT
    *
FROM
    student;

UPDATE student
SET
    name = ?,
    surname = ?,
    student_group = ?,
    phone = ?,
    img = ?,
    email = ?
WHERE
    id = ?;

SELECT
    *
FROM
    employee;

UPDATE employee
SET
    name = ?,
    surname = ?,
    phone = ?,
    adress = ?,
    work_day = ?,
    salary = ?,
    img = ?,
    email = ?
WHERE
    id = ?;

SELECT
    *
FROM
    book;

UPDATE book
SET
    title = ?,
    page_num = ?,
    copies = ?,
    book_img = ?,
    price = ?,
    book_status_id = ?,
    book_tip_id = ?,
    shelf_id = ?
WHERE
    id = ?;

SELECT
    *
FROM
    product;

UPDATE product
SET
    product_name = ?,
    num = ?,
    price = ?,
    amount = ?
WHERE
    id = ?;

UPDATE menu
SET
    active = 0
WHERE
    id = ?;

UPDATE author
SET
    active = 0
WHERE
    id = ?;

UPDATE student
SET
    active = 0
WHERE
    id = ?;

UPDATE employee
SET
    active = 0
WHERE
    id = ?;

UPDATE book
SET
    active = 0
WHERE
    id = ?;

UPDATE product
SET
    active = 0
WHERE
    id = ?;

SELECT
    *
FROM
    student;

SELECT
    ROWNUM r,
    order_book.id,
    order_book.borrow_time,
    order_book.price   borrow_price,
    book.id            book_id,
    book.title,
    book.copies,
    book.page_num,
    book_status.id     book_status_id,
    book_status.status_name,
    student.id         student_id,
    student.name,
    student.surname,
    student.email,
    student.phone,
    student.student_group,
    book.price         book_price
FROM
    order_book
    INNER JOIN student ON student.id = order_book.student_id
    INNER JOIN book ON book.id = order_book.book_id
    INNER JOIN book_status ON book_status.id = order_book.book_status_id
WHERE
    ( order_book.active = 1 )
    AND ( book_status.id = 1
          AND order_book.id = 32 );

SELECT
    *
FROM
    order_book;

UPDATE order_book
SET
    student_id = ?,
    book_id = ?,
    price = ?,
    borrow_time = ?
WHERE
    id = ?;

SELECT
    *
FROM
    order_book;

INSERT INTO order_book (
    id,
    student_id,
    book_id,
    book_status_id,
    price,
    borrow_time
) VALUES (
    order_book_seq.NEXTVAL,
    ?,
    ?,
    ?,
    ?,
    ?
);

SELECT
    *
FROM
    book;

UPDATE book
SET
    copies = ?
WHERE
    id = ?;

SELECT
    *
FROM
    order_book;

SELECT
    *
FROM
    table_order;

INSERT INTO table_order (
    id,
    table_id,
    only_order_id,
    res_name
) VALUES (
    table_order_seq.NEXTVAL,
    2,
    2,
    'Asim'
);

UPDATE only_order
SET
    active = 0
WHERE
    id = ?;

SELECT
    *
FROM
    lib_table;

SELECT
    *
FROM
    table_status;

UPDATE lib_table
SET
    table_status_id = 2
WHERE
    id = ?;

SELECT
    ROWNUM r,
    table_order.id,
    table_order.res_name,
    lib_table.id    table_id,
    lib_table.lib_table,
    only_order.id   order_id,
    only_order.num,
    only_order.price,
    only_order.t_order,
    menu.id         menu_id,
    menu.menu_name
FROM
    table_order
    INNER JOIN lib_table ON lib_table.id = table_order.table_id
    INNER JOIN only_order ON only_order.id = table_order.only_order_id
    INNER JOIN menu ON only_order.menu_id = menu.id
WHERE
    ( table_order.active = 1
      AND lib_table.id = 1 );

SELECT
    ROWNUM r,
    table_order.id,
    table_order.res_name,
    lib_table.id    table_id,
    lib_table.lib_table,
    only_order.id   order_id,
    only_order.num,
    only_order.price,
    only_order.t_order,
    menu.id         menu_id,
    menu.menu_name
FROM
    table_order
    INNER JOIN lib_table ON lib_table.id = table_order.table_id
    INNER JOIN only_order ON only_order.id = table_order.only_order_id
    INNER JOIN menu ON only_order.menu_id = menu.id
WHERE
    ( table_order.active = 1
      AND lib_table.id = 6 );

SELECT
    *
FROM
    only_order;

UPDATE only_order
SET
    num = ?,
    t_order = ?,
    menu_id = ?,
    price = ?,
    res_name = ?
WHERE
    id = ?;

SELECT
    *
FROM
    table_order;

UPDATE table_order
SET
    table_id = ?,
    only_order_id = ?,
    res_name = ?
WHERE
    id = ?;

SELECT
    ROWNUM r,
    id,
    status_name
FROM
    table_status
WHERE
    active = 1;

SELECT
    ROWNUM r,
    lib_table.id,
    lib_table,
    table_status.id table_status_id,
    table_status.status_name
FROM
    lib_table
    INNER JOIN table_status ON table_status.id = lib_table.table_status_id
WHERE
    ( lib_table.active = 1
      AND table_status.id = 2 );

SELECT
    *
FROM
    student;

SELECT
    ROWNUM r,
    id,
    name,
    surname,
    student_group,
    phone,
    email
FROM
    student
WHERE
    ( active = 1 )
    AND ( lower(name) LIKE lower(?)
          OR lower(surname) LIKE lower(?)
          OR lower(student_group) LIKE lower(?)
          OR lower(phone) LIKE lower(?)
          OR lower(email) LIKE lower(?) );

SELECT
    ROWNUM r,
    id,
    name,
    surname,
    birth_date,
    death_date,
    advance_info
FROM
    author
WHERE
    active = 1
    AND lower(name) LIKE lower(?)
    OR lower(surname) LIKE lower(?)
    OR lower(birth_date) LIKE lower(?)
    OR lower(death_date) LIKE lower(?);

SELECT
    ROWNUM r,
    book.id,
    book.title,
    book.copies,
    book.price,
    book_status.id   book_status_id,
    book_tip.id      book_tip_id,
    book_status.status_name,
    book_tip.tip,
    shelf.id         shelf_id,
    shelf.name,
    book.page_num
FROM
    book
    INNER JOIN book_status ON book_status.id = book.book_status_id
    INNER JOIN book_tip ON book_tip.id = book.book_tip_id
    INNER JOIN shelf ON shelf.id = book.shelf_id
WHERE
    book.active = 1
    AND lower(book.title) LIKE lower(?)
    OR lower(book.copies) LIKE lower(?)
    OR lower(book.price) LIKE lower(?)
    OR lower(book.page_num) LIKE lower(?)
    OR lower(book_status.status_name) LIKE lower(?)
    OR lower(book_tip.tip) LIKE lower(?)
    OR lower(shelf.name) LIKE lower(?);

SELECT
    ROWNUM r,
    id,
    menu_name,
    price
FROM
    menu
WHERE
    active = 1
    AND lower(menu_name) LIKE lower(?)
    OR lower(price) LIKE lower(?);

SELECT
    ROWNUM r,
    table_order.id,
    table_order.res_name,
    lib_table.id    table_id,
    lib_table.lib_table,
    only_order.id   order_id,
    only_order.num,
    only_order.price,
    only_order.t_order,
    menu.id         menu_id,
    menu.menu_name
FROM
    table_order
    INNER JOIN lib_table ON lib_table.id = table_order.table_id
    INNER JOIN only_order ON only_order.id = table_order.only_order_id
    INNER JOIN menu ON only_order.menu_id = menu.id
WHERE
    table_order.active = 1
    AND lower(table_order.res_name) LIKE lower(?)
    OR lower(lib_table.lib_table) LIKE lower(?)
    OR lower(only_order.num) LIKE lower(?)
    OR lower(only_order.price) LIKE lower(?)
    OR lower(only_order.t_order) LIKE lower(?)
    OR lower(menu.menu_name) LIKE lower(?);

SELECT
    ROWNUM r,
    id,
    product_name,
    num,
    price,
    amount
FROM
    product
WHERE
    active = 1
    AND lower(product_name) LIKE lower(?)
    OR lower(num) LIKE lower(?)
    OR lower(price) LIKE lower(?)
    OR lower(amount) LIKE lower(?);

SELECT
    ROWNUM r,
    id,
    name,
    surname,
    phone,
    adress,
    work_day,
    salary,
    email
FROM
    employee
WHERE
    active = 1
    AND lower(name) LIKE lower(?)
    OR lower(surname) LIKE lower(?)
    OR lower(phone) LIKE lower(?)
    OR lower(adress) LIKE lower(?)
    OR lower(work_day) LIKE lower(?)
    OR lower(salary) LIKE lower(?)
    OR lower(email) LIKE lower(?);

SELECT
    ROWNUM r,
    send_email.id,
    send_email.message,
    student.id         student_id,
    student.name,
    student.surname,
    student.email,
    employee.id        employee_id,
    employee.name      employee_name,
    employee.surname   employee_surname
FROM
    send_email
    INNER JOIN student ON student.id = send_email.student_id
    INNER JOIN employee ON employee.id = send_email.employee_id
WHERE
    send_email.active = 1
    AND lower(send_email.message) LIKE lower(?)
    OR lower(student.name) LIKE lower(?)
    OR lower(student.surname) LIKE lower(?)
    OR lower(student.email) LIKE lower(?)
    OR lower(employee.name) LIKE lower(?)
    OR lower(employee.surname) LIKE lower(?);

SELECT
    ROWNUM r,
    order_book.id,
    order_book.borrow_time,
    order_book.price   borrow_price,
    book.id            book_id,
    book.title,
    book.copies,
    book.page_num,
    book_status.id     book_status_id,
    book_status.status_name,
    student.id         student_id,
    student.name,
    student.surname,
    student.email,
    student.phone,
    student.student_group,
    book.price         book_price
FROM
    order_book
    INNER JOIN student ON student.id = order_book.student_id
    INNER JOIN book ON book.id = order_book.book_id
    INNER JOIN book_status ON book_status.id = order_book.book_status_id
WHERE
    ( order_book.active = 1
      AND book_status.id = ? )
    AND lower(order_book.borrow_time) LIKE lower(?)
    OR lower(book.title) LIKE lower(?)
    OR lower(book.copies) LIKE lower(?)
    OR lower(book.page_num) LIKE lower(?)
    OR lower(student.name) LIKE lower(?)
    OR lower(student.surname) LIKE lower(?)
    OR lower(student.email) LIKE lower(?)
    OR lower(student.phone) LIKE lower(?)
    OR lower(student.student_group) LIKE lower(?)
    OR lower(book_price) LIKE lower(?);

SELECT
    ROWNUM r,
    book.id,
    book.title,
    book.copies,
    book.price,
    book_status.id   book_status_id,
    book_tip.id      book_tip_id,
    book_status.status_name,
    book_tip.tip,
    shelf.id         shelf_id,
    shelf.name,
    book.page_num
FROM
    book
    INNER JOIN book_status ON book_status.id = book.book_status_id
    INNER JOIN book_tip ON book_tip.id = book.book_tip_id
    INNER JOIN shelf ON shelf.id = book.shelf_id
WHERE
    book.active = 1;

SELECT
    ROWNUM r,
    id,
    product_name,
    num,
    price,
    amount
FROM
    product
WHERE
    active = 1
    AND price > 0.2
    AND price < 0.6;

SELECT
    *
FROM
    paid;

INSERT INTO paid (
    id,
    table_order_id,
    price
) VALUES (
    paid_seq.NEXTVAL,
    ?,
    ?
);

SELECT
    *
FROM
    table_order;

UPDATE table_order
SET
    active = 0
WHERE
    table_id = ?;

SELECT
    ROWNUM r,
    paid.id,
    paid.price,
    paid.paid_date,
    table_order.id     table_order_id,
    table_order.res_name,
    lib_table.id       table_id,
    lib_table.lib_table,
    only_order.id      order_id,
    only_order.num,
    only_order.price   order_price,
    only_order.t_order,
    menu.id            menu_id,
    menu.menu_name
FROM
    paid
    INNER JOIN table_order ON table_order.id = paid.table_order_id
    INNER JOIN lib_table ON lib_table.id = table_order.table_id
    INNER JOIN only_order ON only_order.id = table_order.only_order_id
    INNER JOIN menu ON only_order.menu_id = menu.id
WHERE
    paid.active = 1
    AND lower(paid.price) LIKE lower(?)
    OR lower(lib_table.lib_table) LIKE lower(?);

SELECT
    *
FROM
    paid;

UPDATE paid
SET
    active = 0
WHERE
    id = ?;

UPDATE paid
SET
    price = ?
WHERE
    id = ?;

SELECT
    *
FROM
    table_order;

UPDATE table_order
SET
    table_id = ?
WHERE
    id = ?;
 


--PL-SQL--

CREATE OR REPLACE FUNCTION AUTHOR_LIST RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        ROWNUM r,
                        id,
                        name,
                        surname,
                        birth_date,
                        death_date,
                        advance_info,
                        img
                    FROM
                        author
                    WHERE
                        active = 1;

    RETURN result;
END;

SELECT
   AUTHOR_LIST
FROM
    dual;


--STUDENT PL-SQL--

CREATE OR REPLACE FUNCTION get_student_list RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        ROWNUM r,
                        id,
                        name,
                        surname,
                        student_group,
                        phone,
                        email
                    FROM
                        student
                    WHERE
                        active = 1;

    RETURN result;
END;

SELECT
    get_student_list
FROM
    dual;


--AUTHOR PHOTO PL-SQL--

CREATE OR REPLACE FUNCTION get_author_photo (
    f_id IN NUMBER
) RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        id,
                        img
                    FROM
                        author
                    WHERE
                        id = f_id;

    RETURN result;
END;

SELECT
    get_author_photo(3)
FROM
    dual;

CREATE OR REPLACE FUNCTION get_student_photo (
    f_id IN NUMBER
) RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        id,
                        img
                    FROM
                        student
                    WHERE
                        id = f_id;

    RETURN result;
END;

SELECT
    get_student_photo(1)
FROM
    dual;



--EMPLOYEE--

CREATE OR REPLACE FUNCTION get_employee_list RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        ROWNUM r,
                        id,
                        name,
                        surname,
                        phone,
                        adress,
                        work_day,
                        salary,
                        email
                    FROM
                        employee
                    WHERE
                        active = 1;

    RETURN result;
END;

SELECT
    get_employee_list
FROM
    dual;


--EMPLOYEE PHOTO--

CREATE OR REPLACE FUNCTION get_employee_photo (
    f_id IN NUMBER
) RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        id,
                        img
                    FROM
                        employee
                    WHERE
                        id = f_id;

    RETURN result;
END;

SELECT
    get_employee_photo(1)
FROM
    dual;


--BOOK LIST --

CREATE OR REPLACE FUNCTION book_list RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        ROWNUM r,
                        book.id,
                        book.title,
                        book.copies,
                        book.price,
                        book_status.id   book_status_id,
                        book_tip.id      book_tip_id,
                        book_status.status_name,
                        book_tip.tip,
                        shelf.id         shelf_id,
                        shelf.name,
                        book.page_num
                    FROM
                        book
                        INNER JOIN book_status ON book_status.id = book.book_status_id
                        INNER JOIN book_tip ON book_tip.id = book.book_tip_id
                        INNER JOIN shelf ON shelf.id = book.shelf_id
                    WHERE
                        book.active = 1;

    RETURN result;
END;

SELECT
    book_list
FROM
    dual;


--BOOK PHOTO--

CREATE OR REPLACE FUNCTION book_photo (
    f_id IN NUMBER
) RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        id,
                        book_img
                    FROM
                        book
                    WHERE
                        id = f_id;

    RETURN result;
END;

SELECT
    book_photo(1)
FROM
    dual;
    
    
 --MENU LIST --

CREATE OR REPLACE FUNCTION menu_list RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        ROWNUM r,
                        id,
                        menu_name,
                        price
                    FROM
                        menu
                    WHERE
                        active = 1;

    RETURN result;
END;

SELECT
    menu_list
FROM
    dual;
 
 
 --PRODUCT LIST--

CREATE OR REPLACE FUNCTION product_list RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        ROWNUM r,
                        id,
                        product_name,
                        num,
                        price,
                        amount
                    FROM
                        product
                    WHERE
                        active = 1;

    RETURN result;
END;

SELECT
    product_list
FROM
    dual; 



--SEND EMAIL LIST--

CREATE OR REPLACE FUNCTION send_email_list RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        ROWNUM r,
                        send_email.id,
                        message,
                        student.id         student_id,
                        student.name,
                        student.surname,
                        student.email,
                        employee.id        employee_id,
                        employee.name      employee_name,
                        employee.surname   employee_surname
                    FROM
                        send_email
                        INNER JOIN student ON student.id = send_email.student_id
                        INNER JOIN employee ON employee.id = send_email.employee_id
                    WHERE
                        send_email.active = 1;

    RETURN result;
END;

SELECT
    send_email_list
FROM
    dual;


--ONLY ORDER LIST--

CREATE OR REPLACE FUNCTION only_order_list RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        ROWNUM r,
                        only_order.id,
                        only_order.num,
                        only_order.t_order,
                        only_order.price,
                        menu.id menu_id,
                        menu.menu_name,
                        only_order.RES_NAME
                    FROM
                        only_order
                        INNER JOIN menu ON menu.id = only_order.menu_id
                    WHERE
                        only_order.active = 1;

    RETURN result;
END;

SELECT
    only_order_list
FROM
    dual;


--NOTE LIST--

CREATE OR REPLACE FUNCTION note_list RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        id,
                        ROWNUM r,
                        begin_date,
                        end_date,
                        note
                    FROM
                        notes
                    WHERE
                        active = 1;

    RETURN result;
END;

SELECT
    note_list
FROM
    dual;
    
--TABLE ORDER LIST--

CREATE OR REPLACE FUNCTION table_order_list RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        ROWNUM r,
                        table_order.id,
                        table_order.res_name,
                        lib_table.id    table_id,
                        lib_table.lib_table,
                        only_order.id   order_id,
                        only_order.num,
                        only_order.price,
                        only_order.t_order,
                        menu.id         menu_id,
                        menu.menu_name
                    FROM
                        table_order
                        INNER JOIN lib_table ON lib_table.id = table_order.table_id
                        INNER JOIN only_order ON only_order.id = table_order.only_order_id
                        INNER JOIN menu ON only_order.menu_id = menu.id
                    WHERE
                        table_order.active = 1;

    RETURN result;
END;

SELECT
    table_order_list
FROM
    dual;
    
    
    
    --PAID LIST--

CREATE OR REPLACE FUNCTION paid_list RETURN SYS_REFCURSOR IS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR SELECT
                        ROWNUM r,
                        paid.id,
                        paid.price,
                        paid.paid_date,
                        table_order.id     table_order_id,
                        table_order.res_name,
                        lib_table.id       table_id,
                        lib_table.lib_table,
                        only_order.id      order_id,
                        only_order.num,
                        only_order.price   order_price,
                        only_order.t_order,
                        menu.id            menu_id,
                        menu.menu_name
                    FROM
                        paid
                        INNER JOIN table_order ON table_order.id = paid.table_order_id
                        INNER JOIN lib_table ON lib_table.id = table_order.table_id
                        INNER JOIN only_order ON only_order.id = table_order.only_order_id
                        INNER JOIN menu ON only_order.menu_id = menu.id
                    WHERE
                        paid.active = 1;
    RETURN result;
END;

SELECT PAID_LIST FROM DUAL;



--TABLE LIST--

CREATE OR REPLACE FUNCTION TABLE_LIST RETURN SYS_REFCURSOR
IS 
RESULT SYS_REFCURSOR;
BEGIN
    OPEN RESULT FOR
    SELECT
    ROWNUM r,
    lib_table.id,
    lib_table,
    table_status.id table_status_id,
    table_status.status_name
FROM
    lib_table
    INNER JOIN table_status ON table_status.id = lib_table.table_status_id
WHERE
    lib_table.active = 1;
    RETURN RESULT;

END;


SELECT TABLE_LIST FROM DUAL;



--ONLY ORDER ADD METHOD--

CREATE OR REPLACE PROCEDURE ADD_ONLY_ORDER(P_NUM IN INTEGER , P_T_ORDER IN NVARCHAR2  , P_MENU_ID IN  NUMBER , P_PRICE IN FLOAT , P_RES_NAME IN NVARCHAR2)
IS 
BEGIN
    INSERT INTO ONLY_ORDER(ID,NUM,T_ORDER,MENU_ID,PRICE,RES_NAME) 
    VALUES(ONLY_ORDER_SEQ.NEXTVAL,P_NUM,P_T_ORDER,P_MENU_ID,P_PRICE,P_RES_NAME);
END;


--GET MENU BY ID--
CREATE OR REPLACE FUNCTION MENU_BY_ID(P_ID IN NUMBER) RETURN SYS_REFCURSOR
IS 
    RESULT SYS_REFCURSOR;
    BEGIN 
        OPEN RESULT FOR 
            SELECT ROWNUM r,ID,MENU_NAME,PRICE FROM MENU WHERE ACTIVE = 1 AND ID = P_ID;
        RETURN RESULT;
    END;
    
    SELECT MENU_BY_ID(2) FROM DUAL;
    


--BOOK TIP LIST--

CREATE OR REPLACE FUNCTION BOOK_TIP_LIST RETURN SYS_REFCURSOR
IS
    RESULT SYS_REFCURSOR;
    BEGIN
        OPEN RESULT FOR
            SELECT ROWNUM r,ID,TIP FROM BOOK_TIP WHERE ACTIVE = 1;
        RETURN RESULT;
    END;

SELECT BOOK_TIP_LIST FROM DUAL;


--BOOK SHELF LIST --

CREATE OR REPLACE FUNCTION BOOK_SHELF_LIST RETURN SYS_REFCURSOR
IS
    RESULT SYS_REFCURSOR;
    BEGIN
        OPEN RESULT FOR
            SELECT ROWNUM r,ID,NAME FROM SHELF WHERE ACTIVE  = 1;
        RETURN RESULT;
    END;
    
SELECT BOOK_SHELF_LIST FROM DUAL;


--ADD STUDENT --

CREATE OR REPLACE PROCEDURE ADD_STUDENT(P_NAME IN NVARCHAR2 , P_SURNAME IN NVARCHAR2 , P_STUDENT_GROUP IN NVARCHAR2 , P_PHONE IN NVARCHAR2 , P_EMAIL IN NVARCHAR2 , P_IMG IN BLOB) 
IS

    BEGIN 
        INSERT INTO STUDENT(ID,NAME,SURNAME,STUDENT_GROUP,PHONE,EMAIL,IMG) 
              VALUES(STUDENT_SEQ.NEXTVAL,P_NAME,P_SURNAME,P_STUDENT_GROUP,P_PHONE,P_EMAIL,P_IMG);
    END;



--Unusable index on PK (primary key)
ALTER INDEX STUDENT_PK REBUILD;


