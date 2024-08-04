package qtx.persistencia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import qtx.entidades.Armadora;
import qtx.entidades.ModeloAuto;

public class GestorDatosJPA implements IGestorDatos {
	private EntityManagerFactory fabricaEntityManager;

	public GestorDatosJPA() {
	    System.out.println("(Gdat)  " +  this.getClass().getName() + ".GestorDatosJPA()");
		try {
			this.fabricaEntityManager = 
				Persistence.createEntityManagerFactory("miBaseDeDatos");
		}
		catch(Exception ex)
		{
			Map<String,String> detEx = new HashMap<String, String>();
			detEx.put("msg", "Falla al intentar crear GestorDatos");
			detEx.put("tabla", "");
			detEx.put("ubicacion", this.getClass().getSimpleName() 
					+ ".GestorDatos("
					+ ")");
			PersistenciaException pex = ManejadorErrPersistencia.crearEx(detEx, ex);
			throw pex;
		}
	}

	@Override
	public Armadora getArmadoraXID(String cveArmadora) {
	    System.out.println("(Gdat)  " +  this.getClass().getName() + ".getArmadoraXID(" + cveArmadora + ")");
		EntityManager em = fabricaEntityManager.createEntityManager();
	    Armadora unaArmadora = em.find(Armadora.class, cveArmadora);
	    System.out.println("(Gdat)  " + unaArmadora);
	    em.close();
		return unaArmadora;
	}
	
	@Override
	public Armadora getArmadoraConModelosXID(String cveArmadora) {
		EntityManager em = fabricaEntityManager.createEntityManager();
	    Armadora unaArmadora = em.find(Armadora.class, cveArmadora);
	    if(unaArmadora == null)
	    	return null;
	    unaArmadora.getModelos().size();
	    em.close();
		return unaArmadora;
	}

	@Override
	public Set<Armadora> getArmadorasTodas() {
		String consulta = "SELECT a FROM Armadora a";
		EntityManager em = fabricaEntityManager.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Armadora> listArmadoras = (List<Armadora>) em.createQuery(consulta)
													.getResultList();
	    em.close();
	    return new HashSet<Armadora>(listArmadoras);		
	}

	@Override
	public Map<String, Armadora> getMapaArmadoras() {
		Map<String,Armadora> mapaArmadoras = new HashMap<>();
		Set<Armadora> setArmadoras = this.getArmadorasTodas();
		for(Armadora armadoraI : setArmadoras) {
			mapaArmadoras.put(armadoraI.getClave(), armadoraI);
		}
		return mapaArmadoras;
	}

	@Override
	public Armadora insertarArmadora(Armadora armadora) {
		EntityManager em = null;
		try {
			em = this.fabricaEntityManager.createEntityManager();
			EntityTransaction transaccion = em.getTransaction();
			transaccion.begin();
			em.persist(armadora);
			transaccion.commit();
			return armadora;
		}
		catch(Exception ex)
		{
			Map<String,String> detEx = new HashMap<String, String>();
			detEx.put("msg", "Falla al intentar insertar armadora");
			detEx.put("tabla", "armadora");
			detEx.put("ubicacion", this.getClass().getSimpleName() 
					+ ".insertarArmadora("
					+ armadora
					+ ")");
			PersistenciaException pex = ManejadorErrPersistencia.crearEx(detEx, ex);
			throw pex;
		}
		finally {
			if(em != null)
				em.close();
		}
	}
	@Override
	public Armadora actualizarArmadora(Armadora armadora) {
		EntityManager em = null;
		try {
			em = this.fabricaEntityManager.createEntityManager();
			EntityTransaction transaccion = em.getTransaction();
			transaccion.begin();
			Armadora armadoraAct = em.find(Armadora.class, armadora.getClave());
			if(armadoraAct == null)
				throw new Exception("La armadora no existe. Clave:" + armadora.getClave());
			em.merge(armadora);
			transaccion.commit();
			return armadora;
		}
		catch(Exception ex)
		{
			Map<String,String> detEx = new HashMap<String, String>();
			detEx.put("msg", "Falla al intentar insertar armadora");
			detEx.put("tabla", "armadora");
			detEx.put("ubicacion", this.getClass().getSimpleName() 
					+ ".insertarArmadora("
					+ armadora
					+ ")");
			PersistenciaException pex = ManejadorErrPersistencia.crearEx(detEx, ex);
			throw pex;
		}
		finally {
			if(em != null)
				em.close();
		}
	}
	public ModeloAuto insertarModeloAuto(ModeloAuto modelo) {
		EntityManager em = null;
		try {
			em = this.fabricaEntityManager.createEntityManager();
			EntityTransaction transaccion = em.getTransaction();
			transaccion.begin();
			em.persist(modelo);
			transaccion.commit();
			return modelo;
		}
		catch(Exception ex)
		{
			Map<String,String> detEx = new HashMap<String, String>();
			detEx.put("msg", "Falla al intentar insertar ModeloAuto");
			detEx.put("tabla", "ModeloAuto");
			detEx.put("ubicacion", this.getClass().getSimpleName() 
					+ ".insertarModeloAuto("
					+ modelo
					+ ")");
			PersistenciaException pex = ManejadorErrPersistencia.crearEx(detEx, ex);
			throw pex;
		}
		finally {
			if(em != null)
				em.close();
		}
	}

}
