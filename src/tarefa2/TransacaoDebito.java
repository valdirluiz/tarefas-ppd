package tarefa2;

public class TransacaoDebito extends Transacao{

	TransacaoDebito(int valor, String data) {
		super(valor, data);
	}

	int getVariacao() {
		return -1;
	}

	void emiteLinhaExtrato() {
		
	}

}
