package modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="carritos")
public class Carritos {

	
	
	@Id
	@Column(name="codigo")
	//@GeneratedValue(strategy=GenerationType.AUTO )
	private int codigo;
	
	
	@Column(name="cantidad")
	private int cantidad;
	
	
	@Column(name="precioLib")
	private double precioLib;
	
	
	@Column(name="descuentoLib")
	private int descuentoLib;
	
	@Column(name = "id_libc_FK")
	private int id_libc_FK;

	@Column(name = "id_usuta_FK")
	private String id_usuta_FK;
	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioLib() {
		return precioLib;
	}

	public void setPrecioLib(double precioLib) {
		this.precioLib = precioLib;
	}

	public int getDescuentoLib() {
		return descuentoLib;
	}

	public void setDescuentoLib(int descuentoLib) {
		this.descuentoLib = descuentoLib;
	}

	public int getId_libc_FK() {
		return id_libc_FK;
	}

	public void setId_libc_FK(int id_libc_FK) {
		this.id_libc_FK = id_libc_FK;
	}
	
	public String getId_usuta_FK() {
		return id_usuta_FK;
	}

	public void setId_usuta_FK(String id_usuta_FK) {
		this.id_usuta_FK = id_usuta_FK;
	}

	@Override
	public String toString() {
		return "Carrito [codigo=" + codigo + ", cant=" + cantidad + ", precioLib=" + precioLib + ", descuentoLib="
				+ descuentoLib + ", id_libc_FK=" + id_libc_FK + "]";
	}

	
}
