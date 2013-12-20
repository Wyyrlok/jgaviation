/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.SuiviRep;
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
public class DAO_SuiviRep {
    
    public int CREATE(SuiviRep suivirep) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into suivirep (id_SuiviRep,immat,type,objet,ref_approb,date_appro,id_personnel) values (?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setInt(1,suivirep.getId_SuiviRep());
            ps.setString(2,suivirep.getImmat());
            ps.setString(3,suivirep.getType());
            ps.setString(4,suivirep.getObjet());
            ps.setString(5,suivirep.getRef_approb());
            ps.setDate(6,(Date)suivirep.getDate_appro());
            ps.setInt(7,suivirep.getId_personnel());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<SuiviRep> GET_ALL()
    {
        ArrayList<SuiviRep> suivirep = new ArrayList<SuiviRep>();
        
        Connection con = null; 
        ResultSet rs=null;
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM suivirep WHERE id_SuiviRep = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                SuiviRep b = new SuiviRep();
                b.setId_SuiviRep(rs.getInt("id_SuiviRep"));
                b.setImmat(rs.getString("immat"));
                b.setType(rs.getString("type"));
                b.setObjet(rs.getString("objet"));
                b.setRef_approb(rs.getString("ref_approb"));
                b.setDate_appro(rs.getDate("date_appro"));
                b.setId_personnel(rs.getInt("id_personnel"));
                
                suivirep.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return suivirep;
    }

    public SuiviRep READ(int id_SuiviRep)
    {
        SuiviRep suivirep = new SuiviRep();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM suivirep WHERE id_SuiviRep = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_SuiviRep);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                
                suivirep.setId_SuiviRep(rs.getInt("id_SuiviRep"));
                suivirep.setImmat(rs.getString("immat"));
                suivirep.setType(rs.getString("type"));
                suivirep.setObjet(rs.getString("objet"));
                suivirep.setRef_approb(rs.getString("ref_approb"));
                suivirep.setDate_appro(rs.getDate("date_appro"));
                suivirep.setId_personnel(rs.getInt("id_personnel"));
                
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}      
        
        
        return suivirep;
    }
    
    public int UPDATE(SuiviRep suivirep)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE suivirep SET id_SuiviRep=?, immat=? ,type=? ,objet=? ,ref_approb=? ,date_appro=? ,id_personnel=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1,suivirep.getId_SuiviRep());
            ps.setString(2,suivirep.getImmat());
            ps.setString(3,suivirep.getType());
            ps.setString(4,suivirep.getObjet());
            ps.setString(5,suivirep.getRef_approb());
            ps.setDate(6,(Date)suivirep.getDate_appro());
            ps.setInt(7,suivirep.getId_personnel());
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_SuiviRep)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE suivirep WHERE id_SuiviRep=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_SuiviRep);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }   
}