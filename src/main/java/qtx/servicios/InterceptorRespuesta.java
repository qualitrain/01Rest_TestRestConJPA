package qtx.servicios;

import java.io.IOException;
import java.io.OutputStream;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Arrays;

import org.glassfish.jersey.message.internal.CommittingOutputStream;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;
import qtx.entidades.Armadora;
import qtx.entidades.ModeloAuto;
import qtx.monitoreo.PrintStreamMonitor;

@Provider
/**
 *  Comentar/Descomentar @Provider para desactivar/activar este interceptor. 
 *  Ejemplifica un Interceptor de Jersey
 *  
 *  Permite monitorear el Output Stream usado por jersey
 *  para generar la entidad (objeto) XML o JSON que ira en la respuesta http.
 *  Jersey debe serializar un objeto en Java a JSon o Xml. Deja los resultados en un objeto OutputStream.
 *  Accede a un objeto de contexto que tiene diversos elementos que pueden modificarse por
 *  el interceptor
 * 
 */
public class InterceptorRespuesta implements WriterInterceptor {

	public InterceptorRespuesta() {
		super();
		System.out.println("(IntJersey)  InterceptorRespuesta instanciado: " + this.hashCode());
	}

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		System.out.println("(IntJersey)  InterceptorRespuesta.aroundWriteTo()");
		
//      Para espiar el contexto:
		mostrarHeadersYpropertiesContext(context);		
		mostrarDetallesOutputStream(context);		
		mostrarDetallesEntity(context);
		
//      Para poner un proxy espía que nos permita monitorear el comportamiento del OutputStream
		PrintStreamMonitor ps = new PrintStreamMonitor(context.getOutputStream(),true,"ISO-8859-1");
		context.setOutputStream(ps);
		
		// Para permitir el paso al Message Writer que escribirá el objeto de respuesta
		context.proceed();

	}

	/**
	 * Se usó en su momento para explorar un contenido erróneo generado por problemas con ISO-8859-1.
	 * Ejemplifica un Normalizer. Consideremos que EL MISMO caracter especial (acentos, eñes, etc.)
	 * puede ocupar uno o varios caracteres o codepoints dependiendo del tipo de normalizacion usada
	 * para crear el String 
	 * @param cad
	 * @param etiqueta
	 */
	private void explorarCaracteresCad(String cad, String etiqueta) {
		int[] unicodes    = new int[cad.length()];
		char[] caracteres = new char[cad.length()];
		for(int i=0; i<cad.length(); i++) {
			unicodes[i] = cad.codePointAt(i);
			caracteres[i] = cad.charAt(i);
		}
		
		if(Normalizer.isNormalized(cad, Form.NFC))
			System.out.println("La cadena " + etiqueta + " está normalizada en forma " + Form.NFC);
		else
			System.out.println("La cadena " + etiqueta + " NO está normalizada en forma " + Form.NFC);
		
		System.out.println("\n(IntJersey)  " + etiqueta + ":" + cad);
		System.out.println("(IntJersey)  unicodes:" + Arrays.toString(unicodes));
		System.out.println("(IntJersey)  caracteres:" + Arrays.toString(caracteres));
		System.out.println("(IntJersey)  codePoints:" + cad.codePoints().count());
		
		if(cad.contains("ñ"))
			System.out.println("(IntJersey)  La cadena " + etiqueta 
					+ " contiene la letra eñe");
		else
			System.out.println("(IntJersey)  La cadena " + etiqueta
					+ " NO contiene la letra eñe");

	}

	private void mostrarDetallesEntity(WriterInterceptorContext context) {
		Class<?> tipo = context.getType();
		System.out.println("(IntJersey)  Type:" + tipo.getName());
		
		Object entidad = context.getEntity();
		System.out.println("(IntJersey)  Entidad:" + entidad.toString());
	}

	private void mostrarDetallesOutputStream(WriterInterceptorContext context) {
		Class<? extends OutputStream> clsOutStr = context.getOutputStream().getClass();
		String nomClaseOuStream = clsOutStr.getName();
		System.out.println("(IntJersey)  Clase Output Stream:" +  nomClaseOuStream);
		
		System.out.println("(IntJersey)  Interfaces simples implementadas:");
		if(Arrays.asList(clsOutStr.getInterfaces()).size() == 0)
			System.out.println("(IntJersey)  NINGUNA");			
		Arrays.asList(clsOutStr.getInterfaces())
			   .stream()
		       .map(clsI->clsI.getName())
		       .forEach(nom->System.out.println(nom));
		
		Class<?> supClsOutStr = clsOutStr.getSuperclass();
		if(supClsOutStr != null) {
			System.out.println("(IntJersey)  Superclase Output Stream:" +  supClsOutStr.getName());
		}
	}

	private void mostrarHeadersYpropertiesContext(WriterInterceptorContext context) {
		System.out.println("\n(IntJersey)  Headers");
		context.getHeaders()
		        .forEach((k,v)->System.out.printf("(IntJersey)  %20s :[%s]\n",k,v));
		
		System.out.println("\n(IntJersey)  Properties");
		context.getPropertyNames()
		       .forEach(propI->System.out.printf("(IntJersey)  %20s :[%s]\n",propI, context.getProperty(propI)));
	}

}
