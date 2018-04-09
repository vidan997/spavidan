package zadaciVezbaSPA;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.AJSLista;

public class JSLista extends AJSLista {
	// Napisati metodu koja izbacuje minimum u JS listi
	public CvorJSListe izbaciMin() throws LabisException {
		if (prvi == null)
			throw new LabisException();
		CvorJSListe pom = prvi;
		if (prvi.sledeci == null) {
			prvi = null;
			return pom;
		}
		CvorJSListe min = prvi;
		while (pom != null) {
			if (pom.podatak < min.podatak) {
				min = pom;
			}
			pom = pom.sledeci;
		}
		pom = prvi;
		while (pom.sledeci != min) {
			pom = pom.sledeci;
		}
		pom.sledeci = min.sledeci;
		return min;
	}

	// Napisati metodu unakrsno spaja dve JS liste jednakih duzina 1 2 3 4 5 11 12
	// 13 14 15
	// rezultat je pokazivac na prvi element liste: 1 11 2 12 3 13 4 14 5 15.
	public void unakrsno(CvorJSListe prvi1, CvorJSListe prvi2) throws LabisException {
		if (prvi1 == null && prvi2 == null)
			return;
		CvorJSListe pom1 = prvi1.sledeci;
		CvorJSListe pom2 = prvi2.sledeci;
		prvi1.sledeci = prvi2;
		prvi2.sledeci = pom1;
		unakrsno(pom1, pom2);
	}

	// Napisati metodu koja proverava da li su elementi JS liste redom elementi
	// Fibonacijevog niza.
	// Fibonacijev niz: F[0] = 1; F[1] = 1; F[i] = F[i - 1] + F[i - 2], za i >=2
	// public boolean fibonaci().
	public boolean fibonacijevNiz(CvorJSListe p) throws LabisException {
		if (p == null || p.sledeci == null)
			throw new LabisException();
		if (p.podatak != 1 || p.sledeci.podatak != 1)
			return false;
		CvorJSListe pom = p.sledeci.sledeci;
		CvorJSListe pom1 = p;
		CvorJSListe pom2 = p.sledeci;
		while (pom != null) {
			int zbir = pom2.podatak + pom1.podatak;
			if (zbir != pom.podatak)
				return false;
			pom2 = pom2.sledeci;
			pom1 = pom1.sledeci;
			pom = pom.sledeci;
		}

		return true;
	}

	// . Dat je pokazivac na prvi element JS liste. Napisati metodu koja iz date
	// liste izbacuje
	// drugi i treci element od kraja iz date liste i ne vraca nista
	public void izbaciOdKraja() throws LabisException {
		if (prvi == null || prvi.sledeci == null || prvi.sledeci.sledeci == null)
			throw new LabisException("U listi ima manje od 3 elemenata.");
		if (prvi.sledeci.sledeci.sledeci == null) {
			prvi = prvi.sledeci.sledeci;
			return;
		}
		CvorJSListe pom = prvi;
		while (pom.sledeci.sledeci.sledeci != null) {
			pom = pom.sledeci;
		}
		pom.sledeci = pom.sledeci.sledeci;
		pom = prvi;
		while (pom.sledeci.sledeci.sledeci != null) {
			pom = pom.sledeci;
		}
		pom.sledeci = pom.sledeci.sledeci;
	}

	public boolean postoji(int pod, CvorJSListe prvi) {
		CvorJSListe pom = prvi;
		while (pom != null) {
			if (pom.podatak == pod)
				return true;
			pom = pom.sledeci;
		}
		return false;
	}

	// Napisati metodu koja pravi treecu listu koja predstavlja simetricnu razliku
	// dve JS
	// liste(unija bez preseka) Primer: 1 2 3 4 5 i 3 4 5 6 -> 1 2 6.
	public CvorJSListe simetricnaRazlika(CvorJSListe prvi1, CvorJSListe prvi2) throws LabisException {
		CvorJSListe nova = null;
		CvorJSListe pom = prvi1;
		CvorJSListe pom1 = prvi2;
		while (pom != null) {
			if (!postoji(pom.podatak, prvi2)) {
				nova = new CvorJSListe(pom.podatak, nova);
			}
			pom = pom.sledeci;
		}
		while (pom1 != null) {
			if (!postoji(pom1.podatak, prvi1)) {
				nova = new CvorJSListe(pom1.podatak, nova);
			}
			pom1 = pom1.sledeci;
		}

		return nova;
	}

	// Napisati metodu koja is JS liste izbacuje sve duplikate.
	public void izbaciDuple() throws LabisException {
		if (prvi == null) {
			throw new LabisException();
		}
		CvorJSListe pom = prvi;
		CvorJSListe pom1 = prvi.sledeci;
		while (pom.sledeci != null) {
			while (pom1.sledeci != null && pom1.sledeci.podatak != pom.podatak) {
				pom1 = pom1.sledeci;
			}
			if (pom1.sledeci != null) {
				pom1.sledeci = pom1.sledeci.sledeci;
			}
			pom = pom.sledeci;
			pom1 = pom.sledeci;
		}
	}
	
	//Dat je pokazivac na prvi element JS liste. Napisati metodu koja izbacuje sve elemente
	//vece od svog prethodnika.
	public void izbaciVecePreth() throws LabisException{
		if(prvi == null || prvi.sledeci == null)
			throw new LabisException();
		
		CvorJSListe pom = prvi;
		
		while(pom.sledeci!=null) {
			if(pom.sledeci.podatak > pom.podatak) {
				pom.sledeci = pom.sledeci.sledeci;
			}
			pom = pom.sledeci;
		}
	}
}
