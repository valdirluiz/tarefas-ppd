package tarefa3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Torre {

	private static final int AERONAVES_SIMULTANEAS = 1;
	private final Semaphore pista = new Semaphore(AERONAVES_SIMULTANEAS, true);
	
	

	public Semaphore getSemafaro() {
		return pista;
	}
}
