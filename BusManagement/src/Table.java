import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author  Pradumya
 * @date  ${DATE} ${TIME}
 * @version 1.0
 */

class Table extends JFrame
{
	public void table(String s1)
	{
		JFrame q =new JFrame("VIEW BOOKINGS");
		q.setBounds(150,150,800,500);
		q.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		q.setVisible(true);
		
		String column[] = {};
		String data[][] = {}; 
		
		JTable jt = new JTable(data,column);
		JScrollPane sp = new JScrollPane(jt); 
	    q.add(sp); 
	
     	Connection conn;
		PreparedStatement pst;
		ResultSet rs;

		//String st = "";
		
		try
		{
		 Class.forName("com.mysql.cj.jdbc.Driver");

		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus", "admin", "1234");
		 String sql = "select Source,Destination,Day,Months,Seats from BookTickets where Username='"+s1+"' ";
		 pst = conn.prepareStatement(sql);
		 rs = pst.executeQuery();
		 jt.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
		  System.out.println(e.getMessage());
		}
		
	}
}	