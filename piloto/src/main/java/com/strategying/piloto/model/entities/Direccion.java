package com.strategying.piloto.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="direccion")
public class Direccion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdDireccion", nullable=false)
    private Integer idDireccion;
    @Column(name="Barrio", length=80)
    private String barrio;
    @Column (name="NomCalle", length=80)
    private String nomCalle;
    @Column (name="CEP", length=9)
    private String cep;
    @Column (name="Numero")
    private Integer numero;
    @Column (name="Complemento")
    private Integer complemento;
    
    @OneToOne(optional=true, fetch= FetchType.LAZY)
    @ForeignKey(name="DireccionPersona")
    @JoinColumn(name = "IdPersona", referencedColumnName = "IdPersona")
    private Persona persona;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name="DireccionTipoCalle")
    @JoinColumn(name = "IdTipoCalle", referencedColumnName = "IdTipoCalle")
    private TipoCalle tipocalle;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name="DireccionEstado")
    @JoinColumn(name = "IdEstado", nullable = false)
    private Estado estado;
        
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name="DireccionTipoDireccion")
    @JoinColumn(name = "IdTipoDireccion", referencedColumnName="IdTipoDireccion")
    private TipoDireccion tipodireccion;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name="DireccionCiudad")
    @JoinColumn(name = "IdCiudad", referencedColumnName="IdCiudad")
    private Ciudad ciudad;   

    public Direccion() {
        this.ciudad = new Ciudad();
        this.estado = new Estado();
        this.tipocalle = new TipoCalle();
        this.tipodireccion = new TipoDireccion();
        this.persona = new Persona();
    }    
    
    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getNomCalle() {
        return nomCalle;
    }

    public void setNomCalle(String nomCalle) {
        this.nomCalle = nomCalle;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getComplemento() {
        return complemento;
    }

    public void setComplemento(Integer complemento) {
        this.complemento = complemento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoDireccion getTipodireccion() {
        return tipodireccion;
    }

    public void setTipodireccion(TipoDireccion tipodireccion) {
        this.tipodireccion = tipodireccion;
    }

    public TipoCalle getTipocalle() {
        return tipocalle;
    }

    public void setTipocalle(TipoCalle tipocalle) {
        this.tipocalle = tipocalle;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.idDireccion != null ? this.idDireccion.hashCode() : 0);
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
        final Direccion other = (Direccion) obj;
        if (this.idDireccion != other.idDireccion && (this.idDireccion == null || !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }
        
}
