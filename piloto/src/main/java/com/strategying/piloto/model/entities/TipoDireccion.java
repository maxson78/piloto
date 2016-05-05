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
@Table(name="tipodireccion")
public class TipoDireccion implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "IdTipoDireccion", nullable = false)
    private Integer idTipoDireccion;
    @Column(name = "DescripcionTipoDireccion", nullable = false, length = 35)
    private String descripcionTipoDireccion;
    
    @OneToMany(mappedBy = "tipodireccion", fetch = FetchType.LAZY)
    @ForeignKey(name="DireccionTipoDireccion")
    private List<Direccion> direcciones;

    public TipoDireccion() {
    }

    public String getDescripcionTipoDireccion() {
        return descripcionTipoDireccion;
    }

    public void setDescripcionTipoDireccion(String descripcionTipoDireccion) {
        this.descripcionTipoDireccion = descripcionTipoDireccion;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Integer getIdTipoDireccion() {
        return idTipoDireccion;
    }

    public void setIdTipoDireccion(Integer idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoDireccion other = (TipoDireccion) obj;
        if (this.idTipoDireccion != other.idTipoDireccion && (this.idTipoDireccion == null || !this.idTipoDireccion.equals(other.idTipoDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.idTipoDireccion != null ? this.idTipoDireccion.hashCode() : 0);
        return hash;
    }
}
