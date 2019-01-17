/*
 * Copyright (C) 2017 GedMarc
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

package com.jwebmp.plugins.bluradmin.console;

import com.jwebmp.plugins.bluradmin.layout.display.DisplayScreen;
import com.jwebmp.plugins.bootstrap.options.BSWidthOptions;
import com.jwebmp.plugins.weblogappender.WebLogAppenderDiv;

/**
 * @author GedMarc
 * @since 23 Apr 2017
 */
public class ConsoleDisplayScreen
		extends DisplayScreen
{


	private final WebLogAppenderDiv webLogger;

	/*
	 * Constructs a new ConsoleDisplayScreen
	 */
	public ConsoleDisplayScreen(String title)
	{
		webLogger = new ConsoleLogger();
		webLogger.addClass("auth-block");
		webLogger.addClass("col-offset-md-3");
		webLogger.addClass(BSWidthOptions.col_md_6);
		webLogger.addClass(BSWidthOptions.col_xs_12);
		webLogger.addAttribute("style", "overflow-y:auto;height:380px;");

		getContentTop().getHeader()
		               .setText(title);
		getContentDiv().add(webLogger);
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + webLogger.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof ConsoleDisplayScreen))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		ConsoleDisplayScreen that = (ConsoleDisplayScreen) o;

		return webLogger.equals(that.webLogger);
	}
}
