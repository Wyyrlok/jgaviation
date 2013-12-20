/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Compensation;
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
       
    
    public int CREATE(Compensation compensation) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into compensation (id_compensation,num_rev,date,ecartsN,ecartsE,ecartsS,ecartsW,ecarts45,ecarts135,ecarts225,ecarts315,id_moteur) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, compensation.getId_compensation());
            ps.setInt(2,compensation.getNum_rev());
            ps.setDate(3, (Date) compensation.getDate());
            ps.setFloat(4,compensation.getEcartsN());
            ps.setFloat(5,compensation.getEcartsE());
            ps.setFloat(6,compensation.getEcartsS());
            ps.setFloat(7,compensation.getEcartsW());
            ps.setFloat(8, compensation.getEcarts45());
            ps.setFloat(9, compensation.getEcarts135());
            ps.setFloat(10, compensation.getEcarts225());
            ps.setFloat(11, compensation.getEcarts315());
            ps.setInt(12, compensation.getId_moteur());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Compensation> GET_ALL()
    {
        ArrayList<Compensation> compensation = new ArrayList<Compensation>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM compensation WHERE id_compensation = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Compensation b = new Compensation();
                b.setId_compensation(rs.getInt("id_compensation"));
                b.setNum_rev(rs.getInt("num_rev"));
                b.setDate(rs.getDate("date"));
                b.setEcartsN(rs.getFloat("ecrartsN"));
                b.setEcartsE(rs.getFloat("ecrartsE"));                
                b.setEcartsS(rs.getFloat("ecrartsS"));
                b.setEcartsW(rs.getFloat("ecartsW"));
                b.setEcarts45(rs.getFloat("ecarts45"));
                b.setEcarts135(rs.getFloat("ecarts135"));
                b.setEcarts225(rs.getFloat("ecarts225"));
                b.setEcarts315(rs.getFloat("ecarts315"));
                b.setId_moteur(rs.getInt("id_moteur"));
                
                compensation.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return compensation;
    }

   public Compensation READ(int id_compensation)
    {
        Compensation b = new Compensation();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM compensation WHERE id_compensation = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_compensation);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setId_compensation(rs.getInt("id_compensation"));
                b.setNum_rev(rs.getInt("num_rev"));
                b.setDate(rs.getDate("date"));
                b.setEcartsN(rs.getFloat("ecrartsN"));
                b.setEcartsE(rs.getFloat("ecrartsE"));                
                b.setEcartsS(rs.getFloat("ecrartsS"));
                b.setEcartsW(rs.getFloat("ecartsW"));
                b.setEcarts45(rs.getFloat("ecarts45"));
                b.setEcarts135(rs.getFloat("ecarts135"));
                b.setEcarts225(rs.getFloat("ecarts225"));
                b.setEcarts315(rs.getFloat("ecarts315"));
                b.setId_moteur(rs.getInt("id_moteur"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(Compensation compensation)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE cn_moteur SET id_compensation=? ,num_rev=? ,date=? ,ecartsN=? ,ecartsE=? ,ecartsS=? ,ecartsW=? ,ecarts45=? ,ecarts135=? ,ecarts225=? ,ecarts315=? ,id_moteur=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, compensation.getId_compensation());
            ps.setInt(2,compensation.getNum_rev());
            ps.setDate(3, (Date) compensation.getDate());
            ps.setFloat(4,compensation.getEcartsN());
            ps.setFloat(5,compensation.getEcartsE());
            ps.setFloat(6,compensation.getEcartsS());
            ps.setFloat(7,compensation.getEcartsW());
            ps.setFloat(8, compensation.getEcarts45());
            ps.setFloat(9, compensation.getEcarts135());
            ps.setFloat(10, compensation.getEcarts225());
            ps.setFloat(11, compensation.getEcarts315());
            ps.setInt(12, compensation.getId_moteur());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_compensation)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE compensation WHERE id_compensation=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_compensation);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}

