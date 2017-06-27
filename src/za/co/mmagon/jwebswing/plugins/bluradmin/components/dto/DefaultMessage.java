package za.co.mmagon.jwebswing.plugins.bluradmin.components.dto;

import java.util.Date;
import java.util.Objects;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * A default message for display
 *
 * @author Marc Magon
 * @since 19 Jun 2017
 */
public class DefaultMessage extends JavaScriptPart
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

    public void setId(String id)
    {
        this.id = id;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
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
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        return true;
    }

}