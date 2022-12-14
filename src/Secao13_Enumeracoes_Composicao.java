package application;
import java.util.Date;
import entities.Order;
import entities.enums.OrderStatus;

public class Secao13_Enumeracoes_Composicao {
    public static void main(String[] args) {
        /*
        Enumerações
            • É um tipo especial que serve para especificar de forma literal um conjunto de constantes relacionadas
            • Palavra chave em Java: enum
            • Vantagem: melhor semântica, código mais legível e auxiliado pelo  compilador
            • Referência: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
         */

        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
        System.out.println(order); //Order{id=1080, moment=Tue Dec 13 15:56:08 BRT 2022, status=PENDING_PAYMENT}

        OrderStatus os1 = OrderStatus.DELIVERED;
        System.out.println(os1); //DELIVERED
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
        System.out.println(os2); //DELIVERED

        /*
        Categorias de classes
            • Em um sistema orientado a objetos, de modo geral "tudo" é objeto.
            • Por questões de design tais como organização, flexibilidade, reuso,  delegação, etc.,
               há várias categorias de classes: Views, Controllers, Entities, Services, Repositories

        Composição
            • É um tipo de associação que permite que um objeto contenha outro
            • Relação "tem-um" ou "tem-vários"
            • Vantagens
                • Organização: divisão de responsabilidades
                • Coesão
                • Flexibilidade
                • Reuso
            • Nota: embora o símbolo UML para composição (toda parte) seja o diamante, nesse contexto estamos
            chamando de composição qualquer associação tipo 'tem-um' e 'tem-vários'.
         */


    }
}
