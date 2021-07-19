package customplugin.wizards;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;

import customplugin.MyPageOne;
import customplugin.MyPageTwo;

public class MyWizard implements IWizard {

    protected MyPageOne one;
    protected MyPageTwo two;

    public MyWizard() {
        super();
        //setNeedsProgressMonitor(true);
    }

    @Override
    public String getWindowTitle() {
        return "Export My Data";
    }

    @Override
    public void addPages() {
        one = new MyPageOne();
        two = new MyPageTwo();
        //addPage(one);
        //addPage(two);
    }

    @Override
    public boolean performFinish() {
        // Print the result to the console
        System.out.println(one.getText1());
        System.out.println(two.getText1());

        return true;
    }

	@Override
	public boolean canFinish() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPageControls(Composite pageContainer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IWizardContainer getContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getDefaultPageImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDialogSettings getDialogSettings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWizardPage getPage(String pageName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IWizardPage[] getPages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWizardPage getStartingPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RGB getTitleBarColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHelpAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean needsPreviousAndNextButtons() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean needsProgressMonitor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean performCancel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setContainer(IWizardContainer wizardContainer) {
		// TODO Auto-generated method stub
		
	}

}
