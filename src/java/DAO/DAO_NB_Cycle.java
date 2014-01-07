/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Nb_Cycle;
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
    
    
    public int CREATE(Nb_Cycle nb_cycle) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into nbcycle (id_NbCycle,id_cycle,date_vol,nb_cycle) values (?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, nb_cycle.getId_NbCyle());
            ps.setInt(2, nb_cycle.getId_cycle());
            ps.setDate(3, (Date) nb_cycle.getDate_vol());
            ps.setInt(4, nb_cycle.getNb_cycle());

            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Nb_Cycle> GET_ALL()
    {
        ArrayList<Nb_Cycle> nb_cycle = new ArrayList<Nb_Cycle>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM moteuraeronef";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Nb_Cycle b = new Nb_Cycle();
                b.setId_NbCyle(rs.getInt("id_NbCycle"));
                b.setId_cycle(rs.getInt("id_cycle"));
                b.setDate_vol(rs.getDate("date_vol"));
                b.setNb_cycle(rs.getInt("nb_cycle"));
                
                nb_cycle.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return nb_cycle;
    }

   public Nb_Cycle READ(int nb_cycle)
    {
        Nb_Cycle b = new Nb_Cycle();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM nbcycle WHERE id_NbCycle= ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,nb_cycle);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setId_NbCyle(rs.getInt("id_NbCycle"));
                b.setId_cycle(rs.getInt("id_cycle"));
                b.setDate_vol(rs.getDate("date_vol"));
                b.setNb_cycle(rs.getInt("nb_cycle"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(Nb_Cycle nb_cycle)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE nbcycle SET id_NbCycle=? ,id_cycle=? ,date_vol=? ,nb_cycle=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, nb_cycle.getId_NbCyle());
            ps.setInt(2, nb_cycle.getId_cycle());
            ps.setDate(3, (Date) nb_cycle.getDate_vol());
            ps.setInt(4, nb_cycle.getNb_cycle());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_nbCycle)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE nbcycle WHERE id_NbCycle=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_nbCycle);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}


