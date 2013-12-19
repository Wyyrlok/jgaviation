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
public class MoteurAeronef {
    
    private int id_Moteur;
    private String prosition;
    private Date date_inventaire;
    private String immat;

    /**
     * @return the id_Moteur
     */
    public int getId_Moteur() {
        return id_Moteur;
    }

    /**
     * @param id_Moteur the id_Moteur to set
     */
    public void setId_Moteur(int id_Moteur) {
        this.id_Moteur = id_Moteur;
    }

    /**
     * @return the prosition
     */
    public String getProsition() {
        return prosition;
    }

    /**
     * @param prosition the prosition to set
     */
    public void setProsition(String prosition) {
        this.prosition = prosition;
    }

    /**
     * @return the date_inventaire
     */
    public Date getDate_inventaire() {
        return date_inventaire;
    }

    /**
     * @param date_inventaire the date_inventaire to set
     */
    public void setDate_inventaire(Date date_inventaire) {
        this.date_inventaire = date_inventaire;
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
    
}
