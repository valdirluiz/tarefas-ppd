package tarefa1;


public class Produtor implements Runnable {

	private Buffer msg;
	private Escalonador escalonador;
	private String id;

	public Produtor(Buffer buffer, Escalonador escalonador, String id) {
		this.msg = buffer;
		this.escalonador = escalonador;
		this.id = id;
	}

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println(Thread.currentThread().getId()  + " " + id);
			Thread.currentThread().interrupt();
		}

	}

}
