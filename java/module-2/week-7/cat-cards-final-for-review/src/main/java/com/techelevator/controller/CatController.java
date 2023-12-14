package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.model.CatCard;
import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard getIndividualCard(@PathVariable int id) {
        try {
            CatCard catCard = catCardDao.getCatCardById(id);
            if (catCard == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CatCard not found");
            }
            return catCard;
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO Error - " + e.getMessage());
        }
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CatCard> getAllCards() {
        try {
            return catCardDao.getCatCards();
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO Error - " + e.getMessage());
        }
    }

    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard makeNewCard() {
        CatFact f = catFactService.getFact();
        CatPic p = catPicService.getPic();
        CatCard c = new CatCard();
        c.setCatFact(f.getText());
        c.setImgUrl(p.getFile());
        return c;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public CatCard saveNewCard(@Valid @RequestBody CatCard incomingCard) {
        try {
            return catCardDao.createCatCard(incomingCard);
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO Error - " + e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public CatCard updateExistingCard(@Valid @RequestBody CatCard changedCard, @PathVariable int id) {
        // The id on the URL takes precedence over the one in the payload, if any
        changedCard.setCatCardId(id);

        try {
            return catCardDao.updateCatCard(changedCard);
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO Error - " + e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteExistingCard(@PathVariable int id) {
        try {
            int cardsDeleted = catCardDao.deleteCatCardById(id);
            if (cardsDeleted == 0) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO Error - " + e.getMessage());
        }
    }
}
