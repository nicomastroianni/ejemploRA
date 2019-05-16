package ar.com.supervielle.api.entidades;

import java.util.ArrayList;
import java.util.List;

public class PersonaJuridica {

	 private String canal_creacion;
	 private Integer canal_distribucion;
	 private String canal_modificacion;
	 private Integer capital_total_empresa;
	 private String categoria;
	 private String codigo_pais;
	 private String descripcion_rubro;
	 private List<Domicilio> domicilios= new ArrayList<Domicilio>();
	 private List<Email> emails= new ArrayList<Email>() ;
	 private Boolean es_iva_consumidor_final;
	 private Boolean es_iva_exento;
	 private Boolean es_iva_no_responsable;
	 private Boolean es_iva_responsable_inscripto;
	 private Boolean es_iva_responsable_no_inscripto;
	 private Boolean es_sujeto_impuestos_internos;
	 private Estado estado_persona_expuesta_politicamente;
	 private String fecha_alta_bt;
	 private String fecha_baja_bt;
	 private String fecha_constitucion;
	 private String fecha_creacion;
	 private String fecha_de_creacion;
	 private String fecha_de_modificacion;
	 private String fecha_expiracion;
	 private String fecha_modificacion;
	 private Integer id;
	 private Integer naturaleza_juridica;
	 private String numero_documento;
	 private Integer numero_registro_legal;
	 private Integer otros_ajustes_al_patrimonio;
	 private Boolean presenta_balance;
	 private String razon_social;
	 private List<Telefono> telefonos= new ArrayList<Telefono>() ;
	 private String tipo_documento;
	 private String tipo_persona;
	 private Vinculos vinculos;
	 private ArrayList<ErroresAP> Errores= new ArrayList<ErroresAP>();
	public String getCanal_creacion() {
		return canal_creacion;
	}
	public void setCanal_creacion(String canal_creacion) {
		this.canal_creacion = canal_creacion;
	}
	public Integer getCanal_distribucion() {
		return canal_distribucion;
	}
	public void setCanal_distribucion(Integer canal_distribucion) {
		this.canal_distribucion = canal_distribucion;
	}
	public String getCanal_modificacion() {
		return canal_modificacion;
	}
	public void setCanal_modificacion(String canal_modificacion) {
		this.canal_modificacion = canal_modificacion;
	}
	public Integer getCapital_total_empresa() {
		return capital_total_empresa;
	}
	public void setCapital_total_empresa(Integer capital_total_empresa) {
		this.capital_total_empresa = capital_total_empresa;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCodigo_pais() {
		return codigo_pais;
	}
	public void setCodigo_pais(String codigo_pais) {
		this.codigo_pais = codigo_pais;
	}
	public String getDescripcion_rubro() {
		return descripcion_rubro;
	}
	public void setDescripcion_rubro(String descripcion_rubro) {
		this.descripcion_rubro = descripcion_rubro;
	}
	public List<Domicilio> getDomicilios() {
		return domicilios;
	}
	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	public Boolean getEs_iva_consumidor_final() {
		return es_iva_consumidor_final;
	}
	public void setEs_iva_consumidor_final(Boolean es_iva_consumidor_final) {
		this.es_iva_consumidor_final = es_iva_consumidor_final;
	}
	public Boolean getEs_iva_exento() {
		return es_iva_exento;
	}
	public void setEs_iva_exento(Boolean es_iva_exento) {
		this.es_iva_exento = es_iva_exento;
	}
	public Boolean getEs_iva_no_responsable() {
		return es_iva_no_responsable;
	}
	public void setEs_iva_no_responsable(Boolean es_iva_no_responsable) {
		this.es_iva_no_responsable = es_iva_no_responsable;
	}
	public Boolean getEs_iva_responsable_inscripto() {
		return es_iva_responsable_inscripto;
	}
	public void setEs_iva_responsable_inscripto(Boolean es_iva_responsable_inscripto) {
		this.es_iva_responsable_inscripto = es_iva_responsable_inscripto;
	}
	public Boolean getEs_iva_responsable_no_inscripto() {
		return es_iva_responsable_no_inscripto;
	}
	public void setEs_iva_responsable_no_inscripto(
			Boolean es_iva_responsable_no_inscripto) {
		this.es_iva_responsable_no_inscripto = es_iva_responsable_no_inscripto;
	}
	public Boolean getEs_sujeto_impuestos_internos() {
		return es_sujeto_impuestos_internos;
	}
	public void setEs_sujeto_impuestos_internos(Boolean es_sujeto_impuestos_internos) {
		this.es_sujeto_impuestos_internos = es_sujeto_impuestos_internos;
	}
	public Estado getEstado_persona_expuesta_politicamente() {
		return estado_persona_expuesta_politicamente;
	}
	public void setEstado_persona_expuesta_politicamente(
			Estado estado_persona_expuesta_politicamente) {
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
	public String getFecha_constitucion() {
		return fecha_constitucion;
	}
	public void setFecha_constitucion(String fecha_constitucion) {
		this.fecha_constitucion = fecha_constitucion;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
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
	public String getFecha_expiracion() {
		return fecha_expiracion;
	}
	public void setFecha_expiracion(String fecha_expiracion) {
		this.fecha_expiracion = fecha_expiracion;
	}
	public String getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNaturaleza_juridica() {
		return naturaleza_juridica;
	}
	public void setNaturaleza_juridica(Integer naturaleza_juridica) {
		this.naturaleza_juridica = naturaleza_juridica;
	}
	public String getNumero_documento() {
		return numero_documento;
	}
	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}
	public Integer getNumero_registro_legal() {
		return numero_registro_legal;
	}
	public void setNumero_registro_legal(Integer numero_registro_legal) {
		this.numero_registro_legal = numero_registro_legal;
	}
	public Integer getOtros_ajustes_al_patrimonio() {
		return otros_ajustes_al_patrimonio;
	}
	public void setOtros_ajustes_al_patrimonio(Integer otros_ajustes_al_patrimonio) {
		this.otros_ajustes_al_patrimonio = otros_ajustes_al_patrimonio;
	}
	public Boolean getPresenta_balance() {
		return presenta_balance;
	}
	public void setPresenta_balance(Boolean presenta_balance) {
		this.presenta_balance = presenta_balance;
	}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getTipo_persona() {
		return tipo_persona;
	}
	public void setTipo_persona(String tipo_persona) {
		this.tipo_persona = tipo_persona;
	}
	public Vinculos getVinculos() {
		return vinculos;
	}
	public void setVinculos(Vinculos vinculos) {
		this.vinculos = vinculos;
	}
	public ArrayList<ErroresAP> getErrores() {
		return Errores;
	}
	public void setErrores(ArrayList<ErroresAP> errores) {
		Errores = errores;
	}
	 
	 
	 

	}


