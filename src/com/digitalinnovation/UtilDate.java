package com.digitalinnovation;


import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class UtilDate {

    /**
     *
     * @param data1 Data Inicial que sera comparada com a data2
     * @param data2 Data Final para comparação
     * @return long com o número de dias entre a data1 e data2, valores positivos significam que
     * a data1 é anterior a data2 e vice versa.
     */
    public static long getDiasEntreDatas(LocalDate data1 , LocalDate  data2){

        return data2.getLong(ChronoField.EPOCH_DAY) -
                data1.getLong(ChronoField.EPOCH_DAY);
    }


}
