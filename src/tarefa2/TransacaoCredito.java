package tarefa2;

public class TransacaoCredito extends Transacao{

	TransacaoCredito(int valor, String data) {
		super(valor, data);
	}

	int getVariacao() {
		return 1;
	}

	void emiteLinhaExtrato() {
		
	}

}
