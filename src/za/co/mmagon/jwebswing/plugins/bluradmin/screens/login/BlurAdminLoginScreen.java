package za.co.mmagon.jwebswing.plugins.bluradmin.screens.login;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.plugins.bluradmin.layout.display.DisplayScreen;
import za.co.mmagon.jwebswing.plugins.bootstrap.buttons.BSButton;
import za.co.mmagon.jwebswing.plugins.bootstrap.componentoptions.BSComponentWidthOptions;
import za.co.mmagon.jwebswing.plugins.bootstrap.forms.BSForm;
import za.co.mmagon.jwebswing.plugins.bootstrap.forms.controls.*;
import za.co.mmagon.jwebswing.plugins.bootstrap.forms.groups.BSFormGroup;

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

        //block.add(new H1("Sign in to CPI"));
        Link newToApp = new Link();

        newToApp.setText("New to the app? Register Today!");
        newToApp.addAttribute("href", "#");
        newToApp.addClass("auth-link");
        //block.add(newToApp);

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

    protected BSFormGroup<BSFormEmailInput, ? extends BSFormGroup> buildEmailInput()
    {
        BSFormEmailInput emailLogin = new BSFormEmailInput();
        emailLogin.setPlaceholder("Email Input");
        emailLogin.setRequired();
        emailLogin.addClass("col-xs-12");
        BSFormGroup loginGroup = new BSFormGroup(null, emailLogin, null);
        loginGroup.setAngularValidation(true);
        return loginGroup;
    }

    protected BSFormGroup<BSFormPasswordInput, ? extends BSFormGroup> buildPasswordInput()
    {
        BSFormPasswordInput passwordInput = new BSFormPasswordInput();
        passwordInput.setMinimumLength(4);
        passwordInput.setRequired();
        passwordInput.setPlaceholder("Password");
        passwordInput.addClass("col-xs-12");
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

    protected BSFormGroup<BSFormTextInput, ? extends BSFormGroup> buildTextInput()
    {
        BSFormTextInput textInput = new BSFormTextInput();
        textInput.setRequired();
        textInput.addClass("col-xs-12");
        BSFormGroup<BSFormTextInput, ? extends BSFormGroup> enterpriseName = new BSFormGroup(null, textInput, null);
        enterpriseName.setAngularValidation(true);
        return enterpriseName;
    }

    public Div buildSeparator()
    {
        Div div = new Div();
        // div.addClass("auth-sep");
        // Span span1;
        //div.add(span1 = new Span());
        // span1.add(new Span("Sign In with One Click"));

        return div;
    }
}
