package app.web.beans;

import javax.faces.context.FacesContext;

public class BaseBean {

    public void redirect(String url){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        }catch (Exception e){
            return;
        }
    }
}
