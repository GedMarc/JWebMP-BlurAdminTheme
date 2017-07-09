package za.co.mmagon.jwebswing.plugins.bluradmin.layout.top;

import com.armineasy.injection.GuiceContext;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.google.inject.servlet.RequestParameters;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.generics.Pair;
import za.co.mmagon.jwebswing.plugins.bluradmin.components.MessageCenterDropDown;
import za.co.mmagon.jwebswing.plugins.bootstrap.dropdown.BSDropDown;
import za.co.mmagon.jwebswing.plugins.bootstrap.dropdown.BSDropDownLink;
import za.co.mmagon.jwebswing.plugins.bootstrap.dropdown.menu.*;

/**
 *
 * @author Marc Magon
 * @since 06 Apr 2017
 */
public class PageTop extends Div
{

    private static final Logger log = Logger.getLogger(PageTop.class.getName());

    private static final long serialVersionUID = 1L;

    private Div rightSideDiv = new Div();

    @Inject
    @RequestParameters
    private java.util.Map<String, String[]> params;

    /*
     * Constructs a new PageTop
     */
    @Inject
    protected PageTop(@RequestParameters java.util.Map<String, String[]> params)
    {
        setID("PageTop");
        addClass("page-top clearfix");
        addAttribute("style", "position: static;");
        rightSideDiv.addClass("user-profile clearfix");

        //Calling all sidebar builders
        Set<Class<? extends BlurAdminPageTop>> sideBarInjections = GuiceContext.reflect().getSubTypesOf(BlurAdminPageTop.class);
        if (sideBarInjections.isEmpty())
        {
            log.severe("Sidebar will be empty, there are no classes that extend BlurAdminSideBar");;
        }
        else
        {
            java.util.List<BlurAdminPageTop> blurs = new ArrayList<>();
            for (Class<? extends BlurAdminPageTop> sideBarInjection : sideBarInjections)
            {
                blurs.add(GuiceContext.getInstance(sideBarInjection));
            }

            java.util.Map<String, String[]> queryParameters = params;
            java.util.Map<String, String> localStorage = GuiceContext.inject().getInstance(Key.get(java.util.Map.class, Names.named("LocalStorage")));
            java.util.Map<String, String> sessionStorage = GuiceContext.inject().getInstance(Key.get(java.util.Map.class, Names.named("SessionStorage")));

            for (BlurAdminPageTop blur : blurs)
            {
                blur.buildPageTop(this, queryParameters, localStorage, sessionStorage);
            }
        }
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            add(rightSideDiv);
        }
        super.init();
    }

    /**
     * Returns the portion displayed on the right hand side
     *
     * @return
     */
    public Div getRightSideDiv()
    {
        return rightSideDiv;
    }

    /**
     * Sets the portion displayed on the right hand side
     *
     * @param rightSideDiv
     */
    public void setRightSideDiv(Div rightSideDiv)
    {
        this.rightSideDiv = rightSideDiv;
        if (this.rightSideDiv != null)
        {
            rightSideDiv.addClass("user-profile clearfix");
        }
    }

    public Link addBranding(String highlightedText, String hoverHighlightText, String icon)
    {
        Link homeLink = new Link("#");

        homeLink.addClass("al-logo clearfix");
        homeLink.addClass("hidden-xs");

        Span highlightedSpan = new Span(highlightedText);

        homeLink.add(highlightedSpan);
        homeLink.setText(hoverHighlightText);
        homeLink.setRenderTextBeforeChildren(false);

        add(homeLink);

        return homeLink;
    }

    public Link addToggleButton(boolean leftSide)
    {
        Link link = GuiceContext.getInstance(NavToggleButton.class);
        if (leftSide)
        {
            add(link);
        }
        else
        {
            getRightSideDiv().add(link);
        }
        return link;
    }

    public Div addSearch(boolean leftSide)
    {
        Div div = new Div();
        div.addClass("search");

        Italic i = new Italic();
        i.addClass("fa fa-search fa-2x");
        InputSearchType ist = new InputSearchType();
        ist.setID("searchInput");
        ist.setPlaceholder("Search for...");

        div.add(i);
        div.add(ist);

        if (leftSide)
        {
            add(div);
        }
        else
        {
            getRightSideDiv().add(div);
        }

        return div;
    }

    public BSDropDown buildProfileButtonBar(String profileImage)
    {
        BSDropDown profileDropdown = new BSDropDown();
        profileDropdown.addClass("al-user-profile clearfix");

        BSDropDownLink profileToggleLink = new BSDropDownLink();
        profileToggleLink.addClass("profile-toggle-link");
        profileDropdown.setDropdownButton(profileToggleLink);

        BSDropDownMenu dropdownList = new BSDropDownMenu();
        dropdownList.addClass("top-dropdown-menu");
        dropdownList.addClass("profile-dropdown");
        profileDropdown.setMenu(dropdownList);

        Image profileImageImg = new Image(profileImage);
        profileToggleLink.add(profileImageImg);

        dropdownList.add(new DropDownArrow());

        return profileDropdown;
    }

    /**
     *
     * @param leftSide
     *
     * @return Message center div parent and the list for child items
     */
    public Pair<Div, List> addMessageCenter(boolean leftSide)
    {
        Pair<Div, List> output = new Pair<>();

        Div messageCenter = new Div();
        messageCenter.setTag("msg-center");

        if (leftSide)
        {
            add(messageCenter);
        }
        else
        {
            getRightSideDiv().add(messageCenter);
        }

        List messageList = new List();
        messageList.addClass("al-msg-center clearfix");

        messageCenter.add(messageList);

        output.setLeft(messageCenter);
        output.setRight(messageList);

        return output;
    }

    public BSDropDownMenuItem buildDropDownItem(String icon, String name)
    {
        BSDropDownMenuItem item = new BSDropDownMenuItem(icon, name);

        return item;
    }

    public BSDropDownMenuItem buildDropDownArrow()
    {
        BSDropDownMenuItem item = new BSDropDownMenuItem("dropdown-arr", "");
        return item;
    }

    public BSDropDownMenuItem buildDropDownDivider()
    {
        BSDropDownMenuItem item = new BSDropDownMenuItemDivider();
        return item;
    }

    public BSDropDownMenuItemHeader buildDropDownMenuHeader(String icon, String name)
    {
        BSDropDownMenuItemHeader item = new BSDropDownMenuItemHeader(icon, name);
        return item;
    }

    /**
     *
     * @param icon             the full component text for the icon (e.g. includes i tag)
     * @param alertNoticeCount The number of new notices to alert about
     *
     * @return The list item created and the div for the content
     */
    public MessageCenterDropDown buildMessageCenterDropDown(ComponentHierarchyBase icon, int alertNoticeCount)
    {
        MessageCenterDropDown dropDown = new MessageCenterDropDown();
        dropDown.setTag("li");

        BSDropDownLink dropdownLink = new BSDropDownLink();
        dropdownLink.add(icon);

        dropDown.setDropdownButton(dropdownLink);

        if (alertNoticeCount > 0)
        {
            Span alertNotice = new Span<>(alertNoticeCount + "");
            dropdownLink.add(alertNotice);
            Div notificationRing = new Div<>().addClass("notification-ring");
            dropdownLink.add(notificationRing);
        }

        BSDropDownMenu menu = new BSDropDownMenu();
        menu.addClass("top-dropdown-menu");
        dropDown.setMenu(menu);

        return dropDown;
    }

    class DropDownArrow extends Italic implements BSDropDownMenuChildren
    {

        private static final long serialVersionUID = 1L;

        public DropDownArrow()
        {
            addClass("dropdown-arr");
        }
    }
}
