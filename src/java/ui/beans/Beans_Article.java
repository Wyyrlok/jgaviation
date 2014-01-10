/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import DAO.DAO_Article;
import Metier.Article;
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
@ManagedBean(name="article_beans")
@SessionScoped()
public class Beans_Article implements Serializable{

    private Article selectedArt;
    private int id_article;
    private String designation;
    private String part_nb_const;
    private int id_const;
    private float prix_vte_article;
    private boolean bPeremption;
    private boolean bSerialNb;
    private int stock_mini;
    
    private List<SelectItem> listeArtItem;
    private String selectedArtItem;
    private String selectedConstrItem;
    private List<SelectItem> listeConstrItem;


    public Beans_Article()
    {
        listeArtItem = new ArrayList<SelectItem>();
        List<Article> artList = new DAO.DAO_Article().GET_ALL();
        for(Article article: artList)
        {
            listeArtItem.add(new SelectItem(article.getId_article(), article.getPart_nb_const()));
        }
        
        listeConstrItem = new ArrayList<SelectItem>();
        List<Constructeur> proprioList = new DAO.DAO_Constructeur().GET_ALL();
        for(Constructeur constr: proprioList)
        {
            listeConstrItem.add(new SelectItem(constr.getId_const(), constr.getNom_const()));
        }
    }
    
    public List<Article> getList(){
        return new DAO_Article().GET_ALL();
    }

    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AddArticle() throws Exception
    {
        Article art = new Article();
        art.setDesignation(getDesignation());
        art.setPart_nb_const(getPart_nb_const());
        art.setId_const(getId_const());
        art.setPrix_vte_article(getPrix_vte_article());
        art.setbPeremption(isbPeremption());
        art.setbSerialNb(isbSerialNb());
        art.setStock_mini(getStock_mini());
       
        
        int add = new DAO.DAO_Article().CREATE(art);
        if( add != 0 )
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "L'Article a bien été ajouté!"));
            return "listArticle";
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";   
        }
    }
    
    public List<Article> GET_LIST()
    {
        return new DAO.DAO_Article().GET_ALL();
    }

    /**
     * @return the art
     */
    public Article getSelectedArt() {
        return selectedArt;
    }

    /**
     * @param art the art to set
     */
    public void setSelectedArt(Article art) {
        this.selectedArt = selectedArt;
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
     * @return the part_nb_const
     */
    public String getPart_nb_const() {
        return part_nb_const;
    }

    /**
     * @param part_nb_const the part_nb_const to set
     */
    public void setPart_nb_const(String part_nb_const) {
        this.part_nb_const = part_nb_const;
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
     * @return the prix_vte_article
     */
    public float getPrix_vte_article() {
        return prix_vte_article;
    }

    /**
     * @param prix_vte_article the prix_vte_article to set
     */
    public void setPrix_vte_article(float prix_vte_article) {
        this.prix_vte_article = prix_vte_article;
    }

    /**
     * @return the bPeremption
     */
    public boolean isbPeremption() {
        return bPeremption;
    }

    /**
     * @param bPeremption the bPeremption to set
     */
    public void setbPeremption(boolean bPeremption) {
        this.bPeremption = bPeremption;
    }

    /**
     * @return the bSerialNb
     */
    public boolean isbSerialNb() {
        return bSerialNb;
    }

    /**
     * @param bSerialNb the bSerialNb to set
     */
    public void setbSerialNb(boolean bSerialNb) {
        this.bSerialNb = bSerialNb;
    }

    /**
     * @return the stock_mini
     */
    public int getStock_mini() {
        return stock_mini;
    }

    /**
     * @param stock_mini the stock_mini to set
     */
    public void setStock_mini(int stock_mini) {
        this.stock_mini = stock_mini;
    }

    /**
     * @return the id_article
     */
    public int getId_article() {
        return id_article;
    }

    /**
     * @param id_article the id_article to set
     */
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    /**
     * @return the selectedArtItem
     */
    public String getSelectedArtItem() {
        return selectedArtItem;
    }

    /**
     * @param selectedArtItem the selectedArtItem to set
     */
    public void setSelectedArtItem(String selectedArtItem) {
        this.selectedArtItem = selectedArtItem;
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

    /**
     * @return the listeConstrItem
     */
    public List<SelectItem> getListeConstrItem() {
        return listeConstrItem;
    }

    /**
     * @param listeConstrItem the listeConstrItem to set
     */
    public void setListeConstrItem(List<SelectItem> listeConstrItem) {
        this.listeConstrItem = listeConstrItem;
    }
    
   
}
