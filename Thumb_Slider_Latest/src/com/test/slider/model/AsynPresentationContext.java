package com.test.slider.model;

import org.eclipse.debug.internal.ui.viewers.model.provisional.PresentationContext;

@SuppressWarnings("restriction")
public class AsynPresentationContext extends PresentationContext {
	public AsynContentTableModel model;

	public AsynPresentationContext(String id, AsynContentTableModel model) {
		super(id);
		this.model= model;

	}

}

