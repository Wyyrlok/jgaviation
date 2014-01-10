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
@ManagedBean(name = "art_fourn_beans")
@SessionScoped()
public class Beans_Art_Form  implements Serializable {


    private Article_Fourn art_Fourn;
    private int id_art;
    private int id_fourn;
    private float prix_ach_fourn;
    private String part_nb_fourn;
    private String code_aen;

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    
    
    public String AddFournisseur() throws Exception {

        Article_Fourn art_Fourn = new Article_Fourn();
        art_Fourn.setId_art(getId_art());
        art_Fourn.setId_fourn(getId_fourn());
        art_Fourn.setPrix_ach_fourn(getPrix_ach_fourn());
        art_Fourn.setPart_nb_fourn(getPart_nb_fourn());
        art_Fourn.setCode_aen(getCode_aen());

        int add = new DAO.DAO_Article_Fourn().CREATE(art_Fourn);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "L'Article Fournisseur a bien été ajouté!"));
            return "listArtFournisseur";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<Article_Fourn> GET_LIST() {
        return new DAO.DAO_Article_Fourn().GET_ALL();
    }

    /**
     * @return the art_Fourn
     */
    public Article_Fourn getArt_Fourn() {
        return art_Fourn;
    }

    /**
     * @param art_Fourn the art_Fourn to set
     */
    public void setArt_Fourn(Article_Fourn art_Fourn) {
        this.art_Fourn = art_Fourn;
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
     * @return the prix_ach_fourn
     */
    public float getPrix_ach_fourn() {
        return prix_ach_fourn;
    }

    /**
     * @param prix_ach_fourn the prix_ach_fourn to set
     */
    public void setPrix_ach_fourn(float prix_ach_fourn) {
        this.prix_ach_fourn = prix_ach_fourn;
    }

    /**
     * @return the part_nb_fourn
     */
    public String getPart_nb_fourn() {
        return part_nb_fourn;
    }

    /**
     * @param part_nb_fourn the part_nb_fourn to set
     */
    public void setPart_nb_fourn(String part_nb_fourn) {
        this.part_nb_fourn = part_nb_fourn;
    }

    /**
     * @return the code_aen
     */
    public String getCode_aen() {
        return code_aen;
    }

    /**
     * @param code_aen the code_aen to set
     */
    public void setCode_aen(String code_aen) {
        this.code_aen = code_aen;
    }

    
}