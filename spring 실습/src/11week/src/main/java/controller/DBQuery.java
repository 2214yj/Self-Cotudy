package controller;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBQuery {
    private DataSource dataSource;

    public DBQuery(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    PreparedStatement pstmt = null;

    public int insertBook(BookInfo bookInfo) throws SQLException {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String insertQuery = "INSERT INTO BOOK(bookname,publisher,price) values(?,?,?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, bookInfo.getName());
            pstmt.setString(2, bookInfo.getPublisher());
            pstmt.setInt(3, (int) bookInfo.getPrice());
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("BOOK Table Inserted Successfully.......");
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int insertCustomer(CustomerInfo customerInfo) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String insertQuery = "INSERT INTO CUSTOMER(name,address,phone) values(?,?,?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, customerInfo.getName());
            pstmt.setString(2, customerInfo.getAddress());
            pstmt.setString(3, customerInfo.getPhone());
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("CUSTOMER Table Inserted Successfully.......");
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCustId(String custName) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String selectQuery = "SELECT Customer.custid FROM Customer where Customer.name = ?";
            pstmt = conn.prepareStatement(selectQuery);
            pstmt.setString(1,custName);
            ResultSet rs = pstmt.executeQuery();
            System.out.println(rs);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getBookId(String bookName) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String selectQuery = "SELECT Book.bookid FROM Book where Book.bookname = ?";
            pstmt = conn.prepareStatement(selectQuery);
            pstmt.setString(1,bookName);
            ResultSet rs = pstmt.executeQuery();
            System.out.println(rs);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int insertOrder(OrderInfo orderInfo) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            String insertQuery = "INSERT INTO Orders(custid,bookid,saleprice,orderdate) values(?,?,?,?)";
            pstmt = conn.prepareStatement(insertQuery);
            System.out.println("well");
            pstmt.setInt(1, Math.toIntExact(orderInfo.getCustId()));
            pstmt.setInt(2, Math.toIntExact(orderInfo.getBookId()));
            pstmt.setInt(3, orderInfo.getPrice());
            pstmt.setString(4, orderInfo.getDate());
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("ORDER Table Inserted Successfully.......");
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}

