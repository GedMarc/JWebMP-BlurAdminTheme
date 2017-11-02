package za.co.mmagon.jwebswing.plugins.bluradmin.screens.login;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.display.DisplayScreen;
import za.co.mmagon.jwebswing.plugins.bootstrap.buttons.BSButton;
import za.co.mmagon.jwebswing.plugins.bootstrap.componentoptions.BSComponentWidthOptions;
import za.co.mmagon.jwebswing.plugins.bootstrap.forms.BSForm;
import za.co.mmagon.jwebswing.plugins.bootstrap.forms.controls.BSFormEmailInput;
import za.co.mmagon.jwebswing.plugins.bootstrap.forms.controls.BSFormPasswordInput;
import za.co.mmagon.jwebswing.plugins.bootstrap.forms.controls.BSFormTextInput;
import za.co.mmagon.jwebswing.plugins.bootstrap.forms.groups.BSFormGroup;
import za.co.mmagon.jwebswing.utilities.StaticStrings;

/**
 *
 * @author Marc Magon
 * @since 24 Jun 2017
 */
public class BlurAdminLoginScreen extends DisplayScreen
{

    private static final long serialVersionUID = 1L;

    /*
     * Constructs a new BlurAdminLoginScreen
     */
    public BlurAdminLoginScreen()
    {
        //Nothing needed
    }

    protected Div buildSurroundingDiv()
    {
        Div block = new Div();
        block.addClass("auth-block");
        block.addClass("col-offset-md-3");
        block.addClass(BSComponentWidthOptions.col_md_6);
        block.addClass(BSComponentWidthOptions.col_xs_12);

        return block;
    }

    protected Div buildLoginBlock()
    {
        Div div = new Div();
        div.addClass("auth-main");
        div.setTag("main");

        Div block = new Div();
        block.addClass("auth-block");
        div.add(block);
	
	    Link newToApp = new Link();

        newToApp.setText("New to the app? Register Today!");
        newToApp.addAttribute("href", StaticStrings.STRING_HASH);
        newToApp.addClass("auth-link");

        BSForm form = new BSForm();
        form.addClass("form-horizontal");

        form.add(buildEmailInput());
        form.add(buildPasswordInput());
        form.add(buildButtonBar());

        block.add(form);
        block.add(buildSeparator());

        return div;
    }

    protected BSButton buildDefaultButton()
    {
        BSButton registerButton = new BSButton("");
        registerButton.addClass("btn-default btn-auth");
        return registerButton;
    }
	
	protected BSFormGroup<?> buildEmailInput()
	{
        BSFormEmailInput emailLogin = new BSFormEmailInput();
        emailLogin.setPlaceholder("Email Input");
        emailLogin.setRequired();
		emailLogin.addClass(BSComponentWidthOptions.col_xs_12);
		BSFormGroup loginGroup = new BSFormGroup(null, emailLogin, null);
        loginGroup.setAngularValidation(true);
        return loginGroup;
    }
	
	protected BSFormGroup<?> buildPasswordInput()
	{
        BSFormPasswordInput passwordInput = new BSFormPasswordInput();
        passwordInput.setMinimumLength(4);
        passwordInput.setRequired();
        passwordInput.setPlaceholder("Password");
		passwordInput.addClass(BSComponentWidthOptions.col_xs_12);
		BSFormGroup passwordGroup = new BSFormGroup(null, passwordInput, null);
        passwordGroup.setAngularValidation(true);
        return passwordGroup;
    }

    protected BSFormGroup buildButtonBar()
    {
        BSFormGroup buttonGroup = new BSFormGroup();
        buttonGroup.addAttribute("style", "margin-top:5px;");
        buttonGroup.addClass(BSComponentWidthOptions.col_xs_12);
        return buttonGroup;
    }

    protected Link niceText(String text)
    {
        Link newToApp = new Link();
        newToApp.setText(text);
        newToApp.addClass("auth-link");
        newToApp.addClass(BSComponentWidthOptions.col_xs_12);
        return newToApp;
    }

    protected Link softText(String text)
    {
        Link newToApp = new Link();
        newToApp.setText(text);
        newToApp.addClass("auth-link text-muted");
        newToApp.addClass(BSComponentWidthOptions.col_xs_12);
        return newToApp;
    }
	
	protected BSFormGroup<?> buildTextInput()
	{
        BSFormTextInput textInput = new BSFormTextInput();
        textInput.setRequired();
		textInput.addClass(BSComponentWidthOptions.col_xs_12);
		BSFormGroup<? extends BSFormGroup> enterpriseName = new BSFormGroup(null, textInput, null);
		enterpriseName.setAngularValidation(true);
        return enterpriseName;
    }

    public Div buildSeparator()
    {
	    return new Div();
    }
}
