package com.dogsplaces.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import com.dogsplaces.session.SessionContext;

@SessionScoped
@ManagedBean
public class F5Detector {
  private String previousPage = null;

  public void checkF5() {
    String msg = "";
    UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
    String id = viewRoot.getViewId();
    if (previousPage != null && (previousPage.equals(id))) {
    	System.out.println("Recarregou a pagina");
    } else {
    	SessionContext sc = SessionContext.getInstance();
    	switch(sc.getRequestServletPath()) {
    	case "/dog.xhtml":
    		sc.getSessionMap().remove("search");
    		break;
    	case "/search.xhtml":
    		sc.getSessionMap().remove("dogDetail");
    		break;
    	default:
    		sc.getSessionMap().remove("search");
    		sc.getSessionMap().remove("dogDetail");
    	}
    }
    previousPage = id;
  }
}
