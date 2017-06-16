package za.co.mmagon.jwebswing.plugins.bluradmin.layout.top;

import com.armineasy.injection.GuiceContext;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.base.html.*;
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

    private Div userProfileDiv = new Div();

    /*
     * Constructs a new PageTop
     */
    @Inject
    protected PageTop()
    {
        setID("PageTop");
        addClass("page-top clearfix");
        addAttribute("style", "position: static;");

        //add(buildBranding());
        //add(buildToggleButton());
        userProfileDiv.addClass("user-profile clearfix");
        //userProfileDiv.add(addProfileButtonBar());
        userProfileDiv.add(buildMessageCenter());
        add(userProfileDiv);
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {

        }
        super.init();
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

    public Link addToggleButton()
    {
        Link llkk = GuiceContext.getInstance(NavToggleButton.class);
        add(llkk);
        return llkk;
    }

    public Div addSearch()
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

        add(div);
        return div;

    }

    public Div addProfileButtonBar(String profileImage)
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

        for (BSDropDownMenuChildren buildDropDownItem : buildDropDownItems())
        {
            dropdownList.add(buildDropDownItem);
        }

        Image profileImageImg = new Image(profileImage);
        profileToggleLink.add(profileImageImg);

        add(profileDropdown);
        return profileDropdown;

    }

    private Div buildMessageCenter()
    {
        Div messageCenter = new Div();
        messageCenter.setTag("msg-center");
        //messageCenter.add(GuiceContext.inject().getInstance(PageTopMessageCenter.class));

        return messageCenter;
    }

    private ArrayList<BSDropDownMenuChildren> buildDropDownItems()
    {
        ArrayList<BSDropDownMenuChildren> arr = new ArrayList<>();

        BSDropDownMenuItem li1 = new BSDropDownMenuItem("dropdown-arr", "");
        arr.add(li1);

        BSDropDownMenuItem li2Link = new BSDropDownMenuItem("fa fa-user", "Profile");
        arr.add(li2Link);

        BSDropDownMenuItem li3Link = new BSDropDownMenuItem("fa fa-cog", "Settings");
        arr.add(li3Link);

        BSDropDownMenuItem li4Link = new BSDropDownMenuItem("fa fa-power-off", "Sign Out");
        li4Link.addClass("signout");
        arr.add(li4Link);

        return arr;
    }

}
