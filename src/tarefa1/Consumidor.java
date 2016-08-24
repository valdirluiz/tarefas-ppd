package tarefa1;

public class Consumidor implements Runnable{
	
	private Buffer buffer;
	private int id;

	public Consumidor(Buffer buffer, int id) {
		this.buffer = buffer;
		this.id = id;
	}

    public void run() {
    	synchronized(buffer) {
        	System.out.println("Thread leitora " + id + " leu valor: " + buffer.ler());
    		//buffer.ler();
    	}
    }

}
