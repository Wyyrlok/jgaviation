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
public class Nb_Cycle {
    
    private int id_NbCyle;
    private int id_cycle;
    private Date date_vol;
    private int nb_cycle;

    /**
     * @return the id_NbCyle
     */
    public int getId_NbCyle() {
        return id_NbCyle;
    }

    /**
     * @param id_NbCyle the id_NbCyle to set
     */
    public void setId_NbCyle(int id_NbCyle) {
        this.id_NbCyle = id_NbCyle;
    }

    /**
     * @return the id_cycle
     */
    public int getId_cycle() {
        return id_cycle;
    }

    /**
     * @param id_cycle the id_cycle to set
     */
    public void setId_cycle(int id_cycle) {
        this.id_cycle = id_cycle;
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
     * @return the nb_cycle
     */
    public int getNb_cycle() {
        return nb_cycle;
    }

    /**
     * @param nb_cycle the nb_cycle to set
     */
    public void setNb_cycle(int nb_cycle) {
        this.nb_cycle = nb_cycle;
    }
    
}
