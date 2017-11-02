package za.co.mmagon.jwebswing.plugins.bluradmin.layout.display;

import com.google.inject.servlet.SessionScoped;
import za.co.mmagon.jwebswing.Event;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.base.html.attributes.LinkAttributes;
import za.co.mmagon.jwebswing.utilities.StaticStrings;

/**
 * @author Marc Magon
 * @since 21 Jun 2017
 */
@SessionScoped
public class ContentTop extends Div
{

	private static final long serialVersionUID = 1L;

	private final H1 header;
	private final List breadCrumblist;

	/*
	 * Constructs a new ContentTop
	 */
	public ContentTop()
	{
		this.header = new H1();
		header.addAttribute("style", "display:inline;");
		this.breadCrumblist = new List(false);

		addClass("content-top clearfix");
		breadCrumblist.addClass("breadcrumb al-breadcrumb");

		add(header);
		add(breadCrumblist);
	}

	public void clearCrumbs()
	{
		breadCrumblist.getChildren().clear();
	}

	public ListItem addCrumb(String crumb)
	{
		return addCrumb(crumb, null);
	}

	public ListItem addCrumb(String crumb, Event event)
	{
		ListItem li = new ListItem();
		if (event != null)
		{
			Link link = new Link<>();
			li.add(link);
			link.setText(crumb);
			link.addEvent(event);
			link.addAttribute(LinkAttributes.HRef, StaticStrings.STRING_HASH);
		}
		else
		{
			li.setText(crumb);
		}
		getBreadCrumblist().add(li);
		return li;
	}

	public List getBreadCrumblist()
	{
		return breadCrumblist;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof ContentTop))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		ContentTop that = (ContentTop) o;

		if (getHeader() != null ? !getHeader().equals(that.getHeader()) : that.getHeader() != null)
		{
			return false;
		}
		return getBreadCrumblist() != null ? getBreadCrumblist().equals(that.getBreadCrumblist()) : that.getBreadCrumblist() == null;
	}

	public H1 getHeader()
	{
		return header;
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (getHeader() != null ? getHeader().hashCode() : 0);
		result = 31 * result + (getBreadCrumblist() != null ? getBreadCrumblist().hashCode() : 0);
		return result;
	}
}
