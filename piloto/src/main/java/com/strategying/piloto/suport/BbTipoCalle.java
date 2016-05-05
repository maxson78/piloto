package com.strategying.piloto.suport;

import com.strategying.piloto.model.entities.TipoCalle;
import com.strategying.piloto.model.dao.HibernateDAO;
import com.strategying.piloto.model.dao.InterfaceDAO;
import com.strategying.piloto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

@ManagedBean(name="bbTipoCalle")
@RequestScoped
public class BbTipoCalle  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public List<TipoCalle> getTipoCalles() {
        Session session = FacesContextUtil.getRequestSession();
        InterfaceDAO<TipoCalle> tipoCalleDAO = new HibernateDAO<TipoCalle>(TipoCalle.class, session);
        return tipoCalleDAO.getEntities();
    }
}