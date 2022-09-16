package ComputerSectionTest;

import baseTestNew.Baseclass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddItemsOfComputer extends Baseclass
{
    @Test

    public void verifyComputerItems() throws InterruptedException, IOException
    {
        pageFactoryNew.getAddComputerItems().verifyComputer();
    }

}
