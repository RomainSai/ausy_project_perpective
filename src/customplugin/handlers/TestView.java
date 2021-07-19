package customplugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * Creates an custom View and opens it.
 *
 */
public class TestView extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		System.out.println("in TestView excute");
		try {
			//command to open a view with this id in parameter
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("CustomPlugin.views.TestView");
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
