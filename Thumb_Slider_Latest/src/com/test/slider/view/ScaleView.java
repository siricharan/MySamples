package com.test.slider.view;

import org.eclipse.debug.internal.ui.viewers.AsynchronousTableViewer;
import org.eclipse.debug.internal.ui.viewers.model.provisional.IPresentationContext;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import com.test.slider.data.DataInfo;
import com.test.slider.data.DataProvider;
import com.test.slider.data.Person;
import com.test.slider.model.AsynContentTableModel;
import com.test.slider.model.AsynPresentationContext;
import com.test.slider.model.AsynViewer;

@SuppressWarnings("restriction")
public class ScaleView extends ViewPart implements IPropertyChangeListener {

	String CONTEXT_ID = "com.nest.asynView";

	private AsynchronousTableViewer viewer = null;
	private AsynContentTableModel tableModel;
	private DataInfo dataInfo = null;
	private static final int data_Size = 200;
	private static final int THRESHOLD = 20;
	private Table table;
	// private Scale scale;
	private Slider slider;
	private DataInfo data1;
	private int dataPercent;

	@Override
	public void createPartControl(Composite parent) {
		createViewer(parent);
	}

	/**
	 * This will create the columns for the table
	 */
	private void createColumns(AsynchronousTableViewer viewer) {
		String[] titles = null;
		int[] bounds = null;

		titles = new String[] { "Sl. no", "Name", "lastName", "gender" };
		bounds = new int[] { 80, 80, 80, 80 };
		if (null != titles && null != bounds) {
			for (int i = 0; i < titles.length; i++) {
				TableColumn column = new TableColumn(viewer.getTable(),
						SWT.BOLD);
				column.setText(titles[i]);
				column.setWidth(bounds[i]);
				column.setResizable(true);
				column.setMoveable(true);
			}
			Table table = viewer.getTable();
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
		}
	}

	private void createViewer(Composite parent) {
		// Composite container = new Composite(parent, SWT.LEFT_TO_RIGHT);
		GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);

		viewer = new AsynViewer(parent, SWT.MULTI | SWT.NO_SCROLL | SWT.FILL
				| SWT.FULL_SELECTION | SWT.VIRTUAL);
		tableModel = new AsynContentTableModel(viewer);
		viewer.setContext(createPresentationContext(parent));
		createColumns(viewer);
		// layout
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		viewer.getTable().setLayoutData(data);

		// create slider for viewer
		createScale(parent);
		data = new GridData(SWT.RIGHT_TO_LEFT, SWT.FILL, true, true);
		// data.widthHint = 500;
		slider.setLayoutData(data);

		dataInfo = new DataInfo(0, data_Size, true);
		table = viewer.getTable();
		setViewerInput(dataInfo);

		// Handle events for mouse
		viewer.getTable().addListener(SWT.MouseWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				table = viewer.getTable();
				int top = table.getTopIndex();
				int visibleRows = (table.getSize().y / table.getItemHeight()) - 1;
				if (event.count > 0) {// up
					table.setTopIndex(table.getTopIndex() - event.count);
					top = table.getTopIndex();
					if (top <= THRESHOLD) {
						int rowId = getRowID(top);
						if (rowId + visibleRows - data_Size > 0) {
							dataInfo = new DataInfo(rowId + visibleRows
									- data_Size, rowId + visibleRows);
							setViewerInput(dataInfo);
							table.setTopIndex(data_Size - visibleRows
									- THRESHOLD);
							table.setSelection(data_Size - visibleRows
									- THRESHOLD);
							// setScrollPosition();
						} else {
							goToHome();
						}
					}
					setSliderPosition();
				} else {// down
					table.setTopIndex(table.getTopIndex() - event.count);
					top = table.getTopIndex();
					if (top + visibleRows >= data_Size - THRESHOLD) {
						int rowId = getRowID(top);
						dataInfo = new DataInfo(rowId + visibleRows, rowId
								+ visibleRows + data_Size);
						setViewerInput(dataInfo);
						table.setTopIndex(THRESHOLD);
						table.setSelection(THRESHOLD);
						// setScrollPosition();
					}
					setSliderPosition();

				}
			}
		});
		viewer.getTable().addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				Table table = viewer.getTable();

				int visibleRows = computeVisibleCount();
				int top = table.getTopIndex();
				int firstID = getRowID(top) - top;
				int lastID = firstID + data_Size;
				// int lastID = getRowID(lastVisibleCount+remainingCount-2);
				setSliderPosition();

				switch (e.keyCode) {
				case SWT.DRAG:
					System.out.println("Dragged...");
				case SWT.ARROW_UP:
					if (top <= THRESHOLD) {
						firstID = firstID - data_Size;
						if (firstID >= 0) {
							dataInfo = new DataInfo(firstID, firstID
									+ data_Size);
							setViewerInput(dataInfo);
							table.setTopIndex(data_Size - visibleRows
									- THRESHOLD);
							table.setSelection(data_Size - visibleRows
									- THRESHOLD);
						} else {
							goToHome();
						}
					}
					setSliderPosition();
					break;
				case SWT.PAGE_UP:
					// System.out.println("Page up ...");
					if (top - visibleRows <= THRESHOLD) {
						firstID = firstID - data_Size;
						if (firstID >= 1) {
							dataInfo = new DataInfo(firstID, firstID
									+ data_Size);
							setViewerInput(dataInfo);
							table.setTopIndex(data_Size - visibleRows
									- THRESHOLD);
							table.setSelection(data_Size - visibleRows
									- THRESHOLD);
						} else {
							goToHome();
						}
					}
					setSliderPosition();
					break;
				case SWT.ARROW_DOWN:
				case SWT.PAGE_DOWN:
					// System.out.println("Page down ...");
					if (data_Size - (top + visibleRows) <= THRESHOLD) {// when
																		// reaches
																		// to
																		// end
																		// of
																		// the
																		// table
																		// items
						dataInfo = new DataInfo(lastID, lastID + data_Size);
						setViewerInput(dataInfo);
						table.setTopIndex(visibleRows);
						table.setSelection(visibleRows);
					}
					/*
					  if (top + visibleRows + data_Size >= 200) {
					  table.setTopIndex(itemCount - data_Size - visibleRows -THRESHOLD); 
					  table.setSelection(itemCount - data_Size);
					   } else { 
					  table.setTopIndex(itemCount - visibleRows - THRESHOLD + 1); 
					  table.setSelection(itemCount + THRESHOLD + 1);
					   }
					 */
					setSliderPosition();
					break;
				case SWT.HOME:
					// System.out.println("Home ...");
					goToHome();
					break;

				case SWT.END:
					// System.out.println("End ...");
					dataInfo = new DataInfo(DataProvider.totalRecords,
							DataProvider.totalRecords + data_Size);
					setViewerInput(dataInfo);
					table.setSelection(visibleRows);
					setSliderPosition();
					break;
				default:
					setSliderPosition();
					break;
				}
			}
		});
	}
	
	private void createScale(final Composite parent) {
		slider = new Slider(parent, SWT.VERTICAL | SWT.BORDER_DASH);
		// scale = new Slider(parent, SWT.VERTICAL|SWT.NO_REDRAW_RESIZE);
		initializeSlider();
		addListeners();
	}

	private void initializeSlider() {
		if (null != slider) {
			slider.setMinimum(0);
			slider.setMaximum(100);
			slider.setIncrement(1);
			slider.setToolTipText("Scale");
			slider.setThumb(1);
			slider.setSize(25, 50);
		}
	}

	private void addListeners() {
		if (null != slider) {
			// Listener for control size change
			slider.addControlListener(new ControlAdapter() {
				@Override
				public void controlResized(ControlEvent e) {
					System.out.println("parent.getBounds().width >> "
							+ slider.getBounds().width);
					if (slider.getBounds().width < 34
							|| slider.getBounds().width > 36) {
						Rectangle bounds = slider.getBounds();
						bounds.width = 35;
						slider.setBounds(bounds);
					}
				}
			});

			// Listener for mouse up(release)
			slider.addListener(SWT.MouseUp, new Listener() {
				public void handleEvent(Event event) {
					// System.out.println("mouse released");
					setSliderPosition();
				}
			});

			// Handle events for mouse
			slider.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					int value = slider.getMaximum() - slider.getSelection()
							+ slider.getMinimum();
					System.out.println("Speed: " + value + " \t selection : "
							+ slider.getSelection());
					int rowPosition = DataProvider.totalRecords
							* slider.getSelection() / 100;
					if (slider.getSelection() == 0) {
						dataInfo = new DataInfo(0, data_Size);
						setViewerInput(dataInfo);
						table.setTopIndex(0);
						table.setSelection(0);
						setSliderPosition();
					} else {
						System.out.println("Row position " + rowPosition);
						// if(rowPosition-data_Size >= data_Size){
						dataInfo = new DataInfo(rowPosition, rowPosition
								+ data_Size);
						setViewerInput(dataInfo);
						table.setTopIndex(THRESHOLD);
						table.setSelection(THRESHOLD);
						setSliderPosition();

						/*
						 * }else{ goToHome(); }
						 */
					}
				}
			});
		}
	}

	private void setViewerInput(DataInfo data) {
		data1 = data;
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				viewer.setInput(data1);
			}
		});
	}
	
	public IPresentationContext createPresentationContext(Composite parent) {
		return new AsynPresentationContext(CONTEXT_ID, tableModel);
	}

	private int computeVisibleCount() {
		table = viewer.getTable();
		Rectangle rect = table.getClientArea();
		int itemHeight = table.getItemHeight();
		int headerHeight = table.getHeaderHeight();
		int visibleCount = (rect.height - headerHeight + itemHeight - 1)
				/ itemHeight;
		return visibleCount;
	}

	private void setSliderPosition() {
		int top = viewer.getTable().getTopIndex();
		float start = getRowID(top);
		float total = DataProvider.totalRecords;
		System.out.println("% Top " + top + " totalRecords "
				+ DataProvider.totalRecords);
		dataPercent = (int) (100 * (start / total));
		System.out.println("% of data " + dataPercent);
		slider.setSelection(dataPercent);
	}


	private int getRowID(final int index) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				try {
				//	showMessage("index",index);
					Person person = (Person) viewer.getTable().getItem(index)
							.getData();
					rowID = person.getNumber();
				} catch (Exception e) {
					System.out.println("Exception occured at index "+index);
				}
			}
		});
		return rowID;
	}

	private void goToHome() {
		dataInfo = new DataInfo(0, data_Size);
		setViewerInput(dataInfo);
		viewer.getTable().setSelection(0);
		slider.setSelection(0);
	}
	

	@Override
	public void dispose() {
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
		// tableviewer.getControl().setFocus();
	}
	

	@Override
	public void propertyChange(PropertyChangeEvent event) {

	}
	
	int rowID;
}
