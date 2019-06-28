import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class TesteRuntime {
	public static void main(String[] args){
		String linkMusica="https://www.youtube.com/watch?v=2ZBtPf7FOoM";
		try{
			Process processoShell=Runtime.getRuntime().exec("bash /home/andre/Scripts/youtube-download.sh "+linkMusica);
			processoShell.waitFor();
		}catch(IOException excecaoIO){
			System.err.println("Erro de IOException!");
			System.exit(1);
		}catch(InterruptedException excecao){
			System.err.println("Erro de InterruptedException!");
			System.exit(1);
		}
	}
}

