import java.sql.*;

public class Test
{
  public static void main(String s[])throws Exception
  {
    Connection con;
    PreparedStatement ps;
    
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3600/madurai","root","");
    ps=con.prepareStatement("insert into student values(101,'krithickram','MSc(CS)',7.35)");
    ps.executeUpdate();
    ps.close();
    System.out.println("Student Record Inserted");
  }
}

