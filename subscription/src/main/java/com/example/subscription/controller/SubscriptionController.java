package com.example.subscription.controller;


import com.example.subscription.model.Subscription;
import com.example.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/buy")
    public ResponseEntity<Subscription> buySubscription(@RequestBody SubscriptionRequest request) {
        Subscription subscription = subscriptionService.buySubscription(request.getUserId(), request.getType());
        return ResponseEntity.ok(subscription);
    }

    @GetMapping("/latest")
    public ResponseEntity<Subscription> getLatestSubscription(@RequestParam("userId") Long userId) {
        Subscription subscription = subscriptionService.getLatestSubscription(userId);
        return ResponseEntity.ok(subscription);
    }

    static class SubscriptionRequest {
        private Long userId;
        private Subscription.SubscriptionType type;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Subscription.SubscriptionType getType() {
            return type;
        }

        public void setType(Subscription.SubscriptionType type) {
            this.type = type;
        }
    }
}