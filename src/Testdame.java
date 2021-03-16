import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

public class Testdame {
    public static void main1(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/test0316?useSSL=false";
        String username="root";//数据库的名称
        String password="1111";//数据库的密码
        Connection connection=
                DriverManager.getConnection(url,username,password);
        //执行SQL语句
        String sql="select * from user ";
        Statement statement=connection.createStatement();
        //结果集
        ResultSet resultSet=statement.executeQuery(sql);
        User user=new User();
        //一条if 多条while 不为空查询
        if(resultSet.next()){
           /* System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));*/
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
        }
        System.out.println("查询到的数据是："+user);
    }
    public static void main2(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/test0316?useSSL=false";
        String username="root";//数据库的名称
        String password="1111";//数据库的密码
        Connection connection=
                DriverManager.getConnection(url,username,password);
        //执行SQL语句
        String sql="select * from user where name='liulin'and password='123'";
        Statement statement=connection.createStatement();
        //结果集
        ResultSet resultSet=statement.executeQuery(sql);
        User user=new User();
        //一条if 多条while 不为空查询
        if(resultSet.next()){
           /* System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));*/
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
        }
        System.out.println("查询到的数据是："+user);
    }
    public static void main3(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/test0316?useSSL=false";
        String username="root";//数据库的名称
        String password="1111";//数据库的密码
        Connection connection=
                DriverManager.getConnection(url,username,password);
        //执行SQL语句
        String uname="liulin";
        String upass="123";
        String sql="select * from user where name='"+uname+"'and password='"+upass+"'";//字符串拼接
        //不安全 存在SQL注入 当upass=“1‘or ’1‘=’1 ”时
        Statement statement=connection.createStatement();
        //结果集
        ResultSet resultSet=statement.executeQuery(sql);
        User user=new User();
        //一条if 多条while 不为空查询
        if(resultSet.next()){
           /* System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));*/
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
        }
        System.out.println("查询到的数据是："+user);
    }
    public static void main4(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/test0316?useSSL=false";
        String username="root";//数据库的名称
        String password="1111";//数据库的密码
        //Connection connection=DriverManager.getConnection(url,username,password);
        DataSource dataSource=new MysqlDataSource();//获取数据源 有连接池
        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);
       Connection connection= dataSource.getConnection();
        //执行SQL语句
        String uname="liulin";
        String upass="123";
        //String sql="select * from user where name='"+uname+"'and password='"+upass+"'";//字符串拼接
        String sql="select * from user where name =? and password =?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,uname);
        preparedStatement.setString(2,upass);
        System.out.println("sql:"+preparedStatement.toString());
        //不安全 存在SQL注入 当upass=“1‘or ’1‘=’1 ”时
        //Statement statement=connection.createStatement();
        //结果集
        ResultSet resultSet=preparedStatement.executeQuery();
        User user=new User();
        //一条if 多条while 不为空查询
        if(resultSet.next()){
           /* System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));*/
            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
        }
        System.out.println("查询到的数据是："+user);
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    public static void main5(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/test0316?useSSL=false";
        String username="root";//数据库的名称
        String password="1111";//数据库的密码
        //Connection connection=DriverManager.getConnection(url,username,password);
        DataSource dataSource=new MysqlDataSource();//获取数据源 有连接池
        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);
        Connection connection= dataSource.getConnection();
        //执行SQL语句
        String uname="mao";
        String upass="1234";
        //String sql="select * from user where name='"+uname+"'and password='"+upass+"'";//字符串拼接
        String sql="insert into user(id,name,password) values(?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,2);
        preparedStatement.setString(2,uname);
        preparedStatement.setString(3,upass);
        System.out.println("sql:"+preparedStatement.toString());
        //不安全 存在SQL注入 当upass=“1‘or ’1‘=’1 ”时
        //Statement statement=connection.createStatement();
        //结果集
        int ret=preparedStatement.executeUpdate();
        if(ret!=0){
            System.out.println("插入成功！");
        }
        //关闭数据
        preparedStatement.close();
        connection.close();
    }
    public static void main6(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/test0316?useSSL=false";
        String username="root";//数据库的名称
        String password="1111";//数据库的密码
        //Connection connection=DriverManager.getConnection(url,username,password);
        DataSource dataSource=new MysqlDataSource();//获取数据源 有连接池
        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);
        Connection connection= dataSource.getConnection();
        //执行SQL语句
        String uname="mao";
        String upass="1234";
        //String sql="select * from user where name='"+uname+"'and password='"+upass+"'";//字符串拼接
        String sql="update user set name=? where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        //preparedStatement.setInt(1,2);
        preparedStatement.setString(1,"ai");
        preparedStatement.setInt(2,2);
        System.out.println("sql:"+preparedStatement.toString());
        //不安全 存在SQL注入 当upass=“1‘or ’1‘=’1 ”时
        //Statement statement=connection.createStatement();
        //结果集
        int ret=preparedStatement.executeUpdate();
        if(ret!=0){
            System.out.println("更新成功！");
        }
        //关闭数据
        preparedStatement.close();
        connection.close();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url="jdbc:mysql://127.0.0.1:3306/test0316?useSSL=false";
        String username="root";//数据库的名称
        String password="1111";//数据库的密码
        //Connection connection=DriverManager.getConnection(url,username,password);
        DataSource dataSource=new MysqlDataSource();//获取数据源 有连接池
        ((MysqlDataSource)dataSource).setUrl(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);
        Connection connection= dataSource.getConnection();
        //执行SQL语句
        String uname="mao";
        String upass="1234";
        //String sql="select * from user where name='"+uname+"'and password='"+upass+"'";//字符串拼接
        String sql="delete from user where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,2);
        System.out.println("sql:"+preparedStatement.toString());
        //不安全 存在SQL注入 当upass=“1‘or ’1‘=’1 ”时
        //Statement statement=connection.createStatement();
        //结果集
        int ret=preparedStatement.executeUpdate();
        if(ret!=0){
            System.out.println("删除成功！");
        }
        //关闭数据
        preparedStatement.close();
        connection.close();
    }
}
