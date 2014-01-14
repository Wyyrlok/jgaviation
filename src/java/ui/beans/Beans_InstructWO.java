/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;
 
import Metier.InstructWO;
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
@ManagedBean(name="instructWO_beans")
@SessionScoped()
public class Beans_InstructWO implements Serializable{

    
    

    private List<SelectItem> listeInstructWOItem;
    private String selectedInstructWOItem;
    
    private InstructWO selectedInstructWO;
    private int id_instructWO;
    private int pos;
    private String designation;
    private int id_WO;



    public Beans_InstructWO()
    {
        listeInstructWOItem = new ArrayList<SelectItem>();
        List<InstructWO> instructWO = new DAO.DAO_InstructWo().GET_ALL();
        for(InstructWO inst: instructWO)
        {
            listeInstructWOItem.add(new SelectItem(inst.getId_WO()));
        }
    }
    
    private void addMessage(FacesMessage message)
    {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String AddInstructWO() throws Exception
    {
        InstructWO instruct = new InstructWO();
        instruct.setId_instructWO(getId_instructWO());
        instruct.setPos(getPos());
        instruct.setDesignation(getDesignation());
        instruct.setId_WO(getId_WO());
        

        
        int add = new DAO.DAO_InstructWo().CREATE(instruct);
        if( add != 0 )
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "L'Instruction du Work Order a bien été ajouté!"));
            return "listInstructWO";
        }
        else
        {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";   
        }
    }
    
    public List<InstructWO> GET_LIST()
    {
        return new DAO.DAO_InstructWo().GET_ALL();
    }

    /**
     * @return the listeInstructWOItem
     */
    public List<SelectItem> getListeInstructWOItem() {
        return listeInstructWOItem;
    }

    /**
     * @param listeInstructWOItem the listeInstructWOItem to set
     */
    public void setListeInstructWOItem(List<SelectItem> listeInstructWOItem) {
        this.listeInstructWOItem = listeInstructWOItem;
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
    public InstructWO getSelectedInstructWO() {
        return selectedInstructWO;
    }

    /**
     * @param selectedInstructWO the selectedInstructWO to set
     */
    public void setSelectedInstructWO(InstructWO selectedInstructWO) {
        this.selectedInstructWO = selectedInstructWO;
    }

    /**
     * @return the id_instructWO
     */
    public int getId_instructWO() {
        return id_instructWO;
    }

    /**
     * @param id_instructWO the id_instructWO to set
     */
    public void setId_instructWO(int id_instructWO) {
        this.id_instructWO = id_instructWO;
    }

    /**
     * @return the pos
     */
    public int getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(int pos) {
        this.pos = pos;
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
     * @return the id_WO
     */
    public int getId_WO() {
        return id_WO;
    }

    /**
     * @param id_WO the id_WO to set
     */
    public void setId_WO(int id_WO) {
        this.id_WO = id_WO;
    }
    
}
