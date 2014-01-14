/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Compensation;
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
@ManagedBean(name="compensation_beans")
@SessionScoped()
public class Beans_Compensation implements Serializable{
    
    private List<SelectItem> listeCompensationItem;
    private String selectedCompensationItem;
    
    private Compensation selectedCompensation;
    
    private int id_compensation;
    private int num_rev;
    private Date date;
    private float ecartsN;
    private float ecartsE;
    private float ecartsS;
    private float ecartsW;
    private float ecarts45;
    private float ecarts135;
    private float ecarts225;
    private float ecarts315;
    private int id_moteur;

    public Beans_Compensation()
    {
        listeCompensationItem = new ArrayList<SelectItem>();
        List<Compensation> compensation = new DAO.DAO_Compensation().GET_ALL();
        for(Compensation compens: compensation)
        {
            listeCompensationItem.add(new SelectItem(compens.getId_compensation()));
        }
    }
    
    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AddCompensation() throws Exception
    {
        Compensation comp = new Compensation();
        comp.setId_compensation(getId_compensation());
        comp.setNum_rev(getNum_rev());
        comp.setDate(getDate());
        comp.setEcartsN(getEcartsN());
        comp.setEcartsE(getEcartsE());
        comp.setEcartsW(getEcartsW());
        comp.setEcartsS(getEcartsS());
        comp.setEcarts45(getEcarts45());
        comp.setEcarts135(getEcarts135());
        comp.setEcarts225(getEcarts225());
        comp.setEcarts315(getEcarts315());
        comp.setId_moteur(getId_moteur());
        
        int add = new DAO.DAO_Compensation().CREATE(comp);
        if( add != 0 )
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "La Compensation a bien été ajouté!"));
            return "listCompensation";
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";   
        }
    }
    
    public List<Compensation> GET_LIST()
    {
        return new DAO.DAO_Compensation().GET_ALL();
    }

    /**
     * @return the listeCompensationItem
     */
    public List<SelectItem> getListeCompensationItem() {
        return listeCompensationItem;
    }

    /**
     * @param listeCompensationItem the listeCompensationItem to set
     */
    public void setListeCompensationItem(List<SelectItem> listeCompensationItem) {
        this.listeCompensationItem = listeCompensationItem;
    }

    /**
     * @return the selectedCompensationItem
     */
    public String getSelectedCompensationItem() {
        return selectedCompensationItem;
    }

    /**
     * @param selectedCompensationItem the selectedCompensationItem to set
     */
    public void setSelectedCompensationItem(String selectedCompensationItem) {
        this.selectedCompensationItem = selectedCompensationItem;
    }

    /**
     * @return the selectedCompensation
     */
    public Compensation getSelectedCompensation() {
        return selectedCompensation;
    }

    /**
     * @param selectedCompensation the selectedCompensation to set
     */
    public void setSelectedCompensation(Compensation selectedCompensation) {
        this.selectedCompensation = selectedCompensation;
    }

    /**
     * @return the id_compensation
     */
    public int getId_compensation() {
        return id_compensation;
    }

    /**
     * @param id_compensation the id_compensation to set
     */
    public void setId_compensation(int id_compensation) {
        this.id_compensation = id_compensation;
    }

    /**
     * @return the num_rev
     */
    public int getNum_rev() {
        return num_rev;
    }

    /**
     * @param num_rev the num_rev to set
     */
    public void setNum_rev(int num_rev) {
        this.num_rev = num_rev;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the ecartsN
     */
    public float getEcartsN() {
        return ecartsN;
    }

    /**
     * @param ecartsN the ecartsN to set
     */
    public void setEcartsN(float ecartsN) {
        this.ecartsN = ecartsN;
    }

    /**
     * @return the ecartsE
     */
    public float getEcartsE() {
        return ecartsE;
    }

    /**
     * @param ecartsE the ecartsE to set
     */
    public void setEcartsE(float ecartsE) {
        this.ecartsE = ecartsE;
    }

    /**
     * @return the ecartsS
     */
    public float getEcartsS() {
        return ecartsS;
    }

    /**
     * @param ecartsS the ecartsS to set
     */
    public void setEcartsS(float ecartsS) {
        this.ecartsS = ecartsS;
    }

    /**
     * @return the ecartsW
     */
    public float getEcartsW() {
        return ecartsW;
    }

    /**
     * @param ecartsW the ecartsW to set
     */
    public void setEcartsW(float ecartsW) {
        this.ecartsW = ecartsW;
    }

    /**
     * @return the ecarts45
     */
    public float getEcarts45() {
        return ecarts45;
    }

    /**
     * @param ecarts45 the ecarts45 to set
     */
    public void setEcarts45(float ecarts45) {
        this.ecarts45 = ecarts45;
    }

    /**
     * @return the ecarts135
     */
    public float getEcarts135() {
        return ecarts135;
    }

    /**
     * @param ecarts135 the ecarts135 to set
     */
    public void setEcarts135(float ecarts135) {
        this.ecarts135 = ecarts135;
    }

    /**
     * @return the ecarts225
     */
    public float getEcarts225() {
        return ecarts225;
    }

    /**
     * @param ecarts225 the ecarts225 to set
     */
    public void setEcarts225(float ecarts225) {
        this.ecarts225 = ecarts225;
    }

    /**
     * @return the ecarts315
     */
    public float getEcarts315() {
        return ecarts315;
    }

    /**
     * @param ecarts315 the ecarts315 to set
     */
    public void setEcarts315(float ecarts315) {
        this.ecarts315 = ecarts315;
    }

    /**
     * @return the id_moteur
     */
    public int getId_moteur() {
        return id_moteur;
    }

    /**
     * @param id_moteur the id_moteur to set
     */
    public void setId_moteur(int id_moteur) {
        this.id_moteur = id_moteur;
    }

   

  
    
}



