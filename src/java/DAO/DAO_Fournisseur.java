/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Fournisseur;
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
public class DAO_Fournisseur {
    

    public int CREATE(Fournisseur fournisseur) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into fournisseur (nom_fourn) values (?)";
            ps=con.prepareStatement(sql);
            
            ps.setString(1,fournisseur.getNom_fourn());

            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Fournisseur> GET_ALL()
    {
        ArrayList<Fournisseur> fournisseur = new ArrayList<Fournisseur>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM fournisseur";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Fournisseur b = new Fournisseur();
                b.setId_fournisseur(rs.getInt("id_fournisseur"));
                b.setNom_fourn(rs.getString("nom_fourn"));
                
                fournisseur.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return fournisseur;
    }

   public Fournisseur READ(int id_fournisseur)
    {
        Fournisseur b = new Fournisseur();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM fournisseur WHERE id_fournisseur = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_fournisseur);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setId_fournisseur(rs.getInt("id_fournisseur"));
                b.setNom_fourn(rs.getString("nom_fourn"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(Fournisseur fournisseur)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE fournisseur SET id_fournisseur=? ,nom_fourn=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, fournisseur.getId_fournisseur());
            ps.setString(2,fournisseur.getNom_fourn());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_fournisseur)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE fournisseur WHERE id_fournisseur=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_fournisseur);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}


