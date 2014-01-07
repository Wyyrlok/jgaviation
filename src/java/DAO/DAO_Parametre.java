/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Parametre;
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
public class DAO_Parametre {
    
    public int CREATE(Parametre parametre) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into parametre (sKey,sValue) values (?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, parametre.getsKey());
            ps.setString(2, parametre.getsValue());
        

            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Parametre> GET_ALL()
    {
        ArrayList<Parametre> parametre = new ArrayList<Parametre>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM parametre";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Parametre b = new Parametre();
                b.setsKey(rs.getString("sKey"));
                b.setsKey(rs.getString("sValue"));
                
                parametre.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return parametre;
    }

   public Parametre READ(int parametre)
    {
        Parametre b = new Parametre();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM parametre WHERE sKey= ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,parametre);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setsKey(rs.getString("sKey"));
                b.setsKey(rs.getString("sValue"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(Parametre parametre)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE nbcycle SET id_NbCycle=? ,id_cycle=? ,date_vol=? ,nb_cycle=?";
            ps=con.prepareStatement(sql);

            ps.setString(1, parametre.getsKey());
            ps.setString(2, parametre.getsValue());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int sKey)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE parametre WHERE sKey=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, sKey);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}


