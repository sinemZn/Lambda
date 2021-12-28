package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class L01 {
	/*
	 * 1) Lambda "Functional Programming" "Functional Programming" de
	 * "Nasil yaparim?" degil "Ne yaparim?" dusunulur. 2) "Structured Programming"
	 * de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur 3)
	 * "Functional Programming" hiz, code kisaligi, code okunabilirligi ve hatasiz
	 * code yazma acilarindan cok faydalidir. 4) Lambda sadece
	 * collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak
	 * map'lerde kullanılmaz. Lambda kullanmak hatasız code kullanmaktır.
	 */

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55));
		printStructured(list); // kodun calismasi icin en son method call yazdik buraya sirasiyla her methoda
		System.out.println();
		System.out.println("*****");
		printFunctional(list);// lambda expression calisti
		System.out.println();
		System.out.println("*****");
		printElFunctional1(list);// method reference calisti
		System.out.println();
		System.out.println("*****");
		printCiftElStructured(list);
		System.out.println();
		System.out.println("*****");
		printCiftElFunctional1(list);
		System.out.println();
		System.out.println("*****");
		printCiftElFunctional2(list);
		System.out.println();
		System.out.println("*****");
		printCiftAltmisKucuk(list);
		System.out.println();
		System.out.println("*****");
		printTekYirmiBuyuk(list);
		System.out.println();
		System.out.println("*****");
		printCiftKare(list);
		System.out.println();
		System.out.println("*****");
		printKupFazla(list);
		System.out.println();
		System.out.println("*****");
		printCiftKarekok(list);
		System.out.println();
		System.out.println("*****");
		maxElFunction(list);

	}

	// structure programming ile list elemanlarinin tamamini bosluklu yazdiriniz
	public static void printStructured(List<Integer> list) {
		for (Integer w : list) {
			System.out.print(w + " ");
		}
	}
	// functional programming ile list elemanlarinin tamamini bosluklu yazdiriniz

	public static void printFunctional(List<Integer> list) {

		list.stream().forEach(t -> System.out.print(t + " "));// lambda expression:lambda ifadesi
		// stream: datalari yukaridan asagiya akis sekline getirir.
		// forEach(): datanin parametresine gore her bir elemani isler
		// t-> : Lambda operatoru
		// Lambda Expression yapisi cok tavsiye edilmez.daha cok METHOD REFERENCE
		// kullanilir.
	}
	// Method Reference: kendi create ettigimiz veya javan aldigimiz method ile
	// ClassName::MethodName -->ezberleyin

	public static void printEl(int t) {
		System.out.print(t + " ");// refere edilecek methodu creat ettim
	}

	public static void printElFunctional1(List<Integer> list) {
		list.stream().forEach(L01::printEl);// lamabda bu
	}

	// structure programming ile list elemanlarinin cift elemanlarini bosluklu
	// yazdiriniz
	public static void printCiftElStructured(List<Integer> list) {
		for (Integer w : list) {
			if (w % 2 == 0) {
				System.out.print(w + " ");
			}
		}

	}

	// functional programming ile list elemanlarinin cift elemanlarini bosluklu
	// yazin
	public static void printCiftElFunctional1(List<Integer> list) {
		list.stream().filter(t -> t % 2 == 0).forEach(L01::printEl);// lambda expression yaptik

		// filter(): bir akis icerisindeki elemanlari istenen sarta gore filtreliyor.

	}

	public static boolean ciftBul(int i) {// refere edilecek tohum method yaptik

		return i % 2 == 0;
	}

	public static void printCiftElFunctional2(List<Integer> list) {
		list.stream().filter(L01::ciftBul).forEach(L01::printEl);// burada iki tane method refer ettik.lambda refere
																	// yaptik
	}
	// Functional Programming ile list elemanlarinin cift olanalrinin 60 dan kucuk
	// olanlarını
	// ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void printCiftAltmisKucuk(List<Integer> list) {
		list.stream().filter(t -> t % 2 == 0 & t < 60).forEach(L01::printEl);

	}

	// Functional Programming ile list elemanlarinin tek olanlarini veya 20den buyuk
	// olanlarını
	// ayni satirda aralarina bosluk birakarak yazdiriniz

	public static void printTekYirmiBuyuk(List<Integer> list) {
		list.stream().filter(t -> t % 2 == 1 || t > 20).forEach(L01::printEl);
	}
	//Functional Programming ile list elemanlarinin  cift olanlarinin
	// karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void printCiftKare(List<Integer> list) {
		list.stream().filter(L01::ciftBul).map(t->t*t).forEach(L01::printEl);
		
	}
	//Functional Programming ile list elemanlarinin  tek olanlarinin
	// kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void printKupFazla(List<Integer> list) {
		list.stream().filter(t->t%2==1).map(t->(t*t*t)+1).forEach(L01::printEl);
	}
	//Functional Programming ile list elemanlarinin  cift olanlarinin
	//karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
	
	public static void printCiftKarekok(List<Integer> list) {
		list.
		stream().
		filter(L01::ciftBul).
		map(Math::sqrt).
		forEach(t->System.out.println(t+" "));//genelde boyle altalta yazilir
	}
	//listin en buyuk elemanini yazdiriniz
	public static void maxElFunction(List<Integer> list) {
	Optional<Integer> maxEl=list.stream().reduce(Math::max);
	System.out.println(maxEl);
	
	//reduce() : bir cok datayi bir tek dataya indirgemek icin kullanilir.(max-min sorulari,carp,topla vb)
	}
	
	

}
