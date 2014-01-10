/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.beans;

import Metier.Proprietaire;
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
@ManagedBean(name="proprio_beans")
@SessionScoped()
public class Beans_Proprio implements Serializable
{
    private List<SelectItem> listePropriosItem;
    private String selectedProprioItem;
    
    private Proprietaire selectedproprio;
    
    private String nom;
    private String prenom;
    private String civ;
    private String societe;
    private String adresse1;
    private String adresse2;
    private String ville;
    private String nip;
    private String tel1;
    private String tel2;
    private String mail1;
    private String mail2;
    private String fax;
    private String prive;
    private String portable;
    private int id_proprio;

    public Beans_Proprio()
    {
        listePropriosItem = new ArrayList<SelectItem>();
        List<Proprietaire> proprioList = new DAO.DAO_Proprietaire().GET_ALL();
        for(Proprietaire proprio: proprioList)
        {
            listePropriosItem.add(new SelectItem(proprio.getId_proprio(), (proprio.getNom()+" " + proprio.getPrenom())));
        }
    }
    
    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AddProprio() throws Exception
    {
        Proprietaire proprio = new Proprietaire();
        proprio.setCivilite(civ);
        proprio.setNom(nom);
        proprio.setPrenom(prenom);
        proprio.setAdresse1(adresse1);
        proprio.setAdresse2(adresse2);
        proprio.setSociete(societe);
        proprio.setVille(ville);
        proprio.setNip(nip);
        proprio.setTel1(tel1);
        proprio.setTel2(tel2);
        proprio.setEmail(mail1);
        proprio.setEmail2(mail2);
        proprio.setFax(fax);
        proprio.setPrive(prive);
        proprio.setPortable(portable);
        
        int add = new DAO.DAO_Proprietaire().CREATE(proprio);
        if( add != 0 )
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le propriétaire a bien été ajouté!"));
            return "listProprietaire";
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";   
        }
    }
    
    public List<Proprietaire> GET_LIST()
    {
        return new DAO.DAO_Proprietaire().GET_ALL();
    }
    
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the civ
     */
    public String getCiv() {
        return civ;
    }

    /**
     * @param civ the civ to set
     */
    public void setCiv(String civ) {
        this.civ = civ;
    }

    /**
     * @return the societe
     */
    public String getSociete() {
        return societe;
    }

    /**
     * @param societe the societe to set
     */
    public void setSociete(String societe) {
        this.societe = societe;
    }

    /**
     * @return the adresse1
     */
    public String getAdresse1() {
        return adresse1;
    }

    /**
     * @param adresse1 the adresse1 to set
     */
    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    /**
     * @return the adresse2
     */
    public String getAdresse2() {
        return adresse2;
    }

    /**
     * @param adresse2 the adresse2 to set
     */
    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return the nip
     */
    public String getNip() {
        return nip;
    }

    /**
     * @param nip the nip to set
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

    /**
     * @return the tel1
     */
    public String getTel1() {
        return tel1;
    }

    /**
     * @param tel1 the tel1 to set
     */
    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    /**
     * @return the tel2
     */
    public String getTel2() {
        return tel2;
    }

    /**
     * @param tel2 the tel2 to set
     */
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    /**
     * @return the mail1
     */
    public String getMail1() {
        return mail1;
    }

    /**
     * @param mail1 the mail1 to set
     */
    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }

    /**
     * @return the mail2
     */
    public String getMail2() {
        return mail2;
    }

    /**
     * @param mail2 the mail2 to set
     */
    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the prive
     */
    public String getPrive() {
        return prive;
    }

    /**
     * @param prive the prive to set
     */
    public void setPrive(String prive) {
        this.prive = prive;
    }

    /**
     * @return the portable
     */
    public String getPortable() {
        return portable;
    }

    /**
     * @param portable the portable to set
     */
    public void setPortable(String portable) {
        this.portable = portable;
    }

    /**
     * @return the id_proprio
     */
    public int getId_proprio() {
        return id_proprio;
    }

    /**
     * @param id_proprio the id_proprio to set
     */
    public void setId_proprio(int id_proprio) {
        this.id_proprio = id_proprio;
    }

    /**
     * @return the selectedproprio
     */
    public Proprietaire getSelectedproprio() {
        return selectedproprio;
    }

    /**
     * @param selectedproprio the selectedproprio to set
     */
    public void setSelectedproprio(Proprietaire selectedproprio) {
        this.selectedproprio = selectedproprio;
    }

    /**
     * @return the listePropriosItem
     */
    public List<SelectItem> getListePropriosItem() {
        return listePropriosItem;
    }

    /**
     * @param listePropriosItem the listePropriosItem to set
     */
    public void setListePropriosItem(List<SelectItem> listePropriosItem) {
        this.listePropriosItem = listePropriosItem;
    }

    /**
     * @return the selectedProprioItem
     */
    public String getSelectedProprioItem() {
        return selectedProprioItem;
    }

    /**
     * @param selectedProprioItem the selectedProprioItem to set
     */
    public void setSelectedProprioItem(String selectedProprioItem) {
        this.selectedProprioItem = selectedProprioItem;
    }
}
