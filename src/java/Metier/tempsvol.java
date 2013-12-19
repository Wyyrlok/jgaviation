/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;

/**
 *
 * @author quent_000
 */
public class tempsvol {
    private int id_tempsVol;
    private String immat;
    private Date date_vol;
    private float duree;

    /**
     * @return the id_tempsVol
     */
    public int getId_tempsVol() {
        return id_tempsVol;
    }

    /**
     * @param id_tempsVol the id_tempsVol to set
     */
    public void setId_tempsVol(int id_tempsVol) {
        this.id_tempsVol = id_tempsVol;
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
    public float getDuree() {
        return duree;
    }

    /**
     * @param duree the duree to set
     */
    public void setDuree(float duree) {
        this.duree = duree;
    }
}
