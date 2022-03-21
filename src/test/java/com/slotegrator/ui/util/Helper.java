package com.slotegrator.ui.util;

import com.slotegrator.ui.data.Player;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static List<Player> setPlayersTableAsList(List<WebElement> table) {
        List<Player> list = new ArrayList<>();
        for (WebElement el : table) {
            Player player = new Player(
                    findChildElementByXpath(el, "./td[2]"),
                    findChildElementByXpath(el, "./td[3]"),
                    findChildElementByXpath(el, "./td[4]"),
                    findChildElementByXpath(el, "./td[5]"),
                    findChildElementByXpath(el, "./td[6]"),
                    findChildElementByXpath(el, "./td[7]"),
                    findChildElementByXpath(el, "./td[8]"),
                    findChildElementByXpath(el, "./td[9]"),
                    findChildElementByXpath(el, "./td[10]"),
                    findChildElementByXpath(el, "./td[11]"),
                    findChildElementByXpath(el, "./td[12]"),
                    findChildElementByXpath(el, "./td[13]").equalsIgnoreCase("Yes"),
                    findChildElementByXpath(el, "./td[14]").equalsIgnoreCase("Yes"),
                    findChildElementByXpath(el, "./td[15]")
            );
            list.add(player);
        }
        return list;
    }

    private static String findChildElementByXpath(WebElement element, String xpath) {
        return element.findElement(By.xpath(xpath)).getText();
    }
}
