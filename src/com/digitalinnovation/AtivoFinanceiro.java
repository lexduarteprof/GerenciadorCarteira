package com.digitalinnovation;

import java.time.LocalDate;

public abstract class AtivoFinanceiro {

    protected String nome;
    protected String descricao;
    protected LocalDate dataVencimento;
    protected long quantidadeVigente;

    private LocalDate dataDeCompra;
    private double taxaDeCompra;
    private double precoUnitarioCompra;
    private LocalDate dataDeVenda;
    private double taxaDeVenda;
    private double precoUnitarioVenda;
    private Double taxaDeMercado;
    private double precoUnitarioMercado;

    private double VNA;

    public AtivoFinanceiro(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
        this.taxaDeMercado = null;
    }

    public LocalDate getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(LocalDate dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getTaxaDeCompra() {
        return taxaDeCompra;
    }

    public void setTaxaDeCompra(double taxaDeCompra) {
        this.taxaDeCompra = taxaDeCompra;
    }

    public double getPrecoUnitarioCompra() {

        precoUnitarioCompra = this.calcularPreco(this.taxaDeCompra, this.dataDeCompra);

        return precoUnitarioCompra;
    }

    public double getVNA() {
        return VNA;
    }

    public void setVNA(double VNA) {
        this.VNA = VNA;
    }

    public LocalDate getDataDeVenda() {
        return dataDeVenda;
    }

    public void setDataDeVenda(LocalDate dataDeVenda) {
        this.dataDeVenda = dataDeVenda;
    }

    public double getTaxaDeVenda() {
        return taxaDeVenda;
    }

    public void setTaxaDeVenda(double taxaDeVenda) {
        this.taxaDeVenda = taxaDeVenda;
    }

    public double getPrecoUnitarioVenda() {

        this.precoUnitarioVenda = this.calcularPreco(this.taxaDeVenda, this.dataDeVenda);
        return precoUnitarioVenda;
    }

    public Double getTaxaDeMercado() {
        return taxaDeMercado;
    }

    public void setTaxaDeMercado(Double taxaDeMercado) {
        this.taxaDeMercado = taxaDeMercado;
    }

    public double getPrecoUnitarioMercado(LocalDate dataBaseCalculo) {

        if(this.taxaDeMercado == null){
            throw new NullPointerException("Para o cálculo do PU de Mercado, a taxa de mercado não pode ser nula!");
        }else{
            precoUnitarioMercado = this.calcularPreco(this.taxaDeMercado, dataBaseCalculo);
        }

        return precoUnitarioMercado;
    }

    public long getQuantidadeVigente() {
        return quantidadeVigente;
    }





    @Override
    public String toString() {
        return  "nome=" + nome + "\n" +
                "descricao=" + descricao + "\n" +
                "dataDeCompra=" + dataDeCompra +  "\n" +
                "taxaDeCompra=" + taxaDeCompra + "\n" +
                "precoUnitarioCompra=" + precoUnitarioCompra + "\n" +
                "dataDeVenda=" + dataDeVenda + "\n" +
                "taxaDeVenda=" + taxaDeVenda + "\n" +
                "precoUnitarioVenda=" + precoUnitarioVenda + "\n" +
                "taxaDeMercado=" + taxaDeMercado + "\n" +
                "precoUnitarioMercado=" + precoUnitarioMercado + "\n" +
                "quantidadeVigente=" + quantidadeVigente;
    }
    public abstract double calcularPreco(double Taxa, LocalDate dataCalculo);
    public void comprar(LocalDate dataDeCompra, long quantidadeComprada, double taxaDeCompra){

        this.quantidadeVigente += quantidadeComprada;
        this.taxaDeCompra = taxaDeCompra;
        this.dataDeCompra = dataDeCompra;
        this.getPrecoUnitarioCompra();

    }
    public void vender(LocalDate dataDeVenda, long quantidadeVendida, double taxaDeVenda){

            if(quantidadeVendida > this.quantidadeVigente){
                throw new ArithmeticException("A quantidade vendida não pode ser " +
                        "maior que a quantidade vigente no título!");
            }else{
                this.quantidadeVigente -= quantidadeVendida;
                this.taxaDeVenda = taxaDeVenda;
                this.dataDeVenda = dataDeVenda;
                this.getPrecoUnitarioVenda();
            }
    }


}
