package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="carritos")
@Table(name="carritos")
public class Carrito {
	
	
	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy=GenerationType.AUTO )
	private int codigo;
	
	@NotEmpty
	@Column(name="cantidad", length = 3)
	private int cant;
	
	@NotEmpty
	@Column(name="precioLib")
	private double precioLib;
	
	@NotEmpty
	@Column(name="descuentoLib", length = 2)
	private int descuentoLib;
	
	@Column(name = "id_libc_FK")
	private int id_libc_FK;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
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

	@Override
	public String toString() {
		return "Carrito [codigo=" + codigo + ", cant=" + cant + ", precioLib=" + precioLib + ", descuentoLib="
				+ descuentoLib + ", id_libc_FK=" + id_libc_FK + "]";
	}

	
}
