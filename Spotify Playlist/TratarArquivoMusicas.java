import java.util.Scanner;
import java.io.FileNotFoundException;
public class TratarArquivoMusicas {
	Scanner arquivo;

	public void abrirArquivo(){
		try{
			this.arquivo=new Scanner(new File("Old but Gold Formatado.txt"));
		}catch(FileNotFoundException arquivoNaoEncontrado){
			System.err.println("Erro! Arquivo não encontrado!");
			System.exit(1);
		}catch(SecurityException acessoAoArquivo){
			System.err.println("Erro! Você não tem acesso ao arquivo!");
			System.exit(1);
		}
	}

	public void tratarArquivo(){
		
	}

	public void fecharArquivo(){
		if(arquivo!=null)
			arquivo.close();
	}
}

