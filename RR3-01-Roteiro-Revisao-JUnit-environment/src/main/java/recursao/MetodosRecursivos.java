package recursao;

public class MetodosRecursivos {

	public long calcularFatorial(int n) {
		long result = 1;

		//caso base: não faz nada
		if(n == 0){} 
		//caso recurssivo: multiplica o número pelo fatorial do seu anterior recurssivamente
		else {
			result = n * calcularFatorial(n-1);
		}
		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;

		//caso base: temos que calcular o 1° ou o 2° número da sequencia de fibonacci (que já são iguais a 1, valor inicial do result), o programa não faz nada
		if(n == 1 || n == 2){}
		//caso recurssivo: a partir do terceiro termo, o número da sequencia é igual a soma dos dois números anteriores a ele
		else{
			result = calcularFibonacci(n-1) + calcularFibonacci(n-2);
		}
		
		return result;
	}

	public int countNotNull(Object[] array) {
		return countNotNull(array, 0);
	}

	private int countNotNull(Object[] array, int index){
		//contabiliza os elementos não nulos de um array
		int result = 0;

		//contabilização tem que ser feita logo no início: se o objeto do array na posição index for diferente de nulo, somamos +1 ao resultado
		if(array[index] != null){
			result ++;
		}
		//caso base: atingimos o último elemento do array
		if(index == array.length - 1){}

		//caso recurssivo: chamamos a função para o próximo elemento do array
		else{
			result += countNotNull(array, index+1);

		}
		return result;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		// TODO: IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA POTENCIA DE 2

		//caso base: expoente == 0
		if(expoente == 0){
		}

		//caso recurssivo: multiplicamos o "expoente anterior" por 2 até expoente == 0
		else{
			result = 2* potenciaDe2(expoente -1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		// TODO: IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO TERMO DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		
		//caso base: queremos o 1° termo da sequencia
		if(n == 1){}

		//caso recurssivo: vamos até o primeiro termo da sequencia, e depois vamos reconstruindo-a
		else{
			result = progressaoAritmetica(termoInicial, razao, n-1) + razao;
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO TERMO DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO

		//caso base: queremos o 1° termo da sequencia
		if(n == 1){}

		//caso recurssivo: vamos até o primeiro termo da sequencia, e depois vamos reconstruindo-a
		else{
			result = progressaoGeometrica(termoInicial, razao, n-1) * razao;
		}
		return result;
	}
	
	
}
