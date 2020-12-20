package cn.edu.cqvie.jvm;

import java.sql.*;

/**
 * @author zhengsh
 * @date 2020-12-14
 */
public class JdbcTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("net.sf.log4jdbc.DriverSpy");
        Connection con = DriverManager.getConnection(
                "jdbc:log4jdbc:mysql://127.0.0.1:3306/ssm", "root", "root123");
        PreparedStatement pds = con.prepareStatement("select 1");
        ResultSet rs = pds.executeQuery();
        while (rs.next()) {
            String result = rs.getString(1);
            System.out.println("rs: " + result);
        }
        rs.close();
        con.close();
    }
}
