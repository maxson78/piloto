package com.strategying.piloto.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tipocalle")
public class TipoCalle implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdTipoCalle", nullable = false)
    private Integer idTipoCalle;
    @Column(name = "DescripcionTipoCalle", nullable = false, length = 40)
    private String descripcionTipoCalle;
    
    @OneToMany(mappedBy = "tipocalle", fetch = FetchType.LAZY)
    @ForeignKey(name = "DireccionTipoCalle")
    private List<Direccion> direcciones;

    public TipoCalle() {
    }

    public String getDescripcionTipoCalle() {
        return descripcionTipoCalle;
    }

    public void setDescripcionTipoCalle(String descripcionTipoCalle) {
        this.descripcionTipoCalle = descripcionTipoCalle;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Integer getIdTipoCalle() {
        return idTipoCalle;
    }

    public void setIdTipoCalle(Integer idTipoCalle) {
        this.idTipoCalle = idTipoCalle;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoCalle other = (TipoCalle) obj;
        if (this.idTipoCalle != other.idTipoCalle && (this.idTipoCalle == null || !this.idTipoCalle.equals(other.idTipoCalle))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.idTipoCalle != null ? this.idTipoCalle.hashCode() : 0);
        return hash;
    }
}
