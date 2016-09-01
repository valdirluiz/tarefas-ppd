package tarefa3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Torre {

	int i;
	private static final int AERONAVES_SIMULTANEAS = 1;
	private final Semaphore semafaro = new Semaphore(AERONAVES_SIMULTANEAS, true);
	
	private List<Pista> pistas = new ArrayList<Pista>();
	

	
	public void solicitarPouso(Aeronave aeronave){
		aeronave.setPriority(10);
		try {
			semafaro.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Torre(Pista pista) {
		this.pistas.add(pista);
	}
	
	
	public Semaphore getSemafaro() {
		return semafaro;
	}
	
	
	public  void teste() {
		final Semaphore semafaro = new Semaphore(2, false);
		for (i = 0; i < 20; i++) {
			(new Runnable() {

				public void run() {
					int prioridade = 1;
					if (i % 2 == 0) {
						prioridade =10;
					} 
					try {
						Thread.currentThread().setPriority(prioridade);
						semafaro.acquire();
						System.out.println(prioridade);
						semafaro.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).run();
		}
		
	}
	
	public static void main(String[] args) {
		Torre torre = new Torre(new Pista());
		torre.teste();
	}
	
	
}
