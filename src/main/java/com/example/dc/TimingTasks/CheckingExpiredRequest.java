package com.example.dc.TimingTasks;

import com.example.dc.service.SendEmail;
import com.example.dc.model.DonationRequest;
import com.example.dc.repository.ItemRepository;
import com.example.dc.repository.RequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckingExpiredRequest {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    SendEmail sendEmail;

    static final int TIMEOUT = 14 * 24 * 60 * 60 * 1000; // two weeks

    private static final Logger log = LoggerFactory.getLogger(CheckingExpiredRequest.class);

    //periodically check
//    @Scheduled(fixedRate = 24 * 60 * 1000) // check once a day
//    public void checkExpiredRequest() {
//        log.info("Checking expired requests...");
//
//        int cnt = 0;
//        Iterable<DonationRequest> requests = requestRepository.findAll();
//        for (DonationRequest request : requests) {
//            if (request.getStatus() == "pending"
//                    && new Date().getTime() - request.getDate().getTime() > TIMEOUT) { // expired
//                itemRepository.deleteByDonationRequest(request);
//                requestRepository.delete(request);
//
//                log.info("Request " + request.getId() + " to " + request.getNgo().getName() + " is expired.");
//                cnt++;
//                // notify resident here
//            }
//        }
//        log.info("Found and removed " + cnt + " expired requests.");
//    }

     //for demo
    @Scheduled(initialDelay = 10 * 1000, fixedRate = 10 * 1000)
    public void checkExpiredRequest() throws Exception {
        log.info("Checking expired requests...");

        Iterable<DonationRequest> requests = requestRepository.findAll();
        for (DonationRequest request : requests) {
            if (request.getNgo().getId() == 135) {
                log.info("Request " + request.getId() + " to " + request.getNgo().getName() + " is expired and removed.");
                itemRepository.deleteByDonationRequest(request);
                requestRepository.delete(request);
                // notify resident here
                sendEmail.main(request.getEmail(), " cancelled");
            }
        }
    }
}
