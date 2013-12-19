/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Workorder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author quent_000
 */
public class DAO_Workorder {
    
    public int CREATE(Workorder workorder) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into proprietaire (Id_wo,Immat,Id_proprio,Date_in,Date_out,Num_wo) values (?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setInt(1,workorder.getId_wo());
            ps.setString(2,workorder.getImmat());
            ps.setInt(3,workorder.getId_proprio());
            ps.setDate(4, (Date) workorder.getDate_in());
            ps.setDate(5, (Date) workorder.getDate_out());
            ps.setString(6,workorder.getNum_wo());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Workorder> GET_ALL()
    {
        ArrayList<Workorder> workorder = new ArrayList<Workorder>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM workorder WHERE id_wo = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Workorder b = new Workorder();
                b.setId_wo(rs.getInt("id_wo"));
                b.setImmat(rs.getString("immat"));
                b.setId_proprio(rs.getInt("id_proprio"));
                b.setDate_in(rs.getDate("date_in"));
                b.setDate_out(rs.getDate("date_out"));
                b.setNum_wo(rs.getString("num_wo"));
                
                workorder.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return workorder;
    }

    public Workorder READ(int id_wo)
    {
        Workorder workorder = new Workorder();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM workorder WHERE id_wo = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_wo);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                workorder.setId_wo(rs.getInt("id_wo"));
                workorder.setImmat(rs.getString("immat"));
                workorder.setId_proprio(rs.getInt("id_proprio"));
                workorder.setDate_in(rs.getDate("date_in"));
                workorder.setDate_out(rs.getDate("date_out"));
                workorder.setNum_wo(rs.getString("num_wo"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return workorder;
    }
    
    public int UPDATE(Workorder workorder)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE proprietaire SET id_wo=?, immat=? ,id_proprio=? ,date_in=? ,date_out=? ,num_wo=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1,workorder.getId_wo());
            ps.setString(2,workorder.getImmat());
            ps.setInt(3,workorder.getId_proprio());
            ps.setDate(4, (Date) workorder.getDate_in());
            ps.setDate(5, (Date) workorder.getDate_out());
            ps.setString(6,workorder.getNum_wo());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_wo)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE workorder WHERE id_wo=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_wo);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}