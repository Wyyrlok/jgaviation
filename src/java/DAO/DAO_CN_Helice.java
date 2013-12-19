/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.CN_Helice;
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
public class DAO_CN_Helice {
    

    

    
    public int CREATE(CN_Helice cn_helice) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into cn_cel (id_CN_Helice,id_moteur,date_ajt,reference,SB,objet,applicabilite,rep_i_m,rep_he,rep_cy,exe_date,exe_he,exe_cy,bAnnul) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, cn_helice.getId_CN_Helice());
            ps.setString(2,cn_helice.getId_moteur());
            ps.setDate(3, (Date) cn_helice.getDate_ajt());
            ps.setString(4,cn_helice.getReference());
            ps.setString(5,cn_helice.getSB());
            ps.setString(6,cn_helice.getObjet());
            ps.setString(7,cn_helice.getApplicabilite());
            ps.setFloat(8, cn_helice.getRep_i_m());
            ps.setFloat(9, cn_helice.getRep_he());
            ps.setFloat(10, cn_helice.getRep_cy());
            ps.setDate(11, (Date) cn_helice.getExe_date());
            ps.setFloat(12, cn_helice.getExe_he());
            ps.setFloat(13, cn_helice.getExe_cy());
            ps.setBoolean(14, cn_helice.isbAnnul());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<CN_Helice> GET_ALL()
    {
        ArrayList<CN_Helice> cn_helice = new ArrayList<CN_Helice>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM cn_helice WHERE id_CN_Helice = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                CN_Helice b = new CN_Helice();
                b.setId_CN_Helice(rs.getInt("id_CN_Helice"));
                b.setId_moteur(rs.getString("id_moteur"));
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
                
                cn_helice.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return cn_helice;
    }

    public CN_Helice READ(int id_CN_Helice)
    {
        CN_Helice cn_helice = new CN_Helice();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM cn_helice WHERE id_CN_Helice = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_CN_Helice);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                cn_helice.setId_CN_Helice(rs.getInt("id_CN_Helice"));
                cn_helice.setId_moteur(rs.getString("id_moteur"));
                cn_helice.setDate_ajt(rs.getDate("date_ajt"));
                cn_helice.setReference(rs.getString("reference"));
                cn_helice.setSB(rs.getString("SB"));                
                cn_helice.setObjet(rs.getString("objet"));
                cn_helice.setApplicabilite(rs.getString("applicabilite"));
                cn_helice.setRep_i_m(rs.getFloat("rep_i_m"));
                cn_helice.setRep_he(rs.getFloat("rep_he"));
                cn_helice.setRep_cy(rs.getFloat("rep_cy"));
                cn_helice.setExe_date(rs.getDate("exe_date"));
                cn_helice.setExe_he(rs.getFloat("exe_he"));
                cn_helice.setExe_cy(rs.getFloat("exe_cy"));
                cn_helice.setbAnnul(rs.getBoolean("bAnnuel"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return cn_helice;
    }
    
    public int UPDATE(CN_Helice cn_helice)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE cn_helice SET id_CN_Helice=?, id_moteur=? ,date_ajt=? ,reference=? ,SB=? ,objet=? ,applicabilite? ,rep_i_m=? ,rep_he=? ,rep_cy=? ,exe_date=? ,exe_he=? ,exe_cy=? ,bAnnul=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, cn_helice.getId_CN_Helice());
            ps.setString(2,cn_helice.getId_moteur());
            ps.setDate(3, (Date) cn_helice.getDate_ajt());
            ps.setString(4,cn_helice.getReference());
            ps.setString(5,cn_helice.getSB());
            ps.setString(6,cn_helice.getObjet());
            ps.setString(7,cn_helice.getApplicabilite());
            ps.setFloat(8, cn_helice.getRep_i_m());
            ps.setFloat(9, cn_helice.getRep_he());
            ps.setFloat(10, cn_helice.getRep_cy());
            ps.setDate(11, (Date) cn_helice.getExe_date());
            ps.setFloat(12, cn_helice.getExe_he());
            ps.setFloat(13, cn_helice.getExe_cy());
            ps.setBoolean(14, cn_helice.isbAnnul());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_CN_Helice)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE cn_helice WHERE id_CN_Helice=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_CN_Helice);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}

    
    

