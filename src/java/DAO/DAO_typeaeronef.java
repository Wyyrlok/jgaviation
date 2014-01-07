/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.TypeAeronef;
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
public class DAO_typeaeronef {
    
    public int CREATE(TypeAeronef typeaeronef) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into typeaeronef (id_type,nom_type,nb_moteur) values (?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setInt(1,typeaeronef.getId_type());
            ps.setString(2,typeaeronef.getNom_type());
            ps.setInt(3,typeaeronef.getNb_moteur());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<TypeAeronef> GET_ALL()
    {
        ArrayList<TypeAeronef> typeaeronef = new ArrayList<TypeAeronef>();
        
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
                TypeAeronef b = new TypeAeronef();
                b.setId_type(rs.getInt("id_type"));
                b.setNom_type(rs.getString("nom_type"));
                b.setNb_moteur(rs.getInt("nb_moteur"));
                
                typeaeronef.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return typeaeronef;
    }

    public TypeAeronef READ(int id_type)
    {
        TypeAeronef typeaeronef = new TypeAeronef();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM typeaeronef WHERE id_type = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_type);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                
                typeaeronef.setId_type(rs.getInt("id_type"));
                typeaeronef.setNom_type(rs.getString("nom_type"));
                typeaeronef.setNb_moteur(rs.getInt("nb_moteur"));
                
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return typeaeronef;
    }
    
    public int UPDATE(TypeAeronef typeaeronef)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE typeaeronef SET id_type=?, nom_type=? ,nb_moteur=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1,typeaeronef.getId_type());
            ps.setString(2,typeaeronef.getNom_type());
            ps.setInt(3,typeaeronef.getNb_moteur());
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_type)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE typeaeronef WHERE id_type=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_type);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}
