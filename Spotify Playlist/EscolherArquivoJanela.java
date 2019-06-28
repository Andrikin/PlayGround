import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;
public class EscolherArquivoJanela extends JPanel{
	JFileChooser fileManager;

	public EscolherArquivoJanela(){
		super(new BorderLayout());
		this.fileManager=new JFileChooser();
		fileManager.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	}

	public File getArquivo(){
		int escolhaDoUsuario=fileManager.showOpenDialog(EscolherArquivoJanela.this);
		if(escolhaDoUsuario==JFileChooser.CANCEL_OPTION)
			System.exit(1);
		File arquivo=fileManager.getSelectedFile();
		if(arquivo==null||arquivo.getName().equals("")){
			JOptionPane.showMessageDialog(this, "Nome inválido", "Nome inválido", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		return arquivo;
	}
}

