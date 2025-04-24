package jdbcdemo;
import java.sql.*;

public class jdbc {
    private static final String url = "jdbc:mysql://localhost:3306/jimjdbc";
    private static final String username = "jimjdbc";
    private static final  String password = " abid009  ";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("int");

                System.out.println("ID :" +id);
                System.out.println("Name : " +name);
                System.out.println("Age : " +age);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
