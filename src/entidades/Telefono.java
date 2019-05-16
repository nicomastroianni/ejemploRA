package ar.com.supervielle.api.entidades;

public class Telefono {

	private String compania;
    private String declarado;
    private String fecha_creacion;
    private String fecha_modificacion;
    private int id;
    private String no_llame;
    private String normalizado;
    private String numero;
    private String origen_contacto;
    private String tipo_contacto;
    private String tipo_telefono;
	
    //AGREGAR 26.03.2019
    private int caracteristica;
    private String cargo_interlocutor;
    private String ddi;
    private String ddn;
    private boolean es_geografico;
    private String fecha_ultimo_cambio_no_llame;
    private int interno;
    private String nombre_interlocutor;
    private int numero_telefono;
    private String pais;
    private boolean registro_anterior_no_llame;
    private int score;
    
    public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public String getDeclarado() {
		return declarado;
	}
	public void setDeclarado(String declarado) {
		this.declarado = declarado;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo_llame() {
		return no_llame;
	}
	public void setNo_llame(String no_llame) {
		this.no_llame = no_llame;
	}
	public String getNormalizado() {
		return normalizado;
	}
	public void setNormalizado(String normalizado) {
		this.normalizado = normalizado;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getOrigen_contacto() {
		return origen_contacto;
	}
	public void setOrigen_contacto(String origen_contacto) {
		this.origen_contacto = origen_contacto;
	}
	public String getTipo_contacto() {
		return tipo_contacto;
	}
	public void setTipo_contacto(String tipo_contacto) {
		this.tipo_contacto = tipo_contacto;
	}
	public String getTipo_telefono() {
		return tipo_telefono;
	}
	public void setTipo_telefono(String tipo_telefono) {
		this.tipo_telefono = tipo_telefono;
	}
	public int getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(int caracteristica) {
		this.caracteristica = caracteristica;
	}
	public String getCargo_interlocutor() {
		return cargo_interlocutor;
	}
	public void setCargo_interlocutor(String cargo_interlocutor) {
		this.cargo_interlocutor = cargo_interlocutor;
	}
	public String getDdi() {
		return ddi;
	}
	public void setDdi(String ddi) {
		this.ddi = ddi;
	}
	public String getDdn() {
		return ddn;
	}
	public void setDdn(String ddn) {
		this.ddn = ddn;
	}
	public boolean isEs_geografico() {
		return es_geografico;
	}
	public void setEs_geografico(boolean es_geografico) {
		this.es_geografico = es_geografico;
	}
	public String getFecha_ultimo_cambio_no_llame() {
		return fecha_ultimo_cambio_no_llame;
	}
	public void setFecha_ultimo_cambio_no_llame(String fecha_ultimo_cambio_no_llame) {
		this.fecha_ultimo_cambio_no_llame = fecha_ultimo_cambio_no_llame;
	}
	public int getInterno() {
		return interno;
	}
	public void setInterno(int interno) {
		this.interno = interno;
	}
	public String getNombre_interlocutor() {
		return nombre_interlocutor;
	}
	public void setNombre_interlocutor(String nombre_interlocutor) {
		this.nombre_interlocutor = nombre_interlocutor;
	}
	public int getNumero_telefono() {
		return numero_telefono;
	}
	public void setNumero_telefono(int numero_telefono) {
		this.numero_telefono = numero_telefono;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public boolean isRegistro_anterior_no_llame() {
		return registro_anterior_no_llame;
	}
	public void setRegistro_anterior_no_llame(boolean registro_anterior_no_llame) {
		this.registro_anterior_no_llame = registro_anterior_no_llame;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

    	
}
