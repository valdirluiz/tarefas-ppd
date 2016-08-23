package tarefa1;

public class Consumidor implements Runnable{
	
	private Buffer buffer;
	private int id;

	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

    public void run() {
        System.out.println("Thread leitora leu valor: " + buffer.ler());
    }

}
