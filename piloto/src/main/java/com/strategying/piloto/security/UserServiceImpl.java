package com.strategying.piloto.security;

import com.strategying.piloto.model.dao.HibernateDAO;
import com.strategying.piloto.model.dao.InterfaceDAO;
import com.strategying.piloto.model.entities.Persona;

import com.strategying.piloto.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("semeruUserService")
public class UserServiceImpl implements UserDetailsService, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username != null && username.isEmpty()) {
            throw new UsernameNotFoundException("Usuario nao encontrado!");
        } else {
            try {
                Persona usuario = findUser(username);

                String login = usuario.getLogin();
                String password = usuario.getContrasena();
                boolean enabled = true; //userBean.isActive()
                boolean accountNonExpired = true;//userBean.isActive()
                boolean credentialsNonExpired = true; //userBean.isActive()
                boolean accountNonLocked = true; //userBean.isActive()

                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                //Use assim se você usa o Spring Security 3.0.5.RELEASE
                authorities.add(new GrantedAuthorityImpl(usuario.getPermiso()));
                //Já na versão 3.1.3.RELEASE essa classe foi depreciada e você deve usar como no trecho abaixo
                //authorities.add(new SimpleGrantedAuthority(usuario.getPermissao()));
                User user = new User(
                        login,
                        password,
                        enabled,
                        accountNonExpired,
                        credentialsNonExpired,
                        accountNonLocked,
                        authorities);
                return user;
            } catch (Exception e) {
                return null;
            }
        }

    }

    public Persona findUser(String login) {
        String stringQuery = "from Persona persona where persona.login = "+ login;
//        return personaDAO().getEntityByHQLQuery(stringQuery);
        Session session = FacesContextUtil.getRequestSession();
        Query query = session.createQuery(stringQuery);
        //query.setString(0, login);
        return (Persona) query.uniqueResult();
    }
    
    private InterfaceDAO<Persona> personaDAO() {
        InterfaceDAO<Persona> personaDAO = new HibernateDAO<Persona>(Persona.class, FacesContextUtil.getRequestSession());
        return personaDAO;
    }
}