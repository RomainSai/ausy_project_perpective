package customplugin.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import customplugin.wizards.TestWizard;

public class ButtonView extends ViewPart {
	public static final String ID = "CustomPlugin.views.ButtonView";

	public ButtonView() {
	}
	
	@Override
	public void createPartControl(Composite parent) {
		
			//Print something on the new window ButtonView
			Text text = new Text(parent, SWT.BORDER);
			text.setText("Hello From ButtonView");
									
			//Button to open new Wizard Pages 
			Button button = new Button(parent, SWT.PUSH);
			button.setText("Migration");
			button.addSelectionListener(new SelectionAdapter() {
			    @Override
			    public void widgetSelected(SelectionEvent e) {
			        WizardDialog wizardDialog = new WizardDialog(parent.getShell(), new TestWizard());

			        if (wizardDialog.open() == Window.OK ) {
			            System.out.println("Ok pressed");
			        } else {
			            System.out.println("Cancel pressed");
			        }
			    }
			});
	}
	
	/**
	 * Function to write a selected file in a new directory 
	 */
	private void writeFile(File selectedFile) {
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Save As");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          String src = selectedFile.getAbsolutePath();
          String dest = chooser.getSelectedFile().toString();
          InputStream is = null;
          OutputStream os = null;
          	try {
				is = new FileInputStream(src);
				os = new FileOutputStream(dest);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = is.read(buffer)) > 0) {
				    os.write(buffer, 0, len);
				}
              is.close();
              os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
          System.out.println("No Selection ");
        }
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
