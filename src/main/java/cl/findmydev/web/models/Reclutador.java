package cl.findmydev.web.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="reclutadores")
	
public class Reclutador {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="usuario_id", referencedColumnName = "id") 
	private Usuario usuario;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dato_empresa_id", referencedColumnName = "id")
	private DatoEmpresa datoEmpresa;


}
