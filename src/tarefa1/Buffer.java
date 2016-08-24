package tarefa1;

public class Buffer {

	private int num= 0;

	public synchronized void escrever(int num) {
		this.num = num;
		notifyAll();
	}

	public synchronized int ler() {
		while(num == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int result = num;
		num = 0;
		notifyAll();
		return result;
	}
}
