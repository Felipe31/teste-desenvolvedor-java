package com.dogsplaces.session;

import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.dogsplaces.model.ItemSale;
  
  
public class SessionContext {
     
    private static SessionContext instance;
     
    public static SessionContext getInstance(){
         if (instance == null){
             instance = new SessionContext();
         }
          
         return instance;
    }
     
    private SessionContext(){
          
    }
     
    private ExternalContext currentExternalContext(){
         if (FacesContext.getCurrentInstance() == null){
             throw new RuntimeException("O FacesContext não pode ser"+ 
            		 "chamado fora de uma requisição HTTP");
         }else{
             return FacesContext.getCurrentInstance().getExternalContext();
         }
    }
     
    public List<ItemSale> getItemsSale(){
         return (List<ItemSale>) getAttribute("itemsSale");
    }
     
    public void setItemsSale(List<ItemSale> itemsSale){
         setAttribute("itemsSale", itemsSale);
    }
     
    public void finishSession(){   
         currentExternalContext().invalidateSession();
    }
     
    public Object getAttribute(String nome){
         return currentExternalContext().getSessionMap().get(nome);
    }
     
    public void setAttribute(String nome, Object valor){
         currentExternalContext().getSessionMap().put(nome, valor);
    }
     
}