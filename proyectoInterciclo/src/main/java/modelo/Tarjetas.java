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
@Table(name="tarjetas")
public class Tarjetas {
	@Id
	@Column(name="codigo")
	@GeneratedValue(strategy=GenerationType.AUTO )
	private int codigo;
	
	@NotEmpty
	@Column(name="numTarj")
	private String numTarj;
	
	@NotEmpty
	@Column(name="codVerif")
	private String codVerif;
	
	@NotEmpty
	@Column(name="empTarj")
	private String empTarj;
	
	@Column(name = "id_usuta_fk")
	private String id_usuta_FK;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tarjet_fk", referencedColumnName = "codigo")
	private List<FacturaCabs> facturacab;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumTarj() {
		return numTarj;
	}

	public void setNumTarj(String numTarj) {
		this.numTarj = numTarj;
	}

	public String getCodVerif() {
		return codVerif;
	}

	public void setCodVerif(String codVerif) {
		this.codVerif = codVerif;
	}

	public String getEmpTarj() {
		return empTarj;
	}

	public void setEmpTarj(String empTarj) {
		this.empTarj = empTarj;
	}

	

	public String getId_usuta_FK() {
		return id_usuta_FK;
	}

	public void setId_usuta_FK(String id_usuta_FK) {
		this.id_usuta_FK = id_usuta_FK;
	}

	
	
	public List<FacturaCabs> getFacturacab() {
		return facturacab;
	}

	public void setFacturacab(List<FacturaCabs> facturacab) {
		this.facturacab = facturacab;
	}

	@Override
	public String toString() {
		return "Tarjeta [codigo=" + codigo + ", numTarj=" + numTarj + ", codVerif=" + codVerif + ", empTarj=" + empTarj
				+ ", id_usuta_FK=" + id_usuta_FK + "]";
	}
	
}
