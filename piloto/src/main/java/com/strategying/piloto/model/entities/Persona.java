package com.strategying.piloto.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table (name="persona")
public class Persona implements Serializable {
    
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdPersona", nullable=false)
    private Integer idPersona;
    @Column (name="Nombre", nullable = false, length = 80 )
    private String nombre;
    @Column (name="Email", nullable = false, length = 80 )
    private String email;
    @Column (name="Telefono", nullable = false, length = 15 )//(034)-8888-8888
    private String telefono;
    @Column (name="CPF", nullable = false, length = 14 )
    private String cpf;
    @Column (name="DataDeNacimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNacimento;
    @Column (name="DataDeCatastro", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCatastro;
        
    @Column(name = "Login", unique=true, length = 25)
    private String login;
    @Column(name = "Contrasena", length = 40)
    private String contrasena;
    @Column(name = "Permiso", length = 36)
    private String permiso;
    
    @OneToOne(mappedBy = "persona", fetch = FetchType.LAZY)
    @ForeignKey(name="DireccionPersona")
    private Direccion direccion;
    
    @ManyToOne(optional=false)
    @ForeignKey(name = "PersonaSexo") 
    @JoinColumn(name="IdSexo", referencedColumnName = "IdSexo")
    private Sexo sexo;

    public Persona() {
        this.sexo = new Sexo();
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNacimento() {
        return dataDeNacimento;
    }

    public void setDataDeNacimento(Date dataDeNacimento) {
        this.dataDeNacimento = dataDeNacimento;
    }

    public Date getDataDeCatastro() {
        return dataDeCatastro;
    }

    public void setDataDeCatastro(Date dataDeCatastro) {
        this.dataDeCatastro = dataDeCatastro;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }
         
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.idPersona != null ? this.idPersona.hashCode() : 0);
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
        final Persona other = (Persona) obj;
        if (this.idPersona != other.idPersona && (this.idPersona == null || !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }
             
}
