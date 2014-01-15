/**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.Date;

/**
 *
 * @author quent_000
 */
public class StockArt {
    private int id_Stockart;
    private int id_art;
    private int id_fourn;
    private int id_qt;
    private Date date_peremtion;
    private String serial_nb;
    private String StockArtcol;

    /**
     * @return the id_Stockart
     */
    public int getId_Stockart() {
        return id_Stockart;
    }

    /**
     * @param id_Stockart the id_Stockart to set
     */
    public void setId_Stockart(int id_Stockart) {
        this.id_Stockart = id_Stockart;
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
    public int getId_qt() {
        return id_qt;
    }

    /**
     * @param id_qt the id_qtt to set
     */
    public void setId_qt(int id_qt) {
        this.id_qt = id_qt;
    }

    /**
     * @return the date_peremtion
     */
    public Date getDate_peremtion() {
        return date_peremtion;
    }

    /**
     * @param date_peremtion the date_peremtion to set
     */
    public void setDate_peremtion(Date date_peremtion) {
        this.date_peremtion = date_peremtion;
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
     * @return the StockArtcol
     */
    public String getStockArtcol() {
        return StockArtcol;
    }

    /**
     * @param StockArtcol the StockArtcol to set
     */
    public void setStockArtcol(String StockArtcol) {
        this.StockArtcol = StockArtcol;
    }
}
