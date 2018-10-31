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

package com.jwebmp.plugins.bluradmin.components;

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.plugins.bluradmin.components.dto.DefaultMessage;
import com.jwebmp.plugins.bootstrap.dropdown.BSDropDown;
import com.jwebmp.plugins.bootstrap.dropdown.menu.BSDropDownMenuChildren;
import com.jwebmp.plugins.moment.Moment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marc Magon
 * @since 19 Jun 2017
 */
public class MessageCenterDropDown
		extends BSDropDown<MessageCenterDropDown>
{


	private ShowAllLink showAllLink;
	private Link settingsLink;
	private Link markAllReadLink;
	private Link markAllUnReadLink;

	private String header;

	private List<DefaultMessage> messages;

	private int messagesToShow = 6;

	/*
	 * Constructs a new MessageCenterDropDown
	 */
	public MessageCenterDropDown()
	{
		//No configuration needed
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof MessageCenterDropDown))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		MessageCenterDropDown that = (MessageCenterDropDown) o;

		if (getMessagesToShow() != that.getMessagesToShow())
		{
			return false;
		}
		if (!showAllLink.equals(that.showAllLink))
		{
			return false;
		}
		if (!settingsLink.equals(that.settingsLink))
		{
			return false;
		}
		if (!markAllReadLink.equals(that.markAllReadLink))
		{
			return false;
		}
		if (!markAllUnReadLink.equals(that.markAllUnReadLink))
		{
			return false;
		}
		if (getHeader() != null ? !getHeader().equals(that.getHeader()) : that.getHeader() != null)
		{
			return false;
		}
		return getMessages().equals(that.getMessages());
	}

	public int getMessagesToShow()
	{
		return messagesToShow;
	}

	public void setMessagesToShow(int messagesToShow)
	{
		this.messagesToShow = messagesToShow;
	}

	public String getHeader()
	{
		return header;
	}

	public void setHeader(String header)
	{
		this.header = header;
	}

	public List<DefaultMessage> getMessages()
	{
		if (messages == null)
		{
			messages = new ArrayList<>();
		}
		return messages;
	}

	public void setMessages(List<DefaultMessage> messages)
	{
		this.messages = messages;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void preConfigure()
	{

		getChildren().clear();
		Header headerDiv = new Header();
		if (getHeader() != null)
		{
			headerDiv.add(new Strong(getHeader()));
		}

		getDropdownMenu().add(new DropDownArrow());

		headerDiv.add(markAllReadLink);
		headerDiv.add(markAllUnReadLink);
		headerDiv.add(settingsLink);

		getDropdownMenu().add(headerDiv);

		MessagesList messageList = new MessagesList();
		messageList.addClass("msg-list");

		for (DefaultMessage message : getMessages())
		{
			messageList.add(buildMessage(message));
		}
		getDropdownMenu().add(messageList);
		if (showAllLink != null)
		{
			getDropdownMenu().add(showAllLink);
		}

		super.preConfigure();
	}

	@SuppressWarnings("unchecked")
	private Link buildMessage(DefaultMessage message)
	{
		Link link = new Link();
		link.addClass("clearfix");

		if (message.getImage() != null)
		{
			Div imageArea = new Div<>().addClass("img-area");
			Image image = new Image<>(message.getImage()).addClass("photo-msg-item");
			link.add(imageArea);
			imageArea.add(image);
		}

		Div messageArea = new Div<>();
		messageArea.addClass("msg-area");
		Div messageDescription = new Div<>().setText(message.getMessage());
		Moment messageTime = new Moment(message.getDate());
		messageTime.setTag("span");

		link.add(messageArea);
		messageArea.add(messageDescription);
		messageArea.add(messageTime);

		return link;
	}

	public Link getShowAllLink(String text)
	{
		if (showAllLink == null)
		{
			showAllLink = new ShowAllLink(StaticStrings.STRING_HASH, null, text);
		}
		return showAllLink;
	}

	public Link getSettingsLink(String text)
	{
		if (settingsLink == null)
		{
			settingsLink = new Link(StaticStrings.STRING_HASH, null, text);
		}
		return settingsLink;
	}

	public Link getMarkAllReadLink(String text)
	{
		if (markAllReadLink == null)
		{
			markAllReadLink = new Link(StaticStrings.STRING_HASH, null, text);
		}
		return markAllReadLink;
	}

	public Link getMarkAllUnReadLink(String text)
	{
		if (markAllUnReadLink == null)
		{
			markAllUnReadLink = new Link(StaticStrings.STRING_HASH, null, text);
		}
		return markAllUnReadLink;
	}

	class Header
			extends Div
			implements BSDropDownMenuChildren
	{


		public Header()
		{
			addClass("header clearfix");
		}
	}

	class MessagesList
			extends Div
			implements BSDropDownMenuChildren
	{


		public MessagesList()
		{
			addClass("msg-list");
		}
	}

	public class ShowAllLink
			extends Link
			implements BSDropDownMenuChildren
	{


		public ShowAllLink()
		{
		}

		public ShowAllLink(String directToAddress)
		{
			super(directToAddress);
		}

		public ShowAllLink(String directToAddress, String targetFrameName)
		{
			super(directToAddress, targetFrameName);
		}

		public ShowAllLink(String directToAddress, String targetFrameName, String text)
		{
			super(directToAddress, targetFrameName, text);
		}

		public ShowAllLink(String directToAddress, String targetFrameName, ComponentHierarchyBase component)
		{
			super(directToAddress, targetFrameName, component);
		}

	}

	class DropDownArrow
			extends Italic
			implements BSDropDownMenuChildren
	{


		public DropDownArrow()
		{
			addClass("dropdown-arr");
		}

	}
}
