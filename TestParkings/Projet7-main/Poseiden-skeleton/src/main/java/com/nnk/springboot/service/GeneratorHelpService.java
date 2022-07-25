package com.nnk.springboot.service;

import com.nnk.springboot.domain.*;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Service
public class GeneratorHelpService {

    @Autowired
    private BidListRepository bidListRepository;

    @Autowired
    private CurvePointRepository curvePointRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RuleNameRepository ruleNameRepository;

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private UserRepository userRepository;


    //cette classe permet de faciliter les tests en générant des BidList, CurvePoint,Rating, RuleName, Trade et user aléatoirement qui seront unique dans la base de données.

    public List<BidList> generatorBidListTest(int nombreDeGeneration){
        List<BidList> listBidList = new ArrayList<>();
        for (int i = 0; i <nombreDeGeneration; i++) {
            BidList bidList = new BidList();

            while(bidList.getAccount() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByAccount("testAccount " + i + chiffreAleatoire).isPresent()) {
                    bidList.setAccount("testAccount " + i + chiffreAleatoire);
                }
            }
            while(bidList.getType() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByType("testType " + i + chiffreAleatoire).isPresent()) {
                    bidList.setType("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getBidQuantity() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByBidQuantity((double) (i + chiffreAleatoire)).isPresent()) {
                    bidList.setBidQuantity((double) (i + chiffreAleatoire));
                }
            }
            while(bidList.getAskQuantity() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByAskQuantity((double) (i + chiffreAleatoire)).isPresent()) {
                    bidList.setAskQuantity((double) (i + chiffreAleatoire));
                }
            }
            while(bidList.getBid() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByBid((double) (i + chiffreAleatoire)).isPresent()) {
                    bidList.setBid((double) (i + chiffreAleatoire));
                }
            }
            while(bidList.getAsk() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByAsk((double) (i + chiffreAleatoire)).isPresent()) {
                    bidList.setAsk((double) (i + chiffreAleatoire));
                }
            }
            while(bidList.getBenchmark() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByBenchmark("testBenchmark " + i + chiffreAleatoire).isPresent()) {
                    bidList.setBenchmark("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getCommentary() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByCommentary("testCommentary " + i + chiffreAleatoire).isPresent()) {
                    bidList.setCommentary("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getSecurity() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findBySecurity("testSecurity " + i + chiffreAleatoire).isPresent()) {
                    bidList.setSecurity("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getStatus() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByStatus("testStatus " + i + chiffreAleatoire).isPresent()) {
                    bidList.setStatus("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getTrader() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByTrader("testTrader " + i + chiffreAleatoire).isPresent()) {
                    bidList.setTrader("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getBook() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByBook("testBook " + i + chiffreAleatoire).isPresent()) {
                    bidList.setBook("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getCreationName() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByCreationName("testCreationName " + i + chiffreAleatoire).isPresent()) {
                    bidList.setCreationName("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getRevisionName() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByRevisionName("testRevisionName " + i + chiffreAleatoire).isPresent()) {
                    bidList.setRevisionName("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getDealName() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByDealName("testDealName " + i + chiffreAleatoire).isPresent()) {
                    bidList.setDealName("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getDealType() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findByDealType("testDealType " + i + chiffreAleatoire).isPresent()) {
                    bidList.setDealType("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getSourceListId() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findBySourceListId("testSourceListId " + i + chiffreAleatoire).isPresent()) {
                    bidList.setSourceListId("testType " + i + chiffreAleatoire);
                }
            }
            while(bidList.getSide() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!bidListRepository.findBySide("testSide " + i + chiffreAleatoire).isPresent()) {
                    bidList.setSide("testType " + i + chiffreAleatoire);
                }
            }
            bidListRepository.save(bidList);
            listBidList.add(bidList);
        }
        return listBidList;
    }

    public List<CurvePoint> generatorCurvePointTest(int nombreDeGeneration) {
        List<CurvePoint> curvePointList = new ArrayList<>();
        for (int i = 0; i < nombreDeGeneration; i++) {
            CurvePoint curvePoint = new CurvePoint();

            while (curvePoint.getCurveId() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!curvePointRepository.findByCurveId(i + chiffreAleatoire).isPresent()) {
                    curvePoint.setCurveId(i + chiffreAleatoire);
                }
            }
            while (curvePoint.getTerm() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!curvePointRepository.findByTerm((double) (i + chiffreAleatoire)).isPresent()) {
                    curvePoint.setTerm((double) (i + chiffreAleatoire));
                }
            }
            while (curvePoint.getValue() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!curvePointRepository.findByValue((double) (i + chiffreAleatoire)).isPresent()) {
                    curvePoint.setValue((double) (i + chiffreAleatoire));
                }
            }
            curvePointRepository.save(curvePoint);
            curvePointList.add(curvePoint);
        }
        return  curvePointList;
    }

    public List<Rating> generatorRatingTest(int nombreDeGeneration) {
        List<Rating> ratingList = new ArrayList<>();
        for (int i = 0; i < nombreDeGeneration; i++) {
            Rating rating = new Rating();

            while (rating.getMoodysRating() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!ratingRepository.findByMoodysRating("testMoodysRating " + i + chiffreAleatoire).isPresent()) {
                    rating.setMoodysRating("testMoodysRating " + i + chiffreAleatoire);
                }
            }
            while (rating.getSandPRating() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!ratingRepository.findBySandPRating("testSandPRating " + i + chiffreAleatoire).isPresent()) {
                    rating.setSandPRating("testSandPRating " + i + chiffreAleatoire);
                }
            }
            while (rating.getFitchRating() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!ratingRepository.findByFitchRating("testFitchRating " + i + chiffreAleatoire).isPresent()) {
                    rating.setFitchRating("testFitchRating " + i + chiffreAleatoire);
                }
            }
            while (rating.getOrderNumber() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!ratingRepository.findByOrderNumber(i + chiffreAleatoire).isPresent()) {
                    rating.setOrderNumber(i + chiffreAleatoire);
                }
            }
            ratingRepository.save(rating);
            ratingList.add(rating);
        }
        return  ratingList;
    }

    public List<RuleName> generatorRuleNameTest(int nombreDeGeneration) {
        List<RuleName> ruleNameList = new ArrayList<>();
        for (int i = 0; i < nombreDeGeneration; i++) {
            RuleName ruleName = new RuleName();

            while (ruleName.getName() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!ruleNameRepository.findByName("testName " + i + chiffreAleatoire).isPresent()) {
                    ruleName.setName("testName " + i + chiffreAleatoire);
                }
            }
            while (ruleName.getDescription() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!ruleNameRepository.findByDescription("testDescription " + i + chiffreAleatoire).isPresent()) {
                    ruleName.setDescription("testDescription " + i + chiffreAleatoire);
                }
            }
            while (ruleName.getJson() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!ruleNameRepository.findByJson("testjson " + i + chiffreAleatoire).isPresent()) {
                    ruleName.setJson("testjson " + i + chiffreAleatoire);
                }
            }
            while (ruleName.getTemplate() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!ruleNameRepository.findByTemplate("testTemplate " + i + chiffreAleatoire).isPresent()) {
                    ruleName.setTemplate("testTemplate " + i + chiffreAleatoire);
                }
            }
            while (ruleName.getSqlStr() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!ruleNameRepository.findBySqlStr("testSqlStr " + i + chiffreAleatoire).isPresent()) {
                    ruleName.setSqlStr("testSqlStr " + i + chiffreAleatoire);
                }
            }
            while (ruleName.getSqlPart() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!ruleNameRepository.findBySqlPart("testSqlPart " + i + chiffreAleatoire).isPresent()) {
                    ruleName.setSqlPart("testSqlPart " + i + chiffreAleatoire);
                }
            }
            ruleNameRepository.save(ruleName);
            ruleNameList.add(ruleName);
        }
        return ruleNameList;
    }

    public List<Trade> generatorTradeTest(int nombreDeGeneration) {
        List<Trade> tradeList = new ArrayList<>();
        for (int i = 0; i < nombreDeGeneration; i++) {
            Trade trade = new Trade();

            while (trade.getAccount() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!tradeRepository.findByAccount("testAccount " + i + chiffreAleatoire).isPresent()) {
                    trade.setAccount("testAccount " + i + chiffreAleatoire);
                }
            }
            while (trade.getType() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!tradeRepository.findByType("testType " + i + chiffreAleatoire).isPresent()) {
                    trade.setType("testType " + i + chiffreAleatoire);
                }
            }
            while (trade.getBuyQuantity() == null) {
                Random random = new Random((System.currentTimeMillis()));
                int chiffreAleatoire = random.nextInt(1000000);
                if (!tradeRepository.findByBuyQuantity((double) (i + chiffreAleatoire)).isPresent()) {
                    trade.setBuyQuantity((double) (i + chiffreAleatoire));
                }
            }
            tradeRepository.save(trade);
            tradeList.add(trade);
        }
        return tradeList;
    }
}
