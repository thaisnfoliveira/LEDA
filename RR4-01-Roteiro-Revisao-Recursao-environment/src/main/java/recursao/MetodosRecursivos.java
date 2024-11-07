package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRAY
		
		return calcularSomaArrayRecursivo(array, 0);
	}

	private int calcularSomaArrayRecursivo(int[] array, int index){
		int result = 0;
		if(index<array.length){
			result += array[index];
			result += calcularSomaArrayRecursivo(array, index + 1);
		}
		return result;
	}
	public long calcularFatorial(int n) {
		long result = 1;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS
		if(n > 1){
			result = result * calcularFatorial(n - 1);
		}
		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O N-ESIMO TERMO
		// DA SEQUENCIA DE FIBONACCI, QUE TEM A SEGUINTE LEI DE FORMACAO: O
		// PRIMEIRO E SEGUNDO NUMEROS
		// DA SEQUENCIA SÃO 1. A PARTIR DO TERCEIRO TERMO, CADA TERMO DA
		// SEQUENCIA É DADO
		// PELA SOMA DOS OUTROS DOIS ANTERIORES. OBSERVE QUE SENDO O METODO
		// RECURSIVO, O FIBONACCI DOS NUMEROS ANTERIORES TAMBEM VAO SER
		// IMPRESSOS
		if(n == 1 || n == 2){
			//caso base: não fazemos nada, pois o result já é igual a 1
		}else{
			result = calcularFibonacci(n-1) + calcularFibonacci(n-2);
		}
		return result;
	}

	public int countNotNull(Object[] array) {
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		return countNotNullRecursivo(array, 0);
	}

	private int countNotNullRecursivo(Object[] array, int index){
		int result = 0;
		if(array[index]!=null){
			result += 1;
		}

		if(index != array.length-1){
			result += countNotNullRecursivo(array, index+1);
		}
		
		return result;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		// TODO IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2
		if(expoente == 0){

		}else{
			result = 2 * potenciaDe2(expoente-1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		if(n == 0){
			//caso base: nada fazemos
		}
		else{
			result += progressaoAritmetica(termoInicial, razao, n-1) + razao;
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		if(n == 0){
			//caso base: nada fazemos
		}
		else{
			result += progressaoGeometrica(termoInicial, razao, n-1) * razao;
		}
		return result;
	}
	
	
}
