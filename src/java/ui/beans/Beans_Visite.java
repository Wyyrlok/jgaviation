/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Visite;
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

@ManagedBean(name = "visite_beans")
@SessionScoped()
public class Beans_Visite implements Serializable{

    

    private List<SelectItem> listeVisiteItem;
    private String selectedVisiteItem;
    private Visite selectedvisite;
    
    private int id_Visite;
    private String immat;
    private float saisie_heure;
    private Date saisie_date;
    private Date tol_date;
    private float tol_heure;
    private Date der_date;
    private float der_heure;
    private int id_maintenance;


    public Beans_Visite() {
        
        listeVisiteItem = new ArrayList<SelectItem>();
        List<Visite> visite = new DAO.DAO_Visite().GET_ALL();
        for (Visite vis : visite) {
            listeVisiteItem.add(new SelectItem(vis.getId_Visite()));
        }
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddVisite() throws Exception {
        
        Visite visite = new Visite();
        visite.setId_Visite(getId_Visite());
        visite.setImmat(getImmat());
        visite.setSaisie_heure(getSaisie_heure());
        visite.setSaisie_date(getSaisie_date());
        visite.setTol_date(getTol_date());
        visite.setTol_heure(getTol_heure());
        visite.setDer_date(getDer_date());
        visite.setDer_heure(getDer_heure());
        visite.setId_maintenance(getId_maintenance());

        


        int add = new DAO.DAO_Visite().CREATE(visite);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "La Visite a bien été ajouté !"));
            return "listVisite";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<Visite> GET_LIST() {
        return new DAO.DAO_Visite().GET_ALL();
    }

    /**
     * @return the listeVisiteItem
     */
    public List<SelectItem> getListeVisiteItem() {
        return listeVisiteItem;
    }

    /**
     * @param listeVisiteItem the listeVisiteItem to set
     */
    public void setListeVisiteItem(List<SelectItem> listeVisiteItem) {
        this.listeVisiteItem = listeVisiteItem;
    }

    /**
     * @return the selectedVisiteItem
     */
    public String getSelectedVisiteItem() {
        return selectedVisiteItem;
    }

    /**
     * @param selectedVisiteItem the selectedVisiteItem to set
     */
    public void setSelectedVisiteItem(String selectedVisiteItem) {
        this.selectedVisiteItem = selectedVisiteItem;
    }

    /**
     * @return the selectedvisite
     */
    public Visite getSelectedvisite() {
        return selectedvisite;
    }

    /**
     * @param selectedvisite the selectedvisite to set
     */
    public void setSelectedvisite(Visite selectedvisite) {
        this.selectedvisite = selectedvisite;
    }

    /**
     * @return the id_Visite
     */
    public int getId_Visite() {
        return id_Visite;
    }

    /**
     * @param id_Visite the id_Visite to set
     */
    public void setId_Visite(int id_Visite) {
        this.id_Visite = id_Visite;
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
     * @return the saisie_heure
     */
    public float getSaisie_heure() {
        return saisie_heure;
    }

    /**
     * @param saisie_heure the saisie_heure to set
     */
    public void setSaisie_heure(float saisie_heure) {
        this.saisie_heure = saisie_heure;
    }

    /**
     * @return the saisie_date
     */
    public Date getSaisie_date() {
        return saisie_date;
    }

    /**
     * @param saisie_date the saisie_date to set
     */
    public void setSaisie_date(Date saisie_date) {
        this.saisie_date = saisie_date;
    }

    /**
     * @return the tol_date
     */
    public Date getTol_date() {
        return tol_date;
    }

    /**
     * @param tol_date the tol_date to set
     */
    public void setTol_date(Date tol_date) {
        this.tol_date = tol_date;
    }

    /**
     * @return the tol_heure
     */
    public float getTol_heure() {
        return tol_heure;
    }

    /**
     * @param tol_heure the tol_heure to set
     */
    public void setTol_heure(float tol_heure) {
        this.tol_heure = tol_heure;
    }

    /**
     * @return the der_date
     */
    public Date getDer_date() {
        return der_date;
    }

    /**
     * @param der_date the der_date to set
     */
    public void setDer_date(Date der_date) {
        this.der_date = der_date;
    }

    /**
     * @return the der_heure
     */
    public float getDer_heure() {
        return der_heure;
    }

    /**
     * @param der_heure the der_heure to set
     */
    public void setDer_heure(float der_heure) {
        this.der_heure = der_heure;
    }

    /**
     * @return the id_maintenance
     */
    public int getId_maintenance() {
        return id_maintenance;
    }

    /**
     * @param id_maintenance the id_maintenance to set
     */
    public void setId_maintenance(int id_maintenance) {
        this.id_maintenance = id_maintenance;
    }
    
}
