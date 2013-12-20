/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.InstructWO;
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
public class DAO_InstructWo {
 
    public int CREATE(InstructWO instructWO) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into instructwo (id_InstructWO,pos,designation,id_wo) values (?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, instructWO.getId_instructWO());
            ps.setInt(2, instructWO.getPos());
            ps.setString(3,instructWO.getDesignation());
            ps.setInt(4, instructWO.getId_WO());

            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<InstructWO> GET_ALL()
    {
        ArrayList<InstructWO> instructWO = new ArrayList<InstructWO>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM instructwo WHERE id_InstructWO = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                InstructWO b = new InstructWO();
                b.setId_instructWO(rs.getInt("id_InstructWO"));
                b.setPos(rs.getInt("pos"));
                b.setDesignation(rs.getString("designation"));
                b.setId_WO(rs.getInt("id_wo"));
                
                instructWO.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return instructWO;
    }

   public InstructWO READ(int id_InstructWO)
    {
        InstructWO b = new InstructWO();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM instructWO WHERE id_InstructWO= ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_InstructWO);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                 b.setId_instructWO(rs.getInt("id_InstructWO"));
                b.setPos(rs.getInt("pos"));
                b.setDesignation(rs.getString("designation"));
                b.setId_WO(rs.getInt("id_wo"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(InstructWO instructWO)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE instructwo SET id_InstructWO=? ,pos=?, designation=?, id_wo=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, instructWO.getId_instructWO());
            ps.setInt(2, instructWO.getPos());
            ps.setString(3,instructWO.getDesignation());
            ps.setInt(4, instructWO.getId_WO());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_InstructWO)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE instructWO WHERE id_InstructWO=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_InstructWO);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}


