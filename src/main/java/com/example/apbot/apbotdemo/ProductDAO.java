import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {

    // JDBC连接信息
    private static final String URL = "jdbc:mysql://localhost:3306/ap_database";
    private static final String USER = "root";
    private static final String PASSWORD = "***";// 模糊处理

    // 插入数据的SQL语句
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO products (itemno, price) VALUES (?, ?, ?)";

    // 数据库连接
    private Connection connection;

    public DatabaseHandler() {
        try {
            // 加载 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立数据库连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProduct(Product product) {
        try {
            // 创建 PreparedStatement 对象
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
            // 设置 SQL 语句中的参数
            preparedStatement.setString(1, product.getItemno());
            preparedStatement.setDouble(2, product.getPrice());

            // 执行 SQL 语句
            preparedStatement.executeUpdate();

            // 关闭资源
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            // 关闭数据库连接
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
