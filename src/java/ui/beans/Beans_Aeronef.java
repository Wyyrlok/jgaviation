/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.beans;

import Metier.Aeronef;
import Metier.Constructeur;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Valentin
 */
@ManagedBean(name = "aeronef_beans")
@SessionScoped()
public class Beans_Aeronef implements Serializable {
 
    private Aeronef selectedAero;
    private String immat;
    private int id_const;
    private String serial_nb;
    private Date date_const;
    private int id_proprio;
    private int id_type;
    private String type;


    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String AddAeronef() throws Exception {

        Aeronef aero = new Aeronef();
        aero.setImmat(getImmat());
        aero.setId_const(getId_const());
        aero.setSerial_nb(getSerial_nb());
        aero.setDate_const(getDate_const());
        aero.setId_proprio(getId_proprio());
        aero.setId_type(getId_type());
        aero.setType(getType());

        int add = new DAO.DAO_Aeronef().CREATE(aero);
        if (add != 0) {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Information : ", "L'Aeronef a bien été ajouté!"));
            return "listAeronef";
        } else {
            addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement fail!!!", null));
            return "";
        }
    }

    public List<Aeronef> GET_LIST() {
        return new DAO.DAO_Aeronef().GET_ALL();
    }

    /**
     * @return the selectedAero
     */
    public Aeronef getSelectedAero() {
        return selectedAero;
    }

    /**
     * @param selectedAero the selectedAero to set
     */
    public void setSelectedAero(Aeronef selectedAero) {
        this.selectedAero = selectedAero;
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
     * @return the id_const
     */
    public int getId_const() {
        return id_const;
    }

    /**
     * @param id_const the id_const to set
     */
    public void setId_const(int id_const) {
        this.id_const = id_const;
    }

    /**
     * @return the serial_nb
     */
    public String getSerial_nb() {
        return serial_nb;
    }

    /**
     * @param serial_nb the serial_nb to set
     */
    public void setSerial_nb(String serial_nb) {
        this.serial_nb = serial_nb;
    }

    /**
     * @return the date_const
     */
    public Date getDate_const() {
        return date_const;
    }

    /**
     * @param date_const the date_const to set
     */
    public void setDate_const(Date date_const) {
        this.date_const = date_const;
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
     * @return the id_type
     */
    public int getId_type() {
        return id_type;
    }

    /**
     * @param id_type the id_type to set
     */
    public void setId_type(int id_type) {
        this.id_type = id_type;
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

}

