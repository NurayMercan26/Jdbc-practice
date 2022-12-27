package utilities;public class DBUtils {
  


        private static Connection connection;
        private static Statement statement;
        private static ResultSet resultSet;

        public static void createConnection(String dbUrl,String dbUsername,String dbPassword) {
            try {
                connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
}
