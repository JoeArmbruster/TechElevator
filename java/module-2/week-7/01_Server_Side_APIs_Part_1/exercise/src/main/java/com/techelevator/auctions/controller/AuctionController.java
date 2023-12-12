package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;

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

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Auction> list(@RequestParam(name = "title_like", defaultValue = "") String titleLike) {
//        if (!titleLike.isEmpty()) {
//            return auctionDao.getAuctionsByTitle(titleLike);
//        } else {
//            return auctionDao.getAuctions();
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Auction> list(@RequestParam(name = "currentBid_lte", defaultValue = "0") double currentBidlte){
//        if (currentBidlte > 0){
//            return auctionDao.getAuctionsByMaxBid(currentBidlte);
//        } else {
//            return auctionDao.getAuctions();
//        }
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Auction> list(@RequestParam(name = "title_like", defaultValue = "") String titleLike,
//                              @RequestParam(name = "currentBid_lte", defaultValue = "0") double currentBidLte){
//        if (!titleLike.isEmpty() && currentBidLte > 0){
//            return auctionDao.getAuctionsByTitleAndMaxBid(titleLike, currentBidLte);
//        } else if (!titleLike.isEmpty()) {
//            return auctionDao.getAuctionsByTitle(titleLike);
//        } else if (currentBidLte > 0) {
//            return auctionDao.getAuctionsByMaxBid(currentBidLte);
//        } else {
//            return auctionDao.getAuctions();
//        }
//    }

//    @RequestMapping(path = "", method = RequestMethod.GET)
//    public List<Auction> list(@RequestParam(defaultValue = "") String title_like, @RequestParam(defaultValue = "0") double currentBid_lte) {
//
//        if (!title_like.equals("")) {
//            return auctionDao.getAuctionsByTitle(title_like);
//        }
//        if (currentBid_lte > 0) {
//            return auctionDao.getAuctionsByMaxBid(currentBid_lte);
//        }
//
//        return auctionDao.getAuctions();
//    }


}
