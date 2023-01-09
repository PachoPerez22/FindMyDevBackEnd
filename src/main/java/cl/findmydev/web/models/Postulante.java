package cl.findmydev.web.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "postulantes")
public class Postulante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}


	
    //*****RELACIONES ******
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="usuario_id", referencedColumnName = "id") 
	private Usuario usuario;
	
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dato_contacto_id", referencedColumnName = "id")
    private DatoContacto datoContacto;

	@OneToMany(mappedBy= "postulante",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Academica> academica;
	
	@OneToMany(mappedBy = "postulante",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Laboral> laboral;
	
	@OneToMany(mappedBy="postulante",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Proyecto> proyecto;
	
	@ManyToMany
	@JoinTable(
			name="hblandas_usuarios",
			joinColumns = @JoinColumn(name="postulante_id"),
			inverseJoinColumns = @JoinColumn(name="habilidad_blanda_id")	
			)
	private List<Habilidad_Blanda> habilidad_blanda;
	
	
	@ManyToMany
	@JoinTable(
			name="htecnicas_usuarios",
			joinColumns= @JoinColumn(name="postulante_id"),
			inverseJoinColumns= @JoinColumn(name="habilidad_tecnica_id")
			)
	private List<Habilidad_Tecnica> habilidad_tecnica;
	
	
	


}
