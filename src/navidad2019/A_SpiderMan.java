package navidad2019;

///////////////////////////////////////////////////////////////////
//		Ejercicio A de la lista de navidad 2019
//		https://gitlab.com/blugnesblug/programame-2019
//		
//		Falta por hacer:
//		* input por archivo.
//		* que la salida sea toda de una y no en cada linea.
//
///////////////////////////////////////////////////////////////////

import java.util.Scanner;

/////////////////////////////////////////////////
//		Definición de Clase calle
/////////////////////////////////////////////////
 
class SpiderCalle {
	int spider;
	int bomba1;
	int bomba2;
	
	public SpiderCalle (int spider, int bomba1, int bomba2) {
		this.spider = spider;
		this.bomba1 = bomba1;
		this.bomba2 = bomba2;
	}
	
	public int getNearest () {
		if (Math.abs(spider - bomba1) < Math.abs(spider - bomba2)) {
			return bomba1;
		} else {
			return bomba2;
		}
	}
	
	public int getFurthest () {
		if (this.getNearest() == bomba1) {
			return bomba2;
		} else {
			return bomba1;
		}
	}
	
	public int getSpider() {
		return this.spider;
	}
}

/////////////////////////////////////////////////

public class A_SpiderMan {
	
	///////////////////////////////////////////////////////////////////
	//		Solución ilegible con progra estructurada
	///////////////////////////////////////////////////////////////////
	
	public static int calculoRaw (int s, int b1, int b2) {
		int dist = 0;
		
		// Comprueba si la bomba más cercana es b1 y la otra es b2
		// De no serlo las intercambia
		if (Math.abs(s - b1) > Math.abs(s - b2)) {
			int d = b2;
			b2 = b1;
			b1 = d;
		}
		
		// 4 casos
		if (b2 > s) {
			if (b1 > s) { 		// Spider al principio
				dist = b2-s;
			} else { 			// Spider en medio
				dist = s-b1;
				dist += b2-b1;
			}
		} else {
			if (b1 < s) {
				dist = s-b2;
			} else {
				dist = b1-s;
				dist += b1-b2;
			}
		}
		return dist;
	}
	
	///////////////////////////////////////////////////////////////////
	//		Solución orientada a objetos
	//		Utiliza la clase Linea
	///////////////////////////////////////////////////////////////////
	
	public static int calculoCalle (SpiderCalle linea) {
		int dist=0;
		if (linea.getSpider() > linea.getNearest()) {
			if (linea.getSpider() > linea.getFurthest()) {
				dist = linea.getSpider() - linea.getFurthest(); 
			} else {
				dist = linea.getSpider() - linea.getNearest();
				dist += linea.getFurthest() - linea.getNearest();
			}
		} else {
			if (linea.getSpider() < linea.getFurthest()) {
				dist = linea.getFurthest() - linea.getSpider();
			} else {
				dist = linea.getNearest() - linea.getSpider();
				dist += linea.getNearest() - linea.getFurthest();
			}
		}
		return dist;
	}
	
	///////////////////////////////////////////////////////////////////
	//		Main
	//		usando la solución orientada o objetos
	///////////////////////////////////////////////////////////////////
	
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);
		SpiderCalle data;
		int value;
		int nTimes = entrada.nextInt();
		
		for (int i = 0; i < nTimes; i++) {
			
			data = new SpiderCalle(
				Integer.valueOf(entrada.next()),
				Integer.valueOf(entrada.next()),
				Integer.valueOf(entrada.next()));
			
			value = calculoCalle(data);
			System.out.println(value);
		}
		entrada.close();
	}
	
	/////////////////////////////////////////////////
}

