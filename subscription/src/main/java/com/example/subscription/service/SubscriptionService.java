package com.example.subscription.service;
import com.example.subscription.model.Subscription;
import com.example.subscription.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription buySubscription(Long userId, Subscription.SubscriptionType type) {
        Subscription subscription = new Subscription();
        subscription.setUserId(userId);
        subscription.setSubscriptionType(type);
        subscription.setStartDate(LocalDate.now());

        if (type == Subscription.SubscriptionType.MONTHLY) {
            subscription.setEndDate(LocalDate.now().plusMonths(1));
        } else {
            subscription.setEndDate(LocalDate.now().plusYears(1));
        }

        return subscriptionRepository.save(subscription);
    }

    public Subscription getLatestSubscription(Long userId) {
        return subscriptionRepository.findTopByUserIdOrderByEndDateDesc(userId)
                .orElseThrow(() -> new RuntimeException("No subscription found for user ID: " + userId));
    }
}
