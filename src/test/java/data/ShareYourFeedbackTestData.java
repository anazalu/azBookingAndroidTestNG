package data;

import org.testng.annotations.DataProvider;

import util.DriverSetup;

public class ShareYourFeedbackTestData extends DriverSetup {

    @DataProvider(name = "feedback_data")
    public Object[][] feedbackData() {
        return new Object[][] {
                {"Data1"}
//                {"Data2"},
//                {"Data3"}
        };
    }
}
