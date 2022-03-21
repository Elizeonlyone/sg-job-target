package com.slotegrator.ui.steps;

import com.slotegrator.ui.data.Player;
import com.slotegrator.ui.data.PlayerColumn;
import com.slotegrator.ui.pages.PlayerManagementPage;
import com.slotegrator.ui.util.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerManagementSteps extends PlayerManagementPage {

    private List<Player> playersList;

    @And("Set shown players as list")
    public void setPlayersAsList() {
        playersList = Helper.setPlayersTableAsList(allPlayersRows);
    }

    @And("Sort players table by {word} and verify sorting successful")
    public void sortTableByColumn(String columnName) {
        PlayerColumn playerColumn = PlayerColumn.valueOf(columnName.toUpperCase());

        getColumnElement(playerColumn.getIndex()).click();
        waitUntilTableIsRefreshed();
        List<Player> actualList = Helper.setPlayersTableAsList(allPlayersRows);

        Assertions.assertEquals(actualList, sortPlayersListByColumn(actualList, playerColumn));
    }

    @Then("Verification Player management page has been loaded")
    public void verificationPageHasLoaded() {
        softAssert.assertThat(mainContent.isDisplayed()).isTrue();

        softAssert.assertAll();
    }

    private void waitUntilTableIsRefreshed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.not
                            (ExpectedConditions.attributeContains(mainContent, "class", "grid-view-loading")));
        } catch (StaleElementReferenceException e) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.not
                            (ExpectedConditions.attributeContains(mainContent, "class", "grid-view-loading")));
        }
    }

    private List<Player> sortPlayersListByColumn(List<Player> actualList, PlayerColumn column) {
        List<Player> expectedList = new ArrayList<>();
        switch (column) {
            case USERNAME:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::getUsername)).collect(Collectors.toList());
                break;
            case EXTERNAL_ID:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::getExternalId)).collect(Collectors.toList());
                break;
            case NAME:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::getName)).collect(Collectors.toList());
                break;
            case LAST_NAME:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::getLastName)).collect(Collectors.toList());
                break;
            case EMAIL:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::getEmail)).collect(Collectors.toList());
                break;
            case PHONE:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::getPhone)).collect(Collectors.toList());
                break;
            case HALL:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::getHall)).collect(Collectors.toList());
                break;
            case REG_DATE:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::getRegDate)).collect(Collectors.toList());
                break;
            case LAST_VISIT:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::getLastVisit)).collect(Collectors.toList());
                break;
            case VERIFIED_PLAYER:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::isVerified)).collect(Collectors.toList());
                break;
            case STATUS:
                expectedList =
                        actualList.stream().sorted(Comparator.comparing(Player::getStatus)).collect(Collectors.toList());
                break;
        }
        return expectedList;
    }
}
