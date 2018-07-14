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

package com.jwebmp.plugins.bluradmin.components.dto;

import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;

import java.util.Date;
import java.util.Objects;

/**
 * A default message for display
 *
 * @author Marc Magon
 * @since 19 Jun 2017
 */
public class DefaultMessage
		extends JavaScriptPart
{

	private static final long serialVersionUID = 1L;

	private String id;
	private String image;
	private String name;
	private Date date;
	private String message;

	/*
	 * Constructs a new DefaultMessage
	 */
	public DefaultMessage()
	{
		//Nothing needed
	}

	public String getId()
	{
		return id;
	}

	public DefaultMessage setId(String id)
	{
		this.id = id;
		return this;
	}

	public String getImage()
	{
		return image;
	}

	public DefaultMessage setImage(String image)
	{
		this.image = image;
		return this;
	}

	public String getName()
	{
		return name;
	}

	public DefaultMessage setName(String name)
	{
		this.name = name;
		return this;
	}

	public Date getDate()
	{
		return date;
	}

	public DefaultMessage setDate(Date date)
	{
		this.date = date;
		return this;
	}

	public String getMessage()
	{
		return message;
	}

	public DefaultMessage setMessage(String message)
	{
		this.message = message;
		return this;
	}

	@Override
	public int hashCode()
	{
		int hash = 5;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final DefaultMessage other = (DefaultMessage) obj;
		return (Objects.equals(this.id, other.id));
	}

}
