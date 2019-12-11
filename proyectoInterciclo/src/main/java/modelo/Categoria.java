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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="categorias")
@Table(name="categorias")
public class Categoria {
	
	@Id 
	@Column(name="codigo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	@NotEmpty
	@Column(name="descripcion")
	private String descripcion;
	
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cat_fk", referencedColumnName = "codigo")
	private List<Libro> libro;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo; 
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Libro> getLibro() {
		return libro;
	}
	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}
	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	

	
	
}
