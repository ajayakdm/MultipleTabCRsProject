package com.blackBoard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BBPage
{
	WebDriver driver;

	public BBPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	
	//**************Login Page**************
	
	//Popup
	@FindBy(className ="button-1")
	WebElement popup;
	public void clickOnPopup() 
	{
		popup.click();
	}
	//Username text box
	@FindBy(id="user_id")
	WebElement userName;
	public void enterUserName(String un) 
	{
		userName.sendKeys(un);
	}
	
	//Password text box
	@FindBy(id="password")
	WebElement passWord;
	public void enterPassword(String pw) 
	{
		passWord.sendKeys(pw);
	}
		
	//Login button
	@FindBy(id="entry-login")
	WebElement loginBtn;
	public void clickLoginBtn() 
	{
		loginBtn.click();
	}
		

	//**************Home Page**************
		
	//Course Link
	@FindBy(linkText="CRS Test Multiple Tabs 1")
	WebElement course;
	public void clickOnCourseLink() 
	{
		course.click();
	}
	
	@FindBy(linkText="Content")
	WebElement content;
	public void clickOnContentLink() 
	{
		content.click();
	}
		
	@FindBy(linkText="CogBooks Content Items")
	WebElement CogBooksContentItems;
	public void clickOnCogBooksContentItemsFolder() 
	{
		CogBooksContentItems.click();
	}
	
	//Topic 1 link
	@FindBy(linkText="The Cell")
	WebElement topic1;
	public void clickOnTopic1() 
	{
		topic1.click();
	}
		
	//Topic 2 link
	@FindBy(linkText = "Outer Boundary of the Cell-The Plasma Membrane")
	WebElement topic2;
	public void clickOnTopic2() 
	{
		topic2.click();
	}
	
	//Topic 3 link
	@FindBy(linkText = "Inside the Cell-The Cytoskeleton Systems")
	WebElement topic3;
	public void clickOnTopic3() 
	{
		topic3.click();
	}
	
	//Topic 4 link
	@FindBy(linkText = "The Endomembrane System")
	WebElement topic4;
	public void clickOnTopic4() 
	{
		topic4.click();
	}
	
	@FindBy(id="startIcon")
	WebElement startCourse;
	public void clickOnStartCourse() 
	{
		startCourse.click();
	}
}
