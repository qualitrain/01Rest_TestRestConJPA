package qtx.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="modelo")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class ModeloAuto {
	@Id
	private String claveModelo;
	private String nombre;
	@XmlTransient
	@ManyToOne
	@JoinColumn(name="claveArmadora")
	private Armadora armadora;
	private String version;
	private boolean importado;
	
	public ModeloAuto(String claveModelo, String nombre, Armadora armadora, 
			String version, boolean importado) {
		super();
		this.claveModelo = claveModelo;
		this.nombre = nombre;
		this.armadora = armadora;
		this.version = version;
		this.importado = importado;
	}

	public ModeloAuto() {
		super();
	}

	public String getClaveModelo() {
		return claveModelo;
	}

	public void setClaveModelo(String claveModelo) {
		this.claveModelo = claveModelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Armadora getArmadora() {
		return armadora;
	}

	public void setArmadora(Armadora armadora) {
		this.armadora = armadora;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isImportado() {
		return importado;
	}

	public void setImportado(boolean importado) {
		this.importado = importado;
	}

	@Override
	public String toString() {
		return "ModeloAuto [claveModelo=" + claveModelo + ", nombre=" + nombre + ", armadora=" + armadora.getClave() + ", version="
				+ version + ", importado=" + importado + "]";
	}
	
}
