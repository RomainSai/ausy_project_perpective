package customplugin.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import customplugin.MyPageOne;
import customplugin.MyPageTwo;

public class TestWizard extends Wizard implements INewWizard {
	protected MyPageOne one;
	protected MyPageTwo two;

	public TestWizard() {
		// TODO Auto-generated constructor stub
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
	}

    @Override
    public String getWindowTitle() {
        return "Export My Data";
    }

    @Override
    public void addPages() {
        one = new MyPageOne();
        two = new MyPageTwo();
        addPage(one);
        addPage(two);
    }

    @Override
    public boolean performFinish() {
        // Print the result to the console
        System.out.println(one.getText1());
        System.out.println(two.getText1());

        return true;
    }
	
	

}
