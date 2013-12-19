/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;

/**
 *
 * @author quent_000
 */
public class Suivirep {
    private int id_SuiviRep;
    private String immat;
    private String type;
    private String objet;
    private String ref_approb;
    private Date date_appro;
    private int id_personnel;

    /**
     * @return the id_SuiviRep
     */
    public int getId_SuiviRep() {
        return id_SuiviRep;
    }

    /**
     * @param id_SuiviRep the id_SuiviRep to set
     */
    public void setId_SuiviRep(int id_SuiviRep) {
        this.id_SuiviRep = id_SuiviRep;
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
     * @return the objet
     */
    public String getObjet() {
        return objet;
    }

    /**
     * @param objet the objet to set
     */
    public void setObjet(String objet) {
        this.objet = objet;
    }

    /**
     * @return the ref_approb
     */
    public String getRef_approb() {
        return ref_approb;
    }

    /**
     * @param ref_approb the ref_approb to set
     */
    public void setRef_approb(String ref_approb) {
        this.ref_approb = ref_approb;
    }

    /**
     * @return the date_appro
     */
    public Date getDate_appro() {
        return date_appro;
    }

    /**
     * @param date_appro the date_appro to set
     */
    public void setDate_appro(Date date_appro) {
        this.date_appro = date_appro;
    }

    /**
     * @return the id_personnel
     */
    public int getId_personnel() {
        return id_personnel;
    }

    /**
     * @param id_personnel the id_personnel to set
     */
    public void setId_personnel(int id_personnel) {
        this.id_personnel = id_personnel;
    }
}
