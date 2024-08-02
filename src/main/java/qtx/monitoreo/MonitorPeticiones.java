package qtx.monitoreo;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MonitorPeticiones
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
		HttpServletRequest peticion = (HttpServletRequest) request;
		System.out.println(peticion.getMethod() + " " + peticion.getRequestURI() + "---------------------------");
		peticion.setCharacterEncoding("ISO-8859-1");
		System.out.println("" + peticion.getCharacterEncoding() + ", ContentType request:" + peticion.getContentType());
		Map<String, String[]> mapaParametros = peticion.getParameterMap();
		for(String paramI : mapaParametros.keySet()) {
			System.out.println(paramI + ":[" + mapaParametros.get(paramI)[0] + "]");
		}
		chain.doFilter(request, response);
		System.out.println("ContentType response:" + response.getContentType());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
