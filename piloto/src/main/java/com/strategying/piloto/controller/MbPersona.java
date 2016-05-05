package com.strategying.piloto.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import com.strategying.piloto.conversores.ConverterSHA1;


import com.strategying.piloto.util.FacesContextUtil;
import com.strategying.piloto.model.entities.Direccion;
import com.strategying.piloto.model.entities.Persona;
import com.strategying.piloto.model.dao.HibernateDAO;
import com.strategying.piloto.model.dao.InterfaceDAO;


@ManagedBean
@SessionScoped
public class MbPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    private String confirmaContrasena;
    private Persona persona = new Persona();
    private Direccion direccion = new Direccion();
    private List<Persona> personas;
    private List<Direccion> direcciones;

    public MbPersona() {
    }

    private InterfaceDAO<Persona> personaDAO() {
        InterfaceDAO<Persona> personaDAO = new HibernateDAO<Persona>(Persona.class, FacesContextUtil.getRequestSession());
        return personaDAO;
    }

    private InterfaceDAO<Direccion> direccionDAO() {
        InterfaceDAO<Direccion> direccionDAO = new HibernateDAO<Direccion>(Direccion.class, FacesContextUtil.getRequestSession());
        return direccionDAO;
    }

    public String limpPersona() {
        persona = new Persona();
        direccion = new Direccion();
        return editPersona();
    }

    public String editPersona() {
        return "/restrict/cadastrarpersona.faces";
    }

    public String addPersona() {
        Date date = new Date();
        if (persona.getIdPersona() == null || persona.getIdPersona() == 0) {
            persona.setDataDeCatastro(date);
            insertPersona();
        } else {
            updatePersona();
        }

        return null;
    }

    private void insertPersona() {
        persona.setContrasena(ConverterSHA1.cipher(persona.getContrasena()));
        if (persona.getContrasena() == null ? confirmaContrasena == null : persona.getContrasena().equals(ConverterSHA1.cipher(confirmaContrasena))) {
            persona.setPermiso("ROLE_ADMIN");
            personaDAO().save(persona);
            direccion.setPersona(persona);
            direccionDAO().save(direccion);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Persona inscrita correctamente", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseñas no coinciden.", ""));
        }
    }

    private void updatePersona() {
        personaDAO().update(persona);
        direccionDAO().update(direccion);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos persona actualizados", ""));
    }

    public String deletePersona() {
        personaDAO().remove(persona);
        direccionDAO().remove(direccion);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado", ""));
        return null;
    }

    public List<Persona> getPersonas() {
        personas = personaDAO().getEntities();
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Direccion> getDirecciones() {
        direcciones = direccionDAO().getEntities();
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getConfirmaContrasena() {
        return confirmaContrasena;
    }

    public void setConfirmaContrasena(String confirmaContrasena) {
        this.confirmaContrasena = confirmaContrasena;
    }
}
