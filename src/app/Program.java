import java.util.Set;
import java.util.stream.Collectors;

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

			Map<String, Double> counting = list.stream().collect(
					Collectors.groupingBy(Sale::getSeller, Collectors.summingDouble(value -> value.getTotal())));

			System.out.println("--------------------------------------------");
			System.out.println("Total de vendas por vendedor:");
			System.out.println("--------------------------------------------");
			counting.forEach((seller, total) -> System.out.println(String.format(seller + " R$: %.2f", total)));
			System.out.println("_____________________________________________");

		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		} finally {
			if (sc != null) {

				sc.close();
			}

		}
	}

}
