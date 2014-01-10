/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Article_Fourn;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Valentin
 */
//@ManagedBean(name = "art_fourn_beans")
//@SessionScoped()
//public class Beans_Art_Form  implements Serializable {
//
//
//    private Article_Fourn art_Fourn;
//    private int id_art;
//    private int id_fourn;
//    private float prix_ach_fourn;
//    private String part_nb_fourn;
//    private String code_aen;
//
//    private void addMessage(FacesMessage message) {
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
//
//    
//    
//    public String AddFournisseur() throws Exception {
//
//        Article_Fourn art_Fourn = new Article_Fourn();
//        art_Fourn.setId_art(getNom_fourn());
//
//        int add = new DAO.DAO_Fournisseur().CREATE(fourni);
//        if (add != 0) {
//            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le fournisseur a bien été ajouté!"));
//            return "listFournisseur";
//        } else {
//            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
//            return "";
//        }
//    }
//
//    public List<Fournisseur> GET_LIST() {
//        return new DAO.DAO_Fournisseur().GET_ALL();
//    }
//
//    /**
//     * @return the selectedFourni
//     */
//    public Fournisseur getSelectedConstruct() {
//        return getSelectedFourni();
//    }
//
//    /**
//     * @param selectedFourni the selectedFourni to set
//     */
//    public void setSelectedFourni(Fournisseur selectedFourni) {
//        this.setSelectedFourni(getSelectedFourni());
//    }
//
//    /**
//     * @return the id_fournisseur
//     */
//    public int getId_Fournisseur() {
//        return getId_fournisseur();
//    }
//
//    /**
//     * @param id_fournisseur the id_fournisseur to set
//     */
//    public void setId_fournisseur(int id_const) {
//        this.id_fournisseur = id_fournisseur;
//    }
//
//    /**
//     * @return the selectedFourni
//     */
//    public Fournisseur getSelectedFourni() {
//        return selectedFourni;
//    }
//
//    /**
//     * @return the id_fournisseur
//     */
//    public int getId_fournisseur() {
//        return id_fournisseur;
//    }
//
//    /**
//     * @return the nom_fourn
//     */
//    public String getNom_fourn() {
//        return nom_fourn;
//    }
//
//    /**
//     * @param nom_fourn the nom_fourn to set
//     */
//    public void setNom_fourn(String nom_fourn) {
//        this.nom_fourn = nom_fourn;
//    }
//}