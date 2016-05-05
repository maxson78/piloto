package com.strategying.piloto.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.strategying.piloto.util.FacesContextUtil;
import com.strategying.piloto.model.entities.Ciudad;
import com.strategying.piloto.model.dao.HibernateDAO;
import com.strategying.piloto.model.dao.InterfaceDAO;


@ManagedBean(name = "mbCiudad")
@RequestScoped
public class MbCiudad implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Ciudad ciudad = new Ciudad();
    private List<Ciudad> ciudades;

    public MbCiudad() {
    }

    private InterfaceDAO<Ciudad> ciudadDAO() {
        InterfaceDAO<Ciudad> ciudadDAO = new HibernateDAO<Ciudad>(Ciudad.class, FacesContextUtil.getRequestSession());
        return ciudadDAO;
    }

    public String limpCiudad() {
        ciudad = new Ciudad();
        return editCiudad();
    }

    public String editCiudad() {
        return "/restrict/cadastrarciudad.faces";
    }

    public String addCiudad() {
        if (ciudad.getIdCiudad() == null || ciudad.getIdCiudad() == 0) {
            insertCiudad();
        } else {
            updateCiudad();
        }
        limpCiudad();
        return null;
    }

    private void insertCiudad() {
        ciudadDAO().save(ciudad);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Ciudad insertada", ""));
    }

    private void updateCiudad() {
        ciudadDAO().update(ciudad);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Ciudad actualizada", ""));
    }
    
    public void deleteCiudad(){
        ciudadDAO().remove(ciudad);        
    }
    
    public List<Ciudad> getCiudades() {       
        ciudades = ciudadDAO().getEntities();
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
        
}
