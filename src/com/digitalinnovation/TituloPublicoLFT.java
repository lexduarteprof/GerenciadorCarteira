package com.digitalinnovation;

import java.time.LocalDate;

public class TituloPublicoLFT extends AtivoFinanceiro{

    public TituloPublicoLFT(LocalDate dataVencimento) {
        super(dataVencimento);
        this.nome = "LFT";
        this.descricao = "Título público Federal denominado LFT, " +
                "possui rendimento pós-fixado, corrigido pela SELIC!";
    }

    @Override
    public double calcularPreco(double Taxa, LocalDate dataCalculo) {

        if (this.getVNA() == 0) {
            throw new ArithmeticException("Para cálculo do título " +
                    "é necessário definir um VNA maior do que 0.");
        }else{
            double cotacao = 0;
            double precoCalculado = 0;
            double dias = UtilDate.getDiasEntreDatas(dataCalculo, this.dataVencimento);

            cotacao = (100 / Math.pow((Taxa/100+1),(dias/360))) - 1;
            cotacao = cotacao / 100;

            precoCalculado = this.getVNA() * cotacao;
            return precoCalculado;

        }

    }




}
