/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Profil_Utilisateur;
import java.io.Serializable;
import java.util.ArrayList;
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

@ManagedBean(name = "profilUtilisateur_beans")
@SessionScoped()
public class Beans_Profil_Utilisateur implements Serializable{

    

    private List<SelectItem> listeProfilUtilisateurItem;
    private String selectedProfilUtilisateurItem;
    private Profil_Utilisateur selectedprofilutilisteur;
    private int id_profil;
    private String nom_profil;

    public Beans_Profil_Utilisateur() {
        listeProfilUtilisateurItem = new ArrayList<SelectItem>();
        List<Profil_Utilisateur> profilU = new DAO.DAO_Profil_Utilisateur().GET_ALL();
        for (Profil_Utilisateur profil : profilU) {
            listeProfilUtilisateurItem.add(new SelectItem(profil.getId_profil()));
        }
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddProfilUtilisateur() throws Exception {
        
        Profil_Utilisateur profil = new Profil_Utilisateur();
        profil.setId_profil(getId_profil());
        profil.setNom_profil(getNom_profil());


        int add = new DAO.DAO_Profil_Utilisateur().CREATE(profil);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le Profil Utilisateur a bien été ajouté!"));
            return "listProfilUtilisateur";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<Profil_Utilisateur> GET_LIST() {
        return new DAO.DAO_Profil_Utilisateur().GET_ALL();
    }

    /**
     * @return the listeProfilUtilisateurItem
     */
    public List<SelectItem> getListeProfilUtilisateurItem() {
        return listeProfilUtilisateurItem;
    }

    /**
     * @param listeProfilUtilisateurItem the listeProfilUtilisateurItem to set
     */
    public void setListeProfilUtilisateurItem(List<SelectItem> listeProfilUtilisateurItem) {
        this.listeProfilUtilisateurItem = listeProfilUtilisateurItem;
    }

    /**
     * @return the selectedProfilUtilisateurItem
     */
    public String getSelectedProfilUtilisateurItem() {
        return selectedProfilUtilisateurItem;
    }

    /**
     * @param selectedProfilUtilisateurItem the selectedProfilUtilisateurItem to set
     */
    public void setSelectedProfilUtilisateurItem(String selectedProfilUtilisateurItem) {
        this.selectedProfilUtilisateurItem = selectedProfilUtilisateurItem;
    }

    /**
     * @return the selectedprofilutilisteur
     */
    public Profil_Utilisateur getSelectedprofilutilisteur() {
        return selectedprofilutilisteur;
    }

    /**
     * @param selectedprofilutilisteur the selectedprofilutilisteur to set
     */
    public void setSelectedprofilutilisteur(Profil_Utilisateur selectedprofilutilisteur) {
        this.selectedprofilutilisteur = selectedprofilutilisteur;
    }

    /**
     * @return the id_profil
     */
    public int getId_profil() {
        return id_profil;
    }

    /**
     * @param id_profil the id_profil to set
     */
    public void setId_profil(int id_profil) {
        this.id_profil = id_profil;
    }

    /**
     * @return the nom_profil
     */
    public String getNom_profil() {
        return nom_profil;
    }

    /**
     * @param nom_profil the nom_profil to set
     */
    public void setNom_profil(String nom_profil) {
        this.nom_profil = nom_profil;
    }
    
}
