package data;

import org.testng.annotations.DataProvider;

import util.DriverSetup;

public class SaveTravelTestData extends DriverSetup {

    @DataProvider(name = "dates_data")
    public Object[][] datesData() {
        return new Object[][] {
                {"24 December 2024", "28 December 2024"},
//                {"20 December 2024", "23 December 2024"},
//                {"02 December 2024", "08 December 2024"},
        };
    }
}
