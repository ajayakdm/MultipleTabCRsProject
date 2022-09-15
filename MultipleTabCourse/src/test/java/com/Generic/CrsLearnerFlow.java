package com.Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrsLearnerFlow 
{

public WebDriver ldriver;
	
	public Actions moveSliderBar;
	public Action action1;
	
	
	public CrsLearnerFlow(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(driver,this );	
	}
	
	@FindBy(xpath="//*[contains(text(),\"Show list view\")]")
	WebElement listViewBtn;
	
	@FindBy(xpath="//*[@class=\"commentIcon cbColobbutton-normal\"]")
	WebElement collToolBtn;
	
	@FindBy(xpath="//div[@onclick=\"courseNav()\"][1]")
	WebElement startCourseButton;
	
	@FindBy(xpath="//div[contains(text(),\"Resume Course\")]")
	WebElement resumeCourseButton;
	
	@FindBy(id="startIcon")
	WebElement startSubModule;
	
	@FindBy(id="sec_rsm_txt")
	WebElement startResumeButton;
	
	@FindBy(xpath="//div[contains(text(),\"Resume\")]")
	private WebElement resumeButton;
	
	@FindBy(xpath="//div[@role=\"slider\"]")
	WebElement slider;
	
	@FindBy(id="1093")
	WebElement courseId;
	
	@FindBy(id="reviewBtn")
	WebElement reviewButton;
	
	@FindBy(id="courseStatus")
	WebElement startResumeModuleBtn;
	
	@FindBy(xpath="//*[contains(text(),\"Drag Me\")]")
	WebElement dragMeButton;
	
	@FindBy(xpath="//*[contains(text(),\"I want to continue without submitting\")]")
	WebElement withoutSubmitLink;
	
	@FindBy(xpath="//*[@id=\"imageCorrectAnsIndx0\"]")
	WebElement ansOption;
	
	@FindBy(id="submitBtnText")
	WebElement submitAnsBtn;
	
	@FindBy(id="nextActivityCont")
	WebElement upNext; 
	
	@FindBy(xpath="//*[@id=\"startTextTop\"]")
	WebElement sliderStartButton; 
	
	@FindBy(xpath="//*[@id=\"startText\"]")
	WebElement answerStartButton;
	
	@FindBy(xpath="//*[@class=\"learningsectid\"]")
	WebElement learningSectionNo;
	
	@FindBy(xpath="//*[@id=\"nextSecText\"]")
	WebElement nextModuleText;    
	
	@FindBy(xpath="//*[@id=\"showTestContentText\"]/span[1]")
	WebElement seeOtherOptionLink; 
	
	@FindBy(id="actCntIframe_child")
	WebElement frameID;
	
	@FindBy(id="draganddrop")
	WebElement dragAndDropInFrame;
	
	@FindBy(id="startIcon")
	WebElement startIcon;
	
	public void clickOnStartIcon() 
	{
		startIcon.click();
	}
	
	public void doDragAndDropInFrame() 
	{
		moveSliderBar=new Actions(ldriver);
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(dragAndDropInFrame));
    	action1=moveSliderBar.dragAndDropBy(dragAndDropInFrame,736,660).build();
    	action1.perform();	   
	}
	public void moveSliderBar() 
	{
		moveSliderBar=new Actions(ldriver);
		WebDriverWait wait = new WebDriverWait(ldriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(slider));
    	action1=moveSliderBar.dragAndDropBy(slider, 350, 0).build();
    	action1.perform();	                                        
	}
	
	public boolean ToVerifyCollTool() 
	{
		boolean tool = collToolBtn.isEnabled();
		return tool;
	}
	
	public void clickOnListViewBtn() 
	{
		listViewBtn.click();
	}
	
	public void clickOnStartCourseButton() 
	{
		startCourseButton.click();
	}
	
	public void clickOnResumeCourseBtn() 
	{
		resumeCourseButton.click();
	}
	
	public void clickToStartOrResumeSubModule()
	{
     	startResumeModuleBtn.click();	
	}
	
	public void clickToStarOrResumeActivity() 
	{
		startResumeModuleBtn.click();
	}
	
	public void clickToNewActivity() 
	{
		startSubModule.click();
	}
	
	public void clickOnStartCourse() 
	{
		if(startCourseButton.getText().equals("Start")) 
		{
			startCourseButton.click();
			
			if(startResumeButton.getText().equals("Start")) 
			{
				startResumeButton.click();
				clickOnStart();
			}
			else if(startResumeButton.getText().equals("Resume"))
			{
				startResumeButton.click();
			}
			
		}
		else 
		{
			resumeCourseButton.click();
		}
	}	
	public void clickOnStart() 
	{
		if(startResumeButton.getText().equals("Start")) 
		{
			startResumeButton.click();
		}
		else 
		{
			resumeButton.click();
		}
	}
	
	public void clickOnCourseTitle() 
	{
		courseId.click();
	}
	
	public void clickOnStartButtonOfSlider() 
	{
		WebDriverWait wait = new WebDriverWait(ldriver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(sliderStartButton));
		sliderStartButton.click();
	}
	
	public void clickOnAnswerStartButton() 
	{
	    WebDriverWait wait = new WebDriverWait(ldriver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(answerStartButton));
		answerStartButton.click();
	}
	
	public void clickOnReview() 
	{
		reviewButton.click();
	}
	
	public void clickOnwithoutSubmit() 
	{
		withoutSubmitLink.click();
	}
	
	public void switchToFrame() 
	{
		WebDriverWait wait = new WebDriverWait(ldriver,5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameID));
	//	driver.switchTo().frame("actCntIframe_child");
	}
	public void selectAnswer() 
	{   
		WebDriverWait wait = new WebDriverWait(ldriver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(ansOption));
		ansOption.click();
	}
	public void clickOnSubmitBtn()
	{
		submitAnsBtn.click();
	}
	public void switchBackToWindow() 
	{
		ldriver.switchTo().defaultContent();
	}
	
	public String getTextLearningSection() 
	{
	    String number=learningSectionNo.getText();	
	    return number;
	}
	
	public String getNextModuleText() 
	{
		String sectionId=nextModuleText.getText();
		//double sectionId=Double.parseDouble(j); 
		return sectionId;
	}
	
	public void clickOnUpNext() 
	{
		upNext.click();
	}
	
	public void clickOnSeeOtherOptionLink() 
	{
		seeOtherOptionLink.click();
	}
	
}
