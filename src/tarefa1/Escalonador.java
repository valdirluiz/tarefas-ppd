package tarefa1;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import java.util.concurrent.TimeUnit;

public class Escalonador {
	
	private ScheduledFuture scheduledFuture;
	
	public void start(){
		Buffer buffer = new Buffer();
        
        ExecutorService threadsLeitoras = Executors.newFixedThreadPool(4);
        
        ScheduledExecutorService threadsEscritoras = Executors.newScheduledThreadPool(120);
        this.scheduledFuture = threadsEscritoras.scheduleAtFixedRate(new Produtor(buffer, this, UUID.randomUUID().toString()) , 0, 1, TimeUnit.MILLISECONDS); 

        /*try {
            for (int i = 0; i < 120; i++) {
                
                //threadsLeitoras.execute(new Consumidor(buffer));  

                 
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        
        threadsEscritoras.shutdownNow();
        threadsLeitoras.shutdownNow();
        
        while(!threadsEscritoras.isTerminated() ){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) { 
                System.out.println("Thread: "+Thread.currentThread().getName()+ " não finalizada.");
            }
        }*/
	}
	
	public ScheduledFuture getScheduledFuture() {
		return scheduledFuture;
	}

}
