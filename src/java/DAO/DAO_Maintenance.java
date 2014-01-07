/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Maintenance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Valentin
 */
public class DAO_Maintenance {

    
    public int CREATE(Maintenance maintenance) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into maintenance (id_Maintenance,designation,duree_presta,description,nHeure,nDuree,nHeureBut,nDureeBut) values (?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, maintenance.getId_Maintenance());
            ps.setString(2, maintenance.getDesignation());
            ps.setFloat(3,maintenance.getDuree_presta());
            ps.setString(4, maintenance.getDescritpion());
            ps.setFloat(5, maintenance.getnHeure());
            ps.setFloat(6, maintenance.getnDuree());
            ps.setFloat(7, maintenance.getnHeureBut());
            ps.setFloat(8, maintenance.getnDureeBut());

            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Maintenance> GET_ALL()
    {
        ArrayList<Maintenance> maintenance = new ArrayList<Maintenance>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM maintenance";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Maintenance b = new Maintenance();
                b.setId_Maintenance(rs.getInt("id_Maintenance"));
                b.setDesignation(rs.getString("designation"));
                b.setDuree_presta(rs.getFloat("duree_presta"));
                b.setDescritpion(rs.getString("description"));
                b.setnHeure(rs.getFloat("nHeure"));
                b.setnDuree(rs.getFloat("nDuree"));
                b.setnHeureBut(rs.getFloat("nHeureBut"));
                b.setnDureeBut(rs.getFloat("nDureeBut"));
                
                maintenance.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return maintenance;
    }

   public Maintenance READ(int id_Maintenance)
    {
        Maintenance b = new Maintenance();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM maintenance WHERE id_Maintenance= ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_Maintenance);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setId_Maintenance(rs.getInt("id_Maintenance"));
                b.setDesignation(rs.getString("designation"));
                b.setDuree_presta(rs.getFloat("duree_presta"));
                b.setDescritpion(rs.getString("description"));
                b.setnHeure(rs.getFloat("nHeure"));
                b.setnDuree(rs.getFloat("nDuree"));
                b.setnHeureBut(rs.getFloat("nHeureBut"));
                b.setnDureeBut(rs.getFloat("nDureeBut"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(Maintenance maintenance)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE maintenance SET id_Maintenance=? ,designation=? ,duree_presta=? ,description=? ,nHeure=? ,nDuree=? ,nHeureBut=? ,nDureeBut=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, maintenance.getId_Maintenance());
            ps.setString(2, maintenance.getDesignation());
            ps.setFloat(3,maintenance.getDuree_presta());
            ps.setString(4, maintenance.getDescritpion());
            ps.setFloat(5, maintenance.getnHeure());
            ps.setFloat(6, maintenance.getnDuree());
            ps.setFloat(7, maintenance.getnHeureBut());
            ps.setFloat(8, maintenance.getnDureeBut());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_Maintenance)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE maintenance WHERE id_Maintenance=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_Maintenance);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}


