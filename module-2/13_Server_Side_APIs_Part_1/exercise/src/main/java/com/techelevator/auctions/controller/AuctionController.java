package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(required = false) String title_like,
                              @RequestParam(required = false) Double currentBid_lte) {
        List<Auction> auctions = new ArrayList<>();

        boolean haveTitleCriteria = title_like != null;
        boolean haveBidCriteria = currentBid_lte != null;

        if (!haveTitleCriteria && !haveBidCriteria) {
            auctions = this.dao.list();
        }
        else if (haveTitleCriteria && haveBidCriteria) {
            auctions = this.dao.searchByTitleAndPrice(title_like, currentBid_lte);
        }
        else if (haveTitleCriteria && !haveBidCriteria) {
            auctions = this.dao.searchByTitle(title_like);
        }
        else if (!haveTitleCriteria && haveBidCriteria) {
            auctions = this.dao.searchByPrice(currentBid_lte);
        }
        return auctions;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return this.dao.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction newAuction) {
        return this.dao.create(newAuction);
    }


}
