/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.ElmntMoteur;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.el.ELManager;

/**
 *
 * @author Valentin
 */
public class DAO_ElmntMoteur {
    
      
    
    public int CREATE(ElmntMoteur elmntMoteur) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into elmntmoteur (id_elmnt,designation,id_const_marque,type,serial_nb,date,observations,id_moteur) values (?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, elmntMoteur.getId_elmnt());
            ps.setString(2,elmntMoteur.getDesignation());
            ps.setInt(3,elmntMoteur.getId_Const_Marque());
            ps.setString(4,elmntMoteur.getType());
            ps.setString(5,elmntMoteur.getSerial_nb());
            ps.setDate(6, (Date) elmntMoteur.getDate());
            ps.setString(7, elmntMoteur.getObservations());
            ps.setInt(8, elmntMoteur.getId_moteur());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<ElmntMoteur> GET_ALL()
    {
        ArrayList<ElmntMoteur> elmntMoteur = new ArrayList<ElmntMoteur>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM elmntmoteur";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                ElmntMoteur b = new ElmntMoteur();
                b.setId_elmnt(rs.getInt("id_elmnt"));
                b.setDesignation(rs.getString("designation"));
                b.setId_Const_Marque(rs.getInt("id_const_marque"));
                b.setType(rs.getString("type"));
                b.setSerial_nb(rs.getString("serial_nb"));
                b.setDate(rs.getDate("date"));
                b.setObservations(rs.getString("observations"));
                b.setId_moteur(rs.getInt("id_moteur"));
               
                
                elmntMoteur.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return elmntMoteur;
    }

   public ElmntMoteur READ(int id_elmnt)
    {
        ElmntMoteur b = new ElmntMoteur();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM elmntmoteur WHERE id_elmnt = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_elmnt);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setId_elmnt(rs.getInt("id_elmnt"));
                b.setDesignation(rs.getString("designation"));
                b.setId_Const_Marque(rs.getInt("id_const_marque"));
                b.setType(rs.getString("type"));
                b.setSerial_nb(rs.getString("serial_nb"));
                b.setDate(rs.getDate("date"));
                b.setObservations(rs.getString("observations"));
                b.setId_moteur(rs.getInt("id_moteur"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(ElmntMoteur elmntMoteur)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE elmntmoteur SET id_elmnt=? ,designation=? ,id_const_marque=? ,type=? ,serial_nb=? ,date=? ,observations=? ,id_moteur=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, elmntMoteur.getId_elmnt());
            ps.setString(2,elmntMoteur.getDesignation());
            ps.setInt(3,elmntMoteur.getId_Const_Marque());
            ps.setString(4,elmntMoteur.getType());
            ps.setString(5,elmntMoteur.getSerial_nb());
            ps.setDate(6, (Date) elmntMoteur.getDate());
            ps.setString(7, elmntMoteur.getObservations());
            ps.setInt(8, elmntMoteur.getId_moteur());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_elmnt)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE elmntmoteur WHERE id_elmnt=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_elmnt);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}

