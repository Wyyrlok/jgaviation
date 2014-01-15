/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.TypeAeronef;
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
@ManagedBean(name = "typeaeronef_beans")
@SessionScoped()
public class Beans_TypeAeronef implements Serializable{
    

    private List<SelectItem> listeTypeAeronefItem;
    private String selectedTypeAeronefItem;
    private TypeAeronef selectedtypeaeronef;
    private int id_type;
    private String nom_type;
    private int nb_moteur;

    public Beans_TypeAeronef() {
        
        listeTypeAeronefItem = new ArrayList<SelectItem>();
        List<TypeAeronef> typeAeronef = new DAO.DAO_TypeAeronef().GET_ALL();
        for (TypeAeronef type : typeAeronef) {
            listeTypeAeronefItem.add(new SelectItem(type.getId_type()));
        }
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddTypeAeronef() throws Exception {
        
        TypeAeronef type = new TypeAeronef();
        type.setId_type(getId_type());
        type.setNom_type(getNom_type());
        type.setNb_moteur(getNb_moteur());
        


        int add = new DAO.DAO_TypeAeronef().CREATE(type);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le Type Aeronef a bien été ajouté !"));
            return "listTypeAjoute";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<TypeAeronef> GET_LIST() {
        return new DAO.DAO_TypeAeronef().GET_ALL();
    }

    /**
     * @return the listeTypeAeronefItem
     */
    public List<SelectItem> getListeTypeAeronefItem() {
        return listeTypeAeronefItem;
    }

    /**
     * @param listeTypeAeronefItem the listeTypeAeronefItem to set
     */
    public void setListeTypeAeronefItem(List<SelectItem> listeTypeAeronefItem) {
        this.listeTypeAeronefItem = listeTypeAeronefItem;
    }

    /**
     * @return the selectedTypeAeronefItem
     */
    public String getSelectedTypeAeronefItem() {
        return selectedTypeAeronefItem;
    }

    /**
     * @param selectedTypeAeronefItem the selectedTypeAeronefItem to set
     */
    public void setSelectedTypeAeronefItem(String selectedTypeAeronefItem) {
        this.selectedTypeAeronefItem = selectedTypeAeronefItem;
    }

    /**
     * @return the selectedtypeaeronef
     */
    public TypeAeronef getSelectedtypeaeronef() {
        return selectedtypeaeronef;
    }

    /**
     * @param selectedtypeaeronef the selectedtypeaeronef to set
     */
    public void setSelectedtypeaeronef(TypeAeronef selectedtypeaeronef) {
        this.selectedtypeaeronef = selectedtypeaeronef;
    }

    /**
     * @return the id_type
     */
    public int getId_type() {
        return id_type;
    }

    /**
     * @param id_type the id_type to set
     */
    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    /**
     * @return the nom_type
     */
    public String getNom_type() {
        return nom_type;
    }

    /**
     * @param nom_type the nom_type to set
     */
    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    /**
     * @return the nb_moteur
     */
    public int getNb_moteur() {
        return nb_moteur;
    }

    /**
     * @param nb_moteur the nb_moteur to set
     */
    public void setNb_moteur(int nb_moteur) {
        this.nb_moteur = nb_moteur;
    }
    
}
