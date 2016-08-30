package tarefa2;

 
public class Terminal {

	private ContaBancaria conta = new ContaBancaria(33);
	int i;

	public void start() {
		

		for (i = 0; i < 20; i++) {
			(new Runnable() {

				public void run() {
					if (i % 2 == 0) {
						conta.credite(11, "credito");
					} else {
						conta.debite(10, "debito");
					}
				}
			}).run();
		}
		conta.emiteExtrato();
		System.out.println(conta.getSaldoAtual());
	}

}
