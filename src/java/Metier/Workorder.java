/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;

/**
 *
 * @author quent_000
 */
public class Workorder {
    private int id_wo;
    private String immat;
    private int id_proprio;
    private Date date_in;
    private Date date_out;
    private String num_wo;

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