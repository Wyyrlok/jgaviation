/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author Valentin
 */
public class Article {
    
    private int id_article;
    private String designation;
    private String part_nb_const;
    private int id_const;
    private float prix_vte_article;
    private boolean bPeremption;
    private boolean bSerialNb;
    private int stock_mini;

    /**
     * @return the id_article
     */
    public int getId_article() {
        return id_article;
    }

    /**
     * @param id_article the id_article to set
     */
    public void setId_article(int id_article) {
        this.id_article = id_article;
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
     * @return the part_nb_const
     */
    public String getPart_nb_const() {
        return part_nb_const;
    }

    /**
     * @param part_nb_const the part_nb_const to set
     */
    public void setPart_nb_const(String part_nb_const) {
        this.part_nb_const = part_nb_const;
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
     * @return the prix_vte_article
     */
    public float getPrix_vte_article() {
        return prix_vte_article;
    }

    /**
     * @param prix_vte_article the prix_vte_article to set
     */
    public void setPrix_vte_article(float prix_vte_article) {
        this.prix_vte_article = prix_vte_article;
    }

    /**
     * @return the bPeremption
     */
    public boolean isbPeremption() {
        return bPeremption;
    }

    /**
     * @param bPeremption the bPeremption to set
     */
    public void setbPeremption(boolean bPeremption) {
        this.bPeremption = bPeremption;
    }

    /**
     * @return the bSerialNb
     */
    public boolean isbSerialNb() {
        return bSerialNb;
    }

    /**
     * @param bSerialNb the bSerialNb to set
     */
    public void setbSerialNb(boolean bSerialNb) {
        this.bSerialNb = bSerialNb;
    }

    /**
     * @return the stock_mini
     */
    public int getStock_mini() {
        return stock_mini;
    }

    /**
     * @param stock_mini the stock_mini to set
     */
    public void setStock_mini(int stock_mini) {
        this.stock_mini = stock_mini;
    }

   

    
}
