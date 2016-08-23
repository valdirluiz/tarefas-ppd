package tarefa1;

public class Consumidor implements Runnable{
	
	private Buffer msg;

	public Consumidor(Buffer buffer) {
		msg = buffer;
	}

    public void run() {
        for (int i = 0; i < 120; i++) { 
            while(msg.ler() != 0){}  
        }
    }

}
