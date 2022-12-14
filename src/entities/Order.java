package entities;
import java.util.Date;
import entities.enums.OrderStatus;

public class Order { //Isso é uma classe
    private Integer id;
    private Date moment;
    private OrderStatus status;

    public Order() { //Isso é um construtor
        //Em Java, o construtor é definido como um método cujo nome deve ser o mesmo nome da classe e sem indicação do
        // tipo de retorno -- nem mesmo void. O construtor é unicamente invocado no momento da criação do objeto
        // através do operador new. O retorno do operador new é uma referência para o objeto recém-criado

    }

    public Order (Integer id, Date moment, OrderStatus status){
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override   //Generate to string
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + moment +
                ", status=" + status +
                '}';
    }
}


