package customplugin.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * Creates an custom dialog and opens it.
 *
 */
public class SayHello extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		//open a dialog window to select a file
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(fileChooser);
		
		if (result == JFileChooser.APPROVE_OPTION) {
		    // user selects a file
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			
			//read the file
		    FileReader fr;
			try {
				fr = new FileReader(selectedFile);
				BufferedReader br = new BufferedReader(fr);
			    String line = br.readLine();
			    while(line != null) {
			        System.out.println(line);
			        line = br.readLine();
			    }
			    br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//move the file
			String src = selectedFile.getAbsolutePath();
			String dest = "/home/ausy/Romain/dest.txt";
						
	        try {
				Files.copy(Paths.get(src), Paths.get(dest));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

		return null;
	}
}
