package com.jwebmp.plugins.bluradmin.components;

import com.jwebmp.plugins.bootstrap.progressbar.BSProgressBar;
import com.jwebmp.plugins.bootstrap.progressbar.bar.BSProgressBarDisplay;

/**
 * @author Marc Magon
 * @since 04 Jul 2017
 */
public class LongRunningProgressBar
		extends BSProgressBar<LongRunningProgressBar>
{

	private static final long serialVersionUID = 1L;

	/*
	 * Constructs a new LongRunningProgressBar
	 */
	public LongRunningProgressBar()
	{
		super(true, true);
		setID("LongRunningProgressBar");
		setProgressBar(new BSProgressBarDisplay(0, 100, 5, "Running..."));
		setAnimated(true);
		setPercentage(0);
	}
}
