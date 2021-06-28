package frgp.tusi.lab5.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transferencia")
public class Transferencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idMovOrigen")
	private Movimiento movimientoOrigen;
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idMovDestino")
	private Movimiento movimientoDestino;
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idCuentaOrigen")
	private Cuenta cuentaOrigen;
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="idCuentaDestino")
	private Cuenta cuentaDestino;
	
	
	public Transferencia(){}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Movimiento getMovimientoOrigen() {
		return movimientoOrigen;
	}


	public void setMovimientoOrigen(Movimiento movimientoOrigen) {
		this.movimientoOrigen = movimientoOrigen;
	}


	public Movimiento getMovimientoDestino() {
		return movimientoDestino;
	}


	public void setMovimientoDestino(Movimiento movimientoDestino) {
		this.movimientoDestino = movimientoDestino;
	}


	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}


	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}


	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}


	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
}
