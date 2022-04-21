
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc2020;

import java.sql.*;
import java.util.*;

/**
 *
 * @author ujjawal kumar
 */
public class RackData 
{
    public String insert(RackBean rb) throws Exception
    {
        if(rb != null)
        {
            if(rb.getRackno() <= 0)
            {
                return "input";
            }
            else if(rb.getSubject().equals(""))
            {
                return "input";
            }

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@laptop-ujjawal:1521:XE","M1","M1");   
            PreparedStatement pst = con.prepareStatement("insert into emp1 values(?,?)");
            pst.setInt(1, rb.getRackno());
            pst.setString(2, rb.getSubject());
            pst.executeUpdate();
            con.close();
            return "success";
        }
        else
        {
            return "input";
        }
    }

    public String delete(int rackno) throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@laptop-ujjawal:1521:XE","M1", "M1");
        PreparedStatement pst = con.prepareStatement("delete from emp1 where no = ?");
        pst.setInt(1, rackno);
        int x = pst.executeUpdate();
        con.close();
        if(x > 0)
        {
            return "success";
        }
        else
        {
            return "input";
        }
    }
    


    public RackBean search(int rackno) throws Exception
    {
        RackBean r = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@laptop-ujjawal:1521:XE","M1", "M1");
        PreparedStatement pst = con.prepareStatement("select * from emp1 where no = ?");
        pst.setInt(1, rackno);
        ResultSet rs = pst.executeQuery();
        if( rs.next())
        {
            r = new RackBean();
            r.setRackno(rs.getInt(1));
            r.setSubject(rs.getString(2));
        }
        con.close();
        return r;
    }

    public ArrayList getAll() throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@laptop-ujjawal:1521:XE","M1", "M1");

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("Select * from emp1 order by 1");
        ArrayList al = new ArrayList();
        RackBean rb = null;

        while(rs.next())
        {
            rb = new RackBean();
            rb.setRackno(rs.getInt(1));
            rb.setSubject(rs.getString(2));
            al.add(rb);
        }
        con.close();
        return al;
    }
}