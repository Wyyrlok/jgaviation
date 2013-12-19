/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;

/**
 *
 * @author quent_000
 */
public class Visite {
    private int id_Visite;
    private String immat;
    private Date saisie_heure;
    private float saisie_date;
    private float tol_date;
    private float tol_heure;
    private float der_date;
    private float der_heure;
    private float id_maintenance;

    /**
     * @return the id_Visite
     */
    public int getId_Visite() {
        return id_Visite;
    }

    /**
     * @param id_Visite the id_Visite to set
     */
    public void setId_Visite(int id_Visite) {
        this.id_Visite = id_Visite;
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
     * @return the saisie_heure
     */
    public Date getSaisie_heure() {
        return saisie_heure;
    }

    /**
     * @param saisie_heure the saisie_heure to set
     */
    public void setSaisie_heure(Date saisie_heure) {
        this.saisie_heure = saisie_heure;
    }

    /**
     * @return the saisie_date
     */
    public float getSaisie_date() {
        return saisie_date;
    }

    /**
     * @param saisie_date the saisie_date to set
     */
    public void setSaisie_date(float saisie_date) {
        this.saisie_date = saisie_date;
    }

    /**
     * @return the tol_date
     */
    public float getTol_date() {
        return tol_date;
    }

    /**
     * @param tol_date the tol_date to set
     */
    public void setTol_date(float tol_date) {
        this.tol_date = tol_date;
    }

    /**
     * @return the tol_heure
     */
    public float getTol_heure() {
        return tol_heure;
    }

    /**
     * @param tol_heure the tol_heure to set
     */
    public void setTol_heure(float tol_heure) {
        this.tol_heure = tol_heure;
    }

    /**
     * @return the der_date
     */
    public float getDer_date() {
        return der_date;
    }

    /**
     * @param der_date the der_date to set
     */
    public void setDer_date(float der_date) {
        this.der_date = der_date;
    }

    /**
     * @return the der_heure
     */
    public float getDer_heure() {
        return der_heure;
    }

    /**
     * @param der_heure the der_heure to set
     */
    public void setDer_heure(float der_heure) {
        this.der_heure = der_heure;
    }

    /**
     * @return the id_maintenance
     */
    public float getId_maintenance() {
        return id_maintenance;
    }

    /**
     * @param id_maintenance the id_maintenance to set
     */
    public void setId_maintenance(float id_maintenance) {
        this.id_maintenance = id_maintenance;
    }
}
