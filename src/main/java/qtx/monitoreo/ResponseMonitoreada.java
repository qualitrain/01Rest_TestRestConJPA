package qtx.monitoreo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

public class ResponseMonitoreada extends HttpServletResponseWrapper {

	public ResponseMonitoreada(HttpServletResponse response) throws IOException {
		super(response);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		System.out.println("(Mrespwrap)  " + this.getClass().getName() + ".getOutputStream()");
		ServletOutputStream outputStream = super.getOutputStream();
		System.out.println("(Mrespwrap)  Impl de ServletOutputStream original:" + outputStream.getClass().getName());
		ProxyServletOutputStream proxyOs = new ProxyServletOutputStream(outputStream);
		return proxyOs;
	}
	
	@Override
	public String getCharacterEncoding() {
		System.out.println("(Mrespwrap)  " + this.getClass().getName() + ".getCharacterEncoding()");
		return super.getCharacterEncoding();
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
	   System.out.println("(Mrespwrap)  " + this.getClass().getName() + ".getWriter()");
	   return super.getWriter();
	}

}
