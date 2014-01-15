/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Profil_Utilisateur;
import Metier.StockArt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Valentin
 */    
@ManagedBean(name = "stockart_beans")
@SessionScoped()
public class Beans_StockArt implements Serializable{


    private List<SelectItem> listeStockArtItem;
    private String selectedStockArtItem;
    private Profil_Utilisateur selectedstockart;
    private int id_Stockart;
    private int id_art;
    private int id_fourn;
    private int id_qt;
    private Date date_peremtion;
    private String serial_nb;
    private String StockArtcol;


    public Beans_StockArt() {
        listeStockArtItem = new ArrayList<SelectItem>();
        List<StockArt> stockArt = new DAO.DAO_StockArt().GET_ALL();
        for (StockArt stock : stockArt) {
            listeStockArtItem.add(new SelectItem(stock.getId_Stockart()));
        }
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddStockArt() throws Exception {
        
        StockArt stock = new StockArt();
        stock.setId_Stockart(getId_Stockart());
        stock.setId_art(getId_art());
        stock.setId_fourn(getId_fourn());
        stock.setId_qt(getId_qt());
        stock.setDate_peremtion(getDate_peremtion());
        stock.setSerial_nb(getSerial_nb());
        stock.setStockArtcol(getStockArtcol());

        int add = new DAO.DAO_StockArt().CREATE(stock);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le Stock a bien été mis à jour!"));
            return "listStockArt";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<StockArt> GET_LIST() {
        return new DAO.DAO_StockArt().GET_ALL();
    }

    /**
     * @return the listeStockArtItem
     */
    public List<SelectItem> getListeStockArtItem() {
        return listeStockArtItem;
    }

    /**
     * @param listeStockArtItem the listeStockArtItem to set
     */
    public void setListeStockArtItem(List<SelectItem> listeStockArtItem) {
        this.listeStockArtItem = listeStockArtItem;
    }

    /**
     * @return the selectedStockArtItem
     */
    public String getSelectedStockArtItem() {
        return selectedStockArtItem;
    }

    /**
     * @param selectedStockArtItem the selectedStockArtItem to set
     */
    public void setSelectedStockArtItem(String selectedStockArtItem) {
        this.selectedStockArtItem = selectedStockArtItem;
    }

    /**
     * @return the selectedstockart
     */
    public Profil_Utilisateur getSelectedstockart() {
        return selectedstockart;
    }

    /**
     * @param selectedstockart the selectedstockart to set
     */
    public void setSelectedstockart(Profil_Utilisateur selectedstockart) {
        this.selectedstockart = selectedstockart;
    }

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
     * @return the id_qt
     */
    public int getId_qt() {
        return id_qt;
    }

    /**
     * @param id_qt the id_qt to set
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
