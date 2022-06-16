package com.curso.cfg;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.web3j.tx.gas.StaticGasProvider;

@Configuration
public class TrazaElJamonProperties {
	@Value("${trazaeljamon.contract.gasPrice}")
    private BigInteger gasPrice;
	@Value("${trazaeljamon.contract.gasLimit}")
    private BigInteger gasLimit;

    public StaticGasProvider gas() {
    	
    	System.out.println("==========================================");
    	System.out.println(gasPrice+", "+gasLimit);
    	
        return new StaticGasProvider(gasPrice, gasLimit);
    }

}