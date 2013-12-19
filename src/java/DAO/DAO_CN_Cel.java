/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.CN_Cel;
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
public class DAO_CN_Cel {
    

    
    public int CREATE(CN_Cel cn_cel) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into cn_cel (id_CN_Cel,immat,date_ajt,reference,SB,objet,applicabilite,rep_i_m,rep_he,rep_cy,exe_date,exe_he,exe_cy,bAnnul) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, cn_cel.getId_Cn_Cel());
            ps.setString(2,cn_cel.getImmat());
            ps.setDate(3, (Date) cn_cel.getDate_ajt());
            ps.setString(4,cn_cel.getReference());
            ps.setString(5,cn_cel.getSB());
            ps.setString(6,cn_cel.getObjet());
            ps.setString(7,cn_cel.getApplicabilite());
            ps.setFloat(8, cn_cel.getRep_i_m());
            ps.setFloat(9, cn_cel.getRep_he());
            ps.setFloat(10, cn_cel.getRep_cy());
            ps.setDate(11, (Date) cn_cel.getExe_date());
            ps.setFloat(12, cn_cel.getExe_he());
            ps.setFloat(13, cn_cel.getExe_cy());
            ps.setBoolean(14, cn_cel.isbAnnul());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<CN_Cel> GET_ALL()
    {
        ArrayList<CN_Cel> cn_cel = new ArrayList<CN_Cel>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM cn_cel WHERE id_CN_Cel = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                CN_Cel b = new CN_Cel();
                b.setId_Cn_Cel(rs.getInt("id_CN_Cel"));
                b.setImmat(rs.getString("immat"));
                b.setDate_ajt(rs.getDate("date_ajt"));
                b.setReference(rs.getString("reference"));
                b.setSB(rs.getString("SB"));                
                b.setObjet(rs.getString("objet"));
                b.setApplicabilite(rs.getString("applicabilite"));
                b.setRep_i_m(rs.getFloat("rep_i_m"));
                b.setRep_he(rs.getFloat("rep_he"));
                b.setRep_cy(rs.getFloat("rep_cy"));
                b.setExe_date(rs.getDate("exe_date"));
                b.setExe_he(rs.getFloat("exe_he"));
                b.setExe_cy(rs.getFloat("exe_cy"));
                b.setbAnnul(rs.getBoolean("bAnnuel"));
                
                cn_cel.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return cn_cel;
    }

    public CN_Cel READ(int id_CN_Cel)
    {
        CN_Cel cn_cel = new CN_Cel();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM cn_cel WHERE id_CN_Cel = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_CN_Cel);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                cn_cel.setId_Cn_Cel(rs.getInt("id_CN_Cel"));
                cn_cel.setImmat(rs.getString("immat"));
                cn_cel.setDate_ajt(rs.getDate("date_ajt"));
                cn_cel.setReference(rs.getString("reference"));
                cn_cel.setSB(rs.getString("SB"));                
                cn_cel.setObjet(rs.getString("objet"));
                cn_cel.setApplicabilite(rs.getString("applicabilite"));
                cn_cel.setRep_i_m(rs.getFloat("rep_i_m"));
                cn_cel.setRep_he(rs.getFloat("rep_he"));
                cn_cel.setRep_cy(rs.getFloat("rep_cy"));
                cn_cel.setExe_date(rs.getDate("exe_date"));
                cn_cel.setExe_he(rs.getFloat("exe_he"));
                cn_cel.setExe_cy(rs.getFloat("exe_cy"));
                cn_cel.setbAnnul(rs.getBoolean("bAnnuel"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return cn_cel;
    }
    
    public int UPDATE(CN_Cel cn_cel)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE cn_cel SET id_CN_Cel=?, immat=? ,date_ajt=? ,reference=? ,SB=? ,objet=? ,applicabilite? ,rep_i_m=? ,rep_he=? ,rep_cy=? ,exe_date=? ,exe_he=? ,exe_cy=? ,bAnnul=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, cn_cel.getId_Cn_Cel());
            ps.setString(2,cn_cel.getImmat());
            ps.setDate(3, (Date) cn_cel.getDate_ajt());
            ps.setString(4,cn_cel.getReference());
            ps.setString(5,cn_cel.getSB());
            ps.setString(6,cn_cel.getObjet());
            ps.setString(7,cn_cel.getApplicabilite());
            ps.setFloat(8, cn_cel.getRep_i_m());
            ps.setFloat(9, cn_cel.getRep_he());
            ps.setFloat(10, cn_cel.getRep_cy());
            ps.setDate(11, (Date) cn_cel.getExe_date());
            ps.setFloat(12, cn_cel.getExe_he());
            ps.setFloat(13, cn_cel.getExe_cy());
            ps.setBoolean(14, cn_cel.isbAnnul());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_CN_Cel)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE cn_cel WHERE id_CN_Cel=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_CN_Cel);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}

    