public class TesteStringContains {
	public static void main(String[] args){
		String buscarId="        <img src=\"https://i.ytimg.com/vi/2ZBtPf7FOoM/hqdefault.jpg?sqp=-oaymwEjCPYBEIoBSFryq4qpAxUIARUAAAAAGAElAADIQj0AgKJDeAE=&amp;rs=AOn4CLD29JWcEmZjSVTUKY-1x6pVm9nBig\">";
		if(buscarId.contains("i.ytimg.com/vi/"))
			System.out.println("Deu certo!");
		else
			System.out.println("Deu errado!");
	}
}

