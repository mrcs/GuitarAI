import org.jfugue.Pattern;
import org.jfugue.Player;


public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Player t = new Player();
		//t.stop();
		//t.play("Cmaj5q F#min2h Bbmin13^^^");
		
		Player player = new Player();
		//Pattern pattern = new Pattern("I[24] C D E F G A B");
		//player.play(pattern);
		
		t.play("T[90] I[25] Gmaj7w Gmajw");
	}

}
