package nacional2019;

// EJERCICIO A DE LA LISTA NACIONAL 2019
// funciona, pero hay que optimizarlo

import java.util.Scanner;

class Vivienda {
	public char letra;
	public int npersonas;

	public Vivienda (char letra) {
		this.letra = letra;
		this.npersonas = 0;
	}

}

class Edificio {
	int p, l;
	Vivienda[][] pisos;

	public Edificio (int p, int l) {
		this.p = p;
		this.l = l;

		pisos = new Vivienda[p][];
		for (int i = 0; i < p; i++) {
			pisos[i] = new Vivienda[l];
			for (int j = 0; j < l; j++) {
				pisos[i][j] = new Vivienda((char) (65 + j));
			}
		}
	}

	public void addHabitante (int numero, char letra) {
		numero--;
		for (int i = 0; i < pisos[numero].length; i++) {
			if (pisos[numero][i].letra == letra) {
				pisos[numero][i].npersonas++;
			}
		}
	}

	public int getViviendas () {
		return p * l;
	}
	
	public int getAsistentes () {
		int h = 0;
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < l; j++) {
				if (pisos[i][j].npersonas >= 1) {
					h++;
				}
			}
		}
		return h;
	}

}

// ReunionChecker
public class A_ReunionVecinos {

	public static void main (String[] args) {
		Scanner ent = new Scanner(System.in);
		int p, l, a;
		Edificio[] casos = null;
		int ne = 0;

		do {
			p = ent.nextInt();
			l = ent.nextInt();
			a = ent.nextInt();

			Edificio[] casosExt = new Edificio[ne+1] ;
			for (int i=0; i < ne; i++) {
				casosExt[i] = casos[i];
			}
			casosExt[ne] = new Edificio(p, l);
			casos = casosExt;
			
			for (int i = 0; i < a; i++) {
				casos[ne].addHabitante(ent.nextInt(), ent.next().charAt(0));
			}

			ne++;
		} while (p > 0 && l > 0 && a > 0);
		
		for (int i=0; i < ne-1; i++) {
			Edificio edificio = casos[i];
			int viviendas = edificio.getViviendas();
			int requeridos = viviendas/2 + viviendas%2;
			
			if (casos[i].getAsistentes() >= requeridos) {
				System.out.println("EMPEZAMOS");
			} else {
				System.out.println("ESPERAMOS");
			}
		}
		
		ent.close();

	}
}
