package modelo;

import java.util.List;

import javax.management.relation.Relation;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity(name="libros")
@Table(name="libros")
public class Libros {
	 
	@Id
	@Column(name="codigo")	
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int codigo;
	
	@Column(name="titulo")	
	@NotEmpty
	private String titulo;
	
	@Column(name="autor")	
	@NotEmpty
	private String autor;
	
	@Column(name="editorial")	
	@NotEmpty
	private String editorial;
	
	@Column(name="aniopublicacion")
	private int aniopublicacion;
	
	@Column(name = "id_cat_fk")
	private int id_cat_fk;
	
	@Column(name="precio")	
	private double precio;
	
	@Column(name="descuento", length = 2)
	private int descuento;
	
	@Column(name="stock")
	private int stock;
	
	@Column(name="imagen")	
	private String imagen;
	
	/*@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_lib_fk", referencedColumnName = "codigo")
	private List<Like> likes;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_libc_fk", referencedColumnName = "codigo")
	private List<Carrito> carrito;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_facd_fk", referencedColumnName = "codigo")
	private List<FacturaDet> facdet;*/
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
/*
	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}

	public List<FacturaDet> getFacdet() {
		return facdet;
	}

	public void setFacdet(List<FacturaDet> facdet) {
		this.facdet = facdet;
	}
*/
	public int getAniopublicacion() {
		return aniopublicacion;
	}

	public void setAniopublicacion(int aniopublicacion) {
		this.aniopublicacion = aniopublicacion;
	}

	public int getId_cat_fk() {
		return id_cat_fk;
	}

	public void setId_cat_fk(int id_cat_fk) {
		this.id_cat_fk = id_cat_fk;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", aniopublicacion=" + aniopublicacion + ", id_cat_fk=" + id_cat_fk + ", precio=" + precio
				+ ", descuento=" + descuento + ", stock=" + stock + ", imagen=" + imagen + "]";
	}

	
	
	
}
