package com.example.test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBQuery {
    private DataSource dataSource;

    public DBQuery(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int count(String tableName) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tableName)) {
                rs.next();
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public ArrayList<String> searchBook() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOK");
            ArrayList<String> result = new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getInt(1) +
                        "\t\t" + rs.getString(2) +
                        "\t\t" + rs.getString(3) +
                        "\t\t" + rs.getInt(4));
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

    public String bookRank() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ORDERS.BOOKID, COUNT(ORDERS.BOOKID) " +
                    "FROM ORDERS GROUP BY ORDERS.BOOKID ORDER BY COUNT(ORDERS.BOOKID) DESC LIMIT 1");
            if (rs.next())
                return rs.getInt(1) +
                        "이고\t\t" + rs.getInt(2);
            else
                return "없음";
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

    public ArrayList<String> searchCustomer() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
            ArrayList<String> result = new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getInt(1) +
                        "\t\t" + rs.getString(2) +
                        "\t" + rs.getString(3) +
                        "\t" + rs.getString(4));
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

    public String customerRank() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ORDERS.CUSTID, COUNT(ORDERS.CUSTID) " +
                    "FROM ORDERS GROUP BY  ORDERS.CUSTID ORDER BY COUNT(ORDERS.CUSTID) DESC LIMIT 1");
            if (rs.next())
                return rs.getInt(1) +
                        "이고\t\t" + rs.getInt(2);
            else
                return "없음";
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

