package qtx.monitoreo;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

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
		Map<String, String[]> mapaParametros = peticion.getParameterMap();
		for(String paramI : mapaParametros.keySet()) {
			System.out.println(paramI + ":[" + mapaParametros.get(paramI)[0] + "]");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
