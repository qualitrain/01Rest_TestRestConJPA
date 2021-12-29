package qtx.persistencia;

import java.util.Map;
import java.util.Set;

import qtx.entidades.Armadora;
import qtx.entidades.ModeloAuto;

public interface IGestorDatos {
	public Armadora getArmadoraXID(String cveArmadora);
	public Set<Armadora> getArmadorasTodas();
	public Map<String,Armadora> getMapaArmadoras();
	public Armadora insertarArmadora(Armadora armadora);
	public ModeloAuto insertarModeloAuto(ModeloAuto modelo);
	public Armadora getArmadoraConModelosXID(String cveArmadora);
	Armadora actualizarArmadora(Armadora armadora);
}
