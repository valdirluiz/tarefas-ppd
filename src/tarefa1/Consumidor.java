package tarefa1;

public class Consumidor implements Runnable{
	
	private Buffer buffer;

	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

    public void run() {
    	buffer.ler();
        
    }

}
