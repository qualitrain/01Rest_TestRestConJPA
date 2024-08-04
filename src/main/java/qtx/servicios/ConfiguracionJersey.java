package qtx.servicios;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

//@ApplicationPath(value = "") 
/*
 * Descomentar para que el motor de Jersey tome en cuenta esta configuracion. No es necesario.
 * Se hizo originalmente para mopdificar propiedades de configuración de Jersey
 * En este momento, no se usa. Es solo un ejemplo de cómo hacerlo
*/                               
public class ConfiguracionJersey extends ResourceConfig 
{

	public ConfiguracionJersey() {
		super();
		System.out.println("Configurando Jersey...");
		packages("mx.qtx.PrimerProyRest","qtx.servicios");
	}

}
