package com.lazaretov.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class AddressComponent {

    public AddressComponent setAddress(String address, String state, String city) {
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        return this;
    }
}
