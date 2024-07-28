package test.endtoend.auctionsniper;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuctionSniperEndToEndTest {
    private final FakeAuctionServer auction = new FakeAuctionServer("item-54321");
    private final ApplicationRunner application = new ApplicationRunner();

    @Test
    public void sniperJoinsAuctionUntilAuctionCloses() throws Exception {
        auction.startSellingItem();                 // Step 1
        application.startBiddingIn(auction);        // Step 2
        auction.hasReceivedJoinRequestFromSniper(); // Step 3
        auction.announceClosed();                   // Step 4
        application.showsSniperHasLostAuction();    // Step 5
    }

    // Additional cleanup
    @AfterAll
    public void stopAuction() {
        auction.stop();
    }

    @AfterAll
    public void stopApplication() {
        application.stop();
    }
}
