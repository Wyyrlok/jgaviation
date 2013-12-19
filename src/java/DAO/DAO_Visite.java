/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
            String sql="SELECT * FROM visite WHERE id_Visite = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Visite b = new Visite();
                b.setId_Visite(rs.getInt("id_visite"));
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

    public Workorder READ(int id_wo)
    {
        Workorder workorder = new Workorder();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM workorder WHERE id_wo = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_wo);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                workorder.setId_wo(rs.getInt("id_wo"));
                workorder.setImmat(rs.getString("immat"));
                workorder.setId_proprio(rs.getInt("id_proprio"));
                workorder.setDate_in(rs.getDate("date_in"));
                workorder.setDate_out(rs.getDate("date_out"));
                workorder.setNum_wo(rs.getString("num_wo"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return workorder;
    }
    
    public int UPDATE(Workorder workorder)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE workorder SET id_wo=?, immat=? ,id_proprio=? ,date_in=? ,date_out=? ,num_wo=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1,workorder.getId_wo());
            ps.setString(2,workorder.getImmat());
            ps.setInt(3,workorder.getId_proprio());
            ps.setDate(4, (Date) workorder.getDate_in());
            ps.setDate(5, (Date) workorder.getDate_out());
            ps.setString(6,workorder.getNum_wo());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_wo)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE workorder WHERE id_wo=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_wo);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}

