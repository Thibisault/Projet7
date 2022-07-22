package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BidlistServiceTest extends TestCase {

    @Autowired
    private BidlistService bidlistService;

    @Autowired
    private BidListRepository bidListRepository;

    @Autowired
    private GeneratorHelpService generatorHelpService;

    @Test
    public void contextLoads() {
    }

    private void supprimerBidTestDansBDD(List<BidList> listBidList){
        while (listBidList.size() > 0){
            bidListRepository.delete(listBidList.get(0));
            listBidList.remove(0);
        }
    }

    @Test
    public void testCreerNewBidlist() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<Integer> listIdBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listIdBidList.add(bidLists.getBidListId());
        }
        for (Integer bidId : listIdBidList) {
            assertNotNull(bidlistService.chercherByBidListId(bidId));
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherTouteLesBidList() {
        int nombreDeGeneration = 2;
        int nombreTotalDeBidListAvantAjout = bidlistService.chercherTouteLesBidList().size();
        List<BidList> bidLists = generatorHelpService.generatorBidListTest(nombreDeGeneration);
        int nombreTotalDeBidListApresAjout = bidlistService.chercherTouteLesBidList().size();
        assertEquals(nombreTotalDeBidListAvantAjout + nombreDeGeneration, nombreTotalDeBidListApresAjout);
        this.supprimerBidTestDansBDD(bidLists);
    }

    @Test
    public void supprimerBidList() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<Integer> listIdBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listIdBidList.add(bidLists.getBidListId());
        }

        for (Integer bidId : listIdBidList) {
            assertNotNull(bidlistService.chercherByBidListId(bidId));
        }

        for (Integer bidId : listIdBidList) {
            BidList bidList1 = bidlistService.chercherByBidListId(bidId);
            bidlistService.supprimerBidList(bidList1);
            assertNull(bidlistService.chercherByBidListId(bidId));
        }
    }

    @Test
    public void chercherByBidListId() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<Integer> listIdBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listIdBidList.add(bidLists.getBidListId());
        }

        for (Integer bidId : listIdBidList) {
            assertEquals(bidlistService.chercherByBidListId(bidId).getBidListId(), bidId);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherByaccount() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listAccountBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listAccountBidList.add(bidLists.getAccount());
        }

        for (String bidAccount : listAccountBidList) {
            assertEquals(bidlistService.chercherByaccount(bidAccount).getAccount(), bidAccount);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBytype() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listTypeBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listTypeBidList.add(bidLists.getType());
        }

        for (String bidtype : listTypeBidList) {
            assertEquals(bidlistService.chercherByType(bidtype).getType(), bidtype);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBybidQuantity() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<Double> listBidQuantityBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listBidQuantityBidList.add(bidLists.getBidQuantity());
        }

        for (Double bidQuantity : listBidQuantityBidList) {
            assertEquals(bidlistService.chercherBybidQuantity(bidQuantity).getBidQuantity(), bidQuantity);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherByaskQuantity() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<Double> listAskQuantityBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listAskQuantityBidList.add(bidLists.getAskQuantity());
        }

        for (Double askQuantity : listAskQuantityBidList) {
            assertEquals(bidlistService.chercherByaskQuantity(askQuantity).getAskQuantity(), askQuantity);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBybid() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<Double> listBidBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listBidBidList.add(bidLists.getBid());
        }

        for (Double bid : listBidBidList) {
            assertEquals(bidlistService.chercherBybid(bid).getBid(), bid);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherByask() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<Double> listAskBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listAskBidList.add(bidLists.getAsk());
        }

        for (Double ask : listAskBidList) {
            assertEquals(bidlistService.chercherByask(ask).getAsk(), ask);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBybenchmark() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listBenchmarkBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listBenchmarkBidList.add(bidLists.getBenchmark());
        }

        for (String benchmark : listBenchmarkBidList) {
            assertEquals(bidlistService.chercherBybenchmark(benchmark).getBenchmark(), benchmark);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBycommentary() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listCommentaryBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listCommentaryBidList.add(bidLists.getCommentary());
        }

        for (String commentary : listCommentaryBidList) {
            assertEquals(bidlistService.chercherBycommentary(commentary).getCommentary(), commentary);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBysecurity() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listSecurityBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listSecurityBidList.add(bidLists.getSecurity());
        }

        for (String security : listSecurityBidList) {
            assertEquals(bidlistService.chercherBysecurity(security).getSecurity(), security);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBystatus() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listStatusBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listStatusBidList.add(bidLists.getStatus());
        }

        for (String status : listStatusBidList) {
            assertEquals(bidlistService.chercherBystatus(status).getStatus(), status);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBytrader() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listTraderBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listTraderBidList.add(bidLists.getTrader());
        }

        for (String trader : listTraderBidList) {
            assertEquals(bidlistService.chercherBytrader(trader).getTrader(), trader);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBybook() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listBookBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listBookBidList.add(bidLists.getBook());
        }

        for (String book : listBookBidList) {
            assertEquals(bidlistService.chercherBybook(book).getBook(), book);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBycreationName() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listCreationNameBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listCreationNameBidList.add(bidLists.getCreationName());
        }

        for (String creationName : listCreationNameBidList) {
            assertEquals(bidlistService.chercherBycreationName(creationName).getCreationName(), creationName);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherByrevisionName() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listRevisionNameBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listRevisionNameBidList.add(bidLists.getRevisionName());
        }

        for (String revisionName : listRevisionNameBidList) {
            assertEquals(bidlistService.chercherByrevisionName(revisionName).getRevisionName(), revisionName);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBydealName() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listDealNameBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listDealNameBidList.add(bidLists.getDealName());
        }

        for (String dealName : listDealNameBidList) {
            assertEquals(bidlistService.chercherBydealName(dealName).getDealName(), dealName);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBydealType() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listDealTypeBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listDealTypeBidList.add(bidLists.getDealType());
        }

        for (String dealType : listDealTypeBidList) {
            assertEquals(bidlistService.chercherBydealType(dealType).getDealType(), dealType);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherBysourceListId() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listSourceListIdBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listSourceListIdBidList.add(bidLists.getSourceListId());
        }

        for (String sourceListId : listSourceListIdBidList) {
            assertEquals(bidlistService.chercherBysourceListId(sourceListId).getSourceListId(), sourceListId);
        }
        this.supprimerBidTestDansBDD(bidList);
    }

    @Test
    public void chercherByside() {
        List<BidList> bidList = generatorHelpService.generatorBidListTest(2);
        List<String> listSideBidList = new ArrayList<>();

        for (BidList bidLists : bidList){
            listSideBidList.add(bidLists.getSide());
        }

        for (String side : listSideBidList) {
            assertEquals(bidlistService.chercherByside(side).getSide(), side);
        }
        this.supprimerBidTestDansBDD(bidList);
    }
}