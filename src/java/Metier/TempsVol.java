/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.util.Date;

/**
 *
 * @author quent_000
 */
public class TempsVol {
    private int id_TempsVol;
    private String immat;
    private Date date_vol;
    private Float duree;

    /**
     * @return the id_TempsVol
     */
    public int getId_TempsVol() {
        return id_TempsVol;
    }

    /**
     * @param id_TempsVol the id_TempsVol to set
     */
    public void setId_TempsVol(int id_TempsVol) {
        this.id_TempsVol = id_TempsVol;
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
     * @return the duree
     */
    public Float getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(Float duree) {
        this.duree = duree;
    }
}
