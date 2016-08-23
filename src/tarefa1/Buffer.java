package tarefa1;

public class Buffer {

	private int num= 0;

	public synchronized void escrever(int num) {
		this.num = num;
		notifyAll();
	}

	public synchronized int ler() {
		if(num == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			notifyAll();
		}
		return this.num;
	}
}
