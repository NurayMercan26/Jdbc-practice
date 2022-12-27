package jdbctests;public class LibraryConnectionTest {
  

    @Test
    public void test1() throws SQLException {
        String dbURL = "jdbc:mysql://54.175.31.71:3306/library1/";
        String dbUsername = "library1_client";
        String dbPassword = "WVF4NdGXCKHeE6VQ";

        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery("SELECT * FROM books");

        //once you set up connection default pointer looks for
        //move to first row
       // resultSet.next();

        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
