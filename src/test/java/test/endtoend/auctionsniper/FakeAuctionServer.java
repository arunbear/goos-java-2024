package test.endtoend.auctionsniper;

import org.assertj.core.api.Fail;

public class FakeAuctionServer {
    public FakeAuctionServer(String itemId) {

    }

    public String getItemId() {
        return "";
    }

    public void startSellingItem() {

    }

    public void hasReceivedJoinRequestFromSniper() {
        Fail.fail("To do");
    }

    public void announceClosed() {

    }

    public void stop() {

    }
}
