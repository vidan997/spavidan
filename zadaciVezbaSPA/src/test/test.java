package test;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.test.ListGenerator;
import zadaciVezbaSPA.JSLista;
import zadaciVezbaSPA.Niz;

public class test {

	public static void main(String[] args) {
		/*int[] prvi = new int[] {1,2,4,5,7};
		int[] drugi = new int[] {-20,4,5,6,10,11};
		int[] novi = null;
		try {
			novi = Niz.spojidva(prvi, drugi);
		} catch (LabisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0 ; i < novi.length ; i ++) {
			System.out.println(novi[i]);
		}*/
		JSLista lista = new JSLista();
		JSLista lista1 = new JSLista();
		CvorJSListe kurac = null;
		ListGenerator.napraviJSListuCommon(lista, new int[] {11,33,11,44,33,22}, false);
		ListGenerator.napraviJSListuCommon(lista1, new int[] {11,22,33,44,55}, false);
		ListGenerator.ispisiJSListu(lista.prvi);
		System.out.println("------------------------------------------------------------------");
		//ListGenerator.ispisiJSListu(lista1.prvi);
		try {
			lista.izbaciVecePreth();
		} catch (LabisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------------------------------------------------------------");
		ListGenerator.ispisiJSListu(lista.prvi);
	}

}
