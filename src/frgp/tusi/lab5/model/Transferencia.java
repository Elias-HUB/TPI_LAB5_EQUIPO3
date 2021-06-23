package frgp.tusi.lab5.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transferencia")
public class Transferencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 
	@Column()
	private Integer idMovOrigen;
	@Column()
	private Integer idMovDestino;
	@Column()
	private Integer idCuentaOrigen;
	@Column()
	private Integer idCuentaDestino;
	
	
	public Transferencia(){}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getIdMovOrigen() {
		return idMovOrigen;
	}


	public void setIdMovOrigen(Integer idMovOrigen) {
		this.idMovOrigen = idMovOrigen;
	}


	public Integer getIdMovDestino() {
		return idMovDestino;
	}


	public void setIdMovDestino(Integer idMovDestino) {
		this.idMovDestino = idMovDestino;
	}


	public Integer getIdCuentaOrigen() {
		return idCuentaOrigen;
	}


	public void setIdCuentaOrigen(Integer idCuentaOrigen) {
		this.idCuentaOrigen = idCuentaOrigen;
	}


	public Integer getIdCuentaDestino() {
		return idCuentaDestino;
	}


	public void setIdCuentaDestino(Integer idCuentaDestino) {
		this.idCuentaDestino = idCuentaDestino;
	}
	
}
