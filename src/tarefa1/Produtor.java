package tarefa1;


public class Produtor extends Thread {

	private Buffer buffer;
	private int num;

	public Produtor(Buffer buffer, int num) {
		this.buffer = buffer;
		this.num = num;
	}

	public void start() {
		buffer.escrever(num);
		System.out.println("Thread escritora " + num);
	}

}
