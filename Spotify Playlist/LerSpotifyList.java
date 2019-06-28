// Lê .txt e cria um novo arquivo com o texto formatado
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
class LerSpotifyList{
	Scanner arquivo;
	Formatter arquivoNovo;

	public void abrirArquivo(){
		try{
			this.arquivoNovo=new Formatter("Old but Gold Formatado.txt");
			this.arquivo=new Scanner(new File("Old but Gold.txt"));
		}catch(FileNotFoundException arquivoNaoEncontrado){
			System.err.println("Erro! Arquivo não encontrado!");
			System.exit(1);
		}catch(SecurityException acessoAoArquivo){
			System.err.println("Erro! Você não tem acesso ao arquivo!");
			System.exit(1);
		}
	}

	public void lerArquivo(){
		try{
			while(arquivo.hasNext()){
				String linha=arquivo.nextLine();
				String[] linhaFormatada=linha.split(" - ");
				this.arquivoNovo.format("%s\n", linhaFormatada[0]+" - "+linhaFormatada[1]);
				System.out.printf("%s\n", linhaFormatada[0]+" - "+linhaFormatada[1]);
			}
		}catch(NoSuchElementException arquivoMalFormatado){
			System.err.println("Erro! Arquivo mal formatado!");
			arquivo.close();
			System.exit(1);
		}catch(IllegalStateException erroAoLerArquivo){
			System.err.println("Erro ao ler o arquivo!");
			System.exit(1);
		}
	}

	public void fecharArquivo(){
		if(arquivo!=null||arquivoNovo!=null){
			arquivo.close();
			arquivoNovo.close();
		}
	}
}
