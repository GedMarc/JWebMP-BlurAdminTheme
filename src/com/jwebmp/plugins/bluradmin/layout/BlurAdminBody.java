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

import com.jwebmp.base.html.Body;
import com.jwebmp.utilities.regex.RegularExpressionsDTO;
import za.co.mmagon.guiceinjection.GuiceContext;

/**
 * @author Marc Magon
 * @since 07 Jun 2017
 */
public class BlurAdminBody
		extends Body
{

	private static final long serialVersionUID = 1L;

	/*
	 * Constructs a new BlurAdminBody
	 */
	protected BlurAdminBody()
	{
		//Nothing needed
	}

	@Override
	public void init()
	{
		if (!isInitialized())
		{
			GuiceContext.getInstance(BlurAdminLayout.class);
			addDto("regex", new RegularExpressionsDTO().addDefaults());
		}
		super.init();
	}

}
