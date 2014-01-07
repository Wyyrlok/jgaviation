/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DBConnect;
import Metier.Visite;
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
public class DAO_Visite {
    
    public int CREATE(Visite visite) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into visite (id_Visite,immat,saisie_date,saisie_heure,tol_date,tol_heure,der_date,der_heure,id_maintenance) values (?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setInt(1,visite.getId_Visite());
            ps.setString(2,visite.getImmat());
            ps.setDate(3,(Date)visite.getSaisie_date());
            ps.setFloat(4,visite.getSaisie_heure());
            ps.setDate(5,(Date)visite.getTol_date());
            ps.setFloat(6,visite.getTol_heure());
            ps.setDate(7,(Date)visite.getDer_date());
            ps.setFloat(8,visite.getDer_heure());
            ps.setInt(9,visite.getId_maintenance());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Visite> GET_ALL()
    {
        ArrayList<Visite> visite = new ArrayList<Visite>();
        
        Connection con = null;
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM visite";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Visite b = new Visite();
                b.setId_Visite(rs.getInt("id_Visite"));
                b.setImmat(rs.getString("immat"));
                b.setSaisie_date(rs.getDate("saisie_date"));
                b.setSaisie_heure(rs.getFloat("saisie_heure"));
                b.setTol_date(rs.getDate("tol_date"));
                b.setTol_heure(rs.getFloat("tol_heure"));
                b.setDer_date(rs.getDate("der_date"));
                
                visite.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return visite;
    }

    public Visite READ(int id_Visite)
    {
        Visite visite = new Visite();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM visite WHERE id_Visite = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_Visite);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                visite.setId_Visite(rs.getInt("id_Visite"));
                visite.setImmat(rs.getString("immat"));
                visite.setSaisie_date(rs.getDate("saisie_date"));
                visite.setSaisie_heure(rs.getFloat("saisie_heure"));
                visite.setTol_date(rs.getDate("tol_date"));
                visite.setTol_heure(rs.getFloat("tol_heure"));
                visite.setDer_date(rs.getDate("der_date"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return visite;
    }
    
    public int UPDATE(Visite visite)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE visite SET id_Visite=?, immat=? ,saisie_date=? ,saisie_heure=? ,tol_date=? ,tol_heure=? ,der_date=? ,der_heure=? ,id_maintenance=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1,visite.getId_Visite());
            ps.setString(2,visite.getImmat());
            ps.setDate(3,(Date)visite.getSaisie_date());
            ps.setFloat(4,visite.getSaisie_heure());
            ps.setDate(5,(Date)visite.getTol_date());
            ps.setFloat(6,visite.getTol_heure());
            ps.setDate(7,(Date)visite.getDer_date());
            ps.setFloat(8,visite.getDer_heure());
            ps.setInt(9,visite.getId_maintenance());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_Visite)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE visite WHERE id_Visite=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_Visite);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
}