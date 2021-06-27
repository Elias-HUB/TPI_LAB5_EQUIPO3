package frgp.tusi.lab5.modelImpl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movimiento")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column()
	private Integer idCuenta;
	@Column()
	private Integer idTipoMovimiento;
	@Column()
	private String detalle;
	@Column()
	private Integer importe;
	@Column()
	private Boolean estado;
	@Column()
	private Date fecha;
	@Column()
	private Date fechaUltimaModificacion;
	
	public Movimiento() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Integer getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public void setIdTipoMovimiento(Integer idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Integer getImporte() {
		return importe;
	}

	public void setImporte(Integer importe) {
		this.importe = importe;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
