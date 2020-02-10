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

@Entity(name="usuarios")
@Table(name="usuarios")
public class Usuarios {
	
		@Id
		@Column(name="cedula")
		private String cedula;
		
		@NotEmpty
		@Column(name="nombres")
		private String nombres;
		
		@NotEmpty
		@Column(name="telefono")
		private String telefono;
		
		@NotEmpty
		@Column(name="correo")
		private String correo;
		
		@NotEmpty
		@Column(name="contrasenia")
		private String contrasenia;
		
		/*@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name = "id_usuta_fk", referencedColumnName = "cedula")
		private List<Carritos> id_usuta_FK;*/
		/*
		@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
		@JoinColumn(name = "id_gustausu_fk", referencedColumnName = "cedula")
		private List<Like> gusta;
		*/
		@Column(name="administrador")
		private String administrador;
		
		@Column(name="imagen")
		private String imagen;
		
		@Column(name="direccionDefecto")
		private String direccionDefecto;		
		/*
		@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name = "id_usu_fk", referencedColumnName = "cedula")
		private List<Direccion> direccion;
		
		@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name = "id_usuta_fk", referencedColumnName = "cedula")
		private List<Tarjeta> tarjeta;
		
		@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
		@JoinColumn(name = "id_usufc_fk", referencedColumnName = "cedula")
		private List<FacturaCab> facturacab;
*/

		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}

		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		public String getContrasenia() {
			return contrasenia;
		}
		public void setContrasenia(String contrasenia) {
			this.contrasenia = contrasenia;
		}
		public String getAdministrador() {
			return administrador;
		}
		public void setAdministrador(String administrador) {
			this.administrador = administrador;
		}
		public String getImagen() {
			return imagen;
		}
		public void setImagen(String imagen) {
			this.imagen = imagen;
		}	
		/*
		
		public List<Direccion> getDireccion() {
			return direccion;
		}
		public void setDireccion(List<Direccion> direccion) {
			this.direccion = direccion;
		}
		
		
		public List<Tarjeta> getTarjeta() {
			return tarjeta;
		}
		public void setTarjeta(List<Tarjeta> tarjeta) {
			this.tarjeta = tarjeta;
		}
		public List<FacturaCab> getFacturacab() {
			return facturacab;
		}
		public void setFacturacab(List<FacturaCab> facturacab) {
			this.facturacab = facturacab;
		}
		 */
		public String getDireccionDefecto() {
			return direccionDefecto;
		}
		public void setDireccionDefecto(String direccionDefecto) {
			this.direccionDefecto = direccionDefecto;
		}

		@Override
		public String toString() {
			return "Usuario [cedula=" + cedula + ", nombres=" + nombres + ", telefono=" + telefono + ", correo="
					+ correo + ", contrasenia=" + contrasenia + ", administrador=" + administrador + ", imagen="
					+ imagen + ", direccionDefecto=" + direccionDefecto + "]";
		}
		/*
		public void setGusta(List<Like> gusta) {
			this.gusta = gusta;
		}

		*/
}
