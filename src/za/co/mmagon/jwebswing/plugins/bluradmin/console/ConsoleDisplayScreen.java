package za.co.mmagon.jwebswing.plugins.bluradmin.console;

import za.co.mmagon.jwebswing.plugins.bluradmin.layout.display.DisplayScreen;
import za.co.mmagon.jwebswing.plugins.bootstrap.options.BSWidthOptions;
import za.co.mmagon.plugins.weblogappender.WebLogAppenderDiv;

/**
 *
 * @author Marc Magon
 * @since 23 Apr 2017
 */
public class ConsoleDisplayScreen extends DisplayScreen
{

    private static final long serialVersionUID = 1L;

	private final WebLogAppenderDiv webLogger;

    /*
     * Constructs a new ConsoleDisplayScreen
     */
    public ConsoleDisplayScreen(String title)
    {
        webLogger = new ConsoleLogger();
        webLogger.addClass("auth-block");
        webLogger.addClass("col-offset-md-3");
	    webLogger.addClass(BSWidthOptions.col_md_6);
	    webLogger.addClass(BSWidthOptions.col_xs_12);
        webLogger.addAttribute("style", "overflow-y:auto;height:380px;");

        getContentTop().getHeader().setText(title);
        getContentDiv().add(webLogger);
    }

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof ConsoleDisplayScreen))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		ConsoleDisplayScreen that = (ConsoleDisplayScreen) o;

		return webLogger.equals(that.webLogger);
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + webLogger.hashCode();
		return result;
	}
}
