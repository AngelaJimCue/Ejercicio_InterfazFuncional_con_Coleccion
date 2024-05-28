package interfaz_funcional.interfazfuncional_concolecciones;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
public class Ejercicio1 {
	/*ENUNCIADO1: Método para realizar una transformación mediante una función lambda a una lista de cualquier tipo.*/
	     /*private <T> -->Significa que es una "T" genérica, sino la ponemos da error porque espera una clase, un String o algo.*/
	private static <T> void transformaLista(List<T> lista, Function<T,T>function) {
		for (T elemento : lista) { //PARA VER LO QUE HACE ANTES DEL FOR
			System.out.println(elemento);
		}
		
		for (int i= 0; i<lista.size(); i++) {/*VA DEL 0 HASTA EL ANTERIOR, DARÁ LOS ÍNDICES DE TODA LA LISTA.*/
			lista.set(i, function.apply(lista.get(i)/*para acceder al elemento.*/)/*aplico esa transformacion a los del ()*/);	
		}
		
		for (T elemento : lista) { //PARA VER LO QUE HACE DESPUÉS DEL FOR
		System.out.println(elemento);
		}
	}
	
	/*ENUNCIADO2: Método para generar una nueva lista a partir de otra aplicando una 
	  transformación expresada como lambda.
	 */
	private static <T,R> List<R> generarLista (List <T> lista2, Function<T, R> funcion2){
		List<R> listaModificada = new ArrayList<>();
		for(int i = 0; i< lista2.size(); i++) {
			listaModificada.add(funcion2.apply(lista2.get(i)));
		}
		return listaModificada;
	}
	
	/*ENUNCIADO3: Método para devolver una lista filtrada.*/	
	private static <T> List<T> generarListaFiltrada(List <T> filtradaLista, Predicate<T> predicado) {
		List<T> listaFiltrada = new ArrayList<>();
        for (T elemento : filtradaLista) {
            if (predicado.test(elemento)) {
                listaFiltrada.add(elemento);
            }
        }
        return listaFiltrada;
    }

	
	/*ENUNCIADO4: Método para devolver una lista que contenga 
	 los elementos de dos listas unidos en una nueva, filtrando 
	 con un filtro en la primera y otro en la segunda.
	 */
	private static <T> List<T> unirYFiltrarListas (List <T> unirFiltrarListas1, 
			List <T> unirFiltrarListas2, Predicate<T> predicado1, Predicate<T> predicado2) {
		
        return null;
    }
	
	/*ENUNCIADO5: Método para realizar una acción de tipo consumer 
	  para todos los elementos de una lista.
	 */
	private static <T> void aplicarAccion(List<T> AplicarAccionLista, Consumer<T> accionEnUnaLista) {
		for (T elemento : AplicarAccionLista) {
            accionEnUnaLista.accept(elemento);
        }
    }
	

	public static void main(String[] args) {
		//ENUNCIADO 1
		List<Integer> miListaDeNumeros = new ArrayList<>();
		miListaDeNumeros.add(3);//Añadir elementos a la lista.
		miListaDeNumeros.add(2);//Añadir elementos a la lista.
		miListaDeNumeros.add(1);//Añadir elementos a la lista.
				
		List<String> miListaDeString = new ArrayList<>();
		miListaDeString.add("¿Cómo estás?");
		miListaDeString.add("Very sad");
		miListaDeString.add("and depression");
		
		/*Function is a raw type --> puede dar este peligro porque es genérico y no hemos puesto nada, para que no salga le concretamos algo <algo,algo>.*/
		Function <Integer,Integer> miFuncion = num -> num * 2;/*Como no vamos a usarla, no le ponemos de que tipo es, sino que es NULL.*/
		
		/*Puede que aquí de error porque list y function tenga tipos de datos distintos, como integer y otro object*/
		transformaLista(miListaDeNumeros, miFuncion /*Pongo la lamda directamente y puedo borrar la línea 31 (function <in,in>)*/);
		/*En el resultado 1º muestra la lista (1º foreach) y en 2º muestra la lista después del for.*/
		
		System.out.println("***************************************");
		
		transformaLista(miListaDeString, string -> string.toUpperCase());
		
		System.out.println("---------------------------------------------------------");
		//ENUNCIADO 2
		List <String> listaDeString = new ArrayList<>();
		listaDeString.add("Hoy,");
		listaDeString.add("Mañana y ");
		listaDeString.add("Ayer");
		
		Function<String,String> añadirTexto = string -> "Ansiedad: " + string;
		
		System.out.println(generarLista(listaDeString, string -> string.length()));
		generarLista(listaDeString, cadena -> cadena.length());
		System.out.println("***************************************");
		transformaLista(listaDeString, añadirTexto);
		System.out.println(generarLista(listaDeString, string -> string.length()));//Cuenta las palabras y espacio de la línea de arriba.
		
		System.out.println("---------------------------------------------------------");
		//ENUNCIADO 3
		List <Integer> filtradaEnteros = new ArrayList<>();
		filtradaEnteros.add(23);
		filtradaEnteros.add(17);
		filtradaEnteros.add(8);
		
		List <String> filtradaCadena = new ArrayList<>();
		filtradaCadena.add("Vaca");
		filtradaCadena.add("Cabra");
		filtradaCadena.add("Sanguijuela");
		filtradaCadena.add("Buitre");
		
		Predicate <Integer> sumarEnteros = numero -> numero %2 ==0; //Devuelve boolean.
		System.out.println("Números que son pares -->" +
		generarListaFiltrada(filtradaEnteros, sumarEnteros));//Sólo mostrará los numeros de la condición. En este caso le digo nº pares y el nº 8 es el único número par.
		System.out.println("***************************************");
		Predicate<String> contieneA = cadena -> cadena.contains("a");
		System.out.println("Palabras que contiene la letra A -->" +
		generarListaFiltrada(filtradaCadena, contieneA ));//Sólo muestra las palabras que contienen la letra "A" y resto de la lista lo elimina.
		System.out.println("Palabras que contiene la letra E -->" + 
		generarListaFiltrada(filtradaCadena, cadena -> cadena.contains("e")));
		
		System.out.println("---------------------------------------------------------");
		//ENUNCIADO 4
		
		
		System.out.println("---------------------------------------------------------");
		//ENUNCIADO 5
		List <String> aplicarAccionString = new ArrayList<>();
		aplicarAccionString.add("La vache abandonne tout pour une truie.");
		List<Double> aplicarAccionDecimal = new ArrayList<>();
		aplicarAccionDecimal.add(23.0);
		aplicarAccionDecimal.add(0.8);
     
		Consumer<String> convertirEnMayuscula = cadena -> System.out.println(cadena.toUpperCase());
		aplicarAccion(aplicarAccionString, convertirEnMayuscula);
		System.out.println("***************************************");
		Consumer<Double> raizCuadradaDecimal = numero -> System.out.printf("La raíz cuadrada de %.1f es: %.2f%n",numero, Math.sqrt(numero));
		aplicarAccion(aplicarAccionDecimal, raizCuadradaDecimal);
		
	}
}
