package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="likes")
@Table(name="likes")
public class Like {

	@Id
	@Column(name="codigo")	
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int codigo;
	
	
	@Column(name = "id_lib_FK")
	private int id_lib_FK;
	
	@Column(name = "id_gustausu_FK")
	private String id_gustausu_FK;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getId_lib_FK() {
		return id_lib_FK;
	}

	public void setId_lib_FK(int id_lib_FK) {
		this.id_lib_FK = id_lib_FK;
	}

	public String getId_gustausu_FK() {
		return id_gustausu_FK;
	}

	public void setId_gustausu_FK(String id_gustausu_FK) {
		this.id_gustausu_FK = id_gustausu_FK;
	}

	@Override
	public String toString() {
		return "Like [codigo=" + codigo + ", id_lib_FK=" + id_lib_FK + ", id_gustausu_FK=" + id_gustausu_FK + "]";
	}
	
}
