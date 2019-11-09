package bpb.keywords;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import bpb.Singleton.SingletonDriver;

public class ActionsExecutor {
	public ActionsExecutor() {

	}

	public static void rightClickElement(WebElement elem) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.contextClick(elem).perform();
	}

	public static void doubleClickElement(WebElement elem) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.doubleClick(elem).perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.dragAndDrop(source, target).perform();
	}

	public static void mouseOver(WebElement elem) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.moveToElement(elem).perform();
	}

	public static void keyDown(Keys key) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.keyDown(key).perform();
	}

	public static void keyUp(Keys key) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.keyUp(key).perform();
	}

	public static void clickAndHoldAndMove(WebElement target, int xOff, int yOff) {
		Actions act = new Actions(SingletonDriver.getInstance().getDriver());
		act.clickAndHold(target).moveByOffset(xOff, yOff).perform();
	}

}
