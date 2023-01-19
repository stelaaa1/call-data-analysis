import java.sql.*;
import java.util.Scanner;
public class call{
public static void main(String args[]) 
{
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Call ID: ");
    int id=sc.nextInt();
    System.out.println("Enter From_number: ");
    String From_number=sc.next();
    System.out.println("Start_time: ");
    float Start_time=sc.nextFloat();
    System.out.println("End_time: ");
    float End_time=sc.nextFloat();
    System.out.println("Duration: ");
    int Duration=sc.nextInt();
    try 
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try 
        {
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager12");
            PreparedStatement stmnt=con.prepareStatement("insert into Call data values(?,?,?,?,?)");
            stmnt.setInt(1, id);
            stmnt.setInt(2, From_number);
            stmnt.setDate(3, Start_time);
            stmnt.setDate(4, End_time);
            stmnt.setInt(5, Duration);

            int i=stmnt.executeUpdate();
            System.out.println(i+"records inserted");
            Statement stmnt1=con.createStatement();
            ResultSet rs=stmnt1.executeQuery("select * from Call");
            while (rs.next()) 
            {
                System.out.println(rs.getInt(1)+" _ "+rs.getInt(2)+" _ "+rs.getDate(3)+" _ "rs.getDate(4)+" _ "+rs.getInt(5));
                                
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    

    
}    
}