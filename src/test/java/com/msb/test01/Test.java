package com.msb.test01;

import java.sql.*;
import org.junit.Test;  // 导入Test注解
import static org.junit.Assert.*;  // 导入断言方法

public class Test {
    @Test
    public static void main(String[] args) throws ClassNotFoundException, SQLException { // throws异常是下面forName上alt+enter后生成的
        // 加载driver驱动：
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://192.168.1.34:3306/blockchain?serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "hscizyq";
        Connection conn = DriverManager.getConnection(url,username,password);
        // 创建会话
        Statement sta = conn.createStatement();
        // 发送SQL
        ResultSet rs1 = sta.executeQuery("select * from sys_user where user_name <= 40");
        // 处理结果
        while(rs1.next()){
            System.out.println(rs1.getInt("dept_id")+"---"+rs1.getString("user_name"));
        }
        // 关闭资源
        sta.close();
        conn.close();
        assertTrue(true);  // 需要导入 org.junit.Assert.*
    }
}
