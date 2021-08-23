/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author victo
 */
public class Suporte {
      
    
    
    public void NewDirectory(String name) {
        new File("C:\\Users\\Thety\\OneDrive\\Documentos\\NetBeansProjects\\projeto 2\\projeto_2_server"+name).mkdir();
    }
    public void visualizarArquivos(String diretorio) throws IOException {

	File file = new File(diretorio);
	File[] arquivos = file.listFiles();
	
	
        for (int j = 0; j < arquivos.length; j++) {
                
                if(arquivos[j].getName().contains(".")){
                    System.out.println(arquivos[j].getCanonicalPath()+" arq");
                        
                } else{
                    System.out.println(arquivos[j].getCanonicalPath());
                    visualizarArquivos(diretorio+"\\"+arquivos[j].getName());
                }
                
        }
       

}
    public void MovePasta(String Arquivo){
        // Arquivo a ser movido
        File arquivo = new File(Arquivo);

        if (!arquivo.exists()) {
            System.out.println("Arquivo nao encontrado");
        } else {
            // Diretorio de destino
            File diretorioDestino = new File("C:\\Users\\Thety\\Desktop");

            // Move o arquivo para o novo diretorio
            boolean sucesso = arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
            if (sucesso) {
                System.out.println("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
            } else {
                System.out.println("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
                        + diretorioDestino.getAbsolutePath() + "'");
            }
        }
}
}

