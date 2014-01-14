/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.MoteurAeronef;
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

@ManagedBean(name = "moteurAeronef_beans")
@SessionScoped()
public class Beans_MoteurAeronef implements Serializable {

    private List<SelectItem> listeMoteurAeronefItem;
    private String selectedInstructWOItem;
    private MoteurAeronef selectedInstructWO;
    private int id_Moteur;
    private String position;
    private Date date_inventaire;
    private String immat;

    public Beans_MoteurAeronef() {
        listeMoteurAeronefItem = new ArrayList<SelectItem>();
        List<MoteurAeronef> moteur = new DAO.DAO_MoteurAeronef().GET_ALL();
        for (MoteurAeronef mot : moteur) {
            listeMoteurAeronefItem.add(new SelectItem(mot.getId_Moteur()));
        }
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddMoteurAeronef() throws Exception {
        
        MoteurAeronef moteur = new MoteurAeronef();
        moteur.setId_Moteur(getId_Moteur());
        moteur.setPosition(getPosition());
        moteur.setDate_inventaire(getDate_inventaire());
        moteur.setImmat(getImmat());


        int add = new DAO.DAO_MoteurAeronef().CREATE(moteur);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le Moteur Aeronef a bien été ajouté!"));
            return "listMoteurAeronef";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<MoteurAeronef> GET_LIST() {
        return new DAO.DAO_MoteurAeronef().GET_ALL();
    }

    /**
     * @return the listeMoteurAeronefItem
     */
    public List<SelectItem> getListeMoteurAeronefItem() {
        return listeMoteurAeronefItem;
    }

    /**
     * @param listeMoteurAeronefItem the listeMoteurAeronefItem to set
     */
    public void setListeMoteurAeronefItem(List<SelectItem> listeMoteurAeronefItem) {
        this.listeMoteurAeronefItem = listeMoteurAeronefItem;
    }

    /**
     * @return the selectedInstructWOItem
     */
    public String getSelectedInstructWOItem() {
        return selectedInstructWOItem;
    }

    /**
     * @param selectedInstructWOItem the selectedInstructWOItem to set
     */
    public void setSelectedInstructWOItem(String selectedInstructWOItem) {
        this.selectedInstructWOItem = selectedInstructWOItem;
    }

    /**
     * @return the selectedInstructWO
     */
    public MoteurAeronef getSelectedInstructWO() {
        return selectedInstructWO;
    }

    /**
     * @param selectedInstructWO the selectedInstructWO to set
     */
    public void setSelectedInstructWO(MoteurAeronef selectedInstructWO) {
        this.selectedInstructWO = selectedInstructWO;
    }

    /**
     * @return the id_Moteur
     */
    public int getId_Moteur() {
        return id_Moteur;
    }

    /**
     * @param id_Moteur the id_Moteur to set
     */
    public void setId_Moteur(int id_Moteur) {
        this.id_Moteur = id_Moteur;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the date_inventaire
     */
    public Date getDate_inventaire() {
        return date_inventaire;
    }

    /**
     * @param date_inventaire the date_inventaire to set
     */
    public void setDate_inventaire(Date date_inventaire) {
        this.date_inventaire = date_inventaire;
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
}
