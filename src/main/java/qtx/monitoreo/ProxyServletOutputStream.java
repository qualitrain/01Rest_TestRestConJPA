package qtx.monitoreo;

import java.io.IOException;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;

public class ProxyServletOutputStream extends ServletOutputStream {

	private ServletOutputStream sos;

	public ProxyServletOutputStream(ServletOutputStream sos) {
		super();
		this.sos = sos;
	}

	@Override
	public boolean isReady() {
		return this.sos.isReady();
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
		this.sos.setWriteListener(writeListener);
	}

	@Override
	public void write(int b) throws IOException {
		System.out.println("(MproxySOS)  " + this.getClass().getName() + ".write(" + b + ") " + (char)b);
		this.sos.write(b);
	} 

}
