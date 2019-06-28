import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.IllegalFormatFlagsException;
public class GetUrlYoutube {
	BufferedReader youtube;
	String url;

	// A String da música chegará tratada
	public GetUrlYoutube(String musica){
		this.url="https://www.youtube.com/results?search_query="+musica;
	}

	public String getUrl(){
		final String USER_AGENT="Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0";
		String[] buscandoID=new String[0];
		try{
			URL url=new URL(this.url);
			HttpURLConnection conexao= (HttpURLConnection) url.openConnection();

			conexao.setRequestMethod("GET");

			conexao.setRequestProperty("User-Agent", USER_AGENT);

			int codigoResposta=conexao.getResponseCode();
			if(codigoResposta==200){
				BufferedReader lendoArquivo=new BufferedReader(new InputStreamReader(conexao.getInputStream()));
				String lendoLinha;
				while((lendoLinha=lendoArquivo.readLine())!=null){
					if(lendoLinha.contains("i.ytimg.com/vi/")){
						break;
					}
				}
				buscandoID=lendoLinha.split("/");
				if(lendoArquivo!=null){
					lendoArquivo.close();
				}
			}else{
				System.err.println(String.format("Erro! Conexão não estabelecida! Código: %d", codigoResposta));
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
		}catch(IllegalFormatFlagsException excecaoDeFlag){
			System.err.println("Excecao de Flag!");
			System.exit(1);
		}catch(ArrayIndexOutOfBoundsException excecao){
			System.err.println("ID não encontrado!");
			System.exit(1);
		}catch(NullPointerException excecao){
			System.err.println("ID nulo!");
			System.exit(1);
		}
		return buscandoID[4];
	}
}
