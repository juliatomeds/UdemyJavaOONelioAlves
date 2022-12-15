package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Secao14_ExercicioResolvido1 {
    public static void main(String[] args) {

        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING

        Account acc1 = bacc; //receber o objeto da subclasse pra classe
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // DOWNCASTING -> nem sempre vai dar certo

        BusinessAccount acc4 = (BusinessAccount)acc2; //Não é indicado forçar convenção da superclasse pra subclasse,
        // por isso utiliza esse () pra o Casting da superclasse para subclasse
        acc4.loan(100.0);

        // BusinessAccount acc5 = (BusinessAccount)acc3; a acc3 foi instanciada como SavingsAccount e por isso não
        // converter pra BusinessAccount, dando erro de Class exception

        //como não reproduzir o erro acima:
        if (acc3 instanceof BusinessAccount) { //testa se o obj acc3 realmente é um obj de instancia de BusinessAccount
            //ai sim consegue fazer o casting, cc não
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount)acc3; // DOWNCASTING
            acc5.updateBalance();
            System.out.println("Update!");
        }

        Account acc5 = new Account(1005, "Alex", 1000.0);
        acc5.withdraw(200.0);
        System.out.println("\nO valor do acc5 é: " + acc5.getBalance());

        Account acc6 = new SavingsAccount(1006, "Maria", 1000.0, 0.01);
        acc6.withdraw(200.0);
        System.out.println("O valor do acc6 é: " + acc6.getBalance());

        Account acc7 = new BusinessAccount(1007, "Bob", 1000.0, 500.0);
        acc7.withdraw(200.0);
        System.out.println("O valor do acc7 é: " + acc7.getBalance());
    }
}
