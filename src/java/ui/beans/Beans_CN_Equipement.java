/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.CN_Equipement;
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
@ManagedBean(name="cn_equip_beans")
@SessionScoped()
public class Beans_CN_Equipement implements Serializable{
   


    private List<SelectItem> listeCnEquipItem;
    private String selectedCnEquipItem;
    
    private CN_Equipement selectedCnEquip;
    
     private int id_CN_Equipement;
    private String immat;
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
    


    public Beans_CN_Equipement()
    {
        listeCnEquipItem = new ArrayList<SelectItem>();
        List<CN_Equipement> cnEquip = new DAO.DAO_CN_Equipement().GET_ALL();
        for(CN_Equipement cn_equip: cnEquip)
        {
            listeCnEquipItem.add(new SelectItem(cn_equip.getImmat()));
        }
    }
    
    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AddProprio() throws Exception
    {
        CN_Equipement cn_Equip = new CN_Equipement();
        cn_Equip.setId_CN_Equipement(getId_CN_Equipement());
        cn_Equip.setImmat(getImmat());
        cn_Equip.setDate_ajt(getDate_ajt());
        cn_Equip.setReference(getReference());
        cn_Equip.setSB(getSB());
        cn_Equip.setObjet(getObjet());
        cn_Equip.setApplicabilite(getApplicabilite());
        cn_Equip.setRep_i_m(getRep_i_m());
        cn_Equip.setRep_he(getRep_he());
        cn_Equip.setRep_cy(getRep_cy());
        cn_Equip.setExe_cy(getExe_cy());
        cn_Equip.setExe_date(getExe_date());
        cn_Equip.setExe_he(getExe_cy());
        cn_Equip.setbAnnul(isbAnnul());
        
        int add = new DAO.DAO_CN_Equipement().CREATE(cn_Equip);
        if( add != 0 )
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le CN de l'équipement a bien été ajouté!"));
            return "listCn_Equipe";
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";   
        }
    }
    
    public List<CN_Equipement> GET_LIST()
    {
        return new DAO.DAO_CN_Equipement().GET_ALL();
    }

    /**
     * @return the listeCnEquipItem
     */
    public List<SelectItem> getListeCnEquipItem() {
        return listeCnEquipItem;
    }

    /**
     * @param listeCnEquipItem the listeCnEquipItem to set
     */
    public void setListeCnEquipItem(List<SelectItem> listeCnEquipItem) {
        this.listeCnEquipItem = listeCnEquipItem;
    }

    /**
     * @return the selectedCnEquipItem
     */
    public String getSelectedCnEquipItem() {
        return selectedCnEquipItem;
    }

    /**
     * @param selectedCnEquipItem the selectedCnEquipItem to set
     */
    public void setSelectedCnEquipItem(String selectedCnEquipItem) {
        this.selectedCnEquipItem = selectedCnEquipItem;
    }

    /**
     * @return the selectedCnEquip
     */
    public CN_Equipement getSelectedCnCel() {
        return selectedCnEquip;
    }

    /**
     * @param selectedCnEquip the selectedCnEquip to set
     */
    public void setSelectedCnCel(CN_Equipement selectedCnCel) {
        this.selectedCnEquip = selectedCnCel;
    }

    /**
     * @return the id_CN_Equipement
     */
    public int getId_CN_Equipement() {
        return id_CN_Equipement;
    }

    /**
     * @param id_CN_Equipement the id_CN_Equipement to set
     */
    public void setId_CN_Equipement(int id_CN_Equipement) {
        this.id_CN_Equipement = id_CN_Equipement;
    }

    /**
     * @return the immat
     */
    public String getImmat() {
        return immat;
    }

    /**
     * @param immat the immat to set
     */
    public void setImmat(String immat) {
        this.immat = immat;
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


