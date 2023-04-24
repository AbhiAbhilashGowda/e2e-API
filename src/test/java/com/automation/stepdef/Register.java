package com.automation.stepdef;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import com.automation.base.Base;
import com.automation.framework.Elements;
import com.automation.pages.RegisterPage;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.automation.util.*;

public class Register extends Base {

	RegisterPage scenA = new RegisterPage();
	Faker fkobj = new Faker();
	static String Storedmail = " ";
	GetEMailUsingJavaMailFromMail7 rapi = new GetEMailUsingJavaMailFromMail7();

	@Given("^I launch application$")
	public void i_launch_the_application() throws InterruptedException {

		Base.driver.get(Base.reader.getUrl());
		Thread.sleep(2000);
		System.out.println("Launch the application");
	}

	@Then("I click on Register")
	public void i_click_on_register() throws Throwable {

		Thread.sleep(2000);
		Elements.click(RegisterPage.clickonRegister);
		Thread.sleep(3000);
	}

	@Then("^I enter first name$")
	public void i_enter_first_name() throws Throwable {
		Elements.click(RegisterPage.enterFirstName);

		String firstName = fkobj.name().firstName();
		System.err.println(firstName);
		Elements.TypeText(RegisterPage.enterFirstName, firstName);

		Thread.sleep(2000);

	}

	@Then("^I enter last name$")
	public void i_enter_last_name() throws Throwable {
		Elements.click(RegisterPage.enterLastName);
		String lastName = fkobj.name().lastName();
		System.err.println(lastName);
		Elements.TypeText(RegisterPage.enterLastName, lastName);
		Thread.sleep(2000);

	}

	@Then("^I enter New emailid$")
	public void i_enter_new_emailid() throws Throwable {
		Thread.sleep(200);
		Elements.click(RegisterPage.enterRandomEmail);
		Thread.sleep(1000);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		WebElement upload = Base.driver.findElement(By.xpath("//input[@placeholder='Email ID']"));
		String cred = "username" + randomInt + "@mail7.io";
		upload.sendKeys(cred);
		Storedmail = cred;
		System.out.println(Storedmail);
	}

	@Then("^I enter New password \"([^\"]*)\"$")
	public void i_enter_new_password_something(String pass) throws Throwable {
		Thread.sleep(2000);
		Elements.TypeText(RegisterPage.enterNewPassword, pass);
		Thread.sleep(2000);

	}

	@Then("^I click on Register button$")
	public void i_click_on_register_button() throws Throwable {
		Thread.sleep(2000);
		Elements.click(RegisterPage.clickRegisterforRegisteration);
	}

	@Then("^I fetch otp using API$")
	public void i_fetch_otp_using_api() throws Throwable {
		Thread.sleep(2000);
		GetEMailUsingJavaMailFromMail7 rapi = new GetEMailUsingJavaMailFromMail7();
		String result = rapi.getOTPfromMail(Storedmail);
		System.err.println(result);
		System.out.println(result);
		Thread.sleep(2000);
		Elements.TypeText(RegisterPage.passotp, result);
		Thread.sleep(2000);

	}

	@Then("^I click on verify otp$")
	public void i_click_on_verify_otp() throws Throwable {
		Thread.sleep(2000);
		Elements.click(RegisterPage.verifyOtp);

	}

	@Then("^I enter registered emailid$")
	public void i_enter_registered_emailid() throws Throwable {
		Thread.sleep(2000);
		Elements.click(RegisterPage.enterRandomEmail);
		Thread.sleep(2000);
		System.err.println("stored mail registedemail fun>>>>" + Storedmail);
		Elements.TypeText(RegisterPage.enterRandomEmail, Storedmail);
		Thread.sleep(1000);

	}

	@Then("^I enter registered password \"([^\"]*)\"$")
	public void i_enter_registered_password_something(String pass) throws Throwable {
		Thread.sleep(200);
		Elements.TypeText(RegisterPage.enterNewPassword, pass);
		Thread.sleep(200);
		Elements.click(RegisterPage.clickReLogin);
		Thread.sleep(4000);

	}

	@Then("^I click on me$")
	public void i_click_on_me() throws Throwable {
		Thread.sleep(2000);
		Elements.click(RegisterPage.clickonMe);
		Thread.sleep(2000);
	}

	@Then("I click on settings and privacy")
	public void i_click_on_settings_and_privacy() throws Throwable {
		Thread.sleep(2000);
		Elements.click(RegisterPage.clickonSettingAndPrivacy);

	}

	@Then("^I click on delete account permentaly$")
	public void i_click_on_delete_account_permentaly() throws Throwable {
		Thread.sleep(1000);
		Elements.click(RegisterPage.clickOnDeleteAccount);

	}

	@Then("^I click on confirm delete$")
	public void i_click_on_confirm_delete() throws Throwable {
		Thread.sleep(2000);
		Elements.click(RegisterPage.clickonReDelete);
		Thread.sleep(2000);

	}

	@Then("^I enter otp from API$")
	public void i_enter_otp_from_api() throws Throwable {
//		GetEMailUsingJavaMailFromMail7 rapi = new GetEMailUsingJavaMailFromMail7();
		String result = rapi.getOTPfromMail(Storedmail);
		System.out.println(result);
		System.err.println(result);
		Thread.sleep(1000);

		Elements.TypeText(RegisterPage.passotp, result);
		Thread.sleep(2000);

	}

	@Then("^I click on delete account$")
	public void i_click_on_delete_account() throws Throwable {
		Elements.click(RegisterPage.clickonDelete);
		Thread.sleep(5000);

	}

}