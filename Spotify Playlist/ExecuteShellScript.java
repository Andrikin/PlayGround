import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ExecuteShellScript {
	Process processoShell;
	String linkMusica;

	public ExecuteShellScript(String musica){
		this.linkMusica="https://www.youtube.com/watch?v="+musica;
		try{
			String executandoShellScript="bash /home/andre/Scripts/youtube-download.sh "+linkMusica;
			processoShell=Runtime.getRuntime().exec(executandoShellScript);
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

