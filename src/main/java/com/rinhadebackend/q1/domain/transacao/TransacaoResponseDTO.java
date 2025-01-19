package com.rinhadebackend.q1.domain.transacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoResponseDTO {

    private int limite;
    private int saldo;

}
