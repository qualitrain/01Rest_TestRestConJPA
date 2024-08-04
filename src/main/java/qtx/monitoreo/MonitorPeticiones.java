package qtx.monitoreo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MonitorPeticiones
 * Ejemplifica cómo por medio de un HttpServletResponseWrapper se puede monitorear
 * o alterar el comportamiento de un objeto HttpServletResponse
 */
public class MonitorPeticiones implements Filter {

    /**
     * Default constructor. 
     */
    public MonitorPeticiones() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("---" + this.getClass().getSimpleName() +".doFilter() antes de chain.doFilter() ----");
		HttpServletRequest peticion = (HttpServletRequest) request;
		System.out.println("\t(MonPet) "+ peticion.getMethod() + " " + peticion.getRequestURI() );
		System.out.println("\t(MonPet) Charset default:" + Charset.defaultCharset().toString());
		
		peticion.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("\t(MonPet) " + peticion.getCharacterEncoding() + ", ContentType request:" + peticion.getContentType());
		mostrarParametrosPeticion(peticion);
		
		//Crea la respuesta alterada, que encierra el objeto de respuesta original y la envía a la cadena de filtrado
		ResponseMonitoreada respponseMonitoreada = new ResponseMonitoreada((HttpServletResponse) response);
		chain.doFilter(request, respponseMonitoreada);
		
		System.out.println("\t(MonPet)  --->" + this.getClass().getSimpleName() +".doFilter() despues de chain.doFilter() ----");
		System.out.println("\t(MonPet) CharacterEncoding response:" + response.getCharacterEncoding());
		System.out.println("\t(MonPet) ContentType response:" + response.getContentType());
	}

	private void mostrarParametrosPeticion(HttpServletRequest peticion) {
		Map<String, String[]> mapaParametros = peticion.getParameterMap();
		for(String paramI : mapaParametros.keySet()) {
			System.out.println(paramI + ":[" + mapaParametros.get(paramI)[0] + "]");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("\t(MonPet) " + this.getClass().getSimpleName() + ".init(...)");
		mostrarVariablesAmbienteYpropiedades();
	}

	private void mostrarVariablesAmbienteYpropiedades() {
		System.out.println("\t(MonPet) Variables de ambiente:----------------\n");
		System.getenv()
		      .forEach((k,v)->System.out.printf("\t(MonPet) %-20s : %s\n", k, v));
		
		System.out.println("\n\t(MonPet) Propiedades:-----------------------\n");
		System.getProperties()
		      .forEach((k,v)->System.out.printf("\t(MonPet) %-30s : %s\n", k, v));
	}

}
