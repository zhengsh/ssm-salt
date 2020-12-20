package cn.edu.cqvie.jvm;

import java.sql.*;

/**
 * @author zhengsh
 * @date 2020-12-14
 */
public class JdbcTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/easy-code?useSSL=false&characterEncoding=UTF-8&useUnicode=true&serverTimezone=Asia/Shanghai"
                , "root", "zhh359#");
        PreparedStatement pds = con.prepareStatement("select 1");
        ResultSet rs = pds.executeQuery();
        while (rs.next()) {
            String result = rs.getString(1);
            System.out.println("rs: " + result);
        }
        con.close();
    }
}
