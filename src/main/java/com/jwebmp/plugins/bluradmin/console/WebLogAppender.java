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

import com.jwebmp.core.base.ajax.AjaxComponentInsertType;
import com.jwebmp.core.base.ajax.AjaxComponentUpdates;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.weblogappender.WebLogAppenderPageConfigurator;
import com.jwebmp.plugins.weblogappender.annotations.*;

import java.util.Optional;
import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * @author GedMarc
 * @since 23 Apr 2017
 */
public class WebLogAppender
		extends Handler
{
	private static final String CLASS_CAST_LOG_MESSAGE = "Old Log Entry Found, Removing";

	@Override
	public void publish(LogRecord record)
	{
		if ((record.getLevel()
		           .intValue() <= LogFactory.getDefaultLevel()
		                                    .intValue()))
		{
			return;
		}

		Level levelEnum = record.getLevel();
		processLogRecord(levelEnum, record);
	}

	private void processLogRecord(Level levelEnum, LogRecord record)
	{
		if (WebLogAppenderPageConfigurator.isEnabled())
		{
			Optional<AjaxResponse> autoUpdate;
			switch (levelEnum.getName())
			{
				case "INFO":
				{
					autoUpdate = Optional.ofNullable(renderInfoMessage(record));
					break;
				}
				case "CONFIG":
				{
					autoUpdate = Optional.ofNullable(renderConfigMessage(record));
					break;
				}
				case "WARNING":
				{
					autoUpdate = Optional.ofNullable(renderWarningMessage(record));
					break;
				}
				case "SEVERE":
				{
					autoUpdate = Optional.ofNullable(renderSevereMessage(record));
					break;
				}
				case "FINE":
				{
					autoUpdate = Optional.ofNullable(renderFineMessage(record));
					break;
				}
				case "FINER":
				{
					autoUpdate = Optional.ofNullable(renderFinerMessage(record));
					break;
				}
				case "FINEST":
				{
					autoUpdate = Optional.ofNullable(renderFinestMessage(record));
					break;
				}
				default:
				{
					autoUpdate = Optional.ofNullable(renderInfoMessage(record));
					break;
				}
			}
			if (autoUpdate.isPresent())
			{
				//	GuiceContext.getInstance(AtmosphereResource.class)
				//	            .write(autoUpdate.toString());
			}
		}
	}

	public AjaxResponse renderInfoMessage(LogRecord record)
	{
		try
		{
			Set<Class<? extends WebLogInfoMessage>> items = GuiceContext.reflect()
			                                                            .getSubTypesOf(WebLogInfoMessage.class);
			for (Class<? extends WebLogInfoMessage> item : items)
			{
				return processMessage(item, record);
			}
		}
		catch (ClassCastException cce)
		{
			Logger.getLogger(getClass().getName())
			      .log(Level.SEVERE, CLASS_CAST_LOG_MESSAGE, cce);
		}
		return null;
	}

	public AjaxResponse renderConfigMessage(LogRecord record)
	{
		Set<Class<? extends WebLogConfigMessage>> items = GuiceContext.reflect()
		                                                              .getSubTypesOf(WebLogConfigMessage.class);
		for (Class<? extends WebLogConfigMessage> item : items)
		{
			return processMessage(item, record);
		}
		return null;
	}

	public AjaxResponse renderWarningMessage(LogRecord record)
	{
		Set<Class<? extends WebLogWarningMessage>> items = GuiceContext.reflect()
		                                                               .getSubTypesOf(WebLogWarningMessage.class);
		for (Class<? extends WebLogWarningMessage> item : items)
		{
			return processMessage(item, record);
		}
		return null;
	}

	public AjaxResponse renderSevereMessage(LogRecord record)
	{
		Set<Class<? extends WebLogSevereMessage>> items = GuiceContext.reflect()
		                                                              .getSubTypesOf(WebLogSevereMessage.class);
		for (Class<? extends WebLogSevereMessage> item : items)
		{
			return processMessage(item, record);
		}
		return null;
	}

	public AjaxResponse renderFineMessage(LogRecord record)
	{
		Set<Class<? extends WebLogFineMessage>> items = GuiceContext.reflect()
		                                                            .getSubTypesOf(WebLogFineMessage.class);
		for (Class<? extends WebLogFineMessage> item : items)
		{
			return processMessage(item, record);
		}
		return null;
	}

	public AjaxResponse renderFinerMessage(LogRecord record)
	{
		Set<Class<? extends WebLogFinerMessage>> items = GuiceContext.reflect()
		                                                             .getSubTypesOf(WebLogFinerMessage.class);
		for (Class<? extends WebLogFinerMessage> item : items)
		{
			return processMessage(item, record);
		}
		return null;
	}

	public AjaxResponse renderFinestMessage(LogRecord record)
	{
		Set<Class<? extends WebLogFinestMessage>> items = GuiceContext.reflect()
		                                                              .getSubTypesOf(WebLogFinestMessage.class);
		for (Class<? extends WebLogFinestMessage> item : items)
		{
			return processMessage(item, record);
		}
		return null;
	}

	private AjaxResponse processMessage(Class<? extends WebLogMessage> item, LogRecord record)
	{
		AjaxResponse ar = GuiceContext.getInstance(AjaxResponse.class);
		try
		{
			WebLogMessage infoMessage = item.newInstance();
			infoMessage.renderMessage(record);
			AjaxComponentUpdates comp = ar.addComponent(infoMessage);
			if (WebLogAppenderPageConfigurator.isInsertAtTop())
			{
				comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
				comp.setInsertType(AjaxComponentInsertType.Insert);
			}
			else
			{
				comp.setId(WebLogAppenderPageConfigurator.getWebLogDivDisplayName());
				comp.setInsertType(AjaxComponentInsertType.Insert_Last);
			}
		}
		catch (InstantiationException | IllegalAccessException ex)
		{
			Logger.getLogger(getClass().getName())
			      .log(Level.SEVERE, "asd", ex);
		}
		return ar;
	}

	@Override
	public void flush()
	{
		//Not needed
	}

	@Override
	public void close()
	{
		//Not needed
	}

}
