package tarefa1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Escalonador {
	
	private final int NUM_THREADS = 120;
	private final int CONCURRENT_THREADS = 4;
	private final int INTERVAL_MS = 1;
	private ScheduledExecutorService escritoras;
	private ExecutorService leitoras;
	private Buffer buffer;
	
	public Escalonador(){
		this.buffer = new Buffer();
        this.escritoras = Executors.newScheduledThreadPool(1);
        this.leitoras = Executors.newFixedThreadPool(CONCURRENT_THREADS);
	}

	public void start(){
		// cria thread que instancia produtores
        escritoras.scheduleAtFixedRate(new Runnable(){
        	private int currentThreads = 0;
        	public void run(){
        		if(currentThreads < NUM_THREADS){
        			currentThreads++;
        			(new Produtor(buffer, currentThreads)).start();
        		} else {
        			Thread.currentThread().interrupt();
        		}
        	}
        }, 0, INTERVAL_MS, TimeUnit.MILLISECONDS);
        // instancia consumidores que competirao pelo processador
        for(int i = 0; i < NUM_THREADS; i++){
        	leitoras.execute(new Consumidor(buffer, i+1));
        }
	}
}
