package com.digitalinnovation;

import java.time.LocalDate;

public class TituloPublicoLTN extends AtivoFinanceiro {


    public TituloPublicoLTN(LocalDate dataDeVencimento) {
        super(dataDeVencimento);
        this.nome = "LTN";
        this.descricao = "Título público Federal denominado LTN, possui rendimento pré-fixado!";
    }

    @Override
    public double calcularPreco(double Taxa, LocalDate dataCalculo) {

        double precoCalculado = 0;
        double dias = UtilDate.getDiasEntreDatas(dataCalculo, this.dataVencimento);

        try{
            precoCalculado = 1000.0 / Math.pow((Taxa/100+1), (dias / 360));
        }catch(Exception e){
            e.printStackTrace();
        }

        return precoCalculado;
    }



}
