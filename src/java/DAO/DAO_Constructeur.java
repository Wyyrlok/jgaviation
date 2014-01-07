/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Constructeur;
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
public class DAO_Constructeur {

    
    public int CREATE(Constructeur constructeur) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into constructeur (nom_const) values (?)";
            ps=con.prepareStatement(sql);

            ps.setString(1,constructeur.getNom_const());
 
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Constructeur> GET_ALL()
    {
        ArrayList<Constructeur> constructeur = new ArrayList<Constructeur>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM constructeur WHERE id_const = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Constructeur b = new Constructeur();
                b.setId_const(rs.getInt("id_const"));
                b.setNom_const(rs.getString("id_const"));
                
                constructeur.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return constructeur;
    }

    public Constructeur READ(int id_const)
    {
        Constructeur constructeur = new Constructeur();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM constructeur WHERE id_const = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_const);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                constructeur.setId_const(rs.getInt("id_const"));
                constructeur.setNom_const(rs.getString("id_const"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return constructeur;
    }
    
    public int UPDATE(Constructeur constructeur)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE constructeur SET id_const=?, nom_const=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1,constructeur.getId_const());
            ps.setString(2,constructeur.getNom_const());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_const)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE constructeur WHERE id_const=?, nom_const=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_const);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}
