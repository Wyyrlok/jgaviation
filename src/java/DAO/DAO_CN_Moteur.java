/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.CN_Moteur;
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
public class DAO_CN_Moteur {
   

    
    public int CREATE(CN_Moteur cn_moteur) throws Exception
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
            
            ps.setInt(1, cn_moteur.getId_CN_Moteur());
            ps.setString(2,cn_moteur.getId_moteur());
            ps.setDate(3, (Date) cn_moteur.getDate_ajt());
            ps.setString(4,cn_moteur.getReference());
            ps.setString(5,cn_moteur.getSB());
            ps.setString(6,cn_moteur.getObjet());
            ps.setString(7,cn_moteur.getApplicabilite());
            ps.setFloat(8, cn_moteur.getRep_i_m());
            ps.setFloat(9, cn_moteur.getRep_he());
            ps.setFloat(10, cn_moteur.getRep_cy());
            ps.setDate(11, (Date) cn_moteur.getExe_date());
            ps.setFloat(12, cn_moteur.getExe_he());
            ps.setFloat(13, cn_moteur.getExe_cy());
            ps.setBoolean(14, cn_moteur.isbAnnul());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<CN_Moteur> GET_ALL()
    {
        ArrayList<CN_Moteur> cn_moteur = new ArrayList<CN_Moteur>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM cn_moteur WHERE id_CN_Moteur = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                CN_Moteur b = new CN_Moteur();
                b.setId_CN_Moteur(rs.getInt("id_CN_Moteur"));
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
                
                cn_moteur.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return cn_moteur;
    }

   public CN_Moteur READ(int id_CN_Moteur)
    {
        CN_Moteur cn_moteur = new CN_Moteur();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM cn_moteur WHERE id_CN_Moteur = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_CN_Moteur);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                cn_moteur.setId_CN_Moteur(rs.getInt("id_CN_Moteur"));
                cn_moteur.setId_moteur(rs.getString("id_moteur"));
                cn_moteur.setDate_ajt(rs.getDate("date_ajt"));
                cn_moteur.setReference(rs.getString("reference"));
                cn_moteur.setSB(rs.getString("SB"));                
                cn_moteur.setObjet(rs.getString("objet"));
                cn_moteur.setApplicabilite(rs.getString("applicabilite"));
                cn_moteur.setRep_i_m(rs.getFloat("rep_i_m"));
                cn_moteur.setRep_he(rs.getFloat("rep_he"));
                cn_moteur.setRep_cy(rs.getFloat("rep_cy"));
                cn_moteur.setExe_date(rs.getDate("exe_date"));
                cn_moteur.setExe_he(rs.getFloat("exe_he"));
                cn_moteur.setExe_cy(rs.getFloat("exe_cy"));
                cn_moteur.setbAnnul(rs.getBoolean("bAnnuel"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return cn_moteur;
    }
    
    public int UPDATE(CN_Moteur cn_moteur)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE cn_moteur SET id_CN_Moteur=?, id_moteur=? ,date_ajt=? ,reference=? ,SB=? ,objet=? ,applicabilite? ,rep_i_m=? ,rep_he=? ,rep_cy=? ,exe_date=? ,exe_he=? ,exe_cy=? ,bAnnul=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1, cn_moteur.getId_CN_Moteur());
            ps.setString(2,cn_moteur.getId_moteur());
            ps.setDate(3, (Date) cn_moteur.getDate_ajt());
            ps.setString(4,cn_moteur.getReference());
            ps.setString(5,cn_moteur.getSB());
            ps.setString(6,cn_moteur.getObjet());
            ps.setString(7,cn_moteur.getApplicabilite());
            ps.setFloat(8, cn_moteur.getRep_i_m());
            ps.setFloat(9, cn_moteur.getRep_he());
            ps.setFloat(10, cn_moteur.getRep_cy());
            ps.setDate(11, (Date) cn_moteur.getExe_date());
            ps.setFloat(12, cn_moteur.getExe_he());
            ps.setFloat(13, cn_moteur.getExe_cy());
            ps.setBoolean(14, cn_moteur.isbAnnul());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_CN_Moteur)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE cn_moteur WHERE id_CN_Moteur=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_CN_Moteur);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}

