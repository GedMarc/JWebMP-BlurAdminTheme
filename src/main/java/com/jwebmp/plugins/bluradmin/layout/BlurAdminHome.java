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

import com.jwebmp.core.Page;
import com.jwebmp.core.annotations.PageConfiguration;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.generics.WebReference;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.plugins.bluradmin.layout.display.DisplayScreen;
import com.jwebmp.plugins.bluradmin.layout.footer.Footer;
import com.jwebmp.plugins.bluradmin.layout.sidebar.SideBar;
import com.jwebmp.plugins.bluradmin.layout.top.PageTop;

/**
 * The default page for blur Admin theme
 *
 * @author Marc Magon
 * @since 07 Jun 2017
 */
@PageConfiguration(url = "/blur")
public class BlurAdminHome
		extends Page
{


	/*
	 * Constructs a new BlurAdminHome
	 */
	protected BlurAdminHome()
	{
		//Literally just to build
		setBody(new BlurAdminBody());
		WebReference.setUseMinAtEndOfExtension(true);
	}

	@Override
	public AjaxResponse onConnect(AjaxCall call, AjaxResponse response)
	{
		response.addComponent(GuiceContext.getInstance(SideBar.class));
		response.addComponent(GuiceContext.getInstance(Footer.class));
		response.addComponent(GuiceContext.getInstance(PageTop.class));
		response.addComponent(GuiceContext.getInstance(DisplayScreen.class));

		return super.onConnect(call, response);
	}

	@Override
	public void init()
	{
		if (!isInitialized())
		{
			setBody(GuiceContext.getInstance(BlurAdminBody.class));
		}
		super.init();
	}
}
