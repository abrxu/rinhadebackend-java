package com.rinhadebackend.q1.domain.transacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequestDTO {

    private int idCliente;
    private int valor;
    private char tipo;
    private String descricao;

}
