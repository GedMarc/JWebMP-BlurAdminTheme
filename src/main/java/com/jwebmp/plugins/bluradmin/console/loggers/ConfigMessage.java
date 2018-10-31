/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwebmp.plugins.bluradmin.console.loggers;

import com.jwebmp.core.htmlbuilder.css.measurement.MeasurementCSSImpl;
import com.jwebmp.plugins.bootstrap.alerts.BSAlert;
import com.jwebmp.plugins.bootstrap.alerts.BSAlertWarning;
import com.jwebmp.plugins.weblogappender.annotations.WebLogConfigMessage;

import java.util.logging.LogRecord;

/**
 * @author Marc Magon
 * @since 23 Apr 2017
 */
public class ConfigMessage
		extends WebLogConfigMessage
{


	/*
	 * Constructs a new InfoMessage
	 */
	public ConfigMessage()
	{
		//Nothing needed
	}

	@Override
	public void renderMessage(LogRecord record)
	{
		BSAlert alert = new BSAlertWarning();
		alert.getCss()
		     .getMargins()
		     .setMarginRight(new MeasurementCSSImpl(15));
		alert.addAttribute("style", "color:black;");

		alert.setText(record.getMessage());
		if (record.getParameters() != null)
		{
			for (int i = 0; i < record.getParameters().length; i++)
			{
				Object parameter = record.getParameters()[i];
				alert.setText(alert.getText(0)
				                   .toString()
				                   .replace("{" + i + "}", parameter.toString()));
			}
		}
		else
		{
			alert.setText(alert.getText(0)
			                   .toString());
		}

		add(alert);
	}

}
