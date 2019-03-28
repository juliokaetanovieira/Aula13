package br.com.db1.conta.bancaria;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContaBancariaTest {
	
	private ContaBancaria conta;
	private ContaBancaria conta2;
	
	@Before
	public void init(){
	Cliente cliente = new Cliente("Julio Vieira", "99999999999");
	conta = new ContaBancaria("1234", "004", 1000.0, ContaBancariaTipo.CORRENTE, cliente);
	
	Cliente cliente2 = new Cliente("Julio Vieira", "99999999999");
	conta2 = new ContaBancaria("4321", "400", 1000.0, ContaBancariaTipo.CORRENTE, cliente2);
	}
	
	@Test
	public void deveSacarDinheiroDaConta(){		
		conta.sacar(500.0);		
		Assert.assertEquals(500.0, conta.getSaldo(), 0);
		Assert.assertEquals(1, conta.getHistorico().size());
	}
	
	@Test
	public void deveDepositarDinheiroNaConta(){		
		conta.depositar(500.0);		
		Assert.assertEquals(1500.0, conta.getSaldo(), 0);
		Assert.assertEquals(1, conta.getHistorico().size());
	}
	
	@Test
	public void deveTransferirDinheiroDaConta() {
		conta.transferenciasaida(500.0);
		conta2.entradatransferencia(500.0);
		Assert.assertEquals(500.0, conta.getSaldo(), 0);
		Assert.assertEquals(1, conta.getHistorico().size());
		
		Assert.assertEquals(1500.0,  conta2.getSaldo(), 0);
		Assert.assertEquals(1, conta2.getHistorico().size());
	}
	
	@Test(expected=RuntimeException.class)
	public void deveRetornarErroQuandoValorMenorQueZero(){
		conta.depositar(-500.0);
	}
	
	@Test(expected=RuntimeException.class)
	public void deveRetornarErroQuandoValorIgualQueZero(){
		conta.depositar(0.0);
	}
	
	@Test(expected=RuntimeException.class)
	public void deveRetornarErroQuandoSaldoMenorQueSaque(){
		conta.sacar(2000.0);
	}

}
