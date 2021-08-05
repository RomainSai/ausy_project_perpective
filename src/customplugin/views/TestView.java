package customplugin.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class TestView extends ViewPart {
	//public static final String ID = "CustomPlugin.views.TestView";

	public TestView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// Simple Text to print on the view called Test View
		Text text = new Text(parent, SWT.READ_ONLY);
		text.setText("Hello from TestView");
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}

}
