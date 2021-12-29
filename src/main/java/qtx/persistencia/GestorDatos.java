package qtx.persistencia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import qtx.entidades.Armadora;
import qtx.entidades.ModeloAuto;

public class GestorDatos implements IGestorDatos{
	private Map<String,Armadora> armadoras;

	public GestorDatos() {
		this.armadoras = new HashMap<String,Armadora>();
		this.cargarArmadoras();
	}
	
	@Override
	public Armadora getArmadoraXID(String cveArmadora) {
		return this.armadoras.get(cveArmadora);
	}

	@Override
	public Set<Armadora> getArmadorasTodas() {
		return new HashSet<Armadora>(this.armadoras.values());
	}

	@Override
	public Map<String, Armadora> getMapaArmadoras() {
		return this.armadoras;
	}

	@Override
	public Armadora insertarArmadora(Armadora armadora) {
		if(this.armadoras.containsKey(armadora.getClave()) == false)
			this.armadoras.put(armadora.getClave(), armadora);
		else
			return null;
		return armadora;
	}
	
	public void cargarArmadoras() {
		this.insertarArmadora(new Armadora("Ford", "Ford Motor Company",
				"EUA", 2));
		this.insertarArmadora(new Armadora("Nissan", "Nissan de México S.A. de C.V.",
				"Japón", 1));
		this.insertarArmadora(new Armadora("Mazda", "Mazda International",
				"Japón", 1));
		this.insertarArmadora(new Armadora("BMW", "BMW Americas",
				"Alemania", 0));
		
	}

	@Override
	public ModeloAuto insertarModeloAuto(ModeloAuto modelo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Armadora getArmadoraConModelosXID(String cveArmadora) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Armadora actualizarArmadora(Armadora armadora) {
		// TODO Auto-generated method stub
		return null;
	}

}
