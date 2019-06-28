import java.io.File;
public class TesteFileManager {
	public static void main(String[] args){
		EscolherArquivoJanela janelaArquivoEscolher=new EscolherArquivoJanela();
		File arquivo=janelaArquivoEscolher.getArquivo();
		System.out.println(arquivo.getName());
	}
}

