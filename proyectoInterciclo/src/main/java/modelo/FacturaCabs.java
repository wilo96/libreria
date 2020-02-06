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

@Entity
@Table(name="facturacabs")
public class FacturaCabs {

	@Id
	@Column(name = "codigo")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	
	@Column(name = "id_usufc_fk")
	private String id_usufc_FK;
	
	@Column(name = "id_direcc_fk")
	private int id_direcc_FK;
	
	@Column(name = "id_tarjet_fk")
	private int id_tarjet_FK;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_faccab_fk", referencedColumnName = "codigo")
	private List<FacturaDet> id_faccab_fk;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	

	public String getId_usufc_FK() {
		return id_usufc_FK;
	}

	public void setId_usufc_FK(String id_usufc_FK) {
		this.id_usufc_FK = id_usufc_FK;
	}

	public int getId_direcc_FK() {
		return id_direcc_FK;
	}

	public void setId_direcc_FK(int id_direcc_FK) {
		this.id_direcc_FK = id_direcc_FK;
	}

	public int getId_tarjet_FK() {
		return id_tarjet_FK;
	}

	public void setId_tarjet_FK(int id_tarjet_FK) {
		this.id_tarjet_FK = id_tarjet_FK;
	}

	public List<FacturaDet> getId_faccab_fk() {
		return id_faccab_fk;
	}

	public void setId_faccab_fk(List<FacturaDet> id_faccab_fk) {
		this.id_faccab_fk = id_faccab_fk;
	}

	@Override
	public String toString() {
		return "FacturaCabs [codigo=" + codigo + ", id_usufc_FK=" + id_usufc_FK + ", id_direcc_FK=" + id_direcc_FK
				+ ", id_tarjet_FK=" + id_tarjet_FK + "]";
	}






	
	

	
}
