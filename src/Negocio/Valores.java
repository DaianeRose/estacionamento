package Negocio;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="valores")
public class Valores{
	
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Integer idvalores;
	
	
	@Column
	private float horista;
	@Column
	private float mensalista;
	
	public Valores(float newHorista, float newMensalista){
		this.horista = newHorista;
		this.mensalista = newMensalista;
	}
	
	public Valores(int id){
		this.idvalores=id;
	}
	
	public Valores(){
		
	}
	
	public float getMensalista(){
		return this.mensalista;
	}
	
	public float getHorista(){
		return this.horista;
	}
	
	public int getIdvalores() {
		return this.idvalores;
	}
	
	
	public void setMensalista(float newMensalista){
		this.mensalista = newMensalista;
	}

	public void setHorista(float newHorista){
		this.horista = newHorista;
	}	
}