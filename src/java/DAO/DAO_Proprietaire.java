/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Metier.Proprietaire;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public class DAO_Proprietaire 
{
    public int CREATE(Proprietaire proprietaire) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into proprietaire (civilite,nom,prenom,societe,adresse1,adresse2,ville,nip,tel1,tel2,email,email2,fax,portable,prive) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setString(1,proprietaire.getCivilite());
            ps.setString(2,proprietaire.getNom());
            ps.setString(3,proprietaire.getPrenom());
            ps.setString(4,proprietaire.getSociete());
            ps.setString(5,proprietaire.getAdresse1());
            ps.setString(6,proprietaire.getAdresse2());
            ps.setString(7,proprietaire.getVille());
            ps.setString(8,proprietaire.getNip());
            ps.setString(9,proprietaire.getTel1());
            ps.setString(10,proprietaire.getTel2());
            ps.setString(11,proprietaire.getEmail());
            ps.setString(12,proprietaire.getEmail2());
            ps.setString(13,proprietaire.getFax());
            ps.setString(14,proprietaire.getPortable());
            ps.setString(15,proprietaire.getPrive());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Proprietaire> GET_ALL()
    {
        ArrayList<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM proprietaire WHERE id_proprietaire = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Proprietaire b = new Proprietaire();
                b.setId_proprio(rs.getInt("id_proprio"));
                b.setCivilite(rs.getString("civilite"));
                b.setNom(rs.getString("nom"));
                b.setPrenom(rs.getString("prenom"));
                b.setSociete(rs.getString("societe"));                
                b.setAdresse1(rs.getString("adresse1"));
                b.setAdresse2(rs.getString("adresse2"));
                b.setVille(rs.getString("ville"));
                b.setNip(rs.getString("nip"));
                b.setTel1(rs.getString("tel1"));
                b.setTel2(rs.getString("tel2"));
                b.setEmail(rs.getString("email"));
                b.setEmail2(rs.getString("email2"));
                b.setFax(rs.getString("fax"));
                b.setPortable(rs.getString("portable"));
                b.setPrive(rs.getString("prive"));
                
                proprietaires.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return proprietaires;
    }

    public Proprietaire READ(int id_proprietaire)
    {
        Proprietaire proprietaire = new Proprietaire();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM proprietaire WHERE id_proprietaire = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_proprietaire);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                proprietaire.setId_proprio(rs.getInt("id_proprio"));
                proprietaire.setCivilite(rs.getString("civilite"));
                proprietaire.setNom(rs.getString("nom"));
                proprietaire.setPrenom(rs.getString("prenom"));
                proprietaire.setSociete(rs.getString("societe"));                
                proprietaire.setAdresse1(rs.getString("adresse1"));
                proprietaire.setAdresse2(rs.getString("adresse2"));
                proprietaire.setVille(rs.getString("ville"));
                proprietaire.setNip(rs.getString("nip"));
                proprietaire.setTel1(rs.getString("tel1"));
                proprietaire.setTel2(rs.getString("tel2"));
                proprietaire.setEmail(rs.getString("email"));
                proprietaire.setEmail2(rs.getString("email2"));
                proprietaire.setFax(rs.getString("fax"));
                proprietaire.setPortable(rs.getString("portable"));
                proprietaire.setPrive(rs.getString("prive"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return proprietaire;
    }
    
    public int UPDATE(Proprietaire proprietaire)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE proprietaire SET civilite=?, nom=? ,prenom=? ,societe=? ,adresse1=? ,adresse2=? ,ville=? ,nip=? ,tel1=? ,tel2=? ,email=? ,email2=? ,fax=? ,portable=? ,prive=? WHERE id_proprietaire=? ";
            ps=con.prepareStatement(sql);

            ps.setString(1,proprietaire.getCivilite());
            ps.setString(2,proprietaire.getNom());
            ps.setString(3,proprietaire.getPrenom());
            ps.setString(4,proprietaire.getSociete());
            ps.setString(5,proprietaire.getAdresse1());
            ps.setString(6,proprietaire.getAdresse2());
            ps.setString(7,proprietaire.getVille());
            ps.setString(8,proprietaire.getNip());
            ps.setString(9,proprietaire.getTel1());
            ps.setString(10,proprietaire.getTel2());
            ps.setString(11,proprietaire.getEmail());
            ps.setString(12,proprietaire.getEmail2());
            ps.setString(13,proprietaire.getFax());
            ps.setString(14,proprietaire.getPortable());
            ps.setString(15,proprietaire.getPrive());
            ps.setInt(16, proprietaire.getId_proprio());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_proprietaire)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE proprietaire WHERE id_proprietaire=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_proprietaire);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
}
