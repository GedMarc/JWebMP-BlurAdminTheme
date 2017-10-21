package za.co.mmagon.jwebswing.plugins.bluradmin.layout.display;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * @author Marc Magon
 * @since 08 Apr 2017
 */
public class DisplayScreen extends Div
{

	private static final long serialVersionUID = 1L;

	private final ContentTop contentTop;
	private final Div contentDiv;

	/*
	 * Constructs a new DisplayScreen
	 */
	public DisplayScreen()
	{
		addAttribute("style", "width:100%;height:100%;");
		setID("DisplayScreen");
		addClass("al-content");
		addAttribute("style", "overflow-y:auto;");

		contentTop = new ContentTop();

		contentDiv = new Div();
		contentDiv.addClass("auth-main");
		contentDiv.addAttribute("autoscroll", "true");
		contentDiv.addAttribute("autoscroll-body-top", null);

		add(contentTop);
		add(contentDiv);
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof DisplayScreen))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		DisplayScreen that = (DisplayScreen) o;

		if (getContentTop() != null ? !getContentTop().equals(that.getContentTop()) : that.getContentTop() != null)
		{
			return false;
		}
		return getContentDiv() != null ? getContentDiv().equals(that.getContentDiv()) : that.getContentDiv() == null;
	}

	public ContentTop getContentTop()
	{
		return contentTop;
	}

	public Div getContentDiv()
	{
		return contentDiv;
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (getContentTop() != null ? getContentTop().hashCode() : 0);
		result = 31 * result + (getContentDiv() != null ? getContentDiv().hashCode() : 0);
		return result;
	}
}
