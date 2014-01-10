/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.beans;

import Metier.Profil_Utilisateur;
import Metier.Proprietaire;
import Metier.Utilisateur;
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
 * @author Fabien
 */
@ManagedBean(name="util_beans")
@SessionScoped()
public class Beans_Util implements Serializable
{
    private List<SelectItem> listeCategoriesItem;
    private String add_prenom;
    private String add_nom;
    private String add_pwd1;
    private String add_pwd2;
    private String add_login;
    private String add_selecteditem;
    
    public Beans_Util()
    {
        listeCategoriesItem = new ArrayList<SelectItem>();
        List<Profil_Utilisateur> categoryList = new DAO.DAO_Profil_Utilisateur().GET_ALL();
        for(Profil_Utilisateur category: categoryList)
        {
            listeCategoriesItem.add(new SelectItem(category.getId_profil(), category.getNom_profil()));
        }
    }
    
    public String AddUser() throws Exception
    {
        System.out.println("ADD_NEW_USER");
        Utilisateur user = new Utilisateur();
        user.setsPrenom(add_prenom);
        user.setsNom(add_nom);
        user.setsLogin(add_login);
        user.setsPassword(add_pwd1);
        user.setId_profil( Integer.parseInt(add_selecteditem));
        
        System.out.println(add_prenom);
        
        if(add_pwd1.equals(add_pwd2))
        {
            int add = new DAO.DAO_Utilisateur().CREATE(user);
            if( add != 0 )
            {
                addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "L'utilisateur a bien été ajouté!"));
                return "listUtilisateur";
            }
            else
            {
                addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
                return "";   
            }
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_WARN, "Information : ", "Les mots de passe ne correspondent pas!"));
            return ""; 
        }
    }
    
    public List<Utilisateur> GET_LIST()
    {
        return new DAO.DAO_Utilisateur().GET_ALL();
    }
    
    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    /**
     * @return the add_prenom
     */
    public String getAdd_prenom() {
        return add_prenom;
    }

    /**
     * @param add_prenom the add_prenom to set
     */
    public void setAdd_prenom(String add_prenom) {
        this.add_prenom = add_prenom;
    }

    /**
     * @return the add_nom
     */
    public String getAdd_nom() {
        return add_nom;
    }

    /**
     * @param add_nom the add_nom to set
     */
    public void setAdd_nom(String add_nom) {
        this.add_nom = add_nom;
    }

    /**
     * @return the add_pwd1
     */
    public String getAdd_pwd1() {
        return add_pwd1;
    }

    /**
     * @param add_pwd1 the add_pwd1 to set
     */
    public void setAdd_pwd1(String add_pwd1) {
        this.add_pwd1 = add_pwd1;
    }

    /**
     * @return the add_pwd2
     */
    public String getAdd_pwd2() {
        return add_pwd2;
    }

    /**
     * @param add_pwd2 the add_pwd2 to set
     */
    public void setAdd_pwd2(String add_pwd2) {
        this.add_pwd2 = add_pwd2;
    }

    /**
     * @return the add_login
     */
    public String getAdd_login() {
        return add_login;
    }

    /**
     * @param add_login the add_login to set
     */
    public void setAdd_login(String add_login) {
        this.add_login = add_login;
    }

    /**
     * @return the add_selecteditem
     */
    public String getAdd_selecteditem() {
        return add_selecteditem;
    }

    /**
     * @param add_selecteditem the add_selecteditem to set
     */
    public void setAdd_selecteditem(String add_selecteditem) {
        this.add_selecteditem = add_selecteditem;
    }

    /**
     * @return the listeCategoriesItem
     */
    public List<SelectItem> getListeCategoriesItem() {
        return listeCategoriesItem;
    }

    /**
     * @param listeCategoriesItem the listeCategoriesItem to set
     */
    public void setListeCategoriesItem(List<SelectItem> listeCategoriesItem) {
        this.listeCategoriesItem = listeCategoriesItem;
    }
}
