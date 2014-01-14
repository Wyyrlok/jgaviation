/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.ElmntMoteur;
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
@ManagedBean(name="elmntMoteur_beans")
@SessionScoped()
public class Beans_ElmntMoteur implements Serializable{
    

    private List<SelectItem> listeElmntMoteurItem;
    private String selectedElmntMoteurItem;
    
    private ElmntMoteur selectedElmntMoteur;
    private int id_elmnt;
    private String designation;
    private int id_Const_Marque;
    private String type;
    private String serial_nb;
    private Date date;
    private String observations;
    private int id_moteur;


    public Beans_ElmntMoteur()
    {
        listeElmntMoteurItem = new ArrayList<SelectItem>();
        List<ElmntMoteur> ElmntMoteur = new DAO.DAO_ElmntMoteur().GET_ALL();
        for(ElmntMoteur elmnt: ElmntMoteur)
        {
            listeElmntMoteurItem.add(new SelectItem(elmnt.getId_elmnt()));
        }
    }
    
    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AddElmntMoteur() throws Exception
    {
        ElmntMoteur elmnt = new ElmntMoteur();
        elmnt.setId_elmnt(getId_elmnt());
        elmnt.setDesignation(getDesignation());
        elmnt.setId_Const_Marque(getId_Const_Marque());
        elmnt.setType(getType());
        elmnt.setSerial_nb(getSerial_nb());
        elmnt.setDate(getDate());
        elmnt.setObservations(getObservations());
        elmnt.setId_moteur(getId_moteur());

        
        int add = new DAO.DAO_ElmntMoteur().CREATE(elmnt);
        if( add != 0 )
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "L'élment moteur a bien été ajouté!"));
            return "listElmntMoteur";
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";   
        }
    }
    
    public List<ElmntMoteur> GET_LIST()
    {
        return new DAO.DAO_ElmntMoteur().GET_ALL();
    }

    /**
     * @return the listeElmntMoteurItem
     */
    public List<SelectItem> getListeElmntMoteurItem() {
        return listeElmntMoteurItem;
    }

    /**
     * @param listeElmntMoteurItem the listeElmntMoteurItem to set
     */
    public void setListeElmntMoteurItem(List<SelectItem> listeElmntMoteurItem) {
        this.listeElmntMoteurItem = listeElmntMoteurItem;
    }

    /**
     * @return the selectedElmntMoteurItem
     */
    public String getSelectedElmntMoteurItem() {
        return selectedElmntMoteurItem;
    }

    /**
     * @param selectedElmntMoteurItem the selectedElmntMoteurItem to set
     */
    public void setSelectedElmntMoteurItem(String selectedElmntMoteurItem) {
        this.selectedElmntMoteurItem = selectedElmntMoteurItem;
    }

    /**
     * @return the selectedElmntMoteur
     */
    public ElmntMoteur getSelectedElmntMoteur() {
        return selectedElmntMoteur;
    }

    /**
     * @param selectedElmntMoteur the selectedElmntMoteur to set
     */
    public void setSelectedElmntMoteur(ElmntMoteur selectedElmntMoteur) {
        this.selectedElmntMoteur = selectedElmntMoteur;
    }

    /**
     * @return the id_elmnt
     */
    public int getId_elmnt() {
        return id_elmnt;
    }

    /**
     * @param id_elmnt the id_elmnt to set
     */
    public void setId_elmnt(int id_elmnt) {
        this.id_elmnt = id_elmnt;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the id_Const_Marque
     */
    public int getId_Const_Marque() {
        return id_Const_Marque;
    }

    /**
     * @param id_Const_Marque the id_Const_Marque to set
     */
    public void setId_Const_Marque(int id_Const_Marque) {
        this.id_Const_Marque = id_Const_Marque;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the observations
     */
    public String getObservations() {
        return observations;
    }

    /**
     * @param observations the observations to set
     */
    public void setObservations(String observations) {
        this.observations = observations;
    }

    /**
     * @return the id_moteur
     */
    public int getId_moteur() {
        return id_moteur;
    }

    /**
     * @param id_moteur the id_moteur to set
     */
    public void setId_moteur(int id_moteur) {
        this.id_moteur = id_moteur;
    }

    
    
}


