package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;

public class Trabalhador {

    private String nome;
    private WorkerLevel level;
    private Double salarioBase;
    private Departamento departamento; //trabalhador tem um departamento

    private List<ContratoHora> contratos = new ArrayList<>(); // trabalhador tem varios contratos

    // construtores
    public Trabalhador() {
    }

    public Trabalhador(String nome, WorkerLevel level, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.level = level;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }


    // métodos de negócio
    public void addContrato(ContratoHora contrato) {
        contratos.add(contrato);
    }

    public void removerContrato(ContratoHora contrato) {
        contratos.remove(contrato);
    }

    public double ganhos(int ano, int mes) {
        double soma = salarioBase;

        for (ContratoHora c : contratos) {
            int cAno = c.getDate().getYear();
            int cMes = c.getDate().getMonthValue();

           if (cAno == ano && cMes == mes) {
                soma += c.valorTotal();
            }
        }
        return soma;
    }
}

