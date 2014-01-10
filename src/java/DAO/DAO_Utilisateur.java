/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Metier.Article;
import Metier.Utilisateur;
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
public class DAO_Utilisateur 
{
    public int CREATE(Utilisateur utilisateur) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into utilisateur (sPrenom,sNom,id_profil,sLogin,sPassword,nbErr,bLocked) values (?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setString(1,utilisateur.getsPrenom());
            ps.setString(2,utilisateur.getsNom());
            ps.setInt(3,utilisateur.getId_profil());
            ps.setString(4, utilisateur.getsLogin());
            ps.setString(5,utilisateur.getsPassword());
            ps.setInt(6,utilisateur.getNbErr());
            ps.setBoolean(7,utilisateur.isbLocked());
   
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Utilisateur> GET_ALL()
    {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM utilisateur";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Utilisateur b = new Utilisateur();
                b.setId_Personnel(rs.getInt("id_Personnel"));
                b.setsPrenom(rs.getString("sPrenom"));
                b.setsNom(rs.getString("sNom"));
                b.setsLogin(rs.getString("sLogin"));
                b.setId_profil(rs.getInt("id_profil"));
                b.setsPassword(rs.getString("sPassword"));                
                b.setNbErr(rs.getInt("nbErr"));
                b.setbLocked(rs.getBoolean("bLocked"));
                
                utilisateurs.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return utilisateurs;
    }

    public Utilisateur READ(int id_Personnel)
    {
        Utilisateur b = new Utilisateur();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM utilisateur WHERE id_Personnel = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_Personnel);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                b.setId_Personnel(rs.getInt("id_Personnel"));
                b.setsPrenom(rs.getString("sPrenom"));
                b.setsNom(rs.getString("sNom"));
                b.setId_profil(rs.getInt("id_profil"));
                b.setsLogin(rs.getString("sLogin")); 
                b.setsPassword(rs.getString("sPassword"));                
                b.setNbErr(rs.getInt("nbErr"));
                b.setbLocked(rs.getBoolean("bLocked"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public Utilisateur READ(String sLogin)
    {
        System.err.println("READ : "+sLogin);
        Utilisateur b = new Utilisateur();
        
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM utilisateur WHERE sLogin = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,sLogin);
            
            ResultSet rs = ps.executeQuery();
            
            //rs.first();
            System.err.println("READ : bla1");
            while(rs.next())
            {
                
                b.setId_Personnel(rs.getInt("id_Personnel"));
                b.setsPrenom(rs.getString("sPrenom"));
                b.setsNom(rs.getString("sNom"));
                b.setId_profil(rs.getInt("id_profil"));
                b.setsLogin(rs.getString("sLogin")); 
                b.setsPassword(rs.getString("sPassword"));                
                b.setNbErr(rs.getInt("nbErr"));
                b.setbLocked(rs.getBoolean("bLocked"));
            }
            System.err.println("READ : bla2");
            rs.close();
            ps.close();
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return b;
    }
    
    public int UPDATE(Utilisateur utilisateur)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE utilisateur SET sPrenom=?, sNom=? ,id_profil=? ,sPassword=?, bLocked=? WHERE id_Personnel=?";
            ps=con.prepareStatement(sql);

            ps.setString(1,utilisateur.getsPrenom());
            ps.setString(2,utilisateur.getsNom());
            ps.setInt(3,utilisateur.getId_profil());
            ps.setString(4, utilisateur.getsPassword());
            ps.setBoolean(5,utilisateur.isbLocked());
            ps.setInt(6,utilisateur.getId_Personnel());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_Personnel)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE utilisateur WHERE id_Personnel=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_Personnel);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    /* 
    / Retour : 
    / -1 : login non existant
    / -2 : mot de passe invalide
    / -3 : utilisateur vérouillé
    */
    public Utilisateur Connect(String sLogin, String sPassword)
    {
        Utilisateur utilisateur = READ(sLogin);
        if( utilisateur.getId_Personnel() > 0 )
        {
            if( utilisateur.getsPassword().equals(sPassword) )
            {
                if( !utilisateur.isbLocked())
                    utilisateur.setRetCnx(0);
                else
                    utilisateur.setRetCnx(-3);
            }
            else
                utilisateur.setRetCnx(-2);
        }
        else
            utilisateur.setRetCnx(-1);
        
        return utilisateur;
    }
}
