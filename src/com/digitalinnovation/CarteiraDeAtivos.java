package com.digitalinnovation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CarteiraDeAtivos {

    public CarteiraDeAtivos(String nome) {
        this.nome = nome;
    }

    private String nome;
    private Set<AtivoFinanceiro> ativosVigentes = new LinkedHashSet<AtivoFinanceiro>();
    private Set<AtivoFinanceiro> ativosRemovidos = new LinkedHashSet<AtivoFinanceiro>();

    private double valorInvestido;

    public String getNome() {
        return nome;
    }

    public Set<AtivoFinanceiro> getAtivosVigentes() {
        return ativosVigentes;
    }

    public Set<AtivoFinanceiro> getAtivosRemovidos() {
        return ativosRemovidos;
    }

    public double getValorInvestido() {

        BigDecimal bd = new BigDecimal(valorInvestido).setScale(5, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    public void adicionarAtivo(AtivoFinanceiro ativoFinanceiro, long quantidadeComprada,
                               LocalDate dataCompra, double taxadeCompra){

        ativoFinanceiro.comprar(dataCompra, quantidadeComprada, taxadeCompra);
        ativosVigentes.add(ativoFinanceiro);

        this.valorInvestido += (quantidadeComprada * ativoFinanceiro.getPrecoUnitarioCompra());

        System.out.println("Operacao de compra realizada!");

    }



}
