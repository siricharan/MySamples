package com.test.slider.model;

import org.eclipse.debug.internal.ui.viewers.AsynchronousModel;
import org.eclipse.debug.internal.ui.viewers.AsynchronousViewer;
import org.eclipse.debug.internal.ui.viewers.ModelNode;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.debug.internal.ui.viewers.provisional.AsynchronousContentAdapter;
import org.eclipse.debug.internal.ui.viewers.provisional.IAsynchronousContentAdapter;
import org.eclipse.debug.internal.ui.viewers.provisional.IAsynchronousLabelAdapter;

@SuppressWarnings("restriction")
public class AsynContentTableModel extends AsynchronousModel {
	private AsynchronousViewer fViewer;
	IPresentationContext fcontext;
	public static AsynchronousContentAdapter adapter;
	
	public AsynContentTableModel(AsynchronousViewer viewer) {
		super(viewer);
		fViewer = viewer;
	}
	public AsynContentTableModel(AsynchronousViewer viewer,IPresentationContext context) {
		super(viewer);
		fViewer = viewer;
		fcontext=context;
	}
	
	protected IAsynchronousLabelAdapter getLabelAdapter(Object element) {
		return new TestLabelAdapter();
	}
	
	protected IAsynchronousContentAdapter getContentAdapter(Object element) {  
			adapter = new AsynContentAdapter();
		// System.out.println("adapter "+adapter);
	       return adapter;
	       
	    }

	public AsynchronousViewer getViewer() {
			return fViewer;
		}
	@Override
	protected void add(ModelNode parent, Object element) {
		
	}
}
