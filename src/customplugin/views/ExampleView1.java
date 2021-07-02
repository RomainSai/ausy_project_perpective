package customplugin.views;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class ExampleView1 extends ViewPart {
	public static final String ID = "CustomPlugin.views.ExampleView1";

	public ExampleView1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
		//open a dialog window to select a file
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(fileChooser);
		
		if (result == JFileChooser.APPROVE_OPTION) {
		    // user selects a file
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			
			Text text = new Text(parent, SWT.BORDER);
			text.setText("Selected file: " + selectedFile.getAbsolutePath());
			
			//move the file
			String src = selectedFile.getAbsolutePath();
			String dest = "/home/ausy/Romain/dest.txt";
	        try {
				Path tmp = Files.copy(Paths.get(src), Paths.get(dest));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
