package data;

import org.testng.annotations.DataProvider;

import util.DriverSetup;

public class SaveTravelTestData extends DriverSetup {

    @DataProvider(name = "dates_data")
    public Object[][] datesData() {
        return new Object[][] {
                {"Tue, Dec 24 - Sat, Dec 28"}
//                {"Fri, Dec 20 - Mon, Dec 23"},
//                {"Mon, Dec 2 - Sun, Dec 8"}
        };
    }
}
