// a ideia é fazer com que o programa pegue a lista do Spotify e baixe as músicas do YouTube
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
class Programa{
	public static void main(String[] args){
		BufferedReader arquivo;
		ExecuteShellScript script;
		EscolherArquivoJanela janelaEscolherArquivo=new EscolherArquivoJanela();
		File listaMusicaFormatada=janelaEscolherArquivo.getArquivo();
		try{
			arquivo=new BufferedReader(new FileReader(listaMusicaFormatada));
			String lendoMusica;
			while((lendoMusica=arquivo.readLine())!=null){
				// tratantando String para colocar com a url
				String pesquisarMusica=lendoMusica.replaceAll(" ", "+");
				GetUrlYoutube youtube=new GetUrlYoutube(pesquisarMusica);
				String iD=youtube.getUrl();
				script=new ExecuteShellScript(iD);
				System.out.println(String.format("Música: %s concluída!", lendoMusica));
			}
		}catch (SecurityException excecaoDeSeguranca){
			System.err.println("Você não tem acesso a este arquivo!");
			System.exit(1);
		}catch(FileNotFoundException excecaoArquivoNaoEncontrado){
			System.err.println("Erro ao abrir ou criar arquivo!");
			System.exit(1);
		}catch(IOException excecaoDeIO){
			System.err.println("Arquivo não pode gravar informações!");
			System.exit(1);
		}
	}
}
