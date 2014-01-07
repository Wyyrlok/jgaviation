/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Fournisseur;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author quent_000
 */
@ManagedBean(name = "fourni_beans")
@SessionScoped()
public class Beans_Fournisseur implements Serializable {

    private Fournisseur selectedFourni;
    private int id_fournisseur;
    private String nom_fourn;

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddConstructeur() throws Exception {

        Fournisseur fourni = new Fournisseur();
        fourni.setId_fournisseur(getId_Fournisseur());
        fourni.setNom_fourn(getNom_fourn());



        int add = new DAO.DAO_Fournisseur().CREATE(fourni);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le fournisseur a bien été ajouté!"));
            return "listFournisseur";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<Fournisseur> GET_LIST() {
        return new DAO.DAO_Fournisseur().GET_ALL();
    }

    /**
     * @return the selectedFourni
     */
    public Fournisseur getSelectedConstruct() {
        return getSelectedFourni();
    }

    /**
     * @param selectedFourni the selectedFourni to set
     */
    public void setSelectedFourni(Fournisseur selectedFourni) {
        this.setSelectedFourni(getSelectedFourni());
    }

    /**
     * @return the id_fournisseur
     */
    public int getId_Fournisseur() {
        return getId_fournisseur();
    }

    /**
     * @param id_fournisseur the id_fournisseur to set
     */
    public void setId_fournisseur(int id_const) {
        this.id_fournisseur = id_fournisseur;
    }

    /**
     * @return the selectedFourni
     */
    public Fournisseur getSelectedFourni() {
        return selectedFourni;
    }

    /**
     * @return the id_fournisseur
     */
    public int getId_fournisseur() {
        return id_fournisseur;
    }

    /**
     * @return the nom_fourn
     */
    public String getNom_fourn() {
        return nom_fourn;
    }

    /**
     * @param nom_fourn the nom_fourn to set
     */
    public void setNom_fourn(String nom_fourn) {
        this.nom_fourn = nom_fourn;
    }
}