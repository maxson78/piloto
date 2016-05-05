package com.strategying.piloto.suport;

import com.strategying.piloto.model.entities.TipoDireccion;
import com.strategying.piloto.model.dao.HibernateDAO;
import com.strategying.piloto.model.dao.InterfaceDAO;

import com.strategying.piloto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

@ManagedBean(name="bbTipoDireccion")
@RequestScoped
public class BbTipoDireccion  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public List<TipoDireccion> getTipoDirecciones() {
        Session session = FacesContextUtil.getRequestSession();
        InterfaceDAO<TipoDireccion> tipoDireccionDAO = new HibernateDAO<TipoDireccion>(TipoDireccion.class, session);
        return tipoDireccionDAO.getEntities();
    }
}