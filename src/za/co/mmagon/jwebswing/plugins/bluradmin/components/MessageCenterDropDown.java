package za.co.mmagon.jwebswing.plugins.bluradmin.components;

import java.util.*;
import java.util.List;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.plugins.bluradmin.components.dto.DefaultMessage;
import za.co.mmagon.jwebswing.plugins.bootstrap.dropdown.BSDropDown;
import za.co.mmagon.jwebswing.plugins.bootstrap.dropdown.menu.BSDropDownMenuChildren;
import za.co.mmagon.jwebswing.plugins.moment.Moment;

/**
 *
 * @author Marc Magon
 * @since 19 Jun 2017
 */
public class MessageCenterDropDown extends BSDropDown<MessageCenterDropDown>
{

    private static final long serialVersionUID = 1L;

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

    }

    @Override
    public void preConfigure()
    {
        // if (!isConfigured())
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
            //messageList.addAttribute("style", "overflow-y:auto;height:280px;");

            DefaultMessage dm = new DefaultMessage();
            dm.setDate(new Date());
            dm.setMessage("A test Message");
            dm.setName("Test User");
            dm.setImage("images/default/profile_default.png");
            getMessages().add(dm);
            getMessages().add(dm);
            getMessages().add(dm);
            getMessages().add(dm);
            getMessages().add(dm);
            getMessages().add(dm);
            getMessages().add(dm);
            getMessages().add(dm);
            getMessages().add(dm);
            getMessages().add(dm);

            for (DefaultMessage message : getMessages())
            {
                messageList.add(buildMessage(message));
            }
            getDropdownMenu().add(messageList);
            if (showAllLink != null)
            {
                getDropdownMenu().add(showAllLink);
            }
        }
        super.preConfigure();
    }

    public String getHeader()
    {
        return header;
    }

    public void setHeader(String header)
    {
        this.header = header;
    }

    public Link getShowAllLink(String text)
    {
        if (showAllLink == null)
        {
            showAllLink = new ShowAllLink("#", null, text);
        }
        return showAllLink;
    }

    public Link getSettingsLink(String text)
    {
        if (settingsLink == null)
        {
            settingsLink = new Link("#", null, text);
        }
        return settingsLink;
    }

    public Link getMarkAllReadLink(String text)
    {
        if (markAllReadLink == null)
        {
            markAllReadLink = new Link("#", null, text);
        }
        return markAllReadLink;
    }

    public Link getMarkAllUnReadLink(String text)
    {
        if (markAllUnReadLink == null)
        {
            markAllUnReadLink = new Link("", null, text);
        }
        return markAllUnReadLink;
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

    public int getMessagesToShow()
    {
        return messagesToShow;
    }

    public void setMessagesToShow(int messagesToShow)
    {
        this.messagesToShow = messagesToShow;
    }

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

    class Header extends Div implements BSDropDownMenuChildren
    {

        private static final long serialVersionUID = 1L;

        public Header()
        {
            addClass("header clearfix");
        }
    }

    class MessagesList extends Div implements BSDropDownMenuChildren
    {

        private static final long serialVersionUID = 1L;

        public MessagesList()
        {
            addClass("msg-list");
        }
    }

    public class ShowAllLink extends Link implements BSDropDownMenuChildren
    {

        private static final long serialVersionUID = 1L;

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

    class DropDownArrow extends Italic implements BSDropDownMenuChildren
    {

        private static final long serialVersionUID = 1L;

        public DropDownArrow()
        {
            addClass("dropdown-arr");
        }

    }
}
