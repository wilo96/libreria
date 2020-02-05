package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="FacturaDets")
public class FacturaDet {
	@Id
	@Column(name = "codigo")
	//@GeneratedValue(strategy=GenerationType.AUTO )
	private int codigo;
	
	@Column(name = "id_faccab_fk")
	private int id_faccab_fk;
	
	@Column(name = "id_facd_FK")
	private int id_facd_FK;
	
	@Column(name="cant")
	private int cant;
	
	@Column(name="precioLib")
	private double precioLib;
	
	@Column(name="descuentoLib")
	private int descuentoLib;
	
	@NotEmpty
	@Column(name="subT")
	private double subt;
	
	@NotEmpty
	@Column(name="Total")
	private double total;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getId_faccab_fk() {
		return id_faccab_fk;
	}

	public void setId_faccab_fk(int id_faccab_fk) {
		this.id_faccab_fk = id_faccab_fk;
	}

	public int getId_facd_FK() {
		return id_facd_FK;
	}

	public void setId_facd_FK(int id_facd_FK) {
		this.id_facd_FK = id_facd_FK;
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

	public double getSubt() {
		return subt;
	}

	public void setSubt(double subt) {
		this.subt = subt;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "FacturaDet [codigo=" + codigo + ", id_faccab_fk=" + id_faccab_fk + ", id_facd_FK=" + id_facd_FK
				+ ", cant=" + cant + ", precioLib=" + precioLib + ", descuentoLib=" + descuentoLib + ", subt=" + subt
				+ ", total=" + total + "]";
	}


	
	
}
