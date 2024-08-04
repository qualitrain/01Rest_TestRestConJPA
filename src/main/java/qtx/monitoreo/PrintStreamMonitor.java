package qtx.monitoreo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Locale;

public class PrintStreamMonitor extends PrintStream {

	public PrintStreamMonitor(File file, Charset charset) throws IOException {
		super(file, charset);
	}

	public PrintStreamMonitor(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
		super(file, csn);
	}

	public PrintStreamMonitor(File file) throws FileNotFoundException {
		super(file);
	}

	public PrintStreamMonitor(OutputStream out, boolean autoFlush, Charset charset) {
		super(out, autoFlush, charset);
	}

	public PrintStreamMonitor(OutputStream out, boolean autoFlush, String encoding)
			throws UnsupportedEncodingException {
		super(out, autoFlush, encoding);
	}

	public PrintStreamMonitor(OutputStream out, boolean autoFlush) {
		super(out, autoFlush);
	}

	public PrintStreamMonitor(OutputStream out) {
		super(out);
	}

	public PrintStreamMonitor(String fileName, Charset charset) throws IOException {
		super(fileName, charset);
	}

	public PrintStreamMonitor(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
		super(fileName, csn);
	}

	public PrintStreamMonitor(String fileName) throws FileNotFoundException {
		super(fileName);
	}
	
	@Override
	public PrintStream append(char c) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".append(" + c + ")");
		return super.append(c);
	}
	
    @Override
	public PrintStream append(CharSequence csq) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".append(" + csq + ")");
		return super.append(csq);
	}

	@Override
	public void write(int b) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".write(" + b + ")");
		super.write(b);
	}

	@Override
	public void write(byte[] buf, int off, int len) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".write(" + Arrays.toString(buf) 
				+ ", " + off 
				+ ", " + len 
				+ ")");
		
		super.write(buf, off, len);
	}

	@Override
	public void write(byte[] buf) throws IOException {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".write(" + buf 
				+ ")");
		super.write(buf);
	}

	@Override
	public void writeBytes(byte[] buf) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".writeBytes(" + buf 
				+ ")");
		super.writeBytes(buf);
	}

	@Override
	public void print(boolean b) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".print(" + b + ")");
		super.print(b);
	}

	@Override
	public void print(char c) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".print(" + c + ")");
		super.print(c);
	}

	@Override
	public void print(int i) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".print(" + i + ")");
		super.print(i);
	}

	@Override
	public void print(long l) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".print(" + l + ")");
		super.print(l);
	}

	@Override
	public void print(float f) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".print(" + f + ")");
		super.print(f);
	}

	@Override
	public void print(double d) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".print(" + d + ")");
		super.print(d);
	}

	@Override
	public void print(char[] s) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".print(" + Arrays.toString(s) + ")");
		super.print(s);
	}

	@Override
	public void print(String s) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".print(" + s + ")");
		super.print(s);
	}

	@Override
	public void print(Object obj) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".print(" + obj + ")");
		super.print(obj);
	}

	@Override
	public void println() {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".println()");
		super.println();
	}

	@Override
	public void println(boolean x) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".println(" + x + ")");
		super.println(x);
	}

	@Override
	public void println(char x) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".println(" + x + ")");
		super.println(x);
	}

	@Override
	public void println(int x) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".println(" + x + ")");
		super.println(x);
	}

	@Override
	public void println(long x) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".println(" + x + ")");
		super.println(x);
	}

	@Override
	public void println(float x) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".println(" + x + ")");
		super.println(x);
	}

	@Override
	public void println(double x) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".println(" + x + ")");
		super.println(x);
	}

	@Override
	public void println(char[] x) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".println(" + Arrays.toString(x) + ")");
		super.println(x);
	}

	@Override
	public void println(String x) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".println(" + x + ")");
		super.println(x);
	}

	@Override
	public void println(Object x) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".println(" + x + ")");
		super.println(x);
	}

	@Override
	public PrintStream printf(String format, Object... args) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".printf(" + format 
				+ ", " + args 
				+ ")");
		return super.printf(format, args);
	}

	@Override
	public PrintStream printf(Locale l, String format, Object... args) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".printf(" + l 
				+ ", " + format 
				+ ", " + args 
				+ ")");
		return super.printf(l, format, args);
	}

	@Override
	public PrintStream format(String format, Object... args) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".format(" + format 
				+ ", " + args 
				+ ")");
		return super.format(format, args);
	}

	@Override
	public PrintStream format(Locale l, String format, Object... args) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".format(" + l 
				+ ", " + format 
				+ ", " + args 
				+ ")");
		return super.format(l, format, args);
	}

	@Override
	public PrintStream append(CharSequence csq, int start, int end) {
		System.out.println("(Mpsm)  " + this .getClass().getName() + ".append(" + csq 
				+ ", " + start 
				+ ", " + end 
				+ ")");
		return super.append(csq, start, end);
	}	
    
    public static String decode(byte[] bytes, String nombreCharset) {
        Charset charset = Charset.forName(nombreCharset);
        CharsetDecoder decoder = charset.newDecoder();
        decoder.onMalformedInput(CodingErrorAction.REPORT);
        decoder.onUnmappableCharacter(CodingErrorAction.REPORT);

        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        CharBuffer charBuffer = CharBuffer.allocate(bytes.length);

        try {
            decoder.decode(byteBuffer, charBuffer, true);
            decoder.flush(charBuffer);
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        charBuffer.flip();
        return charBuffer.toString();
    }
   
}
