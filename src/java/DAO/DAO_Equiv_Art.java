/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Equiv_Art;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Valentin
 */
public class DAO_Equiv_Art {

    public int CREATE(Equiv_Art equiv_art) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into equiv_art (id_art,id_art_equiv) values (?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, equiv_art.getId_art());
            ps.setInt(2,equiv_art.getId_art_equiv());

            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Equiv_Art> GET_ALL()
    {
        ArrayList<Equiv_Art> equiv_art = new ArrayList<Equiv_Art>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM equiv_art WHERE id_art = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Equiv_Art b = new Equiv_Art();
                b.setId_art(rs.getInt("id_art"));
                b.setId_art_equiv(rs.getInt("id_art_equiv"));
                
                equiv_art.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return equiv_art;
    }

   public Equiv_Art READ(int id_art)
    {
        Equiv_Art b = new Equiv_Art();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM equiv_art WHERE id_art = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_art);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setId_art(rs.getInt("id_art"));
                b.setId_art_equiv(rs.getInt("id_art_equiv"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(Equiv_Art equiv_art)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE equiv_art SET id_art=? ,id_art_equiv=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, equiv_art.getId_art());
            ps.setInt(2,equiv_art.getId_art_equiv());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_art)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE equiv_art WHERE id_art=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_art);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}

