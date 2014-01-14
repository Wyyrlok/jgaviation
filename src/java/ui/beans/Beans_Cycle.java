/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Cycle;
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

@ManagedBean(name="cycle_beans")
@SessionScoped()
public class Beans_Cycle implements Serializable{


    private List<SelectItem> listeCycleItem;
    private String selectedCycleItem;
    
    private Cycle selectedCycle;
    private int id_Cycle;
    private String nom_Equipement;
    private String immat;
    private int bModeFacteur;
    private float nFacteur;


    public Beans_Cycle()
    {
        listeCycleItem = new ArrayList<SelectItem>();
        List<Cycle> cycleList = new DAO.DAO_Cycle().GET_ALL();
        for(Cycle cycle: cycleList)
        {
            listeCycleItem.add(new SelectItem(cycle.getId_Cycle()));
        }
    }
    
    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AddCycle() throws Exception
    {
        Cycle cycle = new Cycle();
        cycle.setId_Cycle(getId_Cycle());
        cycle.setNom_Equipement(getNom_Equipement());
        cycle.setImmat(getImmat());
        cycle.setbModeFacteur(getbModeFacteur());
        cycle.setnFacteur(getnFacteur());
        
        int add = new DAO.DAO_Cycle().CREATE(cycle);
        if( add != 0 )
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le Cycle a bien été ajouté!"));
            return "listCycle";
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";   
        }
    }
    
    public List<Cycle> GET_LIST()
    {
        return new DAO.DAO_Cycle().GET_ALL();
    }

    /**
     * @return the listeCycleItem
     */
    public List<SelectItem> getListeCycleItem() {
        return listeCycleItem;
    }

    /**
     * @param listeCycleItem the listeCycleItem to set
     */
    public void setListeCycleItem(List<SelectItem> listeCycleItem) {
        this.listeCycleItem = listeCycleItem;
    }

    /**
     * @return the selectedCycleItem
     */
    public String getSelectedCycleItem() {
        return selectedCycleItem;
    }

    /**
     * @param selectedCycleItem the selectedCycleItem to set
     */
    public void setSelectedCycleItem(String selectedCycleItem) {
        this.selectedCycleItem = selectedCycleItem;
    }

    /**
     * @return the selectedCycle
     */
    public Cycle getSelectedCycle() {
        return selectedCycle;
    }

    /**
     * @param selectedCycle the selectedCycle to set
     */
    public void setSelectedCycle(Cycle selectedCycle) {
        this.selectedCycle = selectedCycle;
    }

    /**
     * @return the id_Cycle
     */
    public int getId_Cycle() {
        return id_Cycle;
    }

    /**
     * @param id_Cycle the id_Cycle to set
     */
    public void setId_Cycle(int id_Cycle) {
        this.id_Cycle = id_Cycle;
    }

    /**
     * @return the nom_Equipement
     */
    public String getNom_Equipement() {
        return nom_Equipement;
    }

    /**
     * @param nom_Equipement the nom_Equipement to set
     */
    public void setNom_Equipement(String nom_Equipement) {
        this.nom_Equipement = nom_Equipement;
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
     * @return the bModeFacteur
     */
    public int getbModeFacteur() {
        return bModeFacteur;
    }

    /**
     * @param bModeFacteur the bModeFacteur to set
     */
    public void setbModeFacteur(int bModeFacteur) {
        this.bModeFacteur = bModeFacteur;
    }

    /**
     * @return the nFacteur
     */
    public float getnFacteur() {
        return nFacteur;
    }

    /**
     * @param nFacteur the nFacteur to set
     */
    public void setnFacteur(float nFacteur) {
        this.nFacteur = nFacteur;
    }
    
    
}

