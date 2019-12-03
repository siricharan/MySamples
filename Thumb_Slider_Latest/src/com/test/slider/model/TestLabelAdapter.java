package com.test.slider.model;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.debug.internal.ui.viewers.provisional.AsynchronousLabelAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import com.test.slider.data.Person;

@SuppressWarnings("restriction")
public class TestLabelAdapter extends AsynchronousLabelAdapter {
	String[] str= new String[4];
	String rowLabel;
	@Override
	protected String[] getLabels(Object element, IPresentationContext context)
			throws CoreException {
		if (context instanceof AsynPresentationContext)
		{
			AsynPresentationContext fcontext = (AsynPresentationContext)context;
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					AsynViewer viewer = (AsynViewer) fcontext.model.getViewer();
					int col=viewer.getTable().getColumnCount();
					for (int i=0; i<col; i++)
						str[i] = getColumnText(element, i);
				}
			});
			
		}
		return str; // new String[0];
	}

	private String getColumnText(Object element, int columnIndex) {
		switch (columnIndex) {
		case 0:
			rowLabel = ((Person) element).getNumber().toString();
			return rowLabel;
		case 1:
			rowLabel = ((Person) element).getFirstName();

			return rowLabel;
		case 2:
			rowLabel = ((Person) element).getLastName();

			return rowLabel;
		case 3:
			rowLabel = ((Person) element).getGender();
			return rowLabel;
		}
		return "";
	}

	@Override
	protected ImageDescriptor[] getImageDescriptors(Object element,
			IPresentationContext context) throws CoreException {
		return null;
	}

	@Override
	protected FontData[] getFontDatas(Object element,
			IPresentationContext context) throws CoreException {
		return null;
	}

	@Override
	protected RGB[] getForegrounds(Object element, IPresentationContext context)
			throws CoreException {
		return null;
	}

	@Override
	protected RGB[] getBackgrounds(Object element, IPresentationContext context)
			throws CoreException {
		return null;
	}
}
