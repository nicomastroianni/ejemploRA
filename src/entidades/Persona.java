package ar.com.supervielle.api.entidades;

import java.util.ArrayList;
import java.util.List;

public class Persona {

	  private int id;
	  private String nombre;
	  private String apellido;
//	  private String[] emails;
//	  private String[] telefonos;
//	  private String[] domicilios;
	  private List<Email> emails= new ArrayList<Email>() ;
	  private List<Telefono> telefonos= new ArrayList<Telefono>() ;
	  private List<Domicilio> domicilios= new ArrayList<Domicilio>();
	  private String genero;
	  private String oficial_referente;
	  private String oficial_propietario;
	  private String canal_creacion;
	  private String tipo_documento;
	  private String numero_documento;
	  private String codigo_pais;
	  private String codigo_sucursal;
	  private String fecha_creacion;
	  private String fecha_modificacion;
	  private String fecha_nacimiento;
	  private String segmento_potencial;
	  private String tipo_tributario;
	  private String numero_tributario;
	  private String estado_civil;
	  private boolean es_titular;
	  
	  private ArrayList<ErroresAP> Errores= new ArrayList<ErroresAP>();
	  
	  //AGREGADOS 26.03.2019
	  private int canal_distribucion;
	  private String canal_modificacion;
	  private String categoria;
	  private boolean es_iva_consumidor_final;
	  private boolean es_iva_exento;
	  private boolean es_iva_no_responsable;
	  private boolean es_iva_responsable_inscripto;
	  private boolean es_iva_responsable_no_inscripto;
	  private boolean es_sujeto_impuestos_internos;
	  private EstadoPersonaExpuestaPoliticamenteDto estado_persona_expuesta_politicamente;
	  private String fecha_alta_bt;
	  private String fecha_baja_bt;
	  private String fecha_de_creacion;
	  private String fecha_de_modificacion;
	  private int paquete;
	  private String tipo_persona;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	public List<Domicilio> getDomicilios() {
		return domicilios;
	}
	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getOficial_referente() {
		return oficial_referente;
	}
	public void setOficial_referente(String oficial_referente) {
		this.oficial_referente = oficial_referente;
	}
	public String getOficial_propietario() {
		return oficial_propietario;
	}
	public void setOficial_propietario(String oficial_propietario) {
		this.oficial_propietario = oficial_propietario;
	}
	public String getCanal_creacion() {
		return canal_creacion;
	}
	public void setCanal_creacion(String canal_creacion) {
		this.canal_creacion = canal_creacion;
	}
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getNumero_documento() {
		return numero_documento;
	}
	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}
	public String getCodigo_pais() {
		return codigo_pais;
	}
	public void setCodigo_pais(String codigo_pais) {
		this.codigo_pais = codigo_pais;
	}
	public String getCodigo_sucursal() {
		return codigo_sucursal;
	}
	public void setCodigo_sucursal(String codigo_sucursal) {
		this.codigo_sucursal = codigo_sucursal;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getSegmento_potencial() {
		return segmento_potencial;
	}
	public void setSegmento_potencial(String segmento_potencial) {
		this.segmento_potencial = segmento_potencial;
	}
	public String getTipo_tributario() {
		return tipo_tributario;
	}
	public void setTipo_tributario(String tipo_tributario) {
		this.tipo_tributario = tipo_tributario;
	}
	public String getNumero_tributario() {
		return numero_tributario;
	}
	public void setNumero_tributario(String numero_tributario) {
		this.numero_tributario = numero_tributario;
	}
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	public boolean isEs_titular() {
		return es_titular;
	}
	public void setEs_titular(boolean es_titular) {
		this.es_titular = es_titular;
	}
	public ArrayList<ErroresAP> getErrores() {
		return Errores;
	}
	public void setErrores(ArrayList<ErroresAP> errores) {
		Errores = errores;
	}
	public int getCanal_distribucion() {
		return canal_distribucion;
	}
	public void setCanal_distribucion(int canal_distribucion) {
		this.canal_distribucion = canal_distribucion;
	}
	public String getCanal_modificacion() {
		return canal_modificacion;
	}
	public void setCanal_modificacion(String canal_modificacion) {
		this.canal_modificacion = canal_modificacion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean isEs_iva_consumidor_final() {
		return es_iva_consumidor_final;
	}
	public void setEs_iva_consumidor_final(boolean es_iva_consumidor_final) {
		this.es_iva_consumidor_final = es_iva_consumidor_final;
	}
	public boolean isEs_iva_exento() {
		return es_iva_exento;
	}
	public void setEs_iva_exento(boolean es_iva_exento) {
		this.es_iva_exento = es_iva_exento;
	}
	public boolean isEs_iva_no_responsable() {
		return es_iva_no_responsable;
	}
	public void setEs_iva_no_responsable(boolean es_iva_no_responsable) {
		this.es_iva_no_responsable = es_iva_no_responsable;
	}
	public boolean isEs_iva_responsable_inscripto() {
		return es_iva_responsable_inscripto;
	}
	public void setEs_iva_responsable_inscripto(boolean es_iva_responsable_inscripto) {
		this.es_iva_responsable_inscripto = es_iva_responsable_inscripto;
	}
	public boolean isEs_iva_responsable_no_inscripto() {
		return es_iva_responsable_no_inscripto;
	}
	public void setEs_iva_responsable_no_inscripto(
			boolean es_iva_responsable_no_inscripto) {
		this.es_iva_responsable_no_inscripto = es_iva_responsable_no_inscripto;
	}
	public boolean isEs_sujeto_impuestos_internos() {
		return es_sujeto_impuestos_internos;
	}
	public void setEs_sujeto_impuestos_internos(boolean es_sujeto_impuestos_internos) {
		this.es_sujeto_impuestos_internos = es_sujeto_impuestos_internos;
	}
	public EstadoPersonaExpuestaPoliticamenteDto getEstado_persona_expuesta_politicamente() {
		return estado_persona_expuesta_politicamente;
	}
	public void setEstado_persona_expuesta_politicamente(
			EstadoPersonaExpuestaPoliticamenteDto estado_persona_expuesta_politicamente) {
		this.estado_persona_expuesta_politicamente = estado_persona_expuesta_politicamente;
	}
	public String getFecha_alta_bt() {
		return fecha_alta_bt;
	}
	public void setFecha_alta_bt(String fecha_alta_bt) {
		this.fecha_alta_bt = fecha_alta_bt;
	}
	public String getFecha_baja_bt() {
		return fecha_baja_bt;
	}
	public void setFecha_baja_bt(String fecha_baja_bt) {
		this.fecha_baja_bt = fecha_baja_bt;
	}
	public String getFecha_de_creacion() {
		return fecha_de_creacion;
	}
	public void setFecha_de_creacion(String fecha_de_creacion) {
		this.fecha_de_creacion = fecha_de_creacion;
	}
	public String getFecha_de_modificacion() {
		return fecha_de_modificacion;
	}
	public void setFecha_de_modificacion(String fecha_de_modificacion) {
		this.fecha_de_modificacion = fecha_de_modificacion;
	}
	public int getPaquete() {
		return paquete;
	}
	public void setPaquete(int paquete) {
		this.paquete = paquete;
	}
	public String getTipo_persona() {
		return tipo_persona;
	}
	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
	}

	  
	  
	  
	  
	  


	}


