package tr.com.seruvent.udemy.currencyexchange.model;

import javax.persistence.*;

@Entity
public class Currency {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="from_currency")
    private String from;

    @Column(name="to_currency")
    private String to;
    private double value;

    @Transient
    private String environment;

    @Transient
    private String port;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
