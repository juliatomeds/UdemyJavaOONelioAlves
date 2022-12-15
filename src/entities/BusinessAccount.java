package entities;

public class BusinessAccount extends Account { //se nao colocar extends Account aparece erro no balance
    private Double loanLimit;

    public BusinessAccount() {
        super(); //super -> EXECUTAR A LÓGICA PADRÃO DA CLASSE BASE. construtor padrão da classe Account
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance); //NÃO PRECISA REPITIR OS CONSTRUTORES
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= loanLimit) { //Não pode emprestar um valor acima do limite
            balance += amount - 10.0;
        }
    }
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        balance -= 2.0;
    }
}
