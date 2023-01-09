package cl.findmydev.web.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "datos_Empresas")

public class DatoEmpresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nombre;

	@NotNull
	private String descripcion;

	private String foto;
	 
	 
		@Column(updatable=false)
		@DateTimeFormat(pattern="yyyy-MM-dd")

		private Date createdAt;
		

		@DateTimeFormat(pattern="yyyy-MM-dd")

		private Date updatedAt;


		
		
		//agregar a la columna la fecha antes de insertar 
		// date para mantener registro de fechas 
		 @PrePersist // antes de guardar agrega la fecha 
		    protected void onCreate(){
		        this.createdAt = new Date();
		    }
		 
		 // insertar en el atributo update o actualizar ese atributo ....
		    @PreUpdate
		    protected void onUpdate(){
		        this.updatedAt = new Date();
		    }




		    
		    
		    @JsonIgnore
			@OneToOne(mappedBy = "datoEmpresa",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
			private Reclutador reclutador;
		
		
		
		
		
		
		
}
