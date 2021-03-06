package frgp.tusi.lab5.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Cliente")
public class Cliente extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="id_cliente")
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
//	@OneToMany(fetch= FetchType.LAZY, mappedBy = "cliente")
//	private List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cliente() {
		super();
	}

}