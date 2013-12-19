/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.CN_Equipement;
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
public class DAO_CN_Equipement {
    

    

    
    public int CREATE(CN_Equipement cn_equip) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into cn_equipement (id_CN_Equipement,immat,date_ajt,reference,SB,objet,applicabilite,rep_i_m,rep_he,rep_cy,exe_date,exe_he,exe_cy,bAnnul) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, cn_equip.getId_CN_Equipement());
            ps.setString(2,cn_equip.getImmat());
            ps.setDate(3, (Date) cn_equip.getDate_ajt());
            ps.setString(4,cn_equip.getReference());
            ps.setString(5,cn_equip.getSB());
            ps.setString(6,cn_equip.getObjet());
            ps.setString(7,cn_equip.getApplicabilite());
            ps.setFloat(8, cn_equip.getRep_i_m());
            ps.setFloat(9, cn_equip.getRep_he());
            ps.setFloat(10, cn_equip.getRep_cy());
            ps.setDate(11, (Date) cn_equip.getExe_date());
            ps.setFloat(12, cn_equip.getExe_he());
            ps.setFloat(13, cn_equip.getExe_cy());
            ps.setBoolean(14, cn_equip.isbAnnul());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<CN_Equipement> GET_ALL()
    {
        ArrayList<CN_Equipement> cn_equip = new ArrayList<CN_Equipement>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM cn_equipement WHERE id_CN_Equipement = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                CN_Equipement b = new CN_Equipement();
                b.setId_CN_Equipement(rs.getInt("id_CN_Equipement"));
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
                
                cn_equip.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return cn_equip;
    }

    public CN_Equipement READ(int id_CN_Equipement)
    {
        CN_Equipement id_cn_equipement = new CN_Equipement();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM cn_equipement WHERE id_CN_Equipement = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_CN_Equipement);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                id_cn_equipement.setId_CN_Equipement(rs.getInt("id_CN_Equipement"));
                id_cn_equipement.setImmat(rs.getString("immat"));
                id_cn_equipement.setDate_ajt(rs.getDate("date_ajt"));
                id_cn_equipement.setReference(rs.getString("reference"));
                id_cn_equipement.setSB(rs.getString("SB"));                
                id_cn_equipement.setObjet(rs.getString("objet"));
                id_cn_equipement.setApplicabilite(rs.getString("applicabilite"));
                id_cn_equipement.setRep_i_m(rs.getFloat("rep_i_m"));
                id_cn_equipement.setRep_he(rs.getFloat("rep_he"));
                id_cn_equipement.setRep_cy(rs.getFloat("rep_cy"));
                id_cn_equipement.setExe_date(rs.getDate("exe_date"));
                id_cn_equipement.setExe_he(rs.getFloat("exe_he"));
                id_cn_equipement.setExe_cy(rs.getFloat("exe_cy"));
                id_cn_equipement.setbAnnul(rs.getBoolean("bAnnuel"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return id_cn_equipement;
    }
    
    public int UPDATE(CN_Equipement cn_equip)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE cn_equipement SET id_CN_Equipement=?, immat=? ,date_ajt=? ,reference=? ,SB=? ,objet=? ,applicabilite? ,rep_i_m=? ,rep_he=? ,rep_cy=? ,exe_date=? ,exe_he=? ,exe_cy=? ,bAnnul=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, cn_equip.getId_CN_Equipement());
            ps.setString(2,cn_equip.getImmat());
            ps.setDate(3, (Date) cn_equip.getDate_ajt());
            ps.setString(4,cn_equip.getReference());
            ps.setString(5,cn_equip.getSB());
            ps.setString(6,cn_equip.getObjet());
            ps.setString(7,cn_equip.getApplicabilite());
            ps.setFloat(8, cn_equip.getRep_i_m());
            ps.setFloat(9, cn_equip.getRep_he());
            ps.setFloat(10, cn_equip.getRep_cy());
            ps.setDate(11, (Date) cn_equip.getExe_date());
            ps.setFloat(12, cn_equip.getExe_he());
            ps.setFloat(13, cn_equip.getExe_cy());
            ps.setBoolean(14, cn_equip.isbAnnul());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_CN_Equipement)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE cn_equipement WHERE id_CN_Equipement=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_CN_Equipement);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}

    

