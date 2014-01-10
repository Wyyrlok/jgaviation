/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Constructeur;
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
@ManagedBean(name = "construct_beans")
@SessionScoped()
public class Beans_Constructeur implements Serializable {

    private Constructeur selectedConstruct;
    private int id_const;
    private String nom_const;
    private String selectedConstrItem;
    private List<SelectItem> listeConstrItem;
    
    
    public Beans_Constructeur()
    {
        listeConstrItem = new ArrayList<SelectItem>();
        List<Constructeur> proprioList = new DAO.DAO_Constructeur().GET_ALL();
        for(Constructeur proprio: proprioList)
        {
            listeConstrItem.add(new SelectItem(proprio.getNom_const()));
        }
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddConstructeur() throws Exception {

        Constructeur construct = new Constructeur();
        construct.setNom_const(getNom_const());

        int add = new DAO.DAO_Constructeur().CREATE(construct);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le constructeur a bien été ajouté!"));
            return "listConstructeur";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<Constructeur> GET_LIST() {
        return new DAO.DAO_Constructeur().GET_ALL();
    }

    /**
     * @return the selectedConstruct
     */
    public Constructeur getSelectedConstruct() {
        return selectedConstruct;
    }

    /**
     * @param selectedConstruct the selectedConstruct to set
     */
    public void setSelectedConstruct(Constructeur selectedConstruct) {
        this.selectedConstruct = selectedConstruct;
    }

    /**
     * @return the id_const
     */
    public int getId_const() {
        return id_const;
    }

    /**
     * @param id_const the id_const to set
     */
    public void setId_const(int id_const) {
        this.id_const = id_const;
    }

    /**
     * @return the nom_const
     */
    public String getNom_const() {
        return nom_const;
    }

    /**
     * @param nom_const the nom_const to set
     */
    public void setNom_const(String nom_const) {
        this.nom_const = nom_const;
    }

    /**
     * @return the selectedConstrItem
     */
    public String getSelectedConstrItem() {
        return selectedConstrItem;
    }

    /**
     * @param selectedConstrItem the selectedConstrItem to set
     */
    public void setSelectedConstrItem(String selectedConstrItem) {
        this.selectedConstrItem = selectedConstrItem;
    }
}
