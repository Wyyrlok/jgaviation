/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metier;

/**
 *
 * @author Fabien
 */
public class Utilisateur 
{
    private int id_Personnel;
    private String sPrenom;
    private String sNom;
    private int id_profil;
    private String sLogin;
    private String sPassword;
    private int nbErr;
    private boolean bLocked;
    private int retCnx;

    /**
     * @return the id_Personnel
     */
    public int getId_Personnel() {
        return id_Personnel;
    }

    /**
     * @param id_Personnel the id_Personnel to set
     */
    public void setId_Personnel(int id_Personnel) {
        this.id_Personnel = id_Personnel;
    }

    /**
     * @return the sPrenom
     */
    public String getsPrenom() {
        return sPrenom;
    }

    /**
     * @param sPrenom the sPrenom to set
     */
    public void setsPrenom(String sPrenom) {
        this.sPrenom = sPrenom;
    }

    /**
     * @return the sNom
     */
    public String getsNom() {
        return sNom;
    }

    /**
     * @param sNom the sNom to set
     */
    public void setsNom(String sNom) {
        this.sNom = sNom;
    }

    /**
     * @return the id_profil
     */
    public int getId_profil() {
        return id_profil;
    }

    /**
     * @param id_profil the id_profil to set
     */
    public void setId_profil(int id_profil) {
        this.id_profil = id_profil;
    }

    /**
     * @return the sLogin
     */
    public String getsLogin() {
        return sLogin;
    }

    /**
     * @param sLogin the sLogin to set
     */
    public void setsLogin(String sLogin) {
        this.sLogin = sLogin;
    }

    /**
     * @return the sPassword
     */
    public String getsPassword() {
        return sPassword;
    }

    /**
     * @param sPassword the sPassword to set
     */
    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    /**
     * @return the nbErr
     */
    public int getNbErr() {
        return nbErr;
    }

    /**
     * @param nbErr the nbErr to set
     */
    public void setNbErr(int nbErr) {
        this.nbErr = nbErr;
    }

    /**
     * @return the bLocked
     */
    public boolean isbLocked() {
        return bLocked;
    }

    /**
     * @param bLocked the bLocked to set
     */
    public void setbLocked(boolean bLocked) {
        this.bLocked = bLocked;
    }

    /**
     * @return the retCnx
     */
    public int getRetCnx() {
        return retCnx;
    }

    /**
     * @param retCnx the retCnx to set
     */
    public void setRetCnx(int retCnx) {
        this.retCnx = retCnx;
    }
}
