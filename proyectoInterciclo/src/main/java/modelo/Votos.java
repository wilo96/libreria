package modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "votos")
public class Votos {
	
	@Id
	@Column(name="codigo")
	private int codigo;
	
	@Column(name = "id_prod")
	private int id_prod;
	
	@Column(name = "conteo")
	private int conteo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getId_prod() {
		return id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	public int getConteo() {
		return conteo;
	}

	public void setConteo(int conteo) {
		this.conteo = conteo;
	}

	@Override
	public String toString() {
		return "Votos [codigo=" + codigo + ", id_prod=" + id_prod + ", conteo=" + conteo + "]";
	}
	
	
	

}
