/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Maintenance;
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

@ManagedBean(name="maintenance_beans")
@SessionScoped()
public class Beans_Maintenance implements Serializable{
   

    private List<SelectItem> listeMaintenanceItem;
    private String selectedInstructWOItem;
    
    private Maintenance selectedInstructWO;
    private int id_Maintenance;
    private String designation;
    private float duree_presta;
    private String descritpion;
    private float nHeure;
    private float nDuree;
    private float nHeureBut;
    private float nDureeBut;



    public Beans_Maintenance()
    {
        listeMaintenanceItem = new ArrayList<SelectItem>();
        List<Maintenance> main = new DAO.DAO_Maintenance().GET_ALL();
        for(Maintenance maintenance: main)
        {
            listeMaintenanceItem.add(new SelectItem(maintenance.getId_Maintenance()));
        }
    }
    
    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AddMaintenance() throws Exception
    {
        Maintenance main = new Maintenance();
        main.setId_Maintenance(getId_Maintenance());
        main.setDesignation(getDesignation());
        main.setDuree_presta(getDuree_presta());
        main.setDescritpion(getDescritpion());
        main.setnHeure(getnHeure());
        main.setnDuree(getnDuree());
        main.setnHeureBut(getnHeureBut());
        main.setnDureeBut(getnDureeBut());
        

        
        int add = new DAO.DAO_Maintenance().CREATE(main);
        if( add != 0 )
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "La Maintenance a bien été ajouté!"));
            return "listMaintenance";
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";   
        }
    }
    
    public List<Maintenance> GET_LIST()
    {
        return new DAO.DAO_Maintenance().GET_ALL();
    }  

    /**
     * @return the listeMaintenanceItem
     */
    public List<SelectItem> getListeMaintenanceItem() {
        return listeMaintenanceItem;
    }

    /**
     * @param listeMaintenanceItem the listeMaintenanceItem to set
     */
    public void setListeMaintenanceItem(List<SelectItem> listeMaintenanceItem) {
        this.listeMaintenanceItem = listeMaintenanceItem;
    }

    /**
     * @return the selectedInstructWOItem
     */
    public String getSelectedInstructWOItem() {
        return selectedInstructWOItem;
    }

    /**
     * @param selectedInstructWOItem the selectedInstructWOItem to set
     */
    public void setSelectedInstructWOItem(String selectedInstructWOItem) {
        this.selectedInstructWOItem = selectedInstructWOItem;
    }

    /**
     * @return the selectedInstructWO
     */
    public Maintenance getSelectedInstructWO() {
        return selectedInstructWO;
    }

    /**
     * @param selectedInstructWO the selectedInstructWO to set
     */
    public void setSelectedInstructWO(Maintenance selectedInstructWO) {
        this.selectedInstructWO = selectedInstructWO;
    }

    /**
     * @return the id_Maintenance
     */
    public int getId_Maintenance() {
        return id_Maintenance;
    }

    /**
     * @param id_Maintenance the id_Maintenance to set
     */
    public void setId_Maintenance(int id_Maintenance) {
        this.id_Maintenance = id_Maintenance;
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
     * @return the duree_presta
     */
    public float getDuree_presta() {
        return duree_presta;
    }

    /**
     * @param duree_presta the duree_presta to set
     */
    public void setDuree_presta(float duree_presta) {
        this.duree_presta = duree_presta;
    }

    /**
     * @return the descritpion
     */
    public String getDescritpion() {
        return descritpion;
    }

    /**
     * @param descritpion the descritpion to set
     */
    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    /**
     * @return the nHeure
     */
    public float getnHeure() {
        return nHeure;
    }

    /**
     * @param nHeure the nHeure to set
     */
    public void setnHeure(float nHeure) {
        this.nHeure = nHeure;
    }

    /**
     * @return the nDuree
     */
    public float getnDuree() {
        return nDuree;
    }

    /**
     * @param nDuree the nDuree to set
     */
    public void setnDuree(float nDuree) {
        this.nDuree = nDuree;
    }

    /**
     * @return the nHeureBut
     */
    public float getnHeureBut() {
        return nHeureBut;
    }

    /**
     * @param nHeureBut the nHeureBut to set
     */
    public void setnHeureBut(float nHeureBut) {
        this.nHeureBut = nHeureBut;
    }

    /**
     * @return the nDureeBut
     */
    public float getnDureeBut() {
        return nDureeBut;
    }

    /**
     * @param nDureeBut the nDureeBut to set
     */
    public void setnDureeBut(float nDureeBut) {
        this.nDureeBut = nDureeBut;
    }
}
