package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list() {
        return auctionDao.getAuctions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return auctionDao.getAuctionById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        return auctionDao.createAuction(auction);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(name = "title_like", defaultValue = "") String titleLike) {
        if (!titleLike.isEmpty()) {
            return auctionDao.getAuctionsByTitle(titleLike);
        } else {
            return auctionDao.getAuctions();
        }
    }

}
