/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.CN_Equipement;
import Metier.CN_Helice;
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
@ManagedBean(name="cn_helice_beans")
@SessionScoped()
public class Beans_CN_Helice implements Serializable{
    
    
    private List<SelectItem> listeCnHeliceItem;
    private String selectedCnHeliceItem;
    
    private CN_Helice selectedCnHelice;
    
    private int id_CN_Helice;
    private String id_moteur;
    private Date date_ajt;
    private String reference;
    private String SB;
    private String objet;
    private String applicabilite;
    private float rep_i_m;
    private float rep_he;
    private float rep_cy;
    private Date exe_date;
    private float exe_he;
    private float exe_cy;
    private boolean bAnnul; 

    public Beans_CN_Helice()
    {
        listeCnHeliceItem = new ArrayList<SelectItem>();
        List<CN_Helice> cnHelice = new DAO.DAO_CN_Helice().GET_ALL();
        for(CN_Helice cn_helice: cnHelice)
        {
            listeCnHeliceItem.add(new SelectItem(cn_helice.getId_CN_Helice()));
        }
    }
    
    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AddCN_Helice() throws Exception
    {
        CN_Helice cn_Helice = new CN_Helice();
        cn_Helice.setId_CN_Helice(getId_CN_Helice());
        cn_Helice.setId_moteur(getId_moteur());
        cn_Helice.setDate_ajt(getDate_ajt());
        cn_Helice.setReference(getReference());
        cn_Helice.setSB(getSB());
        cn_Helice.setObjet(getObjet());
        cn_Helice.setApplicabilite(getApplicabilite());
        cn_Helice.setRep_i_m(getRep_i_m());
        cn_Helice.setRep_he(getRep_he());
        cn_Helice.setRep_cy(getRep_cy());
        cn_Helice.setExe_cy(getExe_cy());
        cn_Helice.setExe_date(getExe_date());
        cn_Helice.setExe_he(getExe_cy());
        cn_Helice.setbAnnul(isbAnnul());
        
        int add = new DAO.DAO_CN_Helice().CREATE(cn_Helice);
        if( add != 0 )
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le CN de l'helice a bien été ajouté!"));
            return "listCn_Helice";
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";   
        }
    }
    
    public List<CN_Helice> GET_LIST()
    {
        return new DAO.DAO_CN_Helice().GET_ALL();
    }

    /**
     * @return the listeCnHeliceItem
     */
    public List<SelectItem> getListeCnHeliceItem() {
        return listeCnHeliceItem;
    }

    /**
     * @param listeCnHeliceItem the listeCnHeliceItem to set
     */
    public void setListeCnHeliceItem(List<SelectItem> listeCnHeliceItem) {
        this.listeCnHeliceItem = listeCnHeliceItem;
    }

    /**
     * @return the selectedCnHeliceItem
     */
    public String getSelectedCnHeliceItem() {
        return selectedCnHeliceItem;
    }

    /**
     * @param selectedCnHeliceItem the selectedCnHeliceItem to set
     */
    public void setSelectedCnHeliceItem(String selectedCnHeliceItem) {
        this.selectedCnHeliceItem = selectedCnHeliceItem;
    }

    /**
     * @return the selectedCnHelice
     */
    public CN_Helice getSelectedCnHelice() {
        return selectedCnHelice;
    }

    /**
     * @param selectedCnHelice the selectedCnHelice to set
     */
    public void setSelectedCnHelice(CN_Helice selectedCnHelice) {
        this.selectedCnHelice = selectedCnHelice;
    }

    /**
     * @return the id_CN_Helice
     */
    public int getId_CN_Helice() {
        return id_CN_Helice;
    }

    /**
     * @param id_CN_Helice the id_CN_Helice to set
     */
    public void setId_CN_Helice(int id_CN_Helice) {
        this.id_CN_Helice = id_CN_Helice;
    }

    /**
     * @return the id_moteur
     */
    public String getId_moteur() {
        return id_moteur;
    }

    /**
     * @param id_moteur the id_moteur to set
     */
    public void setId_moteur(String id_moteur) {
        this.id_moteur = id_moteur;
    }

    /**
     * @return the date_ajt
     */
    public Date getDate_ajt() {
        return date_ajt;
    }

    /**
     * @param date_ajt the date_ajt to set
     */
    public void setDate_ajt(Date date_ajt) {
        this.date_ajt = date_ajt;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the SB
     */
    public String getSB() {
        return SB;
    }

    /**
     * @param SB the SB to set
     */
    public void setSB(String SB) {
        this.SB = SB;
    }

    /**
     * @return the objet
     */
    public String getObjet() {
        return objet;
    }

    /**
     * @param objet the objet to set
     */
    public void setObjet(String objet) {
        this.objet = objet;
    }

    /**
     * @return the applicabilite
     */
    public String getApplicabilite() {
        return applicabilite;
    }

    /**
     * @param applicabilite the applicabilite to set
     */
    public void setApplicabilite(String applicabilite) {
        this.applicabilite = applicabilite;
    }

    /**
     * @return the rep_i_m
     */
    public float getRep_i_m() {
        return rep_i_m;
    }

    /**
     * @param rep_i_m the rep_i_m to set
     */
    public void setRep_i_m(float rep_i_m) {
        this.rep_i_m = rep_i_m;
    }

    /**
     * @return the rep_he
     */
    public float getRep_he() {
        return rep_he;
    }

    /**
     * @param rep_he the rep_he to set
     */
    public void setRep_he(float rep_he) {
        this.rep_he = rep_he;
    }

    /**
     * @return the rep_cy
     */
    public float getRep_cy() {
        return rep_cy;
    }

    /**
     * @param rep_cy the rep_cy to set
     */
    public void setRep_cy(float rep_cy) {
        this.rep_cy = rep_cy;
    }

    /**
     * @return the exe_date
     */
    public Date getExe_date() {
        return exe_date;
    }

    /**
     * @param exe_date the exe_date to set
     */
    public void setExe_date(Date exe_date) {
        this.exe_date = exe_date;
    }

    /**
     * @return the exe_he
     */
    public float getExe_he() {
        return exe_he;
    }

    /**
     * @param exe_he the exe_he to set
     */
    public void setExe_he(float exe_he) {
        this.exe_he = exe_he;
    }

    /**
     * @return the exe_cy
     */
    public float getExe_cy() {
        return exe_cy;
    }

    /**
     * @param exe_cy the exe_cy to set
     */
    public void setExe_cy(float exe_cy) {
        this.exe_cy = exe_cy;
    }

    /**
     * @return the bAnnul
     */
    public boolean isbAnnul() {
        return bAnnul;
    }

    /**
     * @param bAnnul the bAnnul to set
     */
    public void setbAnnul(boolean bAnnul) {
        this.bAnnul = bAnnul;
    }

  
    
}


