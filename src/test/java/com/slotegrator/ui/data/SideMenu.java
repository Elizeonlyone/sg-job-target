package com.slotegrator.ui.data;

public enum SideMenu {
    DASHBOARD("Dashboard", "//ul[@class='main-side-menu']/li[1]/a"),
    AGENT_INFO("Agent Info", "//a[@data-target='#s-menu-halls']"),
    SETTINGS("Settings", "//a[@data-target='#s-menu-main']"),
    GAMES("Games", "//a[@data-target='#s-menu-games']"),
    MONEY("Money", "//a[@data-target='#s-menu-money']"),
    CONTENT("Content", "//a[@data-target='#s-menu-content']"),
    SEO("SEO", "//a[@data-target='#s-menu-seo']"),
    USERS("Users", "//a[@data-target='#s-menu-users']"),
    BONUSES("Bonuses", "//a[@data-target='#s-menu-operator-bonus']"),
    JACKPOTS("Jackpots", "//a[@data-target='#module-jackpots']"),
    MESSAGING("Messaging", "//a[@data-target='#module-messaging']"),
    FAQ("FAQ", "//a[@data-target='#module-faq']"),
    SHOP("Shop", "//a[@data-target='#module-shop']"),
    LOGS("Logs", "//a[@data-target='#s-menu-logs']"),
    REPORTS("Reports", "//a[@data-target='#s-menu-reports']");

    SideMenu(String value, String xpath){
        this.value = value;
        this.xpath = xpath;
    }

    private String value;
    private String xpath;

    public String getValue() {
        return value;
    }

    public String getXpath() {
        return xpath;
    }

    public static SideMenu fromString(String value) {
        for (SideMenu item : SideMenu.values()) {
            if (item.value.equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }
}
