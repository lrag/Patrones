package com.curso.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

import com.curso.modelo.contrato.proxy.TrazaElJamon;
import com.curso.modelo.negocio.TrazaElJamonService;

import okhttp3.OkHttpClient;

@Configuration
public class TrazaElJamonConfiguration {

	@Value("${trazaeljamon.contract.owner-address}")
	private String ownerAddress;

	@Value("${web3j.client-address}")
	private String clientAddress;

	@Autowired
	private TrazaElJamonProperties config;

	@Bean
	public Web3j web3j() {
		return Web3j.build(new HttpService(clientAddress, new OkHttpClient.Builder().build()));
	}

	@Bean
	//Si el contrato no está desplegado se despliega para obtener la dirección
	//Si ya estaba desplegado se lee la dirección de la configuración
	public TrazaElJamonService contract(Web3j web3j, @Value("${trazaeljamon.contract.address:}") String contractAddress)
			throws Exception {
		if (!StringUtils.hasLength(contractAddress)) {
			TrazaElJamon trazaElJamon = deployContract(web3j);
			return new TrazaElJamonService(trazaElJamon.getContractAddress(), web3j, config);
		}
		return new TrazaElJamonService(contractAddress, web3j, config);
	}

	private TrazaElJamon deployContract(Web3j web3j) throws Exception {
		System.out.println("About to deploy new contract...");
		TrazaElJamon contract = TrazaElJamon.deploy(web3j, txManager(web3j), config.gas()).send();
		System.out.println("Desplegado el contrato con la dirección:"+ contract.getContractAddress());
		return contract;
	}

	private TransactionManager txManager(Web3j web3j) {
		return new ClientTransactionManager(web3j, ownerAddress);
	}

}