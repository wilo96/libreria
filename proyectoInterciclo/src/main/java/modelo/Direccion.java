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

@Entity(name="direcciones")
@Table(name="direcciones")
<<<<<<< Upstream, based on branch 'master' of https://github.com/wilo96/libreria.git
public class Direccion {
	@Id
=======
public class Direccion {
	
	@Id 
>>>>>>> 2f25540 Actualizacion de Clases
	@Column(name="codigo")
	@GeneratedValue(strategy=GenerationType.AUTO )
	private int codigo;
	
	@NotEmpty
	@Column(name="callePrinc")
	private String callePrinc;
	
	@NotEmpty
	@Column(name="calleSec")
	private String calleSec;
	
	@NotEmpty
	@Column(name="numCasa")
	private String numCasa;
	
	@NotEmpty
	@Column(name="ciudad")
	private String ciudad;
	
	@NotEmpty
	@Column(name="provincia")
	private String provincia;
	
	@Override
	public String toString() {
		return "Direccion [codigo=" + codigo + ", callePrinc=" + callePrinc + ", calleSec=" + calleSec + ", numCasa="
				+ numCasa + ", ciudad=" + ciudad + ", provincia=" + provincia + ", id_usu_FK=" + id_usu_FK + "]";
	}

	@Column(name = "id_usu_FK")
	private String id_usu_FK;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_direcc_FK", referencedColumnName = "codigo")
	private List<FacturaCab> facturacab;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCallePrinc() {
		return callePrinc;
	}

	public void setCallePrinc(String callePrinc) {
		this.callePrinc = callePrinc;
	}

	public String getCalleSec() {
		return calleSec;
	}

	public void setCalleSec(String calleSec) {
		this.calleSec = calleSec;
	}

	public String getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getId_usu_FK() {
		return id_usu_FK;
	}

	public void setId_usu_FK(String id_usu_FK) {
		this.id_usu_FK = id_usu_FK;
	}

	public List<FacturaCab> getFacturacab() {
		return facturacab;
	}

	public void setFacturacab(List<FacturaCab> facturacab) {
		this.facturacab = facturacab;
	}
	
	
}
