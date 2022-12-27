package jdbctests;public class daynamic_list {
  
    String dbURL = "jdbc:oracle:thin:@54.175.31.71:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        // in order to get column names we need resultsetmetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();

        //list of maps to keep all information
        List<Map<String,Object>> queryData = new ArrayList<>();

        //number of columns
        int colCount = rsmd.getColumnCount();

        // loop through each row
        while (resultSet.next()){
            Map<String,Object>row = new HashMap<>();
            
            //some code to fill the dynamically
            for (int i = 1; i <=colCount ; i++) {
                row.put(rsmd.getColumnName(i),resultSet.getObject(i));
                
            }


            //add ready map row to the list
            queryData.add(row);

        }
        //print each row inside the list
        for (Map<String,Object> row: queryData){
            System.out.println(row.toString());
        }


      //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
