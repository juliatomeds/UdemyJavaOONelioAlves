package entities;

public class SavingsAccount extends Account { //HERANÇA

    private Double interestRate;

    public SavingsAccount() {
        super(); //super -> EXECUTAR A LÓGICA PADRÃO DA CLASSE BASE
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    @Override //é interessante até pq a ide procura se existe um método com esse msm nome, se não, ele avisa
    public void withdraw(double amount) {
        balance += amount;
    }
}