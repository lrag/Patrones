package com.curso.modelo.negocio;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.curso.cfg.TrazaElJamonProperties;
import com.curso.modelo.contrato.proxy.TrazaElJamon;

//Registrado en TrazaElJamonConfiguration
public class TrazaElJamonService {

	private final String contractAddress;
	private final Web3j web3j;
	private final TrazaElJamonProperties config;

	public TrazaElJamonService(String contractAddress, Web3j web3j, TrazaElJamonProperties config) {
		this.contractAddress = contractAddress;
		this.web3j = web3j;
		this.config = config;
	}

	/*
    public RemoteFunctionCall<Tuple5<BigInteger, String, String, String, String>> buscarCerdo(BigInteger _cerdoId) {
    public RemoteFunctionCall<TransactionReceipt> crearCerdo(BigInteger _granjeroId, BigInteger _cerdoId, String _raza) {
    public RemoteFunctionCall<TransactionReceipt> vacunarCerdo(BigInteger _cerdoId, BigInteger _veterinarioId) {
    public RemoteFunctionCall<TransactionReceipt> venderCerdo(BigInteger _cerdoId, BigInteger _vendedorId) {
	*/
	
	public void buscarCerdo(BigInteger cerdoId) throws Exception {
		TrazaElJamon trazaElJamon = loadContract(contractAddress);
		Tuple5<BigInteger, String, String, String, String> respuesta = trazaElJamon.buscarCerdo(cerdoId).send();
		System.out.println(respuesta);
	}

	/*
	public BigInteger getBalance() throws IOException {
		return web3j.ethGetBalance(contractAddress, DefaultBlockParameterName.LATEST).send().getBalance();
	}

	public void join(String account, BigDecimal ethers) throws Exception {
		Lottery lottery = loadContract(account);
		lottery.enter(Convert.toWei(ethers, Unit.ETHER).toBigInteger()).send();
	}

	@SuppressWarnings("unchecked")
	public List<String> getPlayers(String ownerAddress) throws Exception {
		Lottery lottery = loadContract(ownerAddress);
		return lottery.getPlayers().send();
	}

	public void pickWinner(String ownerAddress) throws Exception {
		Lottery lottery = loadContract(ownerAddress);
		lottery.pickWinner().send();
	}

	private Lottery loadContract(String accountAddress) {
		return Lottery.load(contractAddress, web3j, txManager(accountAddress), config.gas());
	}
	*/
	
	private TrazaElJamon loadContract(String accountAddress) {
		return TrazaElJamon.load(contractAddress, web3j, txManager(accountAddress), config.gas());
	}
    
	private TransactionManager txManager(String accountAddress) {
        return new ClientTransactionManager(web3j, accountAddress);
    }
}