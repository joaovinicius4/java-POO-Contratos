package Application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		
		System.out.print("Entre com o departamento do funcionário: ");
		String departamentoNome = sc.nextLine();
		
		System.out.print("Digite o nome do trabalhador: ");
		String nome = sc.nextLine();
		
		System.out.print("Digite o nivel do trabalhador (JUNIOR / PLENO / SENIOR): ");
		String nivel = sc.nextLine();
		
		WorkerLevel level = WorkerLevel.valueOf(nivel.toUpperCase());

		System.out.print("Digite o salário: ");
		double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome, level, salarioBase, new Departamento(departamentoNome));
				
		System.out.print("Quantos contratos esse trabalhador possui? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
		    System.out.println("Entre com o contrato " + i + ":");

		    System.out.print("Entre com a data (dd/MM/yyyy): ");
		    LocalDate dataContrato = LocalDate.parse(sc.next(), fmt);

		    System.out.print("Valor por hora: ");
		    double valorPorHora = sc.nextDouble();

		    System.out.print("Duração de horas: ");
		    int horasDia = sc.nextInt();

		    ContratoHora contrato = new ContratoHora(dataContrato, valorPorHora, horasDia);
		    trabalhador.addContrato(contrato);
		}

		
		System.out.println();
		System.out.print("Digite o mês e o ano para consultar o salário: (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: "+ trabalhador.getNome());
		System.out.println("Departamento: "+ trabalhador.getDepartamento().getNome());
		System.out.printf("Renda em %s: %.2f%n", mesAno, trabalhador.ganhos(ano, mes));

		
		sc.close();
	}

}
