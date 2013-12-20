/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Metier.StockArt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author quent
 */
public class DAO_StockArt {
    
    public int CREATE(StockArt stockart) throws Exception
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null; 
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="insert into stockart (id_StockArt,id_art,id_fourn,id_qtt,date_peremption,serial_nb,StockArtcol) values (?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);

            ps.setInt(1,stockart.getId_StockArt());
            ps.setInt(2,stockart.getId_art());
            ps.setInt(3,stockart.getId_fourn());
            ps.setInt(4,stockart.getId_qtt());
            ps.setDate(5,(Date)stockart.getDate_peremption());
            ps.setString(6,stockart.getSerial_nb());
            ps.setString(7,stockart.getStockArtCol());
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public ArrayList<StockArt> GET_ALL()
    {
        ArrayList<StockArt> stockart = new ArrayList<StockArt>();
        
        Connection con = null; 
        ResultSet rs=null;
        Statement st=null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM suivirep WHERE id_SuiviRep = ?";
            
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                StockArt b = new StockArt();
                b.setId_StockArt(rs.getInt("id_StockArt"));
                b.setId_art(rs.getInt("id_art"));
                b.setId_fourn(rs.getInt("id_fourn"));
                b.setId_qtt(rs.getInt("id_qtt"));
                b.setDate_peremption(rs.getDate("date_peremption"));
                b.setSerial_nb(rs.getString("serial_nb"));
                b.setStockArtCol(rs.getString("StockArtcol"));
                
                stockart.add(b);
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}       
        
        return stockart;
    }

    public StockArt READ(int id_StockArt)
    {
        StockArt stockart = new StockArt();
        
        Connection con = null; 
        ResultSet rs=null;  
        PreparedStatement ps = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);
            String sql="SELECT * FROM stockart WHERE id_StockArt = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,id_StockArt);
            
            rs=ps.executeQuery(sql);
            
            while(rs.next())
            {
                
                stockart.setId_StockArt(rs.getInt("id_StockArt"));
                stockart.setId_art(rs.getInt("id_art"));
                stockart.setId_fourn(rs.getInt("id_fourn"));
                stockart.setId_qtt(rs.getInt("id_qtt"));
                stockart.setDate_peremption(rs.getDate("date_peremption"));
                stockart.setSerial_nb(rs.getString("serial_nb"));
                stockart.setStockArtCol(rs.getString("StockArtcol"));
                
            }
            
            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}      
        
        
        return stockart;
    }
    
    public int UPDATE(StockArt stockart)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="UPDATE stockart SET id_StockArt=? ,id_art=? ,id_fourn=? ,id_qtt=? ,date_peremption=? ,serial_nb=? ,StockArtcol=?";
            ps=con.prepareStatement(sql);

            ps.setInt(1,stockart.getId_StockArt());
            ps.setInt(2,stockart.getId_art());
            ps.setInt(3,stockart.getId_fourn());
            ps.setInt(4,stockart.getId_qtt());
            ps.setDate(5,(Date)stockart.getDate_peremption());
            ps.setString(6,stockart.getSerial_nb());
            ps.setString(7,stockart.getStockArtCol());
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }
    
    public int DELETE(int id_StockArt)
    {
        int ret = 0;
        PreparedStatement ps = null;
        Connection con = null;
        try
        {
            Class.forName(DBConnect.sDriver);
            con = DriverManager.getConnection(DBConnect.sCnx, DBConnect.sUser, DBConnect.sPwd);

            String sql="DELETE stockart WHERE id_StockArt=? ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, id_StockArt);
            
            ret = ps.executeUpdate();

            con.close();
        }
        catch(Exception ex){System.err.println(ex.getMessage());}
        return ret;
    }   
}