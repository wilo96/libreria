package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="usuarios")
public class Usuario {
		@Id
		@Column(name="cedula")
		private String cedula;
		
		@NotEmpty
		@Column(name="nombres")
		private String nombres;
		
		@NotEmpty
		@Column(name="direccion")
		private String direccion;
		
		@NotEmpty
		@Column(name="telefono")
		private String telefono;
		
		@NotEmpty
		@Column(name="correo")
		private String correo;
		
		@NotEmpty
		@Column(name="contrasenia")
		private String contrasenia;
		
		@Column(name="administrador")
		private String administrador;
		
		@Column(name="imagen")
		private String imagen;
		
		@Column(name="ventas")
		private int ventas;
		
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
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
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
		public int getVentas() {
			return ventas;
		}
		public void setVentas(int ventas) {
			this.ventas = ventas;
		}
		@Override
		public String toString() {
			return "usuario [cedula=" + cedula + ", nombres=" + nombres + ", direccion=" + direccion + ", telefono="
					+ telefono + ", correo=" + correo + ", contrasenia=" + contrasenia + ", administrador="
					+ administrador + ", imagen=" + imagen + "]";
		}
		
}
