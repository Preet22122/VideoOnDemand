
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbLoader {

    public static ResultSet executeQuery(String query)
    {
        ResultSet resultSet = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vod", "root", "");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery(query);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }
}
