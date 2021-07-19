package customplugin.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class TestView extends ViewPart {
	public static final String ID = "CustomPlugin.views.TestView";

	public TestView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		Text text = new Text(parent, SWT.BORDER);
		text.setText("Selected file:");
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
