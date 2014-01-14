/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Nb_Cycle;
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
@ManagedBean(name = "nbCycle_beans")
@SessionScoped()
public class Beans_Nb_Cycle implements Serializable{
    

    private List<SelectItem> listeNbCycleItem;
    private String selectedNbCycleItem;
    private Nb_Cycle selectednbcycle;
    private int id_NbCyle;
    private int id_cycle;
    private Date date_vol;
    private int nb_cycle;


    public Beans_Nb_Cycle() {
        listeNbCycleItem = new ArrayList<SelectItem>();
        List<Nb_Cycle> cycle = new DAO.DAO_NB_Cycle().GET_ALL();
        for (Nb_Cycle nbcy : cycle) {
            listeNbCycleItem.add(new SelectItem(nbcy.getId_NbCyle()));
        }
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddNbCycle() throws Exception {
        
        Nb_Cycle cycle = new Nb_Cycle();
        cycle.setId_NbCyle(getId_NbCyle());
        cycle.setId_cycle(getId_cycle());
        cycle.setDate_vol(getDate_vol());
        cycle.setNb_cycle(getNb_cycle());


        int add = new DAO.DAO_NB_Cycle().CREATE(cycle);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le Nombre de Cycle a bien été ajouté!"));
            return "listNbCycle";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<Nb_Cycle> GET_LIST() {
        return new DAO.DAO_NB_Cycle().GET_ALL();
    }

    /**
     * @return the listeNbCycleItem
     */
    public List<SelectItem> getListeNbCycleItem() {
        return listeNbCycleItem;
    }

    /**
     * @param listeNbCycleItem the listeNbCycleItem to set
     */
    public void setListeNbCycleItem(List<SelectItem> listeNbCycleItem) {
        this.listeNbCycleItem = listeNbCycleItem;
    }

    /**
     * @return the selectedNbCycleItem
     */
    public String getSelectedNbCycleItem() {
        return selectedNbCycleItem;
    }

    /**
     * @param selectedNbCycleItem the selectedNbCycleItem to set
     */
    public void setSelectedNbCycleItem(String selectedNbCycleItem) {
        this.selectedNbCycleItem = selectedNbCycleItem;
    }

    /**
     * @return the selectednbcycle
     */
    public Nb_Cycle getSelectednbcycle() {
        return selectednbcycle;
    }

    /**
     * @param selectednbcycle the selectednbcycle to set
     */
    public void setSelectednbcycle(Nb_Cycle selectednbcycle) {
        this.selectednbcycle = selectednbcycle;
    }

    /**
     * @return the id_NbCyle
     */
    public int getId_NbCyle() {
        return id_NbCyle;
    }

    /**
     * @param id_NbCyle the id_NbCyle to set
     */
    public void setId_NbCyle(int id_NbCyle) {
        this.id_NbCyle = id_NbCyle;
    }

    /**
     * @return the id_cycle
     */
    public int getId_cycle() {
        return id_cycle;
    }

    /**
     * @param id_cycle the id_cycle to set
     */
    public void setId_cycle(int id_cycle) {
        this.id_cycle = id_cycle;
    }

    /**
     * @return the date_vol
     */
    public Date getDate_vol() {
        return date_vol;
    }

    /**
     * @param date_vol the date_vol to set
     */
    public void setDate_vol(Date date_vol) {
        this.date_vol = date_vol;
    }

    /**
     * @return the nb_cycle
     */
    public int getNb_cycle() {
        return nb_cycle;
    }

    /**
     * @param nb_cycle the nb_cycle to set
     */
    public void setNb_cycle(int nb_cycle) {
        this.nb_cycle = nb_cycle;
    }
}
