package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.Duration;

public class Secao11_DataHora {

    public static void main(String[] args) {

        LocalDate d01 = LocalDate.now();
        System.out.println("d01 = " + d01); //d01 = 2022-12-13

        LocalDateTime d02 = LocalDateTime.now();
        System.out.println("d02 = " + d02); //d02 = 2022-12-13T11:04:56.491563500 ->> HORARIO DE RECIFE

        LocalDate d12 = LocalDate.parse(d01.toString()); //Padrão ISO 8601 - Data-[hora] local
        System.out.println("d12 = " + d12); //d12 = 2022-12-13 SABENDO QUE d01 = 2022-12-13

        LocalDateTime d13 = LocalDateTime.parse(d02.toString()); //Padrão ISO 8601 - Data-[hora] local
        System.out.println("d13 = " + d13); //d13 = 2022-12-13T11:19:55.352098

        Instant d03 = Instant.now();
        System.out.println("d03 = " + d03); //d03 = 2022-12-13T14:04:56.492561200Z ->> "Z" time, ou Zulu time

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");
        System.out.println("d07 = " + d07); //d07 = 2022-07-20T04:30:26Z

        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt02 =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        LocalDate d08 = LocalDate.parse("20/07/2022", fmt01);
        System.out.println("d08 = " + d08); //d08 = 2022-07-20

        LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt02);
        System.out.println("d09 = " + d09); //d09 = 2022-07-20T01:30

        LocalDate d10 = LocalDate.of(2022, 07, 20);
        System.out.println("d10 = " + d10); //d10 = 2022-07-20

        LocalDateTime d11 = LocalDateTime.of(2022, 07, 20, 1, 30);
        System.out.println("d11 = " + d11); //d11 = 2022-07-20T01:30

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        LocalDate d04 = LocalDate.parse("2022-07-20"); //Padrão ISO 8601 - Data-[hora] local
        System.out.println("d04 = " + d04.toString()); //d04 = 2022-07-20

        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        System.out.println("d05 = " + d05); //d05 = 2022-07-20T01:30:26

        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
        System.out.println("d06 = " + d06); //d06 = 2022-07-20T01:30:26Z

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;

        System.out.println("d04 = " + d04.format(fmt1)); //d04 = 20/07/2022
        System.out.println("d04 = " + fmt1.format(d04)); //d04 = 20/07/2022
        System.out.println("d04 = " + d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //d04 = 20/07/2022

        System.out.println("d05 = " + d05.format(fmt1)); //d05 = 20/07/2022
        System.out.println("d05 = " + d05.format(fmt2)); //d05 = 20/07/2022 01:30
        System.out.println("d05 = " + d05.format(fmt4)); //d05 = 2022-07-20T01:30:26

        System.out.println("d06 = " + fmt3.format(d06)); //d06 = 19/07/2022 22:30
        System.out.println("d06 = " + fmt5.format(d06)); //d06 = 2022-07-20T01:30:26Z
        System.out.println("d06 = " + d06.toString()); //d06 = 2022-07-20T01:30:26Z

        System.out.println("\n-------------------------------------------------------------------------------------\n");
        // for (String s : ZoneId.getAvailableZoneIds())
        // System.out.println(s);

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println("r1 = " + r1); //r1 = 2022-07-19
        System.out.println("r2 = " + r2); //r2 = 2022-07-20
        System.out.println("r3 = " + r3); //r3 = 2022-07-19T22:30:26
        System.out.println("r4 = " + r4); //r4 = 2022-07-20T02:30:26

        System.out.println("d04 dia = " + d04.getDayOfMonth()); //d04 dia = 20
        System.out.println("d04 mês = " + d04.getMonthValue()); //d04 mês = 7
        System.out.println("d04 ano = " + d04.getYear()); //d04 ano = 2022

        System.out.println("d05 hora = " + d05.getHour()); //d05 hora = 1
        System.out.println("d05 minutos = " + d05.getMinute()); //d05 minutos = 30

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        LocalDate pastWeekDate = d04.minusDays(7);
        LocalDate nextWeekDate = d04.plusDays(7);
        System.out.println("pastWeekDate = " + pastWeekDate); //pastWeekDate = 2022-07-13
        System.out.println("nextWeekDate = " + nextWeekDate); //nextWeekDate = 2022-07-27

        LocalDateTime pastWeekLocalDate = d05.minusDays(7);
        LocalDateTime nextWeekLocalDate = d05.plusDays(7);
        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate); //pastWeekLocalDate = 2022-07-13T01:30:26
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate); //nextWeekLocalDate = 2022-07-27T01:30:26

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);
        System.out.println("pastWeekInstant = " + pastWeekInstant); //pastWeekInstant = 2022-07-13T01:30:26Z
        System.out.println("nextWeekInstant = " + nextWeekInstant); //nextWeekInstant = 2022-07-27T01:30:26Z

        Duration t1 = Duration.between(pastWeekDate.atStartOfDay(), d04.atStartOfDay());
        Duration t2 = Duration.between(pastWeekLocalDate, d05);
        Duration t3 = Duration.between(pastWeekInstant, d06);
        Duration t4 = Duration.between(d06, pastWeekInstant);
        System.out.println("t1 dias = " + t1.toDays()); //t1 dias = 7
        System.out.println("t2 dias = " + t2.toDays()); //t2 dias = 7
        System.out.println("t3 dias = " + t3.toDays()); //t3 dias = 7
        System.out.println("t4 dias = " + t4.toDays()); //t4 dias = -7
    }
}