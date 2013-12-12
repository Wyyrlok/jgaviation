/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Template;

/**
 *
 * @author Valentin
 */
import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Valentin
 */
public class LoginBean {  
  
    private String username;  
    private String password;  
      
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String usrname) {  
        this.username = usrname;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String pssword) {  
        this.password = pssword;  
    }  
  
    public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;  
          
        if( username != null  && username.equals("admin") && password != null  && password.equals("admin")) {  
            loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);  
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
    }  
}  
