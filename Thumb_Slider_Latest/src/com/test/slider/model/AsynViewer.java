package com.test.slider.model;

import org.eclipse.debug.internal.ui.viewers.AsynchronousModel;
import org.eclipse.debug.internal.ui.viewers.AsynchronousTableViewer;
import org.eclipse.swt.widgets.Composite;


@SuppressWarnings("restriction")
public class AsynViewer extends AsynchronousTableViewer {

	public AsynViewer(Composite parent) {
		super(parent);
		
	}
	
	public AsynViewer(Composite parent, int style) {
		super(parent, style);
	}
	
	protected AsynchronousModel createModel() {
		return new AsynContentTableModel(this, getPresentationContext());
	}
	
}
