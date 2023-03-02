import com.digitalinnovation.CarteiraDeAtivos;
import com.digitalinnovation.TituloPublicoLFT;
import com.digitalinnovation.TituloPublicoLTN;
import com.digitalinnovation.UtilDate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {


        //Criação dos objetos para utilização de datas
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dataCompra;
        dataCompra = LocalDate.parse("2023/01/02", dateTimeFormatter);
        LocalDate dataVencimento;
        dataVencimento = LocalDate.parse("2024/01/01", dateTimeFormatter);
        LocalDate dataVenda;
        dataVenda = LocalDate.parse("2023/01/10", dateTimeFormatter);


        //Criação dos títulos para utilização
        TituloPublicoLTN LTN_20240101 = new TituloPublicoLTN(dataVencimento);
        TituloPublicoLFT LFT_20240101 = new  TituloPublicoLFT(dataVencimento);

        //Realização das operações de compra e venda

        //Operação 1
        //LTN_20240101.comprar( dataCompra, 5000, 8.10);
        //LTN_20240101.vender(dataVenda,1000, 8.90);

        //Operação 2

        //LFT_20240101.setVNA(5115.266868);
        // LFT_20240101.comprar( dataCompra, 5000, 0.52);
        // LFT_20240101.vender(dataVenda,1000, 0.35);

        //System.out.println(LFT_20240101);
        //System.out.println(LTN_20240101);

        //Cálculo do preço de mercado
        //LocalDate dataMercado = LocalDate.parse("2023/04/18", dateTimeFormatter);
        //LFT_20240101.setTaxaDeMercado(0.7);
        //LTN_20240101.setTaxaDeMercado(7.12);
        //LFT_20240101.getPrecoUnitarioMercado(dataMercado);
        //LTN_20240101.getPrecoUnitarioMercado(dataMercado);

        //Criação de uma carteira de Ativos
        CarteiraDeAtivos carteiraCampea = new CarteiraDeAtivos("Carteira Campeã");

        //Operações com a LTN
        LocalDate dataCompraCarteira = LocalDate.parse("2023/02/05", dateTimeFormatter);

        //Primeira compra
        TituloPublicoLTN LTN_20240101a = new TituloPublicoLTN(dataVencimento);
        carteiraCampea.adicionarAtivo(LTN_20240101a, 6000, dataCompraCarteira,
                12.34);
        //Segunda compra
        TituloPublicoLTN LTN_20240101b = new TituloPublicoLTN(dataVencimento);
        carteiraCampea.adicionarAtivo(LTN_20240101b, 3000, dataCompraCarteira,
                11.13);
        //Terceira compra
        TituloPublicoLTN LTN_20240101c = new TituloPublicoLTN(dataVencimento);
        carteiraCampea.adicionarAtivo(LTN_20240101c, 10000, dataCompraCarteira,
                10.22);

        //Quarta compra

        TituloPublicoLFT LFT_20240101a = new  TituloPublicoLFT(dataVencimento);
        LFT_20240101a.setVNA(5115.266868);
        carteiraCampea.adicionarAtivo(LFT_20240101a, 12000, dataCompraCarteira,
                0.02);


        //Impressão dos dados da Carteira
        carteiraCampea.getAtivosVigentes().forEach(
                e -> System.out.println(e.toString()));
        System.out.println(String.format("%,.2f", carteiraCampea.getValorInvestido()));















    }
}