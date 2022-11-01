package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listOfMapExample {

    String dbURL = "jdbc:oracle:thin:@54.175.31.71:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1(){

        // creating list for keeping all the  rows maps
        List<Map<String,Object>>queryData =  new ArrayList<>();
        Map<String,Object> row1 = new HashMap<>();

        row1.put("first_name","Steven");
        row1.put("last_name","King");
        row1.put("salary",24000);
        row1.put("jop_id","AD_PRES");
        System.out.println(row1.toString());

        Map<String, Object>row2 = new HashMap<>();
        row2.put("first_name","Neena");
        row2.put("last_name","Kochhar");
        row2.put("salary",17000);
        row2.put("jop_id","AD_VP");

        System.out.println( row2.toString());
      //adding rows one by one to my list
      queryData.add(row1);
      queryData.add(row2);

      //get the steven lastname directly from the list
        System.out.println( queryData.get(0).get("last_name"));

    }

    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

        // in order to get column names we need resultsetmetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();

        // move to first row
        resultSet.next();


        // creating list for keeping all the  rows maps
        List<Map<String,Object>>queryData =  new ArrayList<>();
        Map<String,Object> row1 = new HashMap<>();

        row1.put(rsmd.getColumnName(1),resultSet.getString(1));
        row1.put(rsmd.getColumnName(2),resultSet.getString(2));
        row1.put(rsmd.getColumnName(3),resultSet.getString(3));
        row1.put(rsmd.getColumnName(4),resultSet.getString(4));

        System.out.println(row1.toString());

        Map<String, Object>row2 = new HashMap<>();
        row2.put(rsmd.getColumnName(1),resultSet.getString(1));
        row2.put(rsmd.getColumnName(2),resultSet.getString(2));
        row2.put(rsmd.getColumnName(3),resultSet.getString(3));
        row2.put(rsmd.getColumnName(4),resultSet.getString(4));

        row2.put("first_name","Neena");
        row2.put("last_name","Kochhar");
        row2.put("salary",17000);
        row2.put("jop_id","AD_VP");

        System.out.println( row2.toString());
        //adding rows one by one to my list
        queryData.add(row1);
        queryData.add(row2);

        //get the steven lastname directly from the list
      //  System.out.println( queryData.get(0).get("last_name"));

        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
