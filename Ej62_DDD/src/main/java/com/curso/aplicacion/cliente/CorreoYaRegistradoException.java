package com.curso.aplicacion.cliente;

import com.curso.dominio.vo.CorreoElectronico;

public class CorreoYaRegistradoException extends RuntimeException {

    public CorreoYaRegistradoException(CorreoElectronico correo) {
        super("ya existe un cliente con el correo " + correo);
    }
}
