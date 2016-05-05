package com.strategying.piloto.suport;




import com.strategying.piloto.model.entities.Ciudad;
import com.strategying.piloto.model.dao.HibernateDAO;
import com.strategying.piloto.model.dao.InterfaceDAO;
import com.strategying.piloto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="bbCiudad")
@RequestScoped
public class BbCiudad  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Ciudad> ciudades;

    public List<Ciudad> getCiudads() {
        InterfaceDAO<Ciudad> cidadeDAO = new HibernateDAO<Ciudad>(Ciudad.class, FacesContextUtil.getRequestSession());
        return cidadeDAO.getEntities();
    }
}
