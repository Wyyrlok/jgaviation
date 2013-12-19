/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author Valentin
 */
public class Article_Fourn {
    
    private int id_art;
    private int id_fourn;
    private float prix_ach_fourn;
    private String part_nb_fourn;
    private String code_aen;

    /**
     * @return the id_art
     */
    public int getId_art() {
        return id_art;
    }

    /**
     * @param id_art the id_art to set
     */
    public void setId_art(int id_art) {
        this.id_art = id_art;
    }

    /**
     * @return the id_forum
     */
    public int getId_fourn() {
        return id_fourn;
    }

    /**
     * @param id_forum the id_forum to set
     */
    public void setId_fourn(int id_fourn) {
        this.id_fourn = id_fourn;
    }

    /**
     * @return the prix_ach_fourn
     */
    public float getPrix_ach_fourn() {
        return prix_ach_fourn;
    }

    /**
     * @param prix_ach_fourn the prix_ach_fourn to set
     */
    public void setPrix_ach_fourn(float prix_ach_fourn) {
        this.prix_ach_fourn = prix_ach_fourn;
    }

    /**
     * @return the part_nb_fourn
     */
    public String getPart_nb_fourn() {
        return part_nb_fourn;
    }

    /**
     * @param part_nb_fourn the part_nb_fourn to set
     */
    public void setPart_nb_fourn(String part_nb_fourn) {
        this.part_nb_fourn = part_nb_fourn;
    }

    /**
     * @return the code_aen
     */
    public String getCode_aen() {
        return code_aen;
    }

    /**
     * @param code_aen the code_aen to set
     */
    public void setCode_aen(String code_aen) {
        this.code_aen = code_aen;
    }
    
}
