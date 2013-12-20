/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Cycle;
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
public class DAO_Cycle {
       
    
    public int CREATE(Cycle cycle) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into cycle (id_Cycle,nom_equipement,immat,bmodeFacteur,nFacteur) values (?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, cycle.getId_Cycle());
            ps.setString(2,cycle.getNom_Equipement());
            ps.setString(3,cycle.getImmat());
            ps.setInt(4,cycle.getbModeFacteur());
            ps.setFloat(5,cycle.getnFacteur());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Cycle> GET_ALL()
    {
        ArrayList<Cycle> cycle = new ArrayList<Cycle>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM cycle WHERE id_Cycle = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Cycle b = new Cycle();
                b.setId_Cycle(rs.getInt("id_Cycle"));
                b.setNom_Equipement(rs.getString("nom_equipement"));
                b.setImmat(rs.getString("immat"));
                b.setbModeFacteur(rs.getInt("bmodeFacteur"));
                b.setnFacteur(rs.getFloat("nFacteur"));                
               
                
                cycle.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return cycle;
    }

   public Cycle READ(int id_Cycle)
    {
        Cycle b = new Cycle();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM cycle WHERE id_Cycle = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_Cycle);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setId_Cycle(rs.getInt("id_Cycle"));
                b.setNom_Equipement(rs.getString("nom_equipement"));
                b.setImmat(rs.getString("immat"));
                b.setbModeFacteur(rs.getInt("bmodeFacteur"));
                b.setnFacteur(rs.getFloat("nFacteur"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(Cycle cycle)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE cycle SET id_Cycle=? ,nom_equipement=? ,immat=? ,bmodeFacteur=? ,nFacteur=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, cycle.getId_Cycle());
            ps.setString(2,cycle.getNom_Equipement());
            ps.setString(3,cycle.getImmat());
            ps.setInt(4,cycle.getbModeFacteur());
            ps.setFloat(5,cycle.getnFacteur());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_Cycle)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE cycle WHERE id_Cycle=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_Cycle);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}

