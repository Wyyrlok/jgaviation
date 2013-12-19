/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.beans;

import Metier.Utilisateur;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fabien
 */
@ManagedBean(name="user_beans")
@SessionScoped()
public class Beans_Utilisateur 
{
    private Utilisateur user;
    private String sLogin;
    private String sPassword;

    public String Connexion()
    {
        String sRet = "";
        
        System.err.println("Login : " + sLogin + " - Password : " + sPassword);
        
        Utilisateur utilisateur = new DAO.DAO_Utilisateur().Connect(sLogin,sPassword);
        System.err.println("Id ret : "+utilisateur.getRetCnx());
        System.err.println("Id perso : "+utilisateur.getId_Personnel());
        
        if( utilisateur.getRetCnx() >= 0)
        {
            if( utilisateur.getId_Personnel() > 0 )
            {
                user = utilisateur;
                sRet = "home.xhtml";
            }
            else
            {
                sRet = "";
            }
        }
        else
        {
            user = new Utilisateur();
            sRet = "";
        }
        
        return sRet;
    }
    
    /**
     * @return the user
     */
    public Utilisateur getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Utilisateur user) {
        this.user = user;
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
}
