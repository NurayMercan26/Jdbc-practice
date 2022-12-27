package jdbctests;public class TestConnection {
  

    public static void main(String[] args) throws SQLException {
        String dbURL = "jdbc:oracle:thin:@54.175.31.71:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet= statement.executeQuery("SELECT * FROM regions");



//        //next() --> move pointer to first row
 // resultSet.next();
//
//       getting information with column name
 //    System.out.println(resultSet.getString("region_name"));

     //   while (resultSet.next()){
      //      System.out.print(resultSet.getString("region_id")+" ");
        //    System.out.println(resultSet.getString("region_name"));
//
      //  }

      //  ResultSet resultSet1 = statement.executeQuery("Select * From employees ");

      // while (resultSet1.next()){
       //     System.out.print(resultSet1.getString("first_name")+" ");
        //    System.out.println(resultSet1.getString("last_name"));
       // }

        //next()--> move pointer to first row
     //  resultSet.next();

        //getting information with column name
    //   System.out.println( resultSet.getString("region_name"));

       //getting information with column index(starts 1)
      // System.out.println(resultSet.getString(2));

       //1-  Europe
        //2- Americas

        //move to second row
       // System.out.println(     resultSet.getInt(1)+"-"+resultSet.getString(2));

        //move to third row
      //  resultSet.next();
       // System.out.println(resultSet.getInt(1)+"-"+resultSet.getString(2));

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+"-"+resultSet.getString(2));
        }


        //close connection
        resultSet.close();
        statement.close();
        connection.close();



    }
}
