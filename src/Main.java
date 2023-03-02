import com.digitalinnovation.TituloPublicoLTN;
import com.digitalinnovation.UtilDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate dataCompra;
        dataCompra = LocalDate.parse("2023/01/02", dateTimeFormatter);
        LocalDate dataVencimento;
        dataVencimento = LocalDate.parse("2024/01/01", dateTimeFormatter);
        LocalDate dataVenda;
        dataVenda = LocalDate.parse("2023/03/05", dateTimeFormatter);


        TituloPublicoLTN LTN_20240101 = new TituloPublicoLTN(dataCompra, dataVencimento);

        LTN_20240101.comprar( dataCompra, 5000, 8.10);

        LTN_20240101.vender(dataVenda,1000, 8.90);

        System.out.println(LTN_20240101.toString());




    }
}