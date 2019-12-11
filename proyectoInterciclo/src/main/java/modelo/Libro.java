package modelo;

import javax.management.relation.Relation;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="libros")
@Table(name="libros")
public class Libro {
	
	@Id
	@Column(name="codigo")	
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int codigo;
	
	@Column(name="descripcion")	
	@NotEmpty
	private String descripcion;
	
	@NotEmpty
	@Column(name="precio")	
	private double precio;
	
	@Column(name="descuento", length = 2)
	private int descuento;
	
	@ManyToOne
	private Categoria categoria;
	
	@Column(name="imagen")	
	private String imagen;
	
	@Column(name="votos")	
	private int votos;
	
	@Column(name="vendidos")	
	private int vendidos;
	
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	public int getVendidos() {
		return vendidos;
	}
	public void setVendidos(int vendidos) {
		this.vendidos = vendidos;
	}
	@Override
	public String toString() {
		return "libros [codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + ", descuento="
				+ descuento + ", categoria=" + categoria + ", imagen=" + imagen + ", votos=" + votos + ", vendidos="
				+ vendidos + "]";
	}
}
