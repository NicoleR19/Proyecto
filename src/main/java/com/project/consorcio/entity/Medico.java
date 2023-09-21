package com.project.consorcio.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_medico")
public class Medico {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="cod_med")
	    private Integer codigo;
	    @Column(name="nom_med")
	    private String nombre;
	    @Column(name="ape_med")
	    private String apellido;
	    @Column(name="fec_nac_med")
	    private LocalDate fechanacimiento;
	    @Column(name="sexo_med")
	    private String sexo;
	    @Column(name="est_civ_med")
	    private String estadocivil;
	    @Column(name="dni_med")
	    private String dni;
	    @Column(name="sue_med")
	    private double sueldo;
	    @Column(name="dir_emp")
	    private String direccionem;
	    
	  //relacion muchos a uno
	      
	      @ManyToOne
	      @JoinColumn(name="cod_espe")
	      private Especialidad espe;//ASOC
	      @ManyToOne
	      @JoinColumn(name="cod_sede")
	      private Sede sede;//ASOC
	      @ManyToOne
	      @JoinColumn(name="cod_dis")
	      private Distrito dis;//ASOC
	      
	      
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
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public LocalDate getFechanacimiento() {
			return fechanacimiento;
		}
		public void setFechanacimiento(LocalDate fechanacimiento) {
			this.fechanacimiento = fechanacimiento;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public String getEstadocivil() {
			return estadocivil;
		}
		public void setEstadocivil(String estadocivil) {
			this.estadocivil = estadocivil;
		}
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public double getSueldo() {
			return sueldo;
		}
		public void setSueldo(double sueldo) {
			this.sueldo = sueldo;
		}
		public String getDireccionem() {
			return direccionem;
		}
		public void setDireccionem(String direccionem) {
			this.direccionem = direccionem;
		}
		public Especialidad getEspe() {
			return espe;
		}
		public void setEspe(Especialidad espe) {
			this.espe = espe;
		}
		public Sede getSede() {
			return sede;
		}
		public void setSede(Sede sede) {
			this.sede = sede;
		}
		public Distrito getDis() {
			return dis;
		}
		public void setDis(Distrito dis) {
			this.dis = dis;
		}
		
	      
	    

}
