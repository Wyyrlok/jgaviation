/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.Date;

/**
 *
 * @author Valentin
 */
public class ElmntMoteur {
    
    private int id_emlnt;
    private String designation;
    private int id_Const_Marque;
    private String type;
    private String serial_nb;
    private Date date;
    private String observations;
    private int id_moteur;

    /**
     * @return the id_emlnt
     */
    public int getId_emlnt() {
        return id_emlnt;
    }

    /**
     * @param id_emlnt the id_emlnt to set
     */
    public void setId_emlnt(int id_emlnt) {
        this.id_emlnt = id_emlnt;
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
     * @return the id_Const_Marque
     */
    public int getId_Const_Marque() {
        return id_Const_Marque;
    }

    /**
     * @param id_Const_Marque the id_Const_Marque to set
     */
    public void setId_Const_Marque(int id_Const_Marque) {
        this.id_Const_Marque = id_Const_Marque;
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
     * @return the observations
     */
    public String getObservations() {
        return observations;
    }

    /**
     * @param observations the observations to set
     */
    public void setObservations(String observations) {
        this.observations = observations;
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
