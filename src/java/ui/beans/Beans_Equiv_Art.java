/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Equiv_Art;
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
@ManagedBean(name="equivArt_beans")
@SessionScoped()
public class Beans_Equiv_Art implements Serializable{
    
    

    private List<SelectItem> listeArtEquivItem;
    private String selectedArtEquivItem;
    
    private Equiv_Art selectedArtEquiv;
    private int id_art;
    private int id_art_equiv;



    public Beans_Equiv_Art()
    {
        listeArtEquivItem = new ArrayList<SelectItem>();
        List<Equiv_Art> equivArt = new DAO.DAO_Equiv_Art().GET_ALL();
        for(Equiv_Art equiv: equivArt)
        {
            listeArtEquivItem.add(new SelectItem(equiv.getId_art()));
        }
    }
    
    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AddEquivArt() throws Exception
    {
        Equiv_Art equiv = new Equiv_Art();
        equiv.setId_art(getId_art());
        equiv.setId_art_equiv(getId_art_equiv());

        
        int add = new DAO.DAO_Equiv_Art().CREATE(equiv);
        if( add != 0 )
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "L'équivalence article a bien été ajouté!"));
            return "listEquivArt";
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";   
        }
    }
    
    public List<Equiv_Art> GET_LIST()
    {
        return new DAO.DAO_Equiv_Art().GET_ALL();
    }

    /**
     * @return the listeArtEquivItem
     */
    public List<SelectItem> getListeArtEquivItem() {
        return listeArtEquivItem;
    }

    /**
     * @param listeArtEquivItem the listeArtEquivItem to set
     */
    public void setListeArtEquivItem(List<SelectItem> listeArtEquivItem) {
        this.listeArtEquivItem = listeArtEquivItem;
    }

    /**
     * @return the selectedArtEquivItem
     */
    public String getSelectedArtEquivItem() {
        return selectedArtEquivItem;
    }

    /**
     * @param selectedArtEquivItem the selectedArtEquivItem to set
     */
    public void setSelectedArtEquivItem(String selectedArtEquivItem) {
        this.selectedArtEquivItem = selectedArtEquivItem;
    }

    /**
     * @return the selectedArtEquiv
     */
    public Equiv_Art getSelectedArtEquiv() {
        return selectedArtEquiv;
    }

    /**
     * @param selectedArtEquiv the selectedArtEquiv to set
     */
    public void setSelectedArtEquiv(Equiv_Art selectedArtEquiv) {
        this.selectedArtEquiv = selectedArtEquiv;
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
     * @return the id_art_equiv
     */
    public int getId_art_equiv() {
        return id_art_equiv;
    }

    /**
     * @param id_art_equiv the id_art_equiv to set
     */
    public void setId_art_equiv(int id_art_equiv) {
        this.id_art_equiv = id_art_equiv;
    }

  
    
}


