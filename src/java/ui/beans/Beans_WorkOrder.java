/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.WorkOrder;
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
@ManagedBean(name = "workorder_beans")
@SessionScoped()
public class Beans_WorkOrder implements Serializable{

    

    private List<SelectItem> listeWorkOrderItem;
    private String selectedWorkOrderItem;
    private WorkOrder selectedworkorder;
    
    private int id_wo;
    private String immat;
    private int id_proprio;
    private Date date_in;
    private Date date_out;
    private String num_wo;


    public Beans_WorkOrder() {
        
        listeWorkOrderItem = new ArrayList<SelectItem>();
        List<WorkOrder> workOrder = new DAO.DAO_Workorder().GET_ALL();
        for (WorkOrder work : workOrder) {
            listeWorkOrderItem.add(new SelectItem(work.getId_wo()));
        }
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddWorkOrder() throws Exception {
        
        WorkOrder work = new WorkOrder();
        work.setId_wo(getId_wo());
        work.setImmat(getImmat());
        work.setId_proprio(getId_proprio());
        work.setDate_in(getDate_in());
        work.setDate_out(getDate_out());
        work.setNum_wo(getNum_wo());
             


        int add = new DAO.DAO_Workorder().CREATE(work);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "Le Work Order a bien été ajouté !"));
            return "listWorkOrder";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<WorkOrder> GET_LIST() {
        return new DAO.DAO_Workorder().GET_ALL();
    }

    /**
     * @return the listeWorkOrderItem
     */
    public List<SelectItem> getListeWorkOrderItem() {
        return listeWorkOrderItem;
    }

    /**
     * @param listeWorkOrderItem the listeWorkOrderItem to set
     */
    public void setListeWorkOrderItem(List<SelectItem> listeWorkOrderItem) {
        this.listeWorkOrderItem = listeWorkOrderItem;
    }

    /**
     * @return the selectedWorkOrderItem
     */
    public String getSelectedWorkOrderItem() {
        return selectedWorkOrderItem;
    }

    /**
     * @param selectedWorkOrderItem the selectedWorkOrderItem to set
     */
    public void setSelectedWorkOrderItem(String selectedWorkOrderItem) {
        this.selectedWorkOrderItem = selectedWorkOrderItem;
    }

    /**
     * @return the selectedworkorder
     */
    public WorkOrder getSelectedworkorder() {
        return selectedworkorder;
    }

    /**
     * @param selectedworkorder the selectedworkorder to set
     */
    public void setSelectedworkorder(WorkOrder selectedworkorder) {
        this.selectedworkorder = selectedworkorder;
    }

    /**
     * @return the id_wo
     */
    public int getId_wo() {
        return id_wo;
    }

    /**
     * @param id_wo the id_wo to set
     */
    public void setId_wo(int id_wo) {
        this.id_wo = id_wo;
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
     * @return the date_in
     */
    public Date getDate_in() {
        return date_in;
    }

    /**
     * @param date_in the date_in to set
     */
    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    /**
     * @return the date_out
     */
    public Date getDate_out() {
        return date_out;
    }

    /**
     * @param date_out the date_out to set
     */
    public void setDate_out(Date date_out) {
        this.date_out = date_out;
    }

    /**
     * @return the num_wo
     */
    public String getNum_wo() {
        return num_wo;
    }

    /**
     * @param num_wo the num_wo to set
     */
    public void setNum_wo(String num_wo) {
        this.num_wo = num_wo;
    }

}
