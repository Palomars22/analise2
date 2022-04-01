package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

import entities.Sale;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		List<Sale> list = new ArrayList<>();

//		System.out.print("Enter file full path: ");
//		String path = sc.nextLine();
//		
		System.out.println("Digite o arquivo path :");
		String path = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");

				Integer month = Integer.parseInt(fields[0]);
				Integer year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				Integer items = Integer.parseInt(fields[3]);
				Double total = Double.parseDouble(fields[4]);
				Sale s1 = new Sale(month, year, seller, items, total);
				list.add(s1);

				line = br.readLine();
			}

			System.out.println("----------------------------------------------------------------------------------");

			Stream<Sale> lista = list.stream().filter(t -> t.getYear() == 2016).filter(t -> t.AveragePrice() > 600)
					.sorted(Comparator.comparing(Sale::AveragePrice).reversed()).limit(5);

			lista.forEach(System.out::println);

			System.out.println("-----------------------------------------------------------------------------------");
			Double mes1 = list.stream().filter(t -> t.getSeller().equals("Logan")).filter(t -> t.getMonth() == 1)
					.mapToDouble(value -> value.getTotal()).sum();
			Double mes7 = list.stream().filter(t -> t.getSeller().equals("Logan")).filter(t -> t.getMonth() == 7)
					.mapToDouble(value -> value.getTotal()).sum();

//			System.out.println("Mes 1 de Logan :"+mes1);
//			System.out.println("Mes 7 de Logan :"+mes7);
			double geral = mes1 + mes7;
			System.out.println(String.format("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = %.2f", geral));
			System.out.println("------------------------------------------------------------------------------------");

		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		} finally {
			if (sc != null) {

				sc.close();
			}

		}
	}

}
