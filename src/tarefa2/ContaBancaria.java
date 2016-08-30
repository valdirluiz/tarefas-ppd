package tarefa2;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {

	Lock lock;
	int numero;
	int saldoAnterior;
	List<Transacao> transacoes = new ArrayList<Transacao>();

	ContaBancaria(int numero) {
		this.numero = numero;
		this.lock = new Lock();
	}

	int getNumero() {
		return 0;
	}

	int getSaldoAtual() {
		return saldoAnterior;
	}

	void debite(int valor, String data) {
		try {
			lock.lock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Transacao transacao = new TransacaoDebito(valor, data);
		transacoes.add(transacao);
		saldoAnterior= saldoAnterior + transacao.getValor();
		lock.unlock();
	}

	void credite(int valor, String data) {
		try {
			lock.lock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Transacao transacao = new TransacaoCredito(valor, data);
		transacoes.add(transacao);
		saldoAnterior= saldoAnterior + transacao.getValor();
		lock.unlock();
	}

	void emiteExtrato() {
		for(Transacao transacao  :transacoes){
			System.out.println("Data: " + transacao.getData() + " | Valor: " + transacao.getValor());
		}
	}
	
	
}
