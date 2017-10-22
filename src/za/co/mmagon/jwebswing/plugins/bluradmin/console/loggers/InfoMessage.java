/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mmagon.jwebswing.plugins.bluradmin.console.loggers;

import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;
import za.co.mmagon.jwebswing.plugins.bootstrap.alerts.BSAlert;
import za.co.mmagon.jwebswing.plugins.bootstrap.alerts.BSAlertSuccess;
import za.co.mmagon.plugins.weblogappender.annotations.WebLogInfoMessage;

import java.util.logging.LogRecord;

/**
 * @author Marc Magon
 * @since 23 Apr 2017
 */
@SuppressWarnings("unused")
public class InfoMessage extends WebLogInfoMessage
{

	private static final long serialVersionUID = 1L;

	/*
	* Constructs a new InfoMessage
	 */
	public InfoMessage()
	{
		//Nothing needed
	}

	@Override
	public void renderMessage(LogRecord record)
	{
		BSAlert alert = new BSAlertSuccess();
		alert.getCss().getMargins().setMarginRight(new MeasurementCSSImpl(15));
		alert.addAttribute("style", "color:black;");
		alert.setText(record.getMessage());
		if (record.getParameters() != null)
		{
			for (int i = 0; i < record.getParameters().length; i++)
			{
				Object parameter = record.getParameters()[i];
				alert.setText(alert.getText(0).toString().replace("{" + i + "}", parameter.toString()));
			}
		}

		add(alert);
	}

}
