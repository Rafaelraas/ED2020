public class Recursividade {
	
	//public static String pilha = "";
	
	// ocupa (64 bits * n) por execucao
	public static int fat(int n) {
		// n! = n*(n-1)!
		if (n <= 1) {
			//pilha = pilha + " 1";
			return 1; // caso base
		} else {
			int r = n * fat(n-1); 
			//pilha = pilha + " - " + r;
			return r; 
		}
	}
	
	// ocupa 64 bits em memoria por execucao
	public static int fatLoop(int n) {
		// n*(n-1)*(n-2)*...*1
		int r=1;
		while (n>0) {
			r = r*n;
			n--;
		}
		return r;
	}
	
	// requer 2int * 2^n de memoria por execucao
	public static int fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			int a = fib(n-2);
			int b = fib(n-1);
			return a + b;
		}
	}
	
	public static int fibLoop(int n) {
	  int soma = n;
	  if (soma >= 2) {
	    int ant2=0;
	    int ant1=1;
	    soma = ant2+ant1;
	    for (int i=3; i<=n; i++) {
			ant2=ant1;
			ant1=soma;
			soma=ant1+ant2;
	    }
	  }
	  return soma;
	}
	
	
	public static void umPorVez(int a) {
        if (a < 10) {
            // caso base
            System.out.print(a);
        } else {
            umPorVez(a/10);
            int r = a%10;
            System.out.print(" ");
            System.out.print(r);
        }
    }
	

	public static void main(String[] args) {
		//System.out.println(fat(3));
		long startTime = System.nanoTime();
		System.out.println(fib(40));
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Tempo: " + (duration/1000000.0));
		startTime = System.nanoTime();
		System.out.println(fibLoop(40));
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		System.out.println("Tempo: " + (duration/1000000.0));
		
		umPorVez(6389012);
	}

}
