package com.test.slider.model;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.debug.internal.ui.viewers.provisional.AsynchronousContentAdapter;

import com.test.slider.data.ModelProvider;
import com.test.slider.data.Person;



@SuppressWarnings("restriction")
public class AsynContentAdapter extends AsynchronousContentAdapter{ //implements IAdaptable{
	
	@Override
	protected Object[] getChildren(Object parent, IPresentationContext context)
			throws CoreException {
		List<Person> list = ModelProvider.INSTANCE.getPersons(parent);
		return list.toArray();
	}
	
	@Override
	protected boolean hasChildren(Object element, IPresentationContext context)
			throws CoreException {
		return false;
	}

	@Override
	protected boolean supportsPartId(String id) {
		return true;
	}
	
	@Override
	protected boolean supportsContext(IPresentationContext context) {
			return true;
	    }

}
