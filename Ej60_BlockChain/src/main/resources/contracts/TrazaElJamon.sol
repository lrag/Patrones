// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;
contract TrazaElJamon {
  
  struct Cerdo {
    uint id;
    bool vacunado;
    bool sacrificado;
    string raza;
    uint idGranjero;
    uint idVeterinario;
    uint idMatadero;
  }
  
  struct Granjero {
    uint id;
    string nombre;
  }
  
  struct Veterinario {
    uint id;
    string nombre;
  }
  
  struct Matadero {
    uint id;
    string nombre;
  }
  
  mapping(uint => Granjero) granjeros;
  mapping(uint => Veterinario) veterinarios;
  mapping(uint => Matadero) mataderos;
  mapping(uint => Cerdo) cerdos;
  
  uint[] idCerdos;
  
  constructor() {
    granjeros[0] = Granjero(0, "");
    granjeros[1] = Granjero(1, "Fistro");
    granjeros[2] = Granjero(2, "Fistra");
    veterinarios[0] = Veterinario(0, "");
    veterinarios[1] = Veterinario(1, "Sr. Smith");
    mataderos[0] = Matadero(0, "");
    mataderos[1] = Matadero(1, "Matadero de Salamanca");
    mataderos[2] = Matadero(2, "Matadero de \xC3\x81vila");
    cerdos[1] = Cerdo(1, false, false, "R1", 1, 0, 0);
    cerdos[2] = Cerdo(2, false, false, "R2", 2, 0, 0);
    idCerdos.push(1);
    idCerdos.push(2);
  }
  
  function crearCerdo(uint256 _idCerdo, uint256 _idGranjero, string memory _raza) public {
        cerdos[_idCerdo] = Cerdo({
            id: _idCerdo,
            idGranjero: _idGranjero,
            raza: _raza,
            vacunado: false,
            sacrificado: false,
            idVeterinario: 0,
            idMatadero: 0
        });
        idCerdos.push(_idCerdo);
  }
  
  function vacunarCerdo(uint256 _idCerdo, uint256 _idVeterinario) external {
        cerdos[_idCerdo].idVeterinario = _idVeterinario;
        cerdos[_idCerdo].vacunado = true;
  }
  
  function sacrificarCerdo(uint256 _idCerdo, uint256 _idMatadero) external {
        cerdos[_idCerdo].idMatadero = _idMatadero;
        cerdos[_idCerdo].sacrificado = true;
  }

  function buscarCerdo(uint256 _idCerdo) public view returns (uint256 _id, string memory _raza, uint256 idGranjero, uint256 idVeterinario, uint256 idMatadero) {
      Cerdo memory c = cerdos[_idCerdo];
      return (c.id, c.raza, c.idGranjero, c.idVeterinario, c.idMatadero);
  }
  
}