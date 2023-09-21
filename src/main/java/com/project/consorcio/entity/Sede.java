package com.project.consorcio.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_sede")
public class Sede {
	      @Id
	      @GeneratedValue (strategy = GenerationType.IDENTITY)
	      @Column(name="cod_sede")
	      private Integer codigo;
	      @Column(name="nom_sede")
	      private String nombre;
	      
	      //relacion uno a muchos 
	         @OneToMany(mappedBy = "sede")//ASOC
	         private List<Medico> sede;

			public Integer getCodigo() {
				return codigo;
			}

			public void setCodigo(Integer codigo) {
				this.codigo = codigo;
			}

			public String getNombre() {
				return nombre;
			}

			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			public List<Medico> getSede() {
				return sede;
			}

			public void setSede(List<Medico> sede) {
				this.sede = sede;
			}
	         
	         
	      

}
