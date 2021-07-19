package customplugin;

import java.io.File;
import javax.swing.JFileChooser;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class MyPageOne extends WizardPage {
	private Text textName;
	private Text textFile;
	private Text textFolder;
	private Composite container;
	private static final String[] ITEMS = { "AngularJs", "Java", "Vue.js", "Autre" };
	
	public MyPageOne() {
		super("First Page");
		setTitle("First Page");
		setDescription("Fake Wizard: First page");
	}

	@Override
	public void createControl(Composite parent) {
		// create global container with 3 columns
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		container.setLayout(layout);
		
		// FIRST ENTRY : SIMPLE TEXT ENTRY
		Label label1 = new Label(container, SWT.FILL);
		label1.setText("Put a value here :");
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan = 2;
		textName = new Text(container, SWT.BORDER | SWT.FILL);
		textName.setLayoutData(gridData);
		textName.setText("");
		textName.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (!textName.getText().isEmpty()) {	
					setPageComplete(true);
				}
			}
		});
		// END FIRST ENTRY : SIMPLE TEXT ENTRY

		// SECOND ENTRY : BUTTON TO CHOOSE A FILE OR A FOLDER & TEXT AREA
		Label labelSelectFile = new Label(container, SWT.NONE);
		labelSelectFile.setText("Select a file :");
		GridData gridData2 = new GridData(SWT.FILL, SWT.FILL, true, false);
		textFile = new Text(container, SWT.READ_ONLY | SWT.BORDER | SWT.SINGLE);
		textFile.setLayoutData(gridData2);
		Button buttonSelectFile = new Button(container, SWT.WRAP);
		buttonSelectFile.setText("Browse...");
		buttonSelectFile.addListener(SWT.Selection, new Listener() {
			// Action to the button -> opening a window to select a file
			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				fileChooser.showOpenDialog(fileChooser);
				File selectedFile = fileChooser.getSelectedFile();
				if (selectedFile != null) {
					setTextPath(selectedFile, textFile);
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
			}
		});	
		// END SECOND ENTRY : BUTTON TO CHOOSE A FILE OR A FOLDER

		// THIRD ENTRY : SCROLLING MENU WITH LANGAGE
		Label labelSelectLangage = new Label(container, SWT.NONE);
		labelSelectLangage.setText("Select Langage :");
		Combo combo = new Combo(container, SWT.READ_ONLY | SWT.SINGLE | SWT.DROP_DOWN);
		GridData gridDataLangage = new GridData(SWT.FILL);
		gridDataLangage.horizontalSpan = 2;
		combo.setItems(ITEMS);
		combo.setLayoutData(gridDataLangage);
		combo.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				String val = combo.getText();
				System.out.println("VALEUR COMBO : " + val);
			}
		});
		// END THIRD ENTRY : SCROLLING MENU WITH LANGAGE
		
		//FOURTH ENTRY : SELECT A FOLDER
		Label labelSelectFolder = new Label(container, SWT.NONE);
		labelSelectFolder.setText("Select a folder :");
		GridData gridData4 = new GridData(SWT.FILL, SWT.FILL, true, false);
		textFolder = new Text(container, SWT.READ_ONLY | SWT.BORDER | SWT.SINGLE);
		textFolder.setLayoutData(gridData4);
		Button buttonSelectFolder = new Button(container, SWT.WRAP);
		buttonSelectFolder.setText("Browse...");
		buttonSelectFolder.addListener(SWT.Selection, new Listener() {
			// Action to the button -> opening a window to select a folder
			@Override
			public void handleEvent(Event event) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new java.io.File("."));
				fileChooser.setDialogTitle("test select folder");
			    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.showOpenDialog(fileChooser);
				File selectedFolder = fileChooser.getSelectedFile();
				if (selectedFolder != null) {
					setTextPath(selectedFolder, textFolder);
					System.out.println("Selected Folder: " + selectedFolder.getAbsolutePath());
				}
			}
		});	
		// END FOURTH ENTRY : SELECT A FOLDER
		
		// required to avoid an error in the system
		setControl(container);
		setPageComplete(false);
	}

	public String getText1() {
		return textName.getText();
	}
	
	private void setTextPath(File selectedFile, Text text) {
		text.setText(selectedFile.getAbsolutePath());
	}
}