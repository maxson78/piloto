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
@Table(name="ciudad")
public class Ciudad implements Serializable{
    
    private static final long serialVersionUID =  1L; 
    
    @Id
    @GeneratedValue
    @Column(name="IdCiudad", nullable=false)
    private Integer idCiudad;
    @Column(name="Nombre", length=80, nullable=false)
    private String nombre;

    @OneToMany(mappedBy = "ciudad", fetch = FetchType.LAZY)
    @ForeignKey(name="DireccionCiudad")
    private List<Direccion> direcciones;
    
    public Ciudad() {
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.idCiudad != null ? this.idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ciudad other = (Ciudad) obj;
        if (this.idCiudad != other.idCiudad && (this.idCiudad == null || !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }
    
}
