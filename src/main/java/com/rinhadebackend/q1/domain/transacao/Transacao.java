package com.rinhadebackend.q1.domain.transacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    private int idCliente;
    private int valor;
    private char tipo;
    private String descricao;
    private Timestamp realizadaEm;

}
