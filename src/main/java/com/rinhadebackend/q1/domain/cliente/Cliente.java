package com.rinhadebackend.q1.domain.cliente;

import com.rinhadebackend.q1.domain.Saldo.Saldo;
import com.rinhadebackend.q1.domain.transacao.Transacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private int id;
    private Saldo saldo;
    private List<Transacao> transacoes;

}
