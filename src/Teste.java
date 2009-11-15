import java.io.IOException;

//import org.jfugue.Pattern;
//import org.jfugue.Player;


public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Digite o troco");
		int troco = 950;
		
		System.out.println("A entrada eh "+troco);
		
		
		int i;
		int[] vetor = {1,2,5,10,20,50,100};
		
		System.out.println("troco: ");
		
		for (int j = vetor.length - 1; j >= 0; j--) {
			while ((troco >= vetor[j])) {
				System.out.println(vetor[j]);
				troco = troco - vetor[j];
			}			
		}
	}
	
	//public void troco (int troco)

}
