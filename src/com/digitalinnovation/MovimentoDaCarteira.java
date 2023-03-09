package com.digitalinnovation;

import java.time.LocalDate;

public class MovimentoDaCarteira {

    enum OPERACAO {
        VENDA,
        COMPRA
    };

    private double precoUnitario;
    private long quantidade;
    private LocalDate dataDoMovimento;
    private AtivoFinanceiro ativoFinanceiro;
    private double taxa;
    private double VNA;
    private double valorDoMovimento;
    private OPERACAO operacao;

}
