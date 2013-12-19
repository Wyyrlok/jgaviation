/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Aeronef;
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
public class DAO_Aeronef {
    
    public int CREATE(Aeronef aeronef) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into proprietaire (civilite,nom,prenom,societe,adresse1,adresse2,ville,nip,tel1,tel2,email,email2,fax,portable,prive) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setString(1,aeronef.getImmat());
            ps.setInt(2,aeronef.getId_const());
            ps.setString(3,aeronef.getSerial_nb());
            ps.setDate(4, (Date) aeronef.getDate_const());
            ps.setInt(5,aeronef.getId_proprio());
            ps.setInt(6,aeronef.getId_type());
            ps.setString(7,aeronef.getType());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Aeronef> GET_ALL()
    {
        ArrayList<Aeronef> aeronef = new ArrayList<Aeronef>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM aeronef WHERE immat = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Aeronef b = new Aeronef();
                b.setImmat(rs.getString("immat"));
                b.setId_const(rs.getInt("id_const"));
                b.setSerial_nb(rs.getString("serial_nb"));
                b.setDate_const(rs.getDate("date_const"));
                b.setId_proprio(rs.getInt("id_proprio"));                
                b.setType(rs.getString("type"));
                
                aeronef.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return aeronef;
    }

    public Aeronef READ(String immat)
    {
        Aeronef aeronef = new Aeronef();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM aeronef WHERE immat = ?";
            
            ps=con.prepareStatement(sql);
            ps.setString(1,immat);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                aeronef.setImmat(rs.getString("immat"));
                aeronef.setId_const(rs.getInt("id_const"));
                aeronef.setSerial_nb(rs.getString("serial_nb"));
                aeronef.setDate_const(rs.getDate("date_const"));
                aeronef.setId_proprio(rs.getInt("id_proprio"));                
                aeronef.setType(rs.getString("type"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return aeronef;
    }
    
    public int UPDATE(Aeronef aeronef)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE proprietaire SET immat=?, id_const=? ,serial_nb=? ,date_const=? ,id_proprio=? ,id_type=? ,type=?";
            ps=con.prepareStatement(sql);

            ps.setString(1,aeronef.getImmat());
            ps.setInt(2,aeronef.getId_const());
            ps.setString(3,aeronef.getSerial_nb());
            ps.setDate(4, (Date) aeronef.getDate_const());
            ps.setInt(5,aeronef.getId_proprio());
            ps.setInt(6,aeronef.getId_type());
            ps.setString(7,aeronef.getType());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(String immat)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE aeronef WHERE immat=? ";
            ps=con.prepareStatement(sql);

            ps.setString(1, immat);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}
