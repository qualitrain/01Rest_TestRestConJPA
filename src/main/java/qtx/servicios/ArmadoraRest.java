package qtx.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import qtx.entidades.Armadora;
import qtx.entidades.ModeloAuto;
import qtx.persistencia.GestorDatosJPA;
import qtx.persistencia.IGestorDatos;
import qtx.persistencia.PersistenciaException;

@Path("armadoras")
public class ArmadoraRest {
	private IGestorDatos gestorDatos;

	public ArmadoraRest(IGestorDatos gestorDatos) {
		System.out.println("(API) " + this.getClass().getName() + ".ArmadoraRest(" + gestorDatos + ")");
		this.gestorDatos = gestorDatos;
	}

	public ArmadoraRest() {
		System.out.println("(API) " + this.getClass().getName() + ".ArmadoraRest()");
		try {
			this.gestorDatos = new GestorDatosJPA();
		}
		catch(PersistenciaException pex) {
			System.out.println(pex.getMessage());
			Throwable t = pex.getCause();
			while(t != null) {
				System.out.println("causa: " + t.getClass().getName() + "->" +  t.getMessage());
				t = t.getCause();
			}			
		}
	}

	public IGestorDatos getGestorDatos() {
		return gestorDatos;
	}

	public void setGestorDatos(IGestorDatos gestorDatos) {
		this.gestorDatos = gestorDatos;
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getArmadoras(){
		List<Armadora> listaArmadoras = 
				new ArrayList<Armadora>(this.gestorDatos.getArmadorasTodas());
		return listaArmadoras.toString();
	}
	@Path("id")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getArmadoraXID_texto(
			@QueryParam("cve")
			@DefaultValue("000000")
			String cveArmadora) {
		Armadora armadora = this.gestorDatos.getArmadoraXID(cveArmadora);
		if(armadora == null) {
			return "Armadora con cve " + cveArmadora + " NO EXISTE";
		}
		return armadora.toString();
	}
	@Path("id")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getArmadoraXID_html(
			@QueryParam("cve")
			@DefaultValue("000000")
			String cveArmadora) {
		Armadora armadora = this.gestorDatos.getArmadoraXID(cveArmadora);
		if(armadora == null) {
			return "<span style='color:red;'>Armadora con cve " + cveArmadora + " NO EXISTE</span>";
		}
		return armadora.toHtml();
	}
	
	@Path("{cve}")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Armadora getArmadoraXID_JSonXML(
			@PathParam("cve")
			@DefaultValue("000000")
			String cveArmadora) {
		System.out.println("(API) " + this.getClass().getName() + ".getArmadoraXID_JSonXML(" + cveArmadora + ")");
		Armadora armadora = this.gestorDatos.getArmadoraXID(cveArmadora);
		System.out.println("(API) " + armadora);			
		return armadora;
	}
	
	@GET
	@Path("{cve}/modelos")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<ModeloAuto> getModelosXarmadora(
			@PathParam("cve")
			String cveArmadora){
		Armadora armadora = this.gestorDatos.getArmadoraConModelosXID(cveArmadora);
		if(armadora == null)
			return null;
		Set<ModeloAuto> modelos = armadora.getModelos();
		
		return new ArrayList<ModeloAuto>(modelos);
	}
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Armadora> getArmadorasXml(){
		List<Armadora> listaArmadoras = 
				new ArrayList<Armadora>(this.gestorDatos.getArmadorasTodas());
		
		return listaArmadoras;
	}
	@POST
	@Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String insertarArmadora(
			@FormParam("clave")
			String clave, 
			@FormParam("nombre")
			String nombre,
			@FormParam("pais")
			String pais, 
			@FormParam("nplantas")
			@DefaultValue("0")
			int nPlantas) {
		String error = this.validarDatosArmadora(clave,nombre,pais,nPlantas);
		if(error != null)
			return error;
		Armadora nvaArmadora = new Armadora(clave,nombre,pais,nPlantas);
		nvaArmadora = this.gestorDatos.insertarArmadora(nvaArmadora);
		return nvaArmadora.toString();
	}
	@POST
	@Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertarArmadora_Json(Armadora nvaArmadora){
		String error = this.validarDatosArmadora(nvaArmadora);
		if(error != null)
			return error;
		nvaArmadora = this.gestorDatos.insertarArmadora(nvaArmadora);
		return nvaArmadora.toString();
	}
	@PUT
	@Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	public String actualizarArmadora_Json(Armadora armadora){
		String error = this.validarDatosArmadoraUpdate(armadora);
		if(error != null)
			return error;
		armadora = this.gestorDatos.actualizarArmadora(armadora);
		return armadora.toString();
	}

	private String validarDatosArmadoraUpdate(Armadora armadora) {
		return this.validarDatosArmadoraUpdate(armadora.getClave(),armadora.getNombre(), 
                armadora.getPaisOrigen(), armadora.getnPlantas());
	}

	private String validarDatosArmadora(Armadora armadora) {
		return this.validarDatosArmadora(armadora.getClave(),armadora.getNombre(), 
				                         armadora.getPaisOrigen(), armadora.getnPlantas());
	}

	private String validarDatosArmadora(String clave, String nombre, String pais, int nPlantas) {
		String camposVacios = "";
		if (campoVacio(clave))
			camposVacios += "clave, ";
		if (campoVacio(nombre))
			camposVacios += "nombre, ";
		if (campoVacio(pais))
			camposVacios += "pais, ";
		if(camposVacios.isEmpty() == false)
			return "Error, faltan los campos: " + camposVacios;
		Armadora armadora = this.gestorDatos.getArmadoraXID(clave);
		if(armadora != null)
			return "Error, ya existe una armadora con esa clave:" + armadora;
		return null;
	}
	private String validarDatosArmadoraUpdate(String clave, String nombre, String pais, int nPlantas) {
		String camposVacios = "";
		if (campoVacio(clave))
			camposVacios += "clave, ";
		if (campoVacio(nombre))
			camposVacios += "nombre, ";
		if (campoVacio(pais))
			camposVacios += "pais, ";
		if(camposVacios.isEmpty() == false)
			return "Error, faltan los campos: " + camposVacios;
		Armadora armadora = this.gestorDatos.getArmadoraXID(clave);
		if(armadora == null)
			return "Error, No existe una armadora con esa clave:" + armadora.getClave();
		return null;
	}

	private boolean campoVacio(String campo) {
		if(campo == null)
			return true;
		if(campo.trim().isEmpty())
			return true;
		return false;
	}
}
