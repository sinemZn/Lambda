package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class L02 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 55));
		ciftKareMax(list);// en son methodun adini koyuyoruz maine ki calissin
		System.out.println();
		System.out.println("****");
		toplaEl1(list);// lamda expression
		System.out.println();
		System.out.println("****");
		ciftCarpim1(list);
		System.out.println();
		System.out.println("****");
		ciftCarpim2(list);
		System.out.println();
		System.out.println("****");
		onbestenBykKckTekSayi(list);
		System.out.println();
		System.out.println("****");
		ciftKareKckByg(list);
		System.out.println();
		System.out.println("****");
		
	}

	// List'in cift olan elelmanlarin karelerini aliniz ve en buyugunu yazdiriniz
	public static void ciftKareMax(List<Integer> list) {
		Optional<Integer> maxEl = list.stream().filter(L01::ciftBul).map(t -> t * t).reduce(Integer::max);
		// Optional<Integer>maxEl=list.stream().filter(L01::ciftBul).map(t->
		// t*t).reduce(Math::max);
		// Math::max da kullanilabilir ama integer daha spesifiktir.yazilimda daha kucuk
		// olan kume tercih edilir

		// int maxEl=list.stream().filter(L01::ciftBul).map(t->
		// t*t).reduce(Integer::max);

		// reduce return edilen elemen null yada int dan buyuk olur ihtimaline binaen
		// java guvenlik olarak handle ederek
		// optianal classi sart kosar.bu yuzden int maxEl hata verir

		System.out.println(maxEl);

	}

	// Listteki tum elemanlarin toplamini yazdiriniz
	// Lambda expression..
	public static void toplaEl1(List<Integer> list) {
		Optional<Integer> toplam = list.stream().reduce((x, y) -> x + y);
		// x her zaman ilk degerini atanan degerden (0)alir
		// y her zaman degerini list.stream()den alir
		// x ilk degerden sonraki degerlerini islemden alir

		System.out.println(toplam);

	}
	// Listteki tum elemanlarin toplamini yazdiriniz
	// Method reference ile..

	public static void toplaEl2(List<Integer> list) {
		Optional<Integer> toplam = list.stream().reduce(Integer::sum);
		// Optional<Integer>toplam= list.stream().reduce(Math::addExact); bunla da olur

		// yukaridaki soruda elle yazmistik,burada Integer::sum ile yaptik.
		// x her zaman ilk degerini atanan degerden (0)alir
		// y her zaman degerini list.stream()den alir
		// x ilk degerden sonraki degerlerini islemden alir

		System.out.println(toplam);
	}

	// Listteki cift elemanlarin carpimini yazdiriniz
	// Method reference ile..
	public static void ciftCarpim1(List<Integer> list) {
		Optional<Integer> carp = list.stream().filter(L01::ciftBul).reduce(Math::multiplyExact);
		System.out.println(carp);

	}

	// Listteki cift elemanlarin carpimini yazdiriniz
	// Lambda expression ile..
	public static void ciftCarpim2(List<Integer> list) {
		Integer carp = list.stream().filter(L01::ciftBul).reduce(1, (x, y) -> (x * y));
		// pztf deger ciksin
		Integer carpPztf = list.stream().filter(L01::ciftBul).reduce(-1, (x, y) -> (x * y));
		System.out.println(carp);
	}

	// listteki elemanlardan en kucugunu 4 farkli yontemle yaziniz
	// 1.yontem method reference--> integer class ile
	public static void min1(List<Integer> list) {
		Optional<Integer> min = list.stream().reduce(Integer::min);
		System.out.println(min);
	}

	// 2.yontem Method reference --> math class ile
	public static void min2(List<Integer> list) {
		Optional<Integer> min = list.stream().reduce(Math::min);
		System.out.println(min);
	}
	// 3. yontem Method reference --> haluk class ile

	public static int minBul(int x, int y) {
		return x < y ? x : y; // ternary ile
	}

	public static void min3(List<Integer> list) {
		Optional<Integer> min = list.stream().reduce(L02::minBul);
		System.out.println(min);
	}

	// 4.yontem Lmada Expression
	public static void min4(List<Integer> list) {
		Integer min = list.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);
		System.out.println(min);
	}
	// listteki 15den buyuk en kucuk tek sayiyi yazdiriniz

	public static void onbestenBykKckTekSayi(List<Integer> list) {
		list.stream().filter(t -> t % 2 == 1).filter(t -> t > 15).reduce(Integer::min);
		// list.stream().filter(t->t %2 ==1 & t>15).filter(t->
		// t>15).reduce(Integer::min); bu da olur
		System.out.println(list.stream().// akisa girdi
				filter(t -> t % 2 == 1 & t > 15).// tek ve 15ten buyuk sarti
				filter(t -> t > 15).reduce(Integer::min));// min deger reduce edildi

	}

	// listin cift elemanlarini karelerini buyukten kucuge siralayin
	public static void ciftKareKckByg(List<Integer> list){
	    list.
	            stream().
	            filter(L01::ciftBul).
	            map(t->t*t).
	            sorted().//akısa giren elelmanlar naturel order'e gore siralanir
	            forEach(L01::printEl);//144 484 1156 1764 3600 
	}
	public static void tekKareBygKck(List<Integer> list){
	    list.
	            stream().
	            filter(t->t%2!=0).
	            map(t->t*t).
	            sorted(Comparator.reverseOrder()). //akısa giren elelmanlar ters siralanir
	            forEach(L01::printEl);//144 484 1156 1764 3600


	}
}
