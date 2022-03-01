package com.techelevator.auctions.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static final String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {
        final String url = API_BASE_URL;
        return this.restTemplate.getForObject(url, Auction[].class);
    }

    public Auction getAuction(int id) {
        final String url = API_BASE_URL + id;
        return this.restTemplate.getForObject(url, Auction.class);
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        final String url = API_BASE_URL + "?title_like=" + title;
        return this.restTemplate.getForObject(url, Auction[].class);
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        final String url = API_BASE_URL + "?currentBid_lte=" + price;
        return this.restTemplate.getForObject(url, Auction[].class);
    }

}
