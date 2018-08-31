package br.com.fiap.fiaproupas.moker;

import java.util.Random;

import br.com.fiap.fiaproupas.entity.Product;
import br.com.fiap.fiaproupas.service.ProductService;

public class ProductDataMoker {

	static String[] roupas = { "Camiseta", "Meia", "Cueca", "Calcinha", "Calça", "Moleton", "Boné", "Meia Calça", "Sutien",
			"Vestido", "Camisa Social" };
	static String[] tamanho = { "P(Pequeno)", "M(Medio)", "G(Grande)", "GG(Enorme)", "XG(Hiper Grande)", "XXG(Decomunal)" };
	static String[] caract = { "Verde", "Florida", "Listrada", "Lisa", "Amarela", "Branca", "Verde", "Preta", "Vermelha",
			"Rosa" };
	static int roupasLen = roupas.length-1;
	static int tamanhoLen = tamanho.length-1;
	static int caractLen = caract.length-1;
	
	public static void populateProduct(ProductService productService) {
		try {

			for (int i = 0; i < 1000; i++) {

				Product product = new Product();
				product.setDescription(
						roupas[ran(roupasLen)] + " " + caract[ran(caractLen)] + " " + tamanho[ran(tamanhoLen)]);;
				product.setPrice(price());
				productService.newProduct(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static int ran(int limit) {
		Random rand = new Random();
		int value = rand.nextInt(limit);
		return value;
	}

	private static double price() {
		Random rand = new Random();
		int value = rand.nextInt(150) + 1;
		return value;
	}
}
