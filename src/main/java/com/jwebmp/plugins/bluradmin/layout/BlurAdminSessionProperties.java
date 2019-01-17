package com.jwebmp.plugins.bluradmin.layout;

import com.google.inject.servlet.SessionScoped;
import com.jwebmp.plugins.bluradmin.layout.display.DisplayScreen;

/**
 * @author GedMarc
 * @since 22 Jun 2017
 */
@SessionScoped
public class BlurAdminSessionProperties
{

	private DisplayScreen currentScreen;

	/*
	 * Constructs a new BlurAdminSessionProperties
	 */
	public BlurAdminSessionProperties()
	{
		//Nothing needed
	}

	public DisplayScreen getCurrentScreen()
	{
		return currentScreen;
	}

	public void setCurrentScreen(DisplayScreen currentScreen)
	{
		this.currentScreen = currentScreen;
	}

}
