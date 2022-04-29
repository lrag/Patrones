// SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;
contract TrazaElJamon {
  
  struct Cerdo {
    uint id;
    bool vacunado;
    bool vendido;
    string raza;
    uint granjeroId;
    uint veterinarioId;
    uint vendedorId;
  }
  
  struct Granjero {
    uint id;
    string nombre;
  }
  
  struct Veterinario {
    uint id;
    string nombre;
  }
  
  struct Vendedor {
    uint id;
    string nombre;
  }
  
  mapping(uint => Granjero) granjeros;
  mapping(uint => Veterinario) veterinarios;
  mapping(uint => Vendedor) vendedores;
  mapping(uint => Cerdo) cerdos;
  
  uint[] cerdosIds;
  
  constructor() {
    granjeros[0] = Granjero(0, "");
    granjeros[1] = Granjero(1, "Falco");
    granjeros[2] = Granjero(2, "Octavia");
    veterinarios[0] = Veterinario(0, "");
    veterinarios[1] = Veterinario(1, "Benji");
    vendedores[0] = Vendedor(0, "");
    vendedores[1] = Vendedor(1, "Arya");
    vendedores[2] = Vendedor(2, "Oliver");
    cerdos[1] = Cerdo(1, false, false, "R1", 1, 0, 0);
    cerdos[2] = Cerdo(2, false, false, "R2", 2, 0, 0);
    cerdosIds.push(1);
    cerdosIds.push(2);
  }
  
  function crearCerdo(uint256 _granjeroId, uint256 _cerdoId, string memory _raza) public {
        cerdos[_cerdoId] = Cerdo({
            id: _cerdoId,
            granjeroId: _granjeroId,
            raza: _raza,
            vacunado: false,
            vendido: false,
            veterinarioId: 0,
            vendedorId: 0
        });
        cerdosIds.push(_cerdoId);
  }
  
  function vacunarCerdo(uint256 _cerdoId, uint256 _veterinarioId) external {
        cerdos[_cerdoId].veterinarioId = _veterinarioId;
        cerdos[_cerdoId].vacunado = true;
  }
  
  function venderCerdo(uint256 _cerdoId, uint256 _vendedorId) external {
        cerdos[_cerdoId].vendedorId = _vendedorId;
        cerdos[_cerdoId].vendido = true;
  }
  
  function buscarCerdo(uint256 _cerdoId) public view returns (uint256 _id, string memory _raza, string memory granjero, string memory _veterinario, string memory _vendedor) {
      Cerdo memory c = cerdos[_cerdoId];
      return (c.id, c.raza, granjeros[c.granjeroId].nombre, veterinarios[c.veterinarioId].nombre, vendedores[c.vendedorId].nombre);
  }
}