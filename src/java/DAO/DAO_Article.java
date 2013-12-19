/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.Article;
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
public class DAO_Article {
/**
 *
 * @author Valentin
 */
    
    public int CREATE(Article article) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into article (id_article,designation,part_nb_const,id_const,prix_vte_art,bPeremption,bSerialNb,stock_mini) values (?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setInt(1,article.getId_article());
            ps.setString(2,article.getDesignation());
            ps.setString(3,article.getPart_nb_const());
            ps.setInt(4, article.getId_const());
            ps.setFloat(5,article.getPrix_vte_article());
            ps.setBoolean(6,article.isbPeremption());
            ps.setBoolean(7,article.isbSerialNb());
            ps.setInt(8, article.getStock_mini());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<Article> GET_ALL()
    {
        ArrayList<Article> article = new ArrayList<Article>();
        
        Connection con = null; 
        ResultSet rs=null;  
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM article WHERE id_article = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                Article b = new Article();
                b.setId_article(rs.getInt("id_article"));
                b.setDesignation(rs.getString("designation"));
                b.setPart_nb_const(rs.getString("part_nb_const"));
                b.setId_const(rs.getInt("id_const"));
                b.setPrix_vte_article(rs.getInt("prix_vte_art"));                
                b.setbPeremption(rs.getBoolean("bPeremption"));
                b.setbSerialNb(rs.getBoolean("bSerialNb"));
                b.setStock_mini(rs.getInt("stock_mini"));
                
                article.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return article;
    }

    public Article READ(String immat)
    {
        Article article = new Article();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM article WHERE id_article = ?";
            
            ps=con.prepareStatement(sql);
            ps.setString(1,immat);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                article.setId_article(rs.getInt("id_article"));
                article.setDesignation(rs.getString("designation"));
                article.setPart_nb_const(rs.getString("part_nb_const"));
                article.setId_const(rs.getInt("id_const"));
                article.setPrix_vte_article(rs.getInt("prix_vte_art"));                
                article.setbPeremption(rs.getBoolean("bPeremption"));
                article.setbSerialNb(rs.getBoolean("bSerialNb"));
                article.setStock_mini(rs.getInt("stock_mini"));
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        
        return article;
    }
    
    public int UPDATE(Article article)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE article SET id_article=?, designation=? ,part_nb_const=? ,id_const=? ,prix_vte_art=? ,bPeremption=? ,bSerialNb=?, stock_mini=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1,article.getId_article());
            ps.setString(2,article.getDesignation());
            ps.setString(3,article.getPart_nb_const());
            ps.setInt(4, article.getId_const());
            ps.setFloat(5,article.getPrix_vte_article());
            ps.setBoolean(6,article.isbPeremption());
            ps.setBoolean(7,article.isbSerialNb());
            ps.setInt(8, article.getStock_mini());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_article)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE article WHERE id_article=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_article);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
}


