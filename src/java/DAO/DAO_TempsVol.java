/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.TempsVol;
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
public class DAO_TempsVol {
    
    public int CREATE(TempsVol tempsvol) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into tempsvol (id_TempsVol,immat,date_vol,duree) values (?,?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setInt(1,tempsvol.getId_TempsVol());
            ps.setString(2,tempsvol.getImmat());
            ps.setDate(3,(Date)tempsvol.getDate_vol());
            ps.setFloat(4,tempsvol.getDuree());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<TempsVol> GET_ALL()
    {
        ArrayList<TempsVol> tempsvol = new ArrayList<TempsVol>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM typeaeronef";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                TempsVol b = new TempsVol();
                b.setId_TempsVol(rs.getInt("id_TempsVol"));
                b.setImmat(rs.getString("immat"));
                b.setDate_vol(rs.getDate("date_vol"));
                b.setDuree(rs.getFloat("duree"));
                
                tempsvol.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return tempsvol;
    }

    public TempsVol READ(int id_TempsVol)
    {
        TempsVol tempsvol = new TempsVol();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM tempsvol WHERE id_TempsVol = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_TempsVol);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                
                tempsvol.setId_TempsVol(rs.getInt("id_TempsVol"));
                tempsvol.setImmat(rs.getString("immat"));
                tempsvol.setDate_vol(rs.getDate("date_vol"));
                tempsvol.setDuree(rs.getFloat("duree"));
                
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return tempsvol;
    }
    
    public int UPDATE(TempsVol tempsvol)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE tempsvol SET id_TempsVol=?, immat=? ,date_vol=? ,duree=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1,tempsvol.getId_TempsVol());
            ps.setString(2,tempsvol.getImmat());
            ps.setDate(3,(Date)tempsvol.getDate_vol());
            ps.setFloat(4,tempsvol.getDuree());
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_TempsVol)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE tempsvol WHERE id_TempsVol=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_TempsVol);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }   
}