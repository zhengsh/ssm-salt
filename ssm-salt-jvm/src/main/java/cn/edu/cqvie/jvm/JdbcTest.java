package cn.edu.cqvie.jvm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhengsh
 * @date 2020-12-14
 */
public class JdbcTest {
    //root:sixxiongda100!@#@tcp(mysql.newibi.com:3306)/link_information?charset=utf8mb4

    static List<String> idsMenus = new ArrayList<>();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        exec("4,5,6,8,9,10,11,12");
        return;
    }

    private static void exec(String ids) throws ClassNotFoundException, SQLException {
        Connection con = getConnection();
        PreparedStatement pds = con.prepareStatement("select menu_id from sys_menu where parent_id in ( + ids +)");
        ResultSet rs = pds.executeQuery();
        List<String> childNodes = new ArrayList<>();
        while (rs.next()) {
            Long result = rs.getLong(1);
            childNodes.add(String.valueOf(result));
        }
        if (childNodes.size() > 0) {
            idsMenus.addAll(childNodes);
            exec(String.join(",", childNodes));
        } else {
            pds.execute("delete sys_menu from id in ("+  +")");
        }
        rs.close();
        con.close();
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("net.sf.log4jdbc.DriverSpy");
        return DriverManager.getConnection(
                "jdbc:log4jdbc:mysql://mysql.newibi.com:3306/pay_manager", "root", "sixxiongda100!@#");
    }
}
