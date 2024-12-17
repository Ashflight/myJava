package mandy.app;

public class Cruise {
    private int signups;
    private int price;

    public Cruise(int signups, int price) {
        this.signups = signups;
        this.price = price;
    }

    public void setPrice(int newPrice) {
        price = newPrice;
    }

    public void checkResponse(String request) {
        for (int i = 0; i < request.length()-5; i++) {
            if (request.substring(i,i+6).equals("cruise")) {
                signups += 1;
                return;  // increments once per request
            }
        }
        // My original answer had an unnecessary "return" at the end which has been removed here
    }

    public int calculateRevenue() {
        if (signups < 200) {
            return price * signups;
        }
        if (signups <= 300) {
            return (price - 350) * signups;
        }
        return (price - 500) * signups;
    }
}
