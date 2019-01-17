package com.jwebmp.plugins.bluradmin;

import com.google.inject.Singleton;
import com.google.inject.servlet.SessionScoped;
import com.jwebmp.guicedinjection.abstractions.GuiceInjectorModule;
import com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder;
import com.jwebmp.plugins.bluradmin.components.LongRunningProgressBar;
import com.jwebmp.plugins.bluradmin.console.WebLogAppender;

/**
 * @author GedMarc
 * @since 02 Jul 2017
 */
public class BlurAdminBinder
		implements IGuiceDefaultBinder<BlurAdminBinder, GuiceInjectorModule>
{

	/*
	 * Constructs a new BlurAdminBinder
	 */
	public BlurAdminBinder()
	{
		//Nothing needed
	}

	@Override
	public void onBind(GuiceInjectorModule module)
	{
		module.bind(WebLogAppender.class)
		      .in(Singleton.class);
		module.bind(LongRunningProgressBar.class)
		      .in(SessionScoped.class);
	}
}
