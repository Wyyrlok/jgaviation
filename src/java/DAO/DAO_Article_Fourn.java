/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Article_Fourn;
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
public class DAO_Article_Fourn {
    

/**
 *
 * @author Valentin
 */
    
    public int CREATE(Article_Fourn article_fourn) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into article_fourn (id_art,id_fourn,prix_ach_fourn,part_nb_fourn,code_ean) values (?,?,?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setInt(1,article_fourn.getId_art());
            ps.setInt(2,article_fourn.getId_fourn());
            ps.setFloat(3,article_fourn.getPrix_ach_fourn());
            ps.setString(4, article_fourn.getPart_nb_fourn());
            ps.setString(5,article_fourn.getCode_aen());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Article_Fourn> GET_ALL()
    {
        ArrayList<Article_Fourn> article = new ArrayList<Article_Fourn>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM article_fourn WHERE id_art = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Article_Fourn b = new Article_Fourn();
                b.setId_art(rs.getInt("id_art"));
                b.setId_fourn(rs.getInt("id_fourn"));
                b.setPrix_ach_fourn(rs.getFloat("prix_ach_fourn"));
                b.setPart_nb_fourn(rs.getString("part_nb_fourn"));
                b.setCode_aen(rs.getString("code_ean"));               
                
                article.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return article;
    }

    public Article_Fourn READ(String immat)
    {
        Article_Fourn article_fourn = new Article_Fourn();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM _fourn WHERE id_art = ?";
            
            ps=con.prepareStatement(sql);
            ps.setString(1,immat);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                article_fourn.setId_art(rs.getInt("id_art"));
                article_fourn.setId_fourn(rs.getInt("id_fourn"));
                article_fourn.setPrix_ach_fourn(rs.getFloat("prix_ach_fourn"));
                article_fourn.setPart_nb_fourn(rs.getString("part_nb_fourn"));
                article_fourn.setCode_aen(rs.getString("code_ean"));  
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return article_fourn;
    }
    
    public int UPDATE(Article_Fourn article_fourn)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE article_fourn SET id_art=?, id_fourn=? ,prix_ach_fourn=? ,prix_nb_fourn=? ,code_ean=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1,article_fourn.getId_art());
            ps.setInt(2,article_fourn.getId_fourn());
            ps.setFloat(3,article_fourn.getPrix_ach_fourn());
            ps.setString(4, article_fourn.getPart_nb_fourn());
            ps.setString(5,article_fourn.getCode_aen());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_art)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE article_fourn WHERE id_art=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_art);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}
