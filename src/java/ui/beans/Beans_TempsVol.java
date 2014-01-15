/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.TempsVol;
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
@ManagedBean(name = "tempsvol_beans")
@SessionScoped()
public class Beans_TempsVol implements Serializable{
    


    private List<SelectItem> listeTempsVolItem;
    private String selectedTempsVolItem;
    private TempsVol selectedtempsvol;
    private int id_TempsVol;
    private String immat;
    private Date date_vol;
    private Float duree;


    public Beans_TempsVol() {
        
        listeTempsVolItem = new ArrayList<SelectItem>();
        List<TempsVol> tempsVol = new DAO.DAO_TempsVol().GET_ALL();
        for (TempsVol temps : tempsVol) {
            listeTempsVolItem.add(new SelectItem(temps.getId_TempsVol()));
        }
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddTempsVol() throws Exception {
        
        TempsVol temps = new TempsVol();
        temps.setId_TempsVol(getId_TempsVol());
        temps.setImmat(getImmat());
        temps.setDate_vol(getDate_vol());
        temps.setDuree(getDuree());


        int add = new DAO.DAO_TempsVol().CREATE(temps);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le Temps de Vol a bien été mis à jour!"));
            return "listTempsVol";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<TempsVol> GET_LIST() {
        return new DAO.DAO_TempsVol().GET_ALL();
    }

    /**
     * @return the listeTempsVolItem
     */
    public List<SelectItem> getListeTempsVolItem() {
        return listeTempsVolItem;
    }

    /**
     * @param listeTempsVolItem the listeTempsVolItem to set
     */
    public void setListeTempsVolItem(List<SelectItem> listeTempsVolItem) {
        this.listeTempsVolItem = listeTempsVolItem;
    }

    /**
     * @return the selectedTempsVolItem
     */
    public String getSelectedTempsVolItem() {
        return selectedTempsVolItem;
    }

    /**
     * @param selectedTempsVolItem the selectedTempsVolItem to set
     */
    public void setSelectedTempsVolItem(String selectedTempsVolItem) {
        this.selectedTempsVolItem = selectedTempsVolItem;
    }

    /**
     * @return the selectedtempsvol
     */
    public TempsVol getSelectedtempsvol() {
        return selectedtempsvol;
    }

    /**
     * @param selectedtempsvol the selectedtempsvol to set
     */
    public void setSelectedtempsvol(TempsVol selectedtempsvol) {
        this.selectedtempsvol = selectedtempsvol;
    }

    /**
     * @return the id_TempsVol
     */
    public int getId_TempsVol() {
        return id_TempsVol;
    }

    /**
     * @param id_TempsVol the id_TempsVol to set
     */
    public void setId_TempsVol(int id_TempsVol) {
        this.id_TempsVol = id_TempsVol;
    }

    /**
     * @return the immat
     */
    public String getImmat() {
        return immat;
    }

    /**
     * @param immat the immat to set
     */
    public void setImmat(String immat) {
        this.immat = immat;
    }

    /**
     * @return the date_vol
     */
    public Date getDate_vol() {
        return date_vol;
    }

    /**
     * @param date_vol the date_vol to set
     */
    public void setDate_vol(Date date_vol) {
        this.date_vol = date_vol;
    }

    /**
     * @return the duree
     */
    public Float getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(Float duree) {
        this.duree = duree;
    }
    
}
