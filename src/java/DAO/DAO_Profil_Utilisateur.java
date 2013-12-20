/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Profil_Utilisateur;
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
public class DAO_Profil_Utilisateur {
    
    public int CREATE(Profil_Utilisateur profil) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into profil_utilisateur (id_profil,nom_profil) values (?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, profil.getId_profil());
            ps.setString(2, profil.getNom_profil());
        

            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Profil_Utilisateur> GET_ALL()
    {
        ArrayList<Profil_Utilisateur> profil = new ArrayList<Profil_Utilisateur>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM profil_utilisateur WHERE id_profil = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Profil_Utilisateur b = new Profil_Utilisateur();
                b.setId_profil(rs.getInt("id_profil"));
                b.setNom_profil(rs.getString("nom_profil"));
                
                profil.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return profil;
    }

   public Profil_Utilisateur READ(int profil)
    {
        Profil_Utilisateur b = new Profil_Utilisateur();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM profil_utilisateur WHERE id_profil= ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,profil);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setId_profil(rs.getInt("id_profil"));
                b.setNom_profil(rs.getString("nom_profil"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(Profil_Utilisateur profil)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE profil_utilisateur SET id_profil=? ,nom_profil=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, profil.getId_profil());
            ps.setString(2, profil.getNom_profil());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_profil)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE profil_utilisateur WHERE id_profil=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_profil);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}


