package frgp.tusi.lab5.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Cuenta")
public class Cuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	
//	@Id
//	@Column(name="")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Cuenta() {}

}
