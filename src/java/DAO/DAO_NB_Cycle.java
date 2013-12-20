/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.MoteurAeronef;
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
public class DAO_NB_Cycle {
    
    
    public int CREATE(MoteurAeronef moteuraeronef) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into moteuraeronef (id_moteur,position,date_inventaire,immat) values (?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, moteuraeronef.getId_Moteur());
            ps.setString(2, moteuraeronef.getPosition());
            ps.setDate(3, (Date) moteuraeronef.getDate_inventaire());
            ps.setString(4, moteuraeronef.getImmat());

            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<MoteurAeronef> GET_ALL()
    {
        ArrayList<MoteurAeronef> moteuraeronef = new ArrayList<MoteurAeronef>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM moteuraeronef WHERE id_moteur = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                MoteurAeronef b = new MoteurAeronef();
                b.setId_Moteur(rs.getInt("id_moteur"));
                b.setPosition(rs.getString("position"));
                b.setDate_inventaire(rs.getDate("date_inventaire"));
                b.setImmat(rs.getString("immat"));
                
                moteuraeronef.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return moteuraeronef;
    }

   public MoteurAeronef READ(int id_Maintenance)
    {
        MoteurAeronef b = new MoteurAeronef();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM moteuraeronef WHERE id_moteur= ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_Maintenance);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setId_Moteur(rs.getInt("id_moteur"));
                b.setPosition(rs.getString("position"));
                b.setDate_inventaire(rs.getDate("date_inventaire"));
                b.setImmat(rs.getString("immat"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(MoteurAeronef moteuraeronef)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE moteuraeronef SET id_moteur=? ,position=? ,date_inventaire=? ,immat=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, moteuraeronef.getId_Moteur());
            ps.setString(2, moteuraeronef.getPosition());
            ps.setDate(3, (Date) moteuraeronef.getDate_inventaire());
            ps.setString(4, moteuraeronef.getImmat());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_moteur)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE moteuraeronef WHERE id_moteur=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_moteur);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}


