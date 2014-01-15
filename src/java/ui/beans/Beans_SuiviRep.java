/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.SuiviRep;
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

@ManagedBean(name = "suivirep_beans")
@SessionScoped()
public class Beans_SuiviRep implements Serializable{
    



    private List<SelectItem> listeSuiviRepItem;
    private String selectedSuiviRepItem;
    private SuiviRep selectedsuivirep;
    private int id_SuiviRep;
    private String immat;
    private String type;
    private String objet;
    private String ref_approb;
    private Date date_appro;
    private int id_personnel;


    public Beans_SuiviRep() {
        listeSuiviRepItem = new ArrayList<SelectItem>();
        List<SuiviRep> suiviRep = new DAO.DAO_SuiviRep().GET_ALL();
        for (SuiviRep suivi : suiviRep) {
            listeSuiviRepItem.add(new SelectItem(suivi.getId_SuiviRep()));
        }
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddSuiviRep() throws Exception {
        
        SuiviRep suiviRep = new SuiviRep();
        suiviRep.setId_SuiviRep(getId_SuiviRep());
        suiviRep.setImmat(getImmat());
        suiviRep.setType(getType());
        suiviRep.setObjet(getObjet());
        suiviRep.setRef_approb(getRef_approb());
        suiviRep.setDate_appro(getDate_appro());
        suiviRep.setId_personnel(getId_personnel());

        int add = new DAO.DAO_SuiviRep().CREATE(suiviRep);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le Suivi de la Réparation a bien été mis à jour!"));
            return "listSuiviRep";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<SuiviRep> GET_LIST() {
        return new DAO.DAO_SuiviRep().GET_ALL();
    }

    /**
     * @return the listeSuiviRepItem
     */
    public List<SelectItem> getListeSuiviRepItem() {
        return listeSuiviRepItem;
    }

    /**
     * @param listeSuiviRepItem the listeSuiviRepItem to set
     */
    public void setListeSuiviRepItem(List<SelectItem> listeSuiviRepItem) {
        this.listeSuiviRepItem = listeSuiviRepItem;
    }

    /**
     * @return the selectedSuiviRepItem
     */
    public String getSelectedSuiviRepItem() {
        return selectedSuiviRepItem;
    }

    /**
     * @param selectedSuiviRepItem the selectedSuiviRepItem to set
     */
    public void setSelectedSuiviRepItem(String selectedSuiviRepItem) {
        this.selectedSuiviRepItem = selectedSuiviRepItem;
    }

    /**
     * @return the selectedsuivirep
     */
    public SuiviRep getSelectedsuivirep() {
        return selectedsuivirep;
    }

    /**
     * @param selectedsuivirep the selectedsuivirep to set
     */
    public void setSelectedsuivirep(SuiviRep selectedsuivirep) {
        this.selectedsuivirep = selectedsuivirep;
    }

    /**
     * @return the id_SuiviRep
     */
    public int getId_SuiviRep() {
        return id_SuiviRep;
    }

    /**
     * @param id_SuiviRep the id_SuiviRep to set
     */
    public void setId_SuiviRep(int id_SuiviRep) {
        this.id_SuiviRep = id_SuiviRep;
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
     * @return the ref_approb
     */
    public String getRef_approb() {
        return ref_approb;
    }

    /**
     * @param ref_approb the ref_approb to set
     */
    public void setRef_approb(String ref_approb) {
        this.ref_approb = ref_approb;
    }

    /**
     * @return the date_appro
     */
    public Date getDate_appro() {
        return date_appro;
    }

    /**
     * @param date_appro the date_appro to set
     */
    public void setDate_appro(Date date_appro) {
        this.date_appro = date_appro;
    }

    /**
     * @return the id_personnel
     */
    public int getId_personnel() {
        return id_personnel;
    }

    /**
     * @param id_personnel the id_personnel to set
     */
    public void setId_personnel(int id_personnel) {
        this.id_personnel = id_personnel;
    }
    
}
