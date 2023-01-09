package cl.findmydev.web.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "habilidades_blandas")
public class Habilidad_Blanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	private String descripcion;

	@NotNull
	private String nombre;
	

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	

	// atributos de control
	@PrePersist // agregar a la columna la fecha antes de insertar
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate // actualizar el atributo de created
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	//*****************Relaciones********** 
	//Relacion con postulante muchos es a muchos una habilidad puede tener mas 
	// de un Postulante & un postulante mas de una habilidad 
	// 
	@JsonIgnore
	@ManyToMany(mappedBy="habilidad_blanda",fetch= FetchType.LAZY)
	private List<Postulante> postulante;

}
