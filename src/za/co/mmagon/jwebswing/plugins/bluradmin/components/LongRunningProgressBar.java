package za.co.mmagon.jwebswing.plugins.bluradmin.components;

import za.co.mmagon.jwebswing.plugins.bootstrap.progressbar.BSProgressBar;
import za.co.mmagon.jwebswing.plugins.bootstrap.progressbar.bar.BSProgressBarDisplay;

/**
 *
 * @author Marc Magon
 * @since 04 Jul 2017
 */
public class LongRunningProgressBar extends BSProgressBar<LongRunningProgressBar>
{

    private static final long serialVersionUID = 1L;

    /*
    * Constructs a new LongRunningProgressBar
     */
    public LongRunningProgressBar()
    {
        super(true, true);
        setID("LongRunningProgressBar");
        setProgressBar(new BSProgressBarDisplay(0, 100, 5, "Running..."));
        setAnimated(true);
        setPercentage(0);
    }
}
