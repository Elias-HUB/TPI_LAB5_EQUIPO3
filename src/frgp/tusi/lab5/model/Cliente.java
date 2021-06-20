package frgp.tusi.lab5.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(name="")
// @GeneratedValue(strategy=GenerationType.AUTO)
	public Cliente() {}

}
