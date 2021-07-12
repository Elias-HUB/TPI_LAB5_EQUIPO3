package frgp.tusi.lab5.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public class Persona {

	@Column
	protected String nombre;
	@Column
	protected String apellido;
	@Column
	protected Integer dni;
	@Column	
	protected String sexo;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="nacionalidad")
	protected Nacionalidad nacionalidad;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="provincia")
	protected Provincia provincia;
	
	@Column
	protected String fechaNacimiento;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="domicilio")
	protected Domicilio domicilio;
	
	@Column
	protected Boolean estado;
	
	public Persona() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
}
