package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*

- Compilador de Solidity

  npm install -g solc

- Web3 cli

  en la powershell

  Set-ExecutionPolicy Bypass -Scope Process -Force; iex ((New-Object System.Net.WebClient).DownloadString('https://raw.githubusercontent.com/web3j/web3j-installer/master/installer.ps1'))

- Ganache

  https://trufflesuite.com/ganache/

- Compilar el contrato

  solcjs TrazaElJamon.sol --pretty-json --bin --abi --optimize -o ./
  
- Generar el código Java

  web3j generate solidity -b TrazaElJamon.bin -a TrazaElJamon.abi -o ./ -p com.curso.modelo.contrato.proxy

- Arrancar Ganache -> Quickstart

- Copiar el identificador de alguna de las cuentas existentes y pegarlo en application.properties

  trazaeljamon.contract.owner-address=0xD688dB71A52635388c4F6896D1c59d682587Eb91
  
- Copiar la clave privada de la cuenta escogida y pegarla en application.properties

  trazaeljamon.contract.owner-privateKey=f76412a5fc4024c0ca17ab4bf0c81b4b61693769c9a898ffd84fef5797477e27
  
- Borrar cualquier valor de la propiedad 'trazaeljamon.contract.address=' en application.properties
  
- Ejecutar la aplicación para ver el despliege. En la consola aparecerá una traza con la dirección que
  le haya correspondido
  
  Desplegado el contrato con la dirección:0xea574e3a14aab74663b05850e80643467f4ee12a
  
- Colocar el valor en application.properties

  trazaeljamon.contract.address=0xea574e3a14aab74663b05850e80643467f4ee12a   

*/

@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

}
