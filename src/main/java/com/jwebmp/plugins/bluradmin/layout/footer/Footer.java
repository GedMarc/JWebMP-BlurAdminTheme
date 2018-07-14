package com.jwebmp.plugins.bluradmin.layout.footer;

import com.jwebmp.base.html.*;

import javax.validation.constraints.NotNull;

/**
 * @author Marc Magon
 * @since 05 Apr 2017
 */
public class Footer
		extends Div
{

	private static final long serialVersionUID = 1L;
	/**
	 * The main footer div
	 */
	private Div footerMainDiv;
	/**
	 * The share list
	 */
	private List shareList;

	/*
	 * Constructs a new Footer
	 */
	public Footer()
	{
		setID("PageFooter");
		setTag("footer");
		addClass("al-footer clearfix");
	}

	/**
	 * Adds a default footer to the right
	 *
	 * @param text
	 * @param iconClassName
	 *
	 * @return
	 */
	public Div addFooterRight(String text, String iconClassName)
	{
		Div div = new Div();
		div.addClass("al-footer-right");
		div.setText(text + " <i class=\"" + iconClassName + "\"></i>");
		return div;
	}

	/**
	 * adds a list formatted as share
	 *
	 * @return
	 */
	@NotNull
	public List addShareList()
	{
		if (footerMainDiv == null)
		{
			addFooterMain("");
		}
		shareList = new List(false);
		shareList.addClass("al-share clearfix");
		footerMainDiv.add(shareList);
		return shareList;
	}

	/**
	 * Returns the new div
	 *
	 * @param copyrightText
	 *
	 * @return
	 */
	@NotNull
	public Div addFooterMain(String copyrightText)
	{
		footerMainDiv = new Div();
		footerMainDiv.addClass("al-footer-main clearfix");
		Div copyright = new Div();
		copyright.addClass("al-copy");
		copyright.setText(copyrightText);
		footerMainDiv.add(copyright);
		return footerMainDiv;
	}

	/**
	 * Adds a share item
	 *
	 * @param iconClass
	 * @param url
	 *
	 * @return
	 */
	@NotNull
	public ListItem addShareItem(String iconClass, String url)
	{
		ListItem li = new ListItem();
		Link link = new Link(url, "_blank");
		li.add(link);

		Italic i = new Italic();
		i.addClass(iconClass);
		link.add(i);

		shareList.add(li);
		return li;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof Footer))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		Footer footer = (Footer) o;

		if (footerMainDiv != null ? !footerMainDiv.equals(footer.footerMainDiv) : footer.footerMainDiv != null)
		{
			return false;
		}
		return shareList != null ? shareList.equals(footer.shareList) : footer.shareList == null;
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (footerMainDiv != null ? footerMainDiv.hashCode() : 0);
		result = 31 * result + (shareList != null ? shareList.hashCode() : 0);
		return result;
	}
}
