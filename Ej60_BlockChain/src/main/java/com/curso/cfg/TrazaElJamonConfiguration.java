package com.curso.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import com.curso.modelo.contrato.proxy.TrazaElJamon;
import com.curso.modelo.negocio.TrazaElJamonService;

import okhttp3.OkHttpClient;

@Configuration
public class TrazaElJamonConfiguration {

	@Value("${trazaeljamon.contract.owner-address}")
	private String ownerAddress;

	@Value("${trazaeljamon.contract.owner-privateKey}")
	private String privateKey;

	@Value("${web3j.client-address}")
	private String clientAddress;
	
	@Value("${trazaeljamon.contract.address}") 
	private String contractAddress;

	@Autowired
	private TrazaElJamonProperties config;

	@Bean
	public Web3j web3j() {
		return Web3j.build(new HttpService(clientAddress, new OkHttpClient.Builder().build()));
	}

	@Bean
	//Si el contrato no está desplegado se despliega para obtener la dirección
	//Si ya estaba desplegado se lee la dirección de la configuración
	public TrazaElJamon trazaElJamon(Web3j web3j, TransactionManager txManager) throws Exception {
		if (!StringUtils.hasLength(contractAddress)) {
			System.out.println("Desplegando el contrato...");
			TrazaElJamon contract = TrazaElJamon.deploy(web3j, txManager(web3j), config.gas()).send();
			System.out.println("Desplegado el contrato con la dirección:"+ contract.getContractAddress());
			return contract;
		}
		return TrazaElJamon.load(contractAddress, web3j, txManager, config.gas());
	}

	@Bean
	public TransactionManager txManager(Web3j web3j) {
	    Credentials credentials = Credentials.create(privateKey);
	    System.out.println(credentials);
	    return new RawTransactionManager(web3j, credentials);
	}

}