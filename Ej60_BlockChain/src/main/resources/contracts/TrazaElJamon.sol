// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;
contract TrazaElJamon {
  
  struct Cerdo {
    string id;
    bool   vacunado;
    bool   sacrificado;
    string raza;
    string idGanadero;
    string idVeterinario;
    string idMatadero;
  }
  
  struct Ganadero {
    string id;
    string nombre;
  }
  
  struct Veterinario {
    string id;
    string nombre;
  }
  
  struct Matadero {
    string id;
    string nombre;
  }
  
  //Los 'atributos' del contrato son el almacenamiento 
  mapping(string => Ganadero) ganaderos;
  mapping(string => Veterinario) veterinarios;
  mapping(string => Matadero) mataderos;
  mapping(string => Cerdo) cerdos;
  
  constructor() {
    ganaderos["0"] = Ganadero("0", "");
    ganaderos["1"] = Ganadero("1", "Fistro");
    ganaderos["2"] = Ganadero("2", "Fistra");
    veterinarios["0"] = Veterinario("0", "");
    veterinarios["1"] = Veterinario("1", "Sr. Smith");
    mataderos["0"] = Matadero("0", "");
    mataderos["1"] = Matadero("1", "Matadero de Salamanca");
    mataderos["2"] = Matadero("2", "Matadero de \xC3\x81vila");
    cerdos["1"] = Cerdo("1", false, false, "R1", "1", "0", "0");
    cerdos["2"] = Cerdo("2", false, false, "R2", "2", "0", "0");
  }
  
  function crearCerdo(string memory _idCerdo, string memory _idGanadero, string memory _raza) public {
        cerdos[_idCerdo] = Cerdo({
            id: _idCerdo,
            idGanadero: _idGanadero,
            raza: _raza,
            vacunado: false,
            sacrificado: false,
            idVeterinario: "0",
            idMatadero: "0"
        });
  }
  
  function vacunarCerdo(string memory _idCerdo, string memory _idVeterinario) external {
        cerdos[_idCerdo].idVeterinario = _idVeterinario;
        cerdos[_idCerdo].vacunado = true;
  }
  
  function sacrificarCerdo(string memory _idCerdo, string memory _idMatadero) external {
        cerdos[_idCerdo].idMatadero = _idMatadero;
        cerdos[_idCerdo].sacrificado = true;
  }

  function buscarCerdo(string memory _idCerdo) public view returns (string memory _id, string memory _raza, string memory idGranjero, string memory idVeterinario, string memory idMatadero) {
      Cerdo memory c = cerdos[_idCerdo];
      return (c.id, c.raza, c.idGanadero, c.idVeterinario, c.idMatadero);
  }
  
}