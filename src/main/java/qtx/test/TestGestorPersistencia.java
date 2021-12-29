package qtx.test;

import qtx.entidades.Armadora;
import qtx.entidades.ModeloAuto;
import qtx.persistencia.GestorDatosJPA;
import qtx.persistencia.IGestorDatos;

public class TestGestorPersistencia {

	public static void main(String[] args) {
/*		IGestorDatos gestorDatos = new GestorDatosJPA();
		System.out.println(gestorDatos.getArmadorasTodas());
		System.out.println(gestorDatos.getArmadoraXID("Ford"));
		System.out.println(gestorDatos.getMapaArmadoras());
		
		System.out.println(gestorDatos.getArmadoraConModelosXID("BMW").getModelos());
	
		Armadora armadora  = gestorDatos.getArmadoraXID("GM");
		armadora.setnPlantas(3);
		armadora.setNombre(armadora.getNombre()+" Inc.");
		gestorDatos.actualizarArmadora(armadora);
		*/
		insertarArmadoras();
		}
	
	public static void insertarArmadoras() {
		IGestorDatos gestorDatos = new GestorDatosJPA();
		Armadora nvaArmadora = new Armadora("VW", " Volkswagen Nutzfahrzeuge", "Alemania", 1);
		gestorDatos.insertarArmadora(nvaArmadora);
		ModeloAuto modelo = new ModeloAuto("Jetta", "Jetta A4 Trendline", nvaArmadora, "Automatic", false);
		gestorDatos.insertarModeloAuto(modelo);
		modelo = new ModeloAuto("GolfGTI", "Golf GTI DSG", nvaArmadora, "Turbo GTI Stronic", true);
		gestorDatos.insertarModeloAuto(modelo);
		
		nvaArmadora = new Armadora("Ford", "Ford Motor Company", "EUA", 1);
		gestorDatos.insertarArmadora(nvaArmadora);
		modelo = new ModeloAuto("Mustang", "Mustang GT 500", nvaArmadora, "500 Caballos", true);
		gestorDatos.insertarModeloAuto(modelo);
		modelo = new ModeloAuto("LoboHD", "Lobo Harley Davidson", nvaArmadora, "Harley Davidson", true);
		gestorDatos.insertarModeloAuto(modelo);
		
		nvaArmadora = new Armadora("GM", "General Motors Company", "EUA", 2);
		gestorDatos.insertarArmadora(nvaArmadora);
		modelo = new ModeloAuto("Spark", "Spark Std Aus", nvaArmadora, "Estándar austero", false);
		gestorDatos.insertarModeloAuto(modelo);
		
		nvaArmadora = new Armadora("Fiat", "Fabbrica Italiana Automobili Torino", "Italia", 1);
		gestorDatos.insertarArmadora(nvaArmadora);
		modelo = new ModeloAuto("500", "Fiat 500 Diabolo", nvaArmadora, "200 Caballos Turbo", true);
		gestorDatos.insertarModeloAuto(modelo);
		modelo = new ModeloAuto("Panda", "Fiat Panda", nvaArmadora, "Estándar", false);
		gestorDatos.insertarModeloAuto(modelo);

		nvaArmadora = new Armadora("BMW", "BMW European cars Corporation", "Alemania", 0);
		gestorDatos.insertarArmadora(nvaArmadora);
		modelo = new ModeloAuto("X3", "Serie 3 SUV", nvaArmadora, "Luxe", true);
		gestorDatos.insertarModeloAuto(modelo);
	}

}
