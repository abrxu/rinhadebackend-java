package com.rinhadebackend.q1.domain.Saldo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Saldo {

    private int idCliente;
    private int total;
    private Timestamp dataExtrato;
    private int limite;

}
