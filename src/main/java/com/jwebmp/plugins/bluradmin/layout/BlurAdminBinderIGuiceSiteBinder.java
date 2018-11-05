/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.plugins.bluradmin.layout;

import com.google.inject.servlet.SessionScoped;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.guicedservlets.services.GuiceSiteInjectorModule;
import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.bluradmin.layout.display.ContentTop;
import com.jwebmp.plugins.bluradmin.layout.display.DisplayScreen;
import com.jwebmp.plugins.bluradmin.layout.top.NavToggleButton;

import java.util.logging.Logger;

/**
 * @author Marc Magon
 * @since 07 Jun 2017
 */
public class BlurAdminBinderIGuiceSiteBinder
		implements IGuiceSiteBinder<GuiceSiteInjectorModule>
{
	private static final Logger log = LogFactory.getLog("BlurAdminBinder");

	/*
	 * Constructs a new BlurAdminBinder
	 */
	public BlurAdminBinderIGuiceSiteBinder()
	{
		//Nothing needed
	}

	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		module.bind(BlurAdminHome.class)
		      .asEagerSingleton();
		module.bind(BlurAdminBody.class)
		      .asEagerSingleton();
		module.bind(BlurAdminLayout.class)
		      .asEagerSingleton();
		module.bind(NavToggleButton.class)
		      .asEagerSingleton();

		module.bind(ContentTop.class)
		      .in(SessionScoped.class);
		module.bind(BlurAdminSessionProperties.class)
		      .in(SessionScoped.class);

		module.bind(DisplayScreen.class)
		      .toProvider(() ->
		                  {
			                  BlurAdminSessionProperties props = GuiceContext.getInstance(BlurAdminSessionProperties.class);
			                  if (props.getCurrentScreen() == null)
			                  {
				                  log.severe("Set display screen with GuiceContext.getInstance(BlurAdminSessionProperties.class)");
			                  }
			                  return props.getCurrentScreen();

		                  });
	}

}
