package tarefa3;

import java.util.ArrayList;
import java.util.List;

public class Torre {

	private static final int AERONAVES_SIMULTANEAS = 1;
	//private final Semaphore pista = new Semaphore(AERONAVES_SIMULTANEAS, true);
	private final Semaforo pista = new Semaforo(AERONAVES_SIMULTANEAS);
	
	private List<Pista> pistas = new ArrayList<Pista>();

	public Torre(Pista pista) {
		this.pistas.add(pista);
	}

	public Semaforo getSemafaro() {
		return pista;
	}
}
