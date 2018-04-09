package zadaciVezbaSPA;

import labis.exception.LabisException;
import labis.niz.ANiz;

public class Niz extends ANiz {
	// Napisati metodu koja pronalazi zbir tri najvece vrednosti u nizu jednim
	// prolaskom kroz niz.
	public int zbirNajvecih(int[] niz) throws LabisException {
		if (niz == null || niz.length < 3) {
			throw new LabisException();
		}
		int m1 = niz[0], m2 = niz[1], m3 = niz[2];
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] > m1 && m1 <= Math.min(m2, m3))
				m1 = niz[i];
			else if (niz[i] > m2 && m2 <= Math.min(m1, m3))
				m2 = niz[i];
			else if (niz[i] > m3 && m3 <= Math.min(m1, m2))
				m3 = niz[i];
		}

		return m1 + m2 + m3;
	}

	// . Data su dva niza sortirana u neopadajucem redosledu. Vratiti niz sortiran
	// takodje u
	// neopadajucem redosledu, tako da sadrzi sve elemente dva niza. public int[]
	// spoj(int[] niz1,
	// int[] niz2) kako da testiram? (u mainu kucas int[] prvi = new int[]{1,2,...};
	// int[] drugi = new
	// int[]{1,2,...}; int[] treci = spoj(prvi, drugi))
	public static int[] spojidva(int[] prvi, int[] drugi) throws LabisException {
		if (prvi == null || drugi == null || (prvi.length == 0 && drugi.length == 0)) {
			throw new LabisException();
		}
		if (prvi.length == 0) {
			return drugi;
		}
		if (drugi.length == 0) {
			return prvi;
		}
		int brojac = 0;
		int i = 0,j = 0;
		int[] novi = new int[prvi.length + drugi.length];
		
		while(i != prvi.length || j != drugi.length) {
			if(i == prvi.length) {
				novi[brojac] = drugi[j];
				brojac++;
				j++;
				continue;
			}
			if(j == drugi.length) {
				novi[brojac] = prvi[i];
				brojac++;
				i++;
				continue;
			}
			if(prvi[i] > drugi[j]) {
				novi[brojac] = drugi[j];
				brojac++;
				j++;
				continue;
			}else {
				novi[brojac] = prvi[i];
				brojac++;
				i++;
				continue;
			}
		}
		return novi;
	}

}
