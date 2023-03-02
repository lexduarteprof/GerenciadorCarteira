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

    private double atualizarValorInvestido(){

        return this.ativosVigentes.stream().mapToDouble(ativo -> ativo.getQuantidadeVigente() *
                ativo.getPrecoUnitarioCompra()).sum();
    }

    public double getValorInvestido() {

        return atualizarValorInvestido();
        //BigDecimal bd = new BigDecimal(valorInvestido).setScale(5, RoundingMode.HALF_UP);

        //return bd.doubleValue();
    }

    public void adicionarAtivo(AtivoFinanceiro ativoFinanceiro, long quantidadeComprada,
                               LocalDate dataCompra, double taxadeCompra){

        ativoFinanceiro.comprar(dataCompra, quantidadeComprada, taxadeCompra);
        ativosVigentes.add(ativoFinanceiro);

        this.valorInvestido += (quantidadeComprada * ativoFinanceiro.getPrecoUnitarioCompra());

        System.out.println("Operacao de compra realizada!");

    }
    public void removerAtivo(AtivoFinanceiro ativoFinanceiro,
                             LocalDate dataVenda, double taxadeVenda){

        this.valorInvestido -= (ativoFinanceiro.getQuantidadeVigente() * ativoFinanceiro.getPrecoUnitarioCompra());
        ativoFinanceiro.vender(dataVenda, ativoFinanceiro.getQuantidadeVigente(),
                taxadeVenda);

        ativosVigentes.remove(ativoFinanceiro);
        ativosRemovidos.add(ativoFinanceiro);

        System.out.println("Operacao de venda realizada!");

    }

    public double getValorDeMercado(LocalDate dataDaMarcacao){

        return this.ativosVigentes.stream().mapToDouble(
                ativos-> ativos.getQuantidadeVigente()
                        * ativos.getPrecoUnitarioMercado(dataDaMarcacao)).sum();

    }




}
