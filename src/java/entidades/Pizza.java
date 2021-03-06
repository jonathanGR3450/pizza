/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathan
 */
@Entity
@Table(name = "PIZZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p")
    , @NamedQuery(name = "Pizza.findById", query = "SELECT p FROM Pizza p WHERE p.id = :id")
    , @NamedQuery(name = "Pizza.findByVendedor", query = "SELECT p FROM Pizza p WHERE p.vendedor = :vendedor")
    , @NamedQuery(name = "Pizza.findByTipo", query = "SELECT p FROM Pizza p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Pizza.findByComprador", query = "SELECT p FROM Pizza p WHERE p.comprador = :comprador")
    , @NamedQuery(name = "Pizza.findByFecha", query = "SELECT p FROM Pizza p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Pizza.findByValor", query = "SELECT p FROM Pizza p WHERE p.valor = :valor")})
public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "VENDEDOR")
    private String vendedor;
    @Size(max = 100)
    @Column(name = "TIPO")
    private String tipo;
    @Size(max = 100)
    @Column(name = "COMPRADOR")
    private String comprador;
    @Size(max = 100)
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "VALOR")
    private Integer valor;

    public Pizza() {
    }

    public Pizza(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizza)) {
            return false;
        }
        Pizza other = (Pizza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pizza[ id=" + id + " ]";
    }
    
}
