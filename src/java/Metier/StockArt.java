/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.Date;

/**
 *
 * @author Valentin
 */
public class StockArt {
   
    private int id_StockArt;
    private int id_art;
    private int id_fourn;
    private int id_qtt;
    private Date date_peremption;
    private String serial_nb;
    private String stockArtCol;

    /**
     * @return the id_StockArt
     */
    public int getId_StockArt() {
        return id_StockArt;
    }

    /**
     * @param id_StockArt the id_StockArt to set
     */
    public void setId_StockArt(int id_StockArt) {
        this.id_StockArt = id_StockArt;
    }

    /**
     * @return the id_art
     */
    public int getId_art() {
        return id_art;
    }

    /**
     * @param id_art the id_art to set
     */
    public void setId_art(int id_art) {
        this.id_art = id_art;
    }

    /**
     * @return the id_fourn
     */
    public int getId_fourn() {
        return id_fourn;
    }

    /**
     * @param id_fourn the id_fourn to set
     */
    public void setId_fourn(int id_fourn) {
        this.id_fourn = id_fourn;
    }

    /**
     * @return the id_qtt
     */
    public int getId_qtt() {
        return id_qtt;
    }

    /**
     * @param id_qtt the id_qtt to set
     */
    public void setId_qtt(int id_qtt) {
        this.id_qtt = id_qtt;
    }

    /**
     * @return the date_peremption
     */
    public Date getDate_peremption() {
        return date_peremption;
    }

    /**
     * @param date_peremption the date_peremption to set
     */
    public void setDate_peremption(Date date_peremption) {
        this.date_peremption = date_peremption;
    }

    /**
     * @return the serial_nb
     */
    public String getSerial_nb() {
        return serial_nb;
    }

    /**
     * @param serial_nb the serial_nb to set
     */
    public void setSerial_nb(String serial_nb) {
        this.serial_nb = serial_nb;
    }

    /**
     * @return the stockArtCol
     */
    public String getStockArtCol() {
        return stockArtCol;
    }

    /**
     * @param stockArtCol the stockArtCol to set
     */
    public void setStockArtCol(String stockArtCol) {
        this.stockArtCol = stockArtCol;
    }
   
}