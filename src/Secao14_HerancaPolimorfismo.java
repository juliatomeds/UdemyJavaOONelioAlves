package application;
import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Secao14_HerancaPolimorfismo {

    /*Herança-----------------------------------------------------------------------------------------------------------
    • É um tipo de associação que permite que uma classe herde todos dados e
    comportamentos de outra
    • Definições importantes
    • Vantagens
        • Reuso
        • Polimorfismo
    • Sintaxe
        • class A extends B

    • Relação "é-um"
    • Generalização/especialização
    • Superclasse (classe base) / subclasse (classe derivada)
    • Herança / extensão
    • Herança é uma associação entre classes (e não entre objetos)
     */

    /*
    Na classe de :
    public class BusinessAccount extends Account
    Temos esse extends, ou seja, ele tem a herança da classe Account (possui todos os métodos)
     */

    public static void main(String[] args) {

        BusinessAccount account = new BusinessAccount(8010, "Bob Brown", 0.0, 500.0);

        System.out.println(account.getBalance());

        //Polimorfismo
        Account x = new Account(1020, "Alex", 1000.0);
        Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);
        x.withdraw(50.0);
        System.out.println(x.getBalance()); //945.0
        y.withdraw(50.0);
        System.out.println(y.getBalance()); //1050.0

    }

    /* Checklist -------------------------------------------------------------------------------------------------------
    • Upcasting
        • Casting da subclasse para superclasse
        • Uso comum: polimorfismo
    • Downcasting
        • Casting da superclasse para subclasse
        • Palavra instanceof
        • Uso comum: métodos que recebem parâmetros genéricos (ex: Equals)
     */

    /* Sobreposição, palavra super, anotação @Override -----------------------------------------------------------------
     É a implementação de um método de uma superclasse na subclasse
     É fortemente recomendável usar a anotação @Override em um método sobrescrito
        • Facilita a leitura e compreensão do código
        • Avisamos ao compilador (boa prática)

    Palavra super : É possível chamar a implementação da superclasse usando a palavra super.
     */

    /*Classes e métodos final ------------------------------------------------------------------------------------------
    • Palavra chave: final
    • Classe: evita que a classe seja herdada  : exemplo - public final class SavingsAccount {
    • Método: evita que o método sob seja sobreposto

    • Segurança: dependendo das regras do negócio, às vezes é desejável garantir que uma classe não seja herdada, ou que
      um método não seja sobreposto.
        • Geralmente convém acrescentar final em métodos sobrepostos, pois sobreposições múltiplas podem ser uma porta
          de entrada para inconsistências
    • Performance: atributos de tipo de uma classe final são analisados de forma mais rápida em tempo de execução.
        • Exemplo clássico: String
     */

    /*Introdução ao polimorfismo  --------------------------------------------------------------------------------------
    Pilares da OOP
        • Encapsulamento
        • Herança
        • Polimorfismo

     Em Programação Orientada a Objetos, polimorfismo é recurso que permite que variáveis de um mesmo tipo mais genérico
      possam apontar para objetos de tipos específicos diferentes, tendo assim comportamentos diferentes conforme cada
       tipo específico.

     • A associação do tipo específico com o tipo genérico é feita em tempo de execução (upcasting).
     • O compilador não sabe para qual tipo específico a chamada do método Withdraw está sendo feita (ele só sabe que
        são duas variáveis tipo Account):
     */

    /*Classes abstratas (fica itálico) ---------------------------------------------------------------------------------
        • São classes que não podem ser instanciadas
        • É uma forma de garantir herança total: somente subclasses não abstratas podem ser instanciadas, mas nunca a
          superclasse abstrata

    Questionamento
        • Se a classe Account não pode ser instanciada, por que simplesmente não criar somente SavingsAccount e
          BusinessAccount?
        • Resposta:
            • Reuso
            • Polimorfismo: a superclasse classe genérica nos permite tratar de forma fácil e uniforme todos os tipos de
              conta, inclusive com polimorfismo se for o caso (como fizemos nos últimos exercícios). Por exemplo, você
              pode colocar todos tipos de contas em uma mesma coleção.

    Métodos abstratos
        • São métodos que não possuem implementação.
        • Métodos precisam ser abstratos quando a classe é genérica demais para conter sua implementação.
        • Se uma classe possuir pelo menos um método abstrato, então esta classe também é abstrata.
        • Notação UML: itálico
        • Exercício resolvido
     */
}