package entities;

import java.time.LocalDate;

public class ContratoHora {

    private LocalDate date;
    private Double valorPorHora;
    private Integer horas;

    public ContratoHora() {
    }

    public ContratoHora(LocalDate date, Double valorPorHora, Integer horas) {
        this.date = date;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public Integer getHoras() {
        return horas;
    }

    // método de negócio
    public double valorTotal() {
        return valorPorHora * horas;
    }
}
